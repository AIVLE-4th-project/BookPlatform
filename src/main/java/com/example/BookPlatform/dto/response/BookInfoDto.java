package com.example.BookPlatform.dto.response;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder

public class BookInfoDto {
    @Column
    private  String title;
    @Column
    private  String content;
}
