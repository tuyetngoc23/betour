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
public class Blog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String wname;
	private String content;
	private Date wdate;
	private int like_amount;
	private boolean state;
	private String image;
	
	@ManyToOne
	@JoinColumn(name = "user_tour")
	private UserTour usertour;

}
