package com.chinayouthedu.zqzc.service;

import java.util.List;

import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.Activity;
import com.github.pagehelper.PageInfo;

public interface ActivityService {

	/**
	 * 创建新活动
	 * @param activity
	 * @return
	 */
	BaseResponse saveNewActivity(Activity activity);
	
	/**
	 * 更新活动
	 * @param activity
	 * @return
	 */
	BaseResponse updateActivity(Activity activity);

	/**
	 * 根据活动的ID查询活动的详情
	 * @param activityId
	 * @return
	 */
	Activity selectByPrimaryKey(Long activityId );
	
	/**
	 * 根据活动的ID进行删除(伪删除)
	 * @param activityId
	 * @return
	 */
	BaseResponse deleteActivity(Long activityId );
	
	/**
	 * 查询所有的活动(包含已过期,已完成的,不包含伪删除的)
	 * @return
	 */
	List<Activity > selectAllActivity();
	
	/**
	 * 分页查询所有的活动(包含已过期,已完成的,不包含伪删除的)
	 * @return
	 */
	PageInfo<Activity > pageSelectActivity(Integer pageNum,Integer pageSize,String currentStstus );
	
}
