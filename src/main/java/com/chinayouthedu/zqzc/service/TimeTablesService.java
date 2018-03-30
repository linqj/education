package com.chinayouthedu.zqzc.service;

import java.util.Map;

import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.vo.TimeTablesVo;
import com.chinayouthedu.zqzc.entity.vo.TimetableRuleVo;

/**
 * 节次管理
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time   2018年3月20日  下午12:20:58
 * @version 1.0
 */
public interface TimeTablesService {

	/**
	 * 节次列表
	 * @Time   2018年3月20日下午12:20:27
	 * @param pageNum
	 * @param pageSize
	 * @param gradeId
	 * @return
	 */
	BaseResponse<Map<String, Object>> getCourseTimeTables(int pageNum, int pageSize);

	/**
	 * 创建节次
	 * @Time   2018年3月20日下午12:20:30
	 * @param timeTablesVo
	 * @return
	 */
	BaseResponse<Map<String, Object>> createCourseTimeTables(TimeTablesVo timeTablesVo);

	/**
	 * 编辑节次
	 * @Time   2018年3月20日下午12:20:34
	 * @param timeTablesVo
	 * @return
	 */
	BaseResponse<Map<String, Object>> editCourseTimeTables(TimeTablesVo timeTablesVo);

	/**
	 * 删除节次
	 * @Time   2018年3月20日下午12:20:37
	 * @param id
	 * @return
	 */
	BaseResponse<Map<String, Object>> delCourseTimeTables(long id);

	/**
	 * 初始化节次
	 * @Time   2018年3月20日下午12:20:39
	 * @param timetableRuleVo
	 * @return
	 */
	BaseResponse<Map<String, Object>> initCourseTimeTables(TimetableRuleVo timetableRuleVo);

}
