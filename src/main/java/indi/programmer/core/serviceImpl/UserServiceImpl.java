package indi.programmer.core.serviceImpl;

import indi.programmer.core.dao.UserDao;
import indi.programmer.core.pojo.User;
import indi.programmer.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier(value = "userDao")
    private UserDao userDao;

    /**用户登录业务*/
    @Override
    public boolean login(String userName, String userPassword) {
        User user = new User();
        user.setUsername(userName);
        user.setPassword(userPassword);
        //返回null表示用户名或密码错误，方法返回false；不为null则表示登录成功，方法返回true
        User oneUser = userDao.selectExistOneRowByUserNameAndPassword(user);
        if (oneUser == null){
            return false;
        }else {
            return true;
        }
    }

    /**用户注册业务*/
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean register(String userName, String userPassword, String userEmail) {
        User user = new User();
        user.setUsername(userName);
        user.setPassword(userPassword);
        user.setEmail(userEmail);
        /*返回null表示数据库中不存在该用户，则增加一位用户并且为其添加一辆购物车；不为null表示已存在该用户，返回false*/
        User oneUser = userDao.selectExistOneRowByUserName(user);
        if (oneUser == null){
            userDao.insertOneRowToUserTable(user);
            int i = 10/0;
            userDao.insertOneRowToCarTable(user);
            System.out.println("成功");
            return true;
        }else {
            return false;
        }
    }

    /**根据用户名查询用户的信息*/
    @Override
    public User ReturnOneUser(String userName) {
        User user = new User();
        user.setUsername(userName);
        User oneUser = userDao.selectExistOneRowByUserName(user);
        return oneUser;
    }
}
