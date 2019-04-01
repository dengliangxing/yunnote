package com.jingqi.service;
import com.jingqi.domain.NoteBook;
import com.jingqi.domain.User;

import java.util.List;

/**
 * 笔记本service接口层
 * @author     Huxudong
 * @date       2019-02-10
 */
public interface NoteBookService {
    /**
     * 根据用户的id查询所有的笔记本的对象集合并返回
     * @author              Huxudong
     * @date                2019-02-12
     * @param userId        用户的id
     * @param noteBookName  笔记本名称
     * @param noteBookType  笔记本类型
     * @param begin         分页的起始
     * @param pageSize      分页的结束
     * @return              所有笔记本的对象的集合
     */
    public List<NoteBook> findAll(String userId,String noteBookName,String noteBookType,Integer begin,Integer pageSize);

    /**
     * 根据用户的id查询所有的笔记本的对象集合并返回
     * @author              Huxudong
     * @date                2019-02-12
     * @param userId        用户的id
     * @param noteBookName  笔记本名称
     * @param noteBookType  笔记本类型
     * @param updator       修改者id
     * @param begin         分页的起始
     * @param pageSize      分页的结束
     * @return              所有笔记本的对象的集合
     */
    public List<NoteBook> findAllBack(String userId,String noteBookName,String noteBookType,String updator,Integer begin,Integer pageSize);

    /**
     * 创建新的笔记本
     * @author    Huxudong
     * @date      2019-02-13
     * @param noteBookType      前端传过来的笔记本类型
     * @param noteBookName      前端传过来的笔记本名称
     * @param noteBookDescription  前段传过来的笔记本描述
     * @param userId             session对象记录的用户登录的id
     * @param userName           session对象记录的用户登录的姓名
     * @return                   新建数据后受影响的行数
     */
    public int createBook(String noteBookType,String noteBookName,String noteBookDescription,String userId,String userName);

    /**
     * 根据前端查询到的id查询对应的实体类的对象
     * @author       Huxudong
     * @date         2019-02-15
     * @param id     前端传过来的id
     * @return       查询到的笔记本的实体类对象
     */
    public NoteBook findById(String id);

    /**
     * 删除一条笔记本记录
     * @author         Huxudong
     * @date           2019-02-15
     * @param id       前端传过来的id
     * @return         删除后受影响的行数
     */
    public int deleteBookById(String id);

    /**
     * 根据笔记本名称查询信息并返回该笔记本的实体类对象
     * @author          Huxudong
     * @date            2019-02-16
     * @param noteBookName  前端传过来的笔记本的名称
     * @return              返回一个笔记本实体类对象
     */
    public NoteBook findByNoteBookName(String noteBookName);

    /**
     * 保存修改笔记本的信息并返回受影响的行数
     * @author            Huxudong
     * @date              2019-02-16
     * @param noteBookId        前端传过来的笔记本的id
     * @param noteBookType      前端传过来的笔记本类型
     * @param noteBookName      前端传过来的笔记本名称
     * @param noteBookDescription  前段传过来的笔记本描述
     * @param user                当前登录用户的信息
     * @return                   修改成功后受影响的行数
     */
    public int update(String noteBookId,String noteBookType, String noteBookName, String noteBookDescription, User user);

    /**
     * 根据笔记本名称和类型进行模糊查询
     * @auhtor                   Huxudong
     * @date                     2019-02-16
     * @param noteBookName       前端笔记本名称参数
     * @param noteBookType       前端笔记本类型参数
     * @param userId             用户登录的session的id
     * @return                   查询到的符合条件的笔记本的list集合
     */
    public List<NoteBook> search(String noteBookName,String noteBookType,String userId);

    /**
     * 查询笔记本总数并返回
     * @author                   Huxudong
     * @date                     2019-02-17
     * @param userId             用户登录的id
     * @param noteBookName       笔记本名称
     * @param noteBookType       笔记本类型
     * @return                   笔记本总数
     */
    public int findCount(String userId,String noteBookName,String noteBookType);

    /**
     * 查询笔记本总数并返回
     * @author                   Huxudong
     * @date                     2019-02-17
     * @param userId             用户登录的id
     * @param noteBookName       笔记本名称
     * @param noteBookType       笔记本类型
     * @param updator            修改者id
     * @return                   笔记本总数
     */
    public int findCountBack(String userId,String noteBookName,String noteBookType,String updator);

    /**
     * 回收笔记本到回收站
     * @author                   Huxudong
     * @date                     2019-02-19
     * @param id                 笔记本的id
     * @param user               用户的登录对象
     * @return                   回收笔记本后受影响的行数
     */
    public int recycleBookById(String id,User user);

    /**
     * 从回收站还原一条笔记本
     * @author                   Huxudong
     * @date                     2019-02-27
     * @param id                 笔记本的id
     * @param user               用户的登录对象
     * @return                   还原笔记本后受影响的行数
     */
    public int restoreBook(String id,User user);

    /**
     * 收集一条笔记本根据笔记本id和登录的用户并返回一条收集成功后受影响的行数
     * @author                   Huxudong
     * @sate                     2019-02-27
     * @param id                 笔记本的id
     * @param user               用户的登录对象
     * @return                   收集笔记本后受影响的行数
     */
    public int collectNoteBook(String id,User user);
}
