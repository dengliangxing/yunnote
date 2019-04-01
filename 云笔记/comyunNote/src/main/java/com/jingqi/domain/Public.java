package com.jingqi.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 公开的笔记实体类
 * @author Huxudong
 * @createTime 2019-03-30 17:25:37
 **/
public class Public implements Serializable {
    /**
     * 公开笔记的id
     */
    private String publicId;
    /**
     * 笔记的id
     */
    private String noteId;
    /**
     * 笔记的内容
     */
    private String noteBody;

    /** 笔记名称 */
    private String noteName;

    /** 是否公开 */
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
    private Date createTime;

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public String getNoteBody() {
        return noteBody;
    }

    public void setNoteBody(String noteBody) {
        this.noteBody = noteBody;
    }

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public String getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(String isPublic) {
        this.isPublic = isPublic;
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
}
