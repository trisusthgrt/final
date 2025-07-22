package com.example.newfinal.repository;

import com.example.newfinal.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface Module extends JpaRepository<Module, Long> {
    List<Module> findByCourseId(Long courseId);
} 