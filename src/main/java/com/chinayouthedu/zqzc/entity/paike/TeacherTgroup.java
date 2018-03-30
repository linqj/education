package com.chinayouthedu.zqzc.entity.paike;

import com.chinayouthedu.zqzc.config.core.BaseBean;
import java.io.Serializable;
import java.util.Date;

/**
 * @表名称 teacher_tgroup
 * @开发日期 2018-03-07 04:10:19
 * @开发作者 :中青至诚教育咨询有限公司 
 */
public class TeacherTgroup extends BaseBean implements Serializable {
    /** @desc 主键 (主健ID) (无默认值) */
    private Long id;

    /** @desc 教师ID(必填项) (无默认值) */
    private String teacherId;

    /** 教师姓名(必填项) (无默认值) */
    private String teacherName;

    /** @desc 教研组ID(必填项) (无默认值) */
    private Long tgroupId;

    /** @desc 教研组编号(可选项) (无默认值) */
    private String tgroupNumber;

    /** @desc 教研组名称(必填项) (无默认值) */
    private String tgroupName;

    /** 教师在教研组内的职务(必填项) (无默认值) */
    private String teacherPost;

    /** @desc 教师-教研组关系开始时间(必填项) (无默认值) */
    private Date startTime;

    /** @desc 教师_教研组关系结束时间(可选项) (无默认值) */
    private Date endTime;

    /** @desc 数据在当前是否有效(必填项) (无默认值) */
    private Byte effective;

    /** 数据记录创建时间(必填项) (无默认值) */
    private Date createTime;

    /** 数据记录更新时间(必填项) (无默认值) */
    private Date updateTime;

    /** 记录当前的状态（是否有效）(可选项) (无默认值) */
    private String status;

    /** @desc 预留字段，系统状态(可选项) (无默认值) */
    private String sysStatus;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public Long getTgroupId() {
        return tgroupId;
    }

    public void setTgroupId(Long tgroupId) {
        this.tgroupId = tgroupId;
    }

    public String getTgroupNumber() {
        return tgroupNumber;
    }

    public void setTgroupNumber(String tgroupNumber) {
        this.tgroupNumber = tgroupNumber == null ? null : tgroupNumber.trim();
    }

    public String getTgroupName() {
        return tgroupName;
    }

    public void setTgroupName(String tgroupName) {
        this.tgroupName = tgroupName == null ? null : tgroupName.trim();
    }

    public String getTeacherPost() {
        return teacherPost;
    }

    public void setTeacherPost(String teacherPost) {
        this.teacherPost = teacherPost == null ? null : teacherPost.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Byte getEffective() {
        return effective;
    }

    public void setEffective(Byte effective) {
        this.effective = effective;
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
}