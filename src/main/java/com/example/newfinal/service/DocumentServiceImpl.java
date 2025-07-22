package com.example.newfinal.service;

import com.example.newfinal.model.DocumentDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Override
    public DocumentDTO getDocumentById(Long id) {
        // TODO: Implement get document by id
        return null;
    }
    @Override
    public List<DocumentDTO> getDocumentsByCourseId(Long courseId) {
        // TODO: Implement get documents by course id
        return null;
    }
    @Override
    public DocumentDTO createDocument(Long courseId, DocumentDTO documentDTO) {
        // TODO: Implement create document
        return null;
    }
    @Override
    public void deleteDocument(Long id) {
        // TODO: Implement delete document
    }
} 