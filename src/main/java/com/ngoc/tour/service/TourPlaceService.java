package com.ngoc.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngoc.tour.entity.Place;
import com.ngoc.tour.entity.TourPlace;
import com.ngoc.tour.repository.DAO;
import com.ngoc.tour.repository.TourPlaceRepository;
import com.ngoc.tour.repository.TourRepository;

@Service
public class TourPlaceService implements DAO<TourPlace> {
	
	
	@Autowired
	private TourPlaceRepository tourPlaceRepository;
	
	public List<Place> getListByTourID(int id) {
		// TODO Auto-generated method stub
		return tourPlaceRepository.listByTourId(id);
	}

	@Override
	public List<TourPlace> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TourPlace findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(TourPlace vo) {
		// TODO Auto-generated method stub
		tourPlaceRepository.save(vo);
	}

	@Override
	public void update(TourPlace vo) {
		// TODO Auto-generated method stub
		tourPlaceRepository.save(vo);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		tourPlaceRepository.deleteByTourId(id);
	}

}
