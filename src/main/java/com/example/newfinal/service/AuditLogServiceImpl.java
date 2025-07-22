package com.example.newfinal.service;

import com.example.newfinal.entity.AuditLog;
import com.example.newfinal.entity.User;
import com.example.newfinal.model.AuditLogDTO;
import com.example.newfinal.repository.AuditLogRepository;
import com.example.newfinal.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuditLogServiceImpl implements AuditLogService {
    private final AuditLogRepository auditLogRepository;
    private final UserRepository userRepository;
    public AuditLogServiceImpl(AuditLogRepository auditLogRepository, UserRepository userRepository) {
        this.auditLogRepository = auditLogRepository;
        this.userRepository = userRepository;
    }
    @Override
    @Transactional
    public void logAction(AuditLogDTO auditLogDTO) {
        User user = userRepository.findById(auditLogDTO.getUserId()).orElse(null);
        AuditLog log = new AuditLog();
        log.setUser(user);
        log.setAction(auditLogDTO.getAction());
        log.setEntityType(auditLogDTO.getEntityType());
        log.setEntityId(auditLogDTO.getEntityId());
        log.setTimestamp(auditLogDTO.getTimestamp());
        log.setDetails(auditLogDTO.getDetails());
        auditLogRepository.save(log);
    }
    @Override
    public List<AuditLogDTO> getAuditLogsByUserId(Long userId) {
        return auditLogRepository.findByUserId(userId).stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    @Override
    public List<AuditLogDTO> getAuditLogsByEntity(String entityType, Long entityId) {
        return auditLogRepository.findByEntityTypeAndEntityId(entityType, entityId).stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    private AuditLogDTO mapToDTO(AuditLog log) {
        AuditLogDTO dto = new AuditLogDTO();
        dto.setUserId(log.getUser() != null ? log.getUser().getId() : null);
        dto.setAction(log.getAction());
        dto.setEntityType(log.getEntityType());
        dto.setEntityId(log.getEntityId());
        dto.setTimestamp(log.getTimestamp());
        dto.setDetails(log.getDetails());
        return dto;
    }
} 