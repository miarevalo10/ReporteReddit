package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class Request {
    public static final Adapter<Request, Builder> ADAPTER = new RequestAdapter();
    public final Boolean accept_encoding;
    public final Boolean accept_language;
    public final String base_url;
    public final String client_ip;
    public final Boolean cookies_present;
    public final String domain;
    public final String header_signature;
    public final String known_bot;
    public final String reddaid;
    public final String user_agent;

    public static final class Builder implements StructBuilder<Request> {
        private Boolean accept_encoding;
        private Boolean accept_language;
        private String base_url;
        private String client_ip;
        private Boolean cookies_present;
        private String domain;
        private String header_signature;
        private String known_bot;
        private String reddaid;
        private String user_agent;

        public Builder(Request request) {
            this.user_agent = request.user_agent;
            this.domain = request.domain;
            this.base_url = request.base_url;
            this.client_ip = request.client_ip;
            this.known_bot = request.known_bot;
            this.header_signature = request.header_signature;
            this.cookies_present = request.cookies_present;
            this.accept_encoding = request.accept_encoding;
            this.accept_language = request.accept_language;
            this.reddaid = request.reddaid;
        }

        public final Builder user_agent(String str) {
            this.user_agent = str;
            return this;
        }

        public final Builder domain(String str) {
            this.domain = str;
            return this;
        }

        public final Builder base_url(String str) {
            this.base_url = str;
            return this;
        }

        public final Builder client_ip(String str) {
            this.client_ip = str;
            return this;
        }

        public final Builder known_bot(String str) {
            this.known_bot = str;
            return this;
        }

        public final Builder header_signature(String str) {
            this.header_signature = str;
            return this;
        }

        public final Builder cookies_present(Boolean bool) {
            this.cookies_present = bool;
            return this;
        }

        public final Builder accept_encoding(Boolean bool) {
            this.accept_encoding = bool;
            return this;
        }

        public final Builder accept_language(Boolean bool) {
            this.accept_language = bool;
            return this;
        }

        public final Builder reddaid(String str) {
            this.reddaid = str;
            return this;
        }

        public final Request build() {
            return new Request();
        }

        public final void reset() {
            this.user_agent = null;
            this.domain = null;
            this.base_url = null;
            this.client_ip = null;
            this.known_bot = null;
            this.header_signature = null;
            this.cookies_present = null;
            this.accept_encoding = null;
            this.accept_language = null;
            this.reddaid = null;
        }
    }

    private static final class RequestAdapter implements Adapter<Request, Builder> {
        private RequestAdapter() {
        }

        public final void write(Protocol protocol, Request request) throws IOException {
            if (request.user_agent != null) {
                protocol.mo2638a(1, (byte) 11);
                protocol.mo2640a(request.user_agent);
            }
            if (request.domain != null) {
                protocol.mo2638a(2, (byte) 11);
                protocol.mo2640a(request.domain);
            }
            if (request.base_url != null) {
                protocol.mo2638a(3, (byte) 11);
                protocol.mo2640a(request.base_url);
            }
            if (request.client_ip != null) {
                protocol.mo2638a(4, (byte) 11);
                protocol.mo2640a(request.client_ip);
            }
            if (request.known_bot != null) {
                protocol.mo2638a(5, (byte) 11);
                protocol.mo2640a(request.known_bot);
            }
            if (request.header_signature != null) {
                protocol.mo2638a(6, (byte) 11);
                protocol.mo2640a(request.header_signature);
            }
            if (request.cookies_present != null) {
                protocol.mo2638a(7, (byte) 2);
                protocol.mo2641a(request.cookies_present.booleanValue());
            }
            if (request.accept_encoding != null) {
                protocol.mo2638a(8, (byte) 2);
                protocol.mo2641a(request.accept_encoding.booleanValue());
            }
            if (request.accept_language != null) {
                protocol.mo2638a(9, (byte) 2);
                protocol.mo2641a(request.accept_language.booleanValue());
            }
            if (request.reddaid != null) {
                protocol.mo2638a(10, (byte) 11);
                protocol.mo2640a(request.reddaid);
            }
            protocol.mo2634a();
        }

        public final Request read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b != (byte) 0) {
                    switch (b.f10037c) {
                        case (short) 1:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.user_agent(protocol.mo2652l());
                            break;
                        case (short) 2:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.domain(protocol.mo2652l());
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.base_url(protocol.mo2652l());
                            break;
                        case (short) 4:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.client_ip(protocol.mo2652l());
                            break;
                        case (short) 5:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.known_bot(protocol.mo2652l());
                            break;
                        case (short) 6:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.header_signature(protocol.mo2652l());
                            break;
                        case (short) 7:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.cookies_present(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 8:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.accept_encoding(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 9:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.accept_language(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 10:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.reddaid(protocol.mo2652l());
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final Request read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private Request(Builder builder) {
        this.user_agent = builder.user_agent;
        this.domain = builder.domain;
        this.base_url = builder.base_url;
        this.client_ip = builder.client_ip;
        this.known_bot = builder.known_bot;
        this.header_signature = builder.header_signature;
        this.cookies_present = builder.cookies_present;
        this.accept_encoding = builder.accept_encoding;
        this.accept_language = builder.accept_language;
        this.reddaid = builder.reddaid;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Request)) {
            return false;
        }
        Request request = (Request) obj;
        if ((this.user_agent == request.user_agent || (this.user_agent != null && this.user_agent.equals(request.user_agent))) && ((this.domain == request.domain || (this.domain != null && this.domain.equals(request.domain))) && ((this.base_url == request.base_url || (this.base_url != null && this.base_url.equals(request.base_url))) && ((this.client_ip == request.client_ip || (this.client_ip != null && this.client_ip.equals(request.client_ip))) && ((this.known_bot == request.known_bot || (this.known_bot != null && this.known_bot.equals(request.known_bot))) && ((this.header_signature == request.header_signature || (this.header_signature != null && this.header_signature.equals(request.header_signature))) && ((this.cookies_present == request.cookies_present || (this.cookies_present != null && this.cookies_present.equals(request.cookies_present))) && ((this.accept_encoding == request.accept_encoding || (this.accept_encoding != null && this.accept_encoding.equals(request.accept_encoding))) && (this.accept_language == request.accept_language || (this.accept_language != null && this.accept_language.equals(request.accept_language))))))))))) {
            if (this.reddaid != request.reddaid) {
                if (!(this.reddaid == null || this.reddaid.equals(request.reddaid) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((((((((((((((((this.user_agent == null ? 0 : this.user_agent.hashCode()) ^ 16777619) * -2128831035) ^ (this.domain == null ? 0 : this.domain.hashCode())) * -2128831035) ^ (this.base_url == null ? 0 : this.base_url.hashCode())) * -2128831035) ^ (this.client_ip == null ? 0 : this.client_ip.hashCode())) * -2128831035) ^ (this.known_bot == null ? 0 : this.known_bot.hashCode())) * -2128831035) ^ (this.header_signature == null ? 0 : this.header_signature.hashCode())) * -2128831035) ^ (this.cookies_present == null ? 0 : this.cookies_present.hashCode())) * -2128831035) ^ (this.accept_encoding == null ? 0 : this.accept_encoding.hashCode())) * -2128831035) ^ (this.accept_language == null ? 0 : this.accept_language.hashCode())) * -2128831035;
        if (this.reddaid != null) {
            i = this.reddaid.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Request{user_agent=");
        stringBuilder.append(this.user_agent);
        stringBuilder.append(", domain=");
        stringBuilder.append(this.domain);
        stringBuilder.append(", base_url=");
        stringBuilder.append(this.base_url);
        stringBuilder.append(", client_ip=");
        stringBuilder.append(this.client_ip);
        stringBuilder.append(", known_bot=");
        stringBuilder.append(this.known_bot);
        stringBuilder.append(", header_signature=");
        stringBuilder.append(this.header_signature);
        stringBuilder.append(", cookies_present=");
        stringBuilder.append(this.cookies_present);
        stringBuilder.append(", accept_encoding=");
        stringBuilder.append(this.accept_encoding);
        stringBuilder.append(", accept_language=");
        stringBuilder.append(this.accept_language);
        stringBuilder.append(", reddaid=");
        stringBuilder.append(this.reddaid);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
