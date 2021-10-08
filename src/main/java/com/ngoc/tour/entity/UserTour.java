package com.ngoc.tour.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;


@Data
@Entity
public class UserTour {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String passwd;
	private String cusname;
	private String phone;
	private Date birthday;
	private String address;
	private String email;
	private String avatar;
	private int state;
	

	@ManyToOne
	@JoinColumn(name = "user_role")
	private UserRole user_role;

}
