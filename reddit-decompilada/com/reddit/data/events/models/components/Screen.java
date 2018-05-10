package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class Screen {
    public static final Adapter<Screen, Builder> ADAPTER = new ScreenAdapter();
    public final String browser_tab_id;
    public final Integer height;
    public final Boolean in_focus;
    public final Integer scroll_position;
    public final String theme;
    public final String view_type;
    public final Integer viewport_height;
    public final Integer viewport_width;
    public final Integer width;

    public static final class Builder implements StructBuilder<Screen> {
        private String browser_tab_id;
        private Integer height;
        private Boolean in_focus;
        private Integer scroll_position;
        private String theme;
        private String view_type;
        private Integer viewport_height;
        private Integer viewport_width;
        private Integer width;

        public Builder(Screen screen) {
            this.width = screen.width;
            this.height = screen.height;
            this.viewport_width = screen.viewport_width;
            this.viewport_height = screen.viewport_height;
            this.view_type = screen.view_type;
            this.theme = screen.theme;
            this.in_focus = screen.in_focus;
            this.browser_tab_id = screen.browser_tab_id;
            this.scroll_position = screen.scroll_position;
        }

        public final Builder width(Integer num) {
            this.width = num;
            return this;
        }

        public final Builder height(Integer num) {
            this.height = num;
            return this;
        }

        public final Builder viewport_width(Integer num) {
            this.viewport_width = num;
            return this;
        }

        public final Builder viewport_height(Integer num) {
            this.viewport_height = num;
            return this;
        }

        public final Builder view_type(String str) {
            this.view_type = str;
            return this;
        }

        public final Builder theme(String str) {
            this.theme = str;
            return this;
        }

        public final Builder in_focus(Boolean bool) {
            this.in_focus = bool;
            return this;
        }

        public final Builder browser_tab_id(String str) {
            this.browser_tab_id = str;
            return this;
        }

        public final Builder scroll_position(Integer num) {
            this.scroll_position = num;
            return this;
        }

        public final Screen build() {
            return new Screen();
        }

        public final void reset() {
            this.width = null;
            this.height = null;
            this.viewport_width = null;
            this.viewport_height = null;
            this.view_type = null;
            this.theme = null;
            this.in_focus = null;
            this.browser_tab_id = null;
            this.scroll_position = null;
        }
    }

    private static final class ScreenAdapter implements Adapter<Screen, Builder> {
        private ScreenAdapter() {
        }

        public final void write(Protocol protocol, Screen screen) throws IOException {
            if (screen.width != null) {
                protocol.mo2638a(1, (byte) 8);
                protocol.mo2637a(screen.width.intValue());
            }
            if (screen.height != null) {
                protocol.mo2638a(2, (byte) 8);
                protocol.mo2637a(screen.height.intValue());
            }
            if (screen.viewport_width != null) {
                protocol.mo2638a(3, (byte) 8);
                protocol.mo2637a(screen.viewport_width.intValue());
            }
            if (screen.viewport_height != null) {
                protocol.mo2638a(4, (byte) 8);
                protocol.mo2637a(screen.viewport_height.intValue());
            }
            if (screen.view_type != null) {
                protocol.mo2638a(5, (byte) 11);
                protocol.mo2640a(screen.view_type);
            }
            if (screen.theme != null) {
                protocol.mo2638a(6, (byte) 11);
                protocol.mo2640a(screen.theme);
            }
            if (screen.in_focus != null) {
                protocol.mo2638a(7, (byte) 2);
                protocol.mo2641a(screen.in_focus.booleanValue());
            }
            if (screen.browser_tab_id != null) {
                protocol.mo2638a(8, (byte) 11);
                protocol.mo2640a(screen.browser_tab_id);
            }
            if (screen.scroll_position != null) {
                protocol.mo2638a(9, (byte) 8);
                protocol.mo2637a(screen.scroll_position.intValue());
            }
            protocol.mo2634a();
        }

        public final Screen read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b != (byte) 0) {
                    switch (b.f10037c) {
                        case (short) 1:
                            if (b.f10036b != (byte) 8) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.width(Integer.valueOf(protocol.mo2649i()));
                            break;
                        case (short) 2:
                            if (b.f10036b != (byte) 8) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.height(Integer.valueOf(protocol.mo2649i()));
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 8) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.viewport_width(Integer.valueOf(protocol.mo2649i()));
                            break;
                        case (short) 4:
                            if (b.f10036b != (byte) 8) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.viewport_height(Integer.valueOf(protocol.mo2649i()));
                            break;
                        case (short) 5:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.view_type(protocol.mo2652l());
                            break;
                        case (short) 6:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.theme(protocol.mo2652l());
                            break;
                        case (short) 7:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.in_focus(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 8:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.browser_tab_id(protocol.mo2652l());
                            break;
                        case (short) 9:
                            if (b.f10036b != (byte) 8) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.scroll_position(Integer.valueOf(protocol.mo2649i()));
                            break;
                        default:
                            ProtocolUtil.m8514a(protocol, b.f10036b);
                            break;
                    }
                }
                return builder.build();
            }
        }

        public final Screen read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    private Screen(Builder builder) {
        this.width = builder.width;
        this.height = builder.height;
        this.viewport_width = builder.viewport_width;
        this.viewport_height = builder.viewport_height;
        this.view_type = builder.view_type;
        this.theme = builder.theme;
        this.in_focus = builder.in_focus;
        this.browser_tab_id = builder.browser_tab_id;
        this.scroll_position = builder.scroll_position;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Screen)) {
            return false;
        }
        Screen screen = (Screen) obj;
        if ((this.width == screen.width || (this.width != null && this.width.equals(screen.width))) && ((this.height == screen.height || (this.height != null && this.height.equals(screen.height))) && ((this.viewport_width == screen.viewport_width || (this.viewport_width != null && this.viewport_width.equals(screen.viewport_width))) && ((this.viewport_height == screen.viewport_height || (this.viewport_height != null && this.viewport_height.equals(screen.viewport_height))) && ((this.view_type == screen.view_type || (this.view_type != null && this.view_type.equals(screen.view_type))) && ((this.theme == screen.theme || (this.theme != null && this.theme.equals(screen.theme))) && ((this.in_focus == screen.in_focus || (this.in_focus != null && this.in_focus.equals(screen.in_focus))) && (this.browser_tab_id == screen.browser_tab_id || (this.browser_tab_id != null && this.browser_tab_id.equals(screen.browser_tab_id)))))))))) {
            if (this.scroll_position != screen.scroll_position) {
                if (!(this.scroll_position == null || this.scroll_position.equals(screen.scroll_position) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((((((((((((((this.width == null ? 0 : this.width.hashCode()) ^ 16777619) * -2128831035) ^ (this.height == null ? 0 : this.height.hashCode())) * -2128831035) ^ (this.viewport_width == null ? 0 : this.viewport_width.hashCode())) * -2128831035) ^ (this.viewport_height == null ? 0 : this.viewport_height.hashCode())) * -2128831035) ^ (this.view_type == null ? 0 : this.view_type.hashCode())) * -2128831035) ^ (this.theme == null ? 0 : this.theme.hashCode())) * -2128831035) ^ (this.in_focus == null ? 0 : this.in_focus.hashCode())) * -2128831035) ^ (this.browser_tab_id == null ? 0 : this.browser_tab_id.hashCode())) * -2128831035;
        if (this.scroll_position != null) {
            i = this.scroll_position.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Screen{width=");
        stringBuilder.append(this.width);
        stringBuilder.append(", height=");
        stringBuilder.append(this.height);
        stringBuilder.append(", viewport_width=");
        stringBuilder.append(this.viewport_width);
        stringBuilder.append(", viewport_height=");
        stringBuilder.append(this.viewport_height);
        stringBuilder.append(", view_type=");
        stringBuilder.append(this.view_type);
        stringBuilder.append(", theme=");
        stringBuilder.append(this.theme);
        stringBuilder.append(", in_focus=");
        stringBuilder.append(this.in_focus);
        stringBuilder.append(", browser_tab_id=");
        stringBuilder.append(this.browser_tab_id);
        stringBuilder.append(", scroll_position=");
        stringBuilder.append(this.scroll_position);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
