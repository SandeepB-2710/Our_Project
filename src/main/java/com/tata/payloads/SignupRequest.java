package com.tata.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SignupRequest {
    private String userName;
    private String email;
    private String password;
    private Long mobileNumber;
    private String bio;
    private String about;
    private String address;
    private String city;
    private Integer pincode;
}