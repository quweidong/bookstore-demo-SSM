package indi.programmer.core.serviceImpl;

import indi.programmer.core.BaseTest;
import indi.programmer.core.pojo.Book;
import indi.programmer.core.service.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class BookServiceImplTest extends BaseTest {

    @Autowired
    private BookService bookService;

    @Test
    public void topTwentySales() {
        List<Book> bookList = bookService.TopTwentySales();
        for (Book book : bookList){
            System.out.println(book);
        }
    }

    @Test
    public void selectOneBook() {
        Book book = bookService.selectOneBook(2);
        System.out.println(book);
    }

    @Test
    public void searchBooksNumberByBookNameOrAuthor() {
        int count = bookService.searchBooksNumberByBookNameOrAuthor("马");
        System.out.println(count);
    }

    @Test
    public void searchBooksByBookNameOrAuthor() {
        List<Book> bookList = bookService.searchBooksByBookNameOrAuthor("马","desc","book_price",1);
        for (Book book:bookList){
            System.out.println(book);
        }
    }
}