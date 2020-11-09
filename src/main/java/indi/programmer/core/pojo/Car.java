package indi.programmer.core.pojo;

import java.math.BigDecimal;

/**购物车实体类*/
public class Car {
    private Integer car_id;
    private String user_name;
    private Integer total_number;
    private BigDecimal total_price;

    /**构造方法*/
    public Car() {
    }

    public Car(Integer car_id, String user_name, Integer total_number, BigDecimal total_price) {
        this.car_id = car_id;
        this.user_name = user_name;
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

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
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
                ", user_name='" + user_name + '\'' +
                ", total_number=" + total_number +
                ", total_price=" + total_price +
                '}';
    }
}
