package com.reddit.frontpage.commons.analytics.events.v1;

public class ControlTabEvent extends BaseEvent<ControlTabEventPayload> {
    public static final String CONTROL_TAB_EVENT_TOPIC = "usercontrol_events";
    public static final String CONTROL_TAB_EVENT_TYPE = "cs.tap_android";

    public static class ControlTabEventPayload extends BasePayload {
        public String base_url;
        public String control_name;
    }

    public final String mo6418a() {
        return CONTROL_TAB_EVENT_TOPIC;
    }

    public final String mo6419b() {
        return CONTROL_TAB_EVENT_TYPE;
    }

    public ControlTabEvent(String str) {
        super(str);
    }

    protected final /* synthetic */ BasePayload mo6420c() {
        return new ControlTabEventPayload();
    }
}
