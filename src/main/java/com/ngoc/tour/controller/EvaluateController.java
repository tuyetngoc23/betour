package com.ngoc.tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ngoc.tour.entity.Evaluate;
import com.ngoc.tour.repository.EvaluateRepository;
import com.ngoc.tour.service.EvaluateService;

@CrossOrigin("*")
@RestController
@Transactional
public class EvaluateController {
	
	@Autowired
	private EvaluateService evaluateService;
	@Autowired
	private EvaluateRepository evaluateRepository;
	
	@PostMapping("/evaluate/add")
	public void insert(@ModelAttribute Evaluate evaluate) {
		Evaluate eva = evaluateRepository.findByUser(evaluate.getUser().getId(), evaluate.getTour().getId());
		if(eva != null) {
			evaluateService.update(evaluate);
			System.out.println("update success");
		}else {
			evaluateService.insert(evaluate);
			System.out.println("insert success");
		}
		
	}
	
	@GetMapping("/evaluate")
	public ResponseEntity<?> getEvaluateBy(@RequestParam int userId, @RequestParam int tourId){
		Evaluate eva = evaluateRepository.findByUser(userId, tourId);
		return ResponseEntity.ok(eva);
	}
}
