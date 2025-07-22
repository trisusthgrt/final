package com.example.newfinal.service;

import com.example.newfinal.entity.Progress;
import com.example.newfinal.entity.User;
import com.example.newfinal.entity.SubModule;
import com.example.newfinal.model.ProgressDTO;
import com.example.newfinal.repository.ProgressRepository;
import com.example.newfinal.repository.UserRepository;
import com.example.newfinal.repository.SubModuleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgressServiceImpl implements ProgressService {
    private final ProgressRepository progressRepository;
    private final UserRepository userRepository;
    private final SubModuleRepository subModuleRepository;
    public ProgressServiceImpl(ProgressRepository progressRepository, UserRepository userRepository, SubModuleRepository subModuleRepository) {
        this.progressRepository = progressRepository;
        this.userRepository = userRepository;
        this.subModuleRepository = subModuleRepository;
    }
    @Override
    @Transactional
    public ProgressDTO markSubModuleComplete(Long userId, Long subModuleId) {
        if (progressRepository.existsByUserIdAndSubModuleId(userId, subModuleId)) {
            throw new RuntimeException("Already marked as complete");
        }
        User user = userRepository.findById(userId).orElseThrow();
        SubModule subModule = subModuleRepository.findById(subModuleId).orElseThrow();
        Progress progress = new Progress();
        progress.setUser(user);
        progress.setSubModule(subModule);
        progress.setCompletedAt(java.time.LocalDateTime.now());
        progress = progressRepository.save(progress);
        return mapToDTO(progress);
    }
    @Override
    public List<ProgressDTO> getProgressByUserId(Long userId) {
        return progressRepository.findByUserId(userId).stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    @Override
    public List<ProgressDTO> getProgressBySubModuleId(Long subModuleId) {
        return progressRepository.findBySubModuleId(subModuleId).stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    private ProgressDTO mapToDTO(Progress progress) {
        ProgressDTO dto = new ProgressDTO();
        dto.setUserId(progress.getUser().getId());
        dto.setSubModuleId(progress.getSubModule().getId());
        dto.setCompletedAt(progress.getCompletedAt());
        return dto;
    }
} 