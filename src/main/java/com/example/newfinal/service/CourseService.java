package com.example.newfinal.service;

import com.example.newfinal.model.CourseRequestDTO;
import com.example.newfinal.model.CourseResponseDTO;
import java.util.List;

public interface CourseService {
    CourseResponseDTO createCourse(CourseRequestDTO courseRequestDTO);
    CourseResponseDTO getCourseById(Long id);
    List<CourseResponseDTO> getAllCourses();
    CourseResponseDTO updateCourse(Long id, CourseRequestDTO courseRequestDTO);
    void deleteCourse(Long id);
    List<CourseResponseDTO> getCoursesByOwnerId(Long ownerId);
} 