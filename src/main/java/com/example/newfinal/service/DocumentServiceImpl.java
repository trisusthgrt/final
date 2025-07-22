package com.example.newfinal.service;

import com.example.newfinal.entity.Document;
import com.example.newfinal.entity.Course;
import com.example.newfinal.model.DocumentDTO;
import com.example.newfinal.repository.DocumentRepository;
import com.example.newfinal.repository.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository documentRepository;
    private final CourseRepository courseRepository;
    public DocumentServiceImpl(DocumentRepository documentRepository, CourseRepository courseRepository) {
        this.documentRepository = documentRepository;
        this.courseRepository = courseRepository;
    }
    @Override
    public DocumentDTO getDocumentById(Long id) {
        return mapToDTO(documentRepository.findById(id).orElseThrow());
    }
    @Override
    public List<DocumentDTO> getDocumentsByCourseId(Long courseId) {
        return documentRepository.findByCourseId(courseId).stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    @Override
    @Transactional
    public DocumentDTO createDocument(Long courseId, DocumentDTO documentDTO) {
        Course course = courseRepository.findById(courseId).orElseThrow();
        Document document = new Document();
        document.setName(documentDTO.getName());
        document.setCourse(course);
        document = documentRepository.save(document);
        return mapToDTO(document);
    }
    @Override
    @Transactional
    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }
    private DocumentDTO mapToDTO(Document document) {
        DocumentDTO dto = new DocumentDTO();
        dto.setId(document.getId());
        dto.setName(document.getName());
        dto.setCourseId(document.getCourse().getId());
        // Document versions mapping can be added as needed
        return dto;
    }
} 