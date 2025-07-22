package com.example.newfinal.repository;

import com.example.newfinal.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface Document extends JpaRepository<Document, Long> {
    List<Document> findByCourseId(Long courseId);
} 