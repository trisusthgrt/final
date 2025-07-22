package com.example.newfinal.service;

import com.example.newfinal.model.EnrollmentDTO;
import java.util.List;

public interface EnrollmentService {
    EnrollmentDTO enrollUser(Long userId, Long courseId);
    List<EnrollmentDTO> getEnrollmentsByUserId(Long userId);
    List<EnrollmentDTO> getEnrollmentsByCourseId(Long courseId);
    void unenrollUser(Long userId, Long courseId);
} 