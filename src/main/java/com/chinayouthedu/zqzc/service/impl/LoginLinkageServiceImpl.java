package com.chinayouthedu.zqzc.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinayouthedu.zqzc.common.core.PassWordUtils;
import com.chinayouthedu.zqzc.config.exception.WebException;
import com.chinayouthedu.zqzc.entity.paike.Login;
import com.chinayouthedu.zqzc.entity.paike.LoginExample;
import com.chinayouthedu.zqzc.entity.paike.Student;
import com.chinayouthedu.zqzc.entity.paike.Teacher;
import com.chinayouthedu.zqzc.entity.paike.User;
import com.chinayouthedu.zqzc.mapper.paike.LoginMapper;
import com.chinayouthedu.zqzc.service.LoginLinkageService;
import com.chinayouthedu.zqzc.service.UserService;

@Service
public class LoginLinkageServiceImpl implements LoginLinkageService {

	private static final String DEFAUL_PASSWORD = "123456";
	private static final String STUDENT_REMARK = "student";
	private static final String TEACHER_REMARK = "teacher";
	private static final String DEFAULT_USER_TYPE = "zczx_role_type_product";
	private static final String SYSTEM_STATUS = "zczx_system_status_enable";
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LoginMapper loginMapper;
	
	@Transactional
	@Override
	public boolean insertUserAndLoginWithStudent(Student student) throws WebException{
		return insertUserAndLogin(student.getStuNumber(), student.getStuName(), STUDENT_REMARK);
	}

	@Transactional
	@Override
	public boolean insertUserAndLoginWithTeacher(Teacher teacher) {
		return insertUserAndLogin(teacher.getTeacherNumber(), teacher.getTeacherName(), TEACHER_REMARK);
	}
	
	@Transactional
	private boolean insertUserAndLogin(String userName,String realName,String remark) {
		
		// 1.添加用户表数据
		User user = new User();
		user.setUserName(userName );						// ...
		user.setRealName(realName );						// ...
		user.setCreateTime(new Date() );					// ...
		user.setUpdateTime(new Date() );					// ...
		user.setRemark(remark );							// ...
		user.setUserType(DEFAULT_USER_TYPE);				// ...
		user.setSystemStatus(SYSTEM_STATUS);				// ...
		boolean userInsertSuccess = userService.insertUser(user );
		if(!userInsertSuccess) {
			throw new WebException(404,"插入用户表失败!");
		}
		
		// 2.添加登录表数据
		Login login = new Login();
		String salt = PassWordUtils.newSalt();
		String encryptPwd = PassWordUtils.encryptPwd(DEFAUL_PASSWORD, salt);
		login.setUserId(user.getId() );						// ...
		login.setCreateTime(new Date() );					// ...
		login.setUpdateTime(new Date() );					// ...
		login.setSalt(salt);								// ...
		login.setPassword(encryptPwd );						// ...
		login.setRemark(user.getRemark());					// ...
		login.setLoginName(user.getUserName());				// ...
		boolean loginInsertSuccess = loginMapper.insert(login )>0 ;
		if(!loginInsertSuccess) {
			throw new WebException(404,"插入登录表失败!");
		}
		
		return true;
	}
	
	/**
	 * 通用的联动删除
	 * @param userName
	 * @param remark
	 * @return
	 */
	@Transactional
	private boolean deleteUserAndLogin(String userName,String remark) {
		
		boolean userDeleteSuccess = userService.deleteUserByUserNameAndRemark(userName,remark);
		
		LoginExample example = new LoginExample();
		example.createCriteria().andLoginNameEqualTo(userName).andRemarkEqualTo(remark);
		boolean loginDeleteSuccess = loginMapper.deleteByExample(example )>0;
		
		return userDeleteSuccess&&loginDeleteSuccess;
		
	}

	/**
	 * 学生联动删除
	 */
	@Override
	public boolean deleteUserAndLoginWithStudent(String studentNumber) throws WebException {
		
		return deleteUserAndLogin(studentNumber, STUDENT_REMARK );
	
	}
	/**
	 * 教师联动删除
	 */
	@Override
	public boolean deleteUserAndLoginWithTeacher(String teacherNumber) throws WebException {
		
		return deleteUserAndLogin(teacherNumber, TEACHER_REMARK );
		
	}
	

}