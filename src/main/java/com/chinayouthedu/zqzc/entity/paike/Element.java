package com.chinayouthedu.zqzc.entity.paike;

import com.chinayouthedu.zqzc.config.core.BaseBean;
import java.io.Serializable;
import java.util.Date;

/**
 * @表名称 zczx_element
 * @开发日期 2018-03-12 11:09:49
 * @开发作者 :中青至诚教育咨询有限公司 
 */
public class Element extends BaseBean implements Serializable {
    /** id (主健ID) (无默认值) */
    private Long id;

    /** 所属功能页面的ID(可选项) (无默认值) */
    private Long functionId;

    /** 元素编码(可选项) (无默认值) */
    private String elementCode;

    /** 元素名称(可选项) (无默认值) */
    private String elementName;

    /** 元素图标(可选项) (无默认值) */
    private String elementIcon;

    /** 元素类型(可选项) (无默认值) */
    private String elementType;

    /** 元素状态(可选项) (无默认值) */
    private String elementStatus;

    /** 元素序号(可选项) (无默认值) */
    private Integer elementSort;

    /** 元素样式(可选项) (无默认值) */
    private String elementClass;

    /** 页面元素位置:1左上2左中3左下4中上5中心6中下7右上8右中9右下(可选项) (无默认值) */
    private Integer elementPosition;

    /** 创建时间(可选项) (无默认值) */
    private Date createTime;

    /** 更新时间(可选项) (无默认值) */
    private Date updateTime;

    /** 备注(可选项) (无默认值) */
    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Long functionId) {
        this.functionId = functionId;
    }

    public String getElementCode() {
        return elementCode;
    }

    public void setElementCode(String elementCode) {
        this.elementCode = elementCode == null ? null : elementCode.trim();
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName == null ? null : elementName.trim();
    }

    public String getElementIcon() {
        return elementIcon;
    }

    public void setElementIcon(String elementIcon) {
        this.elementIcon = elementIcon == null ? null : elementIcon.trim();
    }

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType == null ? null : elementType.trim();
    }

    public String getElementStatus() {
        return elementStatus;
    }

    public void setElementStatus(String elementStatus) {
        this.elementStatus = elementStatus == null ? null : elementStatus.trim();
    }

    public Integer getElementSort() {
        return elementSort;
    }

    public void setElementSort(Integer elementSort) {
        this.elementSort = elementSort;
    }

    public String getElementClass() {
        return elementClass;
    }

    public void setElementClass(String elementClass) {
        this.elementClass = elementClass == null ? null : elementClass.trim();
    }

    public Integer getElementPosition() {
        return elementPosition;
    }

    public void setElementPosition(Integer elementPosition) {
        this.elementPosition = elementPosition;
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
}