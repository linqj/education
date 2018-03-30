package com.chinayouthedu.zqzc.entity.paike;

import com.chinayouthedu.zqzc.config.core.BaseBean;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @表名称 school_year
 * @开发日期 2018-03-07 04:10:19
 * @开发作者 :中青至诚教育咨询有限公司 
 */
public class SchoolYear extends BaseBean implements Serializable {
    /**  (主健ID) (无默认值) */
    private Long id;

    /** 学年编号(可选项) (无默认值) */
    private String schoolYearCode;

    /** 学年名称(可选项) (无默认值) */
    private String schoolYearName;

    /** 创建时间(可选项)  (默认值为: CURRENT_TIMESTAMP) */
    private Date createTime;

    /** 更新时间(可选项) (无默认值) */
    private Date updateTime;
    
    private List<Semester> children;

    private static final long serialVersionUID = 1L;

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

	public List<Semester> getChildren() {
		return children;
	}

	public void setChildren(List<Semester> children) {
		this.children = children;
	}
    
}