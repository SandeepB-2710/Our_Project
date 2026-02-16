package com.tata.service.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tata.entity.User;
import com.tata.payloads.AuthResponse;
import com.tata.payloads.LoginRequest;
import com.tata.payloads.SignupRequest;
import com.tata.payloads.UserDto;
import com.tata.repo.UserRepository;
import com.tata.service.AuthService;
import com.tata.util.JwtUtil;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AuthResponse signup(SignupRequest request) {
        // Check if user already exists
        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("User with this email already exists");
        }

        // Create new user
        User user = User.builder()
                .userName(request.getUserName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword())) // ✅ Hash password
                .mobileNumber(request.getMobileNumber())
                .bio(request.getBio())
                .about(request.getAbout())
                .address(request.getAddress())
                .city(request.getCity())
                .pincode(request.getPincode())
                .registerdAt(LocalDate.now())
                .isActive(true)
                .build();

        User savedUser = userRepository.save(user);

        // Generate JWT token
        String token = jwtUtil.generateToken(savedUser.getEmail(), savedUser.getUserId());

        // Convert to DTO (no password!)
        UserDto userDto = this.modelMapper.map(savedUser, UserDto.class);

        return new AuthResponse(token, userDto);
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        // Find user by email
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        // Check if user is active
        if (!user.getIsActive()) {
            throw new RuntimeException("Account is deactivated");
        }

        // Verify password
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        // Generate JWT token
        String token = jwtUtil.generateToken(user.getEmail(), user.getUserId());

        // Convert to DTO (no password!)
        UserDto userDto = this.modelMapper.map(user, UserDto.class);

        return new AuthResponse(token, userDto);
    }
}