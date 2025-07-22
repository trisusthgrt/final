package com.example.newfinal.service;

import com.example.newfinal.model.UserRequestDTO;
import com.example.newfinal.model.UserResponseDTO;
import java.util.List;

public interface UserService {
    UserResponseDTO registerUser(UserRequestDTO userRequestDTO);
    UserResponseDTO getUserById(Long id);
    List<UserResponseDTO> getAllUsers();
    UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO);
    void deleteUser(Long id);
    UserResponseDTO getUserByEmail(String email);
} 