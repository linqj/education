package com.chinayouthedu.zqzc.entity.paike;

import com.chinayouthedu.zqzc.config.core.BaseBean;
import java.io.Serializable;
import java.util.Date;

/**
 * @表名称 teacher_coursetime
 * @开发日期 2018-03-29 02:12:34
 * @开发作者 :中青至诚教育咨询有限公司 
 */
public class TeacherCoursetime extends BaseBean implements Serializable {
    /**  (主健ID) (无默认值) */
    private Long id;

    /** @desc 学年id(可选项) (无默认值) */
    private Long schoolYearId;

    /** @desc 学年名称(可选项) (无默认值) */
    private String schoolYearName;

    /** @desc 学期id(可选项) (无默认值) */
    private Long semesterId;

    /** @desc 学期名称(可选项) (无默认值) */
    private String semesterName;

    /** @desc 教研组id(可选项) (无默认值) */
    private Long teacherGroupId;

    /** @desc 教研组名(可选项) (无默认值) */
    private String teacherGroupName;

    /** @desc 教师id(可选项) (无默认值) */
    private Long teacherId;

    /** @desc 教师名称(可选项) (无默认值) */
    private String teacherName;

    /** @desc 教师总学时(可选项) (无默认值) */
    private Integer allLearnTime;

    /** @desc 教师周学时(可选项) (无默认值) */
    private Integer weekLearnTime;

    /** 最少周学时(可选项) (无默认值) */
    private Integer minWeekLearnTime;

    /** 最多周学时(可选项) (无默认值) */
    private Integer maxWeekLearnTime;

    /** @desc 实际安排课时(可选项) (无默认值) */
    private Integer actualCourseTime;

    /** 教授班级数量(可选项) (无默认值) */
    private Integer teachClassNumber;

    /** @desc 创建时间(可选项)  (默认值为: CURRENT_TIMESTAMP) */
    private Date createTime;

    /** @desc 更新时间(可选项) (无默认值) */
    private Date updateTime;

    /** @desc 系统状态(可选项) (无默认值) */
    private String systemStatus;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSchoolYearId() {
        return schoolYearId;
    }

    public void setSchoolYearId(Long schoolYearId) {
        this.schoolYearId = schoolYearId;
    }

    public String getSchoolYearName() {
        return schoolYearName;
    }

    public void setSchoolYearName(String schoolYearName) {
        this.schoolYearName = schoolYearName == null ? null : schoolYearName.trim();
    }

    public Long getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Long semesterId) {
        this.semesterId = semesterId;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName == null ? null : semesterName.trim();
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

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public Integer getAllLearnTime() {
        return allLearnTime;
    }

    public void setAllLearnTime(Integer allLearnTime) {
        this.allLearnTime = allLearnTime;
    }

    public Integer getWeekLearnTime() {
        return weekLearnTime;
    }

    public void setWeekLearnTime(Integer weekLearnTime) {
        this.weekLearnTime = weekLearnTime;
    }

    public Integer getMinWeekLearnTime() {
        return minWeekLearnTime;
    }

    public void setMinWeekLearnTime(Integer minWeekLearnTime) {
        this.minWeekLearnTime = minWeekLearnTime;
    }

    public Integer getMaxWeekLearnTime() {
        return maxWeekLearnTime;
    }

    public void setMaxWeekLearnTime(Integer maxWeekLearnTime) {
        this.maxWeekLearnTime = maxWeekLearnTime;
    }

    public Integer getActualCourseTime() {
        return actualCourseTime;
    }

    public void setActualCourseTime(Integer actualCourseTime) {
        this.actualCourseTime = actualCourseTime;
    }

    public Integer getTeachClassNumber() {
        return teachClassNumber;
    }

    public void setTeachClassNumber(Integer teachClassNumber) {
        this.teachClassNumber = teachClassNumber;
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

    public String getSystemStatus() {
        return systemStatus;
    }

    public void setSystemStatus(String systemStatus) {
        this.systemStatus = systemStatus == null ? null : systemStatus.trim();
    }
}