package com.ngoc.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngoc.tour.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
