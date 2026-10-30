package com.example.security.service;

import com.example.security.dto.RegisterRequestDTO;
import com.example.security.model.Users;
import com.example.security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private UserRepo repo;

    @Autowired
    AuthenticationManager authmanager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    public Users register(RegisterRequestDTO request) {
        Users user = new Users();

        user.setUsername(request.getUsername());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setRole("USER");

        return repo.save(user);
    }


    public String verify(Users user) {
Authentication authenticate = authmanager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));

if(authenticate.isAuthenticated())
    return jwtService.generateToken(user.getUsername());

return "failed";

    }
}
