package com.valueup.backend.post.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@DiscriminatorValue("A")// 구분자 상의해보기
@Getter
public class Community extends Post {

    @Column(name = "community_likes")
    private int likes;//좋아요 수

    //카테고리 따로 테이블 생성??? enum처리????
}
