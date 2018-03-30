package com.chinayouthedu.zqzc.entity.paike;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    private Long id;

    private String stuName;

    private String stuGender;

    private Date stuBirthday;

    private String stuPhone;

    private String stuEmail;

    private String stuIdcard;

    private String stuNumber;

    private String stuHomeAddress;

    private Boolean effective;

    private Date stuStartTime;

    private Date stuEndTime;

    private String stuSchoolPost;

    private String stuClassPost;

    private Date createTime;

    private Date updateTime;

    private String stuHostel;

    private String remark;

    private String stuLevel;

    private Long classId;

    private String className;

    private Long gradeId;

    private String gradeName;



    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender == null ? null : stuGender.trim();
    }

    public Date getStuBirthday() {
        return stuBirthday;
    }

    public void setStuBirthday(Date stuBirthday) {
        this.stuBirthday = stuBirthday;
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone == null ? null : stuPhone.trim();
    }

    public String getStuEmail() {
        return stuEmail;
    }

    public void setStuEmail(String stuEmail) {
        this.stuEmail = stuEmail == null ? null : stuEmail.trim();
    }

    public String getStuIdcard() {
        return stuIdcard;
    }

    public void setStuIdcard(String stuIdcard) {
        this.stuIdcard = stuIdcard == null ? null : stuIdcard.trim();
    }

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber == null ? null : stuNumber.trim();
    }

    public String getStuHomeAddress() {
        return stuHomeAddress;
    }

    public void setStuHomeAddress(String stuHomeAddress) {
        this.stuHomeAddress = stuHomeAddress == null ? null : stuHomeAddress.trim();
    }

    public Boolean getEffective() {
        return effective;
    }

    public void setEffective(Boolean effective) {
        this.effective = effective;
    }

    public Date getStuStartTime() {
        return stuStartTime;
    }

    public void setStuStartTime(Date stuStartTime) {
        this.stuStartTime = stuStartTime;
    }

    public Date getStuEndTime() {
        return stuEndTime;
    }

    public void setStuEndTime(Date stuEndTime) {
        this.stuEndTime = stuEndTime;
    }

    public String getStuSchoolPost() {
        return stuSchoolPost;
    }

    public void setStuSchoolPost(String stuSchoolPost) {
        this.stuSchoolPost = stuSchoolPost == null ? null : stuSchoolPost.trim();
    }

    public String getStuClassPost() {
        return stuClassPost;
    }

    public void setStuClassPost(String stuClassPost) {
        this.stuClassPost = stuClassPost == null ? "" : stuClassPost.trim();
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

    public String getStuHostel() {
        return stuHostel;
    }

    public void setStuHostel(String stuHostel) {
        this.stuHostel = stuHostel == null ? null : stuHostel.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getStuLevel() {
        return stuLevel;
    }

    public void setStuLevel(String stuLevel) {
        this.stuLevel = stuLevel == null ? null : stuLevel.trim();
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName == null ? null : gradeName.trim();
    }

    // 自定义
    private String stuGenderShow = "";
    private String stuClassPostShow = "";
    private String stuLevelShow = "";

    public String getStuGenderShow() {
        return stuGenderShow==null?"":stuGenderShow.trim();
    }

    public void setStuGenderShow(String stuGenderShow) {
        this.stuGenderShow = stuGenderShow;
    }

    public String getStuClassPostShow() {
        return stuClassPostShow==null?"":stuClassPostShow.trim();
    }

    public void setStuClassPostShow(String stuClassPostShow) {
        this.stuClassPostShow = stuClassPostShow;
    }

    public String getStuLevelShow() {
        return stuLevelShow==null?"":stuLevelShow.trim();
    }

    public void setStuLevelShow(String stuLevelShow) {
        this.stuLevelShow = stuLevelShow;
    }

}