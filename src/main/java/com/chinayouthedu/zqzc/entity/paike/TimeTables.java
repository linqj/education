package com.chinayouthedu.zqzc.entity.paike;

import com.chinayouthedu.zqzc.config.core.BaseBean;
import java.io.Serializable;
import java.util.Date;

/**
 * @表名称 time_tables
 * @开发日期 2018-03-20 03:29:15
 * @开发作者 :中青至诚教育咨询有限公司 
 */
public class TimeTables extends BaseBean implements Serializable {
    /**  (主健ID) (无默认值) */
    private Long id;

    /** @desc 节次数(可选项) (无默认值) */
    private Integer sort;

    /** @desc 节次名称(可选项) (无默认值) */
    private String name;

    /** @desc 开始时间(可选项) (无默认值) */
    private String startTime;

    /** @desc 结束时间(可选项) (无默认值) */
    private String endTime;

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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
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