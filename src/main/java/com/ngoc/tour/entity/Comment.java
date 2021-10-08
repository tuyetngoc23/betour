package com.ngoc.tour.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String content;
	private Date date;
	
	
	@ManyToOne
	@JoinColumn(name = "usertour_id")
	private UserTour usertour;
	
	@ManyToOne
	@JoinColumn(name = "blog_id")
	private Blog blog;

}
