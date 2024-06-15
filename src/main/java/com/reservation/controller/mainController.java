package com.reservation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alert")
@CrossOrigin(origins = "*")
public class mainController {
    
    @GetMapping("")
    public ResponseEntity<?> getClima(){
        return new ResponseEntity<>("ok",HttpStatus.OK);
    }
}
