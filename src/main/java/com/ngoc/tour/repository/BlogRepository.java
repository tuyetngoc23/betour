package com.ngoc.tour.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ngoc.tour.entity.Blog;
import com.ngoc.tour.entity.Comment;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer>{

	@Query("select m from Comment m where blog_id = ?1")
	List<Comment> getCommentList(int id);
}
