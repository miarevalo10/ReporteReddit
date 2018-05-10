package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class Geo {
    public static final Adapter<Geo, Builder> ADAPTER = new GeoAdapter();
    public final Boolean anonymous;
    public final Boolean anonymous_vpn;
    public final String city;
    public final String country_code;
    public final Boolean hosting_provider;
    public final Boolean public_proxy;
    public final String region;
    public final String time_zone;
    public final Boolean tor_exit_node;

    public static final class Builder implements StructBuilder<Geo> {
        private Boolean anonymous;
        private Boolean anonymous_vpn;
        private String city;
        private String country_code;
        private Boolean hosting_provider;
        private Boolean public_proxy;
        private String region;
        private String time_zone;
        private Boolean tor_exit_node;

        public Builder(Geo geo) {
            this.country_code = geo.country_code;
            this.region = geo.region;
            this.city = geo.city;
            this.time_zone = geo.time_zone;
            this.anonymous = geo.anonymous;
            this.anonymous_vpn = geo.anonymous_vpn;
            this.hosting_provider = geo.hosting_provider;
            this.public_proxy = geo.public_proxy;
            this.tor_exit_node = geo.tor_exit_node;
        }

        public final Builder country_code(String str) {
            this.country_code = str;
            return this;
        }

        public final Builder region(String str) {
            this.region = str;
            return this;
        }

        public final Builder city(String str) {
            this.city = str;
            return this;
        }

        public final Builder time_zone(String str) {
            this.time_zone = str;
            return this;
        }

        public final Builder anonymous(Boolean bool) {
            this.anonymous = bool;
            return this;
        }

        public final Builder anonymous_vpn(Boolean bool) {
            this.anonymous_vpn = bool;
            return this;
        }

        public final Builder hosting_provider(Boolean bool) {
            this.hosting_provider = bool;
            return this;
        }

        public final Builder public_proxy(Boolean bool) {
            this.public_proxy = bool;
            return this;
        }

        public final Builder tor_exit_node(Boolean bool) {
            this.tor_exit_node = bool;
            return this;
        }

        public final Geo build() {
            return new Geo();
        }

        public final void reset() {
            this.country_code = null;
            this.region = null;
            this.city = null;
            this.time_zone = null;
            this.anonymous = null;
            this.anonymous_vpn = null;
            this.hosting_provider = null;
            this.public_proxy = null;
            this.tor_exit_node = null;
        }
    }

    private static final class GeoAdapter implements Adapter<Geo, Builder> {
        private GeoAdapter() {
        }

        public final void write(Protocol protocol, Geo geo) throws IOException {
            if (geo.country_code != null) {
                protocol.mo2638a(1, (byte) 11);
                protocol.mo2640a(geo.country_code);
            }
            if (geo.region != null) {
                protocol.mo2638a(2, (byte) 11);
                protocol.mo2640a(geo.region);
            }
            if (geo.city != null) {
                protocol.mo2638a(3, (byte) 11);
                protocol.mo2640a(geo.city);
            }
            if (geo.time_zone != null) {
                protocol.mo2638a(4, (byte) 11);
                protocol.mo2640a(geo.time_zone);
            }
            if (geo.anonymous != null) {
                protocol.mo2638a(5, (byte) 2);
                protocol.mo2641a(geo.anonymous.booleanValue());
            }
            if (geo.anonymous_vpn != null) {
                protocol.mo2638a(6, (byte) 2);
                protocol.mo2641a(geo.anonymous_vpn.booleanValue());
            }
            if (geo.hosting_provider != null) {
                protocol.mo2638a(7, (byte) 2);
                protocol.mo2641a(geo.hosting_provider.booleanValue());
            }
            if (geo.public_proxy != null) {
                protocol.mo2638a(8, (byte) 2);
                protocol.mo2641a(geo.public_proxy.booleanValue());
            }
            if (geo.tor_exit_node != null) {
                protocol.mo2638a(9, (byte) 2);
                protocol.mo2641a(geo.tor_exit_node.booleanValue());
            }
            protocol.mo2634a();
        }

        public final Geo read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b != (byte) 0) {
                    switch (b.f10037c) {
                        case (short) 1:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.country_code(protocol.mo2652l());
                            break;
                        case (short) 2:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.region(protocol.mo2652l());
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.city(protocol.mo2652l());
                            break;
                        case (short) 4:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.time_zone(protocol.mo2652l());
                            break;
                        case (short) 5:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.anonymous(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 6:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.anonymous_vpn(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 7:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.hosting_provider(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 8:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.public_proxy(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 9:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.tor_exit_node(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final Geo read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private Geo(Builder builder) {
        this.country_code = builder.country_code;
        this.region = builder.region;
        this.city = builder.city;
        this.time_zone = builder.time_zone;
        this.anonymous = builder.anonymous;
        this.anonymous_vpn = builder.anonymous_vpn;
        this.hosting_provider = builder.hosting_provider;
        this.public_proxy = builder.public_proxy;
        this.tor_exit_node = builder.tor_exit_node;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Geo)) {
            return false;
        }
        Geo geo = (Geo) obj;
        if ((this.country_code == geo.country_code || (this.country_code != null && this.country_code.equals(geo.country_code))) && ((this.region == geo.region || (this.region != null && this.region.equals(geo.region))) && ((this.city == geo.city || (this.city != null && this.city.equals(geo.city))) && ((this.time_zone == geo.time_zone || (this.time_zone != null && this.time_zone.equals(geo.time_zone))) && ((this.anonymous == geo.anonymous || (this.anonymous != null && this.anonymous.equals(geo.anonymous))) && ((this.anonymous_vpn == geo.anonymous_vpn || (this.anonymous_vpn != null && this.anonymous_vpn.equals(geo.anonymous_vpn))) && ((this.hosting_provider == geo.hosting_provider || (this.hosting_provider != null && this.hosting_provider.equals(geo.hosting_provider))) && (this.public_proxy == geo.public_proxy || (this.public_proxy != null && this.public_proxy.equals(geo.public_proxy)))))))))) {
            if (this.tor_exit_node != geo.tor_exit_node) {
                if (!(this.tor_exit_node == null || this.tor_exit_node.equals(geo.tor_exit_node) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((((((((((((((this.country_code == null ? 0 : this.country_code.hashCode()) ^ 16777619) * -2128831035) ^ (this.region == null ? 0 : this.region.hashCode())) * -2128831035) ^ (this.city == null ? 0 : this.city.hashCode())) * -2128831035) ^ (this.time_zone == null ? 0 : this.time_zone.hashCode())) * -2128831035) ^ (this.anonymous == null ? 0 : this.anonymous.hashCode())) * -2128831035) ^ (this.anonymous_vpn == null ? 0 : this.anonymous_vpn.hashCode())) * -2128831035) ^ (this.hosting_provider == null ? 0 : this.hosting_provider.hashCode())) * -2128831035) ^ (this.public_proxy == null ? 0 : this.public_proxy.hashCode())) * -2128831035;
        if (this.tor_exit_node != null) {
            i = this.tor_exit_node.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Geo{country_code=");
        stringBuilder.append(this.country_code);
        stringBuilder.append(", region=");
        stringBuilder.append(this.region);
        stringBuilder.append(", city=");
        stringBuilder.append(this.city);
        stringBuilder.append(", time_zone=");
        stringBuilder.append(this.time_zone);
        stringBuilder.append(", anonymous=");
        stringBuilder.append(this.anonymous);
        stringBuilder.append(", anonymous_vpn=");
        stringBuilder.append(this.anonymous_vpn);
        stringBuilder.append(", hosting_provider=");
        stringBuilder.append(this.hosting_provider);
        stringBuilder.append(", public_proxy=");
        stringBuilder.append(this.public_proxy);
        stringBuilder.append(", tor_exit_node=");
        stringBuilder.append(this.tor_exit_node);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
