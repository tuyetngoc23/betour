package com.ngoc.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngoc.tour.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
