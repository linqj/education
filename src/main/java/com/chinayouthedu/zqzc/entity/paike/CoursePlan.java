package com.chinayouthedu.zqzc.entity.paike;

import com.chinayouthedu.zqzc.config.core.BaseBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @表名称 course_plan
 * @开发日期 2018-03-29 10:04:32
 * @开发作者 :中青至诚教育咨询有限公司 
 */
@JsonIgnoreProperties(ignoreUnknown = true)//解决反序列化问题
public class CoursePlan extends BaseBean implements Serializable {
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

    /** @desc 年级id(可选项) (无默认值) */
    private Long gradeId;

    /** @desc 年级名称(可选项) (无默认值) */
    private String gradeName;

    /** @desc 课程id(可选项) (无默认值) */
    private Long courseId;

    /** @desc 课程名称(可选项) (无默认值) */
    private String courseName;

    /** @desc 学科编码(可选项) (无默认值) */
    private String courseDiscipline;

    /** @desc 学科名称(可选项) (无默认值) */
    private String disciplineName;

    /** @desc 学期学时(可选项) (无默认值) */
    private Integer semesterLearnTime;

    /** @desc 周学时(可选项) (无默认值) */
    private Integer weekLearnTime;

    /** @desc 授课教师id,以逗号分隔(可选项)  (默认值为: ) */
    private String courseTeacher;

    /** @desc 创建时间(可选项)  (默认值为: CURRENT_TIMESTAMP) */
    private Date createTime;

    /** @desc 更新时间(可选项) (无默认值) */
    private Date updateTime;

    /** @desc 系统状态(可选项) (无默认值) */
    private String systemStatus;

    private List<CoursePlan> childlist;

    public List<CoursePlan> getChildlist() {
        return childlist;
    }

    public void setChildlist(List<CoursePlan> childlist) {
        this.childlist = childlist;
    }

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

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
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

    public Integer getSemesterLearnTime() {
        return semesterLearnTime;
    }

    public void setSemesterLearnTime(Integer semesterLearnTime) {
        this.semesterLearnTime = semesterLearnTime;
    }

    public Integer getWeekLearnTime() {
        return weekLearnTime;
    }

    public void setWeekLearnTime(Integer weekLearnTime) {
        this.weekLearnTime = weekLearnTime;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher == null ? null : courseTeacher.trim();
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