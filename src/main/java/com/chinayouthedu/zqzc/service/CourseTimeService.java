package com.chinayouthedu.zqzc.service;

import java.util.List;
import java.util.Map;


import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.SchoolYear;
import com.chinayouthedu.zqzc.entity.paike.TeacherGroup;
import com.chinayouthedu.zqzc.entity.vo.CourseTimeVo;

public interface CourseTimeService {

	/**
	 * 进入课时管理时先传入学年学期父子结构List
	 * @author  梁建
	 * @Time   2018年3月21日下午5:04:49
	 * @return
	 */
	List<SchoolYear> syList();
	
	/**
	 * 查询教研组List
	 * @author  梁建
	 * @Time   2018年3月21日下午5:56:48
	 * @return
	 */
	List<TeacherGroup> tgList();
	
	
	BaseResponse<Map<String, Object>> save(CourseTimeVo vo,Long id);
}
