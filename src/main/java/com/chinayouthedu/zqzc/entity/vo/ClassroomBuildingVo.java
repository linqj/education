package com.chinayouthedu.zqzc.entity.vo;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import com.chinayouthedu.zqzc.config.annotation.RequestVo;

/***
 * 
 * @Company 中青至诚教育咨询有限公司
 * @author  梁建
 * @Modifier
 * @time   2018年3月9日 下午4:32:31
 * @version 1.0
 */
@RequestVo
public class ClassroomBuildingVo {
//	 /**  (主健ID) (无默认值) */
//    private Long id;

    /** @desc 教学楼名称 (无默认值) */
    @NotBlank(message="教学楼名称不能为空!")
    private String buildingName;

    /** @desc 教学楼编号(无默认值) */
    @NotBlank(message="教学楼编号不能为空!")
    private String buildingNumber;

    /** @desc 教学楼用途(可选项) (无默认值) */
    private String buildingUse;

    /** @desc 教学楼房间数量(可选项) (无默认值) */
    private Long buildingRoomNum;

    /** @desc 教学楼负责人(可选项) (无默认值) */
    private String buildingAdmin;



    private static final long serialVersionUID = 1L;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

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


}
