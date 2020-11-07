package indi.programmer.core.service;

import indi.programmer.core.pojo.Book;

import java.util.List;

/**展示书籍模块service层接口*/
public interface BookService {
    /**查询销量前二十的书籍*/
    List<Book> TopTwentySales();
}
