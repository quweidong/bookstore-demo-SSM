package indi.programmer.core.interceptor;

import indi.programmer.core.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLoginStatusInterceptor implements HandlerInterceptor {

    /*预处理方法*/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("presentUser");
        if (user != null){
            return true;
        }else {
            response.sendRedirect("/bookstore/static/pages/login.html");
            return false;
        }
    }
}
