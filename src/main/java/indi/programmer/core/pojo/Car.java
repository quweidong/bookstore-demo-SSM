package indi.programmer.core.pojo;

import java.math.BigDecimal;

/**购物车实体类*/
public class Car {
    private Integer car_id;
    private Integer user_id;
    private Integer total_number;
    private BigDecimal total_price;

    /**构造方法*/
    public Car() {
    }

    public Car(Integer car_id, Integer user_id, Integer total_number, BigDecimal total_price) {
        this.car_id = car_id;
        this.user_id = user_id;
        this.total_number = total_number;
        this.total_price = total_price;
    }

    /**getter和setter方法*/
    public Integer getCar_id() {
        return car_id;
    }

    public void setCar_id(Integer car_id) {
        this.car_id = car_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getTotal_number() {
        return total_number;
    }

    public void setTotal_number(Integer total_number) {
        this.total_number = total_number;
    }

    public BigDecimal getTotal_price() {
        return total_price;
    }

    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }

    /**toString方法*/
    @Override
    public String toString() {
        return "Car{" +
                "car_id=" + car_id +
                ", user_id=" + user_id +
                ", total_number=" + total_number +
                ", total_price=" + total_price +
                '}';
    }
}
