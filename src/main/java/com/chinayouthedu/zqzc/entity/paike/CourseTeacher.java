package com.chinayouthedu.zqzc.entity.paike;

import com.chinayouthedu.zqzc.config.core.BaseBean;
import java.io.Serializable;
import java.util.Date;

/**
 * @表名称 course_teacher
 * @开发日期 2018-03-07 04:10:19
 * @开发作者 :中青至诚教育咨询有限公司 
 */
public class CourseTeacher extends BaseBean implements Serializable {
    /** @desc 课程和教师关系表的主键 (主健ID) (无默认值) */
    private Long id;

    /** @desc 教师ID(可选项) (无默认值) */
    private Long teacherId;

    /** @desc 课程ID(可选项) (无默认值) */
    private Long courseId;

    /** @desc 数据创建时间(可选项) (无默认值) */
    private Date createTime;

    /** @desc 数据最后更新时间(可选项) (无默认值) */
    private Date updateTime;

    /** @desc 数据在当前是否有效(可选项) (无默认值) */
    private Boolean effective;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
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