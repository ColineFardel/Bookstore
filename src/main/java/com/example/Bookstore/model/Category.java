package com.example.Bookstore.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="category")
	private List<Book> books;
	
	public Category(String name) {
		this.name=name;
	}
	
	public Category() {
		
	}
	
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
