package com.example.newfinal.service;

import com.example.newfinal.model.EnrollmentDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    @Override
    public EnrollmentDTO enrollUser(Long userId, Long courseId) {
        // TODO: Implement enroll user
        return null;
    }
    @Override
    public List<EnrollmentDTO> getEnrollmentsByUserId(Long userId) {
        // TODO: Implement get enrollments by user id
        return null;
    }
    @Override
    public List<EnrollmentDTO> getEnrollmentsByCourseId(Long courseId) {
        // TODO: Implement get enrollments by course id
        return null;
    }
    @Override
    public void unenrollUser(Long userId, Long courseId) {
        // TODO: Implement unenroll user
    }
} 