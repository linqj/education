package com.chinayouthedu.zqzc.common.utils.myexcel.demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.chinayouthedu.zqzc.common.utils.myexcel.JXLExcelUtil;

/**
 * 导出测试
 * @author 张超群
 * @time   2018年3月14日下午2:27:26
 */
public class ExportEO {
	public static void main(String[] args) {
		// 初始化数据
		List<TeacherEO> list = new ArrayList<TeacherEO>();

		TeacherEO vo = new TeacherEO();
		vo.setA("张超群");
		vo.setB(true);
		vo.setC(25);
		vo.setD(15010222109L);
		vo.setE(new BigDecimal("11112.22222"));
		vo.setF(2.20);
		vo.setG(1.2F);
		vo.setH(new Date());
		list.add(vo);
		TeacherEO vo2 = new TeacherEO();
		vo2.setA("李四");
		vo2.setB(false);
		vo2.setC(25);
		vo2.setD(15010222109L);
		vo2.setE(new BigDecimal("11112.22222"));
		vo2.setF(2.20);
		vo2.setG(1.2F);
		vo2.setH(new Date());
		list.add(vo2);
		FileOutputStream out = null;
		try {
			out = new FileOutputStream("D:\\AAA\\test"+System.currentTimeMillis()+".xls");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		JXLExcelUtil<TeacherEO> util = new JXLExcelUtil<TeacherEO>(TeacherEO.class);// 创建工具类.
		util.exportExcel(list, "教师信息", 65536, out);// 导出
		System.out.println("----执行完毕----------");
	}

}
