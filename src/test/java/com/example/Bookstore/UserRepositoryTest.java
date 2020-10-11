package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.model.User;
import com.example.Bookstore.model.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
    private UserRepository repository;

    @Test
    public void findByUsernameShouldReturnUser() {
        User user = repository.findByUsername("admin");
        
        assertThat(user).isNotNull();
        assertThat(user.getRole()).isEqualTo("ADMIN");
    }
    
    @Test
    public void createNewUser() {
    	User user = new User("Mickey", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
    	repository.save(user);
    	assertThat(user.getId()).isNotNull();
    }   
    
    @Test
    public void deleteUser() {
    	User user = repository.findByUsername("admin");
        assertThat(user).isNotNull();
        
        repository.deleteById(user.getId());
    	assertThat(repository.findByUsername("admin")).isNull();
    }
}
