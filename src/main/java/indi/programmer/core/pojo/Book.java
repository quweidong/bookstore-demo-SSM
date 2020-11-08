package indi.programmer.core.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**book表实体类*/
public class Book {
    private Integer book_id;
    private String book_isbn;
    private String book_name;
    private String book_author;
    private Date publish_time;
    private String publish_house;
    private Integer page_number;
    private BigDecimal book_price;
    private Integer sales_volume;
    private Integer book_stock;
    private String img_url;
    private String book_introduce;

    /**构造方法*/

    public Book() {
    }

    public Book(Integer book_id, String book_isbn, String book_name, String book_author, Date publish_time, String publish_house, Integer page_number, BigDecimal book_price, Integer sales_volume, Integer book_stock, String img_url, String book_introduce) {
        this.book_id = book_id;
        this.book_isbn = book_isbn;
        this.book_name = book_name;
        this.book_author = book_author;
        this.publish_time = publish_time;
        this.publish_house = publish_house;
        this.page_number = page_number;
        this.book_price = book_price;
        this.sales_volume = sales_volume;
        this.book_stock = book_stock;
        this.img_url = img_url;
        this.book_introduce = book_introduce;
    }

    /**getter和setter方法*/

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getBook_isbn() {
        return book_isbn;
    }

    public void setBook_isbn(String book_isbn) {
        this.book_isbn = book_isbn;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public Date getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(Date publish_time) {
        this.publish_time = publish_time;
    }

    public String getPublish_house() {
        return publish_house;
    }

    public void setPublish_house(String publish_house) {
        this.publish_house = publish_house;
    }

    public Integer getPage_number() {
        return page_number;
    }

    public void setPage_number(Integer page_number) {
        this.page_number = page_number;
    }

    public BigDecimal getBook_price() {
        return book_price;
    }

    public void setBook_price(BigDecimal book_price) {
        this.book_price = book_price;
    }

    public Integer getSales_volume() {
        return sales_volume;
    }

    public void setSales_volume(Integer sales_volume) {
        this.sales_volume = sales_volume;
    }

    public Integer getBook_stock() {
        return book_stock;
    }

    public void setBook_stock(Integer book_stock) {
        this.book_stock = book_stock;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getBook_introduce() {
        return book_introduce;
    }

    public void setBook_introduce(String book_introduce) {
        this.book_introduce = book_introduce;
    }

    /**toString方法*/

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", book_isbn='" + book_isbn + '\'' +
                ", book_name='" + book_name + '\'' +
                ", book_author='" + book_author + '\'' +
                ", publish_time=" + publish_time +
                ", publish_house='" + publish_house + '\'' +
                ", page_number=" + page_number +
                ", book_price=" + book_price +
                ", sales_volume=" + sales_volume +
                ", book_stock=" + book_stock +
                ", img_url='" + img_url + '\'' +
                ", book_introduce='" + book_introduce + '\'' +
                '}';
    }
}
