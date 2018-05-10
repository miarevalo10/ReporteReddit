package com.reddit.frontpage.commons.analytics.events.v1;

public class SessionStartEvent extends BaseEvent<SessionStartPayload> {
    private static final String DEFAULT_EVENT_TOPIC = "app_launch_events";
    private static final String DEFAULT_EVENT_TYPE = "cs.app_relaunch_android";

    public static class SessionStartPayload extends BasePayload {
        public long bytes_received;
        public long bytes_transmitted;
        public boolean push_notifications_enabled;

        private SessionStartPayload() {
        }
    }

    public final String mo6418a() {
        return DEFAULT_EVENT_TOPIC;
    }

    public final String mo6419b() {
        return DEFAULT_EVENT_TYPE;
    }

    protected final /* synthetic */ BasePayload mo6420c() {
        return new SessionStartPayload();
    }
}
