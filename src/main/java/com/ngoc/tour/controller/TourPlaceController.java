package com.ngoc.tour.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.persistence.EntityManager;

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

import com.ngoc.tour.entity.Place;
import com.ngoc.tour.entity.Province;
import com.ngoc.tour.entity.TourPlace;
import com.ngoc.tour.repository.TourPlaceRepository;
import com.ngoc.tour.service.TourPlaceService;
import com.ngoc.tour.service.TourService;

@RestController
@CrossOrigin("*")
@RequestMapping("/place")
public class TourPlaceController {

	@Autowired
	private TourPlaceRepository tourPlaceRepository;
	
	@Autowired
	private TourPlaceService tourPlaceService;
	@Autowired
	private TourService tourService;
	
	@GetMapping("/province")
	public ResponseEntity<?> getListProvince(){
		List<Province> provinceList = tourPlaceRepository.getListProvince();
		return ResponseEntity.ok(provinceList);
	}
	
	@GetMapping("/{tourId}/list")
	public ResponseEntity<?> getListByTourId(@PathVariable int tourId){
		List<Place> listPlace = tourPlaceService.getListByTourID(tourId);
		return ResponseEntity.ok(listPlace);
	}
	
	@PostMapping("/tour/insert")
	public void insert(@ModelAttribute TourPlace tp) {
//		
		tourPlaceService.insert(tp);
	}
	
	@PostMapping("/tour/update")
	public void update(@ModelAttribute TourPlace tp) {
		tourPlaceService.update(tp);
	}
	
	@PostMapping("/tour/delete/{id}")
	public void deleteByTourId(@PathVariable int id) {
		tourPlaceService.delete(id);
	}
}
