package com.chinayouthedu.zqzc.entity.paike;

import com.chinayouthedu.zqzc.config.core.BaseBean;
import java.io.Serializable;
import java.util.Date;

/**
 * @表名称 grade_class
 * @开发日期 2018-03-07 04:10:19
 * @开发作者 :中青至诚教育咨询有限公司 
 */
public class GradeClass extends BaseBean implements Serializable {
    /**  (主健ID) (无默认值) */
    private Long id;

    /** @desc 年级的ID
@fk grade表的id
(必填项) (无默认值) */
    private Long gradeId;

    /** @desc 年级的名称(必填项) (无默认值) */
    private String gradeName;

    /** @desc 班级的ID
@fk class表的id(必填项) (无默认值) */
    private Long classId;

    /** @desc 班级的名称
@fk class表的class_name(必填项) (无默认值) */
    private String className;

    /** @desc 班级的开班时间(必填项) (无默认值) */
    private Date startTime;

    /** @desc 班级的结班时间(可选项) (无默认值) */
    private Date endTime;

    /** @desc 数据当前是否有效(必填项) (无默认值) */
    private Boolean effictive;

    /** @desc 数据的创建时间(必填项) (无默认值) */
    private Date createTime;

    /** @desc 数据的最后更新时间(必填项) (无默认值) */
    private Date updateTime;

    /** @desc 备注(必填项)  (默认值为: ) */
    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
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

    public Boolean getEffictive() {
        return effictive;
    }

    public void setEffictive(Boolean effictive) {
        this.effictive = effictive;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}