package com.example.newfinal.service;

import com.example.newfinal.model.AuditLogDTO;
import java.util.List;

public interface AuditLogService {
    void logAction(AuditLogDTO auditLogDTO);
    List<AuditLogDTO> getAuditLogsByUserId(Long userId);
    List<AuditLogDTO> getAuditLogsByEntity(String entityType, Long entityId);
} 