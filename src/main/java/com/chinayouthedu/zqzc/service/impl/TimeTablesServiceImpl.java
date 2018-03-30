package com.chinayouthedu.zqzc.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.chinayouthedu.zqzc.common.core.WebUtils;
import com.chinayouthedu.zqzc.common.utils.DateUtils;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.config.exception.WebException;
import com.chinayouthedu.zqzc.entity.paike.TimeTables;
import com.chinayouthedu.zqzc.entity.paike.TimeTablesExample;
import com.chinayouthedu.zqzc.entity.paike.TimetableRule;
import com.chinayouthedu.zqzc.entity.paike.TimetableRuleExample;
import com.chinayouthedu.zqzc.entity.vo.TimeTablesVo;
import com.chinayouthedu.zqzc.entity.vo.TimetableRuleVo;
import com.chinayouthedu.zqzc.mapper.paike.TimeTablesMapper;
import com.chinayouthedu.zqzc.mapper.paike.TimetableRuleMapper;
import com.chinayouthedu.zqzc.service.TimeTablesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 节次管理
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time   2018年3月20日  下午12:20:51
 * @version 1.0
 */
@Service
public class TimeTablesServiceImpl implements TimeTablesService {
	
	@Autowired
	private TimeTablesMapper timetables;//节次
	
	@Autowired
	private TimetableRuleMapper timeTableRule;//节次规则

	/**
	 * 获取节次列表
	 */
	@Override
	public BaseResponse<Map<String, Object>> getCourseTimeTables(int pageNum, int pageSize) {
		BaseResponse<Map<String,Object>> response = new BaseResponse<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String,Object>();
		PageHelper.startPage(pageNum, pageSize);
		TimeTablesExample timeTablesExample = new TimeTablesExample();
		List<TimeTables> timeTables_list = timetables.selectByExample(timeTablesExample);
		PageInfo<TimeTables> info = new PageInfo<TimeTables>(timeTables_list);
		map.put("pageInfo", info);
		response.setData(map);
		return response;
	}

	/**
	 * 创建节次
	 */
	@Override
	public BaseResponse<Map<String, Object>> createCourseTimeTables(TimeTablesVo timeTablesVo) {
		BaseResponse<Map<String,Object>> response = new BaseResponse<Map<String,Object>>();
		//先检查是否存在,存在则退出并返回错误信息,不存在则生成
		TimeTablesExample timeTablesExample = new TimeTablesExample();
		timeTablesExample.createCriteria().andSortEqualTo(timeTablesVo.getSort());
		List<TimeTables> exist = timetables.selectByExample(timeTablesExample);
		int insert = 0;
		if(exist.size() > 0){//已存在
			WebUtils.Error(response, "该节次已存在!");
			return response;
		}else{//第一次创建
			TimeTables entity = new TimeTables();
			BeanUtils.copyProperties(timeTablesVo, entity);
			entity.setCreateTime(new Date());
			insert += timetables.insert(entity);
		}
		if(insert > 0){//创建成功
			WebUtils.Success(response, "保存成功!");
		}else{
			WebUtils.Error(response, "保存失败!");
		}
		return response;
	}

	/**
	 * 编辑节次
	 */
	@Override
	public BaseResponse<Map<String, Object>> editCourseTimeTables(TimeTablesVo timeTablesVo) {
		BaseResponse<Map<String,Object>> response = new BaseResponse<Map<String,Object>>();
		int update = 0;
		//执行编辑
		if(timeTablesVo.getId() != null && timeTablesVo.getId() > 0){
			TimeTables entity = timetables.selectByPrimaryKey(timeTablesVo.getId());
			if(entity != null){//此记录存在
				//检查编辑后的节次是否存在
				if(entity.getSort() != timeTablesVo.getSort()){//节次不同
					TimeTablesExample timeTablesExample = new TimeTablesExample();
					timeTablesExample.createCriteria().andSortEqualTo(timeTablesVo.getSort());
					List<TimeTables> exist = timetables.selectByExample(timeTablesExample);
					if(exist.size() > 0){//编辑的节次已存在
						WebUtils.Error(response, "该节次数已存在!");
						return response;
					}
				}else{
					TimeTables edit = new TimeTables();
					BeanUtils.copyProperties(timeTablesVo, edit);
					edit.setCreateTime(entity.getCreateTime());
					edit.setUpdateTime(new Date());
					update += timetables.updateByPrimaryKeySelective(edit);
				}
			}
		}else{
			WebUtils.Error(response, "该节次不存在!");
			return response;
		}
		if(update > 0){//创建成功
			WebUtils.Success(response, "编辑成功!");
		}else{
			WebUtils.Error(response, "编辑失败!");
		}
		return response;
	}

