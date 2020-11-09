package indi.programmer.core.dao;

import indi.programmer.core.pojo.Car;
import indi.programmer.core.pojo.CarAndBook;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**购物车模块对数据库进行操作的接口*/
public interface CarDao {
    /**根据传入信息查询car_book表中对应的一条记录*/
    CarAndBook selectOneItemFromCarAndBook(CarAndBook oneInputItem);
    /**为car_book增加一项商品*/
    int addOneItemToTableCarAndBook(CarAndBook oneInputItem);
    /**为car_book删除一项商品*/
    int deleteOneItemFromTableCarAndBook(CarAndBook oneInputItem);
    /**修改car表中某条记录的总商品数量和总价格*/
    int updateTotalNumberAndTotalPriceFromCar(Car car);
    /**根据传入信息查询某个用户所有的加入购物车的商品信息*/
    List<CarAndBook> selectOneCarAllItem(CarAndBook oneInputItem);
    /**查询某个用户的购物车信息*/
    Car selectOneCar(Car car);
}
