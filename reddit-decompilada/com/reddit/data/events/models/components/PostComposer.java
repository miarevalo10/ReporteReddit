package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class PostComposer {
    public static final Adapter<PostComposer, Builder> ADAPTER = new PostComposerAdapter();
    public final String editor_mode;
    public final String final_status;
    public final String input_type;
    public final String text_type;
    public final String type;

    public static final class Builder implements StructBuilder<PostComposer> {
        private String editor_mode;
        private String final_status;
        private String input_type;
        private String text_type;
        private String type;

        public Builder(PostComposer postComposer) {
            this.type = postComposer.type;
            this.input_type = postComposer.input_type;
            this.text_type = postComposer.text_type;
            this.final_status = postComposer.final_status;
            this.editor_mode = postComposer.editor_mode;
        }

        public final Builder type(String str) {
            this.type = str;
            return this;
        }

        public final Builder input_type(String str) {
            this.input_type = str;
            return this;
        }

        public final Builder text_type(String str) {
            this.text_type = str;
            return this;
        }

        public final Builder final_status(String str) {
            this.final_status = str;
            return this;
        }

        public final Builder editor_mode(String str) {
            this.editor_mode = str;
            return this;
        }

        public final PostComposer build() {
            return new PostComposer();
        }

        public final void reset() {
            this.type = null;
            this.input_type = null;
            this.text_type = null;
            this.final_status = null;
            this.editor_mode = null;
        }
    }

    private static final class PostComposerAdapter implements Adapter<PostComposer, Builder> {
        private PostComposerAdapter() {
        }

        public final void write(Protocol protocol, PostComposer postComposer) throws IOException {
            if (postComposer.type != null) {
                protocol.mo2638a(1, (byte) 11);
                protocol.mo2640a(postComposer.type);
            }
            if (postComposer.input_type != null) {
                protocol.mo2638a(2, (byte) 11);
                protocol.mo2640a(postComposer.input_type);
            }
            if (postComposer.text_type != null) {
                protocol.mo2638a(3, (byte) 11);
                protocol.mo2640a(postComposer.text_type);
            }
            if (postComposer.final_status != null) {
                protocol.mo2638a(4, (byte) 11);
                protocol.mo2640a(postComposer.final_status);
            }
            if (postComposer.editor_mode != null) {
                protocol.mo2638a(5, (byte) 11);
                protocol.mo2640a(postComposer.editor_mode);
            }
            protocol.mo2634a();
        }

        public final PostComposer read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b != (byte) 0) {
                    switch (b.f10037c) {
                        case (short) 1:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.type(protocol.mo2652l());
                            break;
                        case (short) 2:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.input_type(protocol.mo2652l());
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.text_type(protocol.mo2652l());
                            break;
                        case (short) 4:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.final_status(protocol.mo2652l());
                            break;
                        case (short) 5:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.editor_mode(protocol.mo2652l());
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final PostComposer read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private PostComposer(Builder builder) {
        this.type = builder.type;
        this.input_type = builder.input_type;
        this.text_type = builder.text_type;
        this.final_status = builder.final_status;
        this.editor_mode = builder.editor_mode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PostComposer)) {
            return false;
        }
        PostComposer postComposer = (PostComposer) obj;
        if ((this.type == postComposer.type || (this.type != null && this.type.equals(postComposer.type))) && ((this.input_type == postComposer.input_type || (this.input_type != null && this.input_type.equals(postComposer.input_type))) && ((this.text_type == postComposer.text_type || (this.text_type != null && this.text_type.equals(postComposer.text_type))) && (this.final_status == postComposer.final_status || (this.final_status != null && this.final_status.equals(postComposer.final_status)))))) {
            if (this.editor_mode != postComposer.editor_mode) {
                if (!(this.editor_mode == null || this.editor_mode.equals(postComposer.editor_mode) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((((((this.type == null ? 0 : this.type.hashCode()) ^ 16777619) * -2128831035) ^ (this.input_type == null ? 0 : this.input_type.hashCode())) * -2128831035) ^ (this.text_type == null ? 0 : this.text_type.hashCode())) * -2128831035) ^ (this.final_status == null ? 0 : this.final_status.hashCode())) * -2128831035;
        if (this.editor_mode != null) {
            i = this.editor_mode.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("PostComposer{type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", input_type=");
        stringBuilder.append(this.input_type);
        stringBuilder.append(", text_type=");
        stringBuilder.append(this.text_type);
        stringBuilder.append(", final_status=");
        stringBuilder.append(this.final_status);
        stringBuilder.append(", editor_mode=");
        stringBuilder.append(this.editor_mode);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
