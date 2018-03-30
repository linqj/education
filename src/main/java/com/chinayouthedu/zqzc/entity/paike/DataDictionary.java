package com.chinayouthedu.zqzc.entity.paike;

import com.chinayouthedu.zqzc.config.core.BaseBean;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @表名称 zczx_data_dictionary
 * @开发日期 2018-03-12 11:09:49
 * @开发作者 :中青至诚教育咨询有限公司 
 */
public class DataDictionary extends BaseBean implements Serializable {
    /** id (主健ID) (无默认值) */
    private Long id;

    /** 字典编码(可选项) (无默认值) */
    private String dictionaryCode;

    /** 字典类型(可选项) (无默认值) */
    private String dictionaryType;

    /** 字典图标(可选项) (无默认值) */
    private String dictionaryIcon;

    /** 字典名称(可选项) (无默认值) */
    private String dictionaryName;

    /** 字典序号(可选项) (无默认值) */
    private Integer dictionarySort;

    /** 字典所属(可选项) (无默认值) */
    private Long dictionarySource;

    /** 其他信息(可选项) (无默认值) */
    private String dictionaryOther;

    /** 系统状态(可选项) (无默认值) */
    private String systemStatus;

    /** 创建时间(可选项) (无默认值) */
    private Date createTime;

    /** 更新时间(可选项) (无默认值) */
    private Date updateTime;

    /** 备注(可选项) (无默认值) */
    private String remark;
    
    /** 该类型下的字典项 */
    private List<Dictionary> childlist;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDictionaryCode() {
        return dictionaryCode;
    }

    public void setDictionaryCode(String dictionaryCode) {
        this.dictionaryCode = dictionaryCode == null ? null : dictionaryCode.trim();
    }

    public String getDictionaryType() {
        return dictionaryType;
    }

    public void setDictionaryType(String dictionaryType) {
        this.dictionaryType = dictionaryType == null ? null : dictionaryType.trim();
    }

    public String getDictionaryIcon() {
        return dictionaryIcon;
    }

    public void setDictionaryIcon(String dictionaryIcon) {
        this.dictionaryIcon = dictionaryIcon == null ? null : dictionaryIcon.trim();
    }

    public String getDictionaryName() {
        return dictionaryName;
    }

    public void setDictionaryName(String dictionaryName) {
        this.dictionaryName = dictionaryName == null ? null : dictionaryName.trim();
    }

    public Integer getDictionarySort() {
        return dictionarySort;
    }

    public void setDictionarySort(Integer dictionarySort) {
        this.dictionarySort = dictionarySort;
    }

    public Long getDictionarySource() {
        return dictionarySource;
    }

    public void setDictionarySource(Long dictionarySource) {
        this.dictionarySource = dictionarySource;
    }

    public String getDictionaryOther() {
        return dictionaryOther;
    }

    public void setDictionaryOther(String dictionaryOther) {
        this.dictionaryOther = dictionaryOther == null ? null : dictionaryOther.trim();
    }

    public String getSystemStatus() {
        return systemStatus;
    }

    public void setSystemStatus(String systemStatus) {
        this.systemStatus = systemStatus == null ? null : systemStatus.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	public List<Dictionary> getChildlist() {
		return childlist;
	}

	public void setChildlist(List<Dictionary> childlist) {
		this.childlist = childlist;
	}
    
}