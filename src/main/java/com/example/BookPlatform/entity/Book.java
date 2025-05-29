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

    @Column
    private String coverImage; //표지 이미지

    @Column
    private String imageUrl; //url

    // AI 키워드 기반 태그 저장용
    @Column
    private String aiKeywords;

    // 등록일
    @CreationTimestamp
    private LocalDateTime createdAt;

    // 수정일
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
