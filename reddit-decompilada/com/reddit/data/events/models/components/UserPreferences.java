package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class UserPreferences {
    public static final Adapter<UserPreferences, Builder> ADAPTER = new UserPreferencesAdapter();
    public final String expando;
    public final Boolean hide_nsfw;
    public final Boolean hide_previously_seen_posts;
    public final Boolean in_beta;
    public final String language;

    public static final class Builder implements StructBuilder<UserPreferences> {
        private String expando;
        private Boolean hide_nsfw;
        private Boolean hide_previously_seen_posts;
        private Boolean in_beta;
        private String language;

        public Builder(UserPreferences userPreferences) {
            this.in_beta = userPreferences.in_beta;
            this.language = userPreferences.language;
            this.hide_nsfw = userPreferences.hide_nsfw;
            this.expando = userPreferences.expando;
            this.hide_previously_seen_posts = userPreferences.hide_previously_seen_posts;
        }

        public final Builder in_beta(Boolean bool) {
            this.in_beta = bool;
            return this;
        }

        public final Builder language(String str) {
            this.language = str;
            return this;
        }

        public final Builder hide_nsfw(Boolean bool) {
            this.hide_nsfw = bool;
            return this;
        }

        public final Builder expando(String str) {
            this.expando = str;
            return this;
        }

        public final Builder hide_previously_seen_posts(Boolean bool) {
            this.hide_previously_seen_posts = bool;
            return this;
        }

        public final UserPreferences build() {
            return new UserPreferences();
        }

        public final void reset() {
            this.in_beta = null;
            this.language = null;
            this.hide_nsfw = null;
            this.expando = null;
            this.hide_previously_seen_posts = null;
        }
    }

    private static final class UserPreferencesAdapter implements Adapter<UserPreferences, Builder> {
        private UserPreferencesAdapter() {
        }

        public final void write(Protocol protocol, UserPreferences userPreferences) throws IOException {
            if (userPreferences.in_beta != null) {
                protocol.mo2638a(1, (byte) 2);
                protocol.mo2641a(userPreferences.in_beta.booleanValue());
            }
            if (userPreferences.language != null) {
                protocol.mo2638a(2, (byte) 11);
                protocol.mo2640a(userPreferences.language);
            }
            if (userPreferences.hide_nsfw != null) {
                protocol.mo2638a(3, (byte) 2);
                protocol.mo2641a(userPreferences.hide_nsfw.booleanValue());
            }
            if (userPreferences.expando != null) {
                protocol.mo2638a(4, (byte) 11);
                protocol.mo2640a(userPreferences.expando);
            }
            if (userPreferences.hide_previously_seen_posts != null) {
                protocol.mo2638a(5, (byte) 2);
                protocol.mo2641a(userPreferences.hide_previously_seen_posts.booleanValue());
            }
            protocol.mo2634a();
        }

        public final UserPreferences read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b != (byte) 0) {
                    switch (b.f10037c) {
                        case (short) 1:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.in_beta(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 2:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.language(protocol.mo2652l());
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.hide_nsfw(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 4:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.expando(protocol.mo2652l());
                            break;
                        case (short) 5:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.hide_previously_seen_posts(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final UserPreferences read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private UserPreferences(Builder builder) {
        this.in_beta = builder.in_beta;
        this.language = builder.language;
        this.hide_nsfw = builder.hide_nsfw;
        this.expando = builder.expando;
        this.hide_previously_seen_posts = builder.hide_previously_seen_posts;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UserPreferences)) {
            return false;
        }
        UserPreferences userPreferences = (UserPreferences) obj;
        if ((this.in_beta == userPreferences.in_beta || (this.in_beta != null && this.in_beta.equals(userPreferences.in_beta))) && ((this.language == userPreferences.language || (this.language != null && this.language.equals(userPreferences.language))) && ((this.hide_nsfw == userPreferences.hide_nsfw || (this.hide_nsfw != null && this.hide_nsfw.equals(userPreferences.hide_nsfw))) && (this.expando == userPreferences.expando || (this.expando != null && this.expando.equals(userPreferences.expando)))))) {
            if (this.hide_previously_seen_posts != userPreferences.hide_previously_seen_posts) {
                if (!(this.hide_previously_seen_posts == null || this.hide_previously_seen_posts.equals(userPreferences.hide_previously_seen_posts) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((((((this.in_beta == null ? 0 : this.in_beta.hashCode()) ^ 16777619) * -2128831035) ^ (this.language == null ? 0 : this.language.hashCode())) * -2128831035) ^ (this.hide_nsfw == null ? 0 : this.hide_nsfw.hashCode())) * -2128831035) ^ (this.expando == null ? 0 : this.expando.hashCode())) * -2128831035;
        if (this.hide_previously_seen_posts != null) {
            i = this.hide_previously_seen_posts.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("UserPreferences{in_beta=");
        stringBuilder.append(this.in_beta);
        stringBuilder.append(", language=");
        stringBuilder.append(this.language);
        stringBuilder.append(", hide_nsfw=");
        stringBuilder.append(this.hide_nsfw);
        stringBuilder.append(", expando=");
        stringBuilder.append(this.expando);
        stringBuilder.append(", hide_previously_seen_posts=");
        stringBuilder.append(this.hide_previously_seen_posts);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
