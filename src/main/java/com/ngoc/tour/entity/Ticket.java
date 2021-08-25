package com.ngoc.tour.entity;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

	private int id;
	private String name;
	private String email;
	private String ticket_code;
	private String phone;
	private boolean state;
	private Date giveDate;
	private BigDecimal unitprice;
	
	private Book book;

}
