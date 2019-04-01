package com.jingqi.domain;
import java.awt.print.Book;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户实体类
 * @author Huxudong
 * @date 2018-12-30
 */
public class User implements Serializable {
    /**
     *用户的登录ID
     */
    private String userId;
    /**
     *用户的登录姓名
     */
    private String userName;
    /**
     *用户的登录密码
     */
    private String userPassword;
    /**
     *用户说明
     */
    private String userNick;
    /**
     * 角色的id
     */
    private String roleId;

    /**
     * 创建用户的登陆者id
     */
    private String creator;
    /**
     * 创建用户的登陆者姓名
     */
    private String createName;
    /**
     * 用户创建的时间
     */
    private Date createTime;
    /**
     * 修改用户的登陆者id
     */
    private String updator;
    /**
     * 修改用户的登陆者姓名
     */
    private String updateName;
    /**
     * 修改用户的时间
     */
    private Date updateTime;
    /**
     *笔记本对象的List集合
     */
    private List<Book> books;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
