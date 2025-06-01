package com.example.BookPlatform.dto.response;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder

public class BookInfoDto {
    @Column
    private  String title; //제목
    @Column
    private  String content; //본문

    @Column
    private String author; //작가

    @Column
    private String coverUrl; //표지 url

    @Column
    private int views; // 조회수

    @Column
    private LocalDateTime createdAt; //수정일
    @Column
    private LocalDateTime updatedAt; //수정일
}
