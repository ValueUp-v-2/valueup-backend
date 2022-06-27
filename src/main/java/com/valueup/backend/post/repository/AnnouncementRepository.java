package com.valueup.backend.post.repository;

import com.valueup.backend.post.domain.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository  extends JpaRepository<Announcement, Long> {

}
