package com.tata.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tata.entity.User;
import com.tata.exception.ResourceNotFoundException;
import com.tata.repo.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println(username);
		
		User user=	this.userRepository.findByEmail(username)
		.orElseThrow(()-> 
		 new UsernameNotFoundException("User not found with email: " + username)
		);
		
		return user;
	}

}

