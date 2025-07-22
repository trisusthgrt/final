package com.example.newfinal.service;

import com.example.newfinal.model.SubModuleDTO;
import java.util.List;

public interface SubModuleService {
    SubModuleDTO getSubModuleById(Long id);
    List<SubModuleDTO> getSubModulesByModuleId(Long moduleId);
    SubModuleDTO createSubModule(Long moduleId, SubModuleDTO subModuleDTO);
    SubModuleDTO updateSubModule(Long id, SubModuleDTO subModuleDTO);
    void deleteSubModule(Long id);
} 