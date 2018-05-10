package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class NotificationRequest {
    public static final Adapter<NotificationRequest, Builder> ADAPTER = new NotificationRequestAdapter();
    public final String failure_reason;
    public final String message_id;
    public final String platform;
    public final String source_queue_name;
    public final String status;

    public static final class Builder implements StructBuilder<NotificationRequest> {
        private String failure_reason;
        private String message_id;
        private String platform;
        private String source_queue_name;
        private String status;

        public Builder(NotificationRequest notificationRequest) {
            this.message_id = notificationRequest.message_id;
            this.status = notificationRequest.status;
            this.platform = notificationRequest.platform;
            this.failure_reason = notificationRequest.failure_reason;
            this.source_queue_name = notificationRequest.source_queue_name;
        }

        public final Builder message_id(String str) {
            this.message_id = str;
            return this;
        }

        public final Builder status(String str) {
            this.status = str;
            return this;
        }

        public final Builder platform(String str) {
            this.platform = str;
            return this;
        }

        public final Builder failure_reason(String str) {
            this.failure_reason = str;
            return this;
        }

        public final Builder source_queue_name(String str) {
            this.source_queue_name = str;
            return this;
        }

        public final NotificationRequest build() {
            return new NotificationRequest();
        }

        public final void reset() {
            this.message_id = null;
            this.status = null;
            this.platform = null;
            this.failure_reason = null;
            this.source_queue_name = null;
        }
    }

    private static final class NotificationRequestAdapter implements Adapter<NotificationRequest, Builder> {
        private NotificationRequestAdapter() {
        }

        public final void write(Protocol protocol, NotificationRequest notificationRequest) throws IOException {
            if (notificationRequest.message_id != null) {
                protocol.mo2638a(1, (byte) 11);
                protocol.mo2640a(notificationRequest.message_id);
            }
            if (notificationRequest.status != null) {
                protocol.mo2638a(2, (byte) 11);
                protocol.mo2640a(notificationRequest.status);
            }
            if (notificationRequest.platform != null) {
                protocol.mo2638a(3, (byte) 11);
                protocol.mo2640a(notificationRequest.platform);
            }
            if (notificationRequest.failure_reason != null) {
                protocol.mo2638a(4, (byte) 11);
                protocol.mo2640a(notificationRequest.failure_reason);
            }
            if (notificationRequest.source_queue_name != null) {
                protocol.mo2638a(5, (byte) 11);
                protocol.mo2640a(notificationRequest.source_queue_name);
            }
            protocol.mo2634a();
        }

        public final NotificationRequest read(Protocol protocol, Builder builder) throws IOException {
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
                            builder.status(protocol.mo2652l());
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.platform(protocol.mo2652l());
                            break;
                        case (short) 4:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.failure_reason(protocol.mo2652l());
                            break;
                        case (short) 5:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.source_queue_name(protocol.mo2652l());
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final NotificationRequest read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private NotificationRequest(Builder builder) {
        this.message_id = builder.message_id;
        this.status = builder.status;
        this.platform = builder.platform;
        this.failure_reason = builder.failure_reason;
        this.source_queue_name = builder.source_queue_name;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NotificationRequest)) {
            return false;
        }
        NotificationRequest notificationRequest = (NotificationRequest) obj;
        if ((this.message_id == notificationRequest.message_id || (this.message_id != null && this.message_id.equals(notificationRequest.message_id))) && ((this.status == notificationRequest.status || (this.status != null && this.status.equals(notificationRequest.status))) && ((this.platform == notificationRequest.platform || (this.platform != null && this.platform.equals(notificationRequest.platform))) && (this.failure_reason == notificationRequest.failure_reason || (this.failure_reason != null && this.failure_reason.equals(notificationRequest.failure_reason)))))) {
            if (this.source_queue_name != notificationRequest.source_queue_name) {
                if (!(this.source_queue_name == null || this.source_queue_name.equals(notificationRequest.source_queue_name) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((((((this.message_id == null ? 0 : this.message_id.hashCode()) ^ 16777619) * -2128831035) ^ (this.status == null ? 0 : this.status.hashCode())) * -2128831035) ^ (this.platform == null ? 0 : this.platform.hashCode())) * -2128831035) ^ (this.failure_reason == null ? 0 : this.failure_reason.hashCode())) * -2128831035;
        if (this.source_queue_name != null) {
            i = this.source_queue_name.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("NotificationRequest{message_id=");
        stringBuilder.append(this.message_id);
        stringBuilder.append(", status=");
        stringBuilder.append(this.status);
        stringBuilder.append(", platform=");
        stringBuilder.append(this.platform);
        stringBuilder.append(", failure_reason=");
        stringBuilder.append(this.failure_reason);
        stringBuilder.append(", source_queue_name=");
        stringBuilder.append(this.source_queue_name);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
