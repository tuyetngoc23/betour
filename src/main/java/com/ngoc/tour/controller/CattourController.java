package com.ngoc.tour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngoc.tour.entity.CatTour;
import com.ngoc.tour.service.CattourService;

@RestController
@CrossOrigin("*")
@RequestMapping("/cat")
public class CattourController {

	@Autowired
	private CattourService cattourService;
	
	@GetMapping({"", "/"})
	public ResponseEntity<?> getList(){
		List<CatTour> getCatList = cattourService.getList();
		return ResponseEntity.ok(getCatList);
	}
}
