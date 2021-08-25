package com.ngoc.tour.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourDiscount {

	private int id;
	
	private Tour tour;
	private Discount discount;


}
