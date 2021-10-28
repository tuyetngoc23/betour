package com.ngoc.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngoc.tour.entity.Department;
import com.ngoc.tour.repository.DAO;
import com.ngoc.tour.repository.DepartmentRepository;

@Service
public class DepartmentService implements DAO<Department>{
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public List<Department> getList() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

	@Override
	public Department findById(int id) {
		// TODO Auto-generated method stub
		return departmentRepository.getById(id);
	}

	@Override
	public void insert(Department vo) {
		// TODO Auto-generated method stub
		departmentRepository.save(vo);
	}

	@Override
	public void update(Department vo) {
		// TODO Auto-generated method stub
		departmentRepository.save(vo);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		departmentRepository.deleteById(id);
	}

}
