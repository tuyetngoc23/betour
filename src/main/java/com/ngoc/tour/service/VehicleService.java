package com.ngoc.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngoc.tour.entity.Vehicle;
import com.ngoc.tour.repository.DAO;
import com.ngoc.tour.repository.VehicleRepository;

@Service
public class VehicleService implements DAO<Vehicle>{
	
	@Autowired
	private VehicleRepository vehicleRepository;

	@Override
	public List<Vehicle> getList() {
		// TODO Auto-generated method stub
		return vehicleRepository.findAll();
	}

	@Override
	public Vehicle findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Vehicle vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Vehicle vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
