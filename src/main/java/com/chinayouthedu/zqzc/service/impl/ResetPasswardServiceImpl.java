package com.chinayouthedu.zqzc.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinayouthedu.zqzc.common.core.PassWordUtils;
import com.chinayouthedu.zqzc.common.core.WebUtils;
import com.chinayouthedu.zqzc.config.core.BaseResponse;
import com.chinayouthedu.zqzc.entity.paike.Login;
import com.chinayouthedu.zqzc.entity.paike.LoginExample;
import com.chinayouthedu.zqzc.entity.paike.UserPersonnel;
import com.chinayouthedu.zqzc.entity.paike.UserPersonnelExample;
import com.chinayouthedu.zqzc.mapper.paike.LoginMapper;
import com.chinayouthedu.zqzc.mapper.paike.UserPersonnelMapper;
import com.chinayouthedu.zqzc.service.ResetPasswardService;

@Service
public class ResetPasswardServiceImpl extends BaseServiceImpl implements ResetPasswardService {

	
	@Autowired
	private LoginMapper loginMapper;
	
	@Autowired
	private UserPersonnelMapper userPersonnelMapper;
	
	
	
	
	/**
	 * 重置密码
	 */
	@Override
	public BaseResponse<Map<String, Object>> resetPwd(Long id, String remark) {
		BaseResponse<Map<String, Object>> res = new BaseResponse<Map<String, Object>>();
		//根据人员id和学号/工号 查询出对应人员用户表的userid
		UserPersonnelExample userPersonnelExample = new UserPersonnelExample();
		userPersonnelExample.createCriteria().andPersonnelIdEqualTo(id).andRemarkEqualTo(remark);
		List<UserPersonnel> list = userPersonnelMapper.selectByExample(userPersonnelExample);
		if (list.size() == 1) {
			Long userId = 0L;
			for (UserPersonnel userPersonnel : list) {
				userId = userPersonnel.getUserId();
			}
			if (userId != 0L) {
				LoginExample loginExample = new LoginExample();
				loginExample.createCriteria().andUserIdEqualTo(userId);
				List<Login> list2 = loginMapper.selectByExample(loginExample);
				if (list2.size() == 1) {
					int i = 0;
					for (Login login : list2) {
						Login login2 = loginMapper.selectByPrimaryKey(login.getId());
						//修改密码
						String newSalt = PassWordUtils.newSalt();//新的盐
						login2.setSalt(newSalt);				//设置新的盐
						login2.setPassword(PassWordUtils.encryptPwd("123456", newSalt));  //通过新的盐设置新密码
						i += loginMapper.updateByPrimaryKey(login2);
					}
					if (i > 0) {
						WebUtils.Success(res, "重置密码成功!");
						return res;
					}else{
						WebUtils.Error(res, "重置密码失败!");
						return res;
					}
				}else{
					WebUtils.Error(res, "重置密码失败!");
					return res;
				}
			}else{
				WebUtils.Error(res, "重置密码失败!");
				return res;
			}
		}else{
			WebUtils.Error(res, "重置密码失败!");
			return res;
		}
	}

	
	/**
	 * 插入教师/学生时同时查到到user_personnel表中一条关系数据
	 */
	@Override
	public int insertUserPersonnel(Long personnelId, Long userId, String num) {
		UserPersonnel userPersonnel = new UserPersonnel();
		userPersonnel.setPersonnelId(personnelId);
		userPersonnel.setUserId(userId);
		userPersonnel.setRemark(num);
		userPersonnel.setCreateTime(new Date());
		int insert = userPersonnelMapper.insert(userPersonnel);
		return insert;
	}





}
