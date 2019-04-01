package com.jingqi.domain;

import java.io.Serializable;

/**
 * 用户角色实体类
 * @author     Huxudong
 * @date       2019-02-21
 */
public class Role implements Serializable {
    /**
     * 角色id
     */
    private String roleId;
    /**
     * 角色类型
     */
    private String roleType;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
}
