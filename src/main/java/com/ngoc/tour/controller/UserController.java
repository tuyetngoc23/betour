package com.ngoc.tour.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.ngoc.tour.entity.UserTour;
import com.ngoc.tour.repository.UserRepository;
import com.ngoc.tour.service.UserService;

@CrossOrigin("*")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;

	//them 1 user
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	@ResponseBody
	public void insert(@ModelAttribute UserTour vo, @ModelAttribute("file") MultipartFile file) throws IOException {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		vo.setPasswd(passwordEncoder.encode(vo.getPasswd()));
		
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
		System.out.println("inputStream: " + inputStream);
		System.out.println("originalName: " + originalName);
		System.out.println("name: " + name);
		System.out.println("contentType: " + contentType);
		System.out.println("size: " + size);
		
		vo.setAvatar(originalName);
		userService.insert(vo);
	}
	//check login
	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public ResponseEntity<?> login(@RequestParam(name="username", defaultValue = "") String username, 
									@RequestParam(name="password", defaultValue = "") String passwd){
		UserDetails user =  userService.loadUserByUsername(username);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(passwordEncoder.matches(passwd, user.getPassword())) {
			System.out.println("login");
			return ResponseEntity.ok(user);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST) ;
		}
		
	}
	//lay 1 user theo username
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@RequestParam(name="username", defaultValue = "") String username){
		UserTour user = userRepository.findByUserName(username);
		return ResponseEntity.ok(user);
	}
	
	//lay user theo id
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUserById(@PathVariable("id") int id){
		return ResponseEntity.ok(userService.findById(id));
	}
	//lay list user
	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	public ResponseEntity<?> getListUser(){
		List<UserTour> getList = userService.getList();
		return ResponseEntity.ok(getList);
	}
	//update user
	@RequestMapping(value = "/user/delete/{id}", method = RequestMethod.POST)
	public void deleteUser(@PathVariable("id") int id){
		System.out.println(id);
		userService.delete(id);
	}
	
}
