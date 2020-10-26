package com.xzx.xzxms.utils;
import com.xzx.xzxms.service.IFileUploadService;
import com.xzx.xzxms.service.impl.FileUploadServiceImpl;
import org.apache.http.entity.ContentType;
import org.apache.log4j.Logger;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import org.junit.Test;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

class ExcelUtil {

    private static final Logger logger = Logger.getLogger(ExcelUtil.class);
    public static final String OFFICE_EXCEL_2003_POSTFIX = "xls";
    public static final String OFFICE_EXCEL_2010_POSTFIX = "xlsx";
    public static final String EMPTY = "";
    public static final String POINT = ".";
    public static SimpleDateFormat sdf =   new SimpleDateFormat("yyyy/MM/dd");

    /**
     * 获得path的后缀名
     * @param path
     * @return
     */
    public static String getPostfix(String path){

        if(path == null || EMPTY.equals(path.trim())){
            return EMPTY;
        }
        if(path.contains(POINT)){
            return path.substring(path.lastIndexOf(POINT)+1,path.length());
        }
        return EMPTY;
    }

    /**
     * 单元格格式
     * @param hssfCell
     * @return
     */
    @SuppressWarnings({ "static-access", "deprecation" })
    public static String getHValue(HSSFCell hssfCell){

        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            String cellValue = "";
            if(HSSFDateUtil.isCellDateFormatted(hssfCell)){
                Date date = HSSFDateUtil.getJavaDate(hssfCell.getNumericCellValue());
                cellValue = sdf.format(date);
            }else{
                DecimalFormat df = new DecimalFormat("#.##");
                cellValue = df.format(hssfCell.getNumericCellValue());
                String strArr = cellValue.substring(cellValue.lastIndexOf(POINT)+1,cellValue.length());
                if(strArr.equals("00")){
                    cellValue = cellValue.substring(0, cellValue.lastIndexOf(POINT));
                }
            }
            return cellValue;
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BLANK){
            return String.valueOf(hssfCell.getStringCellValue());

        }else {
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }

    /**
     * 单元格格式
     * @param xssfCell
     * @return
     */
    public static String getXValue(XSSFCell xssfCell){

        if (xssfCell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xssfCell.getBooleanCellValue());
        } else if (xssfCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            String cellValue = "";
            if(XSSFDateUtil.isCellDateFormatted(xssfCell)){
                Date date = XSSFDateUtil.getJavaDate(xssfCell.getNumericCellValue());
                cellValue = sdf.format(date);
            }else{
                DecimalFormat df = new DecimalFormat("#.##");
                cellValue = df.format(xssfCell.getNumericCellValue());
                String strArr = cellValue.substring(cellValue.lastIndexOf(POINT)+1,cellValue.length());
                if(strArr.equals("00")){
                    cellValue = cellValue.substring(0, cellValue.lastIndexOf(POINT));
                }
            }
            return cellValue;
        } else {
            return String.valueOf(xssfCell.getStringCellValue());
        }
    }
    /**
     * 自定义xssf日期工具类
     *
     */
    static class XSSFDateUtil extends DateUtil {
        protected static int absoluteDay(Calendar cal, boolean use1904windowing) {
            return DateUtil.absoluteDay(cal, use1904windowing);
        }
    }


    /**
     * 获取图片和位置 (xls)
     * @param sheet
     * @return
     * @throws IOException
     */
    public static Map<Integer, InputStream> getPicturesXls (HSSFSheet sheet) throws IOException {

        Map<Integer, InputStream> map = new HashMap<Integer, InputStream>();
        try{
            List<HSSFShape> list = sheet.getDrawingPatriarch().getChildren();
            for (HSSFShape shape : list) {
                if (shape instanceof HSSFPicture) {
                    HSSFPicture picture = (HSSFPicture) shape;
                    HSSFClientAnchor cAnchor = (HSSFClientAnchor) picture.getAnchor();
                    PictureData pdata = picture.getPictureData();
                    //String key = cAnchor.getRow1() + "-" + cAnchor.getCol1(); // 行号-列号
                    Integer key=cAnchor.getRow1();
                    if (pdata.getData()!=null){
                        System.out.println(pdata.getData().length+"****");
                        map.put(key, new ByteArrayInputStream(pdata.getData()));
                    }
                }
            }
        }catch (Exception ex){

        }
        return map;
    }

    /**
     * 获取图片和位置 (xlsx)
     * @param sheet
     * @return
     * @throws IOException
     */
    public static  Map<String, PictureData> getPicturesXlsx (XSSFSheet sheet) throws IOException {
        Map<String, PictureData> map = new HashMap<String, PictureData>();
        List<POIXMLDocumentPart> list = sheet.getRelations();
        for (POIXMLDocumentPart part : list) {
            if (part instanceof XSSFDrawing) {
                XSSFDrawing drawing = (XSSFDrawing) part;
                List<XSSFShape> shapes = drawing.getShapes();
                for (XSSFShape shape : shapes) {
                    XSSFPicture picture = (XSSFPicture) shape;
                    XSSFClientAnchor anchor = picture.getPreferredSize();
                    CTMarker marker = anchor.getFrom();
                    String key = marker.getRow() + "-" + marker.getCol();
                    map.put(key, picture.getPictureData());
                }
            }
        }
        return map;
    }


    //图片写出
