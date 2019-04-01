package com.jingqi.dao;

import com.jingqi.domain.Note;
import com.jingqi.domain.NoteBook;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 笔记本dao层
 * @author Huxudong
 * @date 2019-02-11
 */
@Repository
public interface NoteBookDao {
    /**
     * 查询所有的笔记本
     * @author        Huxudong
     * @date          2019-02-11
     * @param userId  用户的id
     * @param noteBookName 笔记本名称
     * @param noteBookType 笔记本类型
     * @param begin   分页的开始
     * @param pageSize 分页的结束
     * @return        查询的所有的笔记本的对象的集合
     */
    public List<NoteBook> findAllNoteBook(@Param("userId") String userId,@Param("noteBookName") String noteBookName,@Param("noteBookType") String noteBookType,@Param("begin")Integer begin,@Param("pageSize")Integer pageSize);


    /**
     * 查询所有的笔记本
     * @author        Huxudong
     * @date          2019-02-11
     * @param userId  用户的id
     * @param noteBookName 笔记本名称
     * @param noteBookType 笔记本类型
     * @param updator      修改者id
     * @param begin   分页的开始
     * @param pageSize 分页的结束
     * @return        查询的所有的笔记本的对象的集合
     */
    public List<NoteBook> findAllNoteBookBack(@Param("userId") String userId,@Param("noteBookName") String noteBookName,@Param("noteBookType") String noteBookType,@Param("updator") String updator,@Param("begin")Integer begin,@Param("pageSize")Integer pageSize);


    /**
     * 新增一条笔记本信息
     * @author           Huxudong
     * @date             2019-02-15
     * @param noteBook    前端新建的笔记本的实体类信息
     * @return            新建成功后受影响的行数
     */
    public int createByBook(NoteBook noteBook);

    /**
     * 根据具体的id查询笔记本的实体类的信息
     * @author     Huxudong
     * @date       2019-02-15
     * @param id          前端传过来的id
     * @return            一条笔记本的实体类的信息
     */
    public NoteBook findByNoteBookId(String id);

    /**
     * 删除一条笔记本记录
     * @author      Huxudong
     * @date        2019-02-15
     * @param id    前端传入的id
     * @return      删除数据后受影响的行数
     */
    public int deleteNoteBookById(String id);

    /**
     * 根据笔记本名称查询实体类信息并返回实体类对象
     * @author      Huxudong
     * @date        2019-02-16
     * @param noteBookName   前端传过来的笔记本名称
     * @return               返回该笔记本的实体类对象
     */
    public NoteBook findByName(String noteBookName);

    /**
     * 笔记本的修改保存
     * @author         Huxudong
     * @date           2019-02-16
     * @param noteBook  封装的修改将要保存的对象的信息
     * @return          修改保存后受影响的行数
     */
    public int update(NoteBook noteBook);

    /**
     * 根据条件进行模糊查询
     * @author               Huxudong
     * @date                 2019-02-16
     * @param noteBookName   笔记本名称参数
     * @param noteBookType   笔记本类型参数
     * @param userId         用户登录的id
     * @return               笔记本的实体类集合
     */
    public List<NoteBook> findBySearch(@Param("noteBookName") String noteBookName, @Param("noteBookType") String noteBookType,@Param("userId")String userId);

    /**
     * 查询笔记本的总数并返回整型
     * @author               Huxudong
     * @date                 2019-02-17
     * @param userId         用户登录的id
     * @param noteBookName   笔记本名称
     * @param noteBookType   笔记本类型
     * @return               查询笔记本的总数
     */
    public int findByCount(@Param("userId") String userId,@Param("noteBookName") String noteBookName,@Param("noteBookType") String noteBookType);

    /**
     * 查询笔记本的总数并返回整型
     * @author               Huxudong
     * @date                 2019-02-17
     * @param userId         用户登录的id
     * @param noteBookName   笔记本名称
     * @param noteBookType   笔记本类型
     * @param updator        修改者id
     * @return               查询笔记本的总数
     */
    public int findByCountBack(@Param("userId") String userId,@Param("noteBookName") String noteBookName,@Param("noteBookType") String noteBookType,@Param("updator") String updator);

    /**
     * 回收笔记本
     * @author               Huxudong
     * @date                 2019-02-19
     * @param noteBook       笔记本实体类
     * @return               回收笔记本后受影响的行数
     */
    public int recycleBook(NoteBook noteBook);

    /**
     * 还原一个笔记本
     * @param noteBook       笔记本实体类
     * @author               Huxudong
     * @date                 2019-02-21
     * @return               还原笔记本后受影响的行数
     */
    public int restoreBook(NoteBook noteBook);

    /**
     * 收藏一条笔记本
     * @param noteBook       笔记本实体类
     * @author               Huxudong
     * @date                 2019-02-21
     * @return               收藏笔记本后受影响的行数
     */
    public int collectNoteBook(NoteBook noteBook);
}
