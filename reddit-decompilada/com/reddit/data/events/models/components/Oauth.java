package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class Oauth {
    public static final Adapter<Oauth, Builder> ADAPTER = new OauthAdapter();
    public final String client_app_type;
    public final String client_id;
    public final String client_name;

    public static final class Builder implements StructBuilder<Oauth> {
        private String client_app_type;
        private String client_id;
        private String client_name;

        public Builder(Oauth oauth) {
            this.client_app_type = oauth.client_app_type;
            this.client_name = oauth.client_name;
            this.client_id = oauth.client_id;
        }

        public final Builder client_app_type(String str) {
            this.client_app_type = str;
            return this;
        }

        public final Builder client_name(String str) {
            this.client_name = str;
            return this;
        }

        public final Builder client_id(String str) {
            this.client_id = str;
            return this;
        }

        public final Oauth build() {
            return new Oauth();
        }

        public final void reset() {
            this.client_app_type = null;
            this.client_name = null;
            this.client_id = null;
        }
    }

    private static final class OauthAdapter implements Adapter<Oauth, Builder> {
        private OauthAdapter() {
        }

        public final void write(Protocol protocol, Oauth oauth) throws IOException {
            if (oauth.client_app_type != null) {
                protocol.mo2638a(1, (byte) 11);
                protocol.mo2640a(oauth.client_app_type);
            }
            if (oauth.client_name != null) {
                protocol.mo2638a(2, (byte) 11);
                protocol.mo2640a(oauth.client_name);
            }
            if (oauth.client_id != null) {
                protocol.mo2638a(3, (byte) 11);
                protocol.mo2640a(oauth.client_id);
            }
            protocol.mo2634a();
        }

        public final Oauth read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b != (byte) 0) {
                    switch (b.f10037c) {
                        case (short) 1:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.client_app_type(protocol.mo2652l());
                            break;
                        case (short) 2:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.client_name(protocol.mo2652l());
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.client_id(protocol.mo2652l());
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final Oauth read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private Oauth(Builder builder) {
        this.client_app_type = builder.client_app_type;
        this.client_name = builder.client_name;
        this.client_id = builder.client_id;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Oauth)) {
            return false;
        }
        Oauth oauth = (Oauth) obj;
        if ((this.client_app_type == oauth.client_app_type || (this.client_app_type != null && this.client_app_type.equals(oauth.client_app_type))) && (this.client_name == oauth.client_name || (this.client_name != null && this.client_name.equals(oauth.client_name)))) {
            if (this.client_id != oauth.client_id) {
                if (!(this.client_id == null || this.client_id.equals(oauth.client_id) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((this.client_app_type == null ? 0 : this.client_app_type.hashCode()) ^ 16777619) * -2128831035) ^ (this.client_name == null ? 0 : this.client_name.hashCode())) * -2128831035;
        if (this.client_id != null) {
            i = this.client_id.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Oauth{client_app_type=");
        stringBuilder.append(this.client_app_type);
        stringBuilder.append(", client_name=");
        stringBuilder.append(this.client_name);
        stringBuilder.append(", client_id=");
        stringBuilder.append(this.client_id);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
