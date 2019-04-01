package com.jingqi.service;

import com.jingqi.domain.Collect;
import com.jingqi.domain.Note;
import com.jingqi.domain.NoteBook;
import com.jingqi.domain.User;

import java.util.List;

/**
 * 收藏接口层
 * @author    Huxudong
 * @date      2019-02-21
 */
public interface CollectService {
    /**
     * 根据具体用户收集笔记本
     * @author               Huxudong
     * @date                 2019-02-27
     * @param noteBook       笔记本对象
     * @param user           用户的对象信息
     * @return               收集笔记本后受影响的行数
     */
    public int collectNoteBook(NoteBook noteBook, User user);

    /**
     * 根据用户id查询用户收集的笔记本总数
     * @author               Huxudong
     * @date                 2019-02-27
     * @param userId         用户的id
     * @return               该用户收集的笔记本的总数
     */
    public int findCollectCount(String userId);

    /**
     * 查询所有的笔记本的列表集合
     * @author               Huxudong
     * @date                 2019-02-27
     * @param begin          分页的初始
     * @param userId         用户的id
     * @param pageSize       分页的大小
     * @return               根据用户id分页查询所有的笔记本的集合
     */
    public List<Collect> findAllCollect(String userId,Integer begin,Integer pageSize);

    /**
     * 根据收集的笔记本或者笔记的id删除一个笔记本或者笔记
     * @author               Huxudong
     * @date                 2019-02-27
     * @param collectId      收集的笔记本或者笔记的id
     * @return               删除笔记本或者笔记受影响的行数
     */
    public int deleteCollect(String collectId);

    /**
     * 根据笔记本id查询笔记本的实体类对象信息
     * @author               Huxudong
     * @date                 2019-02-27
     * @param id             笔记本的id
     * @return               笔记本的实体类对象
     */
    public Collect lookBookNote(String id);

    /**
     * 根据用户的id查询收集的笔记的总数
     * @author               Huxudong
     * @date                 2019-02-27
     * @param userId         用户的id
     * @return               收集的笔记的总数
     */
    public int findCollectNoteCount(String userId);

    /**
     * 根据用户的id查询所有的收集的笔记的列表的集合
     * @author               Huxudong
     * @date                 2019-02-27
     * @param userId         用户的id
     * @param begin          分页的初始
     * @param pageSize       分页的页面的大小
     * @return
     */
    public List<Collect> findAllCollectNote(String userId,Integer begin,Integer pageSize);

    /**
     * 收集一条笔记并返回受影响的行数
     * @author               Huxudong
     * @date                 2019-02-27
     * @param note           笔记的实体类信息
     * @param user           用户的对象
     * @return               收集一条笔记后返回受影响的行数
     */
    public int collectNote(Note note, User user);



}
