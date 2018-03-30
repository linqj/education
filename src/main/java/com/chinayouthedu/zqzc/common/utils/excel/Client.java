package com.chinayouthedu.zqzc.common.utils.excel;
import java.io.IOException;
import java.util.List;
import java.util.Map;  
  
  
/** 
 * 读取示例demo入口 
 */  
public class Client {  
  
    public static void main(String[] args) throws IOException {  
     /*   String excel2003_2007 ="E:new.xls";//文件路径  
        // read the 2003-2007 excel  
        List<Map<String, Object>> list = new ReadExcel().readExcel(excel2003_2007);  
        if (list != null) {  
            for (Map<String, Object> map : list) {  
                System.out.println("No. : " + map.get("no") + ", name : " + map.get("name") + ", age : " + map.get("age") + ", score : " + map.get("score"));  
            }  
        }  
        System.out.println("================读取xls结束======================");*/  
        // read the 2010 excel  
        String excel2013 = "E:\\new.xlsx"; 
        List<Map<String, Object>> list1 = new ReadExcel().readExcel(excel2013); 
        if (list1 != null) { 
            for (Map<String, Object> map : list1) { 
                System.out.println("No. : " + map.get("no") + ", name : " + map.get("name") + ", age : " + map.get("age") + ", score : " + map.get("score")); 
            } 
        } 
        System.out.println("================读取xlsx结束======================");  
    }  
}  