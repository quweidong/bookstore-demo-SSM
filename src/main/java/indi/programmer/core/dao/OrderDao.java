package indi.programmer.core.dao;


import indi.programmer.core.pojo.Book;
import indi.programmer.core.pojo.Order;
import indi.programmer.core.pojo.OrderItem;

import java.util.List;

/**订单模块对数据库进行操作的接口*/
public interface OrderDao {
    /**根据用户id查询某个用户的所有订单
     * @return*/
    List<Order> selectAllOrders(Integer userId);
    /**根据order_No从order_item表中查询某个订单的具体商品信息*/
    List<OrderItem> selectOneOrderAllItems(String orderNo);
    /**为用户增加一个订单*/
    int addOneOrder(Order order);
    /**为订单加入对应的商品部分信息*/
    int addOneOrderItem(OrderItem orderItem);
    /**订单支付成功后修改相应部分书的库存，增加相应部分书的销量*/
    int updateStockAndSalesVolumeToBook(Book book);
}
