package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class Timer {
    public static final Adapter<Timer, Builder> ADAPTER = new TimerAdapter();
    public final Long millis;
    public final String type;

    public static final class Builder implements StructBuilder<Timer> {
        private Long millis;
        private String type;

        public Builder(Timer timer) {
            this.type = timer.type;
            this.millis = timer.millis;
        }

        public final Builder type(String str) {
            this.type = str;
            return this;
        }

        public final Builder millis(Long l) {
            this.millis = l;
            return this;
        }

        public final Timer build() {
            return new Timer();
        }

        public final void reset() {
            this.type = null;
            this.millis = null;
        }
    }

    private static final class TimerAdapter implements Adapter<Timer, Builder> {
        private TimerAdapter() {
        }

        public final void write(Protocol protocol, Timer timer) throws IOException {
            if (timer.type != null) {
                protocol.mo2638a(1, (byte) 11);
                protocol.mo2640a(timer.type);
            }
            if (timer.millis != null) {
                protocol.mo2638a(2, (byte) 10);
                protocol.mo2639a(timer.millis.longValue());
            }
            protocol.mo2634a();
        }

        public final Timer read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b != (byte) 0) {
                    switch (b.f10037c) {
                        case (short) 1:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.type(protocol.mo2652l());
                            break;
                        case (short) 2:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.millis(Long.valueOf(protocol.mo2650j()));
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final Timer read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private Timer(Builder builder) {
        this.type = builder.type;
        this.millis = builder.millis;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Timer)) {
            return false;
        }
        Timer timer = (Timer) obj;
        if (this.type == timer.type || (this.type != null && this.type.equals(timer.type))) {
            if (this.millis != timer.millis) {
                if (!(this.millis == null || this.millis.equals(timer.millis) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.type == null ? 0 : this.type.hashCode()) ^ 16777619) * -2128831035;
        if (this.millis != null) {
            i = this.millis.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Timer{type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", millis=");
        stringBuilder.append(this.millis);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
