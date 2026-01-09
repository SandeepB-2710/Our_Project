package com.tata.payloads;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	private Integer userId;
	private String username;
	private String email;
	private Long mobileNumber;
	private String password;
	private String bio;
	private String about;
	private String profileImage;
	private String address;
	private String city;
	private Integer pincode;
	private LocalDate registerdAt;
	private Boolean isActive;
}
