package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class User {
    public static final Adapter<User, Builder> ADAPTER = new UserAdapter();
    public final Long cookie_created_timestamp;
    public final Long created_timestamp;
    public final Boolean has_gold;
    public final String id;
    public final Boolean logged_in;
    public final Long number_creddits;

    public static final class Builder implements StructBuilder<User> {
        private Long cookie_created_timestamp;
        private Long created_timestamp;
        private Boolean has_gold;
        private String id;
        private Boolean logged_in;
        private Long number_creddits;

        public Builder(User user) {
            this.id = user.id;
            this.created_timestamp = user.created_timestamp;
            this.logged_in = user.logged_in;
            this.cookie_created_timestamp = user.cookie_created_timestamp;
            this.has_gold = user.has_gold;
            this.number_creddits = user.number_creddits;
        }

        public final Builder id(String str) {
            if (str == null) {
                throw new NullPointerException("Required field 'id' cannot be null");
            }
            this.id = str;
            return this;
        }

        public final Builder created_timestamp(Long l) {
            this.created_timestamp = l;
            return this;
        }

        public final Builder logged_in(Boolean bool) {
            this.logged_in = bool;
            return this;
        }

        public final Builder cookie_created_timestamp(Long l) {
            this.cookie_created_timestamp = l;
            return this;
        }

        public final Builder has_gold(Boolean bool) {
            this.has_gold = bool;
            return this;
        }

        public final Builder number_creddits(Long l) {
            this.number_creddits = l;
            return this;
        }

        public final User build() {
            if (this.id != null) {
                return new User();
            }
            throw new IllegalStateException("Required field 'id' is missing");
        }

        public final void reset() {
            this.id = null;
            this.created_timestamp = null;
            this.logged_in = null;
            this.cookie_created_timestamp = null;
            this.has_gold = null;
            this.number_creddits = null;
        }
    }

    private static final class UserAdapter implements Adapter<User, Builder> {
        private UserAdapter() {
        }

        public final void write(Protocol protocol, User user) throws IOException {
            protocol.mo2638a(1, (byte) 11);
            protocol.mo2640a(user.id);
            if (user.created_timestamp != null) {
                protocol.mo2638a(2, (byte) 10);
                protocol.mo2639a(user.created_timestamp.longValue());
            }
            if (user.logged_in != null) {
                protocol.mo2638a(3, (byte) 2);
                protocol.mo2641a(user.logged_in.booleanValue());
            }
            if (user.cookie_created_timestamp != null) {
                protocol.mo2638a(4, (byte) 10);
                protocol.mo2639a(user.cookie_created_timestamp.longValue());
            }
            if (user.has_gold != null) {
                protocol.mo2638a(5, (byte) 2);
                protocol.mo2641a(user.has_gold.booleanValue());
            }
            if (user.number_creddits != null) {
                protocol.mo2638a(11, (byte) 10);
                protocol.mo2639a(user.number_creddits.longValue());
            }
            protocol.mo2634a();
        }

        public final User read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b == (byte) 0) {
                    return builder.build();
                }
                short s = b.f10037c;
                if (s != (short) 11) {
                    switch (s) {
                        case (short) 1:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.id(protocol.mo2652l());
                            break;
                        case (short) 2:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.created_timestamp(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.logged_in(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 4:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.cookie_created_timestamp(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 5:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.has_gold(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                } else if (b.f10036b == (byte) 10) {
                    builder.number_creddits(Long.valueOf(protocol.mo2650j()));
                } else {
                    ProtocolUtil.m8514a(protocol, b.f10036b);
                }
            }
        }

        public final User read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private User(Builder builder) {
        this.id = builder.id;
        this.created_timestamp = builder.created_timestamp;
        this.logged_in = builder.logged_in;
        this.cookie_created_timestamp = builder.cookie_created_timestamp;
        this.has_gold = builder.has_gold;
        this.number_creddits = builder.number_creddits;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        if ((this.id == user.id || this.id.equals(user.id)) && ((this.created_timestamp == user.created_timestamp || (this.created_timestamp != null && this.created_timestamp.equals(user.created_timestamp))) && ((this.logged_in == user.logged_in || (this.logged_in != null && this.logged_in.equals(user.logged_in))) && ((this.cookie_created_timestamp == user.cookie_created_timestamp || (this.cookie_created_timestamp != null && this.cookie_created_timestamp.equals(user.cookie_created_timestamp))) && (this.has_gold == user.has_gold || (this.has_gold != null && this.has_gold.equals(user.has_gold))))))) {
            if (this.number_creddits != user.number_creddits) {
                if (!(this.number_creddits == null || this.number_creddits.equals(user.number_creddits) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((this.id.hashCode() ^ 16777619) * -2128831035) ^ (this.created_timestamp == null ? 0 : this.created_timestamp.hashCode())) * -2128831035) ^ (this.logged_in == null ? 0 : this.logged_in.hashCode())) * -2128831035) ^ (this.cookie_created_timestamp == null ? 0 : this.cookie_created_timestamp.hashCode())) * -2128831035) ^ (this.has_gold == null ? 0 : this.has_gold.hashCode())) * -2128831035;
        if (this.number_creddits != null) {
            i = this.number_creddits.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("User{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", created_timestamp=");
        stringBuilder.append(this.created_timestamp);
        stringBuilder.append(", logged_in=");
        stringBuilder.append(this.logged_in);
        stringBuilder.append(", cookie_created_timestamp=");
        stringBuilder.append(this.cookie_created_timestamp);
        stringBuilder.append(", has_gold=");
        stringBuilder.append(this.has_gold);
        stringBuilder.append(", number_creddits=");
        stringBuilder.append(this.number_creddits);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
