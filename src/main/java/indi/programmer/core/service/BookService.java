package indi.programmer.core.service;

import indi.programmer.core.pojo.Book;

import java.util.List;

/**展示书籍模块service层接口*/
public interface BookService {
    /**查询销量前二十的书籍*/
    List<Book> TopTwentySales();
    /**根据id查询一本书籍的信息*/
    Book selectOneBook(Integer bookId);
    /**模糊查询：根据传递过来的书名和作者的部分信息查询相关的总记录条数*/
    int searchBooksNumberByBookNameOrAuthor(String bookNameOrAuthor);
    /**根据传递过来的书名和作者的部分信息，排序的方式，排序的字段查询相关的所有书籍，需要在实现方法中进行分页*/
    List<Book> searchBooksByBookNameOrAuthor(String bookNameOrAuthor,String arrangeMethod,String arrangeField,Integer pageNumber);
}
