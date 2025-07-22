package com.example.newfinal.repository;

import com.example.newfinal.entity.SubModule;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SubModule extends JpaRepository<SubModule, Long> {
    List<SubModule> findByModuleId(Long moduleId);
} 