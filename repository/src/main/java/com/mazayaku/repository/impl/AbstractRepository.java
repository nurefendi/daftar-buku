package com.mazayaku.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class AbstractRepository {
  @PersistenceContext
  protected EntityManager entityManager;

  Query query(String sql) {
    return entityManager.createQuery(sql);
  }

  Query query(String sql, Class clazz) {
    return entityManager.createQuery(sql, clazz);
  }

  Query nativeQuery(String sql) {
    return entityManager.createNativeQuery(sql);
  }
  Query nativeQuery(String sql, Class clazz) {
    return entityManager.createNativeQuery(sql, clazz);
  }

  public EntityManager getEntityManager() {
    return entityManager;
  }
}
