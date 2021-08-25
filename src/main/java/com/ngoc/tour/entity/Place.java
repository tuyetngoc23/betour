package com.ngoc.tour.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Place {

	private int id;
	private String name;
	private String address;
	private String image;
	private String description;
	
	private Province province;

}
