package com.example.newfinal.repository;

import com.example.newfinal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface User extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
} 