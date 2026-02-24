package com.tata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tata.exception.ApiException;
import com.tata.payloads.JwtAuthRequest;
import com.tata.payloads.JwtAuthResponse;
import com.tata.payloads.UserDto;
import com.tata.security.JwtTokenHelper;
import com.tata.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class HomeController {

    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception {

        this.authenticate(request.getUsername(), request.getPassword());

        UserDetails userDetails =
                this.userDetailsService.loadUserByUsername(request.getUsername());

        String token = this.jwtTokenHelper.generateToken(userDetails);

        // Fetch the full UserDto so the frontend gets userName, roles, etc.
        UserDto userDto = this.userService.getUserByEmail(request.getUsername());

        JwtAuthResponse response = new JwtAuthResponse();
        response.setToken(token);
        response.setUser(userDto);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void authenticate(String username, String password) throws Exception {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);

        try {
            this.authenticationManager.authenticate(authenticationToken);
        } catch (BadCredentialsException e) {
            throw new ApiException("Invalid Username or password...");
        }
    }

    // Register new user
    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@Valid @RequestBody UserDto userDto) {

        UserDto newUser = this.userService.registerUser(userDto);

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

}















//package com.tata.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.tata.exception.ApiException;
//import com.tata.payloads.JwtAuthRequest;
//import com.tata.payloads.JwtAuthResponse;
//import com.tata.payloads.UserDto;
//import com.tata.security.JwtTokenHelper;
//import com.tata.service.UserService;
//
//import jakarta.validation.Valid;
//
//@RestController
//@RequestMapping("/api/v1/auth")
//public class HomeController {
//
//	@Autowired
//	private JwtTokenHelper jwtTokenHelper;
//
//	@Autowired
//	private UserDetailsService userDetailsService;
//
//	@Autowired
//	private UserService userService;
//
//	@Autowired
//	private AuthenticationManager authenticationManager;
//
//	@PostMapping("/login")
//    public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception {
//
//        this.authenticate(request.getUsername(), request.getPassword());
//
//        UserDetails userDetails =
//                this.userDetailsService.loadUserByUsername(request.getUsername());
//
//        String token = this.jwtTokenHelper.generateToken(userDetails);
//
//        JwtAuthResponse response = new JwtAuthResponse();
//        response.setToken(token);
//
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    private void authenticate(String username, String password) throws Exception {
//
//        UsernamePasswordAuthenticationToken authenticationToken =
//                new UsernamePasswordAuthenticationToken(username, password);
//
//        try {
//            this.authenticationManager.authenticate(authenticationToken);
//        } catch (BadCredentialsException e) {
//            throw new ApiException("Invalid Username or password...");
//        }
//    }
//
//	// Register new user
//    @PostMapping("/register")
//    public ResponseEntity<UserDto> registerUser(@Valid @RequestBody UserDto userDto) {
//
//        UserDto newUser = this.userService.registerUser(userDto);
//
//        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
//    }
//
//}
