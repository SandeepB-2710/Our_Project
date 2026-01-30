package com.tata.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tata.entity.User;
import com.tata.exception.ResourceNotFoundException;
import com.tata.payloads.UserDto;
import com.tata.repo.UserRepository;
import com.tata.service.UserService;

@Service
public class UserServiceimpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto saveUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		User saveUser = this.userRepository.save(user);
		return this.modelMapper.map(saveUser, UserDto.class);
	}
	
	@Override
	public List<UserDto> getAllUser(){
		List<User> users = this.userRepository.findAll();
		List<UserDto> userDtos = users.stream().map((cat)->this.modelMapper.map(cat, UserDto.class)).collect(Collectors.toList());
		return userDtos;
	}
	
	
	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		return this.modelMapper.map(user, UserDto.class);
	}
	
	
	@Override
	public UserDto updateUser(UserDto userDto,Integer userID) {
		return null;
	}
	
	
	public String deleteUser(Integer userId) {
		User user = this.userRepository.findById(userId).orElse(null);
		userRepository.delete(user);
		return "User With ID: " +userId +" Deleted successfully";
	}
}
