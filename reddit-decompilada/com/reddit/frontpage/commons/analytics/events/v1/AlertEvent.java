package com.reddit.frontpage.commons.analytics.events.v1;

public class AlertEvent extends BaseEvent<AlertPayload> {
    private static final String DEFAULT_EVENT_TOPIC = "alert_events";
    private static final String DEFAULT_EVENT_TYPE = "cs.alert_impression";

    public static class AlertPayload extends BasePayload {
        public String alert_name;

        private AlertPayload() {
        }
    }

    public final String mo6418a() {
        return DEFAULT_EVENT_TOPIC;
    }

    public final String mo6419b() {
        return DEFAULT_EVENT_TYPE;
    }

    protected final /* synthetic */ BasePayload mo6420c() {
        return new AlertPayload();
    }
}
