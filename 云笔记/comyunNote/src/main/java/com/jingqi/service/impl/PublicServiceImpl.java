package com.jingqi.service.impl;

import com.jingqi.dao.PublicDao;
import com.jingqi.domain.Note;
import com.jingqi.domain.Public;
import com.jingqi.domain.User;
import com.jingqi.service.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 公开笔记service实现层
 * @author Huxudong
 * @createTime 2019-03-30 19:44:52
 **/
@Service("PublicService")
public class PublicServiceImpl implements PublicService {
    @Autowired
    private PublicDao publicDao;

    @Override
    public int publicNote(Note note, User user) {
        Public pub = new Public();
        pub.setPublicId(UUID.randomUUID().toString());
        pub.setNoteId(note.getNoteId());
        pub.setNoteName(note.getNoteTitle());
        pub.setNoteBody(note.getNoteBody());
        pub.setIsPublic("1");
        pub.setCreator(user.getUserId());
        pub.setCreateName(user.getUserName());
        pub.setCreateTime(new Date());
        return this.publicDao.addPublicNote(pub);
    }

    @Override
    public int findByCount() {
        return this.publicDao.findCount();
    }

    @Override
    public List<Public> findAllPublic(Integer begin, Integer pageSize) {
        return this.publicDao.findAllPublic(begin,pageSize);
    }

    @Override
    public Public findByPublicNote(String id) {
        return this.publicDao.findByPublicId(id);
    }

    @Override
    public int deletePublicNote(String id) {
        return this.publicDao.deletePublicNote(id);
    }

    @Override
    public Public findByPublicNoteId(String noteId) {
        return this.publicDao.findByPublicNoteId(noteId);
    }

    @Override
    public int deleteByNoteId(String noteId) {
        return this.publicDao.deleteByNoteId(noteId);
    }
}
