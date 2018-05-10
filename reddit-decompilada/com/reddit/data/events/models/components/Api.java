package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class Api {
    public static final Adapter<Api, Builder> ADAPTER = new ApiAdapter();
    public final String address;
    public final String endpoint;
    public final String name;

    private static final class ApiAdapter implements Adapter<Api, Builder> {
        private ApiAdapter() {
        }

        public final void write(Protocol protocol, Api api) throws IOException {
            if (api.name != null) {
                protocol.mo2638a(1, (byte) 11);
                protocol.mo2640a(api.name);
            }
            if (api.address != null) {
                protocol.mo2638a(2, (byte) 11);
                protocol.mo2640a(api.address);
            }
            if (api.endpoint != null) {
                protocol.mo2638a(3, (byte) 11);
                protocol.mo2640a(api.endpoint);
            }
            protocol.mo2634a();
        }

        public final Api read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b != (byte) 0) {
                    switch (b.f10037c) {
                        case (short) 1:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.name(protocol.mo2652l());
                            break;
                        case (short) 2:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.address(protocol.mo2652l());
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.endpoint(protocol.mo2652l());
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final Api read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    public static final class Builder implements StructBuilder<Api> {
        private String address;
        private String endpoint;
        private String name;

        public Builder(Api api) {
            this.name = api.name;
            this.address = api.address;
            this.endpoint = api.endpoint;
        }

        public final Builder name(String str) {
            this.name = str;
            return this;
        }

        public final Builder address(String str) {
            this.address = str;
            return this;
        }

        public final Builder endpoint(String str) {
            this.endpoint = str;
            return this;
        }

        public final Api build() {
            return new Api();
        }

        public final void reset() {
            this.name = null;
            this.address = null;
            this.endpoint = null;
        }
    }

    private Api(Builder builder) {
        this.name = builder.name;
        this.address = builder.address;
        this.endpoint = builder.endpoint;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Api)) {
            return false;
        }
        Api api = (Api) obj;
        if ((this.name == api.name || (this.name != null && this.name.equals(api.name))) && (this.address == api.address || (this.address != null && this.address.equals(api.address)))) {
            if (this.endpoint != api.endpoint) {
                if (!(this.endpoint == null || this.endpoint.equals(api.endpoint) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((this.name == null ? 0 : this.name.hashCode()) ^ 16777619) * -2128831035) ^ (this.address == null ? 0 : this.address.hashCode())) * -2128831035;
        if (this.endpoint != null) {
            i = this.endpoint.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Api{name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", address=");
        stringBuilder.append(this.address);
        stringBuilder.append(", endpoint=");
        stringBuilder.append(this.endpoint);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
