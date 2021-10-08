package com.ngoc.tour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngoc.tour.entity.Hotel;
import com.ngoc.tour.service.HotelService;

@CrossOrigin("*")
@RestController
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@GetMapping({"", "/"})
	public ResponseEntity<?> getList(){
		List<Hotel> hotelList = hotelService.getList();
		return ResponseEntity.ok(hotelList);
	}
}
