package com.example.BookPlatform.dto.request;


import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateBookDto {
    @Column
    private Long id; //DB 기본키
    @Column
    private  String title; //제목
    @Column
    private  String content; //본문

    @Column
    private String author; //저자


}
