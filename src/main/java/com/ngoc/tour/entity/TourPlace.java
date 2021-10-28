package com.ngoc.tour.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;

import lombok.Data;

@Data
@Entity
public class TourPlace {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name ="place_id")
	private Place place;
	
	
	@ManyToOne
	@JoinColumn(name ="tour_id")
	private Tour tour;

}
