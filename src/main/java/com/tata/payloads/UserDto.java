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
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String userName;

    @Email(message = "Invalid email address")
    private String email;

    private Long mobileNumber;

    @Size(min = 5, max = 16, message = "Password must be between 5 and 16 characters")
    private String password;

    // Optional profile fields — no @NotEmpty so signup doesn't require them
    private String bio;
    private String about;
    private String profileImage;
    private String address;
    private String city;
    private Integer pincode;

    private LocalDate registerdAt;
    private Boolean isActive;

    private Set<RoleDto> roles = new HashSet<>();
}
















//package com.tata.payloads;
//
//import java.time.LocalDate;
//import java.util.HashSet;
//import java.util.Set;
//
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@NoArgsConstructor
//@Getter
//@Setter
//public class UserDto {
//	
//	private Integer userId;
//	
//	@NotEmpty
//	@Size(min=4, max=15, message="UserName must be more than 3 charecter and less than 16")
//	private String userName;
//	
//	@Email(message="Invalid emial address..")
//	private String email;
//	
//	@NotNull
//	private Long mobileNumber;
//	
//	@NotEmpty
//	@Size(min=5, max=16, message="Password must be less than 16   and more than 5 charecter")
//	private String password;
//	
//	@NotEmpty
//	private String bio;
//	
//	@NotEmpty
//	private String about;
//	
//	@NotEmpty
//	private String profileImage;
//	
//	@NotEmpty
//	private String address;
//	
//	@NotEmpty
//	private String city;
//	
//	@NotNull
//	private Integer pincode;
//	
//	private LocalDate registerdAt;
//	
//	private Boolean isActive;
//	
//	private Set<RoleDto> roles = new HashSet<>();
//}
