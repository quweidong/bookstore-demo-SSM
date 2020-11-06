package indi.programmer.core.service;

import indi.programmer.core.pojo.Book;

import java.util.List;

//书籍模块service层接口
public interface BookService {
    List<Book> TopTwentySales();
}
