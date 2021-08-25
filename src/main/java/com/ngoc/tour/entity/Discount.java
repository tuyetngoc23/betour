package com.ngoc.tour.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Discount {
	private int id;
	private String name;
	private int scope;
	private Date start_day;
	private Date end_day;

}
