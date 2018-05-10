package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class Outbound {
    public static final Adapter<Outbound, Builder> ADAPTER = new OutboundAdapter();
    public final String url;

    public static final class Builder implements StructBuilder<Outbound> {
        private String url;

        public Builder(Outbound outbound) {
            this.url = outbound.url;
        }

        public final Builder url(String str) {
            if (str == null) {
                throw new NullPointerException("Required field 'url' cannot be null");
            }
            this.url = str;
            return this;
        }

        public final Outbound build() {
            if (this.url != null) {
                return new Outbound();
            }
            throw new IllegalStateException("Required field 'url' is missing");
        }

        public final void reset() {
            this.url = null;
        }
    }

    private static final class OutboundAdapter implements Adapter<Outbound, Builder> {
        private OutboundAdapter() {
        }

        public final void write(Protocol protocol, Outbound outbound) throws IOException {
            protocol.mo2638a(1, (byte) 11);
            protocol.mo2640a(outbound.url);
            protocol.mo2634a();
        }

        public final Outbound read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b == (byte) 0) {
                    return builder.build();
                }
                if (b.f10037c != (short) 1) {
                    ProtocolUtil.m8514a(protocol, b.f10036b);
                } else if (b.f10036b == (byte) 11) {
                    builder.url(protocol.mo2652l());
                } else {
                    ProtocolUtil.m8514a(protocol, b.f10036b);
                }
            }
        }

        public final Outbound read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private Outbound(Builder builder) {
        this.url = builder.url;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Outbound)) {
            return false;
        }
        Outbound outbound = (Outbound) obj;
        if (this.url != outbound.url) {
            if (this.url.equals(outbound.url) == null) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return (this.url.hashCode() ^ 16777619) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Outbound{url=");
        stringBuilder.append(this.url);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
