package com.jingqi.service.impl;

import com.jingqi.dao.NoteDao;
import com.jingqi.dao.PublicDao;
import com.jingqi.domain.Note;
import com.jingqi.domain.Public;
import com.jingqi.domain.User;
import com.jingqi.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 笔记service实现层
 * @author     Huxudong
 * @date       2019-02-18
 */
@Service("NoteService")
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteDao noteDao;
    @Autowired
    private PublicDao publicDao;
    @Override
    public int findNoteCount(String noteBookId, String userId, String noteType, String noteTitle) {
        return this.noteDao.findNoteCount(noteBookId,userId,noteType,noteTitle);
    }

    @Override
    public List<Note> findAllNote(String noteBookId, String userId, String noteType, String noteTitle, Integer begin, Integer pageSize) {
        return this.noteDao.findAllNote(noteBookId,userId,noteType,noteTitle,begin,pageSize);
    }

    @Override
    public Note findByTitle(String noteTitle) {
        return this.noteDao.findByNoteTitle(noteTitle);
    }

    @Override
    public int createNote(String noteBookId, String userId,String userName, String noteType, String noteTitle,String noteBookTitle, String noteBody) {
        Note note = new Note();
        note.setNoteId(UUID.randomUUID().toString());
        note.setNoteBookId(noteBookId);
        note.setUserId(userId);
        note.setNoteStatus("1");
        note.setNoteType(noteType);
        note.setNoteTitle(noteTitle);
        note.setNoteBookTitle(noteBookTitle);
        note.setNoteBody(noteBody);
        note.setIsPublic("0");
        note.setCreator(userId);
        note.setCreateName(userName);
        note.setCreateTime(new Date());
        return this.noteDao.createNote(note);
    }

    @Override
    public Note findByNoteId(String id) {
        return this.noteDao.findByNoteId(id);
    }

    @Override
    public int saveNote(String noteId,String noteType, String noteTitle,String noteBody, User user) {
        Note note = new Note();
        note.setNoteId(noteId);
        note.setNoteType(noteType);
        note.setNoteTitle(noteTitle);
        note.setNoteBody(noteBody);
        note.setIsPublic("1");
        note.setUpdator(user.getUserId());
        note.setUpdateName(user.getUserName());
        note.setUpdateTime(new Date());
        return this.noteDao.updateNote(note);
    }

    @Override
    public int deleteNote(String id) {
        return this.noteDao.deleteNote(id);
    }

    @Override
    public int recycleNoteById(String id,User user) {
        Note note = new Note();
        note.setNoteId(id);
        note.setNoteStatus("0");
        note.setUpdator(user.getUserId());
        note.setUpdateName(user.getUserName());
        note.setUpdateTime(new Date());
        return this.noteDao.recycleNote(note);
    }

    @Override
    public int findNoteCountBack( String userId, String noteType, String noteTitle,String updator) {
        return this.noteDao.findNoteCountBack(userId,noteType,noteTitle,updator);
    }

    @Override
    public List<Note> findAllNoteBack( String userId, String noteType, String noteTitle,String updator, Integer begin, Integer pageSize) {
        return this.noteDao.findAllNoteBack(userId,noteType,noteTitle,updator,begin,pageSize);
    }

    @Override
    public int restoreNote(String id, User user) {
        Note note = new Note();
        note.setNoteId(id);
        note.setNoteStatus("1");
        note.setUpdator(user.getUserId());
        note.setUpdateName(user.getUserName());
        note.setUpdateTime(new Date());
        return this.noteDao.restoreNote(note);
    }

}
