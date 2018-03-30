package com.chinayouthedu.zqzc.entity.vo;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import com.chinayouthedu.zqzc.config.annotation.RequestVo;
import com.chinayouthedu.zqzc.config.core.BaseBean;

/***
 * 	学年学期验证对象
 * @Company 中青至诚教育咨询有限公司
 * @author  梁建
 * @Modifier
 * @time   2018年3月9日 下午4:32:43
 * @version 1.0
 */
@RequestVo
public class SchoolYearVo extends BaseBean implements Serializable {
    private static final long serialVersionUID = 1L;

	/**  (主健ID) (无默认值) */
    private Long id;

    /** 学年编号(可选项) (无默认值) */
    @NotBlank(message="学年编号不能为空!")
    private String schoolYearCode;

    /** 学年名称(可选项) (无默认值) */
    @NotBlank(message="学年名称不能为空!")
    private String schoolYearName;

    @NotBlank(message="第一学期名称不能为空!")
    private String firstSemesterName;
    
//    @NotBlank(message="第一学期编号不能为空!")
    private String firstSemesterCode;
    
    @NotBlank(message="第一学期开始时间不能为空!")
    private String firstStartTime;
    
    @NotBlank(message="第一学期结束时间不能为空!")
    private String firstEndTime;
    
    @NotBlank(message="第二学期名称不能为空!")
    private String lastSemesterName;
    
//	@NotBlank(message="第二学期编号不能为空!")
    private String lastSemesterCode;
    
    @NotBlank(message="第二学期开始时间不能为空!")
    private String lastStartTime;
    
    @NotBlank(message="第二学期结束时间不能为空!")
    private String lastEndTime;
    
    
    public String getFirstStartTime() {
		return firstStartTime;
	}

	public void setFirstStartTime(String firstStartTime) {
		this.firstStartTime = firstStartTime;
	}

	public String getFirstEndTime() {
		return firstEndTime;
	}

	public void setFirstEndTime(String firstEndTime) {
		this.firstEndTime = firstEndTime;
	}

	public String getLastStartTime() {
		return lastStartTime;
	}

	public void setLastStartTime(String lastStartTime) {
		this.lastStartTime = lastStartTime;
	}

	public String getLastEndTime() {
		return lastEndTime;
	}

	public void setLastEndTime(String lastEndTime) {
		this.lastEndTime = lastEndTime;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchoolYearCode() {
        return schoolYearCode;
    }

    public void setSchoolYearCode(String schoolYearCode) {
        this.schoolYearCode = schoolYearCode == null ? null : schoolYearCode.trim();
    }

    public String getSchoolYearName() {
        return schoolYearName;
    }

    public void setSchoolYearName(String schoolYearName) {
        this.schoolYearName = schoolYearName == null ? null : schoolYearName.trim();
    }

	public String getFirstSemesterName() {
		return firstSemesterName;
	}

	public void setFirstSemesterName(String firstSemesterName) {
		this.firstSemesterName = firstSemesterName;
	}

	public String getFirstSemesterCode() {
		return firstSemesterCode;
	}

	public void setFirstSemesterCode(String firstSemesterCode) {
		this.firstSemesterCode = firstSemesterCode;
	}

	public String getLastSemesterName() {
		return lastSemesterName;
	}

	public void setLastSemesterName(String lastSemesterName) {
		this.lastSemesterName = lastSemesterName;
	}

	public String getLastSemesterCode() {
		return lastSemesterCode;
	}

	public void setLastSemesterCode(String lastSemesterCode) {
		this.lastSemesterCode = lastSemesterCode;
	}
    
}