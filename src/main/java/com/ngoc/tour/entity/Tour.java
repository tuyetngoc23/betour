package com.ngoc.tour.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="tour")
public class Tour implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private BigDecimal price;
	private int min_amount;
	private int max_amount;
	private Date start_day;
	private Date end_day;
	
	public Tour() {
		super();
	}
	public Tour(int id, String name, BigDecimal price, int min_amount, int max_amount, Date start_day, Date end_day) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.min_amount = min_amount;
		this.max_amount = max_amount;
		this.start_day = start_day;
		this.end_day = end_day;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getMin_amount() {
		return min_amount;
	}
	public void setMin_amount(int min_amount) {
		this.min_amount = min_amount;
	}
	public int getMax_amount() {
		return max_amount;
	}
	public void setMax_amount(int max_amount) {
		this.max_amount = max_amount;
	}
	public Date getStart_day() {
		return start_day;
	}
	public void setStart_day(Date start_day) {
		this.start_day = start_day;
	}
	public Date getEnd_day() {
		return end_day;
	}
	public void setEnd_day(Date end_day) {
		this.end_day = end_day;
	}
	

}
