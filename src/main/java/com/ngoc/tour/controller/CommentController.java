package com.ngoc.tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngoc.tour.entity.Comment;
import com.ngoc.tour.service.CommentService;

@CrossOrigin("*")
@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@PostMapping("/comment/add")
	public void insertComment(@ModelAttribute Comment vo) {
		commentService.insert(vo);
	}
}
