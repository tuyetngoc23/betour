package com.ngoc.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngoc.tour.entity.Comment;
import com.ngoc.tour.repository.CommentRepository;
import com.ngoc.tour.repository.DAO;

@Service
public class CommentService implements DAO<Comment>{
	
	@Autowired
	private CommentRepository commentRepository;

	@Override
	public List<Comment> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Comment vo) {
		// TODO Auto-generated method stub
		commentRepository.save(vo);
	}

	@Override
	public void update(Comment vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
