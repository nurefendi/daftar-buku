package com.mazayaku.repository;


import com.mazayaku.entity.dao.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer>, BookRepositoryCustom {
}