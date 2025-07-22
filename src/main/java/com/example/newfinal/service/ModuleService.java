package com.example.newfinal.service;

import com.example.newfinal.model.ModuleDTO;
import java.util.List;

public interface ModuleService {
    ModuleDTO getModuleById(Long id);
    List<ModuleDTO> getModulesByCourseId(Long courseId);
    ModuleDTO createModule(Long courseId, ModuleDTO moduleDTO);
    ModuleDTO updateModule(Long id, ModuleDTO moduleDTO);
    void deleteModule(Long id);
} 