package com.xzx.xzxms.commons.utils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;

import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

public class POIExcelUtils {

    public static List<Map<String, Object>> getDataFromExcel(InputStream inputStream) throws IOException
    {
        String fileType = "";
        Workbook wookbook = null;
        Sheet sheet = null;
        try
        {
            //2003版本的excel，用.xls结尾
            wookbook = new HSSFWorkbook(inputStream);//得到工作簿
            fileType = "xls";
        }
        catch (Exception ex)
        {
            //ex.printStackTrace();
            try
            {
                //2007版本的excel，用.xlsx结尾
                wookbook = new XSSFWorkbook(inputStream);//得到工作簿
                fileType = "xlsx";
            } catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        Map<Integer, Object> maplist = null;
        sheet = wookbook.getSheetAt(0);
        // 判断用07还是03的方法获取图片
        if ("xls".equals(fileType)) {
            maplist = getPictures1((HSSFSheet) sheet);
        } else if("xlsx".equals(fileType)){
            maplist = getPictures2((XSSFSheet) sheet);
        }
        //得到一个工作表
        //获得表头
        Row rowHead = sheet.getRow(0);
        //获得数据的总列数
        int totalColNum = rowHead.getLastCellNum();

        //获得数据的总行数
        int totalRowNum = sheet.getLastRowNum();
        String space = "";
        List<Map<String, Object>> result = new ArrayList<>();
        for(int i = 1 ; i < totalRowNum ; i++)
        {
            Row row = sheet.getRow(i);
            //空间位置(为空则停止解析)
            Cell cell = row.getCell(0);
            if (cell == null){
                break;
            }
            //序号不为数字则停止解析
            cell.setCellType(CellType.STRING);
            space = cell.getStringCellValue().trim();
            try {
                if (StringUtils.isBlank(space)){
                    break;
                }
                Integer.parseInt(cell.getStringCellValue().trim());
            }catch (Exception e) {
                break;
            }
            Map<String, Object> map = new HashMap<>();
            for (int j = 0; j < totalColNum; j ++) {
                cell = row.getCell(j);
                if (cell != null){

                    Cell colCell = rowHead.getCell(j);
                    colCell.setCellType(CellType.STRING);
                    String rowName = colCell.getStringCellValue();
                    String cellValueByCell = getCellValueByCell(cell);
                    map.put(rowName, cellValueByCell);
                }
            }
            if(maplist.get(i)!=null){
                PictureData pictureData = (PictureData)maplist.get(i);
                String imgType = maplist.get(-1).toString();
                byte[] data = pictureData.getData();
                InputStream is = new ByteArrayInputStream(data);
                map.put("图片", is);
                map.put("imgType", imgType);
                System.out.println(imgType);
            }
            result.add(map);
        }
        //使用完成关闭
        wookbook.close();
        if (inputStream != null){
            inputStream.close();
        }
        return result;
    }
    /**
     * 获取图片和位置 (xls)
     * @param sheet
     * @return
     * @throws IOException
     */
    public static Map<Integer, Object> getPictures1 (HSSFSheet sheet) throws IOException {
        Map<Integer, Object> map = new HashMap<>();
        if(sheet.getDrawingPatriarch()!=null){
            try {
                List<HSSFShape> list = sheet.getDrawingPatriarch().getChildren();
                for (HSSFShape shape : list) {
                    if (shape instanceof HSSFPicture) {
                        HSSFPicture picture = (HSSFPicture) shape;
                        HSSFClientAnchor cAnchor = (HSSFClientAnchor) picture.getAnchor();
                        PictureData pdata = picture.getPictureData();
                        int key = cAnchor.getRow1(); // 行号
                        map.put(key, pdata);
                        String name = picture.getPictureData().getMimeType();
                        name = name.substring(name.lastIndexOf("/") + 1, name.length());
                        map.put(-1, name);

                    }
                }
            }catch (Exception e){
                throw new CustomerException("excel中图片解析异常");
            }
        }
        return map;
    }
    /**
     * 获取图片和位置 (xlsx)
     * @param sheet
     * @return
     * @throws IOException
     */
    public static Map<Integer, Object> getPictures2 (XSSFSheet sheet) throws IOException {
        Map<Integer, Object> map = new HashMap<>();
        if(sheet.getRelations()!=null){
            try {
                List<POIXMLDocumentPart> list = sheet.getRelations();
                for (POIXMLDocumentPart part : list) {
                    if (part instanceof XSSFDrawing) {
                        XSSFDrawing drawing = (XSSFDrawing) part;
                        List<XSSFShape> shapes = drawing.getShapes();
                        for (XSSFShape shape : shapes) {
                            XSSFPicture picture = (XSSFPicture) shape;
                            XSSFClientAnchor anchor = picture.getPreferredSize();
                            CTMarker marker = anchor.getFrom();
                            int key = marker.getRow();
                            map.put(key, picture.getPictureData());
                            String name = picture.getPictureData().getMimeType();
                            name = name.substring(name.lastIndexOf("/") + 1, name.length());
                            map.put(-1, name);
                        }
                    }
                }
            }catch (Exception e){
                throw new CustomerException("excel中图片解析异常");
            }
        }
        return map;
    }
    //获取单元格各类型值，返回字符串类型
    public static String getCellValueByCell(Cell cell) {
        //判断是否为null或空串
        if (cell==null || cell.toString().trim().equals("")) {
            return "";
        }
        String cellValue = "";
        int cellType=cell.getCellType();
        switch (cellType) {
            case Cell.CELL_TYPE_NUMERIC: // 数字
                short format = cell.getCellStyle().getDataFormat();
                if (DateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat sdf = null;
                    //System.out.println("cell.getCellStyle().getDataFormat()="+cell.getCellStyle().getDataFormat());
                    if (format == 20 || format == 32) {
                        sdf = new SimpleDateFormat("HH:mm");
                    } else if (format == 14 || format == 31 || format == 57 || format == 58) {
                        // 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)
                        sdf = new SimpleDateFormat("yyyy-MM-dd");
                        double value = cell.getNumericCellValue();
                        Date date = DateUtil
                                .getJavaDate(value);
                        cellValue = date.getTime()+"";
                    }else {// 日期
                        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    }
                    try {
                        cellValue = cell.getDateCellValue().getTime()+"";// 日期
                    } catch (Exception e) {
                        try {
                            throw new Exception("exception on get date data !".concat(e.toString()));
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }finally{
                        sdf = null;
                    }
                }  else {
                    BigDecimal bd = new BigDecimal(cell.getNumericCellValue());
                    cellValue = bd.toPlainString();// 数值 这种用BigDecimal包装再获取plainString，可以防止获取到科学计数值
                }
                break;
            case Cell.CELL_TYPE_STRING: // 字符串
                cellValue = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_BOOLEAN: // Boolean
                cellValue = cell.getBooleanCellValue()+"";;
                break;
            case Cell.CELL_TYPE_FORMULA: // 公式
                try {
                    cellValue = String.valueOf(cell.getNumericCellValue());
                } catch (IllegalStateException e) {
                    if (e.getMessage().indexOf("from a STRING cell") != -1) {
                        cellValue = String.valueOf(cell.getStringCellValue());
                    } else if (e.getMessage().indexOf("from a ERROR formula cell") != -1) {
                        cellValue = String.valueOf(cell.getErrorCellValue());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case Cell.CELL_TYPE_BLANK: // 空值
                cellValue = "";
                break;
            case Cell.CELL_TYPE_ERROR: // 故障
                cellValue = "ERROR VALUE";
                break;
            default:
                cellValue = "UNKNOW VALUE";
                break;
        }
        return cellValue;
    }
    /*// 测试
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\10376\\Desktop\\PLC询价景轩11.5.xls");
        FileInputStream fis = new FileInputStream(file);
        List<Map<String, Object>> dataFromExcel = getDataFromExcel(fis);
        for (Map<String, Object> map:dataFromExcel) {
            for (String key : map.keySet()) {
                System.out.println(key+":"+map.get(key));
            }
            System.out.println("---------------------------");
        }

    }*/
}
