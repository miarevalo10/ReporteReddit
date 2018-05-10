package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.ListMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DiscoveryUnit {
    public static final Adapter<DiscoveryUnit, Builder> ADAPTER = new DiscoveryUnitAdapter();
    public final Long number_posts;
    public final Long post_position;
    public final String post_subreddit;
    public final String post_type;
    public final List<String> posts_shown;
    public final String semantic_version;
    public final String type;

    public static final class Builder implements StructBuilder<DiscoveryUnit> {
        private Long number_posts;
        private Long post_position;
        private String post_subreddit;
        private String post_type;
        private List<String> posts_shown;
        private String semantic_version;
        private String type;

        public Builder(DiscoveryUnit discoveryUnit) {
            this.semantic_version = discoveryUnit.semantic_version;
            this.type = discoveryUnit.type;
            this.number_posts = discoveryUnit.number_posts;
            this.posts_shown = discoveryUnit.posts_shown;
            this.post_position = discoveryUnit.post_position;
            this.post_type = discoveryUnit.post_type;
            this.post_subreddit = discoveryUnit.post_subreddit;
        }

        public final Builder semantic_version(String str) {
            this.semantic_version = str;
            return this;
        }

        public final Builder type(String str) {
            this.type = str;
            return this;
        }

        public final Builder number_posts(Long l) {
            this.number_posts = l;
            return this;
        }

        public final Builder posts_shown(List<String> list) {
            this.posts_shown = list;
            return this;
        }

        public final Builder post_position(Long l) {
            this.post_position = l;
            return this;
        }

        public final Builder post_type(String str) {
            this.post_type = str;
            return this;
        }

        public final Builder post_subreddit(String str) {
            this.post_subreddit = str;
            return this;
        }

        public final DiscoveryUnit build() {
            return new DiscoveryUnit();
        }

        public final void reset() {
            this.semantic_version = null;
            this.type = null;
            this.number_posts = null;
            this.posts_shown = null;
            this.post_position = null;
            this.post_type = null;
            this.post_subreddit = null;
        }
    }

    private static final class DiscoveryUnitAdapter implements Adapter<DiscoveryUnit, Builder> {
        private DiscoveryUnitAdapter() {
        }

        public final void write(Protocol protocol, DiscoveryUnit discoveryUnit) throws IOException {
            if (discoveryUnit.semantic_version != null) {
                protocol.mo2638a(1, (byte) 11);
                protocol.mo2640a(discoveryUnit.semantic_version);
            }
            if (discoveryUnit.type != null) {
                protocol.mo2638a(2, (byte) 11);
                protocol.mo2640a(discoveryUnit.type);
            }
            if (discoveryUnit.number_posts != null) {
                protocol.mo2638a(3, (byte) 10);
                protocol.mo2639a(discoveryUnit.number_posts.longValue());
            }
            if (discoveryUnit.posts_shown != null) {
                protocol.mo2638a(4, (byte) 15);
                protocol.mo2635a((byte) 11, discoveryUnit.posts_shown.size());
                for (String a : discoveryUnit.posts_shown) {
                    protocol.mo2640a(a);
                }
            }
            if (discoveryUnit.post_position != null) {
                protocol.mo2638a(6, (byte) 10);
                protocol.mo2639a(discoveryUnit.post_position.longValue());
            }
            if (discoveryUnit.post_type != null) {
                protocol.mo2638a(7, (byte) 11);
                protocol.mo2640a(discoveryUnit.post_type);
            }
            if (discoveryUnit.post_subreddit != null) {
                protocol.mo2638a(8, (byte) 11);
                protocol.mo2640a(discoveryUnit.post_subreddit);
            }
            protocol.mo2634a();
        }

        public final DiscoveryUnit read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b != (byte) 0) {
                    switch (b.f10037c) {
                        case (short) 1:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.semantic_version(protocol.mo2652l());
                            break;
                        case (short) 2:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.type(protocol.mo2652l());
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.number_posts(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 4:
                            if (b.f10036b != (byte) 15) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            ListMetadata d = protocol.mo2644d();
                            List arrayList = new ArrayList(d.f10039b);
                            for (int i = 0; i < d.f10039b; i++) {
                                arrayList.add(protocol.mo2652l());
                            }
                            builder.posts_shown(arrayList);
                            break;
                        case (short) 6:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.post_position(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 7:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.post_type(protocol.mo2652l());
                            break;
                        case (short) 8:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.post_subreddit(protocol.mo2652l());
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final DiscoveryUnit read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private DiscoveryUnit(Builder builder) {
        this.semantic_version = builder.semantic_version;
        this.type = builder.type;
        this.number_posts = builder.number_posts;
        this.posts_shown = builder.posts_shown == null ? null : Collections.unmodifiableList(builder.posts_shown);
        this.post_position = builder.post_position;
        this.post_type = builder.post_type;
        this.post_subreddit = builder.post_subreddit;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DiscoveryUnit)) {
            return false;
        }
        DiscoveryUnit discoveryUnit = (DiscoveryUnit) obj;
        if ((this.semantic_version == discoveryUnit.semantic_version || (this.semantic_version != null && this.semantic_version.equals(discoveryUnit.semantic_version))) && ((this.type == discoveryUnit.type || (this.type != null && this.type.equals(discoveryUnit.type))) && ((this.number_posts == discoveryUnit.number_posts || (this.number_posts != null && this.number_posts.equals(discoveryUnit.number_posts))) && ((this.posts_shown == discoveryUnit.posts_shown || (this.posts_shown != null && this.posts_shown.equals(discoveryUnit.posts_shown))) && ((this.post_position == discoveryUnit.post_position || (this.post_position != null && this.post_position.equals(discoveryUnit.post_position))) && (this.post_type == discoveryUnit.post_type || (this.post_type != null && this.post_type.equals(discoveryUnit.post_type)))))))) {
            if (this.post_subreddit != discoveryUnit.post_subreddit) {
                if (!(this.post_subreddit == null || this.post_subreddit.equals(discoveryUnit.post_subreddit) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((((((((((this.semantic_version == null ? 0 : this.semantic_version.hashCode()) ^ 16777619) * -2128831035) ^ (this.type == null ? 0 : this.type.hashCode())) * -2128831035) ^ (this.number_posts == null ? 0 : this.number_posts.hashCode())) * -2128831035) ^ (this.posts_shown == null ? 0 : this.posts_shown.hashCode())) * -2128831035) ^ (this.post_position == null ? 0 : this.post_position.hashCode())) * -2128831035) ^ (this.post_type == null ? 0 : this.post_type.hashCode())) * -2128831035;
        if (this.post_subreddit != null) {
            i = this.post_subreddit.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("DiscoveryUnit{semantic_version=");
        stringBuilder.append(this.semantic_version);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", number_posts=");
        stringBuilder.append(this.number_posts);
        stringBuilder.append(", posts_shown=");
        stringBuilder.append(this.posts_shown);
        stringBuilder.append(", post_position=");
        stringBuilder.append(this.post_position);
        stringBuilder.append(", post_type=");
        stringBuilder.append(this.post_type);
        stringBuilder.append(", post_subreddit=");
        stringBuilder.append(this.post_subreddit);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
