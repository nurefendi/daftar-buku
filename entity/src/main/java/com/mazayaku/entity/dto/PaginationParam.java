package com.mazayaku.entity.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaginationParam implements Serializable {

  private int offset = 0;
  private int limit = 10;
  private String orderBy;
  private Sort.Direction direction = Sort.Direction.DESC;
}
