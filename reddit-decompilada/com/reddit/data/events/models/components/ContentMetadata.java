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

public final class ContentMetadata {
    public static final Adapter<ContentMetadata, Builder> ADAPTER = new ContentMetadataAdapter();
    public final List<String> categories;
    public final Boolean is_nsfw;
    public final Boolean is_quarantined;

    public static final class Builder implements StructBuilder<ContentMetadata> {
        private List<String> categories;
        private Boolean is_nsfw;
        private Boolean is_quarantined;

        public Builder(ContentMetadata contentMetadata) {
            this.is_quarantined = contentMetadata.is_quarantined;
            this.is_nsfw = contentMetadata.is_nsfw;
            this.categories = contentMetadata.categories;
        }

        public final Builder is_quarantined(Boolean bool) {
            this.is_quarantined = bool;
            return this;
        }

        public final Builder is_nsfw(Boolean bool) {
            this.is_nsfw = bool;
            return this;
        }

        public final Builder categories(List<String> list) {
            this.categories = list;
            return this;
        }

        public final ContentMetadata build() {
            return new ContentMetadata();
        }

        public final void reset() {
            this.is_quarantined = null;
            this.is_nsfw = null;
            this.categories = null;
        }
    }

    private static final class ContentMetadataAdapter implements Adapter<ContentMetadata, Builder> {
        private ContentMetadataAdapter() {
        }

        public final void write(Protocol protocol, ContentMetadata contentMetadata) throws IOException {
            if (contentMetadata.is_quarantined != null) {
                protocol.mo2638a(1, (byte) 2);
                protocol.mo2641a(contentMetadata.is_quarantined.booleanValue());
            }
            if (contentMetadata.is_nsfw != null) {
                protocol.mo2638a(2, (byte) 2);
                protocol.mo2641a(contentMetadata.is_nsfw.booleanValue());
            }
            if (contentMetadata.categories != null) {
                protocol.mo2638a(3, (byte) 15);
                protocol.mo2635a((byte) 11, contentMetadata.categories.size());
                for (String a : contentMetadata.categories) {
                    protocol.mo2640a(a);
                }
            }
            protocol.mo2634a();
        }

        public final ContentMetadata read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b != (byte) 0) {
                    switch (b.f10037c) {
                        case (short) 1:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.is_quarantined(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 2:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.is_nsfw(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 15) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            ListMetadata d = protocol.mo2644d();
                            List arrayList = new ArrayList(d.f10039b);
                            for (int i = 0; i < d.f10039b; i++) {
                                arrayList.add(protocol.mo2652l());
                            }
                            builder.categories(arrayList);
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final ContentMetadata read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private ContentMetadata(Builder builder) {
        this.is_quarantined = builder.is_quarantined;
        this.is_nsfw = builder.is_nsfw;
        this.categories = builder.categories == null ? null : Collections.unmodifiableList(builder.categories);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ContentMetadata)) {
            return false;
        }
        ContentMetadata contentMetadata = (ContentMetadata) obj;
        if ((this.is_quarantined == contentMetadata.is_quarantined || (this.is_quarantined != null && this.is_quarantined.equals(contentMetadata.is_quarantined))) && (this.is_nsfw == contentMetadata.is_nsfw || (this.is_nsfw != null && this.is_nsfw.equals(contentMetadata.is_nsfw)))) {
            if (this.categories != contentMetadata.categories) {
                if (!(this.categories == null || this.categories.equals(contentMetadata.categories) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((this.is_quarantined == null ? 0 : this.is_quarantined.hashCode()) ^ 16777619) * -2128831035) ^ (this.is_nsfw == null ? 0 : this.is_nsfw.hashCode())) * -2128831035;
        if (this.categories != null) {
            i = this.categories.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ContentMetadata{is_quarantined=");
        stringBuilder.append(this.is_quarantined);
        stringBuilder.append(", is_nsfw=");
        stringBuilder.append(this.is_nsfw);
        stringBuilder.append(", categories=");
        stringBuilder.append(this.categories);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
