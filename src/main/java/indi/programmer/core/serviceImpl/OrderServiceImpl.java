package indi.programmer.core.serviceImpl;

import indi.programmer.core.dao.BookDao;
import indi.programmer.core.dao.CarDao;
import indi.programmer.core.dao.OrderDao;
import indi.programmer.core.pojo.*;
import indi.programmer.core.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    @Qualifier("orderDao")
    private OrderDao orderDao;

    @Autowired
    @Qualifier("carDao")
    private CarDao carDao;

    @Autowired
    @Qualifier("bookDao")
    private BookDao bookDao;

    /**用户在购物车界面进行购买成功后添加一个订单*/
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addOneOrderInCar(String orderAddress, String orderTelephone, String receiverName, Integer userId,String userName) {
        //生成一个订单号，用系统时间+userId表示唯一值
        String orderNo = System.currentTimeMillis()+""+userId;
        Car car = new Car();
        car.setUser_name(userName);
        //通过用户名查询该用户的购物车信息
        Car oneCar = carDao.selectOneCar(car);
        //新建对象order并为其部分属性赋值
        Order order = new Order();
        order.setOrder_No(orderNo);
        order.setOrder_number(oneCar.getTotal_number());
        order.setOrder_price(oneCar.getTotal_price());
        order.setOrder_address(orderAddress);
        order.setOrder_telephone(orderTelephone);
        order.setReceiver_name(receiverName);
        order.setOrder_status(1);
        order.setUser_id(userId);
        //新建对象orderItem
        OrderItem orderItem = new OrderItem();
        //为用户增加一个订单
        orderDao.addOneOrder(order);
        //新建对象carAndBook，通过car的id来查询购物车中所有的商品项
        CarAndBook carAndBook = new CarAndBook();
        carAndBook.setCar_id(oneCar.getCar_id());
        //查询一个购物车中所有的商品项
        List<CarAndBook> carAndBookList = carDao.selectOneCarAllItem(carAndBook);
        for (CarAndBook carAndBookInList : carAndBookList){
            //根据每一个商品项的book_id查询
            Book book = bookDao.queryOneBookByBookId(carAndBookInList.getBook_id());
            //为查询到的每一个book对象的销量和库存重新赋值
            book.setSales_volume(book.getSales_volume() + carAndBookInList.getSingle_number());
            book.setBook_stock(book.getBook_stock() - carAndBookInList.getSingle_number());
            //修改对应的书籍的库存和销量
            orderDao.updateStockAndSalesVolumeToBook(book);
            //删除购物车中的该项商品
            carDao.deleteOneItemFromTableCarAndBook(carAndBookInList);
            //为car对象的部分属性赋值
            car.setTotal_number(oneCar.getTotal_number() - carAndBookInList.getSingle_number());
            car.setTotal_price(oneCar.getTotal_price().subtract(carAndBookInList.getSingle_price()));
            //更新该用户购物车的商品总数量和总价格
            carDao.updateTotalNumberAndTotalPriceFromCar(car);
            //为orderItem部分属性赋值
            orderItem.setBook_isbn(book.getBook_isbn());
            orderItem.setBook_img(book.getImg_url());
            orderItem.setBook_name(book.getBook_name());
            orderItem.setItem_number(carAndBookInList.getSingle_number());
            orderItem.setItem_price(carAndBookInList.getSingle_price());
            orderItem.setOrder_No(orderNo);
            //为订单增加商品项
            orderDao.addOneOrderItem(orderItem);
        }
    }

    /**用户在书籍详情界面进行购买成功后添加一个订单,应该有事务*/
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addOneOrderInBookInformation(Integer orderNumber, String orderAddress, String orderTelephone, String receiverName, Integer bookId,Integer userId, String userName) {
        //生成一个订单号，用系统时间+userId表示唯一值
        String orderNo = System.currentTimeMillis()+""+userId;
        //根据book的id查询到对应的书籍信息
        Book book = bookDao.queryOneBookByBookId(bookId);
        //新建对象order并为其部分属性赋值
        Order order = new Order();
        order.setOrder_No(orderNo);
        order.setOrder_number(orderNumber);
        order.setOrder_price(book.getBook_price().multiply(new BigDecimal(orderNumber)));
        order.setOrder_address(orderAddress);
        order.setOrder_telephone(orderTelephone);
        order.setReceiver_name(receiverName);
        order.setOrder_status(1);
        order.setUser_id(userId);
        //为用户增加一个订单
        orderDao.addOneOrder(order);
        //新建对象orderItem
        OrderItem orderItem = new OrderItem();
        //为查询到的book对象的销量和库存重新赋值
        book.setSales_volume(book.getSales_volume() + orderNumber);
        book.setBook_stock(book.getBook_stock() - orderNumber);
        //修改对应的书籍的库存和销量
        orderDao.updateStockAndSalesVolumeToBook(book);
        //为orderItem部分属性赋值
        orderItem.setBook_isbn(book.getBook_isbn());
        orderItem.setBook_img(book.getImg_url());
        orderItem.setBook_name(book.getBook_name());
        orderItem.setItem_number(orderNumber);
        orderItem.setItem_price(book.getBook_price().multiply(new BigDecimal(orderNumber)));
        orderItem.setOrder_No(orderNo);
        //为订单增加商品项
        orderDao.addOneOrderItem(orderItem);
    }

    /**根据userId查询该用户的所有订单*/
    @Override
    public List<Order> selectAllOrders(Integer userId) {
        List<Order> orderList = orderDao.selectAllOrders(userId);
        return orderList;
    }

    @Override
    public List<OrderItem> selectOneOrderAllItems(String orderNo) {
        List<OrderItem> orderItemList = orderDao.selectOneOrderAllItems(orderNo);
        return orderItemList;
    }
}
