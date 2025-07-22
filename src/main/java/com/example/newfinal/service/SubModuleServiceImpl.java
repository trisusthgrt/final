package com.example.newfinal.service;

import com.example.newfinal.entity.SubModule;
import com.example.newfinal.entity.Module;
import com.example.newfinal.model.SubModuleDTO;
import com.example.newfinal.repository.SubModuleRepository;
import com.example.newfinal.repository.ModuleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubModuleServiceImpl implements SubModuleService {
    private final SubModuleRepository subModuleRepository;
    private final ModuleRepository moduleRepository;
    public SubModuleServiceImpl(SubModuleRepository subModuleRepository, ModuleRepository moduleRepository) {
        this.subModuleRepository = subModuleRepository;
        this.moduleRepository = moduleRepository;
    }
    @Override
    public SubModuleDTO getSubModuleById(Long id) {
        return mapToDTO(subModuleRepository.findById(id).orElseThrow());
    }
    @Override
    public List<SubModuleDTO> getSubModulesByModuleId(Long moduleId) {
        return subModuleRepository.findByModuleId(moduleId).stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    @Override
    @Transactional
    public SubModuleDTO createSubModule(Long moduleId, SubModuleDTO subModuleDTO) {
        Module module = moduleRepository.findById(moduleId).orElseThrow();
        SubModule subModule = new SubModule();
        subModule.setTitle(subModuleDTO.getTitle());
        subModule.setModule(module);
        subModule = subModuleRepository.save(subModule);
        return mapToDTO(subModule);
    }
    @Override
    @Transactional
    public SubModuleDTO updateSubModule(Long id, SubModuleDTO subModuleDTO) {
        SubModule subModule = subModuleRepository.findById(id).orElseThrow();
        subModule.setTitle(subModuleDTO.getTitle());
        subModule = subModuleRepository.save(subModule);
        return mapToDTO(subModule);
    }
    @Override
    @Transactional
    public void deleteSubModule(Long id) {
        subModuleRepository.deleteById(id);
    }
    private SubModuleDTO mapToDTO(SubModule subModule) {
        SubModuleDTO dto = new SubModuleDTO();
        dto.setId(subModule.getId());
        dto.setTitle(subModule.getTitle());
        // Completion status can be added as needed
        return dto;
    }
} 