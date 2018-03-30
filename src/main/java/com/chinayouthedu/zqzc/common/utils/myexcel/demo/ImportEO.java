package com.chinayouthedu.zqzc.common.utils.myexcel.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.chinayouthedu.zqzc.common.utils.DateUtils;
import com.chinayouthedu.zqzc.common.utils.myexcel.JXLExcelUtil;
import com.chinayouthedu.zqzc.common.utils.myexcel.POIExcelUtil;

/**
 * 导入测试
 * @author 张超群
 * @time   2018年3月14日下午2:27:31
 */
public class ImportEO {
	
	public static void main(String[] args) {
		//true=poi false=jxl
//		List<TeacherEO> list = importExcel(true, "D:\\AAA\\test1522058096598.xls");
		List<TeacherEO> list = importExcel(true, "D:\\AAA\\2003.xls");
		for (TeacherEO teacherEO : list) {
			System.out.println(JSON.toJSON(teacherEO));
			System.out.println(DateUtils.toString(teacherEO.getH(), "yyyy-MM-dd HH:mm:ss"));
		}
		System.out.println("----执行完毕----------");
	}
	
	
	public static List<TeacherEO> importExcel(boolean type,String path){
		List<TeacherEO> list =  new ArrayList<TeacherEO>();
		if(type){//poi
			POIExcelUtil<TeacherEO> poiExcelUtil = new POIExcelUtil<TeacherEO>(TeacherEO.class);
			try {
				list = poiExcelUtil.importExcel(path,null);
				System.out.println(JSON.toJSON(poiExcelUtil.getError()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{//jxl
			FileInputStream input = null;
			try {
				input = new FileInputStream(path);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			JXLExcelUtil<TeacherEO> util = new JXLExcelUtil<TeacherEO>(TeacherEO.class);// 创建工具类.
			list = util.importExcel("",input);
		}
		return list;
	}

}
