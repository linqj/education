package com.chinayouthedu.zqzc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinayouthedu.zqzc.entity.paike.Role;
import com.chinayouthedu.zqzc.mapper.paike.RoleMapper;
import com.chinayouthedu.zqzc.service.RoleService;

/**
 * 角色
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time  2018年3月24日   下午11:46:05 
 * @version 1.0
 */
@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleMapper role;

	/**
	 * 根据用户id获取该用户角色
	 */
	@Override
	public List<Role> selectRolesByUserId(Long id) {
		return role.selectRolesByUserId(id);
	}

}
