package com.chinayouthedu.zqzc.entity.paike;

import com.chinayouthedu.zqzc.config.core.BaseBean;
import java.io.Serializable;
import java.util.Date;

/**
 * @表名称 zczx_organization
 * @开发日期 2018-03-12 11:09:49
 * @开发作者 :中青至诚教育咨询有限公司 
 */
public class Organization extends BaseBean implements Serializable {
    /** 机构id (主健ID) (无默认值) */
    private Long id;

    /** 父机构id(可选项) (无默认值) */
    private Long parentOrganizationId;

    /** 机构名称(可选项) (无默认值) */
    private String organizationName;

    /** 外文名称(可选项) (无默认值) */
    private String foreignLanguageName;

    /** 机构简称(可选项) (无默认值) */
    private String organizationAbbreviation;

    /** 机构性质(可选项) (无默认值) */
    private String organizationNature;

    /** 机构地址(可选项) (无默认值) */
    private String organizationAddress;

    /** 法定代表人(可选项) (无默认值) */
    private String legalPerson;

    /** 机构创始人(可选项) (无默认值) */
    private String organizationFounder;

    /** 成立时间(可选项) (无默认值) */
    private Date setupTime;

    /** 上市时间(可选项) (无默认值) */
    private Date listingTime;

    /** 机构类型(可选项) (无默认值) */
    private String organizationType;

    /** 所属行业(可选项) (无默认值) */
    private String industry;

    /** 统一社会信用代码(可选项) (无默认值) */
    private String creditCode;

    /** 组织机构代码(可选项) (无默认值) */
    private String organizationCode;

    /** 注册号(可选项) (无默认值) */
    private String zczxCode;

    /** 经营状态(可选项) (无默认值) */
    private String managementStatus;

    /** 营业期限(可选项) (无默认值) */
    private String businessTerm;

    /** 发照日期(可选项) (无默认值) */
    private Date licenseTime;

    /** 注册资本(可选项) (无默认值) */
    private String zczxCapital;

    /** 登记机关(可选项) (无默认值) */
    private String zczxOffice;

    /** 股票代码(可选项) (无默认值) */
    private String stockCode;

    /** 年营业额(可选项) (无默认值) */
    private String yearlyTurnover;

    /** 机构使命(可选项) (无默认值) */
    private String organizationMission;

    /** 机构官网(可选项) (无默认值) */
    private String organizationHttp;

    /** 机构文化(可选项) (无默认值) */
    private String organizationCulture;

    /** 机构合伙人(可选项) (无默认值) */
    private String organizationPartner;

    /** 机构股东(可选项) (无默认值) */
    private String organizationShareholder;

    /** 机构董事(可选项) (无默认值) */
    private String organizationManager;

    /** 机构其他信息(可选项) (无默认值) */
    private String organizationOtherInfo;

    /** 系统状态(可选项) (无默认值) */
    private String systemStatus;

    /** 经营范围(可选项) (无默认值) */
    private String businessScope;

    /** 创建时间(可选项) (无默认值) */
    private Date createTime;

    /** 更新时间(可选项) (无默认值) */
    private Date updateTime;

    /** 机构序号(可选项) (无默认值) */
    private Integer organizationSort;

    /** 备注(可选项) (无默认值) */
    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentOrganizationId() {
        return parentOrganizationId;
    }

    public void setParentOrganizationId(Long parentOrganizationId) {
        this.parentOrganizationId = parentOrganizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName == null ? null : organizationName.trim();
    }

    public String getForeignLanguageName() {
        return foreignLanguageName;
    }

    public void setForeignLanguageName(String foreignLanguageName) {
        this.foreignLanguageName = foreignLanguageName == null ? null : foreignLanguageName.trim();
    }

    public String getOrganizationAbbreviation() {
        return organizationAbbreviation;
    }

    public void setOrganizationAbbreviation(String organizationAbbreviation) {
        this.organizationAbbreviation = organizationAbbreviation == null ? null : organizationAbbreviation.trim();
    }

    public String getOrganizationNature() {
        return organizationNature;
    }

    public void setOrganizationNature(String organizationNature) {
        this.organizationNature = organizationNature == null ? null : organizationNature.trim();
    }

    public String getOrganizationAddress() {
        return organizationAddress;
    }

