package com.cdc.demo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	private BookRepository bookRepository;

	@Autowired
	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@PostMapping("/book-service/books")
	public ResponseEntity<IdObject> createBook(@RequestBody @Valid Book user) {
		Book savedBook = this.bookRepository.save(user);
		return ResponseEntity.status(201).body(new IdObject(savedBook.getId()));
	}

	@PutMapping("/book-service/books/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody @Valid Book book, @PathVariable long id) {
		Book bookFromDb = bookRepository.findOne(id);
		bookFromDb.updateFrom(book);
		bookFromDb = bookRepository.save(bookFromDb);
		return ResponseEntity.ok(bookFromDb);
	}

	@GetMapping("/book-service/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") Long id) {
		return ResponseEntity.ok(bookRepository.findOne(id));
	}
}
