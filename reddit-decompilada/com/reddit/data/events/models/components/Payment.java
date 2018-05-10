package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class Payment {
    public static final Adapter<Payment, Builder> ADAPTER = new PaymentAdapter();
    public final Long amount_in_smallest_denom;
    public final String currency;
    public final String method;

    public static final class Builder implements StructBuilder<Payment> {
        private Long amount_in_smallest_denom;
        private String currency;
        private String method;

        public Builder(Payment payment) {
            this.method = payment.method;
            this.currency = payment.currency;
            this.amount_in_smallest_denom = payment.amount_in_smallest_denom;
        }

        public final Builder method(String str) {
            this.method = str;
            return this;
        }

        public final Builder currency(String str) {
            this.currency = str;
            return this;
        }

        public final Builder amount_in_smallest_denom(Long l) {
            this.amount_in_smallest_denom = l;
            return this;
        }

        public final Payment build() {
            return new Payment();
        }

        public final void reset() {
            this.method = null;
            this.currency = null;
            this.amount_in_smallest_denom = null;
        }
    }

    private static final class PaymentAdapter implements Adapter<Payment, Builder> {
        private PaymentAdapter() {
        }

        public final void write(Protocol protocol, Payment payment) throws IOException {
            if (payment.method != null) {
                protocol.mo2638a(1, (byte) 11);
                protocol.mo2640a(payment.method);
            }
            if (payment.currency != null) {
                protocol.mo2638a(2, (byte) 11);
                protocol.mo2640a(payment.currency);
            }
            if (payment.amount_in_smallest_denom != null) {
                protocol.mo2638a(3, (byte) 10);
                protocol.mo2639a(payment.amount_in_smallest_denom.longValue());
            }
            protocol.mo2634a();
        }

        public final Payment read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b != (byte) 0) {
                    switch (b.f10037c) {
                        case (short) 1:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.method(protocol.mo2652l());
                            break;
                        case (short) 2:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.currency(protocol.mo2652l());
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.amount_in_smallest_denom(Long.valueOf(protocol.mo2650j()));
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final Payment read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private Payment(Builder builder) {
        this.method = builder.method;
        this.currency = builder.currency;
        this.amount_in_smallest_denom = builder.amount_in_smallest_denom;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Payment)) {
            return false;
        }
        Payment payment = (Payment) obj;
        if ((this.method == payment.method || (this.method != null && this.method.equals(payment.method))) && (this.currency == payment.currency || (this.currency != null && this.currency.equals(payment.currency)))) {
            if (this.amount_in_smallest_denom != payment.amount_in_smallest_denom) {
                if (!(this.amount_in_smallest_denom == null || this.amount_in_smallest_denom.equals(payment.amount_in_smallest_denom) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((this.method == null ? 0 : this.method.hashCode()) ^ 16777619) * -2128831035) ^ (this.currency == null ? 0 : this.currency.hashCode())) * -2128831035;
        if (this.amount_in_smallest_denom != null) {
            i = this.amount_in_smallest_denom.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Payment{method=");
        stringBuilder.append(this.method);
        stringBuilder.append(", currency=");
        stringBuilder.append(this.currency);
        stringBuilder.append(", amount_in_smallest_denom=");
        stringBuilder.append(this.amount_in_smallest_denom);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
