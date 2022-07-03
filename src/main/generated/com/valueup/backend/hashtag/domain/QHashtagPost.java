package com.valueup.backend.hashtag.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QHashtagPost is a Querydsl query type for HashtagPost
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHashtagPost extends EntityPathBase<HashtagPost> {

    private static final long serialVersionUID = 721834285L;

    public static final QHashtagPost hashtagPost = new QHashtagPost("hashtagPost");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QHashtagPost(String variable) {
        super(HashtagPost.class, forVariable(variable));
    }

    public QHashtagPost(Path<? extends HashtagPost> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHashtagPost(PathMetadata metadata) {
        super(HashtagPost.class, metadata);
    }

}