//    public MultipartFile printImg(Map<String, PictureData> sheetList) throws IOException {
//
//        //for (Map<String, PictureData> map : sheetList) {
//        Object key[] = sheetList.keySet().toArray();
//        for (int i = 0; i < sheetList.size(); i++) {
//            // 获取图片流
//            PictureData pic = sheetList.get(key[i]);
//            // 获取图片索引
//            String picName = key[i].toString();
//            // 获取图片格式
//            String ext = pic.suggestFileExtension();
//
//            byte[] data = pic.getData();
//
//            //MultipartFile multipartFile=new MockMultipartFile()
//
//        }
//
//        return
//        // }
//    }

}


public class ReadExcelUtil{

    public int totalRows; //sheet中总行数
    public static int totalCells; //每一行总单元格数
    /**
     * read the Excel .xlsx,.xls
     * @param file jsp中的上传文件
     * @return
     * @throws IOException
     */
    public List<LinkedList<Map<String,Object>>> readExcel(MultipartFile file) throws IOException {
        if(file==null||ExcelUtil.EMPTY.equals(file.getOriginalFilename().trim())){
            return null;
        }else{
            String postfix = ExcelUtil.getPostfix(file.getOriginalFilename());
            if(!ExcelUtil.EMPTY.equals(postfix)){
                if(ExcelUtil.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)){
                    return readXls(file);
                }else if(ExcelUtil.OFFICE_EXCEL_2010_POSTFIX.equals(postfix)){
                    //return readXlsx(file);
                }else{
                    return null;
                }
            }
        }
        return null;
    }

    /**
     * read the Excel 2010 .xlsx
     * @param file
     * @return
     * @throws IOException
     */
    @SuppressWarnings("deprecation")
    public List<ArrayList<String>> readXlsx(MultipartFile file){
        List<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        // IO流读取文件
        InputStream input = null;
        XSSFWorkbook wb = null;
        ArrayList<String> rowList = null;
        try {
            input = file.getInputStream();
            // 创建文档
            wb = new XSSFWorkbook(input);
            //读取sheet(页)
            for(int numSheet=0;numSheet<wb.getNumberOfSheets();numSheet++){
                XSSFSheet xssfSheet = wb.getSheetAt(numSheet);
                if(xssfSheet == null){
                    continue;
                }
                totalRows = xssfSheet.getLastRowNum();
                //读取Row,从第4行开始
                for(int rowNum = 1;rowNum <= totalRows;rowNum++){
                    XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                    if(xssfRow!=null){
                        rowList = new ArrayList<String>();
                        totalCells = xssfRow.getLastCellNum();
                        //读取列，从第一列开始
                        for(int c=0;c<=totalCells+1;c++){
                            XSSFCell cell = xssfRow.getCell(c);
                            if(cell==null){
                                rowList.add(ExcelUtil.EMPTY);
                                continue;
                            }
                            rowList.add(ExcelUtil.getXValue(cell).trim());
                        }
                        list.add(rowList);
                    }
                }
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;

    }


    /**
     * read the Excel 2003-2007 .xls
     * @param file
     * @return
     * @throws IOException
     */
    public List<LinkedList<Map<String,Object>>> readXls(MultipartFile file){
        List<LinkedList<Map<String,Object>>> list = new ArrayList<LinkedList<Map<String,Object>>>();
        // IO流读取文件
        InputStream input = null;
        HSSFWorkbook wb = null;
        LinkedList<Map<String,Object>> rowList = null;
        HSSFSheet hssfSheet = null;
        ArrayList<String> keys = new ArrayList<>();
        Map<String,Object> excel;

        try {
            input = file.getInputStream();
            // 创建文档
            wb = new HSSFWorkbook(input);


            //读取sheet(页)
            for(int numSheet = 0; numSheet < wb.getNumberOfSheets(); numSheet ++)
            {
                hssfSheet = wb.getSheetAt(numSheet);
                Map map = ExcelUtil.getPicturesXls(hssfSheet);
                //System.out.println(map);
                if(hssfSheet == null)
                {
                    continue;
                }

                //获得数据总行数
                totalRows = hssfSheet.getLastRowNum();

                if (totalRows>=1&&hssfSheet.getRow(0)!=null){
                    //列数
                    totalCells = hssfSheet.getRow(0).getPhysicalNumberOfCells();
                    //第一行的数据
                    //获取第一行的数据
                    Row row1 = hssfSheet.getRow(0);
                    for (int i = 0; i < totalCells; i++) {
                        Cell cell = row1.getCell(i);
                        String value = cell.getStringCellValue();
                        keys.add(value);
                    }
                    System.out.println(keys);
                }

                //读取Row,从第二行开始
                for(int rowNum = 1;rowNum <= totalRows;rowNum++)
                {
                    //根据行号取出map中的图片字节流
                    InputStream value= (InputStream) map.get(rowNum);

                    HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                    if(hssfRow!=null)
                    {
                        //表格第一列如果不是数字类型则代表接下来的行数不循环
                        if (hssfRow.getCell(0).getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            rowList = new LinkedList<Map<String,Object>>();

                            //读取列，从第一列开始
                            for(int c=0;c < totalCells;c++)
                            {
                                excel=new HashMap<String,Object>();
                                HSSFCell cell = hssfRow.getCell(c);
                                if(cell == null){
                                    excel.put(keys.get(c),ExcelUtil.EMPTY);
                                    rowList.add(excel);
                                    continue;
                                }
                                //13为图片列
                                if(c == 13){

                                        excel.put(keys.get(c),value);
                                        rowList.add(excel);
                                        continue;

                                }
                                excel.put(keys.get(c),ExcelUtil.getHValue(cell).trim());
                                rowList.add(excel);
                            }
                            list.add(rowList);
                        }else {
                            break;
                        }

                    }
                }
            }
            return list;

        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    @Test
    public void Test() throws IOException {

        String filePath="C:/Users/cheri/Desktop/询价模板(1)(1).xls";

        File file=new File(filePath);

//        ExcelHelper excelHelper=new ExcelHelper(file);
//        try {
//            List<String> list= excelHelper.getExcelHeaderContent();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }



        FileInputStream fileInputStream=new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile("copy"+file.getName(),file.getName(), ContentType.APPLICATION_OCTET_STREAM.toString(),fileInputStream);
        List<?> lists = readExcel(multipartFile);




        System.out.println(lists);

//        XSSFWorkbook xssfWorkbook=new XSSFWorkbook(new FileInputStream(filePath));
//        XSSFSheet sheet = xssfWorkbook.getSheet("Sheet1");
//        //获取到Excel文件中的所有行数
//
//        int rows = sheet.getPhysicalNumberOfRows();
//
//        //遍历行
//
//        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
//
//        for (int i = 1; i < rows; i++) {
//            // 读取左上端单元格
//
//            XSSFRow row = sheet.getRow(i);
//
//            // 行不为空
//
//            if (row != null) {
//                Map<String, Object> map = new HashMap<String, Object>();
//
//                //获取到Excel文件中的所有的列
//
//                int cells = row.getPhysicalNumberOfCells();
//                XSSFCell nameCell =row.getCell(1);
//
//
//            }
//        }

    }



    /*excel 新版本xlsx*/
    public static Map<String, XSSFPictureData> getPictures(XSSFSheet sheet) throws IOException {
        Map<String, XSSFPictureData> map = new HashMap<String, XSSFPictureData>();

        List<POIXMLDocumentPart> list = sheet.getRelations();
        for (POIXMLDocumentPart part : list) {
            if (part instanceof XSSFDrawing) {
                XSSFDrawing drawing = (XSSFDrawing) part;
                List<XSSFShape> shapes = drawing.getShapes();
                for (XSSFShape shape : shapes) {
                    XSSFPicture picture = (XSSFPicture) shape;
                    XSSFClientAnchor anchor = picture.getPreferredSize();
                    CTMarker marker = anchor.getFrom();
                    String key = marker.getRow() + "-" + marker.getCol();
                    map.put(key, picture.getPictureData());
                }
            }
        }
        return map;
    }

    // excel 旧版本xls
    public static Map<String, HSSFPictureData> getPictures(HSSFSheet sheet) throws IOException {
        Map<String, HSSFPictureData> map = new HashMap<String, HSSFPictureData>();
        List<HSSFShape> list = sheet.getDrawingPatriarch().getChildren();
        for (HSSFShape shape : list) {
            if (shape instanceof HSSFPicture) {
                HSSFPicture picture = (HSSFPicture) shape;
                HSSFClientAnchor cAnchor = (HSSFClientAnchor) picture.getAnchor();
                HSSFPictureData pdata = picture.getPictureData();
                String key = cAnchor.getRow1() + "-" + cAnchor.getCol1(); // 行号-列号
                map.put(key, pdata);
            }
        }
        return map;
    }
}

class ExcelHelper {

    private HSSFWorkbook workbook;
    private HSSFSheet sheet;

    public void setWorkbook(File file) throws FileNotFoundException,
            IOException {
        workbook = new HSSFWorkbook(new FileInputStream(file));
        // 获取Excel第一页的信息
    }

    public HSSFSheet getSheet() {
        return sheet;
    }

    public HSSFWorkbook getWorkbook() {
        return workbook;
    }

    public void setSheet(HSSFWorkbook workbook) {
        sheet = workbook.getSheetAt(0);
    }

    public ExcelHelper(File file) throws FileNotFoundException, IOException {
        this.setWorkbook(file);
        this.setSheet(workbook);
    }

    public List<String> getExcelHeaderContent() throws Exception {
        // 获取excel第一列的表头
        HSSFRow row = sheet.getRow(0);
        int columnNum = row.getLastCellNum();
        // 初始化字符串数组
        List<String> excelHeaderMap = new ArrayList<>();
        for (short i = 0; i < columnNum; i++) {
            HSSFCell cell = row.getCell(i);
            excelHeaderMap.add(cell.getRichStringCellValue().getString());
        }
        return excelHeaderMap;
    }


    /**
     * 判断是否为数字型
     * @param str
     * @return
     */
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }





}
