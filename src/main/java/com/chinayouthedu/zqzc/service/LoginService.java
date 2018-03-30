package com.chinayouthedu.zqzc.service;

import com.chinayouthedu.zqzc.entity.paike.User;
import com.chinayouthedu.zqzc.entity.vo.LoginVo;
import com.chinayouthedu.zqzc.entity.vo.RegisterVo;

/**
 * 登录
 * @time   2018年3月13日下午3:59:49
 */
public interface LoginService {

	/**
	 * 注册用户(创建登录信息和用户信息)
	 * @Time   2018年3月13日下午4:09:49
	 * @param registerVo
	 * @return boolean
	 */
	@Deprecated
	boolean registerLoginInfoAndUserInfo(RegisterVo registerVo);

	/**
	 * 检测用户是否注册过
	 * @Time   2018年3月13日下午4:12:31
	 * @param registerVo
	 * @return boolean
	 */
	@Deprecated
	boolean checkUserByRegister(RegisterVo registerVo);

	/**
	 * 验证登录用户信息
	 * @author  张超群	2018年3月24日 下午11:09:10
	 * @param vo
	 * @return
	 */
	User validateLoginInfo(LoginVo vo);

}
