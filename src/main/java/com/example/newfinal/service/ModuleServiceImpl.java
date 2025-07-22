package com.example.newfinal.service;

import com.example.newfinal.entity.Module;
import com.example.newfinal.entity.Course;
import com.example.newfinal.model.ModuleDTO;
import com.example.newfinal.repository.ModuleRepository;
import com.example.newfinal.repository.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModuleServiceImpl implements ModuleService {
    private final ModuleRepository moduleRepository;
    private final CourseRepository courseRepository;
    public ModuleServiceImpl(ModuleRepository moduleRepository, CourseRepository courseRepository) {
        this.moduleRepository = moduleRepository;
        this.courseRepository = courseRepository;
    }
    @Override
    public ModuleDTO getModuleById(Long id) {
        return mapToDTO(moduleRepository.findById(id).orElseThrow());
    }
    @Override
    public List<ModuleDTO> getModulesByCourseId(Long courseId) {
        return moduleRepository.findByCourseId(courseId).stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    @Override
    @Transactional
    public ModuleDTO createModule(Long courseId, ModuleDTO moduleDTO) {
        Course course = courseRepository.findById(courseId).orElseThrow();
        Module module = new Module();
        module.setTitle(moduleDTO.getTitle());
        module.setCourse(course);
        module = moduleRepository.save(module);
        return mapToDTO(module);
    }
    @Override
    @Transactional
    public ModuleDTO updateModule(Long id, ModuleDTO moduleDTO) {
        Module module = moduleRepository.findById(id).orElseThrow();
        module.setTitle(moduleDTO.getTitle());
        module = moduleRepository.save(module);
        return mapToDTO(module);
    }
    @Override
    @Transactional
    public void deleteModule(Long id) {
        moduleRepository.deleteById(id);
    }
    private ModuleDTO mapToDTO(Module module) {
        ModuleDTO dto = new ModuleDTO();
        dto.setId(module.getId());
        dto.setTitle(module.getTitle());
        // Submodules mapping can be added as needed
        return dto;
    }
} 