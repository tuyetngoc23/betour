package com.ngoc.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngoc.tour.entity.CatTour;
import com.ngoc.tour.repository.CattourRepository;
import com.ngoc.tour.repository.DAO;

@Service
public class CattourService implements DAO<CatTour>{
	
	@Autowired
	private CattourRepository cattourRepository;

	@Override
	public List<CatTour> getList() {
		// TODO Auto-generated method stub
		return cattourRepository.findAll();
	}

	@Override
	public CatTour findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(CatTour vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CatTour vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
