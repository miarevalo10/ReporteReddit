package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class Admin {
    public static final Adapter<Admin, Builder> ADAPTER = new AdminAdapter();
    public final String id;

    private static final class AdminAdapter implements Adapter<Admin, Builder> {
        private AdminAdapter() {
        }

        public final void write(Protocol protocol, Admin admin) throws IOException {
            protocol.mo2638a(1, (byte) 11);
            protocol.mo2640a(admin.id);
            protocol.mo2634a();
        }

        public final Admin read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b == (byte) 0) {
                    return builder.build();
                }
                if (b.f10037c != (short) 1) {
                    ProtocolUtil.m8514a(protocol, b.f10036b);
                } else if (b.f10036b == (byte) 11) {
                    builder.id(protocol.mo2652l());
                } else {
                    ProtocolUtil.m8514a(protocol, b.f10036b);
                }
            }
        }

        public final Admin read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    public static final class Builder implements StructBuilder<Admin> {
        private String id;

        public Builder(Admin admin) {
            this.id = admin.id;
        }

        public final Builder id(String str) {
            if (str == null) {
                throw new NullPointerException("Required field 'id' cannot be null");
            }
            this.id = str;
            return this;
        }

        public final Admin build() {
            if (this.id != null) {
                return new Admin();
            }
            throw new IllegalStateException("Required field 'id' is missing");
        }

        public final void reset() {
            this.id = null;
        }
    }

    private Admin(Builder builder) {
        this.id = builder.id;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Admin)) {
            return false;
        }
        Admin admin = (Admin) obj;
        if (this.id != admin.id) {
            if (this.id.equals(admin.id) == null) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return (this.id.hashCode() ^ 16777619) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Admin{id=");
        stringBuilder.append(this.id);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
