package com.valueup.backend.post.repository;

import com.valueup.backend.post.domain.Announcement;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AnnouncementRepository  extends JpaRepository<Announcement, Long>,
    QuerydslPredicateExecutor<Announcement> {
  @Query(value = "select a, u from Announcement a left join User u on u.id = a", nativeQuery = true)
  List<Announcement> getAnnouncement();


  //List<Announcement> findByUser(User user)
}
