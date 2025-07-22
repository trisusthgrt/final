package com.example.newfinal.service;

import com.example.newfinal.model.DocumentVersionDTO;
import java.util.List;

public interface DocumentVersionService {
    DocumentVersionDTO getDocumentVersionById(Long id);
    List<DocumentVersionDTO> getVersionsByDocumentId(Long documentId);
    DocumentVersionDTO createDocumentVersion(Long documentId, DocumentVersionDTO documentVersionDTO);
    void deleteDocumentVersion(Long id);
} 