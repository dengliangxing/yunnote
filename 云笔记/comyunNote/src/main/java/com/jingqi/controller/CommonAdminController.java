package com.jingqi.controller;

import com.jingqi.Common;
import com.jingqi.domain.User;
import com.jingqi.service.UserService;
import com.jingqi.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 普通管理员的controller层
 * @author    Huxudong
 * @date       2019-02-27
 */
@Controller
public class CommonAdminController implements Common {
    @Autowired
    private UserService userService;

    /**
     * 一开始自动跳转的标志
     */
    private String flag ;

    /**
     * 超级管理员查询所有的普通管理员的列表集合
     * @author            Huxudong
     * @date              2019-02-27
     * @param model       model绑定的页面的对象
     * @param request     request请求的对象
     * @param page        分页的实体类
     * @param userName    用户名
     * @return            普通管理员列表页面
     */
    @RequestMapping(value = "/manageAdmin.do")
    public String manageAdmin(Model model, HttpServletRequest request, Page page,String userName) {
        String roles = request.getParameter("roles");
        // 总页数
        int totalPage;
        if(null != userName) {
            userName = userName.trim();
        }
        flag = "2";
        // 所有的用户的记录数
        int count = this.userService.findAllAdminCount(userName);
        List<User> user = this.userService.findAllAdmin(userName,page.getBegin(),page.getPageSize());
        if(count % page.getPageSize() == 0) {
            totalPage = count / page.getPageSize();
            if(totalPage == 0) {
                totalPage = totalPage + 6 - 5;
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
        return "commonAdmin";
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
