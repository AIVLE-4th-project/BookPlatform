package com.example.BookPlatform.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 제목
    @Column(nullable = false)
    private String title;

    // 본문
    @Column(columnDefinition = "TEXT")
    private String content;

    // 표지 이미지 (직접 업로드 또는 AI 생성)
    private String coverImage;

    // AI가 생성한 표지 이미지 (URL 또는 base64 등)
    private String aiGeneratedCover;

    // AI 키워드 기반 태그 저장용
    private String aiKeywords;

    // 등록일
    @CreationTimestamp
    private LocalDateTime createdAt;

    // 수정일
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
