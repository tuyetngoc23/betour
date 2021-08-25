package com.ngoc.tour.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngoc.tour.entity.Tour;
import com.ngoc.tour.repository.DAO;
import com.ngoc.tour.repository.TourRepository;



@Service
public class TourService implements DAO<Tour> {
	
	@Autowired
	private TourRepository tourRepository;

	@Override
	public List<Tour> getList() {
		
		return tourRepository.findAll();
	}

	@Override
	public Tour findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Tour vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Tour vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}



}
