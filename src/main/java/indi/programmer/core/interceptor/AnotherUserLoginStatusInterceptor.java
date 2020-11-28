package indi.programmer.core.interceptor;

import indi.programmer.core.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class AnotherUserLoginStatusInterceptor implements HandlerInterceptor {

    /**异步请求的预处理方法*/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("presentUser");
        if (user != null){
            return true;
        }else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.print("请先登录后再执行此操作!");
            out.close();
            return false;
        }
    }
}
