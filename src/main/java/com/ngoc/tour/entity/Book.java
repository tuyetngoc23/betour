package com.ngoc.tour.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private BigDecimal total_money;
	private int child_amount;
	private int aldult_amount;
	private int child_nho_amount;
	private Date date;
	private String cus_name;
	private String email;
	private String phone;
	private String payment_type;
	
	@ManyToOne
	@JoinColumn(name = "usertour_id")
	private UserTour usertour;
	@ManyToOne
	@JoinColumn(name = "tour_id")
	private Tour tour;

}
