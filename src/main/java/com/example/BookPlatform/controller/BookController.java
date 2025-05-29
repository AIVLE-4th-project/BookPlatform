package com.example.BookPlatform.controller;

import com.example.BookPlatform.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookController {
    private  final BookService bookService;

    @GetMapping(value = "/book-list")
    public ResponseEntity<?>  getBookList() {
        return new ResponseEntity<>(bookService.getBookList(), HttpStatus.OK);
    }
}
