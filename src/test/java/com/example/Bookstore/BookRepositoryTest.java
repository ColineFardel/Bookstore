package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;
import com.example.Bookstore.model.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	private BookRepository repository;

	//search
    @Test
    public void findByTitleShouldReturnBook() {
        List<Book> books = repository.findByTitle("La Peste");
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Albert Camus");
    }
    
    //create
    @Test
    public void createNewBook() {
    	Book book = new Book("Da Vinci Code", "Dan Brown",2015, "113-431", 9.56 ,new Category("TEST"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }
    
    //delete
    @Test
    public void deleteBook() {    	
    	List<Book> books = repository.findByTitle("La Peste");
    	assertThat(books).hasSize(1);
    	
    	repository.deleteById(books.get(0).getId());
    	assertThat(repository.findByTitle("La Peste")).hasSize(0);
    }
}
