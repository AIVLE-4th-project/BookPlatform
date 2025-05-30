package com.example.BookPlatform.service;


import com.example.BookPlatform.dto.request.BookIdDto;
import com.example.BookPlatform.dto.request.SaveBookInfoDto;
import com.example.BookPlatform.dto.request.UpdateBookDto;
import com.example.BookPlatform.dto.response.BookInfoDto;
import com.example.BookPlatform.dto.response.BookListDto;
import com.example.BookPlatform.entity.Book;
import com.example.BookPlatform.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final ImageService imageService;
    public List<BookListDto> getBookList(){
        List<Book> bookList = bookRepository.findAll();
        List<BookListDto> bookInfoDtoList = new ArrayList<>();
        for (Book book: bookList){
            BookListDto bookInfoDto = BookListDto.builder().
                    id(book.getId()).
                    title(book.getTitle()).
                    coverUrl(book.getCoverUrl()).
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
                author(book.get().getAuthor()).
                coverUrl(book.get().getCoverUrl()).
                createdAt(book.get().getCreatedAt()).
                updatedAt(book.get().getUpdatedAt()).
                build();
        return bookInfoDto;
    }

    @Async
    public void registBook(SaveBookInfoDto saveBookInfoDto){
        String prompt =  "The title of the book is " +saveBookInfoDto.getTitle()+"and the content of the book is "
                +saveBookInfoDto.getContent()+ ". Please generate a cover image for this book.";

        Book book = Book.builder().
                title(saveBookInfoDto.getTitle()).
                content(saveBookInfoDto.getContent()).
                author(saveBookInfoDto.getAuthor()).
                coverUrl(imageService.generateImage(prompt)).
                createdAt(LocalDateTime.now()).
                updatedAt(LocalDateTime.now()).
                build();
        bookRepository.save(book);
    }

    public void  deleteBook(BookIdDto bookIdDto) {
        bookRepository.deleteById(bookIdDto.getId());
    }

    @Async
    public void updateBook(UpdateBookDto updateBookDto){
        Optional<Book> optionalBook = bookRepository.findById(updateBookDto.getId());
        Book book = optionalBook.get();


        String prompt =  "The title of the book is " +updateBookDto.getTitle()+"and the content of the book is "
                +updateBookDto.getContent()+ ". Please generate a cover image for this book.";

        book = Book.builder()
                .id(updateBookDto.getId())
                .title(updateBookDto.getTitle())
                .content(updateBookDto.getContent())
                .author(updateBookDto.getAuthor())
                .coverUrl(imageService.generateImage(prompt))
                .createdAt(optionalBook.get().getCreatedAt())
                .updatedAt(LocalDateTime.now()) // 수동으로 설정
                .build();
         bookRepository.save(book);
    }
}
