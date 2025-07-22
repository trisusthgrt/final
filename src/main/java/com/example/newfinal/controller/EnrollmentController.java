package com.example.newfinal.controller;

import com.example.newfinal.model.EnrollmentDTO;
import com.example.newfinal.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping
    public EnrollmentDTO enrollUser(@RequestParam Long userId, @RequestParam Long courseId) {
        return enrollmentService.enrollUser(userId, courseId);
    }

    @GetMapping("/by-user/{userId}")
    public List<EnrollmentDTO> getEnrollmentsByUserId(@PathVariable Long userId) {
        return enrollmentService.getEnrollmentsByUserId(userId);
    }

    @GetMapping("/by-course/{courseId}")
    public List<EnrollmentDTO> getEnrollmentsByCourseId(@PathVariable Long courseId) {
        return enrollmentService.getEnrollmentsByCourseId(courseId);
    }

    @DeleteMapping
    public void unenrollUser(@RequestParam Long userId, @RequestParam Long courseId) {
        enrollmentService.unenrollUser(userId, courseId);
    }
} 