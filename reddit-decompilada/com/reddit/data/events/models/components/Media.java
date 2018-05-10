package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class Media {
    public static final Adapter<Media, Builder> ADAPTER = new MediaAdapter();
    public final Long duration;
    public final String file_name;
    public final Long height;
    public final String id;
    public final Long load_time;
    public final Long max_time_served;
    public final String mimetype;
    public final String orientation;
    public final Boolean pinned;
    public final Long size;
    public final String source;
    public final String thumbnail_url;
    public final Long time;
    public final String type;
    public final Long upload_duration;
    public final String url;
    public final Long width;

    public static final class Builder implements StructBuilder<Media> {
        private Long duration;
        private String file_name;
        private Long height;
        private String id;
        private Long load_time;
        private Long max_time_served;
        private String mimetype;
        private String orientation;
        private Boolean pinned;
        private Long size;
        private String source;
        private String thumbnail_url;
        private Long time;
        private String type;
        private Long upload_duration;
        private String url;
        private Long width;

        public Builder(Media media) {
            this.width = media.width;
            this.height = media.height;
            this.load_time = media.load_time;
            this.id = media.id;
            this.orientation = media.orientation;
            this.duration = media.duration;
            this.time = media.time;
            this.pinned = media.pinned;
            this.max_time_served = media.max_time_served;
            this.mimetype = media.mimetype;
            this.size = media.size;
            this.url = media.url;
            this.source = media.source;
            this.upload_duration = media.upload_duration;
            this.file_name = media.file_name;
            this.type = media.type;
            this.thumbnail_url = media.thumbnail_url;
        }

        public final Builder width(Long l) {
            this.width = l;
            return this;
        }

        public final Builder height(Long l) {
            this.height = l;
            return this;
        }

        public final Builder load_time(Long l) {
            this.load_time = l;
            return this;
        }

        public final Builder id(String str) {
            this.id = str;
            return this;
        }

        public final Builder orientation(String str) {
            this.orientation = str;
            return this;
        }

        public final Builder duration(Long l) {
            this.duration = l;
            return this;
        }

        public final Builder time(Long l) {
            this.time = l;
            return this;
        }

        public final Builder pinned(Boolean bool) {
            this.pinned = bool;
            return this;
        }

        public final Builder max_time_served(Long l) {
            this.max_time_served = l;
            return this;
        }

        public final Builder mimetype(String str) {
            this.mimetype = str;
            return this;
        }

        public final Builder size(Long l) {
            this.size = l;
            return this;
        }

        public final Builder url(String str) {
            this.url = str;
            return this;
        }

        public final Builder source(String str) {
            this.source = str;
            return this;
        }

        public final Builder upload_duration(Long l) {
            this.upload_duration = l;
            return this;
        }

        public final Builder file_name(String str) {
            this.file_name = str;
            return this;
        }

        public final Builder type(String str) {
            this.type = str;
            return this;
        }

        public final Builder thumbnail_url(String str) {
            this.thumbnail_url = str;
            return this;
        }

        public final Media build() {
            return new Media();
        }

        public final void reset() {
            this.width = null;
            this.height = null;
            this.load_time = null;
            this.id = null;
            this.orientation = null;
            this.duration = null;
            this.time = null;
            this.pinned = null;
            this.max_time_served = null;
            this.mimetype = null;
            this.size = null;
            this.url = null;
            this.source = null;
            this.upload_duration = null;
            this.file_name = null;
            this.type = null;
            this.thumbnail_url = null;
        }
    }

    private static final class MediaAdapter implements Adapter<Media, Builder> {
        private MediaAdapter() {
        }

        public final void write(Protocol protocol, Media media) throws IOException {
            if (media.width != null) {
                protocol.mo2638a(1, (byte) 10);
                protocol.mo2639a(media.width.longValue());
            }
            if (media.height != null) {
                protocol.mo2638a(2, (byte) 10);
                protocol.mo2639a(media.height.longValue());
            }
            if (media.load_time != null) {
                protocol.mo2638a(3, (byte) 10);
                protocol.mo2639a(media.load_time.longValue());
            }
            if (media.id != null) {
                protocol.mo2638a(4, (byte) 11);
                protocol.mo2640a(media.id);
            }
            if (media.orientation != null) {
                protocol.mo2638a(5, (byte) 11);
                protocol.mo2640a(media.orientation);
            }
            if (media.duration != null) {
                protocol.mo2638a(6, (byte) 10);
                protocol.mo2639a(media.duration.longValue());
            }
            if (media.time != null) {
                protocol.mo2638a(7, (byte) 10);
                protocol.mo2639a(media.time.longValue());
            }
            if (media.pinned != null) {
                protocol.mo2638a(8, (byte) 2);
                protocol.mo2641a(media.pinned.booleanValue());
            }
            if (media.max_time_served != null) {
                protocol.mo2638a(9, (byte) 10);
                protocol.mo2639a(media.max_time_served.longValue());
            }
            if (media.mimetype != null) {
                protocol.mo2638a(10, (byte) 11);
                protocol.mo2640a(media.mimetype);
            }
            if (media.size != null) {
                protocol.mo2638a(11, (byte) 10);
                protocol.mo2639a(media.size.longValue());
            }
            if (media.url != null) {
                protocol.mo2638a(12, (byte) 11);
                protocol.mo2640a(media.url);
            }
            if (media.source != null) {
                protocol.mo2638a(13, (byte) 11);
                protocol.mo2640a(media.source);
            }
            if (media.upload_duration != null) {
                protocol.mo2638a(14, (byte) 10);
                protocol.mo2639a(media.upload_duration.longValue());
            }
            if (media.file_name != null) {
                protocol.mo2638a(15, (byte) 11);
                protocol.mo2640a(media.file_name);
            }
            if (media.type != null) {
                protocol.mo2638a(16, (byte) 11);
                protocol.mo2640a(media.type);
            }
            if (media.thumbnail_url != null) {
                protocol.mo2638a(17, (byte) 11);
                protocol.mo2640a(media.thumbnail_url);
            }
            protocol.mo2634a();
        }

        public final Media read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b != (byte) 0) {
                    switch (b.f10037c) {
                        case (short) 1:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.width(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 2:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.height(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.load_time(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 4:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.id(protocol.mo2652l());
                            break;
                        case (short) 5:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.orientation(protocol.mo2652l());
                            break;
                        case (short) 6:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.duration(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 7:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.time(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 8:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.pinned(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 9:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.max_time_served(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 10:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.mimetype(protocol.mo2652l());
                            break;
                        case (short) 11:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.size(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 12:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.url(protocol.mo2652l());
                            break;
                        case (short) 13:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.source(protocol.mo2652l());
                            break;
                        case (short) 14:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.upload_duration(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 15:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.file_name(protocol.mo2652l());
                            break;
                        case (short) 16:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.type(protocol.mo2652l());
                            break;
                        case (short) 17:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.thumbnail_url(protocol.mo2652l());
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final Media read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private Media(Builder builder) {
        this.width = builder.width;
        this.height = builder.height;
        this.load_time = builder.load_time;
        this.id = builder.id;
        this.orientation = builder.orientation;
        this.duration = builder.duration;
        this.time = builder.time;
        this.pinned = builder.pinned;
        this.max_time_served = builder.max_time_served;
        this.mimetype = builder.mimetype;
        this.size = builder.size;
        this.url = builder.url;
        this.source = builder.source;
        this.upload_duration = builder.upload_duration;
        this.file_name = builder.file_name;
        this.type = builder.type;
        this.thumbnail_url = builder.thumbnail_url;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Media)) {
            return false;
        }
        Media media = (Media) obj;
        if ((this.width == media.width || (this.width != null && this.width.equals(media.width))) && ((this.height == media.height || (this.height != null && this.height.equals(media.height))) && ((this.load_time == media.load_time || (this.load_time != null && this.load_time.equals(media.load_time))) && ((this.id == media.id || (this.id != null && this.id.equals(media.id))) && ((this.orientation == media.orientation || (this.orientation != null && this.orientation.equals(media.orientation))) && ((this.duration == media.duration || (this.duration != null && this.duration.equals(media.duration))) && ((this.time == media.time || (this.time != null && this.time.equals(media.time))) && ((this.pinned == media.pinned || (this.pinned != null && this.pinned.equals(media.pinned))) && ((this.max_time_served == media.max_time_served || (this.max_time_served != null && this.max_time_served.equals(media.max_time_served))) && ((this.mimetype == media.mimetype || (this.mimetype != null && this.mimetype.equals(media.mimetype))) && ((this.size == media.size || (this.size != null && this.size.equals(media.size))) && ((this.url == media.url || (this.url != null && this.url.equals(media.url))) && ((this.source == media.source || (this.source != null && this.source.equals(media.source))) && ((this.upload_duration == media.upload_duration || (this.upload_duration != null && this.upload_duration.equals(media.upload_duration))) && ((this.file_name == media.file_name || (this.file_name != null && this.file_name.equals(media.file_name))) && (this.type == media.type || (this.type != null && this.type.equals(media.type)))))))))))))))))) {
            if (this.thumbnail_url != media.thumbnail_url) {
                if (!(this.thumbnail_url == null || this.thumbnail_url.equals(media.thumbnail_url) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((((((((((((((((((((((((((((((this.width == null ? 0 : this.width.hashCode()) ^ 16777619) * -2128831035) ^ (this.height == null ? 0 : this.height.hashCode())) * -2128831035) ^ (this.load_time == null ? 0 : this.load_time.hashCode())) * -2128831035) ^ (this.id == null ? 0 : this.id.hashCode())) * -2128831035) ^ (this.orientation == null ? 0 : this.orientation.hashCode())) * -2128831035) ^ (this.duration == null ? 0 : this.duration.hashCode())) * -2128831035) ^ (this.time == null ? 0 : this.time.hashCode())) * -2128831035) ^ (this.pinned == null ? 0 : this.pinned.hashCode())) * -2128831035) ^ (this.max_time_served == null ? 0 : this.max_time_served.hashCode())) * -2128831035) ^ (this.mimetype == null ? 0 : this.mimetype.hashCode())) * -2128831035) ^ (this.size == null ? 0 : this.size.hashCode())) * -2128831035) ^ (this.url == null ? 0 : this.url.hashCode())) * -2128831035) ^ (this.source == null ? 0 : this.source.hashCode())) * -2128831035) ^ (this.upload_duration == null ? 0 : this.upload_duration.hashCode())) * -2128831035) ^ (this.file_name == null ? 0 : this.file_name.hashCode())) * -2128831035) ^ (this.type == null ? 0 : this.type.hashCode())) * -2128831035;
        if (this.thumbnail_url != null) {
            i = this.thumbnail_url.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Media{width=");
        stringBuilder.append(this.width);
        stringBuilder.append(", height=");
        stringBuilder.append(this.height);
        stringBuilder.append(", load_time=");
        stringBuilder.append(this.load_time);
        stringBuilder.append(", id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", orientation=");
        stringBuilder.append(this.orientation);
        stringBuilder.append(", duration=");
        stringBuilder.append(this.duration);
        stringBuilder.append(", time=");
        stringBuilder.append(this.time);
        stringBuilder.append(", pinned=");
        stringBuilder.append(this.pinned);
        stringBuilder.append(", max_time_served=");
        stringBuilder.append(this.max_time_served);
        stringBuilder.append(", mimetype=");
        stringBuilder.append(this.mimetype);
        stringBuilder.append(", size=");
        stringBuilder.append(this.size);
        stringBuilder.append(", url=");
        stringBuilder.append(this.url);
        stringBuilder.append(", source=");
        stringBuilder.append(this.source);
        stringBuilder.append(", upload_duration=");
        stringBuilder.append(this.upload_duration);
        stringBuilder.append(", file_name=");
        stringBuilder.append(this.file_name);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", thumbnail_url=");
        stringBuilder.append(this.thumbnail_url);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
