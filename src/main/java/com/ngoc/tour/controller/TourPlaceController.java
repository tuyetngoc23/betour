package com.ngoc.tour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngoc.tour.entity.Province;
import com.ngoc.tour.repository.TourPlaceRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/place")
public class TourPlaceController {

	@Autowired
	private TourPlaceRepository tourPlaceRepository;
	
	@GetMapping("/province")
	public ResponseEntity<?> getListProvince(){
		List<Province> provinceList = tourPlaceRepository.getListProvince();
		return ResponseEntity.ok(provinceList);
	}
}
