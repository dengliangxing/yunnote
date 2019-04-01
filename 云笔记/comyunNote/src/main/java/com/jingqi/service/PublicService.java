package com.jingqi.service;

import com.jingqi.domain.Note;
import com.jingqi.domain.Public;
import com.jingqi.domain.User;

import java.util.List;

/**
 * 公开笔记的service层
 * @author Huxudong
 * @createTime 2019-03-30 19:41:54
 **/
public interface PublicService {
    /**
     * 公开笔记
     * @author Huxudong
     * @createTime 2019-03-30 19:57:18
     * @param  note         笔记实体类
     * @param  user         用户实体类
     * @return int          受影响的行数
     **/
    public int publicNote(Note note, User user);
    /**
     * 所有公开的笔记总数
     * @author Huxudong
     * @createTime 2019-03-30 20:27:08
     * @param
     * @return int    受影响的行数
     **/
    public int findByCount();

    /**
     * @author Huxudong
     * @createTime 2019-03-30 20:35:28
     * @param begin                                          分页的初始
     * @param pageSize                                       公开笔记的大小
     * @return java.util.List<com.jingqi.domain.Public>      返回公开笔记的集合
     **/
    public List<Public> findAllPublic(Integer begin, Integer pageSize);

    /**
     * 根据id查询公开的笔记本
     * @author Huxudong
     * @createTime 2019-03-30 22:27:55
     * @param id     公开的笔记本
     * @return com.jingqi.domain.Public   公开笔记实体类信息
     **/
    public Public findByPublicNote(String id);

    /**
     * 删除一条公开的笔记
     * @author Huxudong
     * @createTime 2019-03-30 23:53:02
     * @param id           公开笔记id
     * @return int         返回受影响的行数
     **/
    public int deletePublicNote(String id);

    /**
     * 根据笔记id查询
     * @author Huxudong
     * @createTime 2019-03-31 08:57:53
     * @param noteId          笔记的id
     * @return com.jingqi.domain.Public       公开的笔记的实体类
     **/
    public Public findByPublicNoteId(String noteId);

    /**
     * 根据笔记id删除一条公开的笔记
     * @author Huxudong
     * @createTime 2019-03-31 11:06:03
     * @param noteId     笔记id
     * @return int       受影响的行数
     **/
    public int deleteByNoteId(String noteId);
}
