package com.chinayouthedu.zqzc.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinayouthedu.zqzc.common.core.PassWordUtils;
import com.chinayouthedu.zqzc.common.core.WebUtils;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.Login;
import com.chinayouthedu.zqzc.mapper.paike.LoginMapper;
import com.chinayouthedu.zqzc.service.PasswordService;

@Service
@SuppressWarnings("all")
public class PassWordServiceImpl implements PasswordService{

	@Autowired
	private LoginMapper loginMapper;
	
	
	@Override
	public BaseResponse modifyPassWord(Long loginId, String oldPwd, String newPwd) {
		
		// 1.数据库查询登录信息
		Login loginInDB = loginMapper.selectByPrimaryKey(loginId );
		if(loginInDB==null) {
			@SuppressWarnings("rawtypes")
			BaseResponse response = new BaseResponse<>();
			WebUtils.Error(response, "您修改的用户不存在！");
			return response;
		}
		
		// 2.验证原密码是否正确
		boolean validateSuccess = PassWordUtils.validate(oldPwd, loginInDB.getSalt(), loginInDB.getPassword() );
		if(!validateSuccess ) {
			BaseResponse response = new BaseResponse<>();
			WebUtils.Error(response, "原密码不正确,请重试！");
			return response;
			
		}
		
		// 3.执行数据库数据更新操作
		String newSalt = PassWordUtils.newSalt();		// 使用新盐
		String newEncryptPwd = PassWordUtils.encryptPwd(newPwd, newSalt );	// 使用新的加密密码
		loginInDB.setPassword(newEncryptPwd );
		loginInDB.setSalt(newSalt );
		loginInDB.setUpdateTime(new Date() );
		
		// 4.检查更新是否成功,并且返回相应的提示
		boolean updateSucces = loginMapper.updateByPrimaryKey(loginInDB )>0;
		if(updateSucces ) {
			BaseResponse response = new BaseResponse<>();
			WebUtils.Success(response, "密码修改成功！");
			return response;
		}else {
			BaseResponse response = new BaseResponse<>();
			WebUtils.Error(response, "密码修改失败,请重试！");
			return response;
		}
		
		
	}

}