package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class Platform {
    public static final Adapter<Platform, Builder> ADAPTER = new PlatformAdapter();
    public final String browser_name;
    public final String browser_version;
    public final String device_id;
    public final String device_name;
    public final String fingerprint;
    public final Long fingerprint_created_timestamp;
    public final String name;
    public final String os_name;
    public final String os_version;

    public static final class Builder implements StructBuilder<Platform> {
        private String browser_name;
        private String browser_version;
        private String device_id;
        private String device_name;
        private String fingerprint;
        private Long fingerprint_created_timestamp;
        private String name;
        private String os_name;
        private String os_version;

        public Builder(Platform platform) {
            this.name = platform.name;
            this.device_id = platform.device_id;
            this.device_name = platform.device_name;
            this.os_name = platform.os_name;
            this.os_version = platform.os_version;
            this.browser_name = platform.browser_name;
            this.browser_version = platform.browser_version;
            this.fingerprint = platform.fingerprint;
            this.fingerprint_created_timestamp = platform.fingerprint_created_timestamp;
        }

        public final Builder name(String str) {
            this.name = str;
            return this;
        }

        public final Builder device_id(String str) {
            this.device_id = str;
            return this;
        }

        public final Builder device_name(String str) {
            this.device_name = str;
            return this;
        }

        public final Builder os_name(String str) {
            this.os_name = str;
            return this;
        }

        public final Builder os_version(String str) {
            this.os_version = str;
            return this;
        }

        public final Builder browser_name(String str) {
            this.browser_name = str;
            return this;
        }

        public final Builder browser_version(String str) {
            this.browser_version = str;
            return this;
        }

        public final Builder fingerprint(String str) {
            this.fingerprint = str;
            return this;
        }

        public final Builder fingerprint_created_timestamp(Long l) {
            this.fingerprint_created_timestamp = l;
            return this;
        }

        public final Platform build() {
            return new Platform();
        }

        public final void reset() {
            this.name = null;
            this.device_id = null;
            this.device_name = null;
            this.os_name = null;
            this.os_version = null;
            this.browser_name = null;
            this.browser_version = null;
            this.fingerprint = null;
            this.fingerprint_created_timestamp = null;
        }
    }

    private static final class PlatformAdapter implements Adapter<Platform, Builder> {
        private PlatformAdapter() {
        }

        public final void write(Protocol protocol, Platform platform) throws IOException {
            if (platform.name != null) {
                protocol.mo2638a(1, (byte) 11);
                protocol.mo2640a(platform.name);
            }
            if (platform.device_id != null) {
                protocol.mo2638a(2, (byte) 11);
                protocol.mo2640a(platform.device_id);
            }
            if (platform.device_name != null) {
                protocol.mo2638a(3, (byte) 11);
                protocol.mo2640a(platform.device_name);
            }
            if (platform.os_name != null) {
                protocol.mo2638a(4, (byte) 11);
                protocol.mo2640a(platform.os_name);
            }
            if (platform.os_version != null) {
                protocol.mo2638a(5, (byte) 11);
                protocol.mo2640a(platform.os_version);
            }
            if (platform.browser_name != null) {
                protocol.mo2638a(6, (byte) 11);
                protocol.mo2640a(platform.browser_name);
            }
            if (platform.browser_version != null) {
                protocol.mo2638a(7, (byte) 11);
                protocol.mo2640a(platform.browser_version);
            }
            if (platform.fingerprint != null) {
                protocol.mo2638a(8, (byte) 11);
                protocol.mo2640a(platform.fingerprint);
            }
            if (platform.fingerprint_created_timestamp != null) {
                protocol.mo2638a(9, (byte) 10);
                protocol.mo2639a(platform.fingerprint_created_timestamp.longValue());
            }
            protocol.mo2634a();
        }

        public final Platform read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b != (byte) 0) {
                    switch (b.f10037c) {
                        case (short) 1:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.name(protocol.mo2652l());
                            break;
                        case (short) 2:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.device_id(protocol.mo2652l());
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.device_name(protocol.mo2652l());
                            break;
                        case (short) 4:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.os_name(protocol.mo2652l());
                            break;
                        case (short) 5:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.os_version(protocol.mo2652l());
                            break;
                        case (short) 6:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.browser_name(protocol.mo2652l());
                            break;
                        case (short) 7:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.browser_version(protocol.mo2652l());
                            break;
                        case (short) 8:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.fingerprint(protocol.mo2652l());
                            break;
                        case (short) 9:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.fingerprint_created_timestamp(Long.valueOf(protocol.mo2650j()));
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final Platform read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private Platform(Builder builder) {
        this.name = builder.name;
        this.device_id = builder.device_id;
        this.device_name = builder.device_name;
        this.os_name = builder.os_name;
        this.os_version = builder.os_version;
        this.browser_name = builder.browser_name;
        this.browser_version = builder.browser_version;
        this.fingerprint = builder.fingerprint;
        this.fingerprint_created_timestamp = builder.fingerprint_created_timestamp;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Platform)) {
            return false;
        }
        Platform platform = (Platform) obj;
        if ((this.name == platform.name || (this.name != null && this.name.equals(platform.name))) && ((this.device_id == platform.device_id || (this.device_id != null && this.device_id.equals(platform.device_id))) && ((this.device_name == platform.device_name || (this.device_name != null && this.device_name.equals(platform.device_name))) && ((this.os_name == platform.os_name || (this.os_name != null && this.os_name.equals(platform.os_name))) && ((this.os_version == platform.os_version || (this.os_version != null && this.os_version.equals(platform.os_version))) && ((this.browser_name == platform.browser_name || (this.browser_name != null && this.browser_name.equals(platform.browser_name))) && ((this.browser_version == platform.browser_version || (this.browser_version != null && this.browser_version.equals(platform.browser_version))) && (this.fingerprint == platform.fingerprint || (this.fingerprint != null && this.fingerprint.equals(platform.fingerprint)))))))))) {
            if (this.fingerprint_created_timestamp != platform.fingerprint_created_timestamp) {
                if (!(this.fingerprint_created_timestamp == null || this.fingerprint_created_timestamp.equals(platform.fingerprint_created_timestamp) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((((((((((((((this.name == null ? 0 : this.name.hashCode()) ^ 16777619) * -2128831035) ^ (this.device_id == null ? 0 : this.device_id.hashCode())) * -2128831035) ^ (this.device_name == null ? 0 : this.device_name.hashCode())) * -2128831035) ^ (this.os_name == null ? 0 : this.os_name.hashCode())) * -2128831035) ^ (this.os_version == null ? 0 : this.os_version.hashCode())) * -2128831035) ^ (this.browser_name == null ? 0 : this.browser_name.hashCode())) * -2128831035) ^ (this.browser_version == null ? 0 : this.browser_version.hashCode())) * -2128831035) ^ (this.fingerprint == null ? 0 : this.fingerprint.hashCode())) * -2128831035;
        if (this.fingerprint_created_timestamp != null) {
            i = this.fingerprint_created_timestamp.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Platform{name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", device_id=");
        stringBuilder.append(this.device_id);
        stringBuilder.append(", device_name=");
        stringBuilder.append(this.device_name);
        stringBuilder.append(", os_name=");
        stringBuilder.append(this.os_name);
        stringBuilder.append(", os_version=");
        stringBuilder.append(this.os_version);
        stringBuilder.append(", browser_name=");
        stringBuilder.append(this.browser_name);
        stringBuilder.append(", browser_version=");
        stringBuilder.append(this.browser_version);
        stringBuilder.append(", fingerprint=");
        stringBuilder.append(this.fingerprint);
        stringBuilder.append(", fingerprint_created_timestamp=");
        stringBuilder.append(this.fingerprint_created_timestamp);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
