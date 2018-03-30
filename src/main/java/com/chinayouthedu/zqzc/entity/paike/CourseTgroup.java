package com.chinayouthedu.zqzc.entity.paike;

import com.chinayouthedu.zqzc.config.core.BaseBean;
import java.io.Serializable;
import java.util.Date;

/**
 * @表名称 course_tgroup
 * @开发日期 2018-03-07 04:10:19
 * @开发作者 :中青至诚教育咨询有限公司 
 */
public class CourseTgroup extends BaseBean implements Serializable {
    /**  (主健ID) (无默认值) */
    private Long id;

    /** 课程Id(可选项) (无默认值) */
    private Long courseId;

    /** @desc 课程名称
@redu 冗余字段(可选项) (无默认值) */
    private String courseName;

    /** 教研组id(可选项) (无默认值) */
    private Long tgroupId;

    /** @desc 教研组名称
@redu 冗余字段(可选项) (无默认值) */
    private String tgroupName;

    /** @desc 数据创建时间(可选项) (无默认值) */
    private Date createTime;

    /** @desc 数据最后更新时间(可选项) (无默认值) */
    private Date updateTime;

    /** @desc 当前是否有效，布尔值(可选项) (无默认值) */
    private Boolean effective;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getTgroupId() {
        return tgroupId;
    }

    public void setTgroupId(Long tgroupId) {
        this.tgroupId = tgroupId;
    }

    public String getTgroupName() {
        return tgroupName;
    }

    public void setTgroupName(String tgroupName) {
        this.tgroupName = tgroupName == null ? null : tgroupName.trim();
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