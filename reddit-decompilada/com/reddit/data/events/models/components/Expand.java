package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class Expand {
    public static final Adapter<Expand, Builder> ADAPTER = new ExpandAdapter();
    public final String provider;

    public static final class Builder implements StructBuilder<Expand> {
        private String provider;

        public Builder(Expand expand) {
            this.provider = expand.provider;
        }

        public final Builder provider(String str) {
            this.provider = str;
            return this;
        }

        public final Expand build() {
            return new Expand();
        }

        public final void reset() {
            this.provider = null;
        }
    }

    private static final class ExpandAdapter implements Adapter<Expand, Builder> {
        private ExpandAdapter() {
        }

        public final void write(Protocol protocol, Expand expand) throws IOException {
            if (expand.provider != null) {
                protocol.mo2638a(1, (byte) 11);
                protocol.mo2640a(expand.provider);
            }
            protocol.mo2634a();
        }

        public final Expand read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b == (byte) 0) {
                    return builder.build();
                }
                if (b.f10037c != (short) 1) {
                    ProtocolUtil.m8514a(protocol, b.f10036b);
                } else if (b.f10036b == (byte) 11) {
                    builder.provider(protocol.mo2652l());
                } else {
                    ProtocolUtil.m8514a(protocol, b.f10036b);
                }
            }
        }

        public final Expand read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private Expand(Builder builder) {
        this.provider = builder.provider;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Expand)) {
            return false;
        }
        Expand expand = (Expand) obj;
        if (this.provider != expand.provider) {
            if (this.provider == null || this.provider.equals(expand.provider) == null) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return ((this.provider == null ? 0 : this.provider.hashCode()) ^ 16777619) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Expand{provider=");
        stringBuilder.append(this.provider);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
