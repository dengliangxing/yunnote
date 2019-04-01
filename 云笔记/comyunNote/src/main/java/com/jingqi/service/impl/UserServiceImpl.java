package com.jingqi.service.impl;

import com.jingqi.dao.RoleDao;
import com.jingqi.dao.UserDao;
import com.jingqi.domain.Role;
import com.jingqi.domain.User;
import com.jingqi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 *用户service层的实现类
 * @author Huxudong
 * @date 2019-01-30
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public User checkLogin(String name, String password) {
        User checkUser = this.userDao.findByName(name);
        if(null != checkUser) {
            if((name).equals(checkUser.getUserName()) && (password).equals(checkUser.getUserPassword())) {
                return checkUser;
            }
        }
        return null;
    }

    @Override
    public User optional(String id) {
           User user = this.userDao.findById(id);
           return user;

    }

    @Override
    public void save(User user) {
       this.userDao.update(user);
    }

    @Override
    public User checkUserName(String name) {
        User checkByNameUser = this.userDao.findByName(name);
        if(null != checkByNameUser) {
           return checkByNameUser;
        }
        return null;
    }

    @Override
    public int insert(User user) {
        return this.userDao.save(user);
    }

    @Override
    public Role findRole(String userName) {
        return this.userDao.findByRole(userName);
    }

    @Override
    public List<User> findAllUser(String userName,Integer begin,Integer pageSize) {
        Role role = this.roleDao.findByType("commonUser");
        return this.userDao.findAllUser(userName,role.getRoleId(),begin,pageSize);
    }

    @Override
    public int findAllUserCount(String userName) {
        Role role = this.roleDao.findByType("commonUser");
        return this.userDao.findAllUserCount(userName,role.getRoleId());
    }

    @Override
    public User findByUserId(String userId) {
        return this.userDao.findByUserId(userId);
    }

    @Override
    public int updateUser(String userId, String userName, String userPassword,HttpSession session) {
        User user = new User();
        User user1 =(User) session.getAttribute("SESSION");
        user.setUserId(userId);
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setUpdator(user1.getUserId());
        user.setUpdateName(user1.getUserName());
        user.setUpdateTime(new Date());
        return this.userDao.update(user);
    }

    @Override
    public int deleteUser(String userId) {
        return this.userDao.deleteUser(userId);
    }

    @Override
    public int findAllAdminCount(String userName) {
        Role role = this.roleDao.findByType("commonAdmin");
        return this.userDao.findAllUserCount(userName,role.getRoleId());
    }

    @Override
    public List<User> findAllAdmin(String userName, Integer begin, Integer pageSize) {
        Role role = this.roleDao.findByType("commonAdmin");
        return this.userDao.findAllUser(userName,role.getRoleId(),begin,pageSize);
    }
}
