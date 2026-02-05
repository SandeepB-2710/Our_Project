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
public class UserServiceimpl implements UserService {
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
	public List<UserDto> getAllUser() {
		List<User> users = this.userRepository.findAll();
		List<UserDto> userDtos = users.stream().map((cat) -> this.modelMapper.map(cat, UserDto.class))
				.collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		return this.modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		user.setUserName(userDto.getUsername());
		user.setEmail(userDto.getEmail());
		user.setMobileNumber(userDto.getMobileNumber());
		user.setPassword(userDto.getPassword());
		user.setBio(userDto.getBio());
		user.setAbout(userDto.getAbout());
		user.setProfileImage(userDto.getProfileImage());
		user.setAddress(userDto.getAddress());
		user.setCity(userDto.getCity());
		user.setPincode(userDto.getPincode());
		user.setRegisterdAt(userDto.getRegisterdAt());
		user.setIsActive(userDto.getIsActive());

		User updatedUser = this.userRepository.save(user);

		return this.modelMapper.map(updatedUser, UserDto.class);
	}

	public void deleteUser(Integer userId) {

		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		userRepository.delete(user);
	}
}
