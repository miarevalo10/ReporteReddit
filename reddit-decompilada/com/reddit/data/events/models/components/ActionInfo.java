package com.reddit.data.events.models.components;

import com.microsoft.thrifty.Adapter;
import com.microsoft.thrifty.StructBuilder;
import com.microsoft.thrifty.protocol.FieldMetadata;
import com.microsoft.thrifty.protocol.Protocol;
import com.microsoft.thrifty.util.ProtocolUtil;
import java.io.IOException;

public final class ActionInfo {
    public static final Adapter<ActionInfo, Builder> ADAPTER = new ActionInfoAdapter();
    public final Long count;
    public final String page_type;
    public final String pane_name;
    public final Long position;
    public final String reason;
    public final Boolean retried;
    public final String setting_value;
    public final Boolean success;
    public final String type;

    private static final class ActionInfoAdapter implements Adapter<ActionInfo, Builder> {
        private ActionInfoAdapter() {
        }

        public final void write(Protocol protocol, ActionInfo actionInfo) throws IOException {
            if (actionInfo.page_type != null) {
                protocol.mo2638a(1, (byte) 11);
                protocol.mo2640a(actionInfo.page_type);
            }
            if (actionInfo.pane_name != null) {
                protocol.mo2638a(2, (byte) 11);
                protocol.mo2640a(actionInfo.pane_name);
            }
            if (actionInfo.position != null) {
                protocol.mo2638a(3, (byte) 10);
                protocol.mo2639a(actionInfo.position.longValue());
            }
            if (actionInfo.success != null) {
                protocol.mo2638a(4, (byte) 2);
                protocol.mo2641a(actionInfo.success.booleanValue());
            }
            if (actionInfo.count != null) {
                protocol.mo2638a(5, (byte) 10);
                protocol.mo2639a(actionInfo.count.longValue());
            }
            if (actionInfo.retried != null) {
                protocol.mo2638a(6, (byte) 2);
                protocol.mo2641a(actionInfo.retried.booleanValue());
            }
            if (actionInfo.reason != null) {
                protocol.mo2638a(7, (byte) 11);
                protocol.mo2640a(actionInfo.reason);
            }
            if (actionInfo.setting_value != null) {
                protocol.mo2638a(8, (byte) 11);
                protocol.mo2640a(actionInfo.setting_value);
            }
            if (actionInfo.type != null) {
                protocol.mo2638a(9, (byte) 11);
                protocol.mo2640a(actionInfo.type);
            }
            protocol.mo2634a();
        }

