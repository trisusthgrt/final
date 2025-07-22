package com.example.newfinal.service;

import com.example.newfinal.model.ModuleDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {
    @Override
    public ModuleDTO getModuleById(Long id) {
        // TODO: Implement get module by id
        return null;
    }
    @Override
    public List<ModuleDTO> getModulesByCourseId(Long courseId) {
        // TODO: Implement get modules by course id
        return null;
    }
    @Override
    public ModuleDTO createModule(Long courseId, ModuleDTO moduleDTO) {
        // TODO: Implement create module
        return null;
    }
    @Override
    public ModuleDTO updateModule(Long id, ModuleDTO moduleDTO) {
        // TODO: Implement update module
        return null;
    }
    @Override
    public void deleteModule(Long id) {
        // TODO: Implement delete module
    }
} 