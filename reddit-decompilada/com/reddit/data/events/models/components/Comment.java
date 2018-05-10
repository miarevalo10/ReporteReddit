package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class Comment {
    public static final Adapter<Comment, Builder> ADAPTER = new CommentAdapter();
    public final String author_id;
    public final String body_text;
    public final String id;
    public final Long number_gildings;
    public final String parent_id;
    public final String post_id;

    public static final class Builder implements StructBuilder<Comment> {
        private String author_id;
        private String body_text;
        private String id;
        private Long number_gildings;
        private String parent_id;
        private String post_id;

        public Builder(Comment comment) {
            this.id = comment.id;
            this.post_id = comment.post_id;
            this.parent_id = comment.parent_id;
            this.body_text = comment.body_text;
            this.author_id = comment.author_id;
            this.number_gildings = comment.number_gildings;
        }

        public final Builder id(String str) {
            if (str == null) {
                throw new NullPointerException("Required field 'id' cannot be null");
            }
            this.id = str;
            return this;
        }

        public final Builder post_id(String str) {
            this.post_id = str;
            return this;
        }

        public final Builder parent_id(String str) {
            this.parent_id = str;
            return this;
        }

        public final Builder body_text(String str) {
            this.body_text = str;
            return this;
        }

        public final Builder author_id(String str) {
            this.author_id = str;
            return this;
        }

        public final Builder number_gildings(Long l) {
            this.number_gildings = l;
            return this;
        }

        public final Comment build() {
            if (this.id != null) {
                return new Comment();
            }
            throw new IllegalStateException("Required field 'id' is missing");
        }

        public final void reset() {
            this.id = null;
            this.post_id = null;
            this.parent_id = null;
            this.body_text = null;
            this.author_id = null;
            this.number_gildings = null;
        }
    }

    private static final class CommentAdapter implements Adapter<Comment, Builder> {
        private CommentAdapter() {
        }

        public final void write(Protocol protocol, Comment comment) throws IOException {
            protocol.mo2638a(1, (byte) 11);
            protocol.mo2640a(comment.id);
            if (comment.post_id != null) {
                protocol.mo2638a(2, (byte) 11);
                protocol.mo2640a(comment.post_id);
            }
            if (comment.parent_id != null) {
                protocol.mo2638a(3, (byte) 11);
                protocol.mo2640a(comment.parent_id);
            }
            if (comment.body_text != null) {
                protocol.mo2638a(4, (byte) 11);
                protocol.mo2640a(comment.body_text);
            }
            if (comment.author_id != null) {
                protocol.mo2638a(5, (byte) 11);
                protocol.mo2640a(comment.author_id);
            }
            if (comment.number_gildings != null) {
                protocol.mo2638a(6, (byte) 10);
                protocol.mo2639a(comment.number_gildings.longValue());
            }
            protocol.mo2634a();
        }

        public final Comment read(Protocol protocol, Builder builder) throws IOException {
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
                            builder.post_id(protocol.mo2652l());
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.parent_id(protocol.mo2652l());
                            break;
                        case (short) 4:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.body_text(protocol.mo2652l());
                            break;
                        case (short) 5:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.author_id(protocol.mo2652l());
                            break;
                        case (short) 6:
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

        public final Comment read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private Comment(Builder builder) {
        this.id = builder.id;
        this.post_id = builder.post_id;
        this.parent_id = builder.parent_id;
        this.body_text = builder.body_text;
        this.author_id = builder.author_id;
        this.number_gildings = builder.number_gildings;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Comment)) {
            return false;
        }
        Comment comment = (Comment) obj;
        if ((this.id == comment.id || this.id.equals(comment.id)) && ((this.post_id == comment.post_id || (this.post_id != null && this.post_id.equals(comment.post_id))) && ((this.parent_id == comment.parent_id || (this.parent_id != null && this.parent_id.equals(comment.parent_id))) && ((this.body_text == comment.body_text || (this.body_text != null && this.body_text.equals(comment.body_text))) && (this.author_id == comment.author_id || (this.author_id != null && this.author_id.equals(comment.author_id))))))) {
            if (this.number_gildings != comment.number_gildings) {
                if (!(this.number_gildings == null || this.number_gildings.equals(comment.number_gildings) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((this.id.hashCode() ^ 16777619) * -2128831035) ^ (this.post_id == null ? 0 : this.post_id.hashCode())) * -2128831035) ^ (this.parent_id == null ? 0 : this.parent_id.hashCode())) * -2128831035) ^ (this.body_text == null ? 0 : this.body_text.hashCode())) * -2128831035) ^ (this.author_id == null ? 0 : this.author_id.hashCode())) * -2128831035;
        if (this.number_gildings != null) {
            i = this.number_gildings.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Comment{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", post_id=");
        stringBuilder.append(this.post_id);
        stringBuilder.append(", parent_id=");
        stringBuilder.append(this.parent_id);
        stringBuilder.append(", body_text=");
        stringBuilder.append(this.body_text);
        stringBuilder.append(", author_id=");
        stringBuilder.append(this.author_id);
        stringBuilder.append(", number_gildings=");
        stringBuilder.append(this.number_gildings);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
