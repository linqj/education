package com.chinayouthedu.zqzc.entity.paike;

import com.chinayouthedu.zqzc.config.core.BaseBean;
import java.io.Serializable;
import java.util.Date;

/**
 * @表名称 course
 * @开发日期 2018-03-20 06:21:09
 * @开发作者 :中青至诚教育咨询有限公司 
 */
public class Course extends BaseBean implements Serializable {
    /**  (主健ID) (无默认值) */
    private Long id;

    /** @desc 年级id(可选项) (无默认值) */
    private Long gradeId;

    /** @desc 年级名称(可选项) (无默认值) */
    private String gradeName;

    /** @desc 年级代码(可选项) (无默认值) */
    private String gradeCode;

    /** @desc 学科(可选项) (无默认值) */
    private String courseDiscipline;

    /** @desc 学科名称(可选项) (无默认值) */
    private String disciplineName;

    /** @desc 课程名称(可选项) (无默认值) */
    private String courseName;

    /** @desc 课程编号(可选项) (无默认值) */
    private String courseNumber;

    /** @desc 课程类型(可选项) (无默认值) */
    private String courseType;

    /** @desc 课程时长（单位：分钟）(可选项) (无默认值) */
    private Integer courseLength;

    /** @desc 课程计划总学时（单位：分钟，如果需要转成小时请在JAVA代码中转化）(可选项) (无默认值) */
    private Integer coursePlanLength;

    /** @desc 课程级别(可选项) (无默认值) */
    private Integer courseLevel;

    /** @desc 课程是固定班级上课还是走班上课，布尔值，true表示传统固定班级，false表示走班上课(必填项) (无默认值) */
    private Boolean courseTypeFixed;

    /** 课程状态(可选项) (无默认值) */
    private String courseStatus;

    /** 系统状态(可选项) (无默认值) */
    private String sysStatus;

    /** 创建时间(可选项) (无默认值) */
    private Date createTime;

    /** 更新时间(可选项) (无默认值) */
    private Date updateTime;

    /** @desc 该记录在当前是否有效，布尔值（通过此值可以用作伪删除，日后可以进行分析）(可选项) (无默认值) */
    private Boolean effective;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode == null ? null : gradeCode.trim();
    }

    public String getCourseDiscipline() {
        return courseDiscipline;
    }

    public void setCourseDiscipline(String courseDiscipline) {
        this.courseDiscipline = courseDiscipline == null ? null : courseDiscipline.trim();
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName == null ? null : disciplineName.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber == null ? null : courseNumber.trim();
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType == null ? null : courseType.trim();
    }

    public Integer getCourseLength() {
        return courseLength;
    }

    public void setCourseLength(Integer courseLength) {
        this.courseLength = courseLength;
    }

    public Integer getCoursePlanLength() {
        return coursePlanLength;
    }

    public void setCoursePlanLength(Integer coursePlanLength) {
        this.coursePlanLength = coursePlanLength;
    }

    public Integer getCourseLevel() {
        return courseLevel;
    }

    public void setCourseLevel(Integer courseLevel) {
        this.courseLevel = courseLevel;
    }

    public Boolean getCourseTypeFixed() {
        return courseTypeFixed;
    }

    public void setCourseTypeFixed(Boolean courseTypeFixed) {
        this.courseTypeFixed = courseTypeFixed;
    }

    public String getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(String courseStatus) {
        this.courseStatus = courseStatus == null ? null : courseStatus.trim();
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

    public Boolean getEffective() {
        return effective;
    }

    public void setEffective(Boolean effective) {
        this.effective = effective;
    }
}
