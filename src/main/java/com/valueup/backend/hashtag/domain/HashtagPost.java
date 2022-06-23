package com.valueup.backend.hashtag.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
}
