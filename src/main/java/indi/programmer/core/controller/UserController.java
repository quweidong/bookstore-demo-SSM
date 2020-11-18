package indi.programmer.core.controller;

import indi.programmer.core.pojo.User;
import indi.programmer.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**处理用户登录*/
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public void login(String userName, String password, String code, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String kaptchaCode = (String) session.getAttribute(KAPTCHA_SESSION_KEY);
        if (kaptchaCode.equalsIgnoreCase(code)){
            boolean flag = userService.login(userName,password);
            if (flag == true){
                User user = userService.ReturnOneUser(userName);
                session.setAttribute("presentUser",user);
                response.sendRedirect("/bookstore/");
            }else {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
                out.print("<script>");
                out.print("alert('用户名或密码错误!');");
                out.print("window.location.href='/bookstore/static/pages/login.html'");
                out.print("</script>");
                out.close();
            }
        }else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
            out.print("<script>");
            out.print("alert('请检查验证码是否正确!');");
            out.print("window.location.href='/bookstore/static/pages/login.html'");
            out.print("</script>");
            out.close();
        }
    }

    /**处理用户注册*/
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public void register(String username,String user_password,String email,HttpServletResponse response) throws IOException {
        User user = userService.ReturnOneUser(username);
        if (user == null){
            //可以注册
            userService.register(username,user_password,email);
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
            out.print("<script>");
            out.print("alert('注册成功!');");
            out.print("window.location.href='/bookstore/static/pages/login.html'");
            out.print("</script>");
            out.close();
        }else {
            //注册失败
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
            out.print("<script>");
            out.print("alert('该用户已存在，请重新注册!');");
            out.print("window.location.href='/bookstore/static/pages/register.html'");
            out.print("</script>");
            out.close();
        }
    }

    @ResponseBody
    @RequestMapping(value = "/loginStatus",method = RequestMethod.POST)
    public User loginStatus(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("presentUser");
        return user;
    }

    @RequestMapping(value = "/user/userCancel",method = RequestMethod.POST)
    public void userCancel(HttpSession session){
        session.invalidate();
    }
}
