package com.jingqi.dao;

import com.jingqi.domain.Note;
import com.jingqi.domain.Public;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 笔记dao层
 * @author    Huxudong
 * @date      2019-02-18
 */
@Repository
public interface NoteDao {
    /**
     * 查询特定笔记本下的所有笔记的总数
     * @author                   Huxudong
     * @date                     2019-02-18
     * @param noteBookId         笔记本的id
     * @param userId             用户的登录id
     * @param noteType           笔记类型
     * @param noteTitle          笔记标题
     * @return                   笔记的总数
     */
    public int findNoteCount(@Param("noteBookId") String noteBookId, @Param("userId") String userId, @Param("noteType") String noteType,@Param("noteTitle") String noteTitle);

    /**
     * 查询特定笔记本下的所有笔记的集合
     * @author                   Huxudong
     * @date                     2019-02-18
     * @param userId             用户的登录id
     * @param noteType           笔记的类型
     * @param noteTitle          笔记的标题
     * @param updator            修改者id
     * @param begin              分页初始
     * @param pageSize           分页的每页大小
     * @return                   所有笔记的list集合
     */
    public List<Note> findAllNoteBack(@Param("userId") String userId,@Param("noteType") String noteType,@Param("noteTitle") String noteTitle,@Param("updator")String updator,@Param("begin") Integer begin,@Param("pageSize") Integer pageSize);

    /**
     * 查询特定笔记本下的所有笔记的集合
     * @author                   Huxudong
     * @date                     2019-02-18
     * @param noteBookId         笔记本的id
     * @param userId             用户的登录id
     * @param noteType           笔记的类型
     * @param noteTitle          笔记的标题
     * @param begin              分页初始
     * @param pageSize           分页的每页大小
     * @return                   所有笔记的list集合
     */
    public List<Note> findAllNote(@Param("noteBookId") String noteBookId,@Param("userId") String userId,@Param("noteType") String noteType,@Param("noteTitle") String noteTitle,@Param("begin") Integer begin,@Param("pageSize") Integer pageSize);


    /**
     * 根据笔记标题查询笔记实体类信息
     * @author                   Huxudong
     * @date                     2019-02-18
     * @param noteTitle          笔记的标题
     * @return                   笔记的实体类信息
     */
    public Note findByNoteTitle(String noteTitle);

    /**
     *创建一个笔记
     * @author                   Huxudong
     * @date                     2019-02-18
     * @param note               笔记的实体类
     * @return                   创建后受影响的行数
     */
    public int createNote(Note note);

    /**
     * 根据笔记的id查询笔记的实体类信息
     * @author                    Huxudong
     * @date                      2019-02-18
     * @param id                  笔记的id
     * @return                    笔记的实体类信息
     */
    public Note findByNoteId(String id);

    /**
     * 更新笔记实体类信息
     * @author                    Huxudong
     * @date                      2019-02-18
     * @param note                笔记的实体类
     * @return                    修改后受影响的行数
     */
    public int updateNote(Note note);

    /**
     * 删除笔记
     * @author                    Huxudong
     * @date                      2019-02-18
     * @param id                  笔记的id
     * @return                    s删除后受影响的行数
     */
    public int deleteNote(String id);

    /**
     * 回收一个笔记
     * @param note                 笔记实体类
     * @author                     Huxudong
     * @date                       2019-02-21
     * @return                     回收笔记后受影响的行数
     */
    public int recycleNote(Note note);

    /**
     * 还原一个笔记
     * @param note                  笔记实体类
     * @author                      Huxudong
     * @date                        2019-02-21
     * @return                      还原笔记后受影响的行数
     */
    public int restoreNote(Note note);

    /**
     * 查询
     * @param userId                 用户登陆的id
     * @param noteType               笔记的类型
     * @param noteTitle              笔记的标题
     * @param updator                修改者id
     * @author                       Huxudong
     * @date                         2019-02-21
     * @return
     */
    public int findNoteCountBack(@Param("userId") String userId, @Param("noteType") String noteType,@Param("noteTitle") String noteTitle,@Param("updator")String updator);

}
