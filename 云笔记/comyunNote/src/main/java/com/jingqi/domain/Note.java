package com.jingqi.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 笔记实体类
 * @author Huxudong
 * @date 2019-02-10
 */
public class Note implements Serializable {
    /**
     * 笔记id
     */
    private String noteId;
    /**
     * 笔记本id
     */
    private String noteBookId;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 笔记状态id
     */
    private String noteStatusId;
    /**
     * 笔记状态
     */
    private String noteStatus;
    /**
     * 笔记类型id
     */
    private String noteTypeId;
    /**
     * 笔记类型
     */
    private String noteType;
    /**
     * 笔记标题
     */
    private String noteTitle;
    /**
     * 该笔记所属哪个笔记本
     */
    private String noteBookTitle;
    /**
     * 笔记内容
     */
    private String noteBody;
    /**
     * 是否公开笔记
     */
    private String isPublic;
    /**
     * 笔记创建者id
     */
    private String creator;
    /**
     * 笔记创建者姓名
     */
    private String createName;
    /**
     * 笔记创建时间
     */
    private Date   createTime;
    /**
     * 笔记修改者
     */
        private String updator;
    /**
     * 笔记修改者姓名
     */
    private String updateName;
    /**
     * 笔记修改时间
     */
    private Date   updateTime;
    /**
     * 笔记收藏状态
     */
    private String collectNoteStatus;

    public String getNoteId() {
        return noteId;
    }

    /**
     * 关联查询用到
     */
    private User user;

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

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

    public String getNoteStatusId() {
        return noteStatusId;
    }

    public void setNoteStatusId(String noteStatusId) {
        this.noteStatusId = noteStatusId;
    }

    public String getNoteTypeId() {
        return noteTypeId;
    }

    public void setNoteTypeId(String noteTypeId) {
        this.noteTypeId = noteTypeId;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteBody() {
        return noteBody;
    }

    public void setNoteBody(String noteBody) {
        this.noteBody = noteBody;
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

    public String getNoteType() {
        return noteType;
    }

    public void setNoteType(String noteType) {
        this.noteType = noteType;
    }

    public String getNoteStatus() {
        return noteStatus;
    }

    public void setNoteStatus(String noteStatus) {
        this.noteStatus = noteStatus;
    }

    public String getNoteBookTitle() {
        return noteBookTitle;
    }

    public void setNoteBookTitle(String noteBookTitle) {
        this.noteBookTitle = noteBookTitle;
    }

    public String getCollectNoteStatus() {
        return collectNoteStatus;
    }

    public void setCollectNoteStatus(String collectNoteStatus) {
        this.collectNoteStatus = collectNoteStatus;
    }

    public String getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(String isPublic) {
        this.isPublic = isPublic;
    }
}
