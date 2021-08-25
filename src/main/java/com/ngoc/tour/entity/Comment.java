package com.ngoc.tour.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
	
	private int id;
	private String content;
	private Date date;
	
	
	
	private UserTour usertour;
	private Blog blog;

}
