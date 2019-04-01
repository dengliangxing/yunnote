package com.jingqi.service.impl;

import com.jingqi.dao.CollectDao;
import com.jingqi.domain.Collect;
import com.jingqi.domain.Note;
import com.jingqi.domain.NoteBook;
import com.jingqi.domain.User;
import com.jingqi.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * 收藏接口实现层
 * @author     Huxudong
 * @date       2019-02-21
 */
@Service("CollectService")
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectDao collectDao;
    @Override
    public int collectNoteBook(NoteBook noteBook, User user) {
        Collect collect = new Collect();
        collect.setCollectId(UUID.randomUUID().toString());
        collect.setNoteBookId(noteBook.getNoteBookId());
        collect.setUserId(user.getUserId());
        collect.setNoteBookType(noteBook.getNoteBookType());
        collect.setNoteBookName(noteBook.getNoteBookName());
        collect.setNoteBookDescription(noteBook.getNoteBookDescription());
        collect.setNoteBookStatus(noteBook.getNoteBookStatus());
        collect.setCreator(user.getUserId());
        collect.setCreateName(user.getUserName());
        collect.setCreateTime(new Date());
        collect.setCollectStatus("0");
        return this.collectDao.createCollect(collect);
    }

    @Override
    public int findCollectCount(String userId) {
        return this.collectDao.findCollectCount(userId);
    }

    @Override
    public List<Collect> findAllCollect(String userId,Integer begin, Integer pageSize) {
        return this.collectDao.findAllCollect(userId,begin,pageSize);
    }

    @Override
    public int deleteCollect(String collectId) {
        return this.collectDao.deleteCollect(collectId);
    }

    @Override
    public Collect lookBookNote(String id) {
        return this.collectDao.lookBookNote(id);
    }

    @Override
    public int findCollectNoteCount(String userId) {
        return this.collectDao.findCollectNoteCount(userId);
    }

    @Override
    public List<Collect> findAllCollectNote(String userId, Integer begin, Integer pageSize) {
        return this.collectDao.findAllCollectNote(userId,begin,pageSize);
    }

    @Override
    public int collectNote(Note note, User user) {
        Collect collect = new Collect();
        collect.setCollectId(UUID.randomUUID().toString());
        collect.setNoteId(note.getNoteId());
        collect.setUserId(user.getUserId());
        collect.setNoteStatus(note.getNoteStatus());
        collect.setNoteType(note.getNoteType());
        collect.setNoteTitle(note.getNoteTitle());
        collect.setNoteBody(note.getNoteBody());
        collect.setNoteBookTitle(note.getNoteBookTitle());
        collect.setCreator(user.getUserId());
        collect.setCreateName(user.getUserName());
        collect.setCreateTime(new Date());
        collect.setCollectStatus("1");
        return this.collectDao.createCollectNote(collect);
    }

}
