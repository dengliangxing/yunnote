package com.jingqi.service.impl;

import com.jingqi.dao.NoteBookDao;
import com.jingqi.domain.NoteBook;
import com.jingqi.domain.User;
import com.jingqi.service.NoteBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 笔记本service层实现
 * @author  Huxudong
 * @date    2019-02-10
 */
@Service("NoteBookService")
public class NoteBookServiceImpl implements NoteBookService {
    @Autowired
    private NoteBookDao noteBookDao;
    @Override
    public List<NoteBook> findAll(String userId,String noteBookName,String noteBookType,Integer begin,Integer pageSize) {
        return this.noteBookDao.findAllNoteBook(userId,noteBookName,noteBookType,begin,pageSize);
    }

    @Override
    public int createBook(String noteBookType, String noteBookName, String noteBookDescription,String userId,String userName) {
        NoteBook noteBook = new NoteBook();
        noteBook.setNoteBookId(UUID.randomUUID().toString());
        noteBook.setUserId(userId);
        noteBook.setNoteBookType(noteBookType);
        noteBook.setNoteBookName(noteBookName);
        noteBook.setNoteBookDescription(noteBookDescription);
        noteBook.setCreator(userId);
        noteBook.setCreateName(userName);
        noteBook.setCreateTime(new Date());
        noteBook.setNoteBookStatus("1");
        return this.noteBookDao.createByBook(noteBook);
    }

    @Override
    public NoteBook findById(String id) {
        return this.noteBookDao.findByNoteBookId(id);
    }

    @Override
    public int deleteBookById(String id) {
        return this.noteBookDao.deleteNoteBookById(id);
    }

    @Override
    public NoteBook findByNoteBookName(String noteBookName) {
        return this.noteBookDao.findByName(noteBookName);
    }

    @Override
    public int update(String noteBookId,String noteBookType, String noteBookName, String noteBookDescription,User user) {
        NoteBook noteBook = new NoteBook();
        noteBook.setNoteBookId(noteBookId);
        noteBook.setNoteBookType(noteBookType);
        noteBook.setNoteBookName(noteBookName);
        noteBook.setNoteBookDescription(noteBookDescription);
        noteBook.setUpdator(user.getUserId());
        noteBook.setUpdateName(user.getUserName());
        noteBook.setUpdateTime(new Date());
        return this.noteBookDao.update(noteBook);
    }

    @Override
    public List<NoteBook> search(String noteBookName, String noteBookType,String userId) {
        return this.noteBookDao.findBySearch(noteBookName,noteBookType,userId);
    }

    @Override
    public int findCount(String userId,String noteBookName,String noteBookType ) {
        return this.noteBookDao.findByCount(userId,noteBookName,noteBookType);
    }

    @Override
    public List<NoteBook> findAllBack(String userId, String noteBookName, String noteBookType,String updator, Integer begin, Integer pageSize) {
        return this.noteBookDao.findAllNoteBookBack(userId,noteBookName,noteBookType,updator,begin,pageSize);
    }

    @Override
    public int findCountBack(String userId, String noteBookName, String noteBookType,String updator) {
        return this.noteBookDao.findByCountBack(userId,noteBookName,noteBookType,updator);
    }

    @Override
    public int recycleBookById(String id,User user) {
        NoteBook noteBook = new NoteBook();
        String userId = user.getUserId();
        String userName = user.getUserName();
        noteBook.setNoteBookId(id);
        noteBook.setNoteBookStatus("0");
        noteBook.setUpdator(userId);
        noteBook.setUpdateName(userName);
        noteBook.setUpdateTime(new Date());
        return this.noteBookDao.recycleBook(noteBook);
    }

    @Override
    public int restoreBook(String id, User user) {
        NoteBook noteBook = new NoteBook();
        noteBook.setNoteBookId(id);
        noteBook.setNoteBookStatus("1");
        noteBook.setUpdator(user.getUserId());
        noteBook.setUpdateName(user.getUserName());
        noteBook.setUpdateTime(new Date());
        return this.noteBookDao.restoreBook(noteBook);
    }

    @Override
    public int collectNoteBook(String id, User user) {
        NoteBook noteBook = new NoteBook();
        noteBook.setUpdator(user.getUserId());
        noteBook.setUpdateName(user.getUserName());
        noteBook.setUpdateTime(new Date());
        noteBook.setCollectNoteBookStatus("0");
        return this.noteBookDao.collectNoteBook(noteBook);
    }
}
