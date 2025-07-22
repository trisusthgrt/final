package com.example.newfinal.service;

import com.example.newfinal.model.ProgressDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProgressServiceImpl implements ProgressService {
    @Override
    public ProgressDTO markSubModuleComplete(Long userId, Long subModuleId) {
        // TODO: Implement mark submodule complete
        return null;
    }
    @Override
    public List<ProgressDTO> getProgressByUserId(Long userId) {
        // TODO: Implement get progress by user id
        return null;
    }
    @Override
    public List<ProgressDTO> getProgressBySubModuleId(Long subModuleId) {
        // TODO: Implement get progress by submodule id
        return null;
    }
} 