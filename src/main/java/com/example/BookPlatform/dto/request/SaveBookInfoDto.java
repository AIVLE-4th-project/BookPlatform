package com.example.BookPlatform.dto.request;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

//책 정보 등록
@Getter
@Builder
public class SaveBookInfoDto {

    @Column
    private  String title; //제목
    @Column
    private  String content; //본문

    @Column
    private String author; //저자

    @Column
    private String coverUrl; //이미지 url
}
