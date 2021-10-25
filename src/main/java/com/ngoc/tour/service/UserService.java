package com.ngoc.tour.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ngoc.tour.entity.UserTour;
import com.ngoc.tour.repository.DAO;
import com.ngoc.tour.repository.UserRepository;

@Service("userService")
public class UserService implements DAO<UserTour>, UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserTour> getList() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public UserTour findById(int id) {
		// TODO Auto-generated method stub
		return userRepository.getById(id);
	}

	@Override
	public void insert(UserTour vo) {
		// TODO Auto-generated method stub
		userRepository.save(vo);
	}

	@Override
	public void update(UserTour vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		userRepository.deleteUser(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserTour user = userRepository.findByUserName(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPasswd(),
								getAuthority(user));
	}
	
	private List<SimpleGrantedAuthority> getAuthority(UserTour user) {
		if(user.getUser_role().getId() == 2) {
			return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
		}else {
			return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		
	}
	

}
