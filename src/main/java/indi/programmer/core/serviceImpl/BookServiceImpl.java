package indi.programmer.core.serviceImpl;

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

    @Override
    public List<Book> TopTwentySales() {
        List<Book> bookList = bookDao.queryTopTwentyBooksFromTableBook();
        return bookList;
    }
}
