package com.chinayouthedu.zqzc.entity.paike;

import com.chinayouthedu.zqzc.config.core.BaseBean;
import java.io.Serializable;
import java.util.Date;

/**
 * @表名称 zczx_ugroup
 * @开发日期 2018-03-12 11:09:49
 * @开发作者 :中青至诚教育咨询有限公司 
 */
public class Ugroup extends BaseBean implements Serializable {
    /** id (主健ID) (无默认值) */
    private Long id;

    /** 父用户组的ID(可选项) (无默认值) */
    private Long parentId;

    /** 用户组的ID(可选项) (无默认值) */
    private String ugroupName;

    /** 用户组的状态(可选项) (无默认值) */
    private String uproupStatus;

    /** 系统状态(可选项) (无默认值) */
    private String sysStatus;

    /** 用户组序号(可选项) (无默认值) */
    private Long ugroupSort;

    /** 创建时间(可选项) (无默认值) */
    private Date createTime;

    /** 更新时间(可选项) (无默认值) */
    private Date updateTime;

    /** 备注(可选项) (无默认值) */
    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getUgroupName() {
        return ugroupName;
    }

    public void setUgroupName(String ugroupName) {
        this.ugroupName = ugroupName == null ? null : ugroupName.trim();
    }

    public String getUproupStatus() {
        return uproupStatus;
    }

    public void setUproupStatus(String uproupStatus) {
        this.uproupStatus = uproupStatus == null ? null : uproupStatus.trim();
    }

    public String getSysStatus() {
        return sysStatus;
    }

    public void setSysStatus(String sysStatus) {
        this.sysStatus = sysStatus == null ? null : sysStatus.trim();
    }

    public Long getUgroupSort() {
        return ugroupSort;
    }

    public void setUgroupSort(Long ugroupSort) {
        this.ugroupSort = ugroupSort;
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