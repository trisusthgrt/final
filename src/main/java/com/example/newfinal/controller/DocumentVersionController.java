package com.example.newfinal.controller;

import com.example.newfinal.model.DocumentVersionDTO;
import com.example.newfinal.service.DocumentVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/document-versions")
public class DocumentVersionController {
    @Autowired
    private DocumentVersionService documentVersionService;

    @GetMapping("/{id}")
    public DocumentVersionDTO getDocumentVersionById(@PathVariable Long id) {
        return documentVersionService.getDocumentVersionById(id);
    }

    @GetMapping("/by-document/{documentId}")
    public List<DocumentVersionDTO> getVersionsByDocumentId(@PathVariable Long documentId) {
        return documentVersionService.getVersionsByDocumentId(documentId);
    }

    @PostMapping("/by-document/{documentId}")
    public DocumentVersionDTO createDocumentVersion(@PathVariable Long documentId, @RequestBody DocumentVersionDTO documentVersionDTO) {
        return documentVersionService.createDocumentVersion(documentId, documentVersionDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteDocumentVersion(@PathVariable Long id) {
        documentVersionService.deleteDocumentVersion(id);
    }
} 