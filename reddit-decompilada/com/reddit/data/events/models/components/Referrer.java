package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class Referrer {
    public static final Adapter<Referrer, Builder> ADAPTER = new ReferrerAdapter();
    public final String domain;
    public final String element;
    public final String url;

    public static final class Builder implements StructBuilder<Referrer> {
        private String domain;
        private String element;
        private String url;

        public Builder(Referrer referrer) {
            this.domain = referrer.domain;
            this.url = referrer.url;
            this.element = referrer.element;
        }

        public final Builder domain(String str) {
            this.domain = str;
            return this;
        }

        public final Builder url(String str) {
            this.url = str;
            return this;
        }

        public final Builder element(String str) {
            this.element = str;
            return this;
        }

        public final Referrer build() {
            return new Referrer();
        }

        public final void reset() {
            this.domain = null;
            this.url = null;
            this.element = null;
        }
    }

    private static final class ReferrerAdapter implements Adapter<Referrer, Builder> {
        private ReferrerAdapter() {
        }

        public final void write(Protocol protocol, Referrer referrer) throws IOException {
            if (referrer.domain != null) {
                protocol.mo2638a(1, (byte) 11);
                protocol.mo2640a(referrer.domain);
            }
            if (referrer.url != null) {
                protocol.mo2638a(2, (byte) 11);
                protocol.mo2640a(referrer.url);
            }
            if (referrer.element != null) {
                protocol.mo2638a(3, (byte) 11);
                protocol.mo2640a(referrer.element);
            }
            protocol.mo2634a();
        }

        public final Referrer read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b != (byte) 0) {
                    switch (b.f10037c) {
                        case (short) 1:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.domain(protocol.mo2652l());
                            break;
                        case (short) 2:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.url(protocol.mo2652l());
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.element(protocol.mo2652l());
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final Referrer read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private Referrer(Builder builder) {
        this.domain = builder.domain;
        this.url = builder.url;
        this.element = builder.element;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Referrer)) {
            return false;
        }
        Referrer referrer = (Referrer) obj;
        if ((this.domain == referrer.domain || (this.domain != null && this.domain.equals(referrer.domain))) && (this.url == referrer.url || (this.url != null && this.url.equals(referrer.url)))) {
            if (this.element != referrer.element) {
                if (!(this.element == null || this.element.equals(referrer.element) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((this.domain == null ? 0 : this.domain.hashCode()) ^ 16777619) * -2128831035) ^ (this.url == null ? 0 : this.url.hashCode())) * -2128831035;
        if (this.element != null) {
            i = this.element.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Referrer{domain=");
        stringBuilder.append(this.domain);
        stringBuilder.append(", url=");
        stringBuilder.append(this.url);
        stringBuilder.append(", element=");
        stringBuilder.append(this.element);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
