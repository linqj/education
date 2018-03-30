package com.chinayouthedu.zqzc.service;

import com.chinayouthedu.zqzc.config.exception.WebException;
import com.chinayouthedu.zqzc.entity.paike.Student;
import com.chinayouthedu.zqzc.entity.paike.Teacher;

/**
 * 联动调用登录表和用户表的Service
 * @author wangzq
 *
 */
public interface LoginLinkageService {

	/**
	 * 通过一个学生对象插入一个相关的用户表记录和登录表用户
	 * @param student
	 * @return
	 */
	boolean insertUserAndLoginWithStudent(Student student)throws WebException;
	
	/**
	 * 通过一个学生studentNumber删除一个相关的用户表记录和登录表用户
	 * @param student
	 * @return
	 */
	boolean deleteUserAndLoginWithStudent(String studentNumber)throws WebException;
	
	/**
	 * 通过一个学生studentNumber删除一个相关的用户表记录和登录表用户
	 * @param student
	 * @return
	 */
	boolean deleteUserAndLoginWithTeacher(String teacherNumber)throws WebException;
	
	/**
	 * 通过一个教师对象插入一个相关的用户表记录和登录表用户
	 * @param student
	 * @return
	 */
	boolean insertUserAndLoginWithTeacher(Teacher teacher);

}