package indi.programmer.core.dao;

import indi.programmer.core.pojo.Car;
import indi.programmer.core.pojo.User;

import java.sql.Connection;

/**用户模块的持久层接口*/
public interface UserDao {
    /**根据用户名查找表中对应的记录*/
    User selectOneRowByUserName(User user);
    /**根据用户名和密码查找user表中对应的记录*/
    User selectOneRowByUserNameAndPassword(User user);
    /**向用户表user插入一条数据*/
    int insertOneRowToUserTable(User user);
    /**向购物车car表插入一条数据*/
    int insertOneRowToCarTable(User user);
}
