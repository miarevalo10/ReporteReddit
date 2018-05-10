package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class TwoFactorAuth {
    public static final Adapter<TwoFactorAuth, Builder> ADAPTER = new TwoFactorAuthAdapter();
    public final Boolean backup_code_used;
    public final String device_algorithm;
    public final Integer device_backup_codes_remaining;
    public final Boolean device_exists;
    public final String device_name;
    public final Long device_previous_remaining_backup_codes;
    public final Boolean otp_embedded_in_password;

    public static final class Builder implements StructBuilder<TwoFactorAuth> {
        private Boolean backup_code_used;
        private String device_algorithm;
        private Integer device_backup_codes_remaining;
        private Boolean device_exists;
        private String device_name;
        private Long device_previous_remaining_backup_codes;
        private Boolean otp_embedded_in_password;

        public Builder(TwoFactorAuth twoFactorAuth) {
            this.device_previous_remaining_backup_codes = twoFactorAuth.device_previous_remaining_backup_codes;
            this.device_name = twoFactorAuth.device_name;
            this.device_exists = twoFactorAuth.device_exists;
            this.device_algorithm = twoFactorAuth.device_algorithm;
            this.device_backup_codes_remaining = twoFactorAuth.device_backup_codes_remaining;
            this.backup_code_used = twoFactorAuth.backup_code_used;
            this.otp_embedded_in_password = twoFactorAuth.otp_embedded_in_password;
        }

        public final Builder device_previous_remaining_backup_codes(Long l) {
            this.device_previous_remaining_backup_codes = l;
            return this;
        }

        public final Builder device_name(String str) {
            this.device_name = str;
            return this;
        }

        public final Builder device_exists(Boolean bool) {
            this.device_exists = bool;
            return this;
        }

        public final Builder device_algorithm(String str) {
            this.device_algorithm = str;
            return this;
        }

        public final Builder device_backup_codes_remaining(Integer num) {
            this.device_backup_codes_remaining = num;
            return this;
        }

        public final Builder backup_code_used(Boolean bool) {
            this.backup_code_used = bool;
            return this;
        }

        public final Builder otp_embedded_in_password(Boolean bool) {
            this.otp_embedded_in_password = bool;
            return this;
        }

        public final TwoFactorAuth build() {
            return new TwoFactorAuth();
        }

        public final void reset() {
            this.device_previous_remaining_backup_codes = null;
            this.device_name = null;
            this.device_exists = null;
            this.device_algorithm = null;
            this.device_backup_codes_remaining = null;
            this.backup_code_used = null;
            this.otp_embedded_in_password = null;
        }
    }

    private static final class TwoFactorAuthAdapter implements Adapter<TwoFactorAuth, Builder> {
        private TwoFactorAuthAdapter() {
        }

        public final void write(Protocol protocol, TwoFactorAuth twoFactorAuth) throws IOException {
            if (twoFactorAuth.device_previous_remaining_backup_codes != null) {
                protocol.mo2638a(1, (byte) 10);
                protocol.mo2639a(twoFactorAuth.device_previous_remaining_backup_codes.longValue());
            }
            if (twoFactorAuth.device_name != null) {
                protocol.mo2638a(2, (byte) 11);
                protocol.mo2640a(twoFactorAuth.device_name);
            }
            if (twoFactorAuth.device_exists != null) {
                protocol.mo2638a(3, (byte) 2);
                protocol.mo2641a(twoFactorAuth.device_exists.booleanValue());
            }
            if (twoFactorAuth.device_algorithm != null) {
                protocol.mo2638a(4, (byte) 11);
                protocol.mo2640a(twoFactorAuth.device_algorithm);
            }
            if (twoFactorAuth.device_backup_codes_remaining != null) {
                protocol.mo2638a(5, (byte) 8);
                protocol.mo2637a(twoFactorAuth.device_backup_codes_remaining.intValue());
            }
            if (twoFactorAuth.backup_code_used != null) {
                protocol.mo2638a(6, (byte) 2);
                protocol.mo2641a(twoFactorAuth.backup_code_used.booleanValue());
            }
            if (twoFactorAuth.otp_embedded_in_password != null) {
                protocol.mo2638a(7, (byte) 2);
                protocol.mo2641a(twoFactorAuth.otp_embedded_in_password.booleanValue());
            }
            protocol.mo2634a();
        }

        public final TwoFactorAuth read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b != (byte) 0) {
                    switch (b.f10037c) {
                        case (short) 1:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.device_previous_remaining_backup_codes(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 2:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.device_name(protocol.mo2652l());
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.device_exists(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 4:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.device_algorithm(protocol.mo2652l());
                            break;
                        case (short) 5:
                            if (b.f10036b != (byte) 8) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.device_backup_codes_remaining(Integer.valueOf(protocol.mo2649i()));
                            break;
                        case (short) 6:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.backup_code_used(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 7:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.otp_embedded_in_password(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final TwoFactorAuth read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private TwoFactorAuth(Builder builder) {
        this.device_previous_remaining_backup_codes = builder.device_previous_remaining_backup_codes;
        this.device_name = builder.device_name;
        this.device_exists = builder.device_exists;
        this.device_algorithm = builder.device_algorithm;
        this.device_backup_codes_remaining = builder.device_backup_codes_remaining;
        this.backup_code_used = builder.backup_code_used;
        this.otp_embedded_in_password = builder.otp_embedded_in_password;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof TwoFactorAuth)) {
            return false;
        }
        TwoFactorAuth twoFactorAuth = (TwoFactorAuth) obj;
        if ((this.device_previous_remaining_backup_codes == twoFactorAuth.device_previous_remaining_backup_codes || (this.device_previous_remaining_backup_codes != null && this.device_previous_remaining_backup_codes.equals(twoFactorAuth.device_previous_remaining_backup_codes))) && ((this.device_name == twoFactorAuth.device_name || (this.device_name != null && this.device_name.equals(twoFactorAuth.device_name))) && ((this.device_exists == twoFactorAuth.device_exists || (this.device_exists != null && this.device_exists.equals(twoFactorAuth.device_exists))) && ((this.device_algorithm == twoFactorAuth.device_algorithm || (this.device_algorithm != null && this.device_algorithm.equals(twoFactorAuth.device_algorithm))) && ((this.device_backup_codes_remaining == twoFactorAuth.device_backup_codes_remaining || (this.device_backup_codes_remaining != null && this.device_backup_codes_remaining.equals(twoFactorAuth.device_backup_codes_remaining))) && (this.backup_code_used == twoFactorAuth.backup_code_used || (this.backup_code_used != null && this.backup_code_used.equals(twoFactorAuth.backup_code_used)))))))) {
            if (this.otp_embedded_in_password != twoFactorAuth.otp_embedded_in_password) {
                if (!(this.otp_embedded_in_password == null || this.otp_embedded_in_password.equals(twoFactorAuth.otp_embedded_in_password) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((((((((((this.device_previous_remaining_backup_codes == null ? 0 : this.device_previous_remaining_backup_codes.hashCode()) ^ 16777619) * -2128831035) ^ (this.device_name == null ? 0 : this.device_name.hashCode())) * -2128831035) ^ (this.device_exists == null ? 0 : this.device_exists.hashCode())) * -2128831035) ^ (this.device_algorithm == null ? 0 : this.device_algorithm.hashCode())) * -2128831035) ^ (this.device_backup_codes_remaining == null ? 0 : this.device_backup_codes_remaining.hashCode())) * -2128831035) ^ (this.backup_code_used == null ? 0 : this.backup_code_used.hashCode())) * -2128831035;
        if (this.otp_embedded_in_password != null) {
            i = this.otp_embedded_in_password.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("TwoFactorAuth{device_previous_remaining_backup_codes=");
        stringBuilder.append(this.device_previous_remaining_backup_codes);
        stringBuilder.append(", device_name=");
        stringBuilder.append(this.device_name);
        stringBuilder.append(", device_exists=");
        stringBuilder.append(this.device_exists);
        stringBuilder.append(", device_algorithm=");
        stringBuilder.append(this.device_algorithm);
        stringBuilder.append(", device_backup_codes_remaining=");
        stringBuilder.append(this.device_backup_codes_remaining);
        stringBuilder.append(", backup_code_used=");
        stringBuilder.append(this.backup_code_used);
        stringBuilder.append(", otp_embedded_in_password=");
        stringBuilder.append(this.otp_embedded_in_password);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
