package com.ngoc.tour.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
	
	private int id;
	private String type;
	private String name;
	private String image;
	private String address;

}
