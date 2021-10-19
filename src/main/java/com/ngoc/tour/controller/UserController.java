package com.ngoc.tour.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;

import javax.validation.Valid;

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
//	
//	@Value("#{config['file.upload']}")
//	private String FILE_UPLOAD_DIR;
	
	private static final Path CURRENT_FOLDER = Paths.get("file.upload-dir");
	
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	@ResponseBody
	public void insert(@ModelAttribute UserTour vo, @ModelAttribute("file") MultipartFile file) throws IOException {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		vo.setPasswd(passwordEncoder.encode(vo.getPasswd()));
		
//		System.out.println("alo" + CURRENT_FOLDER);
//		java.io.File file = new java.io.File("D:\\HK9\\DAN\\fetour\\public\\asset\\images");
//		Path file = CURRENT_FOLDER.resolve(img.getOriginalFilename());/
//	    try (OutputStream os = Files.getFileStore(file)) {
//	        	os.write(img.getBytes());
//	    }
//	    vo.setAvatar(img.getOriginalFilename());
		
//		Path path = Paths.get("images");
		if (file == null) {
			throw new RuntimeException("You must select the a file for uploading");
		}
		Object f = new File("D:\\HK9\\DAN\\fetour\\public\\asset\\images");
		InputStream inputStream = file.getInputStream();
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
	
	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public ResponseEntity<?> login(@RequestParam(name="username", defaultValue = "") String username){
		UserDetails user =  userService.loadUserByUsername(username);
		System.out.println("login");
		return ResponseEntity.ok(user);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@RequestParam(name="username", defaultValue = "") String username){
		UserTour user = userRepository.findByUserName(username);
		return ResponseEntity.ok(user);
	}
	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	public ResponseEntity<?> getListUser(){
		List<UserTour> getList = userService.getList();
		return ResponseEntity.ok(getList);
	}
	
	
}
