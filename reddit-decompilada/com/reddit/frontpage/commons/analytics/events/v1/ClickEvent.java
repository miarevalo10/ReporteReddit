package com.reddit.frontpage.commons.analytics.events.v1;

public class ClickEvent extends BaseEvent<ClickPayload> {
    private static final String DEFAULT_EVENT_TOPIC = "usercontrol_events";
    private static final String DEFAULT_EVENT_TYPE = "cs.tap_android";

    public static class ClickPayload extends BasePayload {
        public String control_name;
        public String live_thread_id;
        public String location_name;
        public int position;
        public String query;
        public String swap_with;
        public String target_name;
        public int target_position;
        public String target_url;
        public String target_url_domain;

        private ClickPayload() {
        }
    }

    public final String mo6418a() {
        return "usercontrol_events";
    }

    public final String mo6419b() {
        return "cs.tap_android";
    }

    public ClickEvent(String str) {
        super(str);
    }

    protected final /* synthetic */ BasePayload mo6420c() {
        return new ClickPayload();
    }
}
