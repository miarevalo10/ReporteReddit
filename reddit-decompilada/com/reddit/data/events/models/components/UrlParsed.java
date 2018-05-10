package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class UrlParsed {
    public static final Adapter<UrlParsed, Builder> ADAPTER = new UrlParsedAdapter();
    public final String shared_hash;
    public final Long shared_timestamp;
    public final String utm_name;
    public final String utm_source;

    public static final class Builder implements StructBuilder<UrlParsed> {
        private String shared_hash;
        private Long shared_timestamp;
        private String utm_name;
        private String utm_source;

        public Builder(UrlParsed urlParsed) {
            this.shared_timestamp = urlParsed.shared_timestamp;
            this.utm_source = urlParsed.utm_source;
            this.utm_name = urlParsed.utm_name;
            this.shared_hash = urlParsed.shared_hash;
        }

        public final Builder shared_timestamp(Long l) {
            this.shared_timestamp = l;
            return this;
        }

        public final Builder utm_source(String str) {
            this.utm_source = str;
            return this;
        }

        public final Builder utm_name(String str) {
            this.utm_name = str;
            return this;
        }

        public final Builder shared_hash(String str) {
            this.shared_hash = str;
            return this;
        }

        public final UrlParsed build() {
            return new UrlParsed();
        }

        public final void reset() {
            this.shared_timestamp = null;
            this.utm_source = null;
            this.utm_name = null;
            this.shared_hash = null;
        }
    }

    private static final class UrlParsedAdapter implements Adapter<UrlParsed, Builder> {
        private UrlParsedAdapter() {
        }

        public final void write(Protocol protocol, UrlParsed urlParsed) throws IOException {
            if (urlParsed.shared_timestamp != null) {
                protocol.mo2638a(1, (byte) 10);
                protocol.mo2639a(urlParsed.shared_timestamp.longValue());
            }
            if (urlParsed.utm_source != null) {
                protocol.mo2638a(2, (byte) 11);
                protocol.mo2640a(urlParsed.utm_source);
            }
            if (urlParsed.utm_name != null) {
                protocol.mo2638a(3, (byte) 11);
                protocol.mo2640a(urlParsed.utm_name);
            }
            if (urlParsed.shared_hash != null) {
                protocol.mo2638a(4, (byte) 11);
                protocol.mo2640a(urlParsed.shared_hash);
            }
            protocol.mo2634a();
        }

        public final UrlParsed read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b != (byte) 0) {
                    switch (b.f10037c) {
                        case (short) 1:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.shared_timestamp(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 2:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.utm_source(protocol.mo2652l());
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.utm_name(protocol.mo2652l());
                            break;
                        case (short) 4:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.shared_hash(protocol.mo2652l());
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final UrlParsed read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private UrlParsed(Builder builder) {
        this.shared_timestamp = builder.shared_timestamp;
        this.utm_source = builder.utm_source;
        this.utm_name = builder.utm_name;
        this.shared_hash = builder.shared_hash;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UrlParsed)) {
            return false;
        }
        UrlParsed urlParsed = (UrlParsed) obj;
        if ((this.shared_timestamp == urlParsed.shared_timestamp || (this.shared_timestamp != null && this.shared_timestamp.equals(urlParsed.shared_timestamp))) && ((this.utm_source == urlParsed.utm_source || (this.utm_source != null && this.utm_source.equals(urlParsed.utm_source))) && (this.utm_name == urlParsed.utm_name || (this.utm_name != null && this.utm_name.equals(urlParsed.utm_name))))) {
            if (this.shared_hash != urlParsed.shared_hash) {
                if (!(this.shared_hash == null || this.shared_hash.equals(urlParsed.shared_hash) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((((this.shared_timestamp == null ? 0 : this.shared_timestamp.hashCode()) ^ 16777619) * -2128831035) ^ (this.utm_source == null ? 0 : this.utm_source.hashCode())) * -2128831035) ^ (this.utm_name == null ? 0 : this.utm_name.hashCode())) * -2128831035;
        if (this.shared_hash != null) {
            i = this.shared_hash.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("UrlParsed{shared_timestamp=");
        stringBuilder.append(this.shared_timestamp);
        stringBuilder.append(", utm_source=");
        stringBuilder.append(this.utm_source);
        stringBuilder.append(", utm_name=");
        stringBuilder.append(this.utm_name);
        stringBuilder.append(", shared_hash=");
        stringBuilder.append(this.shared_hash);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
