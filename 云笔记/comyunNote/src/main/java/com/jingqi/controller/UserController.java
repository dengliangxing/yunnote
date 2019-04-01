package com.jingqi.controller;
import com.jingqi.domain.Role;
import com.jingqi.domain.User;
import com.jingqi.service.RoleService;
import com.jingqi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * 用户controller层
 * @author Huxudong
 * @date 2019-01-29
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    /**
     * 判断登录用户的角色(管理员登录还是普通用户登录)
     */
    private String roles;

    /**
     * 用户登录
     * @author Huxudong
     * @date 2019-01-29
     * @return   登录是否成功的页面
     */
    @RequestMapping(value="/login.do")
    public String login() {
        return "login";
    }

    /**
     * 用户登录拦截的请求
     * @author Huxudong
     * @date 2019-02-06
     * @return    登录页面
     */
    @RequestMapping(value = "/index.do",method = RequestMethod.GET)
    public String index() {
        return "redirect:login.do";
    }

    /**
     * 一开始请求自动跳转到登录页面
     * @author Huxudong
     * @date 2019-02-06
     * @return       重定向到登录的请求
     */
    @RequestMapping(value = "/")
    public String list() {
        return "redirect:login.do";
    }
    /**
     * 判断是否登录成功的请求
     * @param username    前端用户名
     * @param password    前端密码
     * @param session     记录的session对象
     * @param model       绑定Model页面的对象
     * @author Huxudong
     * @date 2019-02-06
     * @return 登录成功页面  或者 登录失败返回登录的页面
     */
    @RequestMapping(value="/index.do",method = RequestMethod.POST)
    public String index(String username,String password,HttpSession session,Model model) {
        // 通过账号和密码查询用户
        User user = this.userService.checkLogin(username,password);
        if(null != user) {
            // 将用户添加到Session
            session.setAttribute("SESSION",user);
            Role role = this.userService.findRole(username);
            // 用户的登录角色
            roles = role.getRoleType();
            model.addAttribute("roles",roles);
            return "index";
        }

        model.addAttribute("msg","账号或者密码错误!");
        return "login";
    }

    /**"
     * 用户账户信息的请求
     * @author Huxudong
     * @date 2019-02-07
     * @return   用户的账户信息页面
     */
    @GetMapping(value = "/myAccount.do")
    public String myAccount() {
        return "myAccount";
    }

    /**
     * 退出登录
     * @author Huxudong
     * @date 2019-02-06
     * @return   登录页面
     */
    @GetMapping(value = "/logout.do")
    public String logout(HttpSession session) {
        session.removeAttribute("SESSION");
        return "redirect:login.do";
}

    /**
     * 用户修改自己账户的信息
     * @author Huxudong
     * @date 2019-02-07
     * @param userName      前端传过来的用户名
     * @param userPassword      前端传过来的密码
     * @param session       记录的session对象信息
     * @return              修改信息失败或者成功
     */
    @RequestMapping(value = "/modifyAccount.do")
    @ResponseBody
    public String modifyAccount(String userName,String userPassword,HttpSession session) {
        User userSession = (User)session.getAttribute("SESSION");
        User user2 = this.userService.optional(userSession.getUserId());
        if(null != user2) {
            user2.setUserName(userName);
            user2.setUserPassword(userPassword);
            this.userService.save(user2);
            session.removeAttribute("SESSION");
            session.setAttribute("SESSION",user2);
            // 修改账户成功后返回的json标志
            return "success";
        }
        // 修改账户失败后返回的json标志
        return "error";
    }

    /**
     * 注册账号跳转到注册页面
     * @author Huxudong
     * @date 2019-02-07
     * @return           注册的信息的返回是否成功
     */
    @RequestMapping(value = "/register.do")
    public String register() {
        return "register";
    }

    /**
     * 直接注册请求没有填写用户信息被拦截转发到登录界面
     * @author            Huxudong
     * @date              2019-02-07
     * @return            登录页面
     */
    @RequestMapping(value = "/regist.do",method = RequestMethod.GET)
    public String regist() {
        return "redirect:login.do";
    }

    /**
     * 注册请求填写用户信息后返回json对象
     * @author            Huxudong
     * @date              2019-02-07
     * @param userName          前端传入的用户名
     * @param userPassword      前端传入的密码
     * @return                  返回json对象
     */
    @RequestMapping(value = "/regist.do")
    @ResponseBody
    public String regist(String userName,String userPassword) {
        User checkUser = this.userService.checkUserName(userName);
        if(null != checkUser) {
            // 检查这个注册的用户名已经存在返回的json标志
            return "REPETE";
        }
        User user = new User();
        user.setUserId(UUID.randomUUID().toString());
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        Role role = this.roleService.findByType();
        user.setRoleId(role.getRoleId());
        int row = this.userService.insert(user);
        if(row == 1) {
            // 注册成功后返回的json标志
            return "OK";
        }
        // 注册失败后返回的json标志
        return "FAIL";
    }

    /**
     * 取消注册页面返回登录页面的功能
     * @author     Huxudong
     * @date       2019-02-10
     * @return     请求转发到登录请求的controller的方法
     */
    @RequestMapping(value = "/cancelRegister.do")
    public String cancelRegister() {
        return "redirect:login.do";
    }


    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
