package com.mazayaku.service.impl;

import com.mazayaku.entity.dao.Book;
import com.mazayaku.entity.dto.PaginationParam;
import com.mazayaku.repository.BookRepository;
import com.mazayaku.service.api.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;


@Slf4j
@Service
public class BookServiceImpl implements BookService {

  @Autowired
  private BookRepository bookRepository;

  @Override
  public Mono<Page<Book>> findAll(PaginationParam paginationParam) {
    return Mono.just(bookRepository.findAll(paginationParam));
  }

  @Override
  public Mono<Book> findById(Integer bookId) {
    return bookRepository.findById(bookId)
        .map(Mono::just)
        .orElseGet(() -> Mono.error(
            new ResponseStatusException(HttpStatusCode.valueOf(400), "Data Not found"))
        );
  }

  @Override
  public Mono<Book> store(Book book) {
    return Mono.just(bookRepository.save(book));
  }

  @Override
  public Mono<Book> update(Book book, Integer bookId) {
    return findById(bookId)
        .flatMap(existingBook -> {
          book.setId(existingBook.getId());
          return Mono.just(bookRepository.save(book));
        });
  }

  @Override
  public Mono<Void> delete(Integer bookId) {
    return findById(bookId)
        .flatMap(book -> {
          bookRepository.deleteById(book.getId());
          return Mono.empty();
        });
  }
}
