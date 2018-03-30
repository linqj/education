package com.chinayouthedu.zqzc.entity.vo;

import org.hibernate.validator.constraints.NotBlank;

import com.chinayouthedu.zqzc.config.annotation.RequestVo;

@RequestVo
public class ClassroomVo {

    /**  (主健ID) (无默认值) */
//    private Long id;

    /** 教室名称(可选项) (无默认值) */
    @NotBlank(message="教室名称不能为空!")
    private String roomName;

    /** 教室编号(可选项) (无默认值) */
    @NotBlank(message="教室编号不能为空!")
    private String roomNumber;

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
}
