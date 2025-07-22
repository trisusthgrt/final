package com.example.newfinal.repository;

import com.example.newfinal.entity.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface Progress extends JpaRepository<Progress, Long> {
    List<Progress> findByUserId(Long userId);
    List<Progress> findBySubModuleId(Long subModuleId);
    boolean existsByUserIdAndSubModuleId(Long userId, Long subModuleId);
} 