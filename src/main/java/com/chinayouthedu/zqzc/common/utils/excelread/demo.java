package com.chinayouthedu.zqzc.common.utils.excelread;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class demo {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		// 1.需要解析的Excel文件
		File excelFile = new File("D:\\excel\\商品列表.xls");
		
		// 2.自定义的用于解析JSON串到对象的解析器
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		
		// 3.创建列和字段的对应条件
		Map<Integer,String> pc = new HashMap<Integer,String>();
		pc.put(0,"id" );
		pc.put(1,"name" );
		pc.put(2,"price" );
		pc.put(3,"sale" );
		pc.put(4,"upDate" );
		
		// 4.创建字符串转成对象中的布尔值的条件
		BooleanParse booleanParse = new BooleanParse("sale","是");
		
		// 5.将每一行转成JSON串,之后可以直接使用JSON串或者将其转为对象使用
		List<JSONObject> jsons = ExcelReadUtils.readExcelFile(excelFile, pc, booleanParse);
		
		// 6.将JSON串转成对象
		jsons.forEach(js->{
			Good good = gson.fromJson(js.toString(), Good.class); 
			System.out.println("good="+good);
		});
		
	}
}