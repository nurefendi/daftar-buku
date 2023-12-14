package com.mazayaku.repository;

import com.mazayaku.entity.dao.Book;
import com.mazayaku.entity.dto.PaginationParam;
import org.springframework.data.domain.Page;

public interface BookRepositoryCustom {

  Page<Book> findAll(PaginationParam param);

}
