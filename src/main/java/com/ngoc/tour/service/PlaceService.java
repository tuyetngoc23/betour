package com.ngoc.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngoc.tour.entity.Place;
import com.ngoc.tour.repository.DAO;
import com.ngoc.tour.repository.PlaceRepository;

@Service
public class PlaceService implements DAO<Place>{
	
	@Autowired
	private PlaceRepository placeRepository;

	@Override
	public List<Place> getList() {
		// TODO Auto-generated method stub
		return placeRepository.findAll();
	}

	@Override
	public Place findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Place vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Place vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
