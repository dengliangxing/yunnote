package com.jingqi.service;

import com.jingqi.domain.Note;
import com.jingqi.domain.Public;
import com.jingqi.domain.User;

import java.util.List;

/**
 * 笔记service层
 * @author   Huxudong
 * @date     2019-02-18
 */
public interface NoteService {
    /**
     * 查询某个笔记本下的所有笔记的总数
     * @author                Huxudong
     * @date                  2019-02-18
     * @param noteBookId      笔记本的id
     * @param userId          用户的登录id
     * @param noteType        笔记类型
     * @param noteTitle       笔记标题
     * @return                查询笔记的总数
     */
     public int findNoteCount(String noteBookId,String userId,String noteType,String noteTitle);

    /**
     * 查询所有的笔记列表
     * @author                Huxudong
     * @date                  2019-02-18
     * @param userId          用户的登录id
     * @param noteType        笔记类型
     * @param noteTitle       笔记标题
     * @param updator         修改者id
     * @param begin           分页的初始
     * @param pageSize        分页的每页大小
     * @return                笔记的列表list集合
     */
     public List<Note> findAllNoteBack(String userId,String noteType,String noteTitle,String updator,Integer begin,Integer pageSize);

    /**
     * 查询所有的笔记列表
     * @author                Huxudong
     * @date                  2019-02-18
     * @param noteBookId      笔记本的id
     * @param userId          用户的登录id
     * @param noteType        笔记类型
     * @param noteTitle       笔记标题
     * @param begin           分页的初始
     * @param pageSize        分页的每页大小
     * @return                笔记的列表list集合
     */
    public List<Note> findAllNote(String noteBookId,String userId,String noteType,String noteTitle,Integer begin,Integer pageSize);



    /**
     * 根据笔记标题查询笔记
     * @author                Huxudong
     * @date                  2019-02-18
     * @param noteTitle       笔记标题
     * @return                笔记的实体类
     */
     public Note findByTitle(String noteTitle);

    /**
     * 创建一个笔记
     * @author   Huxudong
     * @date     2019-02-18
     * @param noteBookId      笔记本的id
     * @param userId          用户的登录id
     * @param userName        用户的登录姓名
     * @param noteType        笔记类型
     * @param noteTitle       笔记标题
     * @param noteBookTitle   所属笔记本
     * @param noteBody        笔记内容
     * @return                创建一条笔记后受影响的行数
     */
     public int createNote(String noteBookId,String userId,String userName,String noteType,String noteTitle,String noteBookTitle,String noteBody);

    /**
     * 根据笔记的id查询笔记实体类
     * @author                Huxudong
     * @date                  2019-02-18
     * @param id              笔记的id
     * @return                笔记的实体类
     */
     public Note findByNoteId(String id);

    /**
     * 保存修改笔记
     * @author                Huxudong
     * @date                  2019-02-18
     * @param noteId          笔记的id
     * @param noteType        笔记的类型
     * @param noteTitle       笔记的标题
     * @param noteBody        笔记的内容
     * @param user            用户的实体类对象
     * @return                修改笔记后受影响的行数
     */
     public int saveNote(String noteId,String noteType, String noteTitle,String noteBody, User user);

    /**
     * 删除笔记
     * @author               Huxudong
     * @date                 2019-02-18
     * @param id             笔记的id
     * @return               删除笔记后受影响的行数
     */
     public int deleteNote(String id);

    /**
     * 根据用户和笔记的id回收一个笔记
     * @author               Huxudong
     * @date                 2019-02-27
     * @param id             笔记的id
     * @param user           用户的登录的对象
     * @return               回收一个笔记本后受影响的行数
     */
     public int recycleNoteById(String id,User user);

    /**
     * 查询某个笔记本下的所有笔记的总数
     * @author                Huxudong
     * @date                  2019-02-18
     * @param userId          用户的登录id
     * @param noteType        笔记类型
     * @param noteTitle       笔记标题
     * @param updator         修改者id
     * @return                查询笔记的总数
     */
    public int findNoteCountBack(String userId,String noteType,String noteTitle,String updator);

    /**
     * 还原一个笔记
     * @author                Huxudong
     * @date                  2019-02-27
     * @param id              笔记的id
     * @param user            用户的登录对象
     * @return                还原一个笔记后受影响的行数
     */
    public int restoreNote(String id,User user);


}
