package com.chinayouthedu.zqzc.entity.paike;

import com.chinayouthedu.zqzc.config.core.BaseBean;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @表名称 zczx_personnel_archives
 * @开发日期 2018-03-12 11:09:49
 * @开发作者 :中青至诚教育咨询有限公司 
 */
public class PersonnelArchives extends BaseBean implements Serializable {
    /** id (主健ID) (无默认值) */
    private Long id;

    /** 人员姓名(可选项) (无默认值) */
    private String personnelName;

    /** 曾用名(可选项) (无默认值) */
    private String beforeName;

    /** 英文名(可选项) (无默认值) */
    private String englishName;

    /** 人员编号(可选项) (无默认值) */
    private String personnelCode;

    /** 人员类型(可选项) (无默认值) */
    private String personnelType;

    /** 性别(可选项) (无默认值) */
    private String gender;

    /** 民族(可选项) (无默认值) */
    private String nation;

    /** 证件类型(可选项) (无默认值) */
    private String idcardType;

    /** 证件号码(可选项) (无默认值) */
    private String idcardCode;

    /** 血型(可选项) (无默认值) */
    private String bloodType;

    /** 出生日期(可选项) (无默认值) */
    private Date birthday;

    /** 政治面貌(可选项) (无默认值) */
    private String politicsStatus;

    /** 籍贯(可选项) (无默认值) */
    private String nativePlace;

    /** 国家(可选项) (无默认值) */
    private String country;

    /** 省(可选项) (无默认值) */
    private String province;

    /** 市(可选项) (无默认值) */
    private String city;

    /** 区县(可选项) (无默认值) */
    private String county;

    /** 现居住地址(可选项) (无默认值) */
    private String address;

    /** 邮政编码(可选项) (无默认值) */
    private Integer postalcode;

    /** 联系方式(可选项) (无默认值) */
    private String phone;

    /** 婚姻状况(可选项) (无默认值) */
    private String maritalStatus;

    /** 紧急联系人电话(可选项) (无默认值) */
    private String urgentContactPhone;

    /** 座机(可选项) (无默认值) */
    private String landline;

    /** 邮箱(可选项) (无默认值) */
    private String email;

    /** 身高(可选项) (无默认值) */
    private BigDecimal height;

    /** 体重(可选项) (无默认值) */
    private BigDecimal weight;

    /** 健康状况(可选项) (无默认值) */
    private String health;

    /** 学历(可选项) (无默认值) */
    private String education;

    /** 档案所在地(可选项) (无默认值) */
    private String archivesLocation;

    /** 照片(可选项) (无默认值) */
    private String picturePath;

    /** 系统状态(可选项) (无默认值) */
    private String sysStatus;

    /** 部门名称(可选项) (无默认值) */
    private String deptName;

    /** 部门id(可选项) (无默认值) */
    private Long deptId;

    /** 创建时间(可选项) (无默认值) */
    private Date createTime;

    /** 更新时间(可选项) (无默认值) */
    private Date updateTime;

    /** 序号(可选项) (无默认值) */
    private Integer sort;

    /** 备注(可选项) (无默认值) */
    private String remark;

    /** 人员id(必填项) (无默认值) */
    private Long personId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonnelName() {
        return personnelName;
    }

    public void setPersonnelName(String personnelName) {
        this.personnelName = personnelName == null ? null : personnelName.trim();
    }

    public String getBeforeName() {
        return beforeName;
    }

    public void setBeforeName(String beforeName) {
        this.beforeName = beforeName == null ? null : beforeName.trim();
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName == null ? null : englishName.trim();
    }

    public String getPersonnelCode() {
        return personnelCode;
    }

    public void setPersonnelCode(String personnelCode) {
        this.personnelCode = personnelCode == null ? null : personnelCode.trim();
    }

    public String getPersonnelType() {
        return personnelType;
    }

    public void setPersonnelType(String personnelType) {
        this.personnelType = personnelType == null ? null : personnelType.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getIdcardType() {
        return idcardType;
    }

    public void setIdcardType(String idcardType) {
        this.idcardType = idcardType == null ? null : idcardType.trim();
    }

    public String getIdcardCode() {
        return idcardCode;
    }

    public void setIdcardCode(String idcardCode) {
        this.idcardCode = idcardCode == null ? null : idcardCode.trim();
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType == null ? null : bloodType.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPoliticsStatus() {
        return politicsStatus;
    }

    public void setPoliticsStatus(String politicsStatus) {
        this.politicsStatus = politicsStatus == null ? null : politicsStatus.trim();
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace == null ? null : nativePlace.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(Integer postalcode) {
        this.postalcode = postalcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus == null ? null : maritalStatus.trim();
    }

    public String getUrgentContactPhone() {
        return urgentContactPhone;
    }

    public void setUrgentContactPhone(String urgentContactPhone) {
        this.urgentContactPhone = urgentContactPhone == null ? null : urgentContactPhone.trim();
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline == null ? null : landline.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health == null ? null : health.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getArchivesLocation() {
        return archivesLocation;
    }

    public void setArchivesLocation(String archivesLocation) {
        this.archivesLocation = archivesLocation == null ? null : archivesLocation.trim();
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath == null ? null : picturePath.trim();
    }

    public String getSysStatus() {
        return sysStatus;
    }

    public void setSysStatus(String sysStatus) {
        this.sysStatus = sysStatus == null ? null : sysStatus.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}