package indi.programmer.core.serviceImpl;

import indi.programmer.core.BaseTest;
import indi.programmer.core.pojo.User;
import indi.programmer.core.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserServiceImplTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void login() {
        boolean flag = userService.login("test","123456");
        System.out.println(flag);
    }

    @Test
    public void register() {
        boolean flag = userService.register("test","123456","test@qq.com");
        System.out.println(flag);
    }

    @Test
    public void returnOneUser() {
        User oneUser = userService.ReturnOneUser("test");
        System.out.println(oneUser);
    }
}