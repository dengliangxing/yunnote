package com.jingqi.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 笔记本实体类
 * @author Huxudong
 * @date   2019-02-10
 */
public class NoteBook implements Serializable {
    /**
     * 笔记本id
     */
    private String noteBookId;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 笔记本类型
     */
    private String noteBookType;
    /**
     * 笔记本名字
     */
    private String noteBookName;
    /**
     * 笔记本描述
     */
    private String noteBookDescription;
    /**
     * 笔记本创建者id
     */
    private String creator;
    /**
     * 笔记本创建者姓名
     */
    private String createName;
    /**
     * 笔记本创建时间
     */
    private Date   createTime;
    /**
     * 笔记本修改者id
     */
    private String updator;
    /**
     * 笔记本修改者姓名
     */
    private String updateName;
    /**
     * 笔记本修改时间
     */
    private Date   updateTime;
    /**
     * 笔记本状态
     */
    private String noteBookStatus;
    /**
     * 笔记本收藏状态
     */
    private String collectNoteBookStatus;
    /**
     * 关联查询时用到
     */
    private User user;

    public String getNoteBookId() {
        return noteBookId;
    }

    public void setNoteBookId(String noteBookId) {
        this.noteBookId = noteBookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNoteBookType() {
        return noteBookType;
    }

    public void setNoteBookType(String noteBookType) {
        this.noteBookType = noteBookType;
    }

    public String getNoteBookName() {
        return noteBookName;
    }

    public void setNoteBookName(String noteBookName) {
        this.noteBookName = noteBookName;
    }

    public String getNoteBookDescription() {
        return noteBookDescription;
    }

    public void setNoteBookDescription(String noteBookDescription) {
        this.noteBookDescription = noteBookDescription;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNoteBookStatus() {
        return noteBookStatus;
    }

    public void setNoteBookStatus(String noteBookStatus) {
        this.noteBookStatus = noteBookStatus;
    }

    public String getCollectNoteBookStatus() {
        return collectNoteBookStatus;
    }

    public void setCollectNoteBookStatus(String collectNoteBookStatus) {
        this.collectNoteBookStatus = collectNoteBookStatus;
    }
}
