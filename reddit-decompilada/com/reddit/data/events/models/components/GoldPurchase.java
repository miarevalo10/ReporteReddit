package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class GoldPurchase {
    public static final Adapter<GoldPurchase, Builder> ADAPTER = new GoldPurchaseAdapter();
    public final Boolean gift_anonymous;
    public final Boolean gift_message;
    public final Integer gift_message_length;
    public final String gift_user_id;
    public final Boolean gilded_content;
    public final Integer number_creddits;
    public final Integer number_months;
    public final String one_time_type;
    public final String source;
    public final String subscription_type;
    public final String type;

    public static final class Builder implements StructBuilder<GoldPurchase> {
        private Boolean gift_anonymous;
        private Boolean gift_message;
        private Integer gift_message_length;
        private String gift_user_id;
        private Boolean gilded_content;
        private Integer number_creddits;
        private Integer number_months;
        private String one_time_type;
        private String source;
        private String subscription_type;
        private String type;

        public Builder(GoldPurchase goldPurchase) {
            this.type = goldPurchase.type;
            this.number_months = goldPurchase.number_months;
            this.one_time_type = goldPurchase.one_time_type;
            this.gift_user_id = goldPurchase.gift_user_id;
            this.gift_anonymous = goldPurchase.gift_anonymous;
            this.gift_message = goldPurchase.gift_message;
            this.gift_message_length = goldPurchase.gift_message_length;
            this.number_creddits = goldPurchase.number_creddits;
            this.subscription_type = goldPurchase.subscription_type;
            this.gilded_content = goldPurchase.gilded_content;
            this.source = goldPurchase.source;
        }

        public final Builder type(String str) {
            if (str == null) {
                throw new NullPointerException("Required field 'type' cannot be null");
            }
            this.type = str;
            return this;
        }

        public final Builder number_months(Integer num) {
            this.number_months = num;
            return this;
        }

        public final Builder one_time_type(String str) {
            this.one_time_type = str;
            return this;
        }

        public final Builder gift_user_id(String str) {
            this.gift_user_id = str;
            return this;
        }

        public final Builder gift_anonymous(Boolean bool) {
            this.gift_anonymous = bool;
            return this;
        }

        public final Builder gift_message(Boolean bool) {
            this.gift_message = bool;
            return this;
        }

        public final Builder gift_message_length(Integer num) {
            this.gift_message_length = num;
            return this;
        }

        public final Builder number_creddits(Integer num) {
            this.number_creddits = num;
            return this;
        }

        public final Builder subscription_type(String str) {
            this.subscription_type = str;
            return this;
        }

        public final Builder gilded_content(Boolean bool) {
            this.gilded_content = bool;
            return this;
        }

        public final Builder source(String str) {
            this.source = str;
            return this;
        }

        public final GoldPurchase build() {
            if (this.type != null) {
                return new GoldPurchase();
            }
            throw new IllegalStateException("Required field 'type' is missing");
        }

        public final void reset() {
            this.type = null;
            this.number_months = null;
            this.one_time_type = null;
            this.gift_user_id = null;
            this.gift_anonymous = null;
            this.gift_message = null;
            this.gift_message_length = null;
            this.number_creddits = null;
            this.subscription_type = null;
            this.gilded_content = null;
            this.source = null;
        }
    }

    private static final class GoldPurchaseAdapter implements Adapter<GoldPurchase, Builder> {
        private GoldPurchaseAdapter() {
        }

        public final void write(Protocol protocol, GoldPurchase goldPurchase) throws IOException {
            protocol.mo2638a(1, (byte) 11);
            protocol.mo2640a(goldPurchase.type);
            if (goldPurchase.number_months != null) {
                protocol.mo2638a(2, (byte) 8);
                protocol.mo2637a(goldPurchase.number_months.intValue());
            }
            if (goldPurchase.one_time_type != null) {
                protocol.mo2638a(3, (byte) 11);
                protocol.mo2640a(goldPurchase.one_time_type);
            }
            if (goldPurchase.gift_user_id != null) {
                protocol.mo2638a(4, (byte) 11);
                protocol.mo2640a(goldPurchase.gift_user_id);
            }
            if (goldPurchase.gift_anonymous != null) {
                protocol.mo2638a(5, (byte) 2);
                protocol.mo2641a(goldPurchase.gift_anonymous.booleanValue());
            }
            if (goldPurchase.gift_message != null) {
                protocol.mo2638a(6, (byte) 2);
                protocol.mo2641a(goldPurchase.gift_message.booleanValue());
            }
            if (goldPurchase.gift_message_length != null) {
                protocol.mo2638a(7, (byte) 8);
                protocol.mo2637a(goldPurchase.gift_message_length.intValue());
            }
            if (goldPurchase.number_creddits != null) {
                protocol.mo2638a(8, (byte) 8);
                protocol.mo2637a(goldPurchase.number_creddits.intValue());
            }
            if (goldPurchase.subscription_type != null) {
                protocol.mo2638a(9, (byte) 11);
                protocol.mo2640a(goldPurchase.subscription_type);
            }
            if (goldPurchase.gilded_content != null) {
                protocol.mo2638a(10, (byte) 2);
                protocol.mo2641a(goldPurchase.gilded_content.booleanValue());
            }
            if (goldPurchase.source != null) {
                protocol.mo2638a(11, (byte) 11);
                protocol.mo2640a(goldPurchase.source);
            }
            protocol.mo2634a();
        }

        public final GoldPurchase read(Protocol protocol, Builder builder) throws IOException {
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
                            if (b.f10036b != (byte) 8) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.number_months(Integer.valueOf(protocol.mo2649i()));
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.one_time_type(protocol.mo2652l());
                            break;
                        case (short) 4:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.gift_user_id(protocol.mo2652l());
                            break;
                        case (short) 5:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.gift_anonymous(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 6:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.gift_message(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 7:
                            if (b.f10036b != (byte) 8) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.gift_message_length(Integer.valueOf(protocol.mo2649i()));
                            break;
                        case (short) 8:
                            if (b.f10036b != (byte) 8) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.number_creddits(Integer.valueOf(protocol.mo2649i()));
                            break;
                        case (short) 9:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.subscription_type(protocol.mo2652l());
                            break;
                        case (short) 10:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.gilded_content(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 11:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.source(protocol.mo2652l());
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final GoldPurchase read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private GoldPurchase(Builder builder) {
        this.type = builder.type;
        this.number_months = builder.number_months;
        this.one_time_type = builder.one_time_type;
        this.gift_user_id = builder.gift_user_id;
        this.gift_anonymous = builder.gift_anonymous;
        this.gift_message = builder.gift_message;
        this.gift_message_length = builder.gift_message_length;
        this.number_creddits = builder.number_creddits;
        this.subscription_type = builder.subscription_type;
        this.gilded_content = builder.gilded_content;
        this.source = builder.source;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GoldPurchase)) {
            return false;
        }
        GoldPurchase goldPurchase = (GoldPurchase) obj;
        if ((this.type == goldPurchase.type || this.type.equals(goldPurchase.type)) && ((this.number_months == goldPurchase.number_months || (this.number_months != null && this.number_months.equals(goldPurchase.number_months))) && ((this.one_time_type == goldPurchase.one_time_type || (this.one_time_type != null && this.one_time_type.equals(goldPurchase.one_time_type))) && ((this.gift_user_id == goldPurchase.gift_user_id || (this.gift_user_id != null && this.gift_user_id.equals(goldPurchase.gift_user_id))) && ((this.gift_anonymous == goldPurchase.gift_anonymous || (this.gift_anonymous != null && this.gift_anonymous.equals(goldPurchase.gift_anonymous))) && ((this.gift_message == goldPurchase.gift_message || (this.gift_message != null && this.gift_message.equals(goldPurchase.gift_message))) && ((this.gift_message_length == goldPurchase.gift_message_length || (this.gift_message_length != null && this.gift_message_length.equals(goldPurchase.gift_message_length))) && ((this.number_creddits == goldPurchase.number_creddits || (this.number_creddits != null && this.number_creddits.equals(goldPurchase.number_creddits))) && ((this.subscription_type == goldPurchase.subscription_type || (this.subscription_type != null && this.subscription_type.equals(goldPurchase.subscription_type))) && (this.gilded_content == goldPurchase.gilded_content || (this.gilded_content != null && this.gilded_content.equals(goldPurchase.gilded_content)))))))))))) {
            if (this.source != goldPurchase.source) {
                if (!(this.source == null || this.source.equals(goldPurchase.source) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((((((((((this.type.hashCode() ^ 16777619) * -2128831035) ^ (this.number_months == null ? 0 : this.number_months.hashCode())) * -2128831035) ^ (this.one_time_type == null ? 0 : this.one_time_type.hashCode())) * -2128831035) ^ (this.gift_user_id == null ? 0 : this.gift_user_id.hashCode())) * -2128831035) ^ (this.gift_anonymous == null ? 0 : this.gift_anonymous.hashCode())) * -2128831035) ^ (this.gift_message == null ? 0 : this.gift_message.hashCode())) * -2128831035) ^ (this.gift_message_length == null ? 0 : this.gift_message_length.hashCode())) * -2128831035) ^ (this.number_creddits == null ? 0 : this.number_creddits.hashCode())) * -2128831035) ^ (this.subscription_type == null ? 0 : this.subscription_type.hashCode())) * -2128831035) ^ (this.gilded_content == null ? 0 : this.gilded_content.hashCode())) * -2128831035;
        if (this.source != null) {
            i = this.source.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("GoldPurchase{type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", number_months=");
        stringBuilder.append(this.number_months);
        stringBuilder.append(", one_time_type=");
        stringBuilder.append(this.one_time_type);
        stringBuilder.append(", gift_user_id=");
        stringBuilder.append(this.gift_user_id);
        stringBuilder.append(", gift_anonymous=");
        stringBuilder.append(this.gift_anonymous);
        stringBuilder.append(", gift_message=");
        stringBuilder.append(this.gift_message);
        stringBuilder.append(", gift_message_length=");
        stringBuilder.append(this.gift_message_length);
        stringBuilder.append(", number_creddits=");
        stringBuilder.append(this.number_creddits);
        stringBuilder.append(", subscription_type=");
        stringBuilder.append(this.subscription_type);
        stringBuilder.append(", gilded_content=");
        stringBuilder.append(this.gilded_content);
        stringBuilder.append(", source=");
        stringBuilder.append(this.source);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
