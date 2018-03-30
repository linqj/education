package com.chinayouthedu.zqzc.entity.paike;

import com.chinayouthedu.zqzc.config.core.BaseBean;
import java.io.Serializable;
import java.util.Date;

/**
 * @表名称 zczx_role_ugroup
 * @开发日期 2018-03-12 11:09:49
 * @开发作者 :中青至诚教育咨询有限公司 
 */
public class RoleUgroup extends BaseBean implements Serializable {
    /** id (主健ID) (无默认值) */
    private Long id;

    /** 角色id(可选项) (无默认值) */
    private Long roleId;

    /** 用户组id(可选项) (无默认值) */
    private Long ugroupId;

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

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUgroupId() {
        return ugroupId;
    }

    public void setUgroupId(Long ugroupId) {
        this.ugroupId = ugroupId;
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