package com.mazayaku.service.features;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

import com.mazayaku.repository.BookRepository;
import com.mazayaku.service.impl.BookServiceImpl;
import com.mazayaku.service.variable.BookServiceImplTestVariable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import reactor.test.StepVerifier;

public class BookServiceImplTest extends BookServiceImplTestVariable {

  @InjectMocks private BookServiceImpl bookService;
  @Mock private BookRepository bookRepository;
  private AutoCloseable closeable;
  @BeforeEach public void setup(){
    closeable = openMocks(this);
  }
  @AfterEach public void tearDown() throws Exception {
    verifyNoMoreInteractions(bookRepository);
    closeable.close();
  }

  @Test void findAll(){
    when(bookRepository.findAll(PAGINATION_PARAM))
        .thenReturn(PAGE);

    StepVerifier.create(bookService.findAll(PAGINATION_PARAM))
        .expectNext(PAGE)
        .verifyComplete();

    verify(bookRepository, times(1))
        .findAll(PAGINATION_PARAM);
  }

}