        public final ActionInfo read(Protocol protocol, Builder builder) throws IOException {
            while (true) {
                FieldMetadata b = protocol.mo2642b();
                if (b.f10036b != (byte) 0) {
                    switch (b.f10037c) {
                        case (short) 1:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.page_type(protocol.mo2652l());
                            break;
                        case (short) 2:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.pane_name(protocol.mo2652l());
                            break;
                        case (short) 3:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.position(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 4:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.success(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 5:
                            if (b.f10036b != (byte) 10) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.count(Long.valueOf(protocol.mo2650j()));
                            break;
                        case (short) 6:
                            if (b.f10036b != (byte) 2) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.retried(Boolean.valueOf(protocol.mo2646f()));
                            break;
                        case (short) 7:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.reason(protocol.mo2652l());
                            break;
                        case (short) 8:
                            if (b.f10036b != (byte) 11) {
                                ProtocolUtil.m8514a(protocol, b.f10036b);
                                break;
                            }
                            builder.setting_value(protocol.mo2652l());
                            break;
                        case (short) 9:
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

        public final ActionInfo read(Protocol protocol) throws IOException {
            return read(protocol, new Builder());
        }
    }

    public static final class Builder implements StructBuilder<ActionInfo> {
        private Long count;
        private String page_type;
        private String pane_name;
        private Long position;
        private String reason;
        private Boolean retried;
        private String setting_value;
        private Boolean success;
        private String type;

        public Builder(ActionInfo actionInfo) {
            this.page_type = actionInfo.page_type;
            this.pane_name = actionInfo.pane_name;
            this.position = actionInfo.position;
            this.success = actionInfo.success;
            this.count = actionInfo.count;
            this.retried = actionInfo.retried;
            this.reason = actionInfo.reason;
            this.setting_value = actionInfo.setting_value;
            this.type = actionInfo.type;
        }

        public final Builder page_type(String str) {
            this.page_type = str;
            return this;
        }

        public final Builder pane_name(String str) {
            this.pane_name = str;
            return this;
        }

        public final Builder position(Long l) {
            this.position = l;
            return this;
        }

        public final Builder success(Boolean bool) {
            this.success = bool;
            return this;
        }

        public final Builder count(Long l) {
            this.count = l;
            return this;
        }

        public final Builder retried(Boolean bool) {
            this.retried = bool;
            return this;
        }

        public final Builder reason(String str) {
            this.reason = str;
            return this;
        }

        public final Builder setting_value(String str) {
            this.setting_value = str;
            return this;
        }

        public final Builder type(String str) {
            this.type = str;
            return this;
        }

        public final ActionInfo build() {
            return new ActionInfo();
        }

        public final void reset() {
            this.page_type = null;
            this.pane_name = null;
            this.position = null;
            this.success = null;
            this.count = null;
            this.retried = null;
            this.reason = null;
            this.setting_value = null;
            this.type = null;
        }
    }

    private ActionInfo(Builder builder) {
        this.page_type = builder.page_type;
        this.pane_name = builder.pane_name;
        this.position = builder.position;
        this.success = builder.success;
        this.count = builder.count;
        this.retried = builder.retried;
        this.reason = builder.reason;
        this.setting_value = builder.setting_value;
        this.type = builder.type;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ActionInfo)) {
            return false;
        }
        ActionInfo actionInfo = (ActionInfo) obj;
        if ((this.page_type == actionInfo.page_type || (this.page_type != null && this.page_type.equals(actionInfo.page_type))) && ((this.pane_name == actionInfo.pane_name || (this.pane_name != null && this.pane_name.equals(actionInfo.pane_name))) && ((this.position == actionInfo.position || (this.position != null && this.position.equals(actionInfo.position))) && ((this.success == actionInfo.success || (this.success != null && this.success.equals(actionInfo.success))) && ((this.count == actionInfo.count || (this.count != null && this.count.equals(actionInfo.count))) && ((this.retried == actionInfo.retried || (this.retried != null && this.retried.equals(actionInfo.retried))) && ((this.reason == actionInfo.reason || (this.reason != null && this.reason.equals(actionInfo.reason))) && (this.setting_value == actionInfo.setting_value || (this.setting_value != null && this.setting_value.equals(actionInfo.setting_value)))))))))) {
            if (this.type != actionInfo.type) {
                if (!(this.type == null || this.type.equals(actionInfo.type) == null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((((((((((((((this.page_type == null ? 0 : this.page_type.hashCode()) ^ 16777619) * -2128831035) ^ (this.pane_name == null ? 0 : this.pane_name.hashCode())) * -2128831035) ^ (this.position == null ? 0 : this.position.hashCode())) * -2128831035) ^ (this.success == null ? 0 : this.success.hashCode())) * -2128831035) ^ (this.count == null ? 0 : this.count.hashCode())) * -2128831035) ^ (this.retried == null ? 0 : this.retried.hashCode())) * -2128831035) ^ (this.reason == null ? 0 : this.reason.hashCode())) * -2128831035) ^ (this.setting_value == null ? 0 : this.setting_value.hashCode())) * -2128831035;
        if (this.type != null) {
            i = this.type.hashCode();
        }
        return (hashCode ^ i) * -2128831035;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ActionInfo{page_type=");
        stringBuilder.append(this.page_type);
        stringBuilder.append(", pane_name=");
        stringBuilder.append(this.pane_name);
        stringBuilder.append(", position=");
        stringBuilder.append(this.position);
        stringBuilder.append(", success=");
        stringBuilder.append(this.success);
        stringBuilder.append(", count=");
        stringBuilder.append(this.count);
        stringBuilder.append(", retried=");
        stringBuilder.append(this.retried);
        stringBuilder.append(", reason=");
        stringBuilder.append(this.reason);
        stringBuilder.append(", setting_value=");
        stringBuilder.append(this.setting_value);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void write(Protocol protocol) throws IOException {
        ADAPTER.write(protocol, this);
    }
}
