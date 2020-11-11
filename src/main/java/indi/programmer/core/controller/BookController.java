package indi.programmer.core.controller;

import indi.programmer.core.pojo.Book;
import indi.programmer.core.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**书籍展示模块的控制层*/
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @ResponseBody
    @RequestMapping(value = "/bestSellerList",method = RequestMethod.GET)
    public List<Book> bestSellerList(){
        return bookService.TopTwentySales();
    }

    @ResponseBody
    @RequestMapping(value = "/searchOneBookInformation",method = RequestMethod.GET)
    public Book searchOneBookInformation(Integer bookId){
        return bookService.selectOneBook(bookId);
    }

    @ResponseBody
    @RequestMapping(value = "/searchBooksNumberByMessage",method = RequestMethod.GET)
    public Integer searchBooksNumberByMessages(String searchBoxMessage){
        return bookService.searchBooksNumberByBookNameOrAuthor(searchBoxMessage);
    }

    @ResponseBody
    @RequestMapping(value = "/searchBooksByMessage",method = RequestMethod.GET)
    public List<Book> searchBooksByMessage(String searchBoxMessage,String arrangeMethod,String arrangeField,Integer pageNumber){
        if ("null".equals(arrangeField)){
            arrangeField = null;
        }
        if ("null".equals(arrangeMethod)){
            arrangeMethod = null;
        }
        return bookService.searchBooksByBookNameOrAuthor(searchBoxMessage,arrangeMethod,arrangeField,pageNumber);
    }
}
