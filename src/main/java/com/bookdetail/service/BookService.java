package com.bookdetail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bookdetail.model.Book;
import com.bookdetail.repository.BookRepository;

@Service 

public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	public Book add(Book book) {
		return this.bookRepository.save(book);
	}
	
	public Iterable<Book> show() {
		return this.bookRepository.findAll();
	}
	
	public Book findId(Integer id) {
		return this.bookRepository.findById(id).orElseThrow(
				()->{throw new ResponseStatusException(HttpStatus.NOT_FOUND);
				});
	}
	
	public Book upadate(Integer id,Book book) {
		this.bookRepository.findById(id).orElseThrow(
				()->{throw new ResponseStatusException(HttpStatus.NOT_FOUND);
				});
		book.setBookid(id);
		return this.bookRepository.save(book);
	}
	
	public void delete (Integer id)
	{
		this.bookRepository.deleteById(id);
	}
}
