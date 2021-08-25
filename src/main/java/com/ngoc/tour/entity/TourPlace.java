package com.ngoc.tour.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TourPlace {

	private int id;
	
	private Place place;
	private Tour tour;

}
