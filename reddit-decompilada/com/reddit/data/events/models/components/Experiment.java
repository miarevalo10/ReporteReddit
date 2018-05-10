package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class Experiment {
    public static final Adapter<Experiment, Builder> ADAPTER = new ExperimentAdapter();
    public final String bucketing_key;
    public final Long end_timestamp;
    public final Long id;
    public final String name;
    public final String owner;
    public final Long start_timestamp;
    public final String variant;
    public final String version;

    public static final class Builder implements StructBuilder<Experiment> {
        private String bucketing_key;
        private Long end_timestamp;
        private Long id;
        private String name;
        private String owner;
        private Long start_timestamp;
        private String variant;
        private String version;

        public Builder(Experiment experiment) {
            this.id = experiment.id;
            this.name = experiment.name;
            this.owner = experiment.owner;
            this.variant = experiment.variant;
            this.start_timestamp = experiment.start_timestamp;
            this.end_timestamp = experiment.end_timestamp;
            this.bucketing_key = experiment.bucketing_key;
            this.version = experiment.version;
        }

        public final Builder id(Long l) {
            if (l == null) {
                throw new NullPointerException("Required field 'id' cannot be null");
            }
            this.id = l;
            return this;
        }

        public final Builder name(String str) {
            this.name = str;
            return this;
        }

        public final Builder owner(String str) {
            this.owner = str;
            return this;
        }

        public final Builder variant(String str) {
            if (str == null) {
                throw new NullPointerException("Required field 'variant' cannot be null");
            }
            this.variant = str;
            return this;
        }

        public final Builder start_timestamp(Long l) {
            this.start_timestamp = l;
            return this;
        }

        public final Builder end_timestamp(Long l) {
            this.end_timestamp = l;
            return this;
        }

        public final Builder bucketing_key(String str) {
            this.bucketing_key = str;
            return this;
        }

        public final Builder version(String str) {
            this.version = str;
            return this;
        }

        public final Experiment build() {
            if (this.id == null) {
                throw new IllegalStateException("Required field 'id' is missing");
            } else if (this.variant != null) {
                return new Experiment();
            } else {
                throw new IllegalStateException("Required field 'variant' is missing");
            }
        }

        public final void reset() {
            this.id = null;
            this.name = null;
            this.owner = null;
            this.variant = null;
            this.start_timestamp = null;
            this.end_timestamp = null;
            this.bucketing_key = null;
            this.version = null;
        }
    }

    private static final class ExperimentAdapter implements Adapter<Experiment, Builder> {
        private ExperimentAdapter() {
        }

        public final void write(Protocol protocol, Experiment experiment) throws IOException {
            protocol.mo2638a(1, (byte) 10);
            protocol.mo2639a(experiment.id.longValue());
            if (experiment.name != null) {
                protocol.mo2638a(2, (byte) 11);
                protocol.mo2640a(experiment.name);
            }
            if (experiment.owner != null) {
                protocol.mo2638a(3, (byte) 11);
                protocol.mo2640a(experiment.owner);
            }
            protocol.mo2638a(4, (byte) 11);
            protocol.mo2640a(experiment.variant);
            if (experiment.start_timestamp != null) {
                protocol.mo2638a(5, (byte) 10);
                protocol.mo2639a(experiment.start_timestamp.longValue());
            }
            if (experiment.end_timestamp != null) {
                protocol.mo2638a(6, (byte) 10);
                protocol.mo2639a(experiment.end_timestamp.longValue());
            }
            if (experiment.bucketing_key != null) {
                protocol.mo2638a(7, (byte) 11);
                protocol.mo2640a(experiment.bucketing_key);
            }
            if (experiment.version != null) {
                protocol.mo2638a(8, (byte) 11);
                protocol.mo2640a(experiment.version);
            }
            protocol.mo2634a();
        }

        public final Experiment read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b != (byte) 0) {
                    switch (b.f10037c) {
                        case (short) 1:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.id(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 2:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.name(protocol.mo2652l());
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.owner(protocol.mo2652l());
                            break;
                        case (short) 4:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.variant(protocol.mo2652l());
                            break;
                        case (short) 5:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.start_timestamp(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 6:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.end_timestamp(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 7:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.bucketing_key(protocol.mo2652l());
                            break;
                        case (short) 8:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.version(protocol.mo2652l());
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final Experiment read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private Experiment(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.owner = builder.owner;
        this.variant = builder.variant;
        this.start_timestamp = builder.start_timestamp;
        this.end_timestamp = builder.end_timestamp;
        this.bucketing_key = builder.bucketing_key;
        this.version = builder.version;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Experiment)) {
            return false;
        }
        Experiment experiment = (Experiment) obj;
        if ((this.id == experiment.id || this.id.equals(experiment.id)) && ((this.name == experiment.name || (this.name != null && this.name.equals(experiment.name))) && ((this.owner == experiment.owner || (this.owner != null && this.owner.equals(experiment.owner))) && ((this.variant == experiment.variant || this.variant.equals(experiment.variant)) && ((this.start_timestamp == experiment.start_timestamp || (this.start_timestamp != null && this.start_timestamp.equals(experiment.start_timestamp))) && ((this.end_timestamp == experiment.end_timestamp || (this.end_timestamp != null && this.end_timestamp.equals(experiment.end_timestamp))) && (this.bucketing_key == experiment.bucketing_key || (this.bucketing_key != null && this.bucketing_key.equals(experiment.bucketing_key))))))))) {
            if (this.version != experiment.version) {
                if (!(this.version == null || this.version.equals(experiment.version) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((((this.id.hashCode() ^ 16777619) * -2128831035) ^ (this.name == null ? 0 : this.name.hashCode())) * -2128831035) ^ (this.owner == null ? 0 : this.owner.hashCode())) * -2128831035) ^ this.variant.hashCode()) * -2128831035) ^ (this.start_timestamp == null ? 0 : this.start_timestamp.hashCode())) * -2128831035) ^ (this.end_timestamp == null ? 0 : this.end_timestamp.hashCode())) * -2128831035) ^ (this.bucketing_key == null ? 0 : this.bucketing_key.hashCode())) * -2128831035;
        if (this.version != null) {
            i = this.version.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Experiment{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", owner=");
        stringBuilder.append(this.owner);
        stringBuilder.append(", variant=");
        stringBuilder.append(this.variant);
        stringBuilder.append(", start_timestamp=");
        stringBuilder.append(this.start_timestamp);
        stringBuilder.append(", end_timestamp=");
        stringBuilder.append(this.end_timestamp);
        stringBuilder.append(", bucketing_key=");
        stringBuilder.append(this.bucketing_key);
        stringBuilder.append(", version=");
        stringBuilder.append(this.version);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
