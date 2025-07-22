package com.example.newfinal.service;

import com.example.newfinal.entity.DocumentVersion;
import com.example.newfinal.entity.Document;
import com.example.newfinal.model.DocumentVersionDTO;
import com.example.newfinal.repository.DocumentVersionRepository;
import com.example.newfinal.repository.DocumentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentVersionServiceImpl implements DocumentVersionService {
    private final DocumentVersionRepository documentVersionRepository;
    private final DocumentRepository documentRepository;
    public DocumentVersionServiceImpl(DocumentVersionRepository documentVersionRepository, DocumentRepository documentRepository) {
        this.documentVersionRepository = documentVersionRepository;
        this.documentRepository = documentRepository;
    }
    @Override
    public DocumentVersionDTO getDocumentVersionById(Long id) {
        return mapToDTO(documentVersionRepository.findById(id).orElseThrow());
    }
    @Override
    public List<DocumentVersionDTO> getVersionsByDocumentId(Long documentId) {
        return documentVersionRepository.findByDocumentIdOrderByVersionNumberDesc(documentId).stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    @Override
    @Transactional
    public DocumentVersionDTO createDocumentVersion(Long documentId, DocumentVersionDTO documentVersionDTO) {
        Document document = documentRepository.findById(documentId).orElseThrow();
        DocumentVersion version = new DocumentVersion();
        version.setDocument(document);
        version.setVersionNumber(documentVersionDTO.getVersionNumber());
        version.setFilePath(documentVersionDTO.getFilePath());
        version.setCreatedAt(documentVersionDTO.getCreatedAt());
        version.setEncryptedData(new byte[0]); // Placeholder for encryption
        version = documentVersionRepository.save(version);
        return mapToDTO(version);
    }
    @Override
    @Transactional
    public void deleteDocumentVersion(Long id) {
        documentVersionRepository.deleteById(id);
    }
    private DocumentVersionDTO mapToDTO(DocumentVersion version) {
        DocumentVersionDTO dto = new DocumentVersionDTO();
        dto.setId(version.getId());
        dto.setVersionNumber(version.getVersionNumber());
        dto.setCreatedAt(version.getCreatedAt());
        // Add filePath, encryptedData as needed
        return dto;
    }
} 