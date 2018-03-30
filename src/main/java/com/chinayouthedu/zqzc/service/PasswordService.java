package com.chinayouthedu.zqzc.service;

import com.chinayouthedu.zqzc.config.core.BaseResponse;

@SuppressWarnings("all")
public interface PasswordService {

	/**
	 * 使用新密码替换旧密码
	 * @param loginId 登录数据的ID 
	 * @param oldPwd 旧的未加密的密码
	 * @param newPwd 新的未加密的密码
	 * @return
	 */
	BaseResponse modifyPassWord(Long loginId, String oldPwd, String newPwd );
}
