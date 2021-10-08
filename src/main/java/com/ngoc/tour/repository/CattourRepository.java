package com.ngoc.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngoc.tour.entity.CatTour;

@Repository
public interface CattourRepository extends JpaRepository<CatTour, Integer>{

}
