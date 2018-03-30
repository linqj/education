package com.chinayouthedu.zqzc.entity.paike;

import com.chinayouthedu.zqzc.config.core.BaseBean;
import java.io.Serializable;
import java.util.Date;

/**
 * @表名称 zczx_product_function
 * @开发日期 2018-03-12 11:09:49
 * @开发作者 :中青至诚教育咨询有限公司 
 */
public class ProductFunction extends BaseBean implements Serializable {
    /** id (主健ID) (无默认值) */
    private Long id;

    /** 产品ID(可选项) (无默认值) */
    private Long productId;

    /** 产品编码(可选项) (无默认值) */
    private String productCode;

    /** 产品名称(冗余)(可选项) (无默认值) */
    private String productName;

    /** 产品版本(冗余)(可选项) (无默认值) */
    private String productVersion;

    /** 产品状态(可选项) (无默认值) */
    private String productStatus;

    /** 菜单ID(可选项) (无默认值) */
    private Long menuId;

    /** 菜单图标(可选项) (无默认值) */
    private String menuIcon;

    /** 菜单编码(可选项) (无默认值) */
    private String menuCode;

    /** 菜单名称(冗余)(可选项) (无默认值) */
    private String menuName;

    /** 菜单类型(可选项) (无默认值) */
    private String menuType;

    /** 菜单序号(可选项) (无默认值) */
    private Integer menuSort;

    /** 菜单状态(可选项) (无默认值) */
    private String menuStatus;

    /** 菜单url(可选项) (无默认值) */
    private String menuUrl;

    /** 父菜单id(可选项) (无默认值) */
    private Long menuPid;

    /** 菜单描述(可选项) (无默认值) */
    private String menuRemark;

    /** 功能ID(可选项) (无默认值) */
    private Long functionId;

    /** 功能编码(可选项) (无默认值) */
    private String functionCode;

    /** 功能名称(冗余)(可选项) (无默认值) */
    private String functionName;

    /** 功能路径(冗余)(可选项) (无默认值) */
    private String functionUrl;

    /** 功能状态(可选项) (无默认值) */
    private String functionStatus;

    /** 功能类型(可选项) (无默认值) */
    private String functionType;

    /** 功能序号(可选项) (无默认值) */
    private Integer functionSort;

    /** 功能描述(可选项) (无默认值) */
    private String functionRemark;

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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductVersion() {
        return productVersion;
    }

    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion == null ? null : productVersion.trim();
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus == null ? null : productStatus.trim();
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon == null ? null : menuIcon.trim();
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode == null ? null : menuCode.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType == null ? null : menuType.trim();
    }

    public Integer getMenuSort() {
        return menuSort;
    }

    public void setMenuSort(Integer menuSort) {
        this.menuSort = menuSort;
    }

    public String getMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(String menuStatus) {
        this.menuStatus = menuStatus == null ? null : menuStatus.trim();
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    public Long getMenuPid() {
        return menuPid;
    }

    public void setMenuPid(Long menuPid) {
        this.menuPid = menuPid;
    }

    public String getMenuRemark() {
        return menuRemark;
    }

    public void setMenuRemark(String menuRemark) {
        this.menuRemark = menuRemark == null ? null : menuRemark.trim();
    }

    public Long getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Long functionId) {
        this.functionId = functionId;
    }

    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode == null ? null : functionCode.trim();
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName == null ? null : functionName.trim();
    }

    public String getFunctionUrl() {
        return functionUrl;
    }

    public void setFunctionUrl(String functionUrl) {
        this.functionUrl = functionUrl == null ? null : functionUrl.trim();
    }

    public String getFunctionStatus() {
        return functionStatus;
    }

    public void setFunctionStatus(String functionStatus) {
        this.functionStatus = functionStatus == null ? null : functionStatus.trim();
    }

    public String getFunctionType() {
        return functionType;
    }

    public void setFunctionType(String functionType) {
        this.functionType = functionType == null ? null : functionType.trim();
    }

    public Integer getFunctionSort() {
        return functionSort;
    }

    public void setFunctionSort(Integer functionSort) {
        this.functionSort = functionSort;
    }

    public String getFunctionRemark() {
        return functionRemark;
    }

    public void setFunctionRemark(String functionRemark) {
        this.functionRemark = functionRemark == null ? null : functionRemark.trim();
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