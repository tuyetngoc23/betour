package com.ngoc.tour.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ngoc.tour.entity.Tour;
import com.ngoc.tour.entity.TourPlace;
import com.ngoc.tour.repository.TourPlaceRepository;
import com.ngoc.tour.repository.TourRepository;
import com.ngoc.tour.service.TourService;

@CrossOrigin("*")
@RestController
@RequestMapping("/tour")
public class TourController {
	
	@Autowired
	private TourService tourService;
	@Autowired
	private TourRepository tourRepository;
	@Autowired
	private TourPlaceRepository tourPlaceRepository;
	
	
	@GetMapping(value={"", "/"})
	public ResponseEntity<?> searchTourList(@RequestParam(name="date", defaultValue = "1990-07-27") String date, 
			@RequestParam(name="cattour", defaultValue = "0") String cat_id,
				@RequestParam(name="prov", defaultValue = "0") String prov_id,
				@RequestParam(name="departure", defaultValue = "0") String departure,
				@RequestParam(name="ks", defaultValue = "0") String ks,
				@RequestParam(name="phuongtien", defaultValue = "0") String vehicle,
				@RequestParam(name="timgiatu", defaultValue = "0") String timgiatu,
				@RequestParam(name="timgiaden", defaultValue = "0") String timgiaden) throws Exception{
		
		Date d1 = null;
		try {
			d1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int c1 = Integer.parseInt(cat_id);
		int p1 = Integer.parseInt(prov_id);
		
		List<Tour> tourList = tourPlaceRepository.findDistinctListTour(c1, p1, d1, Integer.parseInt(departure),
									Integer.parseInt(ks), Integer.parseInt(vehicle), new BigDecimal(timgiatu),
									new BigDecimal(timgiaden));
		List<Tour> tourList1 = tourService.getList();
		if(tourList == null || tourList.isEmpty()) {
			return ResponseEntity.ok(tourList1);
		}else {
			return ResponseEntity.ok(tourList);
		}
	}
	
	@GetMapping("/tourplace/{id}")
	public ResponseEntity<?> getTourPlace(@PathVariable int id) {
		List<TourPlace> tourPlaceList = tourRepository.getListByTourID(id);
		
		return ResponseEntity.ok(tourPlaceList);
	}
	
	@GetMapping("/{tourId}")
	public ResponseEntity<?> getTour(@PathVariable int tourId) {
		Tour tour = tourService.findById(tourId);
		
		return ResponseEntity.ok(tour);
	} 
	
	@PostMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		tourService.delete(id);
	}
	 
	@PostMapping("/update")
	public void update(@ModelAttribute Tour tour, @ModelAttribute("file") MultipartFile file) throws IOException {
		if (file == null) {
//			throw new RuntimeException("You must select the a file for uploading");
		}else {
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
			
			tour.setImage(originalName);
		}
		
		tourService.update(tour);
	}
	
	@PostMapping("/insert")
	public void insert(@ModelAttribute Tour tour, @ModelAttribute("file") MultipartFile file) throws IOException {
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
		
		tour.setImage(originalName);
		
		tourService.insert(tour);
	}
}
