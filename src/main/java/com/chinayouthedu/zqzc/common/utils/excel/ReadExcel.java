package com.chinayouthedu.zqzc.common.utils.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 
  
  
/** 
 * 读取Excel文件  (.xls  .xlsx) 
 */  
public class ReadExcel {  
      
    /** 
     * read the Excel file 
     * @param path the path of the Excel file 
     * @return 
     * @throws IOException 
     */  
    public List<Map<String, Object>> readExcel(String path) throws IOException {  
        if (path == null || "".equals(path)) {  
            return null;  
        } else {  
            String postfix ="";  
            if (path.contains(".")) {  
                postfix= path.substring(path.lastIndexOf(".") + 1, path.length());  
            }  
            if (!"".equals(postfix)) {  
                if ("xls".equals(postfix)) {  
                    return readXls(path);  
                }else if ("xlsx".equals(postfix)) { 
                    return readXlsx(path); 
                } 
            } else {  
                System.out.println(path + ": Not the Excel file!");  
            }  
        }  
        return null;  
    }  
  
    /** 
     * Read the Excel 2010 
     * @param path the path of the excel file 
     * @return 
     * @throws IOException 
     */ 
    public List<Map<String, Object>> readXlsx(String path) throws IOException { 
        System.out.println("Processing..." + path); 
        InputStream is = new FileInputStream(path); 
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is); 
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>(); 
        // Read the Sheet 
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) { 
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet); 
            if (xssfSheet == null) { 
                continue; 
            } 
            // Read the Row 
            for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) { 
                XSSFRow xssfRow = xssfSheet.getRow(rowNum); 
                if (xssfRow != null) { 
                    Map<String, Object> map=new HashMap<String, Object>(); 
                    XSSFCell no = xssfRow.getCell(0); 
                    XSSFCell name = xssfRow.getCell(1); 
                    XSSFCell age = xssfRow.getCell(2); 
                    XSSFCell score = xssfRow.getCell(3); 
                    map.put("no", getValue(no)); 
                    map.put("name", getValue(name)); 
                    map.put("age", getValue(age)); 
                    map.put("score", Float.valueOf(getValue(score))); 
                    list.add(map); 
                } 
            } 
        } 
        return list; 
    }  
  
    /** 
     * Read the Excel 2003-2007 
     * @param path the path of the Excel 
     * @return 
     * @throws IOException 
     */  
    public List<Map<String, Object>> readXls(String path) throws IOException {  
        System.out.println("Processing..." + path);  
        InputStream is = new FileInputStream(path);  
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);  
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();  
        // Read the Sheet  
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {  
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);  
            if (hssfSheet == null) {  
                continue;  
            }  
            // Read the Row  
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {  
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);  
                if (hssfRow != null) {  
                    Map<String, Object> map=new HashMap<String, Object>();  
                    HSSFCell oneColumn = hssfRow.getCell(0);  
                    HSSFCell twoColumn = hssfRow.getCell(1);  
                    HSSFCell threeColumn = hssfRow.getCell(2);  
                    HSSFCell fourColumn = hssfRow.getCell(3);  
                    map.put("no", getValue(oneColumn));  
                    map.put("name", getValue(twoColumn));  
                    map.put("age", getValue(threeColumn));  
                    map.put("score", Float.valueOf(getValue(fourColumn)));  
                    list.add(map);  
                }
            }  
        }  
        return list;  
    }  
  
    @SuppressWarnings("static-access") 
    private String getValue(XSSFCell xssfRow) { 
        if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) { 
            return String.valueOf(xssfRow.getBooleanCellValue()); 
        } else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) { 
            return String.valueOf(xssfRow.getNumericCellValue()); 
        } else { 
            return String.valueOf(xssfRow.getStringCellValue()); 
        } 
    }  
  
    @SuppressWarnings("static-access")  
    private String getValue(HSSFCell hssfCell) {  
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {  
            return String.valueOf(hssfCell.getBooleanCellValue());  
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {  
            return String.valueOf(hssfCell.getNumericCellValue());  
        } else {  
            return String.valueOf(hssfCell.getStringCellValue());  
        }  
    }  
}  