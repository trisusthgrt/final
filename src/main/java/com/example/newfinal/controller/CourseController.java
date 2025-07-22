package com.example.newfinal.controller;

import com.example.newfinal.model.CourseRequestDTO;
import com.example.newfinal.model.CourseResponseDTO;
import com.example.newfinal.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    public CourseResponseDTO createCourse(@RequestBody CourseRequestDTO courseRequestDTO) {
        return courseService.createCourse(courseRequestDTO);
    }

    @GetMapping("/{id}")
    public CourseResponseDTO getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @GetMapping
    public List<CourseResponseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PutMapping("/{id}")
    public CourseResponseDTO updateCourse(@PathVariable Long id, @RequestBody CourseRequestDTO courseRequestDTO) {
        return courseService.updateCourse(id, courseRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
} 