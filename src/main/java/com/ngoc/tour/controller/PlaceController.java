package com.ngoc.tour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngoc.tour.entity.Place;
import com.ngoc.tour.service.PlaceService;

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
}
