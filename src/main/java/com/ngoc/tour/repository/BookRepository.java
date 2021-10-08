package com.ngoc.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngoc.tour.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
