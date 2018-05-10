package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class Subreddit {
    public static final Adapter<Subreddit, Builder> ADAPTER = new SubredditAdapter();
    public final String category_name;
    public final String id;
    public final String name;

    public static final class Builder implements StructBuilder<Subreddit> {
        private String category_name;
        private String id;
        private String name;

        public Builder(Subreddit subreddit) {
            this.id = subreddit.id;
            this.name = subreddit.name;
            this.category_name = subreddit.category_name;
        }

        public final Builder id(String str) {
            this.id = str;
            return this;
        }

        public final Builder name(String str) {
            this.name = str;
            return this;
        }

        public final Builder category_name(String str) {
            this.category_name = str;
            return this;
        }

        public final Subreddit build() {
            return new Subreddit();
        }

        public final void reset() {
            this.id = null;
            this.name = null;
            this.category_name = null;
        }
    }

    private static final class SubredditAdapter implements Adapter<Subreddit, Builder> {
        private SubredditAdapter() {
        }

        public final void write(Protocol protocol, Subreddit subreddit) throws IOException {
            if (subreddit.id != null) {
                protocol.mo2638a(1, (byte) 11);
                protocol.mo2640a(subreddit.id);
            }
            if (subreddit.name != null) {
                protocol.mo2638a(2, (byte) 11);
                protocol.mo2640a(subreddit.name);
            }
            if (subreddit.category_name != null) {
                protocol.mo2638a(3, (byte) 11);
                protocol.mo2640a(subreddit.category_name);
            }
            protocol.mo2634a();
        }

        public final Subreddit read(Protocol protocol, Builder builder) throws IOException {
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
                            builder.name(protocol.mo2652l());
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.category_name(protocol.mo2652l());
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final Subreddit read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private Subreddit(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.category_name = builder.category_name;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Subreddit)) {
            return false;
        }
        Subreddit subreddit = (Subreddit) obj;
        if ((this.id == subreddit.id || (this.id != null && this.id.equals(subreddit.id))) && (this.name == subreddit.name || (this.name != null && this.name.equals(subreddit.name)))) {
            if (this.category_name != subreddit.category_name) {
                if (!(this.category_name == null || this.category_name.equals(subreddit.category_name) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((this.id == null ? 0 : this.id.hashCode()) ^ 16777619) * -2128831035) ^ (this.name == null ? 0 : this.name.hashCode())) * -2128831035;
        if (this.category_name != null) {
            i = this.category_name.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Subreddit{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", category_name=");
        stringBuilder.append(this.category_name);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
