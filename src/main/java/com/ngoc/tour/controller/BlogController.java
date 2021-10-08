package com.ngoc.tour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngoc.tour.entity.Blog;
import com.ngoc.tour.entity.Comment;
import com.ngoc.tour.repository.BlogRepository;
import com.ngoc.tour.service.BlogService;

@CrossOrigin("*")
@RestController
@RequestMapping("/blog")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	@Autowired
	private BlogRepository blogRepository;

	@GetMapping({"", "/"})
	public ResponseEntity<?> getListBlog(){
		List<Blog> blogList = blogService.getList();
		
		return ResponseEntity.ok(blogList);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getBlog(@PathVariable("id") int id){
		Blog blog = blogService.findById(id);
		
		return ResponseEntity.ok(blog);
	}
	@GetMapping("/comment/{id}")
	public ResponseEntity<?> getCommentList(@PathVariable("id") int id){
		List<Comment> commentList = blogRepository.getCommentList(id);
		
		return ResponseEntity.ok(commentList);
	}
}
