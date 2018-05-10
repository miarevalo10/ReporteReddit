package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.ListMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Chat {
    public static final Adapter<Chat, Builder> ADAPTER = new ChatAdapter();
    public final String blocked_user_id;
    public final Boolean existing_channel;
    public final String id;
    public final String image_upload_method;
    public final String invitation_id;
    public final String invitation_preview_type;
    public final Long invitation_timestamp;
    public final String invitation_type;
    public final List<String> members;
    public final Long message_length;
    public final String message_type;
    public final Long number_blocked_users;
    public final Long number_channels;
    public final Long number_members;
    public final Long number_pending_invites;
    public final Long number_unreads;
    public final String recipient_user_id;
    public final String reported_user_id;
    public final String request_name;
    public final String sender_user_id;
    public final String type;
    public final String user_added_method;

    public static final class Builder implements StructBuilder<Chat> {
        private String blocked_user_id;
        private Boolean existing_channel;
        private String id;
        private String image_upload_method;
        private String invitation_id;
        private String invitation_preview_type;
        private Long invitation_timestamp;
        private String invitation_type;
        private List<String> members;
        private Long message_length;
        private String message_type;
        private Long number_blocked_users;
        private Long number_channels;
        private Long number_members;
        private Long number_pending_invites;
        private Long number_unreads;
        private String recipient_user_id;
        private String reported_user_id;
        private String request_name;
        private String sender_user_id;
        private String type;
        private String user_added_method;

        public Builder(Chat chat) {
            this.blocked_user_id = chat.blocked_user_id;
            this.id = chat.id;
            this.type = chat.type;
            this.existing_channel = chat.existing_channel;
            this.image_upload_method = chat.image_upload_method;
            this.user_added_method = chat.user_added_method;
            this.invitation_id = chat.invitation_id;
            this.invitation_type = chat.invitation_type;
            this.members = chat.members;
            this.invitation_preview_type = chat.invitation_preview_type;
            this.message_type = chat.message_type;
            this.number_channels = chat.number_channels;
            this.number_pending_invites = chat.number_pending_invites;
            this.number_members = chat.number_members;
            this.number_unreads = chat.number_unreads;
            this.reported_user_id = chat.reported_user_id;
            this.sender_user_id = chat.sender_user_id;
            this.invitation_timestamp = chat.invitation_timestamp;
            this.message_length = chat.message_length;
            this.recipient_user_id = chat.recipient_user_id;
            this.number_blocked_users = chat.number_blocked_users;
            this.request_name = chat.request_name;
        }

        public final Builder blocked_user_id(String str) {
            this.blocked_user_id = str;
            return this;
        }

        public final Builder id(String str) {
            this.id = str;
            return this;
        }

        public final Builder type(String str) {
            this.type = str;
            return this;
        }

        public final Builder existing_channel(Boolean bool) {
            this.existing_channel = bool;
            return this;
        }

        public final Builder image_upload_method(String str) {
            this.image_upload_method = str;
            return this;
        }

        public final Builder user_added_method(String str) {
            this.user_added_method = str;
            return this;
        }

        public final Builder invitation_id(String str) {
            this.invitation_id = str;
            return this;
        }

        public final Builder invitation_type(String str) {
            this.invitation_type = str;
            return this;
        }

        public final Builder members(List<String> list) {
            this.members = list;
            return this;
        }

        public final Builder invitation_preview_type(String str) {
            this.invitation_preview_type = str;
            return this;
        }

        public final Builder message_type(String str) {
            this.message_type = str;
            return this;
        }

        public final Builder number_channels(Long l) {
            this.number_channels = l;
            return this;
        }

        public final Builder number_pending_invites(Long l) {
            this.number_pending_invites = l;
            return this;
        }

        public final Builder number_members(Long l) {
            this.number_members = l;
            return this;
        }

        public final Builder number_unreads(Long l) {
            this.number_unreads = l;
            return this;
        }

        public final Builder reported_user_id(String str) {
            this.reported_user_id = str;
            return this;
        }

        public final Builder sender_user_id(String str) {
            this.sender_user_id = str;
            return this;
        }

        public final Builder invitation_timestamp(Long l) {
            this.invitation_timestamp = l;
            return this;
        }

        public final Builder message_length(Long l) {
            this.message_length = l;
            return this;
        }

        public final Builder recipient_user_id(String str) {
            this.recipient_user_id = str;
            return this;
        }

        public final Builder number_blocked_users(Long l) {
            this.number_blocked_users = l;
            return this;
        }

        public final Builder request_name(String str) {
            this.request_name = str;
            return this;
        }

        public final Chat build() {
            return new Chat();
        }

        public final void reset() {
            this.blocked_user_id = null;
            this.id = null;
            this.type = null;
            this.existing_channel = null;
            this.image_upload_method = null;
            this.user_added_method = null;
            this.invitation_id = null;
            this.invitation_type = null;
            this.members = null;
            this.invitation_preview_type = null;
            this.message_type = null;
            this.number_channels = null;
            this.number_pending_invites = null;
            this.number_members = null;
            this.number_unreads = null;
            this.reported_user_id = null;
            this.sender_user_id = null;
            this.invitation_timestamp = null;
            this.message_length = null;
            this.recipient_user_id = null;
            this.number_blocked_users = null;
            this.request_name = null;
        }
    }

    private static final class ChatAdapter implements Adapter<Chat, Builder> {
        private ChatAdapter() {
        }

        public final void write(Protocol protocol, Chat chat) throws IOException {
            if (chat.blocked_user_id != null) {
                protocol.mo2638a(1, (byte) 11);
                protocol.mo2640a(chat.blocked_user_id);
            }
            if (chat.id != null) {
                protocol.mo2638a(2, (byte) 11);
                protocol.mo2640a(chat.id);
            }
            if (chat.type != null) {
                protocol.mo2638a(3, (byte) 11);
                protocol.mo2640a(chat.type);
            }
            if (chat.existing_channel != null) {
                protocol.mo2638a(4, (byte) 2);
                protocol.mo2641a(chat.existing_channel.booleanValue());
            }
            if (chat.image_upload_method != null) {
                protocol.mo2638a(5, (byte) 11);
                protocol.mo2640a(chat.image_upload_method);
            }
            if (chat.user_added_method != null) {
                protocol.mo2638a(6, (byte) 11);
                protocol.mo2640a(chat.user_added_method);
            }
            if (chat.invitation_id != null) {
                protocol.mo2638a(7, (byte) 11);
                protocol.mo2640a(chat.invitation_id);
            }
            if (chat.invitation_type != null) {
                protocol.mo2638a(8, (byte) 11);
                protocol.mo2640a(chat.invitation_type);
            }
            if (chat.members != null) {
                protocol.mo2638a(9, (byte) 15);
                protocol.mo2635a((byte) 11, chat.members.size());
                for (String a : chat.members) {
                    protocol.mo2640a(a);
                }
            }
            if (chat.invitation_preview_type != null) {
                protocol.mo2638a(10, (byte) 11);
                protocol.mo2640a(chat.invitation_preview_type);
            }
            if (chat.message_type != null) {
                protocol.mo2638a(11, (byte) 11);
                protocol.mo2640a(chat.message_type);
            }
            if (chat.number_channels != null) {
                protocol.mo2638a(12, (byte) 10);
                protocol.mo2639a(chat.number_channels.longValue());
            }
            if (chat.number_pending_invites != null) {
                protocol.mo2638a(13, (byte) 10);
                protocol.mo2639a(chat.number_pending_invites.longValue());
            }
            if (chat.number_members != null) {
                protocol.mo2638a(14, (byte) 10);
                protocol.mo2639a(chat.number_members.longValue());
            }
            if (chat.number_unreads != null) {
                protocol.mo2638a(15, (byte) 10);
                protocol.mo2639a(chat.number_unreads.longValue());
            }
            if (chat.reported_user_id != null) {
                protocol.mo2638a(16, (byte) 11);
                protocol.mo2640a(chat.reported_user_id);
            }
            if (chat.sender_user_id != null) {
                protocol.mo2638a(17, (byte) 11);
                protocol.mo2640a(chat.sender_user_id);
            }
            if (chat.invitation_timestamp != null) {
                protocol.mo2638a(18, (byte) 10);
                protocol.mo2639a(chat.invitation_timestamp.longValue());
            }
            if (chat.message_length != null) {
                protocol.mo2638a(19, (byte) 10);
                protocol.mo2639a(chat.message_length.longValue());
            }
            if (chat.recipient_user_id != null) {
                protocol.mo2638a(20, (byte) 11);
                protocol.mo2640a(chat.recipient_user_id);
            }
            if (chat.number_blocked_users != null) {
                protocol.mo2638a(21, (byte) 10);
                protocol.mo2639a(chat.number_blocked_users.longValue());
            }
            if (chat.request_name != null) {
                protocol.mo2638a(22, (byte) 11);
                protocol.mo2640a(chat.request_name);
            }
            protocol.mo2634a();
        }

        public final Chat read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b != (byte) 0) {
                    switch (b.f10037c) {
                        case (short) 1:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.blocked_user_id(protocol.mo2652l());
                            break;
                        case (short) 2:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.id(protocol.mo2652l());
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.type(protocol.mo2652l());
                            break;
                        case (short) 4:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.existing_channel(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 5:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.image_upload_method(protocol.mo2652l());
                            break;
                        case (short) 6:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.user_added_method(protocol.mo2652l());
                            break;
                        case (short) 7:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.invitation_id(protocol.mo2652l());
                            break;
                        case (short) 8:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.invitation_type(protocol.mo2652l());
                            break;
                        case (short) 9:
                            if (b.f10036b != (byte) 15) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            ListMetadata d = protocol.mo2644d();
                            List arrayList = new ArrayList(d.f10039b);
                            for (int i = 0; i < d.f10039b; i++) {
                                arrayList.add(protocol.mo2652l());
                            }
                            builder.members(arrayList);
                            break;
                        case (short) 10:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.invitation_preview_type(protocol.mo2652l());
                            break;
                        case (short) 11:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.message_type(protocol.mo2652l());
                            break;
                        case (short) 12:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.number_channels(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 13:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.number_pending_invites(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 14:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.number_members(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 15:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.number_unreads(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 16:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.reported_user_id(protocol.mo2652l());
                            break;
                        case (short) 17:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.sender_user_id(protocol.mo2652l());
                            break;
                        case (short) 18:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.invitation_timestamp(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 19:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.message_length(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 20:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.recipient_user_id(protocol.mo2652l());
                            break;
                        case (short) 21:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.number_blocked_users(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 22:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.request_name(protocol.mo2652l());
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final Chat read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private Chat(Builder builder) {
        this.blocked_user_id = builder.blocked_user_id;
        this.id = builder.id;
        this.type = builder.type;
        this.existing_channel = builder.existing_channel;
        this.image_upload_method = builder.image_upload_method;
        this.user_added_method = builder.user_added_method;
        this.invitation_id = builder.invitation_id;
        this.invitation_type = builder.invitation_type;
        this.members = builder.members == null ? null : Collections.unmodifiableList(builder.members);
        this.invitation_preview_type = builder.invitation_preview_type;
        this.message_type = builder.message_type;
        this.number_channels = builder.number_channels;
        this.number_pending_invites = builder.number_pending_invites;
        this.number_members = builder.number_members;
        this.number_unreads = builder.number_unreads;
        this.reported_user_id = builder.reported_user_id;
        this.sender_user_id = builder.sender_user_id;
        this.invitation_timestamp = builder.invitation_timestamp;
        this.message_length = builder.message_length;
        this.recipient_user_id = builder.recipient_user_id;
        this.number_blocked_users = builder.number_blocked_users;
        this.request_name = builder.request_name;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Chat)) {
            return false;
        }
        Chat chat = (Chat) obj;
        if ((this.blocked_user_id == chat.blocked_user_id || (this.blocked_user_id != null && this.blocked_user_id.equals(chat.blocked_user_id))) && ((this.id == chat.id || (this.id != null && this.id.equals(chat.id))) && ((this.type == chat.type || (this.type != null && this.type.equals(chat.type))) && ((this.existing_channel == chat.existing_channel || (this.existing_channel != null && this.existing_channel.equals(chat.existing_channel))) && ((this.image_upload_method == chat.image_upload_method || (this.image_upload_method != null && this.image_upload_method.equals(chat.image_upload_method))) && ((this.user_added_method == chat.user_added_method || (this.user_added_method != null && this.user_added_method.equals(chat.user_added_method))) && ((this.invitation_id == chat.invitation_id || (this.invitation_id != null && this.invitation_id.equals(chat.invitation_id))) && ((this.invitation_type == chat.invitation_type || (this.invitation_type != null && this.invitation_type.equals(chat.invitation_type))) && ((this.members == chat.members || (this.members != null && this.members.equals(chat.members))) && ((this.invitation_preview_type == chat.invitation_preview_type || (this.invitation_preview_type != null && this.invitation_preview_type.equals(chat.invitation_preview_type))) && ((this.message_type == chat.message_type || (this.message_type != null && this.message_type.equals(chat.message_type))) && ((this.number_channels == chat.number_channels || (this.number_channels != null && this.number_channels.equals(chat.number_channels))) && ((this.number_pending_invites == chat.number_pending_invites || (this.number_pending_invites != null && this.number_pending_invites.equals(chat.number_pending_invites))) && ((this.number_members == chat.number_members || (this.number_members != null && this.number_members.equals(chat.number_members))) && ((this.number_unreads == chat.number_unreads || (this.number_unreads != null && this.number_unreads.equals(chat.number_unreads))) && ((this.reported_user_id == chat.reported_user_id || (this.reported_user_id != null && this.reported_user_id.equals(chat.reported_user_id))) && ((this.sender_user_id == chat.sender_user_id || (this.sender_user_id != null && this.sender_user_id.equals(chat.sender_user_id))) && ((this.invitation_timestamp == chat.invitation_timestamp || (this.invitation_timestamp != null && this.invitation_timestamp.equals(chat.invitation_timestamp))) && ((this.message_length == chat.message_length || (this.message_length != null && this.message_length.equals(chat.message_length))) && ((this.recipient_user_id == chat.recipient_user_id || (this.recipient_user_id != null && this.recipient_user_id.equals(chat.recipient_user_id))) && (this.number_blocked_users == chat.number_blocked_users || (this.number_blocked_users != null && this.number_blocked_users.equals(chat.number_blocked_users))))))))))))))))))))))) {
            if (this.request_name != chat.request_name) {
                if (!(this.request_name == null || this.request_name.equals(chat.request_name) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((((((((((((((((((((((((((((((((((((((((this.blocked_user_id == null ? 0 : this.blocked_user_id.hashCode()) ^ 16777619) * -2128831035) ^ (this.id == null ? 0 : this.id.hashCode())) * -2128831035) ^ (this.type == null ? 0 : this.type.hashCode())) * -2128831035) ^ (this.existing_channel == null ? 0 : this.existing_channel.hashCode())) * -2128831035) ^ (this.image_upload_method == null ? 0 : this.image_upload_method.hashCode())) * -2128831035) ^ (this.user_added_method == null ? 0 : this.user_added_method.hashCode())) * -2128831035) ^ (this.invitation_id == null ? 0 : this.invitation_id.hashCode())) * -2128831035) ^ (this.invitation_type == null ? 0 : this.invitation_type.hashCode())) * -2128831035) ^ (this.members == null ? 0 : this.members.hashCode())) * -2128831035) ^ (this.invitation_preview_type == null ? 0 : this.invitation_preview_type.hashCode())) * -2128831035) ^ (this.message_type == null ? 0 : this.message_type.hashCode())) * -2128831035) ^ (this.number_channels == null ? 0 : this.number_channels.hashCode())) * -2128831035) ^ (this.number_pending_invites == null ? 0 : this.number_pending_invites.hashCode())) * -2128831035) ^ (this.number_members == null ? 0 : this.number_members.hashCode())) * -2128831035) ^ (this.number_unreads == null ? 0 : this.number_unreads.hashCode())) * -2128831035) ^ (this.reported_user_id == null ? 0 : this.reported_user_id.hashCode())) * -2128831035) ^ (this.sender_user_id == null ? 0 : this.sender_user_id.hashCode())) * -2128831035) ^ (this.invitation_timestamp == null ? 0 : this.invitation_timestamp.hashCode())) * -2128831035) ^ (this.message_length == null ? 0 : this.message_length.hashCode())) * -2128831035) ^ (this.recipient_user_id == null ? 0 : this.recipient_user_id.hashCode())) * -2128831035) ^ (this.number_blocked_users == null ? 0 : this.number_blocked_users.hashCode())) * -2128831035;
        if (this.request_name != null) {
            i = this.request_name.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Chat{blocked_user_id=");
        stringBuilder.append(this.blocked_user_id);
        stringBuilder.append(", id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", existing_channel=");
        stringBuilder.append(this.existing_channel);
        stringBuilder.append(", image_upload_method=");
        stringBuilder.append(this.image_upload_method);
        stringBuilder.append(", user_added_method=");
        stringBuilder.append(this.user_added_method);
        stringBuilder.append(", invitation_id=");
        stringBuilder.append(this.invitation_id);
        stringBuilder.append(", invitation_type=");
        stringBuilder.append(this.invitation_type);
        stringBuilder.append(", members=");
        stringBuilder.append(this.members);
        stringBuilder.append(", invitation_preview_type=");
        stringBuilder.append(this.invitation_preview_type);
        stringBuilder.append(", message_type=");
        stringBuilder.append(this.message_type);
        stringBuilder.append(", number_channels=");
        stringBuilder.append(this.number_channels);
        stringBuilder.append(", number_pending_invites=");
        stringBuilder.append(this.number_pending_invites);
        stringBuilder.append(", number_members=");
        stringBuilder.append(this.number_members);
        stringBuilder.append(", number_unreads=");
        stringBuilder.append(this.number_unreads);
        stringBuilder.append(", reported_user_id=");
        stringBuilder.append(this.reported_user_id);
        stringBuilder.append(", sender_user_id=");
        stringBuilder.append(this.sender_user_id);
        stringBuilder.append(", invitation_timestamp=");
        stringBuilder.append(this.invitation_timestamp);
        stringBuilder.append(", message_length=");
        stringBuilder.append(this.message_length);
        stringBuilder.append(", recipient_user_id=");
        stringBuilder.append(this.recipient_user_id);
        stringBuilder.append(", number_blocked_users=");
        stringBuilder.append(this.number_blocked_users);
        stringBuilder.append(", request_name=");
        stringBuilder.append(this.request_name);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
