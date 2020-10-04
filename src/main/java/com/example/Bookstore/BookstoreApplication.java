package com.example.Bookstore;

import org.aspectj.apache.bcel.classfile.Module.Uses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;
import com.example.Bookstore.model.Category;
import com.example.Bookstore.model.CategoryRepository;
import com.example.Bookstore.model.User;
import com.example.Bookstore.model.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository catrepos, UserRepository urepository){
		return(args)->{
			
			log.info("save a couple of books");
			catrepos.save(new Category("Thriller"));
			catrepos.save(new Category("Comedy"));
			catrepos.save(new Category("Romance"));
			
			repository.save(new Book("La Peste", "Albert Camus", 1956, "12311-2", 15.34, catrepos.findByName("Thriller").get(0)));
			repository.save(new Book("Fahrenheit 451", "Ray Bradbury", 1932, "83891-1", 12.45, catrepos.findByName("Comedy").get(0)));	
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
	};

}
}
