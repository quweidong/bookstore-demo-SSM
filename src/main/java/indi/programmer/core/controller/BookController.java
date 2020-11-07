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
}
