package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class Inferred {
    public static final Adapter<Inferred, Builder> ADAPTER = new InferredAdapter();
    public final String app_name;
    public final String client_ip;

    public static final class Builder implements StructBuilder<Inferred> {
        private String app_name;
        private String client_ip;

        public Builder(Inferred inferred) {
            this.app_name = inferred.app_name;
            this.client_ip = inferred.client_ip;
        }

        public final Builder app_name(String str) {
            this.app_name = str;
            return this;
        }

        public final Builder client_ip(String str) {
            this.client_ip = str;
            return this;
        }

        public final Inferred build() {
            return new Inferred();
        }

        public final void reset() {
            this.app_name = null;
            this.client_ip = null;
        }
    }

    private static final class InferredAdapter implements Adapter<Inferred, Builder> {
        private InferredAdapter() {
        }

        public final void write(Protocol protocol, Inferred inferred) throws IOException {
            if (inferred.app_name != null) {
                protocol.mo2638a(1, (byte) 11);
                protocol.mo2640a(inferred.app_name);
            }
            if (inferred.client_ip != null) {
                protocol.mo2638a(2, (byte) 11);
                protocol.mo2640a(inferred.client_ip);
            }
            protocol.mo2634a();
        }

        public final Inferred read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b != (byte) 0) {
                    switch (b.f10037c) {
                        case (short) 1:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.app_name(protocol.mo2652l());
                            break;
                        case (short) 2:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.client_ip(protocol.mo2652l());
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final Inferred read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private Inferred(Builder builder) {
        this.app_name = builder.app_name;
        this.client_ip = builder.client_ip;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Inferred)) {
            return false;
        }
        Inferred inferred = (Inferred) obj;
        if (this.app_name == inferred.app_name || (this.app_name != null && this.app_name.equals(inferred.app_name))) {
            if (this.client_ip != inferred.client_ip) {
                if (!(this.client_ip == null || this.client_ip.equals(inferred.client_ip) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.app_name == null ? 0 : this.app_name.hashCode()) ^ 16777619) * -2128831035;
        if (this.client_ip != null) {
            i = this.client_ip.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Inferred{app_name=");
        stringBuilder.append(this.app_name);
        stringBuilder.append(", client_ip=");
        stringBuilder.append(this.client_ip);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
