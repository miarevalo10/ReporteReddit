package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class Notification {
    public static final Adapter<Notification, Builder> ADAPTER = new NotificationAdapter();
    public final Boolean dropped;
    public final String id;
    public final String process_notes;

    public static final class Builder implements StructBuilder<Notification> {
        private Boolean dropped;
        private String id;
        private String process_notes;

        public Builder(Notification notification) {
            this.id = notification.id;
            this.process_notes = notification.process_notes;
            this.dropped = notification.dropped;
        }

        public final Builder id(String str) {
            if (str == null) {
                throw new NullPointerException("Required field 'id' cannot be null");
            }
            this.id = str;
            return this;
        }

        public final Builder process_notes(String str) {
            this.process_notes = str;
            return this;
        }

        public final Builder dropped(Boolean bool) {
            this.dropped = bool;
            return this;
        }

        public final Notification build() {
            if (this.id != null) {
                return new Notification();
            }
            throw new IllegalStateException("Required field 'id' is missing");
        }

        public final void reset() {
            this.id = null;
            this.process_notes = null;
            this.dropped = null;
        }
    }

    private static final class NotificationAdapter implements Adapter<Notification, Builder> {
        private NotificationAdapter() {
        }

        public final void write(Protocol protocol, Notification notification) throws IOException {
            protocol.mo2638a(1, (byte) 11);
            protocol.mo2640a(notification.id);
            if (notification.process_notes != null) {
                protocol.mo2638a(2, (byte) 11);
                protocol.mo2640a(notification.process_notes);
            }
            if (notification.dropped != null) {
                protocol.mo2638a(3, (byte) 2);
                protocol.mo2641a(notification.dropped.booleanValue());
            }
            protocol.mo2634a();
        }

        public final Notification read(Protocol protocol, Builder builder) throws IOException {
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
                            builder.process_notes(protocol.mo2652l());
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.dropped(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final Notification read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private Notification(Builder builder) {
        this.id = builder.id;
        this.process_notes = builder.process_notes;
        this.dropped = builder.dropped;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Notification)) {
            return false;
        }
        Notification notification = (Notification) obj;
        if ((this.id == notification.id || this.id.equals(notification.id)) && (this.process_notes == notification.process_notes || (this.process_notes != null && this.process_notes.equals(notification.process_notes)))) {
            if (this.dropped != notification.dropped) {
                if (!(this.dropped == null || this.dropped.equals(notification.dropped) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((this.id.hashCode() ^ 16777619) * -2128831035) ^ (this.process_notes == null ? 0 : this.process_notes.hashCode())) * -2128831035;
        if (this.dropped != null) {
            i = this.dropped.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Notification{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", process_notes=");
        stringBuilder.append(this.process_notes);
        stringBuilder.append(", dropped=");
        stringBuilder.append(this.dropped);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
