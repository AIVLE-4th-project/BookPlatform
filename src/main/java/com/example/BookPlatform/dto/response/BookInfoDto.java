package com.example.BookPlatform.dto.response;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder

public class BookInfoDto {
    @Column
    private  String title; //제목
    @Column
    private  String content; //본문
    @Column
    private String updatedAt; //수정일
}
