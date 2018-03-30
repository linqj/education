package com.chinayouthedu.zqzc.entity.paike;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.chinayouthedu.zqzc.config.core.BaseBean;

/**
 * @表名称 classroom_building
 * @开发日期 2018-03-26 06:40:17
 * @开发作者 :中青至诚教育咨询有限公司 
 */
public class ClassroomBuilding extends BaseBean implements Serializable {
    /**  (主健ID) (无默认值) */
    private Long id;

    /** @desc 教学楼名称(可选项) (无默认值) */
    private String buildingName;

    /** @desc 教学楼编号(可选项) (无默认值) */
    private String buildingNumber;

    /** @desc 教学楼用途(可选项) (无默认值) */
    private String buildingUse;

    /** @desc 教学楼房间数量(可选项) (无默认值) */
    private Long buildingRoomNum;

    /** @desc 教学楼负责人(可选项) (无默认值) */
    private String buildingAdmin;

    /** 系统状态(可选项) (无默认值) */
    private String sysStatus;

    /** @desc 创建时间(可选项) (无默认值) */
    private Date createTime;

    /** @desc 更新时间(可选项) (无默认值) */
    private Date updateTime;
    
    private List<Classroom> children;

    public List<Classroom> getChildren() {
		return children;
	}

	public void setChildren(List<Classroom> children) {
		this.children = children;
	}

	private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName == null ? null : buildingName.trim();
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber == null ? null : buildingNumber.trim();
    }

    public String getBuildingUse() {
        return buildingUse;
    }

    public void setBuildingUse(String buildingUse) {
        this.buildingUse = buildingUse == null ? null : buildingUse.trim();
    }

    public Long getBuildingRoomNum() {
        return buildingRoomNum;
    }

    public void setBuildingRoomNum(Long buildingRoomNum) {
        this.buildingRoomNum = buildingRoomNum;
    }

    public String getBuildingAdmin() {
        return buildingAdmin;
    }

    public void setBuildingAdmin(String buildingAdmin) {
        this.buildingAdmin = buildingAdmin == null ? null : buildingAdmin.trim();
    }

    public String getSysStatus() {
        return sysStatus;
    }

    public void setSysStatus(String sysStatus) {
        this.sysStatus = sysStatus == null ? null : sysStatus.trim();
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