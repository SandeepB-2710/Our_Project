package com.tata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tata.payloads.UserDto;
import com.tata.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	
	private UserService userService;
	
	
	@GetMapping("/apiCheck")
	public String apicheck() {
		
		return "User is working";
	}
	@GetMapping("/allUsers")
	public ResponseEntity<List<UserDto>> getAllUser(){
		return new ResponseEntity<List<UserDto>>(this.userService.getAllUser(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("id") Integer userId){
		return new ResponseEntity<UserDto>(this.userService.getUserById(userId), HttpStatus.OK);
	}
	
	@PostMapping("/insertUser")
	public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto){
		UserDto insertUserDto = this.userService.saveUser(userDto);
		return new ResponseEntity<UserDto>(insertUserDto,HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable("id") Integer userId, @RequestBody UserDto userDto){
		UserDto updateUser = this.userService.updateUser(userDto, userId);
		
		return new ResponseEntity<UserDto>(updateUser, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Integer userId){
		String msg =this.userService.deleteUser(userId);
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
}
