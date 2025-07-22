package com.example.newfinal.model;

import java.time.LocalDateTime;

public class AuditLogDTO {
    private Long userId;
    private String action;
    private String entityType;
    private Long entityId;
    private LocalDateTime timestamp;
    private String details;

    // Getters and setters
} 