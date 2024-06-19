package com.reservation.security.controller;

import com.reservation.security.dto.LoginDto;
import com.reservation.security.dto.TokenDto;
import com.reservation.security.dto.UserDto;
import com.reservation.security.entity.UserEntity;
import com.reservation.security.repository.UserRepository;
import com.reservation.security.service.AuthService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class Auth {
    
    @Autowired
    AuthService authService;
    
    @Autowired
    UserRepository userRepository;
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto request){
        return new ResponseEntity<>(authService.login(request),HttpStatus.OK);
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto request){
        return new ResponseEntity<>(authService.register(request),HttpStatus.OK);
    }
    
}
