package com.ngoc.tour.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ngoc.tour.entity.Tour;
import com.ngoc.tour.service.TourService;


@RestController
@RequestMapping("/tour")
public class TourController {
	
	@Autowired
	private TourService tourService;
	
	@GetMapping(value={"", "/"})
	public ResponseEntity<?> tourList() {
		
		List<Tour> tourList = tourService.getList();
		
		return ResponseEntity.ok(tourList);
//		return tourService.getList();
	}
}
