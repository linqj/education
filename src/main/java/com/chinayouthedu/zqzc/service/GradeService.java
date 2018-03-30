package com.chinayouthedu.zqzc.service;

import java.util.List;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.Grade;
import com.chinayouthedu.zqzc.entity.vo.GradeVo;
import com.github.pagehelper.PageInfo;

public interface GradeService {

	/**
	 * 新增一个年级
	 * @param grade
	 * @return BaseResponse
	 */
	BaseResponse save(Grade grade);
	
	/**
	 * 删除一个年级
	 * @param gradeId
	 * @return
	 */
	BaseResponse deleteGrade(Long gradeId);
	
	/**
	 * 更新年级对象
	 * @param grade
	 * @return BaseResponse
	 */
	BaseResponse update(Grade grade);
	
	/**
	 * 通过ID查询一个年级的对象
	 * @param gradeId 年级ID
	 * @return Grade年级对象
	 */
	Grade selectByPrimaryKey(long gradeId);
	
	/**
	 * 根据年级ID查询一个年级VO对象(带班级集合)
	 * @param gradeId
	 * @return
	 */
	GradeVo selectGradeWithClassList(Long gradeId);
	
	/**
	 * 查询所有年级对象,不包含父子结构
	 * @return
	 */
	@Deprecated
	List<Grade> getAllEffectiveGrade();
	
	/**
	 * 分页查询年级-班级父子结构对象集合
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageInfo<GradeVo> getGradeVoPageList(Integer pageNum, Integer pageSize);

	/**
	 * 查询所有年级(带班级结构)
	 * @return List<GradeVo>
	 */
	List<GradeVo> selectAllGradeVo();
	
}