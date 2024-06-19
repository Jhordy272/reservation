package com.reservation.security;

import com.reservation.security.entity.UserEntity;
import com.reservation.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class Auth {
    
    @Autowired
    UserRepository userRepository;
    
    @GetMapping("/login")
    public ResponseEntity<?> login(){
        List<UserEntity> listUsers = userRepository.findAll();
        return new ResponseEntity<>(listUsers,HttpStatus.OK);
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> register(){
        List<UserEntity> listUsers = userRepository.findAll();
        return new ResponseEntity<>(listUsers,HttpStatus.OK);
    }
    
}
