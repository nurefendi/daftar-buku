package com.mazayaku.restweb.response;

import java.sql.Timestamp;
import lombok.Data;

@Data
public class BookResponse {
  private Integer id;
  private String bookCode;
  private String title;
  private String author;
  private String publisher;
  private Timestamp publishDate;
  private Integer countBook;

  @Override
  public String toString() {
    return "BookResponse{" +
        "id=" + id +
        ", bookCode='" + bookCode + '\'' +
        ", title='" + title + '\'' +
        ", author='" + author + '\'' +
        ", publisher='" + publisher + '\'' +
        ", publishDate=" + publishDate +
        ", countBook=" + countBook +
        '}';
  }
}
