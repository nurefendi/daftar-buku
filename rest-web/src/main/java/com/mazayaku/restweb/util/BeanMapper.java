package com.mazayaku.restweb.util;

import com.mazayaku.entity.dao.Book;
import com.mazayaku.restweb.request.BookRequest;
import com.mazayaku.restweb.response.BookResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BeanMapper {
  BeanMapper BEAN_MAPPER = Mappers.getMapper(BeanMapper.class);

  BookResponse map(Book book);

  Book map(BookRequest request);
}
