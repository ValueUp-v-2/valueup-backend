package com.valueup.backend.post.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateAnnouncementRequest extends AnnouncementRequest{
  private Long id;
}
