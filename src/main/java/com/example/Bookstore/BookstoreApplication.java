package com.example.Bookstore;

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

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository catrepos){
		return(args)->{
			
			log.info("save a couple of books");
			catrepos.save(new Category("Thriller"));
			catrepos.save(new Category("Comedy"));
			catrepos.save(new Category("Romance"));
			
			repository.save(new Book("La Peste", "Albert Camus", 1956, "12311-2", 15.34, catrepos.findByName("Thriller").get(0)));
			repository.save(new Book("Fahrenheit 451", "Ray Bradbury", 1932, "83891-1", 12.45, catrepos.findByName("Comedy").get(0)));	
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
	};

}
}
