package com.ngoc.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ngoc.tour.entity.UserTour;

@Repository
public interface UserRepository extends JpaRepository<UserTour, Integer>{

	@Query("SELECT u FROM UserTour u WHERE username =:username")
	UserTour findByUserName(String username);
}
