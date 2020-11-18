package indi.programmer.core.controller;

import indi.programmer.core.pojo.Order;
import indi.programmer.core.pojo.OrderItem;
import indi.programmer.core.pojo.User;
import indi.programmer.core.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    //用户登录后查询其所有的订单
    @ResponseBody
    @RequestMapping(value = "/user/selectAllOrders",method = RequestMethod.POST)
    public List<Order> main(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("presentUser");
        List<Order> orderList = orderService.selectAllOrders(user.getId());
        return orderList;
    }

    //用户登录后查询其某个订单中的具体商品信息
    @ResponseBody
    @RequestMapping(value = "/user/selectOneOrderAllItems",method = RequestMethod.POST)
    public List<OrderItem> selectOneOrderAllItems(String orderNo){
        List<OrderItem> orderItemList = orderService.selectOneOrderAllItems(orderNo);
        return orderItemList;
    }

    //用户登录后在具体商品页面填完地址去支付时
    @ResponseBody
    @RequestMapping(value = "/user/payInBookInformation",method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    public String payInBookInformation(Integer orderNumber,String orderAddress,String orderTelephone,String receiverName,Integer bookId,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("presentUser");
        orderService.addOneOrderInBookInformation(orderNumber,orderAddress,orderTelephone,receiverName,bookId,user.getId(),user.getUsername());
        return "支付成功！";
    }

    //用户登录后在购物车页面填完地址后去支付时
    @ResponseBody
    @RequestMapping(value = "/user/payInCar",method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    public String payInCar(String orderAddress,String orderTelephone,String receiverName,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("presentUser");
        orderService.addOneOrderInCar(orderAddress,orderTelephone,receiverName,user.getId(),user.getUsername());
        return "支付成功！";
    }
}
