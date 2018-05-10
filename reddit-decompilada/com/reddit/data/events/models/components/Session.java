package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class Session {
    public static final Adapter<Session, Builder> ADAPTER = new SessionAdapter();
    public final Long created_timestamp;
    public final String id;
    public final String referrer_domain;
    public final String referrer_url;
    public final String type;
    public final String version;

    public static final class Builder implements StructBuilder<Session> {
        private Long created_timestamp;
        private String id;
        private String referrer_domain;
        private String referrer_url;
        private String type;
        private String version;

        public Builder(Session session) {
            this.id = session.id;
            this.referrer_url = session.referrer_url;
            this.referrer_domain = session.referrer_domain;
            this.version = session.version;
            this.type = session.type;
            this.created_timestamp = session.created_timestamp;
        }

        public final Builder id(String str) {
            if (str == null) {
                throw new NullPointerException("Required field 'id' cannot be null");
            }
            this.id = str;
            return this;
        }

        public final Builder referrer_url(String str) {
            this.referrer_url = str;
            return this;
        }

        public final Builder referrer_domain(String str) {
            this.referrer_domain = str;
            return this;
        }

        public final Builder version(String str) {
            this.version = str;
            return this;
        }

        public final Builder type(String str) {
            this.type = str;
            return this;
        }

        public final Builder created_timestamp(Long l) {
            this.created_timestamp = l;
            return this;
        }

        public final Session build() {
            if (this.id != null) {
                return new Session();
            }
            throw new IllegalStateException("Required field 'id' is missing");
        }

        public final void reset() {
            this.id = null;
            this.referrer_url = null;
            this.referrer_domain = null;
            this.version = null;
            this.type = null;
            this.created_timestamp = null;
        }
    }

    private static final class SessionAdapter implements Adapter<Session, Builder> {
        private SessionAdapter() {
        }

        public final void write(Protocol protocol, Session session) throws IOException {
            protocol.mo2638a(1, (byte) 11);
            protocol.mo2640a(session.id);
            if (session.referrer_url != null) {
                protocol.mo2638a(2, (byte) 11);
                protocol.mo2640a(session.referrer_url);
            }
            if (session.referrer_domain != null) {
                protocol.mo2638a(3, (byte) 11);
                protocol.mo2640a(session.referrer_domain);
            }
            if (session.version != null) {
                protocol.mo2638a(4, (byte) 11);
                protocol.mo2640a(session.version);
            }
            if (session.type != null) {
                protocol.mo2638a(5, (byte) 11);
                protocol.mo2640a(session.type);
            }
            if (session.created_timestamp != null) {
                protocol.mo2638a(6, (byte) 10);
                protocol.mo2639a(session.created_timestamp.longValue());
            }
            protocol.mo2634a();
        }

        public final Session read(Protocol protocol, Builder builder) throws IOException {
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
                            builder.referrer_url(protocol.mo2652l());
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.referrer_domain(protocol.mo2652l());
                            break;
                        case (short) 4:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.version(protocol.mo2652l());
                            break;
                        case (short) 5:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.type(protocol.mo2652l());
                            break;
                        case (short) 6:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.created_timestamp(Long.valueOf(protocol.mo2650j()));
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final Session read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private Session(Builder builder) {
        this.id = builder.id;
        this.referrer_url = builder.referrer_url;
        this.referrer_domain = builder.referrer_domain;
        this.version = builder.version;
        this.type = builder.type;
        this.created_timestamp = builder.created_timestamp;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Session)) {
            return false;
        }
        Session session = (Session) obj;
        if ((this.id == session.id || this.id.equals(session.id)) && ((this.referrer_url == session.referrer_url || (this.referrer_url != null && this.referrer_url.equals(session.referrer_url))) && ((this.referrer_domain == session.referrer_domain || (this.referrer_domain != null && this.referrer_domain.equals(session.referrer_domain))) && ((this.version == session.version || (this.version != null && this.version.equals(session.version))) && (this.type == session.type || (this.type != null && this.type.equals(session.type))))))) {
            if (this.created_timestamp != session.created_timestamp) {
                if (!(this.created_timestamp == null || this.created_timestamp.equals(session.created_timestamp) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((this.id.hashCode() ^ 16777619) * -2128831035) ^ (this.referrer_url == null ? 0 : this.referrer_url.hashCode())) * -2128831035) ^ (this.referrer_domain == null ? 0 : this.referrer_domain.hashCode())) * -2128831035) ^ (this.version == null ? 0 : this.version.hashCode())) * -2128831035) ^ (this.type == null ? 0 : this.type.hashCode())) * -2128831035;
        if (this.created_timestamp != null) {
            i = this.created_timestamp.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Session{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", referrer_url=");
        stringBuilder.append(this.referrer_url);
        stringBuilder.append(", referrer_domain=");
        stringBuilder.append(this.referrer_domain);
        stringBuilder.append(", version=");
        stringBuilder.append(this.version);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", created_timestamp=");
        stringBuilder.append(this.created_timestamp);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
