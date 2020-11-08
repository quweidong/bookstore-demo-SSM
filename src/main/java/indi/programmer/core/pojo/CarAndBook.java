package indi.programmer.core.pojo;

import java.math.BigDecimal;

/**car_book即购物车和书籍关系表的bean类*/
public class CarAndBook {
    private Integer cb_id;
    private Integer single_number;
    private BigDecimal single_price;
    private Integer car_id;
    private Integer book_id;

    /**构造方法*/
    public CarAndBook() {
    }

    public CarAndBook(Integer cb_id, Integer single_number, BigDecimal single_price, Integer car_id, Integer book_id) {
        this.cb_id = cb_id;
        this.single_number = single_number;
        this.single_price = single_price;
        this.car_id = car_id;
        this.book_id = book_id;
    }

    /**setter和getter*/
    public Integer getCb_id() {
        return cb_id;
    }

    public void setCb_id(Integer cb_id) {
        this.cb_id = cb_id;
    }

    public Integer getSingle_number() {
        return single_number;
    }

    public void setSingle_number(Integer single_number) {
        this.single_number = single_number;
    }

    public BigDecimal getSingle_price() {
        return single_price;
    }

    public void setSingle_price(BigDecimal single_price) {
        this.single_price = single_price;
    }

    public Integer getCar_id() {
        return car_id;
    }

    public void setCar_id(Integer car_id) {
        this.car_id = car_id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    /**toString*/
    @Override
    public String toString() {
        return "CarAndBook{" +
                "cb_id=" + cb_id +
                ", single_number=" + single_number +
                ", single_price=" + single_price +
                ", car_id=" + car_id +
                ", book_id=" + book_id +
                '}';
    }
}
