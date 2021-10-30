package com.ngoc.tour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngoc.tour.entity.Vehicle;
import com.ngoc.tour.repository.VehicleRepository;
import com.ngoc.tour.service.VehicleService;

@CrossOrigin("*")
@RestController
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping({"", "/"})
	public ResponseEntity<?> getList(){
		List<Vehicle> vehicleList = vehicleService.getList();
		return ResponseEntity.ok(vehicleList);
	}
	
	@PostMapping("/insert")
	public void insert(@ModelAttribute Vehicle vo) {
		vehicleService.insert(vo);
	}
	
	
	@PostMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		vehicleService.delete(id);
	}
}
