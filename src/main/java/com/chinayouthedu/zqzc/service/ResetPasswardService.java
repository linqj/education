package com.chinayouthedu.zqzc.service;

import java.util.Map;


import com.chinayouthedu.zqzc.config.core.BaseResponse;

public interface ResetPasswardService {

	/**
	 * 重置密码
	 * @author  梁建
	 * @Time   2018年3月23日下午3:30:08
	 * @param stuId
	 * @return
	 */
	BaseResponse<Map<String, Object>> resetPwd(Long id, String remark);
	
	/**
	 * 插入教师/学生时同时查到到user_personnel表中一条关系数据
	 * @author  梁建
	 * @Time   2018年3月23日下午4:41:32
	 * @param id
	 * @param num
	 * @return
	 */
	int insertUserPersonnel(Long personnelId,Long userId, String num);
}
