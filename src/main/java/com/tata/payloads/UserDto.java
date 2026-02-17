package com.tata.payloads;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private Integer userId;
	
	@NotEmpty
	@Size(min=4, max=15, message="UserName must be more than 3 charecter and less than 16")
	private String userName;
	
	@Email(message="Invalid emial address..")
	private String email;
	
	@NotNull
	private Long mobileNumber;
	
	@NotEmpty
	@Size(min=5, max=10, message="Password must be less than 10 and more than 5 charecter")
	private String password;
	
	@NotEmpty
	private String bio;
	
	@NotEmpty
	private String about;
	
	@NotEmpty
	private String profileImage;
	
	@NotEmpty
	private String address;
	
	@NotEmpty
	private String city;
	
	@NotNull
	private Integer pincode;
	
	private LocalDate registerdAt;
	
	private Boolean isActive;
	
	private Set<RoleDto> roles = new HashSet<>();
}
