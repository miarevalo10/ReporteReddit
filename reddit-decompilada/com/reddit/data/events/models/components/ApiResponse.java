package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class ApiResponse {
    public static final Adapter<ApiResponse, Builder> ADAPTER = new ApiResponseAdapter();
    public final String content;
    public final String error;
    public final String error_name;
    public final Integer response_code;

    private static final class ApiResponseAdapter implements Adapter<ApiResponse, Builder> {
        private ApiResponseAdapter() {
        }

        public final void write(Protocol protocol, ApiResponse apiResponse) throws IOException {
            if (apiResponse.response_code != null) {
                protocol.mo2638a(1, (byte) 8);
                protocol.mo2637a(apiResponse.response_code.intValue());
            }
            if (apiResponse.error_name != null) {
                protocol.mo2638a(2, (byte) 11);
                protocol.mo2640a(apiResponse.error_name);
            }
            if (apiResponse.error != null) {
                protocol.mo2638a(3, (byte) 11);
                protocol.mo2640a(apiResponse.error);
            }
            if (apiResponse.content != null) {
                protocol.mo2638a(4, (byte) 11);
                protocol.mo2640a(apiResponse.content);
            }
            protocol.mo2634a();
        }

        public final ApiResponse read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b != (byte) 0) {
                    switch (b.f10037c) {
                        case (short) 1:
                            if (b.f10036b != (byte) 8) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.response_code(Integer.valueOf(protocol.mo2649i()));
                            break;
                        case (short) 2:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.error_name(protocol.mo2652l());
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.error(protocol.mo2652l());
                            break;
                        case (short) 4:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.content(protocol.mo2652l());
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final ApiResponse read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    public static final class Builder implements StructBuilder<ApiResponse> {
        private String content;
        private String error;
        private String error_name;
        private Integer response_code;

        public Builder(ApiResponse apiResponse) {
            this.response_code = apiResponse.response_code;
            this.error_name = apiResponse.error_name;
            this.error = apiResponse.error;
            this.content = apiResponse.content;
        }

        public final Builder response_code(Integer num) {
            this.response_code = num;
            return this;
        }

        public final Builder error_name(String str) {
            this.error_name = str;
            return this;
        }

        public final Builder error(String str) {
            this.error = str;
            return this;
        }

        public final Builder content(String str) {
            this.content = str;
            return this;
        }

        public final ApiResponse build() {
            return new ApiResponse();
        }

        public final void reset() {
            this.response_code = null;
            this.error_name = null;
            this.error = null;
            this.content = null;
        }
    }

    private ApiResponse(Builder builder) {
        this.response_code = builder.response_code;
        this.error_name = builder.error_name;
        this.error = builder.error;
        this.content = builder.content;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ApiResponse)) {
            return false;
        }
        ApiResponse apiResponse = (ApiResponse) obj;
        if ((this.response_code == apiResponse.response_code || (this.response_code != null && this.response_code.equals(apiResponse.response_code))) && ((this.error_name == apiResponse.error_name || (this.error_name != null && this.error_name.equals(apiResponse.error_name))) && (this.error == apiResponse.error || (this.error != null && this.error.equals(apiResponse.error))))) {
            if (this.content != apiResponse.content) {
                if (!(this.content == null || this.content.equals(apiResponse.content) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((((this.response_code == null ? 0 : this.response_code.hashCode()) ^ 16777619) * -2128831035) ^ (this.error_name == null ? 0 : this.error_name.hashCode())) * -2128831035) ^ (this.error == null ? 0 : this.error.hashCode())) * -2128831035;
        if (this.content != null) {
            i = this.content.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ApiResponse{response_code=");
        stringBuilder.append(this.response_code);
        stringBuilder.append(", error_name=");
        stringBuilder.append(this.error_name);
        stringBuilder.append(", error=");
        stringBuilder.append(this.error);
        stringBuilder.append(", content=");
        stringBuilder.append(this.content);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
