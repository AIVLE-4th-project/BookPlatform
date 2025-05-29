package com.example.BookPlatform.dto.request;


import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BookIdDto {
    @Column
    private Long id; //DB 기본키
}
