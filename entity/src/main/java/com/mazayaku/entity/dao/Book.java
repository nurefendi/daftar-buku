package com.mazayaku.entity.dao;

import com.mazayaku.entity.common.BaseEntity;
import com.mazayaku.entity.constants.TableName;
import com.mazayaku.entity.fields.BaseEntityFields;
import com.mazayaku.entity.fields.BookFields;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = TableName.BUKU)
public class Book extends BaseEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = BaseEntityFields.ID)
  private Integer id;
  @Column(name = BookFields.CODE)
  private String bookCode;
  @Column(name = BookFields.TITLE)
  private String title;
  @Column(name = BookFields.AUTHOR)
  private String author;
  @Column(name = BookFields.PUBLISHER)
  private String publisher;
  @Column(name = BookFields.PUBLISH_DATE)
  private Timestamp publishDate;
  @Column(name = BookFields.COUNT_BOOK)
  private Integer countBook;
}
