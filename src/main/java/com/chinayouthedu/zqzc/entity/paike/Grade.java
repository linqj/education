package com.chinayouthedu.zqzc.entity.paike;

import java.io.Serializable;
import java.util.Date;

public class Grade implements Serializable {

	private Long id;

    private String gradeName;

    private String gradeCode;

    private Integer gradeTotalStuNum;

    private Integer gradeTotalClassNum;

    private Date startDate;

    private Date endDate;

    private Boolean effective;

    private Date createTime;

    private Date updateTime;

    private String gradeType;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName == null ? null : gradeName.trim();
    }

    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode == null ? null : gradeCode.trim();
    }

    public Integer getGradeTotalStuNum() {
        return gradeTotalStuNum;
    }

    public void setGradeTotalStuNum(Integer gradeTotalStuNum) {
        this.gradeTotalStuNum = gradeTotalStuNum;
    }

    public Integer getGradeTotalClassNum() {
        return gradeTotalClassNum;
    }

    public void setGradeTotalClassNum(Integer gradeTotalClassNum) {
        this.gradeTotalClassNum = gradeTotalClassNum;
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

    public Boolean getEffective() {
        return effective;
    }

    public void setEffective(Boolean effective) {
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

    public String getGradeType() {
        return gradeType;
    }

    public void setGradeType(String gradeType) {
        this.gradeType = gradeType == null ? null : gradeType.trim();
    }
}