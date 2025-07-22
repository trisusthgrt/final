package com.example.newfinal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sub_modules")
public class SubModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id")
    private Module module;

    // Getters and setters
} 