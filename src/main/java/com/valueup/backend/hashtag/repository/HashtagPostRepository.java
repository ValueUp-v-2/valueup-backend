package com.valueup.backend.hashtag.repository;

import com.valueup.backend.hashtag.domain.HashtagPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HashtagPostRepository  extends JpaRepository<HashtagPost, Long> {

}
