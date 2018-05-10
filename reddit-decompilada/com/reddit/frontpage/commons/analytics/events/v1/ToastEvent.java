package com.reddit.frontpage.commons.analytics.events.v1;

public class ToastEvent extends BaseEvent<ToastPayload> {
    private static final String DEFAULT_EVENT_TOPIC = "alert_events";
    private static final String DEFAULT_EVENT_TYPE = "cs.toast_impression";

    public static class ToastPayload extends BasePayload {
        public String target_name;
        public String toast_name;

        private ToastPayload() {
        }
    }

    public final String mo6418a() {
        return DEFAULT_EVENT_TOPIC;
    }

    public final String mo6419b() {
        return DEFAULT_EVENT_TYPE;
    }

    protected final /* synthetic */ BasePayload mo6420c() {
        return new ToastPayload();
    }
}
