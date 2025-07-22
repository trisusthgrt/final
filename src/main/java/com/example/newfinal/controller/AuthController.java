package com.example.newfinal.controller;

import com.example.newfinal.model.UserRequestDTO;
import com.example.newfinal.model.UserResponseDTO;
import com.example.newfinal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public UserResponseDTO login(@RequestBody UserRequestDTO userRequestDTO) {
        // TODO: Implement authentication and JWT token issuance
        return userService.getUserByEmail(userRequestDTO.getEmail());
    }
} 