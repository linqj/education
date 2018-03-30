package com.chinayouthedu.zqzc.entity.paike;

import java.io.Serializable;
import java.util.Date;

public class Cla implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String claName;

    private Date startDate;

    private Date endDate;

    private Boolean effictive;

    private String classCode;

    private Long classGradeId;

    private String classGradeName;

    private Short classPlanStuNum;

    private Short classStuNum;

    private String status;

    private String sysStatus;

    private Date createTime;

    private Date updateTime;

    private String classType;

    private Long keyClassroomId;

    private String keyClassroomName;

    private Long keyClassroomBuldingId;

    private String keyClassroomBuldingName;

    private Long teacher1Id;

    private String teacher1Name;

    private Long teacher2Id;

    private String teacher2Name;

    private Long schoolYearId;

    private Long semesterId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClaName() {
        return claName;
    }

    public void setClaName(String claName) {
        this.claName = claName == null ? null : claName.trim();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Boolean getEffictive() {
        return effictive;
    }

    public void setEffictive(Boolean effictive) {
        this.effictive = effictive;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode == null ? null : classCode.trim();
    }

    public Long getClassGradeId() {
        return classGradeId;
    }

    public void setClassGradeId(Long classGradeId) {
        this.classGradeId = classGradeId;
    }

    public String getClassGradeName() {
        return classGradeName;
    }

    public void setClassGradeName(String classGradeName) {
        this.classGradeName = classGradeName == null ? null : classGradeName.trim();
    }

    public Short getClassPlanStuNum() {
        return classPlanStuNum;
    }

    public void setClassPlanStuNum(Short classPlanStuNum) {
        this.classPlanStuNum = classPlanStuNum;
    }

    public Short getClassStuNum() {
        return classStuNum;
    }

    public void setClassStuNum(Short classStuNum) {
        this.classStuNum = classStuNum;
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

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType == null ? null : classType.trim();
    }

    public Long getKeyClassroomId() {
        return keyClassroomId;
    }

    public void setKeyClassroomId(Long keyClassroomId) {
        this.keyClassroomId = keyClassroomId;
    }

    public String getKeyClassroomName() {
        return keyClassroomName;
    }

    public void setKeyClassroomName(String keyClassroomName) {
        this.keyClassroomName = keyClassroomName == null ? null : keyClassroomName.trim();
    }

    public Long getKeyClassroomBuldingId() {
        return keyClassroomBuldingId;
    }

    public void setKeyClassroomBuldingId(Long keyClassroomBuldingId) {
        this.keyClassroomBuldingId = keyClassroomBuldingId;
    }

    public String getKeyClassroomBuldingName() {
        return keyClassroomBuldingName;
    }

    public void setKeyClassroomBuldingName(String keyClassroomBuldingName) {
        this.keyClassroomBuldingName = keyClassroomBuldingName == null ? null : keyClassroomBuldingName.trim();
    }

    public Long getTeacher1Id() {
        return teacher1Id;
    }

    public void setTeacher1Id(Long teacher1Id) {
        this.teacher1Id = teacher1Id;
    }

    public String getTeacher1Name() {
        return teacher1Name;
    }

    public void setTeacher1Name(String teacher1Name) {
        this.teacher1Name = teacher1Name == null ? null : teacher1Name.trim();
    }

    public Long getTeacher2Id() {
        return teacher2Id;
    }

    public void setTeacher2Id(Long teacher2Id) {
        this.teacher2Id = teacher2Id;
    }

    public String getTeacher2Name() {
        return teacher2Name;
    }

    public void setTeacher2Name(String teacher2Name) {
        this.teacher2Name = teacher2Name == null ? null : teacher2Name.trim();
    }

    public Long getSchoolYearId() {
        return schoolYearId;
    }

    public void setSchoolYearId(Long schoolYearId) {
        this.schoolYearId = schoolYearId;
    }

    public Long getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Long semesterId) {
        this.semesterId = semesterId;
    }

    /*
     * 非数据库字段属性
     */

    private String schoolYearName;  // 学年名称
    private String semesterName;    // 学期名称

    public String getSchoolYearName() {
        return schoolYearName;
    }

    public void setSchoolYearName(String schoolYearName) {
        this.schoolYearName = schoolYearName;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    /*
     * 非数据库字段属性END
     */
}