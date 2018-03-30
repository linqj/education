package com.chinayouthedu.zqzc.service;

import java.util.List;

import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.config.exception.WebException;
import com.chinayouthedu.zqzc.entity.paike.Student;
import com.github.pagehelper.PageInfo;

public interface StudentService {

	/**
	 * 添加学生
	 * @param student
	 * @return
	 */
	BaseResponse saveStudent(Student student)throws WebException;

	/**
	 * 删除一个学生
	 * @param studentId
	 * @return
	 */
	BaseResponse deleteStudent(Long studentId);
	
	/**
	 * 更新学生对象
	 * @param student
	 * @return
	 */
	BaseResponse updateStudent(Student student);

	/**
	 * 查询学生分页对象 
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageInfo<Student> pageList(Integer pageNum, Integer pageSize,Long gradeId,Long claId,String name);
	
	/**
	 * 根据学生ID查询单个Student对象
	 * @param stuId
	 * @return
	 */
	Student selectByPrimaryKey(Long stuId);
	
	/**
	 * 根据班级的ID查询班级的所有学生
	 * @param classId
	 * @return
	 */
	List<Student> selectStudentsByClassId(Long classId);

	/**
	 * 根据年级的ID查询班级的所有学生
	 * @param gradeId
	 * @return
	 */
	List<Student> selectStudentsBygradeId(Long gradeId);

	/**
	 * 批量删除学生
	 * @param idList
	 * @return
	 */
	BaseResponse batchDeleteStudents(List<Long> idList);

	/**
	 * 批量调整学生的班级
	 * @param studentIds
	 * @param classId
	 * @return
	 */
	BaseResponse adjustToNewClass(List<Long> studentIds,Long classId );


}