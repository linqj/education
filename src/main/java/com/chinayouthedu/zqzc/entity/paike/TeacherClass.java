package com.chinayouthedu.zqzc.entity.paike;

import com.chinayouthedu.zqzc.config.core.BaseBean;
import java.io.Serializable;
import java.util.Date;

/**
 * @表名称 teacher_class
 * @开发日期 2018-03-07 04:10:19
 * @开发作者 :中青至诚教育咨询有限公司 
 */
public class TeacherClass extends BaseBean implements Serializable {
    /** @desc 教师-班级的关系表的主键 (主健ID) (无默认值) */
    private Long id;

    /** @desc 教师工号(必填项) (无默认值) */
    private String teacherNumber;

    /** @desc 班级编号(必填项) (无默认值) */
    private String classNumber;

    /** @desc 教师在班级的职务（班主任/语文教师/...）(可选项) (无默认值) */
    private String teacherClassPost;

    /** @desc 教师-班级的关系开始时间(必填项) (无默认值) */
    private Date startTime;

    /** @desc 教师-班级的结束时间(可选项) (无默认值) */
    private Date endTime;

    /** @desc 数据在当前是否有效(必填项) (无默认值) */
    private Byte effective;

    /** @desc 数据创建时间(必填项) (无默认值) */
    private Date createTime;

    /** @desc 数据更改时间(可选项) (无默认值) */
    private Date updateTime;

    /** @desc 预留字段，状态(可选项) (无默认值) */
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

    public String getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(String teacherNumber) {
        this.teacherNumber = teacherNumber == null ? null : teacherNumber.trim();
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber == null ? null : classNumber.trim();
    }

    public String getTeacherClassPost() {
        return teacherClassPost;
    }

    public void setTeacherClassPost(String teacherClassPost) {
        this.teacherClassPost = teacherClassPost == null ? null : teacherClassPost.trim();
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