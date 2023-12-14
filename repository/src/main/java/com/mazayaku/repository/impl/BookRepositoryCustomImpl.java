package com.mazayaku.repository.impl;

import com.mazayaku.entity.dao.Book;
import com.mazayaku.entity.dto.PaginationParam;
import com.mazayaku.repository.BookRepositoryCustom;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class BookRepositoryCustomImpl extends AbstractRepository implements BookRepositoryCustom {

  @Override
  public Page<Book> findAll(PaginationParam param) {
    Pageable pageable = PageRequest.of(param.getOffset(), param.getLimit());
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Book> query = builder.createQuery(Book.class);
    CriteriaQuery<Long> count = builder.createQuery(Long.class);
    Root<Book> root = query.from(Book.class);

    count.select(builder.count(count.from(Book.class)));

    count.select(builder.count(count.from(Book.class)));
    if (param.getOrderBy() == null || param.getOrderBy().isEmpty()) {
      query.select(root)
          .orderBy(builder.desc(root.get("createdDate")), builder.desc(root.get("updatedDate")));
    } else {
      Order order;
      Expression<?> expression = root.get(param.getOrderBy());
      order = param.getDirection().isDescending() ?
          builder.desc(expression) : builder.asc(expression);
      query.select(root).orderBy(order);
    }

    TypedQuery<Book> queryList = entityManager.createQuery(query)
        .setFirstResult(pageable.getPageNumber() * pageable.getPageSize())
        .setMaxResults(pageable.getPageSize());
    return new PageImpl<>(queryList.getResultList(), pageable,
        entityManager.createQuery(count).getSingleResult());
  }
}
