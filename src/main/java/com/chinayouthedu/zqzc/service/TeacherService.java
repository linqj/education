package com.chinayouthedu.zqzc.service;

import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.Teacher;
import com.chinayouthedu.zqzc.entity.vo.TeacherVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

public interface TeacherService {

	/**
	 * 保存教师
	 * @param teacher
	 * @return
	 */
	BaseResponse saveTeacher(Teacher teacher );
	/**
	 * 根据ID删除教师
	 * @param teacherId
	 * @return
	 */
	BaseResponse deleteTeacherByPrimaryKey(Long teacherId );
	/**
	 * 更新教师
	 * @param teacher
	 * @return
	 */
	BaseResponse updateTeacher(TeacherVo vo, Long tId);
	/**
	 * 根据教师ID查询教师的信息
	 * @param teacherId
	 * @return
	 */
	Teacher selectTeacherByPrimaryKey(Long teacherId );
	/**
	 * 分页查询教师
	 * @param pageNum 页码,可空
	 * @param pageSize 页码大小,可空
	 * @param name 教师名称(做模糊查询,可空)
	 * @return
	 */
	PageInfo<Teacher> selectTeacherPageInfo(Integer pageNum,Integer pageSize,String name );
	/**
	 * 根据教研组查询教师
	 * @param tgId
	 * @return
	 */
	List<Teacher> selectTeacherListByTeacherGroupId(Long tgId );
	/**
	 * 查询所有教师
	 * 不分班级
	 * 不分年级
	 * 不分教研组
	 * @return
	 */
	List<Teacher> selectAllTeacher();
	
	/**
	 * 批量删除教师
	 * @param idList
	 * @return
	 */
	BaseResponse batchDeleteTeacher(List<Long> idList);
	
//	/**
//	 * 获取所有的班主任教师对象
//	 * @return
//	 */
//	List<Teacher> selectAllHeadteacher();
	
	/**
	 * 获取所有的班主任教师ID
	 * @return
	 */
	List<Long > selectAllHeadTeacherId();
	
}
