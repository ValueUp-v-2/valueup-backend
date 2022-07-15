package com.valueup.backend.post.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAnnouncement is a Querydsl query type for Announcement
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAnnouncement extends EntityPathBase<Announcement> {

    private static final long serialVersionUID = -489879092L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAnnouncement announcement = new QAnnouncement("announcement");

    public final QPost _super;

    //inherited
    public final StringPath content;

    public final DateTimePath<java.time.LocalDateTime> endDate = createDateTime("endDate", java.time.LocalDateTime.class);

    public final ListPath<com.valueup.backend.hashtag.domain.HashtagPost, com.valueup.backend.hashtag.domain.QHashtagPost> hashtagPosts = this.<com.valueup.backend.hashtag.domain.HashtagPost, com.valueup.backend.hashtag.domain.QHashtagPost>createList("hashtagPosts", com.valueup.backend.hashtag.domain.HashtagPost.class, com.valueup.backend.hashtag.domain.QHashtagPost.class, PathInits.DIRECT2);

    //inherited
    public final NumberPath<Long> id;

    public final EnumPath<AnnouncementKind> kind = createEnum("kind", AnnouncementKind.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate;

    //inherited
    public final StringPath name;

    public final NumberPath<Integer> period = createNumber("period", Integer.class);

    public final NumberPath<Integer> recruitment = createNumber("recruitment", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate;

    public final DateTimePath<java.time.LocalDateTime> starDate = createDateTime("starDate", java.time.LocalDateTime.class);

    public final StringPath url = createString("url");

    // inherited
    public final com.valueup.backend.user.domain.QUser user;

    //inherited
    public final NumberPath<Integer> views;

    public QAnnouncement(String variable) {
        this(Announcement.class, forVariable(variable), INITS);
    }

    public QAnnouncement(Path<? extends Announcement> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAnnouncement(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAnnouncement(PathMetadata metadata, PathInits inits) {
        this(Announcement.class, metadata, inits);
    }

    public QAnnouncement(Class<? extends Announcement> type, PathMetadata metadata, PathInits inits) {
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

