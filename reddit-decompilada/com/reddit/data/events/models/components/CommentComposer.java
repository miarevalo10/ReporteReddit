package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class CommentComposer {
    public static final Adapter<CommentComposer, Builder> ADAPTER = new CommentComposerAdapter();
    public final String editor_mode;

    public static final class Builder implements StructBuilder<CommentComposer> {
        private String editor_mode;

        public Builder(CommentComposer commentComposer) {
            this.editor_mode = commentComposer.editor_mode;
        }

        public final Builder editor_mode(String str) {
            this.editor_mode = str;
            return this;
        }

        public final CommentComposer build() {
            return new CommentComposer();
        }

        public final void reset() {
            this.editor_mode = null;
        }
    }

    private static final class CommentComposerAdapter implements Adapter<CommentComposer, Builder> {
        private CommentComposerAdapter() {
        }

        public final void write(Protocol protocol, CommentComposer commentComposer) throws IOException {
            if (commentComposer.editor_mode != null) {
                protocol.mo2638a(1, (byte) 11);
                protocol.mo2640a(commentComposer.editor_mode);
            }
            protocol.mo2634a();
        }

        public final CommentComposer read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b == (byte) 0) {
                    return builder.build();
                }
                if (b.f10037c != (short) 1) {
                    ProtocolUtil.m8514a(protocol, b.f10036b);
                } else if (b.f10036b == (byte) 11) {
                    builder.editor_mode(protocol.mo2652l());
                } else {
                    ProtocolUtil.m8514a(protocol, b.f10036b);
                }
            }
        }

        public final CommentComposer read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private CommentComposer(Builder builder) {
        this.editor_mode = builder.editor_mode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CommentComposer)) {
            return false;
        }
        CommentComposer commentComposer = (CommentComposer) obj;
        if (this.editor_mode != commentComposer.editor_mode) {
            if (this.editor_mode == null || this.editor_mode.equals(commentComposer.editor_mode) == null) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return ((this.editor_mode == null ? 0 : this.editor_mode.hashCode()) ^ 16777619) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("CommentComposer{editor_mode=");
        stringBuilder.append(this.editor_mode);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
