package indi.programmer.core.controller;

import indi.programmer.core.pojo.User;
import indi.programmer.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**处理用户登录*/
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String userName, String password,String code, HttpServletRequest request){
        HttpSession session = request.getSession();
        String kaptchaCode = (String) session.getAttribute(KAPTCHA_SESSION_KEY);
        if (kaptchaCode.equalsIgnoreCase(code)){
            boolean flag = userService.login(userName,password);
            if (flag == true){
                User user = userService.ReturnOneUser("test");
                session.setAttribute("presentUser",user);
                return "redirect:/static/pages/index.html";
            }else {
                return "redirect:/static/pages/login.html";
            }
        }else {
            return "redirect:/static/pages/login.html";
        }
    }

    /**处理用户注册*/
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(String userName,String password,String email){
        User user = userService.ReturnOneUser(userName);
        if (user == null){
            //可以注册
            userService.register(userName,password,email);
            return "redirect:/static/pages/login.html";
        }else {
            //注册失败
            return "redirect:/static/pages/register/html";
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
