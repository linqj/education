package com.chinayouthedu.zqzc.entity.paike;

import com.chinayouthedu.zqzc.config.core.BaseBean;
import java.io.Serializable;
import java.util.Date;

/**
 * @表名称 semester
 * @开发日期 2018-03-08 06:03:03
 * @开发作者 :中青至诚教育咨询有限公司 
 */
public class Semester extends BaseBean implements Serializable {
    /**  (主健ID) (无默认值) */
    private Long id;

    /** @desc 学期编号(可选项) (无默认值) */
    private String semesterCode;

    /** 学期名称(可选项) (无默认值) */
    private String semesterName;

    /** @desc 学年ID(可选项) (无默认值) */
    private Long schoolYearId;

    /** 学期开始时间(可选项) (无默认值) */
    private Date startTime;

    /** 学期结束时间(可选项) (无默认值) */
    private Date endTime;

    /** 学期类型,0:上学期, 1:下学期(可选项) (无默认值) */
    private String semesterType;

    /** 创建时间(可选项)  (默认值为: CURRENT_TIMESTAMP) */
    private Date createTime;

    /** 更新时间(可选项) (无默认值) */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSemesterCode() {
        return semesterCode;
    }

    public void setSemesterCode(String semesterCode) {
        this.semesterCode = semesterCode == null ? null : semesterCode.trim();
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName == null ? null : semesterName.trim();
    }

    public Long getSchoolYearId() {
        return schoolYearId;
    }

    public void setSchoolYearId(Long schoolYearId) {
        this.schoolYearId = schoolYearId;
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

    public String getSemesterType() {
        return semesterType;
    }

    public void setSemesterType(String semesterType) {
        this.semesterType = semesterType == null ? null : semesterType.trim();
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
}