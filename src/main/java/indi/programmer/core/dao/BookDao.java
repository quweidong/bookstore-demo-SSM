package indi.programmer.core.dao;

import indi.programmer.core.pojo.Arrange;
import indi.programmer.core.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**显示书籍模块的持久层接口*/
public interface BookDao {

    /**从book表中查询销量前二十的书籍*/
    List<Book> queryTopTwentyBooksFromTableBook();
    /**根据book表的book_id查询该条记录*/
    Book queryOneBookByBookId(Integer bookId);
    /**根据传递的参数从book表查询到的所有记录*/
    List<Book> queryBooksByInformation(@Param("inputBook") Book book, @Param("arrange") Arrange arrange);
    /**根据传递的参数查询到的记录总数*/
    int queryBooksNumberByInformation(Book book);
}
