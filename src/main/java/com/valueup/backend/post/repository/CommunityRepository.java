package com.valueup.backend.post.repository;

import com.valueup.backend.post.domain.Community;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepository  extends JpaRepository<Community, Long> {

}
