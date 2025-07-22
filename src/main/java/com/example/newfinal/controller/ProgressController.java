package com.example.newfinal.controller;

import com.example.newfinal.model.ProgressDTO;
import com.example.newfinal.service.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/progress")
public class ProgressController {
    @Autowired
    private ProgressService progressService;

    @PostMapping("/complete")
    public ProgressDTO markSubModuleComplete(@RequestParam Long userId, @RequestParam Long subModuleId) {
        return progressService.markSubModuleComplete(userId, subModuleId);
    }

    @GetMapping("/by-user/{userId}")
    public List<ProgressDTO> getProgressByUserId(@PathVariable Long userId) {
        return progressService.getProgressByUserId(userId);
    }

    @GetMapping("/by-submodule/{subModuleId}")
    public List<ProgressDTO> getProgressBySubModuleId(@PathVariable Long subModuleId) {
        return progressService.getProgressBySubModuleId(subModuleId);
    }
} 