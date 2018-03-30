package com.chinayouthedu.zqzc.entity.paike;

import com.chinayouthedu.zqzc.config.core.BaseBean;
import java.io.Serializable;
import java.util.Date;

/**
 * @表名称 zczx_user
 * @开发日期 2018-03-12 11:09:49
 * @开发作者 :中青至诚教育咨询有限公司 
 */
public class User extends BaseBean implements Serializable {
    /** id (主健ID) (无默认值) */
    private Long id;

    /** 用户名(可选项) (无默认值) */
    private String userName;

    /** 真实姓名(可选项) (无默认值) */
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

    /** 创建时间(可选项) (无默认值) */
    private Date createTime;

    /** 更新时间(可选项) (无默认值) */
    private Date updateTime;

    /** 备注(可选项) (无默认值) */
    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getIdcardType() {
        return idcardType;
    }

    public void setIdcardType(String idcardType) {
        this.idcardType = idcardType == null ? null : idcardType.trim();
    }

    public String getIdcardCode() {
        return idcardCode;
    }

    public void setIdcardCode(String idcardCode) {
        this.idcardCode = idcardCode == null ? null : idcardCode.trim();
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getUserSource() {
        return userSource;
    }

    public void setUserSource(String userSource) {
        this.userSource = userSource == null ? null : userSource.trim();
    }

    public String getPwdProtection() {
        return pwdProtection;
    }

    public void setPwdProtection(String pwdProtection) {
        this.pwdProtection = pwdProtection == null ? null : pwdProtection.trim();
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo == null ? null : otherInfo.trim();
    }

    public String getSystemStatus() {
        return systemStatus;
    }

    public void setSystemStatus(String systemStatus) {
        this.systemStatus = systemStatus == null ? null : systemStatus.trim();
    }

    public Long getUserSort() {
        return userSort;
    }

    public void setUserSort(Long userSort) {
        this.userSort = userSort;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}