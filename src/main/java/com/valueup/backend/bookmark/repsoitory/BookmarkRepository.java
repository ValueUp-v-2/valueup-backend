package com.valueup.backend.bookmark.repsoitory;

import com.valueup.backend.bookmark.domain.Bookmark;
import com.valueup.backend.post.domain.Post;
import com.valueup.backend.user.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

  Optional<Bookmark> findByUserAndPost(User user, Post post);
}
