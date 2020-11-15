package indi.programmer.core.serviceImpl;

import indi.programmer.core.BaseTest;
import indi.programmer.core.pojo.Car;
import indi.programmer.core.pojo.CarAndBook;
import indi.programmer.core.service.CarService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class CarServiceImplTest extends BaseTest {

    @Autowired
    private CarService carService;

    @Test
    public void addOneGoodToShopCar() {
        boolean flag = carService.addOneGoodToShopCar("test",8,1);
        System.out.println(flag);
    }

    @Test
    public void selectOneCarAllItems() {
        List<CarAndBook> carAndBookList =  carService.selectOneCarAllItems("test");
        for (CarAndBook carAndBook : carAndBookList){
            System.out.println(carAndBook);
        }
    }

    @Test
    public void deleteItemFromCar() {
        carService.deleteItemFromCar("test",3);
    }

    @Test
    public void selectOneCarInformation() {
        Car car = carService.selectOneCarInformation("test");
        System.out.println(car);
    }
}