package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class DOMTimers {
    public static final Adapter<DOMTimers, Builder> ADAPTER = new DOMTimersAdapter();
    public final Long loaded;
    public final Long loading;
    public final Long request;

    public static final class Builder implements StructBuilder<DOMTimers> {
        private Long loaded;
        private Long loading;
        private Long request;

        public Builder(DOMTimers dOMTimers) {
            this.request = dOMTimers.request;
            this.loading = dOMTimers.loading;
            this.loaded = dOMTimers.loaded;
        }

        public final Builder request(Long l) {
            this.request = l;
            return this;
        }

        public final Builder loading(Long l) {
            this.loading = l;
            return this;
        }

        public final Builder loaded(Long l) {
            this.loaded = l;
            return this;
        }

        public final DOMTimers build() {
            return new DOMTimers();
        }

        public final void reset() {
            this.request = null;
            this.loading = null;
            this.loaded = null;
        }
    }

    private static final class DOMTimersAdapter implements Adapter<DOMTimers, Builder> {
        private DOMTimersAdapter() {
        }

        public final void write(Protocol protocol, DOMTimers dOMTimers) throws IOException {
            if (dOMTimers.request != null) {
                protocol.mo2638a(1, (byte) 10);
                protocol.mo2639a(dOMTimers.request.longValue());
            }
            if (dOMTimers.loading != null) {
                protocol.mo2638a(2, (byte) 10);
                protocol.mo2639a(dOMTimers.loading.longValue());
            }
            if (dOMTimers.loaded != null) {
                protocol.mo2638a(3, (byte) 10);
                protocol.mo2639a(dOMTimers.loaded.longValue());
            }
            protocol.mo2634a();
        }

        public final DOMTimers read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b != (byte) 0) {
                    switch (b.f10037c) {
                        case (short) 1:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.request(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 2:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.loading(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.loaded(Long.valueOf(protocol.mo2650j()));
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final DOMTimers read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private DOMTimers(Builder builder) {
        this.request = builder.request;
        this.loading = builder.loading;
        this.loaded = builder.loaded;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DOMTimers)) {
            return false;
        }
        DOMTimers dOMTimers = (DOMTimers) obj;
        if ((this.request == dOMTimers.request || (this.request != null && this.request.equals(dOMTimers.request))) && (this.loading == dOMTimers.loading || (this.loading != null && this.loading.equals(dOMTimers.loading)))) {
            if (this.loaded != dOMTimers.loaded) {
                if (!(this.loaded == null || this.loaded.equals(dOMTimers.loaded) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((this.request == null ? 0 : this.request.hashCode()) ^ 16777619) * -2128831035) ^ (this.loading == null ? 0 : this.loading.hashCode())) * -2128831035;
        if (this.loaded != null) {
            i = this.loaded.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("DOMTimers{request=");
        stringBuilder.append(this.request);
        stringBuilder.append(", loading=");
        stringBuilder.append(this.loading);
        stringBuilder.append(", loaded=");
        stringBuilder.append(this.loaded);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
