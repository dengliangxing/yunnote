package com.jingqi.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 收藏实体类
 * @author  Huxudong
 * @date    2019-02-21
 */
public class Collect implements Serializable {
    /**
     * 收藏的id
     */
    private String collectId;
    /**
     * 收藏的笔记本的id
     */
    private String noteBookId;
    /**
     * 收藏的笔记的id
     */
    private String noteId;
    /**
     * 用户登录的id
     */
    private String userId;
    /**
     * 笔记本的类型
     */
    private String noteBookType;
    /**
     * 笔记本名称
     */
    private String noteBookName;
    /**
     * 笔记本描述
     */
    private String noteBookDescription;
    /**
     * 笔记本状态
     */
    private String noteBookStatus;
    /**
     * 笔记状态
     */
    private String noteStatus;
    /**
     * 笔记类型
     */
    private String noteType;
    /**
     * 笔记标题
     */
    private String noteTitle;
    /**
     * 隶属于那个笔记本
     */
    private String noteBookTitle;
    /**
     * 笔记内容
     */
    private String noteBody;
    /**
     * 收藏者
     */
    private String creator;
    /**
     * 收藏人姓名
     */
    private String createName;
    /**
     * 收藏时间
     */
    private Date   createTime;
    /**
     * 收藏更新者
     */
    private String updator;
    /**
     * 收藏更新者姓名
     */
    private String updateName;
    /**
     * 收藏更新时间
     */
    private Date   updateTime;
    /**
     * 收藏状态
     */
    private String collectStatus;

    public String getCollectId() {
        return collectId;
    }

    public void setCollectId(String collectId) {
        this.collectId = collectId;
    }

    public String getNoteBookId() {
        return noteBookId;
    }

    public void setNoteBookId(String noteBookId) {
        this.noteBookId = noteBookId;
    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
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

    public String getNoteBookStatus() {
        return noteBookStatus;
    }

    public void setNoteBookStatus(String noteBookStatus) {
        this.noteBookStatus = noteBookStatus;
    }

    public String getNoteStatus() {
        return noteStatus;
    }

    public void setNoteStatus(String noteStatus) {
        this.noteStatus = noteStatus;
    }

    public String getNoteType() {
        return noteType;
    }

    public void setNoteType(String noteType) {
        this.noteType = noteType;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteBookTitle() {
        return noteBookTitle;
    }

    public void setNoteBookTitle(String noteBookTitle) {
        this.noteBookTitle = noteBookTitle;
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

    public String getCollectStatus() {
        return collectStatus;
    }

    public void setCollectStatus(String collectStatus) {
        this.collectStatus = collectStatus;
    }
}
