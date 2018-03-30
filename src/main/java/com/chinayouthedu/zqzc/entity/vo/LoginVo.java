package com.chinayouthedu.zqzc.entity.vo;

import java.io.Serializable;

import com.chinayouthedu.zqzc.config.annotation.RequestVo;
import com.chinayouthedu.zqzc.config.core.BaseBean;

/**
 * 登录用户VO
 */
@RequestVo
public class LoginVo extends BaseBean implements Serializable {
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

    /** 序号(可选项) (无默认值) */
    private Integer loginSort;

    /** 验证码  */
    private String code;

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

    public Integer getLoginSort() {
        return loginSort;
    }

    public void setLoginSort(Integer loginSort) {
        this.loginSort = loginSort;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
}