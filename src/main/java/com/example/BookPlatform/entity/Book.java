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
    private Long id; // 기본키

    @Column
    private String title; // 제목

    @Column
    private String content; //본문

    @Column
    private String author; //저자

    @Column
    private String coverUrl; //url

    // 등록일
    @CreationTimestamp
    private LocalDateTime createdAt; //등록일

    // 수정일
    @UpdateTimestamp
    private LocalDateTime updatedAt; //수정일
}
