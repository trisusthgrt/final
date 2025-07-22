package com.example.newfinal.controller;

import com.example.newfinal.model.SubModuleDTO;
import com.example.newfinal.service.SubModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/submodules")
public class SubModuleController {
    @Autowired
    private SubModuleService subModuleService;

    @GetMapping("/{id}")
    public SubModuleDTO getSubModuleById(@PathVariable Long id) {
        return subModuleService.getSubModuleById(id);
    }

    @GetMapping("/by-module/{moduleId}")
    public List<SubModuleDTO> getSubModulesByModuleId(@PathVariable Long moduleId) {
        return subModuleService.getSubModulesByModuleId(moduleId);
    }

    @PostMapping("/by-module/{moduleId}")
    public SubModuleDTO createSubModule(@PathVariable Long moduleId, @RequestBody SubModuleDTO subModuleDTO) {
        return subModuleService.createSubModule(moduleId, subModuleDTO);
    }

    @PutMapping("/{id}")
    public SubModuleDTO updateSubModule(@PathVariable Long id, @RequestBody SubModuleDTO subModuleDTO) {
        return subModuleService.updateSubModule(id, subModuleDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteSubModule(@PathVariable Long id) {
        subModuleService.deleteSubModule(id);
    }
} 