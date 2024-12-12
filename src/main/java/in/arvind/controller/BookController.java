package in.arvind.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.arvind.entity.Book;
import in.arvind.service.BookService;

@Controller
public class BookController {

    @Autowired
    private BookService service;
    
    @GetMapping("/books")
    public ModelAndView getAllBooks() {
        ModelAndView mav = new ModelAndView();
        List<Book> bookData = service.getBookData();
        mav.addObject("books", bookData);
        mav.setViewName("index");
        return mav;
    }
    @GetMapping("/delete")
    public ModelAndView deleteBook(@RequestParam("id") Integer id) {
    	service.deletBook(id);
        ModelAndView mav = new ModelAndView();
        List<Book> bookData = service.getBookData();
        mav.addObject("books", bookData);
        mav.setViewName("index");
        return mav;
    }

    // Changed to POST as saving a book is an action that modifies data
    @PostMapping("/SaveBook")
    public ModelAndView saveBook(Book b) {
        ModelAndView mav = new ModelAndView();
        boolean status = service.saveBook(b);
        if (status) {
            mav.addObject("success", "Record saved successfully.");
        } else {
            mav.addObject("error", "Failed to save record.");
        }
        mav.setViewName("addBook");
        return mav;
    }

    @GetMapping("/addBook")
    public ModelAndView addBook() {
        ModelAndView mav = new ModelAndView();
        //form binding
        mav.addObject("book", new Book());
        mav.setViewName("addBook");
        return mav;
    }
    @GetMapping("/update")
    public ModelAndView updateBook(@RequestParam("bookId") Integer bookId) {
    	Book bookObj = service.getBookById(bookId);
        ModelAndView mav = new ModelAndView();
        mav.addObject("book", bookObj);
        mav.setViewName("addBook");
        return mav;
    }

}
