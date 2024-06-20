package com.reservation.security.service;

import com.reservation.security.dto.LoginDto;
import com.reservation.security.dto.TokenDto;
import com.reservation.security.dto.UserDto;
import com.reservation.security.entity.RolEntity;
import com.reservation.security.entity.UserEntity;
import com.reservation.security.jwt.JwtService;
import com.reservation.security.repository.RolRepository;
import com.reservation.security.repository.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @Autowired
    private PasswordEncoder passwordEncoder;

    public TokenDto login(LoginDto request) {
        UserDetails user = userRepository.findByUsername(request.getUser()).orElse(null);
        if (user != null) {
            if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                return new TokenDto(jwtService.getToken(user));
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public TokenDto register(UserDto request) {
        UserEntity user = new UserEntity();
        RolEntity rol = rolRepository.findByName("CUSTOMER").orElse(null);

        user.setId(userRepository.findMaxId() + 1);
        user.setUsername(request.getUsername());
        String hashedPassword = passwordEncoder.encode(request.getPassword());
        user.setPassword(hashedPassword);
        user.setEmail(request.getEmail());
        user.setRol(rol);
        userRepository.save(user);

        return new TokenDto(jwtService.getToken(user));
    }
}
