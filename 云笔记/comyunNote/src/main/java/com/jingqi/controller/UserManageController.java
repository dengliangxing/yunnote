package com.jingqi.controller;

import com.jingqi.Common;
import com.jingqi.domain.Role;
import com.jingqi.domain.User;
import com.jingqi.service.RoleService;
import com.jingqi.service.UserService;
import com.jingqi.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 用户管理controller层
 * @author        Huxudong
 * @date          2019-02-27
 */
@Controller
public class UserManageController implements Common {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /**
     * 一开始自动点击标志
     */
    private String flag ;

    /**
     * 查询所有的用户集合列表
     * @author                 Huxudong
     * @date                   2019-02-27
     * @param model       绑定页面的model对象
     * @param request     httpRequest请求对象
     * @param page        分页的实体类
     * @param userName    用户名
     * @return            所有用户的实体列表
     */
    @RequestMapping(value = "/manageUser.do")
    public String manageUser(Model model, HttpServletRequest request, Page page,String userName) {
        // 总页数
        int totalPage;
        flag = "1";
        if(null != userName) {
            userName = userName.trim();
        }
        String roles = request.getParameter("roles");
        // 所有的用户的记录数
        int count = this.userService.findAllUserCount(userName);
        List<User> user = this.userService.findAllUser(userName,page.getBegin(),page.getPageSize());
        if(count % page.getPageSize() == 0) {
            totalPage = count / page.getPageSize();
            if(totalPage == 0) {
                totalPage = totalPage + 5 - 4;
            }
        } else {
            totalPage = count / page.getPageSize() + 1;
        }
        model.addAttribute("roles",roles);
        model.addAttribute("user",user);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("currentPage",page.getCurrentPage());
        model.addAttribute("flag",flag);
        if(null != userName && !(NULL).equals(userName)) {
            model.addAttribute("userName",userName);
        }

        return "user";
    }

    /**
     * 添加一个用户信息并返回json对象
     * @author                 Huxudong
     * @date                   2019-02-27
     * @param userName         前端输入用户名
     * @param userPassword     前端输入用户密码
     * @return                 json数据
     */
    @RequestMapping(value = "/createUser.do")
    @ResponseBody
    public String createUser(String userName,String userPassword,String roleType,HttpSession session) {
        User user1 = this.userService.checkUserName(userName);
        User user2 = (User) session.getAttribute("SESSION");
        if(null != user1) {
            return "REPETE";
        }
        User user = new User();
        user.setUserId(UUID.randomUUID().toString());
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        if((COMMINADMIN).equals(roleType)) {
            Role role = this.roleService.findByRoleType(roleType);
            user.setRoleId(role.getRoleId());
        } else {
            Role role = this.roleService.findByType();
            user.setRoleId(role.getRoleId());
        }
        user.setCreator(user2.getUserId());
        user.setCreateName(user2.getUserName());
        user.setCreateTime(new Date());
        int row = this.userService.insert(user);
        if(row > 0) {
            return "OK";
        }
        return "FAIL";
    }

    /**
     * 根据用户id查询该用户的信息并返回对象供前端显示
     * @author                 Huxudong
     * @date                   2019-02-27
     * @param id               用户的id
     * @return                 json数据
     */
    @RequestMapping(value = "/editUser.do")
    @ResponseBody
    public User editUser(String id) {
        User user = this.userService.findByUserId(id);
        return user;
    }

    /**
     * 保存用户修改的信息并返回json数据
     * @author                 Huxudong
     * @date                   2019-02-27
     * @param userId          用户的id
     * @param userName        用户名
     * @param userPassword    用户密码
     * @return                json数据
     */
    @RequestMapping(value = "/saveUser.do")
    @ResponseBody
    public String saveUser(String userId, String userName, String userPassword, HttpSession session) {
        User user = this.userService.checkUserName(userName);
        User user1 = this.userService.findByUserId(userId);
        if(("").equals(userName) || userName == null) {
            return "ZERO";
        }

        if(("").equals(userPassword) || userPassword == null) {
            return "ONE";
        }
        if(null != user) {
            if(!(user.getUserName()).equals(user1.getUserName())) {
                return "EXIST";
            }

        }
        int row = this.userService.updateUser(userId,userName,userPassword,session);
        if(row > 0) {
            return "OK";
        }
        return "FAIL";
    }

    /**
     * 根据用户的id删除一条用户信息
     * @author                 Huxudong
     * @date                   2019-02-27
     * @param id            用户id
     * @return              json数据
     */
    @RequestMapping(value = "/deleteUser.do")
    @ResponseBody
    public String deleteUser(String id) {
        int row = this.userService.deleteUser(id);
        if(row > 0) {
            return "OK";
        }
        return "FAIL";
    }

    /**
     * 查看用户的信息并返回user的json对象
     * @author               Huxudong
     * @date                 2019-02-27
     * @param id            用户的id
     * @return              json的用户对象
     */
    @RequestMapping(value = "/lookUser.do")
    @ResponseBody
    public User lookUser(String id) {
        User user = this.userService.findByUserId(id);
        return user;

    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
