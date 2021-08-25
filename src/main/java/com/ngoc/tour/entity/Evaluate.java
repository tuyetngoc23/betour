package com.ngoc.tour.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evaluate {
	private int id;
	private String content;
	private Date wdate;
	
	
	private UserTour user;
	private Tour tour;

}
