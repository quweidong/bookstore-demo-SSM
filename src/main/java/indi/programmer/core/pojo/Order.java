package indi.programmer.core.pojo;

import java.math.BigDecimal;

/**order_table表实体类*/
public class Order {
    private Integer order_id;
    private String order_No;
    private Integer order_number;
    private BigDecimal order_price;
    private String order_address;
    private String order_telephone;
    private String receiver_name;
    private Integer order_status;
    private Integer user_id;

    /**构造方法*/
    public Order() {
    }

    public Order(Integer order_id, String order_No, Integer order_number, BigDecimal order_price, String order_address, String order_telephone, String receiver_name, Integer order_status, Integer user_id) {
        this.order_id = order_id;
        this.order_No = order_No;
        this.order_number = order_number;
        this.order_price = order_price;
        this.order_address = order_address;
        this.order_telephone = order_telephone;
        this.receiver_name = receiver_name;
        this.order_status = order_status;
        this.user_id = user_id;
    }


    /**getter和setter*/
    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getOrder_No() {
        return order_No;
    }

    public void setOrder_No(String order_No) {
        this.order_No = order_No;
    }

    public Integer getOrder_number() {
        return order_number;
    }

    public void setOrder_number(Integer order_number) {
        this.order_number = order_number;
    }

    public BigDecimal getOrder_price() {
        return order_price;
    }

    public void setOrder_price(BigDecimal order_price) {
        this.order_price = order_price;
    }

    public String getOrder_address() {
        return order_address;
    }

    public void setOrder_address(String order_address) {
        this.order_address = order_address;
    }

    public String getOrder_telephone() {
        return order_telephone;
    }

    public void setOrder_telephone(String order_telephone) {
        this.order_telephone = order_telephone;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public Integer getOrder_status() {
        return order_status;
    }

    public void setOrder_status(Integer order_status) {
        this.order_status = order_status;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    /**toString方法*/
    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", order_No='" + order_No + '\'' +
                ", order_number=" + order_number +
                ", order_price=" + order_price +
                ", order_address='" + order_address + '\'' +
                ", order_telephone='" + order_telephone + '\'' +
                ", receiver_name='" + receiver_name + '\'' +
                ", order_status=" + order_status +
                ", user_id=" + user_id +
                '}';
    }
}
