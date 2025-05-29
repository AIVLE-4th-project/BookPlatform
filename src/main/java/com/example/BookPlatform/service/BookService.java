package com.example.BookPlatform.service;


import com.example.BookPlatform.dto.response.BookInfoDto;
import com.example.BookPlatform.dto.response.BookListDto;
import com.example.BookPlatform.entity.Book;
import com.example.BookPlatform.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    public List<BookListDto> getBookList(){
        List<Book> bookList = bookRepository.findAll();
        List<BookListDto> bookInfoDtoList = new ArrayList<>();
        for (Book book: bookList){
            BookListDto bookInfoDto = BookListDto.builder().
                    id(book.getId()).
                    title(book.getTitle()).
                    createdAt(book.getCreatedAt()).
                    build();
            bookInfoDtoList.add(bookInfoDto);
        }
        return bookInfoDtoList;
    }
    public BookInfoDto getBookDetailInfo(Long id){
        Optional<Book> book = bookRepository.findById(id);
        BookInfoDto bookInfoDto = BookInfoDto.builder().
                title(book.get().getTitle()).
                content(book.get().getContent()).
                updatedAt(book.get().getUpdatedAt()).
                build();
        return bookInfoDto;
    }
}
