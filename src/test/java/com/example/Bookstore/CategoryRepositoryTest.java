package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.Category;
import com.example.Bookstore.model.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {
	@Autowired
    private CategoryRepository repository;

    @Test
    public void findByNameShouldReturnCategory() {
    	List<Category> categories = repository.findByName("Comedy");
    	assertThat(categories).hasSize(1);
    }
    
    @Test
    public void createNewCategory() {
    	Category category = new Category("TEST");
    	repository.save(category);
    	assertThat(category.getId()).isNotNull();
    }    
    
    @Test
    public void deleteCategory() {    	
    	List<Category> categories = repository.findByName("Comedy");
    	assertThat(categories).hasSize(1);
    	
    	repository.deleteById(categories.get(0).getId());
    	assertThat(repository.findByName("Comedy")).hasSize(0);
    }
}
