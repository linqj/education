package com.chinayouthedu.zqzc.entity.paike;

import com.chinayouthedu.zqzc.config.core.BaseBean;
import java.io.Serializable;
import java.util.Date;

/**
 * @表名称 teacher
 * @开发日期 2018-03-27 11:54:20
 * @开发作者 :中青至诚教育咨询有限公司 
 */
public class Teacher extends BaseBean implements Serializable {
    /**  (主健ID) (无默认值) */
    private Long id;

    /** @desc 姓名(可选项) (无默认值) */
    private String teacherName;

    /** @desc 性别(可选项) (无默认值) */
    private String teacherGender;

    /** @desc 生日(可选项) (无默认值) */
    private Date teacherBirthday;

    /** @desc 手机号码(可选项) (无默认值) */
    private String teacherPhone;

    /** @desc 邮件(可选项) (无默认值) */
    private String teacherEmail;

    /** @desc 身份证号(可选项) (无默认值) */
    private String teacherIdcard;

    /** @desc 教师编号(可选项) (无默认值) */
    private String teacherNumber;

    /** @desc 教师学历(可选项) (无默认值) */
    private String teacherDegree;

    /** 教师性质,如班主任,(可选项) (无默认值) */
    private String teacherProperty;

    /** @decs 教师级别(可选项) (无默认值) */
    private String teacherLevel;

    /** 教师所属教研组id(可选项) (无默认值) */
    private Long teacherGroupId;

    /** 教师所属教研组名称(可选项) (无默认值) */
    private String teacherGroupName;

    /** @desc 教师入职时间(可选项) (无默认值) */
    private Date teacherStartTime;

    /** @desc 离职时间(可选项) (无默认值) */
    private Date teacherEndTime;

    /** @desc 教师居住地址(可选项) (无默认值) */
    private String teacherLiveAddress;

    /** @desc 教师家庭地址(可选项) (无默认值) */
    private String teacherHomeAddress;

    /** 是否为组长 0是false 1是true (必填项)  (默认值为: 0) */
    private Boolean isLeader;

    /** 是否为副组长 0是false 1是true (必填项)  (默认值为: 0) */
    private Boolean isLeaderTwo;

    /** 是否为班主任 0是false 1是true (必填项)  (默认值为: 0) */
    private Boolean isClassManager;

    /** @desc 状态(可选项) (无默认值) */
    private String status;

    /** @desc 系统状态(可选项) (无默认值) */
    private String sysStatus;

    /** @desc 数据创建时间(可选项) (无默认值) */
    private Date createTime;

    /** @desc 数据最后修改时间(可选项) (无默认值) */
    private Date updateTime;

    /** @desc 备注(可选项) (无默认值) */
    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public String getTeacherGender() {
        return teacherGender;
    }

    public void setTeacherGender(String teacherGender) {
        this.teacherGender = teacherGender == null ? null : teacherGender.trim();
    }

    public Date getTeacherBirthday() {
        return teacherBirthday;
    }

    public void setTeacherBirthday(Date teacherBirthday) {
        this.teacherBirthday = teacherBirthday;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone == null ? null : teacherPhone.trim();
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail == null ? null : teacherEmail.trim();
    }

    public String getTeacherIdcard() {
        return teacherIdcard;
    }

    public void setTeacherIdcard(String teacherIdcard) {
        this.teacherIdcard = teacherIdcard == null ? null : teacherIdcard.trim();
    }

    public String getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(String teacherNumber) {
        this.teacherNumber = teacherNumber == null ? null : teacherNumber.trim();
    }

    public String getTeacherDegree() {
        return teacherDegree;
    }

    public void setTeacherDegree(String teacherDegree) {
        this.teacherDegree = teacherDegree == null ? null : teacherDegree.trim();
    }

    public String getTeacherProperty() {
        return teacherProperty;
    }

    public void setTeacherProperty(String teacherProperty) {
        this.teacherProperty = teacherProperty == null ? null : teacherProperty.trim();
    }

    public String getTeacherLevel() {
        return teacherLevel;
    }

    public void setTeacherLevel(String teacherLevel) {
        this.teacherLevel = teacherLevel == null ? null : teacherLevel.trim();
    }

    public Long getTeacherGroupId() {
        return teacherGroupId;
    }

    public void setTeacherGroupId(Long teacherGroupId) {
        this.teacherGroupId = teacherGroupId;
    }

    public String getTeacherGroupName() {
        return teacherGroupName;
    }

    public void setTeacherGroupName(String teacherGroupName) {
        this.teacherGroupName = teacherGroupName == null ? null : teacherGroupName.trim();
    }

    public Date getTeacherStartTime() {
        return teacherStartTime;
    }

    public void setTeacherStartTime(Date teacherStartTime) {
        this.teacherStartTime = teacherStartTime;
    }

    public Date getTeacherEndTime() {
        return teacherEndTime;
    }

    public void setTeacherEndTime(Date teacherEndTime) {
        this.teacherEndTime = teacherEndTime;
    }

    public String getTeacherLiveAddress() {
        return teacherLiveAddress;
    }

    public void setTeacherLiveAddress(String teacherLiveAddress) {
        this.teacherLiveAddress = teacherLiveAddress == null ? null : teacherLiveAddress.trim();
    }

    public String getTeacherHomeAddress() {
        return teacherHomeAddress;
    }

    public void setTeacherHomeAddress(String teacherHomeAddress) {
        this.teacherHomeAddress = teacherHomeAddress == null ? null : teacherHomeAddress.trim();
    }

    public Boolean getIsLeader() {
        return isLeader;
    }

    public void setIsLeader(Boolean isLeader) {
        this.isLeader = isLeader;
    }

    public Boolean getIsLeaderTwo() {
        return isLeaderTwo;
    }

    public void setIsLeaderTwo(Boolean isLeaderTwo) {
        this.isLeaderTwo = isLeaderTwo;
    }

    public Boolean getIsClassManager() {
        return isClassManager;
    }

    public void setIsClassManager(Boolean isClassManager) {
        this.isClassManager = isClassManager;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getSysStatus() {
        return sysStatus;
    }

    public void setSysStatus(String sysStatus) {
        this.sysStatus = sysStatus == null ? null : sysStatus.trim();
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