package com.chinayouthedu.zqzc.entity.vo;

import org.hibernate.validator.constraints.NotBlank;

import com.chinayouthedu.zqzc.config.annotation.RequestVo;

@RequestVo
public class TeacherGroupVo {

	/** @desc 教研组名称(可选项) (无默认值) */
	@NotBlank(message = "教研组名称不能为空!")
	private String tgName;

	/** 教研组编号(可选项) (无默认值) */
	private String tgCode;

	/** 教研组组长(可选项) (无默认值) */
	private String tgLeader;

	/** @desc 教研组组长的ID(可选项) (无默认值) */
	private Long tgLeaderId;

	/** @desc 教研组副组长的ID(可选项) (无默认值) */
	private Long tgLeaderTwoId;

	/** 教研组副组长(可选项) (无默认值) */
	private String tgLeaderTwo;

	/** 教研组关联科目编码(可选项) (无默认值) */
	private String courseDiscipline;

	public String getCourseDiscipline() {
		return courseDiscipline;
	}

	public void setCourseDiscipline(String courseDiscipline) {
		this.courseDiscipline = courseDiscipline;
	}

	public String getTgName() {
		return tgName;
	}

	public void setTgName(String tgName) {
		this.tgName = tgName;
	}

	public String getTgCode() {
		return tgCode;
	}

	public void setTgCode(String tgCode) {
		this.tgCode = tgCode;
	}

	public String getTgLeader() {
		return tgLeader;
	}

	public void setTgLeader(String tgLeader) {
		this.tgLeader = tgLeader;
	}

	public Long getTgLeaderId() {
		return tgLeaderId;
	}

	public void setTgLeaderId(Long tgLeaderId) {
		this.tgLeaderId = tgLeaderId;
	}

	public Long getTgLeaderTwoId() {
		return tgLeaderTwoId;
	}

	public void setTgLeaderTwoId(Long tgLeaderTwoId) {
		this.tgLeaderTwoId = tgLeaderTwoId;
	}

	public String getTgLeaderTwo() {
		return tgLeaderTwo;
	}

	public void setTgLeaderTwo(String tgLeaderTwo) {
		this.tgLeaderTwo = tgLeaderTwo;
	}

}
