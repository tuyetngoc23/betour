package com.ngoc.tour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
