package com.example.newfinal.service;

import com.example.newfinal.model.CourseRequestDTO;
import com.example.newfinal.model.CourseResponseDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Override
    public CourseResponseDTO createCourse(CourseRequestDTO courseRequestDTO) {
        // TODO: Implement create course
        return null;
    }
    @Override
    public CourseResponseDTO getCourseById(Long id) {
        // TODO: Implement get course by id
        return null;
    }
    @Override
    public List<CourseResponseDTO> getAllCourses() {
        // TODO: Implement get all courses
        return null;
    }
    @Override
    public CourseResponseDTO updateCourse(Long id, CourseRequestDTO courseRequestDTO) {
        // TODO: Implement update course
        return null;
    }
    @Override
    public void deleteCourse(Long id) {
        // TODO: Implement delete course
    }
    @Override
    public List<CourseResponseDTO> getCoursesByOwnerId(Long ownerId) {
        // TODO: Implement get courses by owner id
        return null;
    }
} 