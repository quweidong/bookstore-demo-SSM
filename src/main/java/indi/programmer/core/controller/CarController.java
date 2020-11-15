package indi.programmer.core.controller;

import indi.programmer.core.pojo.Car;
import indi.programmer.core.pojo.CarAndBook;
import indi.programmer.core.pojo.User;
import indi.programmer.core.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    //用户登录后在商品详情页点击加入到购物车
    @ResponseBody
    @RequestMapping(value = "/user/addOneItemToCar",method = RequestMethod.POST)
    public String addOneItemCar(Integer bookId, Integer inputNumber, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("presentUser");
        boolean flag = carService.addOneGoodToShopCar(user.getUsername(),bookId,inputNumber);
        if (flag == true){
            return "添加至购物车成功";
        }else {
            return "购物车中已存在该商品";
        }
    }

    //用户登录后点击我的购物车后展示的数据
    @ResponseBody
    @RequestMapping(value = "/user/selectOneCarAllItems",method = RequestMethod.POST)
    public List<CarAndBook> selectOneCarAllItems(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("presentUser");
        List<CarAndBook> carAndBookList = carService.selectOneCarAllItems(user.getUsername());
        return carAndBookList;
    }

    //用户登录后在购物车页面的具体商品后面点击删除后的操作
    @RequestMapping(value = "/user/deleteOneItemFromCar",method = RequestMethod.POST)
    public void deleteOneItemFromCar(Integer bookId,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("presentUser");
        carService.deleteItemFromCar(user.getUsername(),bookId);
    }

    //用户登录后的购物车的总体信息
    @ResponseBody
    @RequestMapping(value = "/user/selectOneCarInformation",method = RequestMethod.POST)
    public Car selectOneCarInformation(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("presentUser");
        Car car = carService.selectOneCarInformation(user.getUsername());
        return car;
    }
}
