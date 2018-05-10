package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class App {
    public static final Adapter<App, Builder> ADAPTER = new AppAdapter();
    public final Long install_timestamp;
    public final String name;
    public final String version;

    private static final class AppAdapter implements Adapter<App, Builder> {
        private AppAdapter() {
        }

        public final void write(Protocol protocol, App app) throws IOException {
            if (app.version != null) {
                protocol.mo2638a(1, (byte) 11);
                protocol.mo2640a(app.version);
            }
            protocol.mo2638a(2, (byte) 11);
            protocol.mo2640a(app.name);
            if (app.install_timestamp != null) {
                protocol.mo2638a(3, (byte) 10);
                protocol.mo2639a(app.install_timestamp.longValue());
            }
            protocol.mo2634a();
        }

        public final App read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b != (byte) 0) {
                    switch (b.f10037c) {
                        case (short) 1:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.version(protocol.mo2652l());
                            break;
                        case (short) 2:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.name(protocol.mo2652l());
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.install_timestamp(Long.valueOf(protocol.mo2650j()));
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final App read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    public static final class Builder implements StructBuilder<App> {
        private Long install_timestamp;
        private String name;
        private String version;

        public Builder(App app) {
            this.version = app.version;
            this.name = app.name;
            this.install_timestamp = app.install_timestamp;
        }

        public final Builder version(String str) {
            this.version = str;
            return this;
        }

        public final Builder name(String str) {
            if (str == null) {
                throw new NullPointerException("Required field 'name' cannot be null");
            }
            this.name = str;
            return this;
        }

        public final Builder install_timestamp(Long l) {
            this.install_timestamp = l;
            return this;
        }

        public final App build() {
            if (this.name != null) {
                return new App();
            }
            throw new IllegalStateException("Required field 'name' is missing");
        }

        public final void reset() {
            this.version = null;
            this.name = null;
            this.install_timestamp = null;
        }
    }

    private App(Builder builder) {
        this.version = builder.version;
        this.name = builder.name;
        this.install_timestamp = builder.install_timestamp;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof App)) {
            return false;
        }
        App app = (App) obj;
        if ((this.version == app.version || (this.version != null && this.version.equals(app.version))) && (this.name == app.name || this.name.equals(app.name))) {
            if (this.install_timestamp != app.install_timestamp) {
                if (!(this.install_timestamp == null || this.install_timestamp.equals(app.install_timestamp) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((this.version == null ? 0 : this.version.hashCode()) ^ 16777619) * -2128831035) ^ this.name.hashCode()) * -2128831035;
        if (this.install_timestamp != null) {
            i = this.install_timestamp.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("App{version=");
        stringBuilder.append(this.version);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", install_timestamp=");
        stringBuilder.append(this.install_timestamp);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
