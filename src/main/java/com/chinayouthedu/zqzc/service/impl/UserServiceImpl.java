package com.chinayouthedu.zqzc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinayouthedu.zqzc.entity.paike.User;
import com.chinayouthedu.zqzc.entity.paike.UserExample;
import com.chinayouthedu.zqzc.mapper.paike.UserMapper;
import com.chinayouthedu.zqzc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Transactional
	@Override
	public boolean insertUser(User user ) {
		
		return userMapper.insert(user )>0;
		
	}

	@Transactional
	@Override
	public boolean deleteUserByUserNameAndRemark(String userName, String remark) {
		
		UserExample example = new UserExample();
		example.createCriteria().andUserNameEqualTo(userName).andRemarkEqualTo(remark);
		return userMapper.deleteByExample(example )>0;
		
	}
	
	
	
	
}
