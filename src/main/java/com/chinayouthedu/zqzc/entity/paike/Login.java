package com.chinayouthedu.zqzc.entity.paike;

import com.chinayouthedu.zqzc.config.core.BaseBean;
import java.io.Serializable;
import java.util.Date;

/**
 * @表名称 zczx_login
 * @开发日期 2018-03-12 11:09:49
 * @开发作者 :中青至诚教育咨询有限公司 
 */
public class Login extends BaseBean implements Serializable {
    /** id (主健ID) (无默认值) */
    private Long id;

    /** 登录名(可选项) (无默认值) */
    private String loginName;

    /** 盐(可选项) (无默认值) */
    private String salt;

    /** 密码(可选项) (无默认值) */
    private String password;

    /** 用户id(可选项) (无默认值) */
    private Long userId;

    /** 创建时间(可选项) (无默认值) */
    private Date createTime;

    /** 更新时间(可选项) (无默认值) */
    private Date updateTime;

    /** 序号(可选项) (无默认值) */
    private Integer loginSort;

    /** 备注(可选项) (无默认值) */
    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Integer getLoginSort() {
        return loginSort;
    }

    public void setLoginSort(Integer loginSort) {
        this.loginSort = loginSort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}