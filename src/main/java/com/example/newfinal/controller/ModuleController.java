package com.example.newfinal.controller;

import com.example.newfinal.model.ModuleDTO;
import com.example.newfinal.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/modules")
public class ModuleController {
    @Autowired
    private ModuleService moduleService;

    @GetMapping("/{id}")
    public ModuleDTO getModuleById(@PathVariable Long id) {
        return moduleService.getModuleById(id);
    }

    @GetMapping("/by-course/{courseId}")
    public List<ModuleDTO> getModulesByCourseId(@PathVariable Long courseId) {
        return moduleService.getModulesByCourseId(courseId);
    }

    @PostMapping("/by-course/{courseId}")
    public ModuleDTO createModule(@PathVariable Long courseId, @RequestBody ModuleDTO moduleDTO) {
        return moduleService.createModule(courseId, moduleDTO);
    }

    @PutMapping("/{id}")
    public ModuleDTO updateModule(@PathVariable Long id, @RequestBody ModuleDTO moduleDTO) {
        return moduleService.updateModule(id, moduleDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteModule(@PathVariable Long id) {
        moduleService.deleteModule(id);
    }
} 