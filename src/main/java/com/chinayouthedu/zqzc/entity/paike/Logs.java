package com.chinayouthedu.zqzc.entity.paike;

import com.chinayouthedu.zqzc.config.core.BaseBean;
import java.io.Serializable;
import java.util.Date;

/**
 * @表名称 logs
 * @开发日期 2018-03-12 11:09:49
 * @开发作者 :中青至诚教育咨询有限公司 
 */
public class Logs extends BaseBean implements Serializable {
    /** id (主健ID) (无默认值) */
    private Long id;

    /** 访问者的ID(可选项) (无默认值) */
    private Long visitorId;

    /** 访问者名称(可选项) (无默认值) */
    private String vistiorName;

    /** 访问的路径(可选项) (无默认值) */
    private String visitUrl;

    /** 访问者的IP(可选项) (无默认值) */
    private String visitorIp;

    /** 访问者使用的系统(可选项) (无默认值) */
    private String visitorOs;

    /** 用户代理(可选项) (无默认值) */
    private String userAgent;

    /** 日志详细信息(可选项) (无默认值) */
    private String logInfo;

    /** 日志类型(可选项) (无默认值) */
    private String logType;

    /** 存储位置(可选项) (无默认值) */
    private String storeLocation;

    /** 存储文件后缀(可选项) (无默认值) */
    private String storeSuffix;

    /** 创建时间(可选项) (无默认值) */
    private Date createTime;

    /** 备注(可选项) (无默认值) */
    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    public String getVistiorName() {
        return vistiorName;
    }

    public void setVistiorName(String vistiorName) {
        this.vistiorName = vistiorName == null ? null : vistiorName.trim();
    }

    public String getVisitUrl() {
        return visitUrl;
    }

    public void setVisitUrl(String visitUrl) {
        this.visitUrl = visitUrl == null ? null : visitUrl.trim();
    }

    public String getVisitorIp() {
        return visitorIp;
    }

    public void setVisitorIp(String visitorIp) {
        this.visitorIp = visitorIp == null ? null : visitorIp.trim();
    }

    public String getVisitorOs() {
        return visitorOs;
    }

    public void setVisitorOs(String visitorOs) {
        this.visitorOs = visitorOs == null ? null : visitorOs.trim();
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent == null ? null : userAgent.trim();
    }

    public String getLogInfo() {
        return logInfo;
    }

    public void setLogInfo(String logInfo) {
        this.logInfo = logInfo == null ? null : logInfo.trim();
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType == null ? null : logType.trim();
    }

    public String getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation == null ? null : storeLocation.trim();
    }

    public String getStoreSuffix() {
        return storeSuffix;
    }

    public void setStoreSuffix(String storeSuffix) {
        this.storeSuffix = storeSuffix == null ? null : storeSuffix.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}