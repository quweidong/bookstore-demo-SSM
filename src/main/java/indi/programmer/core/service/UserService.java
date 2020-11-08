package indi.programmer.core.service;

import indi.programmer.core.pojo.User;

/**用户模块服务层的接口*/
public interface UserService {
    /**用户登录*/
    boolean login(String userName,String userPassword);
    /**用户注册*/
    boolean register(String userName,String userPassword,String userEmail);
    /**根据用户名查询一个用户的信息*/
    User ReturnOneUser(String userName);
}
