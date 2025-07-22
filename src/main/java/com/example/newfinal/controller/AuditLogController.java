package com.example.newfinal.controller;

import com.example.newfinal.model.AuditLogDTO;
import com.example.newfinal.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/audit-logs")
public class AuditLogController {
    @Autowired
    private AuditLogService auditLogService;

    @GetMapping("/by-user/{userId}")
    public List<AuditLogDTO> getAuditLogsByUserId(@PathVariable Long userId) {
        return auditLogService.getAuditLogsByUserId(userId);
    }

    @GetMapping("/by-entity")
    public List<AuditLogDTO> getAuditLogsByEntity(@RequestParam String entityType, @RequestParam Long entityId) {
        return auditLogService.getAuditLogsByEntity(entityType, entityId);
    }
} 