package com.valueup.backend.post.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnnouncementListResponse {

  private List<AnnouncementResponse> announcementResponses;

}
