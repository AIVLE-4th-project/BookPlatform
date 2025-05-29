package com.example.BookPlatform.dto.response;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
public class BookListDto {
    @Column
    private  String title; //제목
    @Column
    private LocalDateTime createdAt; // 등록일
}
