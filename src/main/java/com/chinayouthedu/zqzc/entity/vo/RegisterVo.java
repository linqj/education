package com.chinayouthedu.zqzc.entity.vo;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import com.chinayouthedu.zqzc.config.annotation.RequestVo;
import com.chinayouthedu.zqzc.config.core.BaseBean;

/**
 * 用户注册VO
 * @author 张超群
 * @time   2018年3月13日下午3:52:35
 */
@RequestVo
public class RegisterVo extends BaseBean implements Serializable {
	
	 private static final long serialVersionUID = -7973554862107080848L;

	/** 登录名(可选项) (无默认值) */
	@NotBlank(message="登录名不能为空!")
    private String loginName;

    /** 盐(可选项) (无默认值) */
    private String salt;

    /** 密码(可选项) (无默认值) */
    @NotBlank(message="密码不能为空!")
    private String password;
    
    /** 用户名(可选项) (无默认值) */
    @NotBlank(message="用户名不能为空!")
    private String userName;

    /** 真实姓名(可选项) (无默认值) */
    @NotBlank(message="真实姓名不能为空!")
    private String realName;

    /** 证件类型(可选项) (无默认值) */
    private String idcardType;

    /** 证件号码(可选项) (无默认值) */
    private String idcardCode;

    /** 联系方式(可选项) (无默认值) */
    private String mobilePhone;

    /** 邮箱(可选项) (无默认值) */
    private String userEmail;

    /** 用户类型(可选项) (无默认值) */
    private String userType;

    /** 用户来源(可选项) (无默认值) */
    private String userSource;

    /** 用户密保(可选项) (无默认值) */
    private String pwdProtection;

    /** 其他信息(可选项) (无默认值) */
    private String otherInfo;

    /** 系统状态(可选项) (无默认值) */
    private String systemStatus;

    /** 用户序号(可选项) (无默认值) */
    private Long userSort;

    /** 备注(可选项) (无默认值) */
    private String remark;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getIdcardType() {
		return idcardType;
	}

	public void setIdcardType(String idcardType) {
		this.idcardType = idcardType;
	}

	public String getIdcardCode() {
		return idcardCode;
	}

	public void setIdcardCode(String idcardCode) {
		this.idcardCode = idcardCode;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserSource() {
		return userSource;
	}

	public void setUserSource(String userSource) {
		this.userSource = userSource;
	}

	public String getPwdProtection() {
		return pwdProtection;
	}

	public void setPwdProtection(String pwdProtection) {
		this.pwdProtection = pwdProtection;
	}

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public String getSystemStatus() {
		return systemStatus;
	}

	public void setSystemStatus(String systemStatus) {
		this.systemStatus = systemStatus;
	}

	public Long getUserSort() {
		return userSort;
	}

	public void setUserSort(Long userSort) {
		this.userSort = userSort;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
    
}
