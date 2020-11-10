package indi.programmer.core.service;

import indi.programmer.core.pojo.Order;
import indi.programmer.core.pojo.OrderItem;

import java.util.List;

/**用户订单模块业务层的接口*/
public interface OrderService {
    /**用户从购物车界面付款成功后增加一个订单*/
    void addOneOrderInCar(String orderAddress,String orderTelephone,String receiverName,Integer userId,String userName);
    /**用户从商品详情信息页面付款成功后增加一个订单*/
    void addOneOrderInBookInformation(Integer orderNumber,String orderAddress,String orderTelephone,String receiverName,Integer bookId,Integer userId,String userName);
    /**查询某个用户所有的订单信息*/
    List<Order> selectAllOrders(Integer userId);
    /**查看某个订单的具体信息（所有商品项）*/
    List<OrderItem> selectOneOrderAllItems(String orderNo);
}
