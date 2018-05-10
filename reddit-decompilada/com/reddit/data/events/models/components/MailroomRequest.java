package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class MailroomRequest {
    public static final Adapter<MailroomRequest, Builder> ADAPTER = new MailroomRequestAdapter();
    public final String delivery_queue_name;
    public final String dropped_by;
    public final String message_id;
    public final String message_type;
    public final String notification_target;
    public final String notification_transport;

    public static final class Builder implements StructBuilder<MailroomRequest> {
        private String delivery_queue_name;
        private String dropped_by;
        private String message_id;
        private String message_type;
        private String notification_target;
        private String notification_transport;

        public Builder(MailroomRequest mailroomRequest) {
            this.message_id = mailroomRequest.message_id;
            this.message_type = mailroomRequest.message_type;
            this.dropped_by = mailroomRequest.dropped_by;
            this.delivery_queue_name = mailroomRequest.delivery_queue_name;
            this.notification_transport = mailroomRequest.notification_transport;
            this.notification_target = mailroomRequest.notification_target;
        }

        public final Builder message_id(String str) {
            this.message_id = str;
            return this;
        }

        public final Builder message_type(String str) {
            this.message_type = str;
            return this;
        }

        public final Builder dropped_by(String str) {
            this.dropped_by = str;
            return this;
        }

        public final Builder delivery_queue_name(String str) {
            this.delivery_queue_name = str;
            return this;
        }

        public final Builder notification_transport(String str) {
            this.notification_transport = str;
            return this;
        }

        public final Builder notification_target(String str) {
            this.notification_target = str;
            return this;
        }

        public final MailroomRequest build() {
            return new MailroomRequest();
        }

        public final void reset() {
            this.message_id = null;
            this.message_type = null;
            this.dropped_by = null;
            this.delivery_queue_name = null;
            this.notification_transport = null;
            this.notification_target = null;
        }
    }

    private static final class MailroomRequestAdapter implements Adapter<MailroomRequest, Builder> {
        private MailroomRequestAdapter() {
        }

        public final void write(Protocol protocol, MailroomRequest mailroomRequest) throws IOException {
            if (mailroomRequest.message_id != null) {
                protocol.mo2638a(1, (byte) 11);
                protocol.mo2640a(mailroomRequest.message_id);
            }
            if (mailroomRequest.message_type != null) {
                protocol.mo2638a(2, (byte) 11);
                protocol.mo2640a(mailroomRequest.message_type);
            }
            if (mailroomRequest.dropped_by != null) {
                protocol.mo2638a(3, (byte) 11);
                protocol.mo2640a(mailroomRequest.dropped_by);
            }
            if (mailroomRequest.delivery_queue_name != null) {
                protocol.mo2638a(4, (byte) 11);
                protocol.mo2640a(mailroomRequest.delivery_queue_name);
            }
            if (mailroomRequest.notification_transport != null) {
                protocol.mo2638a(5, (byte) 11);
                protocol.mo2640a(mailroomRequest.notification_transport);
            }
            if (mailroomRequest.notification_target != null) {
                protocol.mo2638a(6, (byte) 11);
                protocol.mo2640a(mailroomRequest.notification_target);
            }
            protocol.mo2634a();
        }

        public final MailroomRequest read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b != (byte) 0) {
                    switch (b.f10037c) {
                        case (short) 1:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.message_id(protocol.mo2652l());
                            break;
                        case (short) 2:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.message_type(protocol.mo2652l());
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.dropped_by(protocol.mo2652l());
                            break;
                        case (short) 4:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.delivery_queue_name(protocol.mo2652l());
                            break;
                        case (short) 5:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.notification_transport(protocol.mo2652l());
                            break;
                        case (short) 6:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.notification_target(protocol.mo2652l());
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final MailroomRequest read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private MailroomRequest(Builder builder) {
        this.message_id = builder.message_id;
        this.message_type = builder.message_type;
        this.dropped_by = builder.dropped_by;
        this.delivery_queue_name = builder.delivery_queue_name;
        this.notification_transport = builder.notification_transport;
        this.notification_target = builder.notification_target;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof MailroomRequest)) {
            return false;
        }
        MailroomRequest mailroomRequest = (MailroomRequest) obj;
        if ((this.message_id == mailroomRequest.message_id || (this.message_id != null && this.message_id.equals(mailroomRequest.message_id))) && ((this.message_type == mailroomRequest.message_type || (this.message_type != null && this.message_type.equals(mailroomRequest.message_type))) && ((this.dropped_by == mailroomRequest.dropped_by || (this.dropped_by != null && this.dropped_by.equals(mailroomRequest.dropped_by))) && ((this.delivery_queue_name == mailroomRequest.delivery_queue_name || (this.delivery_queue_name != null && this.delivery_queue_name.equals(mailroomRequest.delivery_queue_name))) && (this.notification_transport == mailroomRequest.notification_transport || (this.notification_transport != null && this.notification_transport.equals(mailroomRequest.notification_transport))))))) {
            if (this.notification_target != mailroomRequest.notification_target) {
                if (!(this.notification_target == null || this.notification_target.equals(mailroomRequest.notification_target) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((((((((this.message_id == null ? 0 : this.message_id.hashCode()) ^ 16777619) * -2128831035) ^ (this.message_type == null ? 0 : this.message_type.hashCode())) * -2128831035) ^ (this.dropped_by == null ? 0 : this.dropped_by.hashCode())) * -2128831035) ^ (this.delivery_queue_name == null ? 0 : this.delivery_queue_name.hashCode())) * -2128831035) ^ (this.notification_transport == null ? 0 : this.notification_transport.hashCode())) * -2128831035;
        if (this.notification_target != null) {
            i = this.notification_target.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("MailroomRequest{message_id=");
        stringBuilder.append(this.message_id);
        stringBuilder.append(", message_type=");
        stringBuilder.append(this.message_type);
        stringBuilder.append(", dropped_by=");
        stringBuilder.append(this.dropped_by);
        stringBuilder.append(", delivery_queue_name=");
        stringBuilder.append(this.delivery_queue_name);
        stringBuilder.append(", notification_transport=");
        stringBuilder.append(this.notification_transport);
        stringBuilder.append(", notification_target=");
        stringBuilder.append(this.notification_target);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
