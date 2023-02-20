package com.bookdetail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookdetail.model.Book;
import com.bookdetail.service.BookService;
import com.bookdetail.util.ResponseWrapper;

@RestController
@RequestMapping("/bookstore")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/add")
	public ResponseEntity<?> bookadd(@RequestBody Book book) {
		this.bookService.add(book);
		return new ResponseEntity<>("book has been add", HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public  ResponseEntity<?> list() {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setMessage("SHOW ALL DATA ");
		responseWrapper.setData(this.bookService.show());
 		 return new ResponseEntity<>(responseWrapper,HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<?> bookupdate(@PathVariable Integer id,@RequestBody  Book book) {
		this.bookService.upadate(id, book);
		return new ResponseEntity<>("book is updated", HttpStatus.OK) ;
	}
	
	@GetMapping("/findid/{id}")
	public ResponseEntity<?> bookfindbyid(@PathVariable Integer id) {
 		return new ResponseEntity<>(this.bookService.findId(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<?> bookdelete(@PathVariable Integer id)
	{
		 this.bookService.delete(id);
		return new ResponseEntity<>("select book has been deleted",HttpStatus.OK);
	}

}
