package com.cdc.demo;

public class Book {

	private Long id;
	private String name;
	private String author;
	private double price;
	
	public Book() {
		
	}
	
	public Book(Long id, String name, String author, double price) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
	}

	public void updateFrom(Book book) {
		this.author = book.getAuthor();
		this.name = book.getName();
		this.price = book.getPrice();
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
