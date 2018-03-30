package com.chinayouthedu.zqzc.config.core;

import java.util.List;

import com.chinayouthedu.zqzc.entity.paike.Role;

/**
 * 用户基本信息
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time   2017年12月28日 下午2:39:02
 * @version 1.0
 */
public class SessionVo extends BaseBean{

	private static final long serialVersionUID = 1L;
	
	private long userId;//用户id

	private String userName;//用户名

	private List<Role> roles;//角色
	
	private List<Long> roleIds;//角色ids
	
	public List<Long> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Long> roleIds) {
		this.roleIds = roleIds;
	}
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
