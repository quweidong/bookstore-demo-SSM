package indi.programmer.core.service;

import indi.programmer.core.pojo.Car;
import indi.programmer.core.pojo.CarAndBook;

import java.util.List;

/**购物车模块的service层接口*/
public interface CarService {
    /**添加一项商品到购物车的功能*/
    boolean addOneGoodToShopCar(String userName,Integer bookId,Integer inputNumber);
    /**查询某个用户的购物车的所有商品信息*/
    List<CarAndBook> selectOneCarAllItems(String userName);
    /**从购物车中删除一项商品的功能*/
    void deleteItemFromCar(String userName,Integer bookId);
    /**根据具有唯一性的用户名查询某个用户的购物车信息*/
    Car selectOneCarInformation(String user_name);
}
