package com.valueup.backend.comment.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentRequest {

  private Long postId;


  private Long parentId;


  private String content;
}
