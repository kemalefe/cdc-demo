package com.cdc.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class BookRepository {

	private static Map<Long, Book> bookMap = new HashMap<Long, Book>();

	public BookRepository() {
		bookMap = new HashMap<>();
		bookMap.put(1L, new Book(1L, "Orhan Pamuk", "Benim Adım Kırmızı", 30.00d));
		bookMap.put(2L, new Book(2L, "Zülfü Livaneli", "Mutluluk", 27.00d));
		bookMap.put(3L, new Book(3L, "Jean Christophe Grange", "Kızıl Nehirler", 22.00d));
	}
	
	public Book save(Book book) {
		bookMap.put(book.getId(), book);
		return book;
	}

	public Book findOne(long id) {
		return bookMap.get(id);
	}

	public Book update(long id, Book book) {
		bookMap.put(id, book);
		book.setId(id);
		return book;
	}
}
