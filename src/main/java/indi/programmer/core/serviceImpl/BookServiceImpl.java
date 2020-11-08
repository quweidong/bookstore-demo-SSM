package indi.programmer.core.serviceImpl;

import com.github.pagehelper.PageHelper;
import indi.programmer.core.dao.BookDao;
import indi.programmer.core.pojo.Book;
import indi.programmer.core.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    @Qualifier(value = "bookDao")
    private BookDao bookDao;

    /**查询销量前二十书籍并返回*/
    @Override
    public List<Book> TopTwentySales() {
        List<Book> bookList = bookDao.queryTopTwentyBooksFromTableBook();
        return bookList;
    }

    /**根据书籍id查询一件商品*/
    @Override
    public Book selectOneBook(Integer bookId) {
        Book book =  bookDao.queryOneBookByBookId(bookId);
        return book;
    }

    /**对传入的字段进行模糊查询，返回总记录条数*/
    @Override
    public int searchBooksNumberByBookNameOrAuthor(String bookNameOrAuthor) {
        Book book = new Book();
        book.setBook_author("%"+bookNameOrAuthor+"%");
        book.setBook_name("%"+bookNameOrAuthor+"%");
        return bookDao.queryBooksNumberByInformation(book);
    }

    /**根据传入的字段进行查询，返回相应的书籍集合*/
    @Override
    public List<Book> searchBooksByBookNameOrAuthor(String bookNameOrAuthor, String arrangeMethod, String arrangeField, Integer pageNumber) {
        Book book = new Book();
        book.setBook_author("%"+bookNameOrAuthor+"%");
        book.setBook_name("%"+bookNameOrAuthor+"%");
        PageHelper.startPage(pageNumber,10);
        List<Book> bookList = bookDao.queryBooksByInformation(book,arrangeMethod,arrangeField);
        return bookList;
    }
}
