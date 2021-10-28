package com.ngoc.tour.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ngoc.tour.entity.Place;
import com.ngoc.tour.entity.Province;
import com.ngoc.tour.entity.Tour;
import com.ngoc.tour.entity.TourPlace;

@Repository
public interface TourPlaceRepository extends JpaRepository<TourPlace, Integer> {

	@Query("select p from Province p")
	List<Province> getListProvince();
	
	@Query("SELECT DISTINCT t FROM TourPlace tp, Place p, Tour t WHERE (t.cattour.id = :cat_id or p.province.id= :prov_id"
			+ " or t.start_day = :date or t.department.id = :departure or t.hotel.id = :ks"
			+" or t.vehicle.id = :vehicle or t.price between :timgiatu and :timgiaden)"
			+" AND tp.place.id = p.id AND t.id = tp.tour.id")
	List<Tour> findDistinctListTour(int cat_id, int prov_id, Date date, int departure, int ks, int vehicle,
									BigDecimal timgiatu, BigDecimal timgiaden);
	
	@Query("SELECT p FROM TourPlace tp, Place p WHERE tp.tour.id =:tour_id AND tp.place.id = p.id")
	List<Place> listByTourId(@Param(value = "tour_id") int tour_id);
	
	
}
