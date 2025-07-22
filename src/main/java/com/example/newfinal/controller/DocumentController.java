package com.example.newfinal.controller;

import com.example.newfinal.model.DocumentDTO;
import com.example.newfinal.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @GetMapping("/{id}")
    public DocumentDTO getDocumentById(@PathVariable Long id) {
        return documentService.getDocumentById(id);
    }

    @GetMapping("/by-course/{courseId}")
    public List<DocumentDTO> getDocumentsByCourseId(@PathVariable Long courseId) {
        return documentService.getDocumentsByCourseId(courseId);
    }

    @PostMapping("/by-course/{courseId}")
    public DocumentDTO createDocument(@PathVariable Long courseId, @RequestBody DocumentDTO documentDTO) {
        return documentService.createDocument(courseId, documentDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteDocument(@PathVariable Long id) {
        documentService.deleteDocument(id);
    }
} 