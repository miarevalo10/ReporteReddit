package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class UserSubreddit {
    public static final Adapter<UserSubreddit, Builder> ADAPTER = new UserSubredditAdapter();
    public final Boolean is_mod;
    public final Boolean mod_access;
    public final Boolean mod_config;
    public final Boolean mod_flair;
    public final Boolean mod_full;
    public final Boolean mod_mail;
    public final Boolean mod_none;
    public final Boolean mod_post;
    public final Boolean mod_wiki;

    public static final class Builder implements StructBuilder<UserSubreddit> {
        private Boolean is_mod;
        private Boolean mod_access;
        private Boolean mod_config;
        private Boolean mod_flair;
        private Boolean mod_full;
        private Boolean mod_mail;
        private Boolean mod_none;
        private Boolean mod_post;
        private Boolean mod_wiki;

        public Builder(UserSubreddit userSubreddit) {
            this.is_mod = userSubreddit.is_mod;
            this.mod_full = userSubreddit.mod_full;
            this.mod_access = userSubreddit.mod_access;
            this.mod_config = userSubreddit.mod_config;
            this.mod_flair = userSubreddit.mod_flair;
            this.mod_mail = userSubreddit.mod_mail;
            this.mod_post = userSubreddit.mod_post;
            this.mod_wiki = userSubreddit.mod_wiki;
            this.mod_none = userSubreddit.mod_none;
        }

        public final Builder is_mod(Boolean bool) {
            this.is_mod = bool;
            return this;
        }

        public final Builder mod_full(Boolean bool) {
            this.mod_full = bool;
            return this;
        }

        public final Builder mod_access(Boolean bool) {
            this.mod_access = bool;
            return this;
        }

        public final Builder mod_config(Boolean bool) {
            this.mod_config = bool;
            return this;
        }

        public final Builder mod_flair(Boolean bool) {
            this.mod_flair = bool;
            return this;
        }

        public final Builder mod_mail(Boolean bool) {
            this.mod_mail = bool;
            return this;
        }

        public final Builder mod_post(Boolean bool) {
            this.mod_post = bool;
            return this;
        }

        public final Builder mod_wiki(Boolean bool) {
            this.mod_wiki = bool;
            return this;
        }

        public final Builder mod_none(Boolean bool) {
            this.mod_none = bool;
            return this;
        }

        public final UserSubreddit build() {
            return new UserSubreddit();
        }

        public final void reset() {
            this.is_mod = null;
            this.mod_full = null;
            this.mod_access = null;
            this.mod_config = null;
            this.mod_flair = null;
            this.mod_mail = null;
            this.mod_post = null;
            this.mod_wiki = null;
            this.mod_none = null;
        }
    }

    private static final class UserSubredditAdapter implements Adapter<UserSubreddit, Builder> {
        private UserSubredditAdapter() {
        }

        public final void write(Protocol protocol, UserSubreddit userSubreddit) throws IOException {
            if (userSubreddit.is_mod != null) {
                protocol.mo2638a(1, (byte) 2);
                protocol.mo2641a(userSubreddit.is_mod.booleanValue());
            }
            if (userSubreddit.mod_full != null) {
                protocol.mo2638a(2, (byte) 2);
                protocol.mo2641a(userSubreddit.mod_full.booleanValue());
            }
            if (userSubreddit.mod_access != null) {
                protocol.mo2638a(3, (byte) 2);
                protocol.mo2641a(userSubreddit.mod_access.booleanValue());
            }
            if (userSubreddit.mod_config != null) {
                protocol.mo2638a(4, (byte) 2);
                protocol.mo2641a(userSubreddit.mod_config.booleanValue());
            }
            if (userSubreddit.mod_flair != null) {
                protocol.mo2638a(5, (byte) 2);
                protocol.mo2641a(userSubreddit.mod_flair.booleanValue());
            }
            if (userSubreddit.mod_mail != null) {
                protocol.mo2638a(6, (byte) 2);
                protocol.mo2641a(userSubreddit.mod_mail.booleanValue());
            }
            if (userSubreddit.mod_post != null) {
                protocol.mo2638a(7, (byte) 2);
                protocol.mo2641a(userSubreddit.mod_post.booleanValue());
            }
            if (userSubreddit.mod_wiki != null) {
                protocol.mo2638a(8, (byte) 2);
                protocol.mo2641a(userSubreddit.mod_wiki.booleanValue());
            }
            if (userSubreddit.mod_none != null) {
                protocol.mo2638a(9, (byte) 2);
                protocol.mo2641a(userSubreddit.mod_none.booleanValue());
            }
            protocol.mo2634a();
        }

        public final UserSubreddit read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b != (byte) 0) {
                    switch (b.f10037c) {
                        case (short) 1:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.is_mod(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 2:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.mod_full(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.mod_access(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 4:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.mod_config(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 5:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.mod_flair(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 6:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.mod_mail(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 7:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.mod_post(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 8:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.mod_wiki(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 9:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.mod_none(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final UserSubreddit read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private UserSubreddit(Builder builder) {
        this.is_mod = builder.is_mod;
        this.mod_full = builder.mod_full;
        this.mod_access = builder.mod_access;
        this.mod_config = builder.mod_config;
        this.mod_flair = builder.mod_flair;
        this.mod_mail = builder.mod_mail;
        this.mod_post = builder.mod_post;
        this.mod_wiki = builder.mod_wiki;
        this.mod_none = builder.mod_none;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UserSubreddit)) {
            return false;
        }
        UserSubreddit userSubreddit = (UserSubreddit) obj;
        if ((this.is_mod == userSubreddit.is_mod || (this.is_mod != null && this.is_mod.equals(userSubreddit.is_mod))) && ((this.mod_full == userSubreddit.mod_full || (this.mod_full != null && this.mod_full.equals(userSubreddit.mod_full))) && ((this.mod_access == userSubreddit.mod_access || (this.mod_access != null && this.mod_access.equals(userSubreddit.mod_access))) && ((this.mod_config == userSubreddit.mod_config || (this.mod_config != null && this.mod_config.equals(userSubreddit.mod_config))) && ((this.mod_flair == userSubreddit.mod_flair || (this.mod_flair != null && this.mod_flair.equals(userSubreddit.mod_flair))) && ((this.mod_mail == userSubreddit.mod_mail || (this.mod_mail != null && this.mod_mail.equals(userSubreddit.mod_mail))) && ((this.mod_post == userSubreddit.mod_post || (this.mod_post != null && this.mod_post.equals(userSubreddit.mod_post))) && (this.mod_wiki == userSubreddit.mod_wiki || (this.mod_wiki != null && this.mod_wiki.equals(userSubreddit.mod_wiki)))))))))) {
            if (this.mod_none != userSubreddit.mod_none) {
                if (!(this.mod_none == null || this.mod_none.equals(userSubreddit.mod_none) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((((((((((((((this.is_mod == null ? 0 : this.is_mod.hashCode()) ^ 16777619) * -2128831035) ^ (this.mod_full == null ? 0 : this.mod_full.hashCode())) * -2128831035) ^ (this.mod_access == null ? 0 : this.mod_access.hashCode())) * -2128831035) ^ (this.mod_config == null ? 0 : this.mod_config.hashCode())) * -2128831035) ^ (this.mod_flair == null ? 0 : this.mod_flair.hashCode())) * -2128831035) ^ (this.mod_mail == null ? 0 : this.mod_mail.hashCode())) * -2128831035) ^ (this.mod_post == null ? 0 : this.mod_post.hashCode())) * -2128831035) ^ (this.mod_wiki == null ? 0 : this.mod_wiki.hashCode())) * -2128831035;
        if (this.mod_none != null) {
            i = this.mod_none.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("UserSubreddit{is_mod=");
        stringBuilder.append(this.is_mod);
        stringBuilder.append(", mod_full=");
        stringBuilder.append(this.mod_full);
        stringBuilder.append(", mod_access=");
        stringBuilder.append(this.mod_access);
        stringBuilder.append(", mod_config=");
        stringBuilder.append(this.mod_config);
        stringBuilder.append(", mod_flair=");
        stringBuilder.append(this.mod_flair);
        stringBuilder.append(", mod_mail=");
        stringBuilder.append(this.mod_mail);
        stringBuilder.append(", mod_post=");
        stringBuilder.append(this.mod_post);
        stringBuilder.append(", mod_wiki=");
        stringBuilder.append(this.mod_wiki);
        stringBuilder.append(", mod_none=");
        stringBuilder.append(this.mod_none);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
