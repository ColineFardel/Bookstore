package com.example.Bookstore.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;
import com.example.Bookstore.model.CategoryRepository;

@Controller
//@ResponseBody
public class BookController {
	
	@Autowired
	private BookRepository bookrepository;
	@Autowired
	private CategoryRepository catrepository;

	
    @RequestMapping(value="/booklist")
    public String bookList(Model model) {	
        model.addAttribute("books", bookrepository.findAll());
        return "booklist";
    }
    
    @RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categories", catrepository.findAll());
        return "addbook";
    }  
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
    	bookrepository.save(book);
        return "redirect:booklist";
    }  
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	bookrepository.deleteById(bookId);
        return "redirect:../booklist";
    }
    
    @RequestMapping(value = "/modify/{id}", method = RequestMethod.GET)
    public String modifyBook(@PathVariable("id") Long bookId, Model model) {
    	Optional<Book> book = bookrepository.findById(bookId);
    	model.addAttribute("book", book);
    	model.addAttribute("categories", catrepository.findAll());
        return "modifybook";
    }

}
