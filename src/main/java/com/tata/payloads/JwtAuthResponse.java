package com.tata.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JwtAuthResponse {

    private String token;

    // Full user object returned on login so the frontend
    // doesn't need a second round-trip to fetch the user.
    private UserDto user;

}








//package com.tata.payloads;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@NoArgsConstructor
//public class JwtAuthResponse {
//
//    private String token;
//
//}
