package com.valueup.backend.image.domain;

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
public class Image {

    @Id
    @GeneratedValue
    @Column(name = "image_id")
    private Long id; //이미지 번호

    @Column(name = "image_filename")
    private String filename; //파일이름

    @Column(name = "image_isCommunity")
    private boolean isCommunity;


}
