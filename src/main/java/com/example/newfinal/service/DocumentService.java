package com.example.newfinal.service;

import com.example.newfinal.model.DocumentDTO;
import java.util.List;

public interface DocumentService {
    DocumentDTO getDocumentById(Long id);
    List<DocumentDTO> getDocumentsByCourseId(Long courseId);
    DocumentDTO createDocument(Long courseId, DocumentDTO documentDTO);
    void deleteDocument(Long id);
} 