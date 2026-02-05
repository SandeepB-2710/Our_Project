package com.tata.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tata.payloads.UserDto;

@Service
public interface UserService {

	UserDto saveUser(UserDto userDto);

	List<UserDto> getAllUser();

	UserDto getUserById(Integer userId);

	UserDto updateUser(UserDto userDto, Integer userID);
	
	public void deleteUser(Integer userId);
}
