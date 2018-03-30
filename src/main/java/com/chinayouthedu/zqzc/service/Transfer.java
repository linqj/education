package com.chinayouthedu.zqzc.service;
/**
 * 
 * 转换器
 * @author wangzq
 *
 */

import java.util.List;

import com.chinayouthedu.zqzc.entity.paike.Cla;
import com.chinayouthedu.zqzc.entity.paike.Student;
import com.github.pagehelper.PageInfo;

public interface Transfer {

	/**
	 * 转换学生对象
	 * @param pageInfo
	 * @return
	 */
	public PageInfo<Student> transfer(PageInfo<Student> pageInfo);
	
	public List<Cla> transfer(List<Cla> classList);
	
	
	
	
	
	
}
