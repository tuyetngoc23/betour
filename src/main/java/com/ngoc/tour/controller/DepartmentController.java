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

import com.ngoc.tour.entity.Department;
import com.ngoc.tour.service.DepartmentService;

@RestController
@CrossOrigin("*")
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping({"", "/"})
	public ResponseEntity<?> getList(){
		List<Department> departmentList = departmentService.getList();
		return ResponseEntity.ok(departmentList);
	}
	
	@PostMapping("/insert")
	public void insert(@ModelAttribute Department vo) {
		departmentService.insert(vo);
	}
	
	@PostMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		departmentService.delete(id);
	}
}
