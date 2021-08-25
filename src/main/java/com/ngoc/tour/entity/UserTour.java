package com.ngoc.tour.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTour {

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
	

	private UserRole user_role;

}
