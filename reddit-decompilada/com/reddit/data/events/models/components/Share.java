package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class Share {
    public static final Adapter<Share, Builder> ADAPTER = new ShareAdapter();
    public final String target;

    public static final class Builder implements StructBuilder<Share> {
        private String target;

        public Builder(Share share) {
            this.target = share.target;
        }

        public final Builder target(String str) {
            this.target = str;
            return this;
        }

        public final Share build() {
            return new Share();
        }

        public final void reset() {
            this.target = null;
        }
    }

    private static final class ShareAdapter implements Adapter<Share, Builder> {
        private ShareAdapter() {
        }

        public final void write(Protocol protocol, Share share) throws IOException {
            if (share.target != null) {
                protocol.mo2638a(1, (byte) 11);
                protocol.mo2640a(share.target);
            }
            protocol.mo2634a();
        }

        public final Share read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b == (byte) 0) {
                    return builder.build();
                }
                if (b.f10037c != (short) 1) {
                    ProtocolUtil.m8514a(protocol, b.f10036b);
                } else if (b.f10036b == (byte) 11) {
                    builder.target(protocol.mo2652l());
                } else {
                    ProtocolUtil.m8514a(protocol, b.f10036b);
                }
            }
        }

        public final Share read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private Share(Builder builder) {
        this.target = builder.target;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Share)) {
            return false;
        }
        Share share = (Share) obj;
        if (this.target != share.target) {
            if (this.target == null || this.target.equals(share.target) == null) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return ((this.target == null ? 0 : this.target.hashCode()) ^ 16777619) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Share{target=");
        stringBuilder.append(this.target);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
