package com.ngoc.tour.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ngoc.tour.entity.Blog;
import com.ngoc.tour.entity.Comment;
import com.ngoc.tour.repository.BlogRepository;
import com.ngoc.tour.service.BlogService;

@CrossOrigin("*")
@RestController
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	@Autowired
	private BlogRepository blogRepository;

	@GetMapping({"/blog", "/blog/"})
	public ResponseEntity<?> getListBlog(){
		List<Blog> blogList = blogService.getList();
		
		return ResponseEntity.ok(blogList);
	}
	
	@GetMapping("/blog/{id}")
	public ResponseEntity<?> getBlog(@PathVariable("id") int id){
		Blog blog = blogService.findById(id);
		
		return ResponseEntity.ok(blog);
	}
	@GetMapping("/blog/comment/{id}")
	public ResponseEntity<?> getCommentList(@PathVariable("id") int id){
		List<Comment> commentList = blogRepository.getCommentList(id);
		
		return ResponseEntity.ok(commentList);
	}
	
	@PostMapping("/blog/insert")
	public void insert(@ModelAttribute Blog vo, @ModelAttribute("file") MultipartFile file) throws IOException {
		if (file == null) {
			throw new RuntimeException("You must select the a file for uploading");
		}
		File f = new File("D:\\HK9\\DAN\\fetour\\public\\asset\\images\\" + file.getOriginalFilename());
		InputStream inputStream = file.getInputStream();
		@SuppressWarnings("resource")
		FileOutputStream outputStream = new FileOutputStream(f);
		int read;
		byte[] bytes = new byte[1024];
		while ((read = inputStream.read(bytes)) != -1) {
			outputStream.write(bytes, 0, read);
		}
		String originalName = file.getOriginalFilename();
		String name = file.getName();
		String contentType = file.getContentType();
		long size = file.getSize();
		
		vo.setImage(originalName);
		blogService.insert(vo);
	}
	
	@PostMapping("/blog/update")
	public void update(@ModelAttribute Blog vo, @ModelAttribute("file") MultipartFile file) throws IOException {
		if (file == null) {
			throw new RuntimeException("You must select the a file for uploading");
		}
		File f = new File("D:\\HK9\\DAN\\fetour\\public\\asset\\images\\" + file.getOriginalFilename());
		InputStream inputStream = file.getInputStream();
		@SuppressWarnings("resource")
		FileOutputStream outputStream = new FileOutputStream(f);
		int read;
		byte[] bytes = new byte[1024];
		while ((read = inputStream.read(bytes)) != -1) {
			outputStream.write(bytes, 0, read);
		}
		String originalName = file.getOriginalFilename();
		String name = file.getName();
		String contentType = file.getContentType();
		long size = file.getSize();
		
		vo.setImage(originalName);
		blogService.update(vo);
	}
	
	@PostMapping("/blog/delete/{id}")
	public void delete(@PathVariable int id) {
		blogService.delete(id);
	}
}
