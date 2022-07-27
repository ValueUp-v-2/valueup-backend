package com.valueup.backend.post.dto.response;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Data
public class PageResponse<DTO, EN>  {
  //dto리스트
  private List<DTO> dtoList;

  //총 페이지 번호
  private int totalPage;

  //현재 페이지 번호
  private int page;

  //목록 사이즈
  private int size;

  //시작 페이지 번호, 끝 페이지 번호
  private int start, end;

  //이전, 다음
  private boolean prev, next;

  //페이지 번호목록
  private List<Integer> pageList;


  //초깃값 세팅
  public PageResponse(Page<EN> result, Function<EN, DTO> fn){
    dtoList = result.stream().map(fn).collect(Collectors.toList());

    totalPage = result.getTotalPages();

    makePageList(result.getPageable());
  }


  private void makePageList(Pageable pageable) {
    this.page = pageable.getPageNumber() +1;
    this.size = pageable.getPageSize();

    //temp end page
    int tempEnd = (int)(Math.ceil(page/10.0)) * 10;

    start = tempEnd - 9;

    prev = start > 1;

    end = totalPage > tempEnd ? tempEnd : totalPage;

    next = totalPage > tempEnd;

    pageList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
  }
}
