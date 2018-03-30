package com.chinayouthedu.zqzc.entity.paike;

import com.chinayouthedu.zqzc.config.core.BaseBean;
import java.io.Serializable;
import java.util.Date;

/**
 * 节次规则表
 * @表名称 timetable_rule
 * @开发日期 2018-03-20 01:25:42
 * @开发作者 :中青至诚教育咨询有限公司 
 */
public class TimetableRule extends BaseBean implements Serializable {
    /**  (主健ID) (无默认值) */
    private Long id;

    /** @desc 每天上课节数(可选项) (无默认值) */
    private Integer courseNum;

    /** @desc 每节课时长(可选项) (无默认值) */
    private Integer courseLength;

    /** @desc 第一节课开始时间(可选项) (无默认值) */
    private String firstCourseTime;

    /** @desc 课间操在第几节课后边(可选项) (无默认值) */
    private Integer gymnasticsSort;

    /** @desc 课间操时长(可选项) (无默认值) */
    private Integer gymnasticsLength;

    /** @desc 下午第一节课开始时间(可选项) (无默认值) */
    private String pmFirstCourseTime;

    /** @desc 下午第一节课开始节次(可选项) (无默认值) */
    private Integer pmFirstCourseSort;

    /** @desc 课间休息时间(可选项) (无默认值) */
    private Integer recess;

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

    public Integer getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(Integer courseNum) {
        this.courseNum = courseNum;
    }

    public Integer getCourseLength() {
        return courseLength;
    }

    public void setCourseLength(Integer courseLength) {
        this.courseLength = courseLength;
    }

    public String getFirstCourseTime() {
        return firstCourseTime;
    }

    public void setFirstCourseTime(String firstCourseTime) {
        this.firstCourseTime = firstCourseTime == null ? null : firstCourseTime.trim();
    }

    public Integer getGymnasticsSort() {
        return gymnasticsSort;
    }

    public void setGymnasticsSort(Integer gymnasticsSort) {
        this.gymnasticsSort = gymnasticsSort;
    }

    public Integer getGymnasticsLength() {
        return gymnasticsLength;
    }

    public void setGymnasticsLength(Integer gymnasticsLength) {
        this.gymnasticsLength = gymnasticsLength;
    }

    public String getPmFirstCourseTime() {
        return pmFirstCourseTime;
    }

    public void setPmFirstCourseTime(String pmFirstCourseTime) {
        this.pmFirstCourseTime = pmFirstCourseTime == null ? null : pmFirstCourseTime.trim();
    }

    public Integer getPmFirstCourseSort() {
        return pmFirstCourseSort;
    }

    public void setPmFirstCourseSort(Integer pmFirstCourseSort) {
        this.pmFirstCourseSort = pmFirstCourseSort;
    }

    public Integer getRecess() {
        return recess;
    }

    public void setRecess(Integer recess) {
        this.recess = recess;
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