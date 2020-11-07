package indi.programmer.core.dao;

import indi.programmer.core.pojo.Book;

import java.util.List;

/**显示书籍模块的持久层接口*/
public interface BookDao {

    /**从book表中查询销量前二十的书籍*/
    List<Book> queryTopTwentyBooksFromTableBook();
}
