package com.ngoc.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngoc.tour.entity.Blog;
import com.ngoc.tour.repository.BlogRepository;
import com.ngoc.tour.repository.DAO;

@Service
public class BlogService implements DAO<Blog>{
	
	@Autowired
	private BlogRepository blogRepository;

	@Override
	public List<Blog> getList() {
		// TODO Auto-generated method stub
		return blogRepository.findAll();
	}

	@Override
	public Blog findById(int id) {
		// TODO Auto-generated method stub
		return blogRepository.getById(id);
	}

	@Override
	public void insert(Blog vo) {
		// TODO Auto-generated method stub
		blogRepository.save(vo);
	}

	@Override
	public void update(Blog vo) {
		// TODO Auto-generated method stub
		blogRepository.save(vo);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		blogRepository.deleteById(id);
	}

}
