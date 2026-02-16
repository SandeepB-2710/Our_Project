package com.tata.service;

import org.springframework.stereotype.Service;

import com.tata.payloads.AuthResponse;
import com.tata.payloads.LoginRequest;
import com.tata.payloads.SignupRequest;

@Service
public interface AuthService {
    
    AuthResponse signup(SignupRequest request);
    
    AuthResponse login(LoginRequest request);
}