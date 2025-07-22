package com.example.newfinal.repository;

import com.example.newfinal.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByOwnerId(Long ownerId);
} 