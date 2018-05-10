package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class Ticket {
    public static final Adapter<Ticket, Builder> ADAPTER = new TicketAdapter();
    public final String id;
    public final String queue_id;
    public final String type;

    public static final class Builder implements StructBuilder<Ticket> {
        private String id;
        private String queue_id;
        private String type;

        public Builder(Ticket ticket) {
            this.id = ticket.id;
            this.type = ticket.type;
            this.queue_id = ticket.queue_id;
        }

        public final Builder id(String str) {
            if (str == null) {
                throw new NullPointerException("Required field 'id' cannot be null");
            }
            this.id = str;
            return this;
        }

        public final Builder type(String str) {
            this.type = str;
            return this;
        }

        public final Builder queue_id(String str) {
            this.queue_id = str;
            return this;
        }

        public final Ticket build() {
            if (this.id != null) {
                return new Ticket();
            }
            throw new IllegalStateException("Required field 'id' is missing");
        }

        public final void reset() {
            this.id = null;
            this.type = null;
            this.queue_id = null;
        }
    }

    private static final class TicketAdapter implements Adapter<Ticket, Builder> {
        private TicketAdapter() {
        }

        public final void write(Protocol protocol, Ticket ticket) throws IOException {
            protocol.mo2638a(1, (byte) 11);
            protocol.mo2640a(ticket.id);
            if (ticket.type != null) {
                protocol.mo2638a(2, (byte) 11);
                protocol.mo2640a(ticket.type);
            }
            if (ticket.queue_id != null) {
                protocol.mo2638a(3, (byte) 11);
                protocol.mo2640a(ticket.queue_id);
            }
            protocol.mo2634a();
        }

        public final Ticket read(Protocol protocol, Builder builder) throws IOException {
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
                            builder.type(protocol.mo2652l());
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.queue_id(protocol.mo2652l());
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final Ticket read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private Ticket(Builder builder) {
        this.id = builder.id;
        this.type = builder.type;
        this.queue_id = builder.queue_id;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Ticket)) {
            return false;
        }
        Ticket ticket = (Ticket) obj;
        if ((this.id == ticket.id || this.id.equals(ticket.id)) && (this.type == ticket.type || (this.type != null && this.type.equals(ticket.type)))) {
            if (this.queue_id != ticket.queue_id) {
                if (!(this.queue_id == null || this.queue_id.equals(ticket.queue_id) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((this.id.hashCode() ^ 16777619) * -2128831035) ^ (this.type == null ? 0 : this.type.hashCode())) * -2128831035;
        if (this.queue_id != null) {
            i = this.queue_id.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Ticket{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", queue_id=");
        stringBuilder.append(this.queue_id);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
