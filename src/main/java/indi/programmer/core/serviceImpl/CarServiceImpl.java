package indi.programmer.core.serviceImpl;

import indi.programmer.core.dao.BookDao;
import indi.programmer.core.dao.CarDao;
import indi.programmer.core.dao.UserDao;
import indi.programmer.core.pojo.Book;
import indi.programmer.core.pojo.Car;
import indi.programmer.core.pojo.CarAndBook;
import indi.programmer.core.pojo.User;
import indi.programmer.core.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    @Qualifier(value = "carDao")
    private CarDao carDao;

    @Autowired
    @Qualifier(value = "bookDao")
    private BookDao bookDao;

    /**添加一个商品到某个用户的购物车*/
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addOneGoodToShopCar(String userName, Integer bookId, Integer inputNumber) {
        //创建car对象，给car对象的user_name属性赋值，通过user_name查询对应的购物车中的信息
        Car car = new Car();
        car.setUser_name(userName);
        Car oneCar = carDao.selectOneCar(car);
        //通过bookId查询对应的书籍信息
        Book book = bookDao.queryOneBookByBookId(bookId);
        //该商品的价格与加入购物车的数量相乘得到的单项总价格
        BigDecimal singlePrice = book.getBook_price().multiply(new BigDecimal(inputNumber));
        //创建carAndBook对象，并为它的部分属性赋值
        CarAndBook carAndBook = new CarAndBook();
        carAndBook.setSingle_number(inputNumber);
        carAndBook.setSingle_price(singlePrice);
        carAndBook.setBook_id(bookId);
        carAndBook.setCar_id(oneCar.getCar_id());
        //计算在加入商品后，该用户购物车的总数量和总价格应该变化成的值,并加入到car对象中
        Integer totalNumber = oneCar.getTotal_number() + inputNumber;
        BigDecimal totalPrice = oneCar.getTotal_price().add(singlePrice);
        car.setTotal_number(totalNumber);
        car.setTotal_price(totalPrice);
        //向购物车中加入该项商品,需要事务
        carDao.addOneItemToTableCarAndBook(carAndBook);
        carDao.updateTotalNumberAndTotalPriceFromCar(car);
    }

    /**根据用户名查询该用户购物车中的所有商品项*/
    @Override
    public List<CarAndBook> selectOneCarAllItems(String userName) {
        Car car = new Car();
        car.setUser_name(userName);
        //根据用户名查询对应的购物车信息
        Car oneCar = carDao.selectOneCar(car);
        CarAndBook carAndBook = new CarAndBook();
        carAndBook.setCar_id(oneCar.getCar_id());
        List<CarAndBook> carAndBookList = carDao.selectOneCarAllItem(carAndBook);
        return carAndBookList;
    }

    /**从该用户的购物车中删除一项商品*/
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteItemFromCar(String userName, Integer bookId) {
        Car car = new Car();
        car.setUser_name(userName);
        //根据用户名查询对应的购物车信息
        Car oneCar = carDao.selectOneCar(car);
        //new一个carAndBook对象，为部分属性赋值
        CarAndBook carAndBook = new CarAndBook();
        carAndBook.setCar_id(oneCar.getCar_id());
        carAndBook.setBook_id(bookId);
        //查询购物车中某一项商品的信息
        CarAndBook carAndBookResult = carDao.selectOneItemFromCarAndBook(carAndBook);
        //删除某项商品后购物车中的总商品数和总价格应该修改为的值,并加入到car中
        Integer totalNumber = oneCar.getTotal_number() - carAndBookResult.getSingle_number();
        BigDecimal totalPrice = oneCar.getTotal_price().subtract(carAndBookResult.getSingle_price());
        car.setTotal_number(totalNumber);
        car.setTotal_price(totalPrice);
        //从购物车中删除某项商品并改变对应的购物车中的商品总数和总价格，需要事务
        carDao.deleteOneItemFromTableCarAndBook(carAndBook);
        carDao.updateTotalNumberAndTotalPriceFromCar(car);
    }

    @Override
    public Car selectOneCarInformation(String user_name) {
        Car car = new Car();
        car.setUser_name(user_name);
        //根据用户名查询对应的购物车信息
        Car oneCar = carDao.selectOneCar(car);
        return oneCar;
    }
}
