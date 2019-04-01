package com.jingqi.dao;

import com.jingqi.domain.Role;
import com.jingqi.domain.User;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 用户dao层
 * @author Huxudong
 * @date 2019-01-30
 */
@Repository
public interface UserDao{
    /**
     * 根据姓名查询实体类信息
     * @author Huxudong
     * @date 2019-02-09
     * @param name    前端传过来的姓名
     * @return        根据姓名查询到的实体类
     */
    

    public User findByName(String name);

    /**
     * 根据id查询数据返回一个user对象
     * @author Huxudong
     * @date   2019-02-09
     * @param id   前端用户传入的id
     * @return     根据id返回的user对象
     */
    public User findById(String id);

    /**
     * 更新用户
     * @author  Huxudong
     * @date 2019-02-09
     * @param user    前端传入的user对象
     * @return        返回受影响的行数
     */
    public int update(User user);

    /**
     * 新增插入一条数据
     * @author Huxudong
     * @date 2019-02-09
     * @param user    前端传入的user对象
     * @return        受影响的行数
     */
    public int save(User user);

    /**
     * 根据用户名查询实体类的角色
     * @author           Huxudong
     * @date             2019-02-27
     * @param userName   登陆的用户名
     * @return           返回角色实体类
     */
    public Role findByRole(String userName);

    /**
     * 模糊查询所有的用户列表
     * @param userName   模糊查询的用户名
     * @param roleId     角色的id
     * @param begin      分页的初始
     * @param pageSize   分页的大小
     * @return           所有的用户列表
     */
    public List<User> findAllUser(@Param("userName") String userName,@Param("roleId") String roleId,@Param("begin") Integer begin,@Param("pageSize") Integer pageSize);

    /**
     * 查询所有用户的总数
     * @author           Huxudong
     * @date             2019-02-27
     * @param roleId     角色的id
     * @param userName   模糊查询的用户名
     * @return           用户总数
     */
    public int findAllUserCount(@Param("userName") String userName,@Param("roleId") String roleId);

    /**
     * 根据用户的id查询用户的实体类对象
     * @author           Huxudong
     * @date             2019-02-27
     * @param userId     用户的id
     * @return           返回用户的对象
     */
    public User findByUserId(String userId);

    /**
     * 删除一条用户
     * @author           Huxudong
     * @date             2019-02-27
     * @param userId     用户的id
     * @return           删除用户后受影响的行数
     */
    public int deleteUser(String userId);


}
