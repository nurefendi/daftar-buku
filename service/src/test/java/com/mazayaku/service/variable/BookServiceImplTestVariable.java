package com.mazayaku.service.variable;

import com.mazayaku.entity.dao.Book;
import com.mazayaku.entity.dto.PaginationParam;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;

public class BookServiceImplTestVariable {
  public static final PaginationParam PAGINATION_PARAM = PaginationParam.builder()
      .limit(10)
      .offset(0)
      .build();
  public static final Page<Book> PAGE = Mockito.mock(Page.class);


}
