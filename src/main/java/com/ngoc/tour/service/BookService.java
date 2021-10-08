package com.ngoc.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngoc.tour.entity.Book;
import com.ngoc.tour.repository.BookRepository;
import com.ngoc.tour.repository.DAO;

@Service
public class BookService implements DAO<Book>{
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getList() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	@Override
	public Book findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Book vo) {
		// TODO Auto-generated method stub
		bookRepository.save(vo);
	}

	@Override
	public void update(Book vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
