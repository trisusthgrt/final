package com.example.newfinal.service;

import com.example.newfinal.model.DocumentVersionDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DocumentVersionServiceImpl implements DocumentVersionService {
    @Override
    public DocumentVersionDTO getDocumentVersionById(Long id) {
        // TODO: Implement get document version by id
        return null;
    }
    @Override
    public List<DocumentVersionDTO> getVersionsByDocumentId(Long documentId) {
        // TODO: Implement get versions by document id
        return null;
    }
    @Override
    public DocumentVersionDTO createDocumentVersion(Long documentId, DocumentVersionDTO documentVersionDTO) {
        // TODO: Implement create document version
        return null;
    }
    @Override
    public void deleteDocumentVersion(Long id) {
        // TODO: Implement delete document version
    }
} 