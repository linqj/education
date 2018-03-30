package com.chinayouthedu.zqzc.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinayouthedu.zqzc.common.utils.cye.CyeCollectionUtils;
import com.chinayouthedu.zqzc.common.utils.cye.CyeStringUtils;
import com.chinayouthedu.zqzc.entity.paike.Login;
import com.chinayouthedu.zqzc.entity.paike.LoginExample;
import com.chinayouthedu.zqzc.entity.paike.User;
import com.chinayouthedu.zqzc.entity.vo.LoginVo;
import com.chinayouthedu.zqzc.entity.vo.RegisterVo;
import com.chinayouthedu.zqzc.mapper.paike.LoginMapper;
import com.chinayouthedu.zqzc.mapper.paike.UserMapper;
import com.chinayouthedu.zqzc.service.LoginService;

/**
 * 登录
 * @author 张超群
 * @time   2018年3月13日下午4:04:25
 */
@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginMapper login;

	@Autowired
	private UserMapper userdao;
	
	

	@Override
	@Transactional("paikeTransactionManager")
	@Deprecated
	public boolean registerLoginInfoAndUserInfo(RegisterVo registerVo) {
		//TODO 事物处理还没完善
		int insert = 0;
		User userInfo = new User();
		BeanUtils.copyProperties(registerVo, userInfo);
		insert += userdao.insert(userInfo);
		Login loginInfo = new Login();
		BeanUtils.copyProperties(registerVo, loginInfo);
		loginInfo.setUserId(userInfo.getId());
		insert += login.insert(loginInfo);
		if(insert == 2){
			return true;
		}
		return false;
	}



	@Override
	@Deprecated
	public boolean checkUserByRegister(RegisterVo registerVo) {
		return false;
	}



	@Override
	public User validateLoginInfo(LoginVo vo) {
		// 1.创建User对象，并且初始化为null
		User user = null;
		// 2.根据登录名查询user对象,并且判断符合的用户是否唯一
		LoginExample example = new LoginExample();
		example.createCriteria().andLoginNameEqualTo(vo.getLoginName());
		List<Login> result = login.selectByExample(example);
		if(CyeCollectionUtils.isBlank(result)){
			// 查询不到登录用户
			return null;
		}
		if(result.size()>1){
			// 查询数据有误
			return null;
		}
		
		// 3.取登录对象的盐,与vo中的密码进行混淆,之后比较是否相同,相同则登录成功！
		Login login = result.get(0);
		String dbSalt = login.getSalt();
		String voPwd = vo.getPassword();
		
		// 加盐模式
		String md5Pwd = CyeStringUtils.md5pwd(voPwd, dbSalt);
		if(Objects.equals(md5Pwd, login.getPassword())){
			user = userdao.selectByPrimaryKey(login.getUserId());
		}
		return user;
	}

}
