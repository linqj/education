package com.chinayouthedu.zqzc.service;

import java.util.List;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.Cla;

public interface ClassService {

	/**
	 * 根据班级的ID查询班级的对象
	 * @param classId
	 * @return
	 */
	Cla selectClassByPrimaryKey(Long classId);

	/**
	 * 保存班级(insert)
	 * @param cla
	 * @return
	 */
	BaseResponse saveClass(Cla cla);
	
	/**
	 * 更新班级(update)
	 * @param cla
	 * @return
	 */
	BaseResponse updateClass(Cla cla);
	
	/**
	 * 删除班级(delete)
	 * @param claId
	 * @return
	 */
	BaseResponse deleteClass(Long claId);
	
	/**
	 * 查询所有的年级对象
	 * @return 年级对象的集合
	 */
	List<Cla> selectAllClasses();
	
	/**
	 * 根据年级ID查询所有的班级
	 * @return 年级对象的集合
	 */
	List<Cla> selectAllClassesByGradeId(Long gradeId );
	
	/**
	 * 操作班级的班主任
	 * @param classId
	 * @param teacherId
	 * @return
	 */
	BaseResponse appointHeadteacher(Long classId,Long teacherId);
	

}