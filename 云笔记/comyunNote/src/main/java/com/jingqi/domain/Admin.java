package com.jingqi.domain;

import java.io.Serializable;

/**
 * 管理员实体类
 * @author     Huxudong
 * @date       2019-02-21
 */
public class Admin implements Serializable {
    /**
     * 管理员登录的id
     */
    private String adminId;
    /**
     * 管理员登录的姓名
     */
    private String adminName;
    /**
     * 管理员登录的密码
     */
    private String adminPassword;

    /**
     * 角色id
     */
    private String roleId;

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
