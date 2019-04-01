package com.jingqi.interceptor;

import com.jingqi.Common;
import com.jingqi.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 * @author Huxudong
 * @date 2019-02-05
 */
public class UserInterceptor implements HandlerInterceptor,Common {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String url = httpServletRequest.getRequestURI();
        // 获取session
        HttpSession session = httpServletRequest.getSession();
        // 查询session中是否有已经登录的用户的信息
        User user = (User) session.getAttribute("SESSION");
        if(null != user) {
            return true;
        }

        if(url.indexOf(LOGIN) >= 0 || url.indexOf(INDEX) >= 0 || url.indexOf(REGISTER) >= 0 || url.indexOf(REGIST) >= 0 || url.indexOf(CANCELREGISTER) >= 0) {
            return true;
        }

        httpServletResponse.sendRedirect("/comyunNote/login.do");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
