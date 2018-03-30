package com.chinayouthedu.zqzc.service;

import com.chinayouthedu.zqzc.entity.paike.User;

/**
 * 用户表相关的Service
 * @author wangzq
 *
 */
public interface UserService {

	
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	boolean insertUser(User user );

	/**
	 * 根据userName和remark删除
	 * @param userName
	 * @param remark
	 * @return
	 */
	boolean deleteUserByUserNameAndRemark(String userName, String remark);
}
