package com.mazayaku.restweb.request;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequest {
  private String bookCode;
  private String title;
  private String author;
  private String publisher;
  private Timestamp publishDate;
  private Integer countBook;

  @Override
  public String toString() {
    return "BookRequest{" +
        "bookCode='" + bookCode + '\'' +
        ", title='" + title + '\'' +
        ", author='" + author + '\'' +
        ", publisher='" + publisher + '\'' +
        ", publishDate=" + publishDate +
        ", countBook=" + countBook +
        '}';
  }
}
