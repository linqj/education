package com.chinayouthedu.zqzc.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinayouthedu.zqzc.common.core.WebUtils;
import com.chinayouthedu.zqzc.config.core.BaseController;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.Activity;
import com.chinayouthedu.zqzc.service.ActivityService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="活动管理接口API")
public class ActivityController extends BaseController{

	@Autowired
	private ActivityService activityService;
	
	@ApiOperation("新增或者更新一个活动")
	@PostMapping(value="/activity")
	public BaseResponse saveOrUpdateActivity(Activity activity){
		
		// 1.对象非空判断
		if(activity==null){
			BaseResponse errorResponse = new BaseResponse<>();
			WebUtils.Error(errorResponse, "接收不到数据,操作失败！");
			return errorResponse;
		}
		
		// 2.对必需字段的值进行检查,防止数据有误
		if(StringUtils.isBlank(activity.getActivityName() )){
			BaseResponse errorResponse = new BaseResponse<>();
			WebUtils.Error(errorResponse, "您未指定活动的名称,操作失败！");
			return errorResponse;
		}
		if(activity.getGradeId()==null ){
			BaseResponse errorResponse = new BaseResponse<>();
			WebUtils.Error(errorResponse, "您未指定活动的年级,操作失败！");
			return errorResponse;
		}
		if(activity.getSchoolYearId()==null ){
			BaseResponse errorResponse = new BaseResponse<>();
			WebUtils.Error(errorResponse, "您未指定活动的学年,操作失败！");
			return errorResponse;
		}
		if(activity.getSemesterId()==null ){
			BaseResponse errorResponse = new BaseResponse<>();
			WebUtils.Error(errorResponse, "您未指定活动的学期,操作失败！");
			return errorResponse;
		}
		if(StringUtils.isBlank(activity.getCurrentStatus()) ){
			BaseResponse errorResponse = new BaseResponse<>();
			WebUtils.Error(errorResponse, "您未指定活动的状态,操作失败！");
			return errorResponse;
		}
		
		// 3.将对象的冗余字段置为null，避免web端失误将冗余传进来
		activity.setGradeName(null);
		activity.setSchoolYearName(null);
		activity.setSemesterName(null);
		
		if(activity.getId()!=null){
			// 更新操作
			return activityService.updateActivity(activity );
		}else{
			// 保存操作
			return activityService.saveNewActivity(activity );
		}
	
	}
	
	
	
}