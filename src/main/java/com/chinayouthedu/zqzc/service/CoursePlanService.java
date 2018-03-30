package com.chinayouthedu.zqzc.service;

import java.util.List;
import java.util.Map;

import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.CoursePlan;
import com.chinayouthedu.zqzc.entity.vo.CoursePlanVo;
/**
 * 课程开设计划管理
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time   2018年3月21日  下午2:41:33
 * @version 1.0
 */
public interface CoursePlanService {

	/**
	 * 学年学期下课程开设计划列表
	 * @Time   2018年3月21日下午2:41:04
	 * @param semesterId	long	学期id
	 * @param yearId		long	学年id
	 * @return
	 */
	BaseResponse<List<CoursePlan>> getCoursePlanList(long yearId, long semesterId,Long gradeId);

	/**
	 * 批量创建课程计划
	 * @Time   2018年3月27日下午12:40:29
	 * @param list
	 * @return
	 */
	BaseResponse<Map<String, Object>> createCoursePlan(List<CoursePlan> list);

	/**
	 * 暂时弃用
	 * @Time   2018年3月27日下午12:40:32
	 * @param list
	 * @return
	 */
	BaseResponse<Map<String, Object>> editCoursePlan(List<CoursePlan> list);

	/**
	 * 删除一个课程计划
	 * @Time   2018年3月27日下午12:40:35
	 * @param id
	 * @return
	 */
	BaseResponse<Map<String, Object>> delCoursePlan(long id);

	/**
	 * 编辑一个课程计划
	 * @Time   2018年3月27日下午12:40:39
	 * @param coursePlanVo
	 * @return
	 */
	BaseResponse<Map<String, Object>> editOneCoursePlan(CoursePlanVo coursePlanVo);

}
