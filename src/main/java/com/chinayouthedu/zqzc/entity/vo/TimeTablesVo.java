package com.chinayouthedu.zqzc.entity.vo;

import com.chinayouthedu.zqzc.config.annotation.RequestVo;
import com.chinayouthedu.zqzc.config.core.BaseBean;
import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 节次表VO
 * @author 张超群
 * @time   2018年3月20日上午10:49:09
 */
@RequestVo
public class TimeTablesVo extends BaseBean implements Serializable {
    /**  (主健ID) (无默认值) */
    private Long id;

    /** @desc 节次数(可选项) (无默认值) */
    @Min(message="节次数不能为空!",value=0)
    private Integer sort;
    
    /** @desc 节次名称(可选项) (无默认值) */
    @NotBlank(message="节次名称不能为空!")
    private String name;

    /** @desc 开始时间(可选项) (无默认值) */
    @NotBlank(message="开始时间不能为空!")
    private String startTime;

    /** @desc 结束时间(可选项) (无默认值) */
    @NotBlank(message="结束时间不能为空!")
    private String endTime;

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
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

}