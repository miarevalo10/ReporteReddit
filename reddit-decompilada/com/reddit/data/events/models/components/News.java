package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class News {
    public static final Adapter<News, Builder> ADAPTER = new NewsAdapter();
    public final String subtopic_id;
    public final String subtopic_name;
    public final String topic_id;
    public final String topic_name;

    public static final class Builder implements StructBuilder<News> {
        private String subtopic_id;
        private String subtopic_name;
        private String topic_id;
        private String topic_name;

        public Builder(News news) {
            this.topic_id = news.topic_id;
            this.topic_name = news.topic_name;
            this.subtopic_id = news.subtopic_id;
            this.subtopic_name = news.subtopic_name;
        }

        public final Builder topic_id(String str) {
            this.topic_id = str;
            return this;
        }

        public final Builder topic_name(String str) {
            this.topic_name = str;
            return this;
        }

        public final Builder subtopic_id(String str) {
            this.subtopic_id = str;
            return this;
        }

        public final Builder subtopic_name(String str) {
            this.subtopic_name = str;
            return this;
        }

        public final News build() {
            return new News();
        }

        public final void reset() {
            this.topic_id = null;
            this.topic_name = null;
            this.subtopic_id = null;
            this.subtopic_name = null;
        }
    }

    private static final class NewsAdapter implements Adapter<News, Builder> {
        private NewsAdapter() {
        }

        public final void write(Protocol protocol, News news) throws IOException {
            if (news.topic_id != null) {
                protocol.mo2638a(1, (byte) 11);
                protocol.mo2640a(news.topic_id);
            }
            if (news.topic_name != null) {
                protocol.mo2638a(2, (byte) 11);
                protocol.mo2640a(news.topic_name);
            }
            if (news.subtopic_id != null) {
                protocol.mo2638a(3, (byte) 11);
                protocol.mo2640a(news.subtopic_id);
            }
            if (news.subtopic_name != null) {
                protocol.mo2638a(4, (byte) 11);
                protocol.mo2640a(news.subtopic_name);
            }
            protocol.mo2634a();
        }

        public final News read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b != (byte) 0) {
                    switch (b.f10037c) {
                        case (short) 1:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.topic_id(protocol.mo2652l());
                            break;
                        case (short) 2:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.topic_name(protocol.mo2652l());
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.subtopic_id(protocol.mo2652l());
                            break;
                        case (short) 4:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.subtopic_name(protocol.mo2652l());
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final News read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private News(Builder builder) {
        this.topic_id = builder.topic_id;
        this.topic_name = builder.topic_name;
        this.subtopic_id = builder.subtopic_id;
        this.subtopic_name = builder.subtopic_name;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof News)) {
            return false;
        }
        News news = (News) obj;
        if ((this.topic_id == news.topic_id || (this.topic_id != null && this.topic_id.equals(news.topic_id))) && ((this.topic_name == news.topic_name || (this.topic_name != null && this.topic_name.equals(news.topic_name))) && (this.subtopic_id == news.subtopic_id || (this.subtopic_id != null && this.subtopic_id.equals(news.subtopic_id))))) {
            if (this.subtopic_name != news.subtopic_name) {
                if (!(this.subtopic_name == null || this.subtopic_name.equals(news.subtopic_name) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((((this.topic_id == null ? 0 : this.topic_id.hashCode()) ^ 16777619) * -2128831035) ^ (this.topic_name == null ? 0 : this.topic_name.hashCode())) * -2128831035) ^ (this.subtopic_id == null ? 0 : this.subtopic_id.hashCode())) * -2128831035;
        if (this.subtopic_name != null) {
            i = this.subtopic_name.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("News{topic_id=");
        stringBuilder.append(this.topic_id);
        stringBuilder.append(", topic_name=");
        stringBuilder.append(this.topic_name);
        stringBuilder.append(", subtopic_id=");
        stringBuilder.append(this.subtopic_id);
        stringBuilder.append(", subtopic_name=");
        stringBuilder.append(this.subtopic_name);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
