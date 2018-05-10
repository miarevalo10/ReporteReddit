package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class Post {
    public static final Adapter<Post, Builder> ADAPTER = new PostAdapter();
    public final Boolean archived;
    public final String author_id;
    public final String body_text;
    public final Long content_duration;
    public final Long created_timestamp;
    public final String crosspost_root_id;
    public final String domain;
    public final String id;
    public final Boolean nsfw;
    public final Long number_gildings;
    public final Boolean promoted;
    public final Boolean spoiler;
    public final String title;
    public final String type;
    public final String url;

    public static final class Builder implements StructBuilder<Post> {
        private Boolean archived;
        private String author_id;
        private String body_text;
        private Long content_duration;
        private Long created_timestamp;
        private String crosspost_root_id;
        private String domain;
        private String id;
        private Boolean nsfw;
        private Long number_gildings;
        private Boolean promoted;
        private Boolean spoiler;
        private String title;
        private String type;
        private String url;

        public Builder(Post post) {
            this.id = post.id;
            this.type = post.type;
            this.title = post.title;
            this.nsfw = post.nsfw;
            this.spoiler = post.spoiler;
            this.url = post.url;
            this.domain = post.domain;
            this.body_text = post.body_text;
            this.created_timestamp = post.created_timestamp;
            this.promoted = post.promoted;
            this.author_id = post.author_id;
            this.content_duration = post.content_duration;
            this.archived = post.archived;
            this.crosspost_root_id = post.crosspost_root_id;
            this.number_gildings = post.number_gildings;
        }

        public final Builder id(String str) {
            if (str == null) {
                throw new NullPointerException("Required field 'id' cannot be null");
            }
            this.id = str;
            return this;
        }

        public final Builder type(String str) {
            this.type = str;
            return this;
        }

        public final Builder title(String str) {
            this.title = str;
            return this;
        }

        public final Builder nsfw(Boolean bool) {
            this.nsfw = bool;
            return this;
        }

        public final Builder spoiler(Boolean bool) {
            this.spoiler = bool;
            return this;
        }

        public final Builder url(String str) {
            this.url = str;
            return this;
        }

        public final Builder domain(String str) {
            this.domain = str;
            return this;
        }

        public final Builder body_text(String str) {
            this.body_text = str;
            return this;
        }

        public final Builder created_timestamp(Long l) {
            this.created_timestamp = l;
            return this;
        }

        public final Builder promoted(Boolean bool) {
            this.promoted = bool;
            return this;
        }

        public final Builder author_id(String str) {
            this.author_id = str;
            return this;
        }

        public final Builder content_duration(Long l) {
            this.content_duration = l;
            return this;
        }

        public final Builder archived(Boolean bool) {
            this.archived = bool;
            return this;
        }

        public final Builder crosspost_root_id(String str) {
            this.crosspost_root_id = str;
            return this;
        }

        public final Builder number_gildings(Long l) {
            this.number_gildings = l;
            return this;
        }

        public final Post build() {
            if (this.id != null) {
                return new Post();
            }
            throw new IllegalStateException("Required field 'id' is missing");
        }

        public final void reset() {
            this.id = null;
            this.type = null;
            this.title = null;
            this.nsfw = null;
            this.spoiler = null;
            this.url = null;
            this.domain = null;
            this.body_text = null;
            this.created_timestamp = null;
            this.promoted = null;
            this.author_id = null;
            this.content_duration = null;
            this.archived = null;
            this.crosspost_root_id = null;
            this.number_gildings = null;
        }
    }

    private static final class PostAdapter implements Adapter<Post, Builder> {
        private PostAdapter() {
        }

        public final void write(Protocol protocol, Post post) throws IOException {
            protocol.mo2638a(1, (byte) 11);
            protocol.mo2640a(post.id);
            if (post.type != null) {
                protocol.mo2638a(2, (byte) 11);
                protocol.mo2640a(post.type);
            }
            if (post.title != null) {
                protocol.mo2638a(3, (byte) 11);
                protocol.mo2640a(post.title);
            }
            if (post.nsfw != null) {
                protocol.mo2638a(4, (byte) 2);
                protocol.mo2641a(post.nsfw.booleanValue());
            }
            if (post.spoiler != null) {
                protocol.mo2638a(5, (byte) 2);
                protocol.mo2641a(post.spoiler.booleanValue());
            }
            if (post.url != null) {
                protocol.mo2638a(6, (byte) 11);
                protocol.mo2640a(post.url);
            }
            if (post.domain != null) {
                protocol.mo2638a(7, (byte) 11);
                protocol.mo2640a(post.domain);
            }
            if (post.body_text != null) {
                protocol.mo2638a(8, (byte) 11);
                protocol.mo2640a(post.body_text);
            }
            if (post.created_timestamp != null) {
                protocol.mo2638a(9, (byte) 10);
                protocol.mo2639a(post.created_timestamp.longValue());
            }
            if (post.promoted != null) {
                protocol.mo2638a(10, (byte) 2);
                protocol.mo2641a(post.promoted.booleanValue());
            }
            if (post.author_id != null) {
                protocol.mo2638a(11, (byte) 11);
                protocol.mo2640a(post.author_id);
            }
            if (post.content_duration != null) {
                protocol.mo2638a(12, (byte) 10);
                protocol.mo2639a(post.content_duration.longValue());
            }
            if (post.archived != null) {
                protocol.mo2638a(13, (byte) 2);
                protocol.mo2641a(post.archived.booleanValue());
            }
            if (post.crosspost_root_id != null) {
                protocol.mo2638a(14, (byte) 11);
                protocol.mo2640a(post.crosspost_root_id);
            }
            if (post.number_gildings != null) {
                protocol.mo2638a(15, (byte) 10);
                protocol.mo2639a(post.number_gildings.longValue());
            }
            protocol.mo2634a();
        }

        public final Post read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b != (byte) 0) {
                    switch (b.f10037c) {
                        case (short) 1:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.id(protocol.mo2652l());
                            break;
                        case (short) 2:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.type(protocol.mo2652l());
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.title(protocol.mo2652l());
                            break;
                        case (short) 4:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.nsfw(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 5:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.spoiler(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 6:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.url(protocol.mo2652l());
                            break;
                        case (short) 7:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.domain(protocol.mo2652l());
                            break;
                        case (short) 8:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.body_text(protocol.mo2652l());
                            break;
                        case (short) 9:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.created_timestamp(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 10:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.promoted(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 11:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.author_id(protocol.mo2652l());
                            break;
                        case (short) 12:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.content_duration(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 13:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.archived(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 14:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.crosspost_root_id(protocol.mo2652l());
                            break;
                        case (short) 15:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.number_gildings(Long.valueOf(protocol.mo2650j()));
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final Post read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private Post(Builder builder) {
        this.id = builder.id;
        this.type = builder.type;
        this.title = builder.title;
        this.nsfw = builder.nsfw;
        this.spoiler = builder.spoiler;
        this.url = builder.url;
        this.domain = builder.domain;
        this.body_text = builder.body_text;
        this.created_timestamp = builder.created_timestamp;
        this.promoted = builder.promoted;
        this.author_id = builder.author_id;
        this.content_duration = builder.content_duration;
        this.archived = builder.archived;
        this.crosspost_root_id = builder.crosspost_root_id;
        this.number_gildings = builder.number_gildings;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Post)) {
            return false;
        }
        Post post = (Post) obj;
        if ((this.id == post.id || this.id.equals(post.id)) && ((this.type == post.type || (this.type != null && this.type.equals(post.type))) && ((this.title == post.title || (this.title != null && this.title.equals(post.title))) && ((this.nsfw == post.nsfw || (this.nsfw != null && this.nsfw.equals(post.nsfw))) && ((this.spoiler == post.spoiler || (this.spoiler != null && this.spoiler.equals(post.spoiler))) && ((this.url == post.url || (this.url != null && this.url.equals(post.url))) && ((this.domain == post.domain || (this.domain != null && this.domain.equals(post.domain))) && ((this.body_text == post.body_text || (this.body_text != null && this.body_text.equals(post.body_text))) && ((this.created_timestamp == post.created_timestamp || (this.created_timestamp != null && this.created_timestamp.equals(post.created_timestamp))) && ((this.promoted == post.promoted || (this.promoted != null && this.promoted.equals(post.promoted))) && ((this.author_id == post.author_id || (this.author_id != null && this.author_id.equals(post.author_id))) && ((this.content_duration == post.content_duration || (this.content_duration != null && this.content_duration.equals(post.content_duration))) && ((this.archived == post.archived || (this.archived != null && this.archived.equals(post.archived))) && (this.crosspost_root_id == post.crosspost_root_id || (this.crosspost_root_id != null && this.crosspost_root_id.equals(post.crosspost_root_id)))))))))))))))) {
            if (this.number_gildings != post.number_gildings) {
                if (!(this.number_gildings == null || this.number_gildings.equals(post.number_gildings) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((((((((((((((((((this.id.hashCode() ^ 16777619) * -2128831035) ^ (this.type == null ? 0 : this.type.hashCode())) * -2128831035) ^ (this.title == null ? 0 : this.title.hashCode())) * -2128831035) ^ (this.nsfw == null ? 0 : this.nsfw.hashCode())) * -2128831035) ^ (this.spoiler == null ? 0 : this.spoiler.hashCode())) * -2128831035) ^ (this.url == null ? 0 : this.url.hashCode())) * -2128831035) ^ (this.domain == null ? 0 : this.domain.hashCode())) * -2128831035) ^ (this.body_text == null ? 0 : this.body_text.hashCode())) * -2128831035) ^ (this.created_timestamp == null ? 0 : this.created_timestamp.hashCode())) * -2128831035) ^ (this.promoted == null ? 0 : this.promoted.hashCode())) * -2128831035) ^ (this.author_id == null ? 0 : this.author_id.hashCode())) * -2128831035) ^ (this.content_duration == null ? 0 : this.content_duration.hashCode())) * -2128831035) ^ (this.archived == null ? 0 : this.archived.hashCode())) * -2128831035) ^ (this.crosspost_root_id == null ? 0 : this.crosspost_root_id.hashCode())) * -2128831035;
        if (this.number_gildings != null) {
            i = this.number_gildings.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Post{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", title=");
        stringBuilder.append(this.title);
        stringBuilder.append(", nsfw=");
        stringBuilder.append(this.nsfw);
        stringBuilder.append(", spoiler=");
        stringBuilder.append(this.spoiler);
        stringBuilder.append(", url=");
        stringBuilder.append(this.url);
        stringBuilder.append(", domain=");
        stringBuilder.append(this.domain);
        stringBuilder.append(", body_text=");
        stringBuilder.append(this.body_text);
        stringBuilder.append(", created_timestamp=");
        stringBuilder.append(this.created_timestamp);
        stringBuilder.append(", promoted=");
        stringBuilder.append(this.promoted);
        stringBuilder.append(", author_id=");
        stringBuilder.append(this.author_id);
        stringBuilder.append(", content_duration=");
        stringBuilder.append(this.content_duration);
        stringBuilder.append(", archived=");
        stringBuilder.append(this.archived);
        stringBuilder.append(", crosspost_root_id=");
        stringBuilder.append(this.crosspost_root_id);
        stringBuilder.append(", number_gildings=");
        stringBuilder.append(this.number_gildings);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
