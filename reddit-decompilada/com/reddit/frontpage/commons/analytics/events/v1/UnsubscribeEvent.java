package com.reddit.frontpage.commons.analytics.events.v1;

public class UnsubscribeEvent extends BaseEvent<UnsubscribePayload> {
    public static final String UNSUBSCRIBE_EVENT_TOPIC = "subscribe_events";
    public static final String UNSUBSCRIBE_EVENT_TYPE = "cs.unsubscribe";

    public static class UnsubscribePayload extends BasePayload {
        public String base_url;
    }

    public final String mo6418a() {
        return "subscribe_events";
    }

    public final String mo6419b() {
        return UNSUBSCRIBE_EVENT_TYPE;
    }

    protected final /* synthetic */ BasePayload mo6420c() {
        return new UnsubscribePayload();
    }
}
