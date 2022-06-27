package com.valueup.backend.bookmark.repsoitory;

import com.valueup.backend.bookmark.domain.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

}
