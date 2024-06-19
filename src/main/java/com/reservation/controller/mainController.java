package com.reservation.controller;

import com.reservation.security.entity.UserEntity;
import com.reservation.security.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alert")
@CrossOrigin(origins = "*")
public class mainController {
    
    @Autowired
    UserRepository userRepository;
    
    @GetMapping("")
    public ResponseEntity<?> getUsers(){
        List<UserEntity> listUsers = userRepository.findAll();
        return new ResponseEntity<>(listUsers,HttpStatus.OK);
    }
}
