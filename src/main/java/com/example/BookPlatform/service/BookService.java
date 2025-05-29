package com.example.BookPlatform.service;


import com.example.BookPlatform.dto.response.BookInfoDto;
import com.example.BookPlatform.entity.Book;
import com.example.BookPlatform.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    public List<BookInfoDto> getBookList(){
        List<Book> bookList = bookRepository.findAll();
        List<BookInfoDto> bookInfoDtoList = new ArrayList<>();
        for (Book book: bookList){
            BookInfoDto bookInfoDto = BookInfoDto.builder().
                    title(book.getTitle()).
                    content(book.getContent()).
                    build();
            bookInfoDtoList.add(bookInfoDto);
        }
        return bookInfoDtoList;
    }
}
