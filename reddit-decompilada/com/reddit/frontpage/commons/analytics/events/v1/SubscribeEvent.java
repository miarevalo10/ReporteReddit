package com.reddit.frontpage.commons.analytics.events.v1;

public class SubscribeEvent extends BaseEvent<SubscribePayload> {
    public static final String SUBSCRIBE_EVENT_TOPIC = "subscribe_events";
    public static final String SUBSCRIBE_EVENT_TYPE = "cs.subscribe";

    public static class SubscribePayload extends BasePayload {
        public String base_url;
    }

    public final String mo6418a() {
        return "subscribe_events";
    }

    public final String mo6419b() {
        return SUBSCRIBE_EVENT_TYPE;
    }

    protected final /* synthetic */ BasePayload mo6420c() {
        return new SubscribePayload();
    }
}
