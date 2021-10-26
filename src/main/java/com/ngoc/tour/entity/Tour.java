package com.ngoc.tour.entity;


import java.math.BigDecimal;
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

public class Tour {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private BigDecimal price;
	private int min_amount;
	private int max_amount;
	private Date start_day;
	private Date end_day;
	private String content;
	private String note;
	private String image;
	private boolean state;
	
	@ManyToOne
	@JoinColumn(name = "location_go")
	private Department department;
	
	@ManyToOne
	@JoinColumn(name = "cattour_id")
	private CatTour cattour;
	
	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;
	
	@ManyToOne
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;
	

}
