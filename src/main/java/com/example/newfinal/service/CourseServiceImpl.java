package com.example.newfinal.service;

import com.example.newfinal.entity.Course;
import com.example.newfinal.entity.User;
import com.example.newfinal.model.CourseRequestDTO;
import com.example.newfinal.model.CourseResponseDTO;
import com.example.newfinal.repository.CourseRepository;
import com.example.newfinal.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    public CourseServiceImpl(CourseRepository courseRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }
    @Override
    @Transactional
    public CourseResponseDTO createCourse(CourseRequestDTO courseRequestDTO) {
        Course course = new Course();
        course.setTitle(courseRequestDTO.getTitle());
        course.setDescription(courseRequestDTO.getDescription());
        // For demo, set owner to first user (should be current user in real app)
        course.setOwner(userRepository.findAll().stream().findFirst().orElseThrow());
        course = courseRepository.save(course);
        return mapToResponse(course);
    }
    @Override
    public CourseResponseDTO getCourseById(Long id) {
        return mapToResponse(courseRepository.findById(id).orElseThrow());
    }
    @Override
    public List<CourseResponseDTO> getAllCourses() {
        return courseRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }
    @Override
    @Transactional
    public CourseResponseDTO updateCourse(Long id, CourseRequestDTO courseRequestDTO) {
        Course course = courseRepository.findById(id).orElseThrow();
        course.setTitle(courseRequestDTO.getTitle());
        course.setDescription(courseRequestDTO.getDescription());
        course = courseRepository.save(course);
        return mapToResponse(course);
    }
    @Override
    @Transactional
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
    @Override
    public List<CourseResponseDTO> getCoursesByOwnerId(Long ownerId) {
        return courseRepository.findByOwnerId(ownerId).stream().map(this::mapToResponse).collect(Collectors.toList());
    }
    private CourseResponseDTO mapToResponse(Course course) {
        CourseResponseDTO dto = new CourseResponseDTO();
        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setDescription(course.getDescription());
        // Owner and modules/documents mapping can be added as needed
        return dto;
    }
} 