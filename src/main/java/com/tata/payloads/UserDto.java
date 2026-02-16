package com.tata.payloads;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
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
	@Size(min=4, max=15, message="UserName must be more than 4 charecter and less than 15")
	private String username;
	
	@Email(message="Invalid emial address..")
	private String email;
	
	private Long mobileNumber;

	private String bio;
	
	@NotEmpty
	private String about;
	
	@NotEmpty
	private String profileImage;
	
	@NotEmpty
	private String address;
	
	@NotEmpty
	private String city;
	
	@NotEmpty
	private Integer pincode;
	
	@NotEmpty
	private LocalDate registerdAt;
	
	private Boolean isActive;
	
	private Set<RoleDto> roles = new HashSet<>();
}