	/**
	 * 删除节次
	 */
	@Override
	public BaseResponse<Map<String, Object>> delCourseTimeTables(long id) {
		BaseResponse<Map<String,Object>> response = new BaseResponse<Map<String,Object>>();
		if(id > 0){
			int del = timetables.deleteByPrimaryKey(id);
			if(del > 0 ){
				WebUtils.Success(response, "删除成功!");
				return response;
			}
		}
		WebUtils.Error(response, "删除失败!");
		return response;
	}

	
	/**
	 * 节次初始化
	 */
	@Override
	@Transactional("paikeTransactionManager")
	public BaseResponse<Map<String, Object>> initCourseTimeTables(TimetableRuleVo timetableRuleVo) {
		BaseResponse<Map<String,Object>> response = new BaseResponse<Map<String,Object>>();
		//执行规则持久化,检查是否插入过规则,如果插入过则删除后重新插入.如果没则第一次插入
		TimetableRuleExample timetableRuleExample = new TimetableRuleExample();
		List<TimetableRule> rules = timeTableRule.selectByExample(timetableRuleExample);
		int in = 0;
		if(rules.size() > 0){//存在
			//删除
			int delete = timeTableRule.deleteByExample(timetableRuleExample);
			if(delete == rules.size()){
				//插入
				TimetableRule Rule = new TimetableRule();
				BeanUtils.copyProperties(timetableRuleVo, Rule);
				Rule.setCreateTime(new Date());
				in += timeTableRule.insert(Rule);
			}else{
				throw new WebException(404,"初始化失败!");
			}
		}else{//第一次创建规则
			//插入
			TimetableRule Rule = new TimetableRule();
			BeanUtils.copyProperties(timetableRuleVo, Rule);
			Rule.setCreateTime(new Date());
			in += timeTableRule.insert(Rule);
		}
		if(in > 0){
			boolean insert = false;
			//先检查是否存在,存在则清空,然后生成
			TimeTablesExample timeTablesExample = new TimeTablesExample();
			List<TimeTables> exist = timetables.selectByExample(timeTablesExample);
			if(exist.size() > 0){//存在节次
				int delete = timetables.deleteByExample(timeTablesExample);
				if(delete == exist.size()){//删除所有节次成功
					//计算规则,插入新节次
					insert = InitTimeTables(timetableRuleVo);
				}else{//删除失败
					throw new WebException(404,"初始化失败!");
				}
			}else{//第一次创建
				//计算规则,插入新节次
				insert = InitTimeTables(timetableRuleVo);
			}
			if(insert){
				WebUtils.Success(response, "初始化成功!");
			}else{
				throw new WebException(404,"初始化失败!");
			}
		}else{
			throw new WebException(404,"初始化失败!");
		}
		return response;
	}

