package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class LinkSharing {
    public static final Adapter<LinkSharing, Builder> ADAPTER = new LinkSharingAdapter();
    public final Long shared_at_timestamp;

    public static final class Builder implements StructBuilder<LinkSharing> {
        private Long shared_at_timestamp;

        public Builder(LinkSharing linkSharing) {
            this.shared_at_timestamp = linkSharing.shared_at_timestamp;
        }

        public final Builder shared_at_timestamp(Long l) {
            this.shared_at_timestamp = l;
            return this;
        }

        public final LinkSharing build() {
            return new LinkSharing();
        }

        public final void reset() {
            this.shared_at_timestamp = null;
        }
    }

    private static final class LinkSharingAdapter implements Adapter<LinkSharing, Builder> {
        private LinkSharingAdapter() {
        }

        public final void write(Protocol protocol, LinkSharing linkSharing) throws IOException {
            if (linkSharing.shared_at_timestamp != null) {
                protocol.mo2638a(1, (byte) 10);
                protocol.mo2639a(linkSharing.shared_at_timestamp.longValue());
            }
            protocol.mo2634a();
        }

        public final LinkSharing read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b == (byte) 0) {
                    return builder.build();
                }
                if (b.f10037c != (short) 1) {
                    ProtocolUtil.m8514a(protocol, b.f10036b);
                } else if (b.f10036b == (byte) 10) {
                    builder.shared_at_timestamp(Long.valueOf(protocol.mo2650j()));
                } else {
                    ProtocolUtil.m8514a(protocol, b.f10036b);
                }
            }
        }

        public final LinkSharing read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private LinkSharing(Builder builder) {
        this.shared_at_timestamp = builder.shared_at_timestamp;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof LinkSharing)) {
            return false;
        }
        LinkSharing linkSharing = (LinkSharing) obj;
        if (this.shared_at_timestamp != linkSharing.shared_at_timestamp) {
            if (this.shared_at_timestamp == null || this.shared_at_timestamp.equals(linkSharing.shared_at_timestamp) == null) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return ((this.shared_at_timestamp == null ? 0 : this.shared_at_timestamp.hashCode()) ^ 16777619) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("LinkSharing{shared_at_timestamp=");
        stringBuilder.append(this.shared_at_timestamp);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
