package com.example.Bookstore.web;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class BookController {
	
	@GetMapping("/index")
	public String index() {
		return "Welcome to the bookstore";
	}


}
