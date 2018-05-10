package com.reddit.frontpage.commons.analytics.events.v1;

public class ScreenViewHeartbeatEvent extends ScreenViewEvent {
    private static final String EVENT_TOPIC = "screenview_heartbeat_events";
    private static final String EVENT_TYPE = "cs.screenview_heartbeat_android";

    public final String mo6418a() {
        return EVENT_TOPIC;
    }

    public final String mo6419b() {
        return EVENT_TYPE;
    }

    public ScreenViewHeartbeatEvent(String str) {
        super(str);
    }
}
