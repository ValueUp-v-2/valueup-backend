package com.valueup.backend.post.repository;

import com.valueup.backend.post.domain.Community;
import com.valueup.backend.post.domain.CommunityLike;
import com.valueup.backend.user.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityLikeRepository extends JpaRepository<CommunityLike, Long> {
  Optional<CommunityLike> findByUserAndCommunity(User user, Community community);
}
