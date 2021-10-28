package com.ngoc.tour.controller;

import java.io.File;
import java.io.FileNotFoundException;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ngoc.tour.entity.Place;
import com.ngoc.tour.service.PlaceService;

import lombok.experimental.PackagePrivate;

@CrossOrigin("*")
@RestController
public class PlaceController {
	
	@Autowired
	private PlaceService placeService;
	
	@GetMapping("/place/list")
	public ResponseEntity<?> getListPlace(){
		List<Place> listPlace = placeService.getList();
		return ResponseEntity.ok(listPlace);
	}
	
	@GetMapping("/place/{id}")
	public ResponseEntity<?> getPlace(@PathVariable int id){
		return ResponseEntity.ok(placeService.findById(id));
	}
	
	@PostMapping("/place/insert")
	public void insert(@ModelAttribute Place p, @ModelAttribute("file") MultipartFile file) throws IOException {
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
		
		p.setImage(originalName);
		placeService.insert(p);
	}
	
	@PostMapping("/place/delete/{id}")
	public void delete(@PathVariable int id) {
		placeService.delete(id);
	}
	
	@PostMapping("/place/update")
	public void update(@ModelAttribute Place p, @ModelAttribute("file") MultipartFile file) throws IOException {
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
		
		p.setImage(originalName);
		placeService.update(p);
	}
}
