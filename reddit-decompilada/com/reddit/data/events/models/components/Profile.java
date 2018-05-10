package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class Profile {
    public static final Adapter<Profile, Builder> ADAPTER = new ProfileAdapter();
    public final String about;
    public final String avatar_url;
    public final Boolean communities_visible;
    public final Boolean content_visible;
    public final String cover_url;
    public final String display_name;
    public final String id;
    public final String name;
    public final Boolean nsfw;
    public final String type;

    public static final class Builder implements StructBuilder<Profile> {
        private String about;
        private String avatar_url;
        private Boolean communities_visible;
        private Boolean content_visible;
        private String cover_url;
        private String display_name;
        private String id;
        private String name;
        private Boolean nsfw;
        private String type;

        public Builder(Profile profile) {
            this.id = profile.id;
            this.name = profile.name;
            this.type = profile.type;
            this.display_name = profile.display_name;
            this.about = profile.about;
            this.avatar_url = profile.avatar_url;
            this.cover_url = profile.cover_url;
            this.nsfw = profile.nsfw;
            this.content_visible = profile.content_visible;
            this.communities_visible = profile.communities_visible;
        }

        public final Builder id(String str) {
            if (str == null) {
                throw new NullPointerException("Required field 'id' cannot be null");
            }
            this.id = str;
            return this;
        }

        public final Builder name(String str) {
            if (str == null) {
                throw new NullPointerException("Required field 'name' cannot be null");
            }
            this.name = str;
            return this;
        }

        public final Builder type(String str) {
            this.type = str;
            return this;
        }

        public final Builder display_name(String str) {
            this.display_name = str;
            return this;
        }

        public final Builder about(String str) {
            this.about = str;
            return this;
        }

        public final Builder avatar_url(String str) {
            this.avatar_url = str;
            return this;
        }

        public final Builder cover_url(String str) {
            this.cover_url = str;
            return this;
        }

        public final Builder nsfw(Boolean bool) {
            this.nsfw = bool;
            return this;
        }

        public final Builder content_visible(Boolean bool) {
            this.content_visible = bool;
            return this;
        }

        public final Builder communities_visible(Boolean bool) {
            this.communities_visible = bool;
            return this;
        }

        public final Profile build() {
            if (this.id == null) {
                throw new IllegalStateException("Required field 'id' is missing");
            } else if (this.name != null) {
                return new Profile();
            } else {
                throw new IllegalStateException("Required field 'name' is missing");
            }
        }

        public final void reset() {
            this.id = null;
            this.name = null;
            this.type = null;
            this.display_name = null;
            this.about = null;
            this.avatar_url = null;
            this.cover_url = null;
            this.nsfw = null;
            this.content_visible = null;
            this.communities_visible = null;
        }
    }

    private static final class ProfileAdapter implements Adapter<Profile, Builder> {
        private ProfileAdapter() {
        }

        public final void write(Protocol protocol, Profile profile) throws IOException {
            protocol.mo2638a(1, (byte) 11);
            protocol.mo2640a(profile.id);
            protocol.mo2638a(2, (byte) 11);
            protocol.mo2640a(profile.name);
            if (profile.type != null) {
                protocol.mo2638a(3, (byte) 11);
                protocol.mo2640a(profile.type);
            }
            if (profile.display_name != null) {
                protocol.mo2638a(4, (byte) 11);
                protocol.mo2640a(profile.display_name);
            }
            if (profile.about != null) {
                protocol.mo2638a(5, (byte) 11);
                protocol.mo2640a(profile.about);
            }
            if (profile.avatar_url != null) {
                protocol.mo2638a(6, (byte) 11);
                protocol.mo2640a(profile.avatar_url);
            }
            if (profile.cover_url != null) {
                protocol.mo2638a(7, (byte) 11);
                protocol.mo2640a(profile.cover_url);
            }
            if (profile.nsfw != null) {
                protocol.mo2638a(8, (byte) 2);
                protocol.mo2641a(profile.nsfw.booleanValue());
            }
            if (profile.content_visible != null) {
                protocol.mo2638a(9, (byte) 2);
                protocol.mo2641a(profile.content_visible.booleanValue());
            }
            if (profile.communities_visible != null) {
                protocol.mo2638a(11, (byte) 2);
                protocol.mo2641a(profile.communities_visible.booleanValue());
            }
            protocol.mo2634a();
        }

        public final Profile read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b != (byte) 0) {
                    switch (b.f10037c) {
                        case (short) 1:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.id(protocol.mo2652l());
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
                            builder.type(protocol.mo2652l());
                            break;
                        case (short) 4:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.display_name(protocol.mo2652l());
                            break;
                        case (short) 5:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.about(protocol.mo2652l());
                            break;
                        case (short) 6:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.avatar_url(protocol.mo2652l());
                            break;
                        case (short) 7:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.cover_url(protocol.mo2652l());
                            break;
                        case (short) 8:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.nsfw(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 9:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.content_visible(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 11:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.communities_visible(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final Profile read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private Profile(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.type = builder.type;
        this.display_name = builder.display_name;
        this.about = builder.about;
        this.avatar_url = builder.avatar_url;
        this.cover_url = builder.cover_url;
        this.nsfw = builder.nsfw;
        this.content_visible = builder.content_visible;
        this.communities_visible = builder.communities_visible;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Profile)) {
            return false;
        }
        Profile profile = (Profile) obj;
        if ((this.id == profile.id || this.id.equals(profile.id)) && ((this.name == profile.name || this.name.equals(profile.name)) && ((this.type == profile.type || (this.type != null && this.type.equals(profile.type))) && ((this.display_name == profile.display_name || (this.display_name != null && this.display_name.equals(profile.display_name))) && ((this.about == profile.about || (this.about != null && this.about.equals(profile.about))) && ((this.avatar_url == profile.avatar_url || (this.avatar_url != null && this.avatar_url.equals(profile.avatar_url))) && ((this.cover_url == profile.cover_url || (this.cover_url != null && this.cover_url.equals(profile.cover_url))) && ((this.nsfw == profile.nsfw || (this.nsfw != null && this.nsfw.equals(profile.nsfw))) && (this.content_visible == profile.content_visible || (this.content_visible != null && this.content_visible.equals(profile.content_visible))))))))))) {
            if (this.communities_visible != profile.communities_visible) {
                if (!(this.communities_visible == null || this.communities_visible.equals(profile.communities_visible) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((((((((this.id.hashCode() ^ 16777619) * -2128831035) ^ this.name.hashCode()) * -2128831035) ^ (this.type == null ? 0 : this.type.hashCode())) * -2128831035) ^ (this.display_name == null ? 0 : this.display_name.hashCode())) * -2128831035) ^ (this.about == null ? 0 : this.about.hashCode())) * -2128831035) ^ (this.avatar_url == null ? 0 : this.avatar_url.hashCode())) * -2128831035) ^ (this.cover_url == null ? 0 : this.cover_url.hashCode())) * -2128831035) ^ (this.nsfw == null ? 0 : this.nsfw.hashCode())) * -2128831035) ^ (this.content_visible == null ? 0 : this.content_visible.hashCode())) * -2128831035;
        if (this.communities_visible != null) {
            i = this.communities_visible.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Profile{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", display_name=");
        stringBuilder.append(this.display_name);
        stringBuilder.append(", about=");
        stringBuilder.append(this.about);
        stringBuilder.append(", avatar_url=");
        stringBuilder.append(this.avatar_url);
        stringBuilder.append(", cover_url=");
        stringBuilder.append(this.cover_url);
        stringBuilder.append(", nsfw=");
        stringBuilder.append(this.nsfw);
        stringBuilder.append(", content_visible=");
        stringBuilder.append(this.content_visible);
        stringBuilder.append(", communities_visible=");
        stringBuilder.append(this.communities_visible);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
