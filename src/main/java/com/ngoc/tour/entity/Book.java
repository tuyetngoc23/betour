package com.ngoc.tour.entity;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	private int id;
	private BigDecimal total_money;
	private int child_amount;
	private int aldult_amount;
	private int child_nho_amount;
	private Date date;
	
	private UserTour usertour;
	private Tour tour;

}
