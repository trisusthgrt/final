package com.example.newfinal.service;

import com.example.newfinal.model.ProgressDTO;
import java.util.List;

public interface ProgressService {
    ProgressDTO markSubModuleComplete(Long userId, Long subModuleId);
    List<ProgressDTO> getProgressByUserId(Long userId);
    List<ProgressDTO> getProgressBySubModuleId(Long subModuleId);
} 