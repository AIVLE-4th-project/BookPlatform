package com.example.BookPlatform.repository;


import com.example.BookPlatform.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface BookRepository extends JpaRepository<Book, Long> {


    List<Book> findAll();

    Optional<Book> findById(Long id); //책 상세 검색

    List<Book> findByAuthor(String author); //작가명으로 검색

    List<Book> findAllByOrderByViewsDesc(); //조회수 기준 정렬
}
