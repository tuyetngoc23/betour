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
public class Evaluate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String content;
	private Date wdate;
	private float rate;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserTour user;
	@ManyToOne
	@JoinColumn(name = "tour_id")
	private Tour tour;

}
