package indi.programmer.core.pojo;

import java.math.BigDecimal;

/**order_item表对应的实体类*/
public class OrderItem {
    private Integer item_id;
    private String book_isbn;
    private String book_img;
    private String book_name;
    private Integer item_number;
    private BigDecimal item_price;
    private String order_No;

    /**构造方法*/
    public OrderItem(){
    }

    public OrderItem(Integer item_id, String book_isbn, String book_img, String book_name, Integer item_number, BigDecimal item_price, String order_No) {
        this.item_id = item_id;
        this.book_isbn = book_isbn;
        this.book_img = book_img;
        this.book_name = book_name;
        this.item_number = item_number;
        this.item_price = item_price;
        this.order_No = order_No;
    }

    /**getter和setter方法*/
    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public String getBook_isbn() {
        return book_isbn;
    }

    public void setBook_isbn(String book_isbn) {
        this.book_isbn = book_isbn;
    }

    public String getBook_img() {
        return book_img;
    }

    public void setBook_img(String book_img) {
        this.book_img = book_img;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public Integer getItem_number() {
        return item_number;
    }

    public void setItem_number(Integer item_number) {
        this.item_number = item_number;
    }

    public BigDecimal getItem_price() {
        return item_price;
    }

    public void setItem_price(BigDecimal item_price) {
        this.item_price = item_price;
    }

    public String getOrder_No() {
        return order_No;
    }

    public void setOrder_No(String order_No) {
        this.order_No = order_No;
    }

    /**toString方法*/
    @Override
    public String toString() {
        return "OrderItem{" +
                "item_id=" + item_id +
                ", book_isbn='" + book_isbn + '\'' +
                ", book_img='" + book_img + '\'' +
                ", book_name='" + book_name + '\'' +
                ", item_number=" + item_number +
                ", item_price=" + item_price +
                ", order_No='" + order_No + '\'' +
                '}';
    }
}
