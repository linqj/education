package com.chinayouthedu.zqzc.entity.paike;

import com.chinayouthedu.zqzc.config.core.BaseBean;
import java.io.Serializable;
import java.util.Date;

/**
 * @表名称 classroom
 * @开发日期 2018-03-07 04:10:19
 * @开发作者 :中青至诚教育咨询有限公司 
 */
public class Classroom extends BaseBean implements Serializable {
    /**  (主健ID) (无默认值) */
    private Long id;

    /** 教室名称(可选项) (无默认值) */
    private String roomName;

    /** 教室编号(可选项) (无默认值) */
    private String roomNumber;

    /** 教室所属教学楼id(可选项) (无默认值) */
    private Long roomBuildingId;

    /** 教室所属教学楼名称(可选项) (无默认值) */
    private String roomBuildingName;

    /** 教室类型(可选项) (无默认值) */
    private String roomType;

    /** 教师用途(可选项) (无默认值) */
    private String roomUse;

    /** 教室面积(可选项) (无默认值) */
    private Double roomArea;

    /** 教室容纳人数(可选项) (无默认值) */
    private String roomPersonMax;

    /** 状态(可选项) (无默认值) */
    private String status;

    /** 系统状态(可选项) (无默认值) */
    private String sysStatus;

    /** 创建时间(可选项) (无默认值) */
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

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName == null ? null : roomName.trim();
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber == null ? null : roomNumber.trim();
    }

    public Long getRoomBuildingId() {
        return roomBuildingId;
    }

    public void setRoomBuildingId(Long roomBuildingId) {
        this.roomBuildingId = roomBuildingId;
    }

    public String getRoomBuildingName() {
        return roomBuildingName;
    }

    public void setRoomBuildingName(String roomBuildingName) {
        this.roomBuildingName = roomBuildingName == null ? null : roomBuildingName.trim();
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType == null ? null : roomType.trim();
    }

    public String getRoomUse() {
        return roomUse;
    }

    public void setRoomUse(String roomUse) {
        this.roomUse = roomUse == null ? null : roomUse.trim();
    }

    public Double getRoomArea() {
        return roomArea;
    }

    public void setRoomArea(Double roomArea) {
        this.roomArea = roomArea;
    }

    public String getRoomPersonMax() {
        return roomPersonMax;
    }

    public void setRoomPersonMax(String roomPersonMax) {
        this.roomPersonMax = roomPersonMax == null ? null : roomPersonMax.trim();
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