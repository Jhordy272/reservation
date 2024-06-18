package com.reservation.security;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class Auth {
    @GetMapping("/login")
    public ResponseEntity<?> login(){
        return new ResponseEntity<>("login ",HttpStatus.OK);
    }
}
