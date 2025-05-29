package com.example.BookPlatform.dto.request;

import jakarta.persistence.Column;

//책 정보 등록 ㅇ썌
public class SaveBookInfoDto {

    @Column
    private  String title; //제목
    @Column
    private  String content; //본문
    @Column
    private String imageUrl; //이미지 url
}
