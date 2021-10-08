package com.ngoc.tour.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ngoc.tour.entity.Tour;
import com.ngoc.tour.entity.TourPlace;


@Repository
public interface TourRepository extends JpaRepository<Tour, Integer> {
	
	@Query("SELECT tp FROM TourPlace tp WHERE tour_id = ?1")
	List<TourPlace> getListByTourID(int id);
	
	
}
