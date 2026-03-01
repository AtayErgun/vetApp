package com.ergun.vetapp.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;      // Başlık
    @Column(columnDefinition = "TEXT")
    private String content;    // İçerik
    private String author;     // Yazar (Dr. Ergün vb.)
    private String imageUrl;   // Fotoğraf linki
    private LocalDateTime createdAt = LocalDateTime.now();

    public BlogPost() {}

    // Manuel Getter ve Setter'lar (JSON hatası almamak için)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}