package com.valueup.backend.hashtag.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
}