	/**
	 * 按规则初始化节次
	 * @Time   2018年3月21日下午1:55:20
	 * @param timetableRuleVo
	 * @return
	 */
	private boolean InitTimeTables(TimetableRuleVo timetableRuleVo) {
		Integer courseNum = timetableRuleVo.getCourseNum();//每天上课节数
		Integer courseLength = timetableRuleVo.getCourseLength();//每节课时长
		String firstCourseTime = timetableRuleVo.getFirstCourseTime();//第一节课开始时间
		Integer gymnasticsSort = timetableRuleVo.getGymnasticsSort();//课间操在第几节课后
		Integer gymnasticsLength = timetableRuleVo.getGymnasticsLength();//课间操时长
		String pmFirstCourseTime = timetableRuleVo.getPmFirstCourseTime();//下午第一节课开始时间
		Integer pmFirstCourseSort = timetableRuleVo.getPmFirstCourseSort();//下午第一节课开始节次
		Integer recess = timetableRuleVo.getRecess();//课间休息时间
		//插入节数条记录
		//上午
		//第一条记录			开始时间为第一节课开始时间,结束时间=第一节课开始时间+每节课时长
		//课间操之前的每条记录	开始时间=前一节结束时间+课间休息时间,结束时间=开始时间+课间休息时间
		//课间操之后的每条记录	开始时间=前一节结束时间+课间休息时间,结束时间=开始时间+课间休息时间
		
		//下午
		//下午第一节			开始时间=下午第一节课开始时间,结束时间=下午第一节课开始时间+课间休息时间
		//之后的				开始时间=前一节结束时间+课间休息时间,结束时间=开始时间+课间休息时间
		int insert = 0;
		String end_time = "";//节次的结束时间
		for (int i = 1; i <= courseNum; i++) {
			TimeTables entity = new TimeTables();
			entity.setSort(i);
			entity.setName("第"+i+"节");
			entity.setCreateTime(new Date());
			if(i == 1){//上午第一节
				entity.setStartTime(firstCourseTime);
				Date time = DateUtils.CalculationTime(firstCourseTime, "HH:mm", Calendar.MINUTE, courseLength, true);
				end_time = DateUtils.toString(time, "HH:mm");
				entity.setEndTime(end_time);
				insert += timetables.insert(entity);
			}else if(i <= gymnasticsSort){//上午课间操之前
				Date before = DateUtils.CalculationTime(end_time, "HH:mm", Calendar.MINUTE, recess, true);
				String start_time = DateUtils.toString(before, "HH:mm");
				entity.setStartTime(start_time);
				Date time = DateUtils.CalculationTime(start_time, "HH:mm", Calendar.MINUTE, courseLength, true);
				end_time = DateUtils.toString(time, "HH:mm");
				entity.setEndTime(end_time);
				insert += timetables.insert(entity);
			}else if(i > gymnasticsSort && i < pmFirstCourseSort){//上午课间操之后
				Date after = null;
				if(i == gymnasticsSort+1){//课间操后一节
					after = DateUtils.CalculationTime(end_time, "HH:mm", Calendar.MINUTE, gymnasticsLength, true);
				}else{//课间操后几节
					after = DateUtils.CalculationTime(end_time, "HH:mm", Calendar.MINUTE, recess, true);
				}
				String start_time = DateUtils.toString(after, "HH:mm");
				entity.setStartTime(start_time);
				Date time = DateUtils.CalculationTime(start_time, "HH:mm", Calendar.MINUTE, courseLength, true);
				end_time = DateUtils.toString(time, "HH:mm");
				entity.setEndTime(end_time);
				insert += timetables.insert(entity);
			}else if(i == pmFirstCourseSort){//下午第一节
				entity.setStartTime(pmFirstCourseTime);
				Date time = DateUtils.CalculationTime(pmFirstCourseTime, "HH:mm", Calendar.MINUTE, courseLength, true);
				end_time = DateUtils.toString(time, "HH:mm");
				entity.setEndTime(end_time);
				insert += timetables.insert(entity);
			}else if(i > pmFirstCourseSort){//下午的节次
				Date pm_time = DateUtils.CalculationTime(end_time, "HH:mm", Calendar.MINUTE, recess, true);
				String start_time = DateUtils.toString(pm_time, "HH:mm");
				entity.setStartTime(start_time);
				Date time = DateUtils.CalculationTime(start_time, "HH:mm", Calendar.MINUTE, courseLength, true);
				end_time = DateUtils.toString(time, "HH:mm");
				entity.setEndTime(end_time);
				insert += timetables.insert(entity);
			}
			
		}
		if(insert == courseNum){
			return true;
		}else{
			return false;
		}
	}
}
