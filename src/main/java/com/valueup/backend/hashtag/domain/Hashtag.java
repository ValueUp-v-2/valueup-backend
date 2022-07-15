package com.valueup.backend.hashtag.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@Getter
public class Hashtag {

    @Id
    @GeneratedValue
    @Column(name = "hashtag_id")
    private Long id; //해시태그 번호

    @Column(name = "hashtag_content")
    private String content; //해시태그 이름

    @OneToMany(mappedBy = "announcement", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<HashtagPost> hashtagPosts = new ArrayList<>();
}
