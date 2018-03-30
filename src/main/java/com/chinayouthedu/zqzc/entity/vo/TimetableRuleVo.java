package com.chinayouthedu.zqzc.entity.vo;

import java.io.Serializable;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

import com.chinayouthedu.zqzc.config.annotation.RequestVo;
import com.chinayouthedu.zqzc.config.core.BaseBean;

/**
 * 节次规则VO
 * @author 张超群
 * @time   2018年3月20日下午12:10:35
 */
@RequestVo
public class TimetableRuleVo extends BaseBean implements Serializable {
    /**  (主健ID) (无默认值) */
    private Long id;
    
    /** @desc 每天上课节数(可选项) (无默认值) */
    @Min(message="每天上课节数不能为空!",value = 1)
    private Integer courseNum;

    /** @desc 每节课时长(可选项) (无默认值) */
    @Min(message="每节课时长不能为空!",value = 1)
    private Integer courseLength;

    /** @desc 第一节课开始时间(可选项) (无默认值) */
    @NotBlank(message="第一节课开始时间不能为空!")
    private String firstCourseTime;

    /** @desc 课间操在第几节课后边(可选项) (无默认值) */
    @Min(message="课间操在第几节课后不能为空!",value = 1)
    private Integer gymnasticsSort;

    /** @desc 课间操时长(可选项) (无默认值) */
    @Min(message="课间操时长不能为空!",value = 1)
    private Integer gymnasticsLength;

    /** @desc 下午第一节课开始时间(可选项) (无默认值) */
    @NotBlank(message="下午第一节课开始时间不能为空!")
    private String pmFirstCourseTime;

    /** @desc 下午第一节课开始节次(可选项) (无默认值) */
    @Min(message="下午第一节课开始节次不能为空!",value = 1)
    private Integer pmFirstCourseSort;

    /** @desc 课间休息时间(可选项) (无默认值) */
    @Min(message="课间休息时间不能为空!",value = 1)
    private Integer recess;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCourseNum() {
		return courseNum;
	}

	public void setCourseNum(Integer courseNum) {
		this.courseNum = courseNum;
	}

	public Integer getCourseLength() {
        return courseLength;
    }

    public void setCourseLength(Integer courseLength) {
        this.courseLength = courseLength;
    }

    public String getFirstCourseTime() {
        return firstCourseTime;
    }

    public void setFirstCourseTime(String firstCourseTime) {
        this.firstCourseTime = firstCourseTime == null ? null : firstCourseTime.trim();
    }

    public Integer getGymnasticsSort() {
        return gymnasticsSort;
    }

    public void setGymnasticsSort(Integer gymnasticsSort) {
        this.gymnasticsSort = gymnasticsSort;
    }

    public Integer getGymnasticsLength() {
        return gymnasticsLength;
    }

    public void setGymnasticsLength(Integer gymnasticsLength) {
        this.gymnasticsLength = gymnasticsLength;
    }

    public String getPmFirstCourseTime() {
        return pmFirstCourseTime;
    }

    public void setPmFirstCourseTime(String pmFirstCourseTime) {
        this.pmFirstCourseTime = pmFirstCourseTime == null ? null : pmFirstCourseTime.trim();
    }

    public Integer getPmFirstCourseSort() {
        return pmFirstCourseSort;
    }

    public void setPmFirstCourseSort(Integer pmFirstCourseSort) {
        this.pmFirstCourseSort = pmFirstCourseSort;
    }

    public Integer getRecess() {
        return recess;
    }

    public void setRecess(Integer recess) {
        this.recess = recess;
    }

}