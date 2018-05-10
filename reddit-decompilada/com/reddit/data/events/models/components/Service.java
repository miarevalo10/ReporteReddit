package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class Service {
    public static final Adapter<Service, Builder> ADAPTER = new ServiceAdapter();
    public final String hostname;
    public final String name;

    public static final class Builder implements StructBuilder<Service> {
        private String hostname;
        private String name;

        public Builder(Service service) {
            this.name = service.name;
            this.hostname = service.hostname;
        }

        public final Builder name(String str) {
            if (str == null) {
                throw new NullPointerException("Required field 'name' cannot be null");
            }
            this.name = str;
            return this;
        }

        public final Builder hostname(String str) {
            this.hostname = str;
            return this;
        }

        public final Service build() {
            if (this.name != null) {
                return new Service();
            }
            throw new IllegalStateException("Required field 'name' is missing");
        }

        public final void reset() {
            this.name = null;
            this.hostname = null;
        }
    }

    private static final class ServiceAdapter implements Adapter<Service, Builder> {
        private ServiceAdapter() {
        }

        public final void write(Protocol protocol, Service service) throws IOException {
            protocol.mo2638a(1, (byte) 11);
            protocol.mo2640a(service.name);
            if (service.hostname != null) {
                protocol.mo2638a(2, (byte) 11);
                protocol.mo2640a(service.hostname);
            }
            protocol.mo2634a();
        }

        public final Service read(Protocol protocol, Builder builder) throws IOException {
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
                            builder.hostname(protocol.mo2652l());
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final Service read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private Service(Builder builder) {
        this.name = builder.name;
        this.hostname = builder.hostname;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Service)) {
            return false;
        }
        Service service = (Service) obj;
        if (this.name == service.name || this.name.equals(service.name)) {
            if (this.hostname != service.hostname) {
                if (!(this.hostname == null || this.hostname.equals(service.hostname) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((this.name.hashCode() ^ 16777619) * -2128831035) ^ (this.hostname == null ? 0 : this.hostname.hashCode())) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Service{name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", hostname=");
        stringBuilder.append(this.hostname);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
