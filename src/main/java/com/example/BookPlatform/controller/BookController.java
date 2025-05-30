package com.example.BookPlatform.controller;

import com.example.BookPlatform.dto.request.BookIdDto;
import com.example.BookPlatform.dto.request.SaveBookInfoDto;
import com.example.BookPlatform.dto.request.UpdateBookDto;
import com.example.BookPlatform.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookController {
    private  final BookService bookService;

    @GetMapping(value = "/books") //전체 목록 조회
    public ResponseEntity<?>  getBookList() {
        return new ResponseEntity<>(bookService.getBookList(), HttpStatus.OK);
    }


    @GetMapping(value = "/books-detail") //상세 정보 조회
    public ResponseEntity<?> getBookDetailInfo( @RequestParam("id") Long id) {
        return new ResponseEntity<>(bookService.getBookDetailInfo(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/books") //책 정보 삭제
    public ResponseEntity<?> deleteBook(@RequestBody BookIdDto bookIdDto){
        bookService.deleteBook(bookIdDto);
        return new ResponseEntity<>("delete success",HttpStatus.OK);
    }

    @PostMapping(value = "/books") //책 정보 등록
    public ResponseEntity<?> registBook(@RequestBody SaveBookInfoDto saveBookInfoDto){

        bookService.registBook(saveBookInfoDto);
        return new ResponseEntity<>("regist success",HttpStatus.OK);
    }


    @PutMapping(value = "/books") //책 정보 수정
    public ResponseEntity<?> updateBook(@RequestBody UpdateBookDto updateBookDto){
        bookService.updateBook(updateBookDto);
        return new ResponseEntity<>("hello",HttpStatus.OK);
    }
}
