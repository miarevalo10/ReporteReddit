package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class Widget {
    public static final Adapter<Widget, Builder> ADAPTER = new WidgetAdapter();
    public final String target_subreddit_id;
    public final String target_subreddit_name;
    public final String type;

    public static final class Builder implements StructBuilder<Widget> {
        private String target_subreddit_id;
        private String target_subreddit_name;
        private String type;

        public Builder(Widget widget) {
            this.target_subreddit_name = widget.target_subreddit_name;
            this.target_subreddit_id = widget.target_subreddit_id;
            this.type = widget.type;
        }

        public final Builder target_subreddit_name(String str) {
            this.target_subreddit_name = str;
            return this;
        }

        public final Builder target_subreddit_id(String str) {
            this.target_subreddit_id = str;
            return this;
        }

        public final Builder type(String str) {
            this.type = str;
            return this;
        }

        public final Widget build() {
            return new Widget();
        }

        public final void reset() {
            this.target_subreddit_name = null;
            this.target_subreddit_id = null;
            this.type = null;
        }
    }

    private static final class WidgetAdapter implements Adapter<Widget, Builder> {
        private WidgetAdapter() {
        }

        public final void write(Protocol protocol, Widget widget) throws IOException {
            if (widget.target_subreddit_name != null) {
                protocol.mo2638a(1, (byte) 11);
                protocol.mo2640a(widget.target_subreddit_name);
            }
            if (widget.target_subreddit_id != null) {
                protocol.mo2638a(2, (byte) 11);
                protocol.mo2640a(widget.target_subreddit_id);
            }
            if (widget.type != null) {
                protocol.mo2638a(3, (byte) 11);
                protocol.mo2640a(widget.type);
            }
            protocol.mo2634a();
        }

        public final Widget read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b != (byte) 0) {
                    switch (b.f10037c) {
                        case (short) 1:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.target_subreddit_name(protocol.mo2652l());
                            break;
                        case (short) 2:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.target_subreddit_id(protocol.mo2652l());
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.type(protocol.mo2652l());
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final Widget read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private Widget(Builder builder) {
        this.target_subreddit_name = builder.target_subreddit_name;
        this.target_subreddit_id = builder.target_subreddit_id;
        this.type = builder.type;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Widget)) {
            return false;
        }
        Widget widget = (Widget) obj;
        if ((this.target_subreddit_name == widget.target_subreddit_name || (this.target_subreddit_name != null && this.target_subreddit_name.equals(widget.target_subreddit_name))) && (this.target_subreddit_id == widget.target_subreddit_id || (this.target_subreddit_id != null && this.target_subreddit_id.equals(widget.target_subreddit_id)))) {
            if (this.type != widget.type) {
                if (!(this.type == null || this.type.equals(widget.type) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((this.target_subreddit_name == null ? 0 : this.target_subreddit_name.hashCode()) ^ 16777619) * -2128831035) ^ (this.target_subreddit_id == null ? 0 : this.target_subreddit_id.hashCode())) * -2128831035;
        if (this.type != null) {
            i = this.type.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Widget{target_subreddit_name=");
        stringBuilder.append(this.target_subreddit_name);
        stringBuilder.append(", target_subreddit_id=");
        stringBuilder.append(this.target_subreddit_id);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
