package com.ngoc.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngoc.tour.entity.Hotel;
import com.ngoc.tour.repository.DAO;
import com.ngoc.tour.repository.HotelRepository;

@Service
public class HotelService implements DAO<Hotel>{
	
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public List<Hotel> getList() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}

	@Override
	public Hotel findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Hotel vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Hotel vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
