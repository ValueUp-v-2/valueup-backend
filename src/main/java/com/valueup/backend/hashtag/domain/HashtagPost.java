package com.valueup.backend.hashtag.domain;

import com.valueup.backend.post.domain.Announcement;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
public class HashtagPost {

    @Id
    @GeneratedValue
    @Column(name = "hashtag_post_id")
    private Long id; //해시태그게시판 번호

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "post_id")
    //private Announcement announcement;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "hashtag_id")
    //private Hashtag hashtag;
}
