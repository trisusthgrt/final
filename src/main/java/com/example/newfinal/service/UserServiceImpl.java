package com.example.newfinal.service;

import com.example.newfinal.model.UserRequestDTO;
import com.example.newfinal.model.UserResponseDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserResponseDTO registerUser(UserRequestDTO userRequestDTO) {
        // TODO: Implement registration logic
        return null;
    }
    @Override
    public UserResponseDTO getUserById(Long id) {
        // TODO: Implement get user by id
        return null;
    }
    @Override
    public List<UserResponseDTO> getAllUsers() {
        // TODO: Implement get all users
        return null;
    }
    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO) {
        // TODO: Implement update user
        return null;
    }
    @Override
    public void deleteUser(Long id) {
        // TODO: Implement delete user
    }
    @Override
    public UserResponseDTO getUserByEmail(String email) {
        // TODO: Implement get user by email
        return null;
    }
} 