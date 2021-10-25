package com.ngoc.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngoc.tour.entity.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer>{

}
