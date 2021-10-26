package com.ngoc.tour.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngoc.tour.entity.Tour;
import com.ngoc.tour.repository.DAO;
import com.ngoc.tour.repository.TourRepository;



@Service
public class TourService implements DAO<Tour>{
	
	@Autowired
	private TourRepository tourRepository;

	@Override
	public List<Tour> getList() {
		
		return tourRepository.findAll();
	}

	@Override
	public Tour findById(int id) {
		// TODO Auto-generated method stub
		return tourRepository.getById(id);
	}

	@Override
	public void insert(Tour vo) {
		// TODO Auto-generated method stub
		tourRepository.saveAndFlush(vo);
	}

	@Override
	public void update(Tour vo) {
		// TODO Auto-generated method stub
		tourRepository.save(vo);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		tourRepository.deleteById(id);
	}

}
