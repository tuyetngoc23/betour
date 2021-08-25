package com.ngoc.tour.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
	
	private int id;
	private String title;
	private String wname;
	private String content;
	private Date wdate;
	private int like_amount;
	private boolean state;
	private String image;

}