    public void setOrganizationAddress(String organizationAddress) {
        this.organizationAddress = organizationAddress == null ? null : organizationAddress.trim();
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson == null ? null : legalPerson.trim();
    }

    public String getOrganizationFounder() {
        return organizationFounder;
    }

    public void setOrganizationFounder(String organizationFounder) {
        this.organizationFounder = organizationFounder == null ? null : organizationFounder.trim();
    }

    public Date getSetupTime() {
        return setupTime;
    }

    public void setSetupTime(Date setupTime) {
        this.setupTime = setupTime;
    }

    public Date getListingTime() {
        return listingTime;
    }

    public void setListingTime(Date listingTime) {
        this.listingTime = listingTime;
    }

    public String getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(String organizationType) {
        this.organizationType = organizationType == null ? null : organizationType.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode == null ? null : creditCode.trim();
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode == null ? null : organizationCode.trim();
    }

    public String getZczxCode() {
        return zczxCode;
    }

    public void setZczxCode(String zczxCode) {
        this.zczxCode = zczxCode == null ? null : zczxCode.trim();
    }

    public String getManagementStatus() {
        return managementStatus;
    }

    public void setManagementStatus(String managementStatus) {
        this.managementStatus = managementStatus == null ? null : managementStatus.trim();
    }

    public String getBusinessTerm() {
        return businessTerm;
    }

    public void setBusinessTerm(String businessTerm) {
        this.businessTerm = businessTerm == null ? null : businessTerm.trim();
    }

    public Date getLicenseTime() {
        return licenseTime;
    }

    public void setLicenseTime(Date licenseTime) {
        this.licenseTime = licenseTime;
    }

    public String getZczxCapital() {
        return zczxCapital;
    }

    public void setZczxCapital(String zczxCapital) {
        this.zczxCapital = zczxCapital == null ? null : zczxCapital.trim();
    }

    public String getZczxOffice() {
        return zczxOffice;
    }

    public void setZczxOffice(String zczxOffice) {
        this.zczxOffice = zczxOffice == null ? null : zczxOffice.trim();
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode == null ? null : stockCode.trim();
    }

    public String getYearlyTurnover() {
        return yearlyTurnover;
    }

    public void setYearlyTurnover(String yearlyTurnover) {
        this.yearlyTurnover = yearlyTurnover == null ? null : yearlyTurnover.trim();
    }

    public String getOrganizationMission() {
        return organizationMission;
    }

    public void setOrganizationMission(String organizationMission) {
        this.organizationMission = organizationMission == null ? null : organizationMission.trim();
    }

    public String getOrganizationHttp() {
        return organizationHttp;
    }

    public void setOrganizationHttp(String organizationHttp) {
        this.organizationHttp = organizationHttp == null ? null : organizationHttp.trim();
    }

    public String getOrganizationCulture() {
        return organizationCulture;
    }

    public void setOrganizationCulture(String organizationCulture) {
        this.organizationCulture = organizationCulture == null ? null : organizationCulture.trim();
    }

    public String getOrganizationPartner() {
        return organizationPartner;
    }

    public void setOrganizationPartner(String organizationPartner) {
        this.organizationPartner = organizationPartner == null ? null : organizationPartner.trim();
    }

    public String getOrganizationShareholder() {
        return organizationShareholder;
    }

    public void setOrganizationShareholder(String organizationShareholder) {
        this.organizationShareholder = organizationShareholder == null ? null : organizationShareholder.trim();
    }

    public String getOrganizationManager() {
        return organizationManager;
    }

    public void setOrganizationManager(String organizationManager) {
        this.organizationManager = organizationManager == null ? null : organizationManager.trim();
    }

    public String getOrganizationOtherInfo() {
        return organizationOtherInfo;
    }

    public void setOrganizationOtherInfo(String organizationOtherInfo) {
        this.organizationOtherInfo = organizationOtherInfo == null ? null : organizationOtherInfo.trim();
    }

    public String getSystemStatus() {
        return systemStatus;
    }

    public void setSystemStatus(String systemStatus) {
        this.systemStatus = systemStatus == null ? null : systemStatus.trim();
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope == null ? null : businessScope.trim();
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

    public Integer getOrganizationSort() {
        return organizationSort;
    }

    public void setOrganizationSort(Integer organizationSort) {
        this.organizationSort = organizationSort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}