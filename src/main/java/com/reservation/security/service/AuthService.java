package com.reservation.security.service;

import com.reservation.security.dto.LoginDto;
import com.reservation.security.dto.TokenDto;
import com.reservation.security.dto.UserDto;
import com.reservation.security.entity.RolEntity;
import com.reservation.security.entity.UserEntity;
import com.reservation.security.jwt.JwtService;
import com.reservation.security.repository.RolRepository;
import com.reservation.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RolRepository rolRepository;
    @Autowired
    JwtService jwtService;
    
    public TokenDto login(LoginDto request) {
        return null;
    }

    public TokenDto register(UserDto request) {
        UserEntity user = new UserEntity();
        RolEntity rol = rolRepository.findByName("CUSTOMER").orElse(null);
        
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setRol(rol);
        userRepository.save(user);
        
        return new TokenDto(jwtService.getToken(user));
    }
}
