package com.ngoc.tour.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ngoc.tour.entity.Tour;


@Repository
public interface TourRepository extends JpaRepository<Tour, Integer> {
	
//	@Query("SELECT * FROM tour")
//	List<Tour> tourList();
	
}
