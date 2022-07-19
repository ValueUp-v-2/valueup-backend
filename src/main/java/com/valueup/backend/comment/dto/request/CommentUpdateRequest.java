package com.valueup.backend.comment.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentUpdateRequest {
  private Long commentId;

  private String content;
}
