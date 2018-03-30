package com.chinayouthedu.zqzc.service;

import java.util.List;

import com.chinayouthedu.zqzc.entity.paike.Role;

/**
 * 角色
 * @Company 中青至诚教育咨询有限公司
 * @author 张超群
 * @Modifier
 * @time  2018年3月24日   下午11:51:18 
 * @version 1.0
 */
public interface RoleService {

	/**
	 * 根据用户id获取该用户角色
	 * @author  张超群	2018年3月24日 下午11:51:15
	 * @param id	long	用户id
	 * @return
	 */
	List<Role> selectRolesByUserId(Long id);

}
