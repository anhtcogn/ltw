package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entitys.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
