package com.chinayouthedu.zqzc.entity.vo;

import java.util.List;

import com.chinayouthedu.zqzc.config.annotation.RequestVo;
import com.chinayouthedu.zqzc.entity.paike.Teacher;

/**
 * 新增时传输的课时对象
 * @Company 中青至诚教育咨询有限公司
 * @author  梁建
 * @Modifier
 * @time   2018年3月22日 下午5:54:57
 * @version 1.0
 */
@RequestVo
public class CourseTimeVo {

	/**  学年id(可选项) (无默认值) */
    private Long schoolYearId;
    
    /**  学年名称(可选项) (无默认值) */
    private String schoolYearName;
    
    /**  学期id(可选项) (无默认值) */
    private Long semesterId;

    /**  学期名称(可选项) (无默认值) */
    private String semesterName;

    /**  教研组id(可选项) (无默认值) */
    private Long teacherGroupId;

    /**  教研组名(可选项) (无默认值) */
    private String teacherGroupName;
    
    /** @desc 教师id(可选项) (无默认值) */
    private Long teacherId;

    /** @desc 教师名称(可选项) (无默认值) */
    private String teacherName;
    
    /**  教师总学时(可选项) (无默认值) */
    private Integer allLearnTime;

    /**  教师周学时(可选项) (无默认值) */
    private Integer weekLearnTime;

    /**  实际安排课时(可选项) (无默认值) */
    private Integer actualCourseTime;

	/** 最少周学时(可选项) (无默认值) */
	private Integer minWeekLearnTime;

	/** 最多周学时(可选项) (无默认值) */
	private Integer maxWeekLearnTime;

	/** 教授班级数量(可选项) (无默认值) */
	private Integer teachClassNumber;

	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Long getSchoolYearId() {
		return schoolYearId;
	}

	public void setSchoolYearId(Long schoolYearId) {
		this.schoolYearId = schoolYearId;
	}

	public String getSchoolYearName() {
		return schoolYearName;
	}

	public void setSchoolYearName(String schoolYearName) {
		this.schoolYearName = schoolYearName;
	}

	public Long getSemesterId() {
		return semesterId;
	}

	public void setSemesterId(Long semesterId) {
		this.semesterId = semesterId;
	}

	public String getSemesterName() {
		return semesterName;
	}

	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}

	public Long getTeacherGroupId() {
		return teacherGroupId;
	}

	public void setTeacherGroupId(Long teacherGroupId) {
		this.teacherGroupId = teacherGroupId;
	}

	public String getTeacherGroupName() {
		return teacherGroupName;
	}

	public void setTeacherGroupName(String teacherGroupName) {
		this.teacherGroupName = teacherGroupName;
	}

	public Integer getAllLearnTime() {
		return allLearnTime;
	}

	public void setAllLearnTime(Integer allLearnTime) {
		this.allLearnTime = allLearnTime;
	}

	public Integer getWeekLearnTime() {
		return weekLearnTime;
	}

	public void setWeekLearnTime(Integer weekLearnTime) {
		this.weekLearnTime = weekLearnTime;
	}

	public Integer getActualCourseTime() {
		return actualCourseTime;
	}

	public void setActualCourseTime(Integer actualCourseTime) {
		this.actualCourseTime = actualCourseTime;
	}

	public Integer getMinWeekLearnTime() {
		return minWeekLearnTime;
	}

	public void setMinWeekLearnTime(Integer minWeekLearnTime) {
		this.minWeekLearnTime = minWeekLearnTime;
	}

	public Integer getMaxWeekLearnTime() {
		return maxWeekLearnTime;
	}

	public void setMaxWeekLearnTime(Integer maxWeekLearnTime) {
		this.maxWeekLearnTime = maxWeekLearnTime;
	}

	public Integer getTeachClassNumber() {
		return teachClassNumber;
	}

	public void setTeachClassNumber(Integer teachClassNumber) {
		this.teachClassNumber = teachClassNumber;
	}
}
