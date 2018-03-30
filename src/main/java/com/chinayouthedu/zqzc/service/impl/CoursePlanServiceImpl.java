package com.chinayouthedu.zqzc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinayouthedu.zqzc.common.core.WebUtils;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.config.exception.WebException;
import com.chinayouthedu.zqzc.entity.paike.CoursePlan;
import com.chinayouthedu.zqzc.entity.paike.CoursePlanExample;
import com.chinayouthedu.zqzc.entity.vo.CoursePlanVo;
import com.chinayouthedu.zqzc.mapper.paike.CoursePlanMapper;
import com.chinayouthedu.zqzc.service.CoursePlanService;
/**
 * 课程开设计划管理
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time   2018年3月21日  下午2:41:41
 * @version 1.0
 */
@Service
public class CoursePlanServiceImpl implements CoursePlanService {
	
	@Autowired
	private CoursePlanMapper coursePlan;

	/**
	 * 学年学期下课程开设计划列表
	 */
	@Override
	public BaseResponse<List<CoursePlan>> getCoursePlanList(long yearId, long semesterId,Long gradeId) {
		BaseResponse<List<CoursePlan>> response = new BaseResponse<List<CoursePlan>>();
		List<CoursePlan> all_plan = new ArrayList<CoursePlan>();
		Map<String,Long> map = new HashMap<String,Long>();
		if(yearId > 0 && semesterId > 0){
			map.put("yearId", yearId);
			map.put("semesterId", semesterId);
			if(gradeId != null && gradeId > 0){
				map.put("gradeId", gradeId);
				all_plan = coursePlan.getCoursePlanList(map);//学年学期下的某个年级课程计划
			}else{
				all_plan = coursePlan.getCoursePlanList(map);//学年学期下的所有年级课程计划
				//课程开设计划中该学年学期下的所有年级
				List<CoursePlan> grade_list = coursePlan.selectGradeBySchoolYearIdAndSemesterId(map);
				for (CoursePlan grade : grade_list) {
					List<CoursePlan> childlist = new ArrayList<CoursePlan>();
					for (CoursePlan coursePlan : all_plan) {
						if(grade.getGradeId() == coursePlan.getGradeId()){
							childlist.add(coursePlan);
						}
					}
					grade.setChildlist(childlist);
				}
				all_plan = grade_list;
			}
			response.setData(all_plan);
		}
		return response;
	}

	/**
	 * 批量创建课程计划
	 */
	@Override
	@Transactional("paikeTransactionManager")
	public BaseResponse<Map<String, Object>> createCoursePlan(List<CoursePlan> list) {
		BaseResponse<Map<String, Object>> response = new BaseResponse<Map<String, Object>>();
		//TODO 先删除,再保存,还可优化
		int insert = 0;
		if(list.size() > 0){
			CoursePlanExample coursePlanExample = new CoursePlanExample();
			coursePlanExample.createCriteria().andSchoolYearIdEqualTo(list.get(0).getSchoolYearId())
			.andSemesterIdEqualTo(list.get(0).getSemesterId())
			.andGradeIdEqualTo(list.get(0).getGradeId());
			long count = coursePlan.countByExample(coursePlanExample);
			if(count > 0){
				int del = coursePlan.deleteByExample(coursePlanExample);
				if(del > 0){
					insert = coursePlan.createCoursePlan(list);
				}
			}else{
				insert = coursePlan.createCoursePlan(list);
			}
		}
		if(insert == list.size()){
			WebUtils.Success(response, "保存成功!");
		}else{
			throw new WebException(404, "保存失败!");
		}
		return response;
	}

	@Override
//	@Transactional("paikeTransactionManager")
	public BaseResponse<Map<String, Object>> editCoursePlan(List<CoursePlan> list) {
		//TODO 批量编辑
		return null;
	}

	/**
	 * 删除一个课程计划
	 */
	@Override
	public BaseResponse<Map<String, Object>> delCoursePlan(long id) {
		BaseResponse<Map<String, Object>> response = new BaseResponse<Map<String, Object>>();
		int del = 0;
		if(id > 0){
			del = coursePlan.deleteByPrimaryKey(id);
		}
		if(del > 0){
			WebUtils.Success(response, "删除成功!");
		}else{
			WebUtils.Error(response, "删除失败!");
		}
		return response;
	}

	/**
	 * 编辑一个课程计划
	 */
	@Override
	public BaseResponse<Map<String, Object>> editOneCoursePlan(CoursePlanVo coursePlanVo) {
		BaseResponse<Map<String, Object>> response = new BaseResponse<Map<String, Object>>();
		CoursePlan record = new CoursePlan();
		BeanUtils.copyProperties(coursePlanVo, record);
		record.setUpdateTime(new Date());
		int update = coursePlan.updateByPrimaryKeySelective(record);
		if(update > 0){
			WebUtils.Success(response, "编辑成功!");
		}else{
			WebUtils.Error(response, "编辑失败!");
		}
		return response;
	}

}
