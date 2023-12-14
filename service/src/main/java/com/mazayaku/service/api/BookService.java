package com.mazayaku.service.api;

import com.mazayaku.entity.dao.Book;
import com.mazayaku.entity.dto.PaginationParam;
import org.springframework.data.domain.Page;
import reactor.core.publisher.Mono;

public interface BookService {

  Mono<Page<Book>> findAll(PaginationParam paginationParam);
  Mono<Book> findById(Integer bookId);
  Mono<Book> store(Book book);
  Mono<Book> update(Book book, Integer bookId);
  Mono<Void> delete(Integer bookId);
}
