package com.example.newfinal.service;

import com.example.newfinal.model.SubModuleDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SubModuleServiceImpl implements SubModuleService {
    @Override
    public SubModuleDTO getSubModuleById(Long id) {
        // TODO: Implement get submodule by id
        return null;
    }
    @Override
    public List<SubModuleDTO> getSubModulesByModuleId(Long moduleId) {
        // TODO: Implement get submodules by module id
        return null;
    }
    @Override
    public SubModuleDTO createSubModule(Long moduleId, SubModuleDTO subModuleDTO) {
        // TODO: Implement create submodule
        return null;
    }
    @Override
    public SubModuleDTO updateSubModule(Long id, SubModuleDTO subModuleDTO) {
        // TODO: Implement update submodule
        return null;
    }
    @Override
    public void deleteSubModule(Long id) {
        // TODO: Implement delete submodule
    }
} 