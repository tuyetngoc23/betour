package com.ngoc.tour.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngoc.tour.entity.Blog;
import com.ngoc.tour.entity.Book;
import com.ngoc.tour.service.BookService;

@CrossOrigin("*")
@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/book")
	public ResponseEntity<?> getListBlog(){
		List<Book> bookList = bookService.getList();
		
		return ResponseEntity.ok(bookList);
	}
	
	@PostMapping("/book/add")
	public void insertBook(@ModelAttribute Book vo){
		bookService.insert(vo);
	} 
}
