package com.chinayouthedu.zqzc.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinayouthedu.zqzc.common.core.WebUtils;
import com.chinayouthedu.zqzc.common.utils.CyeComparators;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.Activity;
import com.chinayouthedu.zqzc.entity.paike.ActivityExample;
import com.chinayouthedu.zqzc.entity.paike.ActivityExample.Criteria;
import com.chinayouthedu.zqzc.entity.paike.Grade;
import com.chinayouthedu.zqzc.entity.paike.SchoolYear;
import com.chinayouthedu.zqzc.entity.paike.Semester;
import com.chinayouthedu.zqzc.mapper.paike.ActivityMapper;
import com.chinayouthedu.zqzc.service.ActivityService;
import com.chinayouthedu.zqzc.service.GradeService;
import com.chinayouthedu.zqzc.service.SchoolYearService;
import com.chinayouthedu.zqzc.service.SemesterService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ActivityServiceImpl extends BaseServiceImpl implements ActivityService {

	@Autowired
	private ActivityMapper activityMapper;

	@Autowired
	private GradeService gradeService;
	
	@Autowired
	private SchoolYearService schoolYearService;
	
	@Autowired
	private SemesterService semesterService;

	@Override
	public BaseResponse saveNewActivity(Activity activity) {

		// 1.处理通用
		activity.setEffective(true);
		activity.setCreateTime(new Date());
		activity.setUpdateTime(activity.getCreateTime());

		// 2.根据ID,判断有效性并添加冗余
		Grade grade = gradeService.selectByPrimaryKey(activity.getGradeId());
		if (grade != null && grade.getEffective() == true) {
			activity.setGradeName(grade.getGradeName());
		} else {
			BaseResponse errorResponse = new BaseResponse<>();
			WebUtils.Error(errorResponse, "活动的年级不存在或已失效,请核实后重试！");
			return errorResponse;
		}

		SchoolYear schoolYear = schoolYearService.selectByPrimaryKey(activity.getSchoolYearId());
		if (schoolYear != null) {
			activity.setSchoolYearName(schoolYear.getSchoolYearName());
		} else {
			BaseResponse errorResponse = new BaseResponse<>();
			WebUtils.Error(errorResponse, "活动的学年不存在或已失效,请核实后重试！");
			return errorResponse;
		}

		Semester semester = semesterService.selectByPrimaryKey(activity.getSemesterId());
		if (semester != null) {
			activity.setSemesterName(semester.getSemesterName());
		} else {
			BaseResponse errorResponse = new BaseResponse<>();
			WebUtils.Error(errorResponse, "活动的学期不存在或已失效,请核实后重试！");
			return errorResponse;
		}

		// 3.插入数据库操作
		boolean insertSuccess = activityMapper.insert(activity) > 0;
		if (insertSuccess) {
			BaseResponse successResponse = new BaseResponse<>();
			WebUtils.Success(successResponse, "活动创建成功！");
			return successResponse;
		} else {
			BaseResponse errorResponse = new BaseResponse<>();
			WebUtils.Error(errorResponse, "活动创建失败,请重试！");
			return errorResponse;
		}

	}

	@Override
	public BaseResponse updateActivity(Activity activity) {

		// 1.根据ID从数据库查询数据
		Activity activityInDB = activityMapper.selectByPrimaryKey(activity.getId());
		if (activityInDB == null || activityInDB.getEffective() == false) {
			BaseResponse errorResponse = new BaseResponse<>();
			WebUtils.Error(errorResponse, "找不到需要更新的记录,请重试！");
			return errorResponse;
		}

		// 1.处理通用
		activity.setEffective(true);
		activity.setCreateTime(activityInDB.getCreateTime());
		activity.setUpdateTime(new Date());

		// 2.根据ID,判断有效性并添加冗余
		Grade grade = gradeService.selectByPrimaryKey(activity.getGradeId());
		if (grade != null && grade.getEffective() == true) {
			activity.setGradeName(grade.getGradeName());
		} else {
			BaseResponse errorResponse = new BaseResponse<>();
			WebUtils.Error(errorResponse, "活动的年级不存在或已失效,请核实后重试！");
			return errorResponse;
		}

		SchoolYear schoolYear = schoolYearService.selectByPrimaryKey(activity.getSchoolYearId());
		if (schoolYear != null) {
			activity.setSchoolYearName(schoolYear.getSchoolYearName());
		} else {
			BaseResponse errorResponse = new BaseResponse<>();
			WebUtils.Error(errorResponse, "活动的学年不存在或已失效,请核实后重试！");
			return errorResponse;
		}

		Semester semester = semesterService.selectByPrimaryKey(activity.getSemesterId());
		if (semester != null) {
			activity.setSemesterName(semester.getSemesterName());
		} else {
			BaseResponse errorResponse = new BaseResponse<>();
			WebUtils.Error(errorResponse, "活动的学期不存在或已失效,请核实后重试！");
			return errorResponse;
		}

		// 3.插入数据库操作
		boolean insertSuccess = activityMapper.insert(activity) > 0;
		if (insertSuccess) {
			BaseResponse successResponse = new BaseResponse<>();
			WebUtils.Success(successResponse, "活动创建成功！");
			return successResponse;
		} else {
			BaseResponse errorResponse = new BaseResponse<>();
			WebUtils.Error(errorResponse, "活动创建失败,请重试！");
			return errorResponse;
		}

	}

	@Override
	public Activity selectByPrimaryKey(Long activityId) {
		
		Activity activityInDB = activityMapper.selectByPrimaryKey(activityId );
		if (activityInDB == null || activityInDB.getEffective() == false) {
			return null;
		}else{
			return activityInDB;
		}
		
	}

	@Override
	public BaseResponse deleteActivity(Long activityId) {
		
		Activity activity = selectByPrimaryKey(activityId );
		
		if(activity==null ){
			BaseResponse errorResponse = new BaseResponse<>();
			WebUtils.Error(errorResponse, "该活动不存在或者已删除！");
			return errorResponse;
		}
		
		activity.setEffective(false );
		boolean deleteSuccess = activityMapper.updateByPrimaryKey(activity )>0;
		if(deleteSuccess ){
			BaseResponse successResponse = new BaseResponse<>();
			WebUtils.Success(successResponse, "活动删除成功！");
			return successResponse;
		}else{
			BaseResponse successResponse = new BaseResponse<>();
			WebUtils.Error(successResponse, "活动删除失败！");
			return successResponse;
		}
		
	}

	@Override
	public List<Activity> selectAllActivity() {
		
		ActivityExample example = new ActivityExample();
		example.createCriteria()
				.andEffectiveEqualTo(true);
		List<Activity> allActivity = activityMapper.selectByExample(example );
		allActivity.sort(CyeComparators.ActivitySortComparator() );
		return allActivity;
	}

	@Override
	public PageInfo<Activity> pageSelectActivity(Integer pageNum, Integer pageSize, String currentStstus) {
		
		PageHelper.startPage(pageNum,pageSize);
		
		ActivityExample example = new ActivityExample();
		Criteria criteria = example.createCriteria().andEffectiveEqualTo(true );
		if(StringUtils.isNotBlank(currentStstus )){
			criteria.andCurrentStatusEqualTo(currentStstus );
		}
		
		return new PageInfo<>(activityMapper.selectByExample(example));
		
	}
	
	
	
	
	
	
	

}
