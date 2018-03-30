package com.chinayouthedu.zqzc.entity.paike;

import com.chinayouthedu.zqzc.config.core.BaseBean;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @表名称 teacher_group
 * @开发日期 2018-03-19 03:34:18
 * @开发作者 :中青至诚教育咨询有限公司 
 */
public class TeacherGroup extends BaseBean implements Serializable {
    /**  (主健ID) (无默认值) */
    private Long id;

    /** @desc 教研组名称(可选项) (无默认值) */
    private String tgName;

    /** @desc 教研组组长的ID(可选项) (无默认值) */
    private Long tgLeaderId;

    /** 教研组组长(可选项) (无默认值) */
    private String tgLeader;

    /** @desc  教研组副组长的ID(可选项) (无默认值) */
    private Long tgLeaderTwoId;

    /** 教研组副组长(可选项) (无默认值) */
    private String tgLeaderTwo;

    /** @desc 教研组课程组长的ID(可选项) (无默认值) */
    private Long tgLessonLeaderId;

    /** @desc 教研组课程组长的名字(可选项) (无默认值) */
    private String tgLessonLeader;

    /** 教研组内教师数量(可选项) (无默认值) */
    private Integer tgTeacherNumber;

    /** 教研组编号(可选项) (无默认值) */
    private String tgCode;

    /** 教研组关联的课程code ,来自字典表(可选项) (无默认值) */
    private String courseDiscipline;

    /**  (无默认值) */
    private String tgCourseName;

    /** @desc 教研组开始时间(可选项) (无默认值) */
    private Date tgStartTime;

    /** @desc 教研组结束时间(可选项) (无默认值) */
    private Date tgEndTime;

    /** @desc 数据创建时间(可选项) (无默认值) */
    private Date createTime;

    /** @desc 数据最后更改时间(可选项) (无默认值) */
    private Date updateTime;

    /** @desc 教研组当前状态(可选项) (无默认值) */
    private String status;

    /** @desc 预留字段(可选项) (无默认值) */
    private String sysStatus;

    /** @desc 数据当前是否有效(可选项) (无默认值) */
    private Boolean effective;

    private List<CourseTgroup> ctList;




	public List<CourseTgroup> getCtList() {
		return ctList;
	}

	public void setCtList(List<CourseTgroup> ctList) {
		this.ctList = ctList;
	}

	private static final long serialVersionUID = 1L;

	
	
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTgName() {
        return tgName;
    }

    public void setTgName(String tgName) {
        this.tgName = tgName == null ? null : tgName.trim();
    }

    public Long getTgLeaderId() {
        return tgLeaderId;
    }

    public void setTgLeaderId(Long tgLeaderId) {
        this.tgLeaderId = tgLeaderId;
    }

    public String getTgLeader() {
        return tgLeader;
    }

    public void setTgLeader(String tgLeader) {
        this.tgLeader = tgLeader == null ? null : tgLeader.trim();
    }

    public Long getTgLeaderTwoId() {
        return tgLeaderTwoId;
    }

    public void setTgLeaderTwoId(Long tgLeaderTwoId) {
        this.tgLeaderTwoId = tgLeaderTwoId;
    }

    public String getTgLeaderTwo() {
        return tgLeaderTwo;
    }

    public void setTgLeaderTwo(String tgLeaderTwo) {
        this.tgLeaderTwo = tgLeaderTwo == null ? null : tgLeaderTwo.trim();
    }

    public Long getTgLessonLeaderId() {
        return tgLessonLeaderId;
    }

    public void setTgLessonLeaderId(Long tgLessonLeaderId) {
        this.tgLessonLeaderId = tgLessonLeaderId;
    }

    public String getTgLessonLeader() {
        return tgLessonLeader;
    }

    public void setTgLessonLeader(String tgLessonLeader) {
        this.tgLessonLeader = tgLessonLeader == null ? null : tgLessonLeader.trim();
    }

    public Integer getTgTeacherNumber() {
        return tgTeacherNumber;
    }

    public void setTgTeacherNumber(Integer tgTeacherNumber) {
        this.tgTeacherNumber = tgTeacherNumber;
    }

    public String getTgCode() {
        return tgCode;
    }

    public void setTgCode(String tgCode) {
        this.tgCode = tgCode == null ? null : tgCode.trim();
    }

    public String getCourseDiscipline() {
        return courseDiscipline;
    }

    public void setCourseDiscipline(String courseDiscipline) {
        this.courseDiscipline = courseDiscipline == null ? null : courseDiscipline.trim();
    }

    public String getTgCourseName() {
        return tgCourseName;
    }

    public void setTgCourseName(String tgCourseName) {
        this.tgCourseName = tgCourseName == null ? null : tgCourseName.trim();
    }

    public Date getTgStartTime() {
        return tgStartTime;
    }

    public void setTgStartTime(Date tgStartTime) {
        this.tgStartTime = tgStartTime;
    }

    public Date getTgEndTime() {
        return tgEndTime;
    }

    public void setTgEndTime(Date tgEndTime) {
        this.tgEndTime = tgEndTime;
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

    public Boolean getEffective() {
        return effective;
    }

    public void setEffective(Boolean effective) {
        this.effective = effective;
    }
}