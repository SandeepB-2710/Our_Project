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

    // REQUIRED FOR SIGNUP
    
    @NotEmpty
    @Size(min = 4, max = 15, message = "UserName must be between 4 and 15 characters")
    private String userName;

    @Email(message = "Invalid email address")
    private String email;

    @NotNull(message = "Mobile number is required")
    private Long mobileNumber;

    @NotEmpty
    @Size(min = 5, max = 16, message = "Password must be between 5 and 16 characters")
    private String password;

    // OPTIONAL PROFILE FIELDS (Can be updated later)
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