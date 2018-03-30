package com.chinayouthedu.zqzc.entity.vo;

import org.hibernate.validator.constraints.NotBlank;

import com.chinayouthedu.zqzc.config.annotation.RequestVo;

@RequestVo
public class TeacherVo {

	 /** @desc 姓名(必填项) (无默认值) */
	@NotBlank(message="教师姓名不能为空!")
    private String teacherName;

    /** @desc 性别(必填项) (无默认值) */
	@NotBlank(message="教师性别不能为空!")
    private String teacherGender;
    
    /** @desc 教师编号(必填项) (无默认值) */
	@NotBlank(message="教师编号不能为空!")
    private String teacherNumber;
    
    /** @decs 教师级别(必填项) (无默认值) */
    private String teacherLevel;
    
    /** 教师所属教研组id(可选项) (无默认值) */
    private Long teacherGroupId;

	public Long getTeacherGroupId() {
		return teacherGroupId;
	}

	public void setTeacherGroupId(Long teacherGroupId) {
		this.teacherGroupId = teacherGroupId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherGender() {
		return teacherGender;
	}

	public void setTeacherGender(String teacherGender) {
		this.teacherGender = teacherGender;
	}

	public String getTeacherNumber() {
		return teacherNumber;
	}

	public void setTeacherNumber(String teacherNumber) {
		this.teacherNumber = teacherNumber;
	}

	public String getTeacherLevel() {
		return teacherLevel;
	}

	public void setTeacherLevel(String teacherLevel) {
		this.teacherLevel = teacherLevel;
	}
    
    
	
}
