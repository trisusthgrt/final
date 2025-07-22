package com.example.newfinal.service;

import com.example.newfinal.entity.Role;
import com.example.newfinal.entity.User;
import com.example.newfinal.model.UserRequestDTO;
import com.example.newfinal.model.UserResponseDTO;
import com.example.newfinal.repository.RoleRepository;
import com.example.newfinal.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public UserResponseDTO registerUser(UserRequestDTO userRequestDTO) {
        if (userRepository.findByEmail(userRequestDTO.getEmail()).isPresent()) {
            throw new RuntimeException("Email already in use");
        }
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
        Set<Role> roles = (userRequestDTO.getRoles() == null || userRequestDTO.getRoles().isEmpty())
                ? Set.of(roleRepository.findByName(Role.RoleName.STUDENT).orElseThrow())
                : userRequestDTO.getRoles().stream()
                    .map(r -> roleRepository.findByName(Role.RoleName.valueOf(r)).orElseThrow())
                    .collect(Collectors.toSet());
        user.setRoles(roles);
        user = userRepository.save(user);
        return mapToResponse(user);
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return mapToResponse(user);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO) {
        User user = userRepository.findById(id).orElseThrow();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        if (userRequestDTO.getPassword() != null && !userRequestDTO.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
        }
        if (userRequestDTO.getRoles() != null && !userRequestDTO.getRoles().isEmpty()) {
            Set<Role> roles = userRequestDTO.getRoles().stream()
                .map(r -> roleRepository.findByName(Role.RoleName.valueOf(r)).orElseThrow())
                .collect(Collectors.toSet());
            user.setRoles(roles);
        }
        user = userRepository.save(user);
        return mapToResponse(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserResponseDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow();
        return mapToResponse(user);
    }

    private UserResponseDTO mapToResponse(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRoles(user.getRoles().stream().map(r -> r.getName().name()).collect(Collectors.toSet()));
        return dto;
    }
} 