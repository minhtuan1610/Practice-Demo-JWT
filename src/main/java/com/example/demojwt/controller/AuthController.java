package com.example.demojwt.controller;

import com.example.demojwt.model.AppUser;
import com.example.demojwt.model.DTO.JwtResponse;
import com.example.demojwt.service.appuser.IAppUserService;
import com.example.demojwt.service.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private IAppUserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AppUser user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        AppUser currentUser = userService.findByName(user.getName());
        return ResponseEntity.ok(new JwtResponse(currentUser.getId(), jwt, userDetails.getUsername(),
                userDetails.getUsername(), userDetails.getAuthorities()));
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello world", HttpStatus.OK);
    }

    @GetMapping("/admin")
    public ResponseEntity<String> admin() {
        return new ResponseEntity<>("Admin", HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<String> user() {
        return new ResponseEntity<>("User", HttpStatus.OK);
    }
}
