package com.mazayaku.restweb.controller;


import com.mazayaku.entity.dto.PaginationParam;
import com.mazayaku.restweb.helper.CommonResponseHelper;
import com.mazayaku.restweb.request.BookRequest;
import com.mazayaku.restweb.response.BookResponse;
import com.mazayaku.restweb.util.BeanMapper;
import com.mazayaku.service.api.BookService;
import com.mazayaku.utility.HeaderRequest;
import com.mazayaku.utility.constant.ServicePath;
import com.mazayaku.utility.helper.RestResult;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import springfox.documentation.annotations.ApiIgnore;

@Slf4j
@RestController
@RequestMapping(ServicePath.ROUTE_BOOKS)
@Api(value = "Book API")
public class BookController extends BaseController {
  @Autowired
  private BookService bookService;
  private static final BeanMapper mapper = BeanMapper.BEAN_MAPPER;

  @GetMapping
  public Mono<RestResult<List<BookResponse>>> findAll(PaginationParam paginationParam) {
    log.info("Find all book");
    return bookService.findAll(paginationParam)
        .map(books -> books.map(mapper::map))
        .doOnNext(response -> log
            .info("Response Find all Book {}", response))
        .map(bookResponses ->
            CommonResponseHelper.constructSuccessGetPageable(bookResponses, paginationParam));
  }

  @GetMapping(ServicePath.ID)
  public Mono<RestResult<BookResponse>> findById(@PathVariable Integer id) {
    log.info("Find one Book with Find Book by ID={}", id);
    return bookService.findById(id)
        .map(mapper::map)
        .map(CommonResponseHelper::constructSuccessGet)
        .doOnNext(response -> log
            .info("Response Find Book by ID {}", response))
        .subscribeOn(Schedulers.boundedElastic());
  }

  @PostMapping()
  public Mono<RestResult<BookResponse>> store(@RequestBody BookRequest request) {
    log.info("Store data request={}", request);
    return bookService.store(mapper.map(request))
        .map(mapper::map)
        .map(CommonResponseHelper::constructSuccessPost)
        .doOnNext(response -> log
            .info("Response Store {}", response))
        .subscribeOn(Schedulers.boundedElastic());
  }

  @PutMapping(ServicePath.ID)
  public Mono<RestResult<BookResponse>> update(
      @RequestBody BookRequest request,
      @PathVariable Integer id) {
    log.info("Update data request={} and id={}",  request, id);
    return bookService.update(mapper.map(request), id)
        .map(mapper::map)
        .map(CommonResponseHelper::constructSuccessPut)
        .doOnNext(response -> log
            .info("Response update {}",  response))
        .subscribeOn(Schedulers.boundedElastic());
  }

  @DeleteMapping(ServicePath.ID)
  public Mono<RestResult<Void>> delete(@PathVariable Integer id) {
    log.info("Delete Book with id={} ", id);
    return bookService.delete(id)
        .then(Mono.fromCallable(() -> {
          RestResult<Void> result = new RestResult<>();
          result.ok("Delete Success");
          return result;
        }))
        .doOnNext(response -> log.info("Response Delete Book with id {}", id));
  }


}
