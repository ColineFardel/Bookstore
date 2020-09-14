package com.example.Bookstore.web;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.Bookstore.model.BookRepository;

@Controller
//@ResponseBody
public class BookController {
	
	@Autowired
	private BookRepository repository;

	
    @RequestMapping(value="/booklist")
    public String bookList(Model model) {	
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

}
