package com.valueup.backend.post.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCommunity is a Querydsl query type for Community
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCommunity extends EntityPathBase<Community> {

    private static final long serialVersionUID = 328485252L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCommunity community = new QCommunity("community");

    public final QPost _super;

    //inherited
    public final StringPath content;

    //inherited
    public final NumberPath<Long> id;

    public final NumberPath<Integer> likes = createNumber("likes", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate;

    //inherited
    public final StringPath name;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate;

    // inherited
    public final com.valueup.backend.user.domain.QUser user;

    //inherited
    public final NumberPath<Integer> views;

    public QCommunity(String variable) {
        this(Community.class, forVariable(variable), INITS);
    }

    public QCommunity(Path<? extends Community> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCommunity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCommunity(PathMetadata metadata, PathInits inits) {
        this(Community.class, metadata, inits);
    }

    public QCommunity(Class<? extends Community> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QPost(type, metadata, inits);
        this.content = _super.content;
        this.id = _super.id;
        this.modDate = _super.modDate;
        this.name = _super.name;
        this.regDate = _super.regDate;
        this.user = _super.user;
        this.views = _super.views;
    }

}

