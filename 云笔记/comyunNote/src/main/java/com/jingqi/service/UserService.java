package com.jingqi.service;

import com.jingqi.domain.Role;
import com.jingqi.domain.User;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户的业务处理方法
 * @author Huxudong
 * @date 2018-01-23
 */
public interface UserService {

    /**
     * 用户登录
     * @author              Huxudong
     * @date                2019-01-23
     * @param name          登录的用户名
     * @param password      登录的用户的密码
     * @return              json字符串
     */
    public User checkLogin(String name, String password);

    /**
     * 根据用户的session的id获取用户的信息
     * @author              Huxudong
     * @date                2019-02-07
     * @param id            用户session的ID
     * @return              用户的对象信息
     */
    public User optional(String id);

    /**
     * 保存用户session的信息
     * @author              Huxudong
     * @date                2019-02-07
     * @param user          用户的对象
     */
    public void save(User user);

    /**
     * 根据用户名查询数据库中是否有用户
     * @author              Huxudong
     * @date                2019-02-09
     * @param userName      前端传过来用户名
     * @return              user对象
     */
    public User checkUserName(String userName);

    /**
     * 新增一条数据
     * @author              Huxudong
     * @date                2019-02-09
     * @param user          前端传入的user对象
     * @return              受影响的行数
     */
    public int insert(User user);

    /**
     * 根据用户名查询角色实体类
     * @author             Huxudong
     * @date               2019-02-27
     * @param userName     用户名
     * @return             角色对象
     */
    public Role findRole(String userName);

    /**
     * 模糊查询并返回用户的列表的集合
     * @param userName     用户名
     * @param begin        每页分页的开始
     * @param pageSize     分页的大小
     * @return             用户的列表的集合
     */
    public List<User> findAllUser(@Param("userName") String userName, Integer begin, Integer pageSize);

    /**
     * 模糊查询所有的用户列表集合
     * @author             Huxudong
     * @date               2019-02-27
     * @param userName     模糊查询输入的用户名
     * @return             所有的用户的总数
     */
    public int findAllUserCount(String userName);

    /**
     * 根据用户的id查询一个用户的实体类信息
     * @author             Huxudong
     * @date               2019-02-27
     * @param userId       用户的登陆的id
     * @return             用户的实体类信息
     */
    public User findByUserId(String userId);

    /**
     * 根据用户的id修改用户信息
     * @author             Huxudong
     * @date               2019-02-27
     * @param userId       用户的id
     * @param userName     用户名
     * @param userPassword 用户密码
     * @param session      记录用户的session对象
     * @return             修改后受影响的行数
     */
    public int updateUser(String userId, String userName, String userPassword, HttpSession session);

    /**
     * 超级管理员删除一条用户的信息
     * @author             Huxudong
     * @date               2019-02-27
     * @param userId       用户的id
     * @return             删除用户后受影响的行数
     */
    public int deleteUser(String userId);

    /**
     * 模糊查询所有普通管理员的总数
     * @author             Huxudong
     * @date               2019-02-27
     * @param userName     模糊查询的用户名
     * @return             返回所有满足条件的管理员的总数
     */
    public int findAllAdminCount(String userName);

    /**
     * 查询所有普通管理员的列表的集合
     * @param userName     模糊查询的用户名
     * @param begin        每页跟页的初始
     * @param pageSize     分页的大小
     * @return             所有管理员的列表的集合
     */
    public List<User> findAllAdmin(@Param("userName") String userName, Integer begin, Integer pageSize);

}
