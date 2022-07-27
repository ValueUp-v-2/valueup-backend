package com.valueup.backend.post.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Builder
@AllArgsConstructor
@Data
public class PageRequestDTO {

  private int page;//현재페이지
  private int size;//한 페이지에 보여질 상품 수

  //기본값 설정
  public PageRequestDTO() {
    this.page = 1;
    this.size = 10;
  }

  //JPA에서 사용할 Pageable 타입 객체 생성
  public Pageable getPageable(Sort sort) {
    return PageRequest.of(page - 1, size, sort);
  }
}

