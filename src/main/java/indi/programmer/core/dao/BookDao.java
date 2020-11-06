package indi.programmer.core.dao;

import indi.programmer.core.pojo.Book;

import java.util.List;

//书籍显示模块的dao层接口
public interface BookDao {
    //从book表查询销量为前二十的书籍
    List<Book> queryTopTwentyBooksFromBook();
}
