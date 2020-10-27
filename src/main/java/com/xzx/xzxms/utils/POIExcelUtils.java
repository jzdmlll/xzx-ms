package com.xzx.xzxms.utils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            for (int j = 1; j < totalColNum; j ++) {
                cell = row.getCell(j);
                if (cell != null){
                    cell.setCellType(CellType.STRING);
                    Cell colCell = rowHead.getCell(j);
                    colCell.setCellType(CellType.STRING);
                    map.put(colCell.getStringCellValue(), cell.getStringCellValue());
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
        List<HSSFShape> list = sheet.getDrawingPatriarch().getChildren();
        for (HSSFShape shape : list) {
            if (shape instanceof HSSFPicture) {
                HSSFPicture picture = (HSSFPicture) shape;
                HSSFClientAnchor cAnchor = (HSSFClientAnchor) picture.getAnchor();
                PictureData pdata = picture.getPictureData();
                int key = cAnchor.getRow1(); // 行号
                map.put(key, pdata);
                String name = picture.getPictureData().getMimeType();
                name = name.substring(name.lastIndexOf("/")+1, name.length());
                map.put(-1, name);

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
                    name = name.substring(name.lastIndexOf("/")+1, name.length());
                    map.put(-1, name);
                }
            }
        }
        return map;
    }
    // 测试
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\10376\\Desktop\\询价模板.xls");
        FileInputStream fis = new FileInputStream(file);
        List<Map<String, Object>> dataFromExcel = getDataFromExcel(fis);
        for (Map<String, Object> map:dataFromExcel) {
            for (String key : map.keySet()) {
                System.out.println(key+":"+map.get(key));
            }
            System.out.println("---------------------------");
        }

    }
}
