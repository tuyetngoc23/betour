package com.ngoc.tour.entity;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
	
	private int id;
	private int quantity;
	private BigDecimal totalprice;
	private Date pdate;
	
	private Book book;
	private PaymentType payment_type;

}
