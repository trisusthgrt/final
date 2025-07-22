package com.example.newfinal.service;

import com.example.newfinal.entity.Enrollment;
import com.example.newfinal.entity.User;
import com.example.newfinal.entity.Course;
import com.example.newfinal.model.EnrollmentDTO;
import com.example.newfinal.repository.EnrollmentRepository;
import com.example.newfinal.repository.UserRepository;
import com.example.newfinal.repository.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository, UserRepository userRepository, CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }
    @Override
    @Transactional
    public EnrollmentDTO enrollUser(Long userId, Long courseId) {
        if (enrollmentRepository.existsByUserIdAndCourseId(userId, courseId)) {
            throw new RuntimeException("User already enrolled in course");
        }
        User user = userRepository.findById(userId).orElseThrow();
        Course course = courseRepository.findById(courseId).orElseThrow();
        Enrollment enrollment = new Enrollment();
        enrollment.setUser(user);
        enrollment.setCourse(course);
        enrollment.setEnrolledAt(java.time.LocalDateTime.now());
        enrollment = enrollmentRepository.save(enrollment);
        return mapToDTO(enrollment);
    }
    @Override
    public List<EnrollmentDTO> getEnrollmentsByUserId(Long userId) {
        return enrollmentRepository.findByUserId(userId).stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    @Override
    public List<EnrollmentDTO> getEnrollmentsByCourseId(Long courseId) {
        return enrollmentRepository.findByCourseId(courseId).stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    @Override
    @Transactional
    public void unenrollUser(Long userId, Long courseId) {
        List<Enrollment> enrollments = enrollmentRepository.findByUserId(userId).stream()
            .filter(e -> e.getCourse().getId().equals(courseId)).collect(Collectors.toList());
        enrollments.forEach(enrollmentRepository::delete);
    }
    private EnrollmentDTO mapToDTO(Enrollment enrollment) {
        EnrollmentDTO dto = new EnrollmentDTO();
        dto.setUserId(enrollment.getUser().getId());
        dto.setCourseId(enrollment.getCourse().getId());
        dto.setEnrolledAt(enrollment.getEnrolledAt());
        return dto;
    }
} 