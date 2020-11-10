package indi.programmer.core.serviceImpl;

import indi.programmer.core.BaseTest;
import indi.programmer.core.pojo.Order;
import indi.programmer.core.pojo.OrderItem;
import indi.programmer.core.service.OrderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class OrderServiceImplTest extends BaseTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void addOneOrderInCar() {
        orderService.addOneOrderInCar("湖北省荆州市","11111111111","暴躁老东",9,"test");
    }

    @Test
    public void addOneOrderInBookInformation() {
        orderService.addOneOrderInBookInformation(4,"湖北省黄石市","22222222222","平和老东",6,9,"test");
    }

    @Test
    public void selectAllOrders() {
        List<Order> orderList = orderService.selectAllOrders(9);
        for (Order order : orderList){
            System.out.println(order);
        }
    }

    @Test
    public void selectOneOrderAllItems() {
        List<OrderItem> orderItemList = orderService.selectOneOrderAllItems("16049975210849");
        for (OrderItem orderItem : orderItemList){
            System.out.println(orderItem);
        }
    }
}