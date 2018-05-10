package com.reddit.frontpage.commons.analytics.events.v1;

public class AdRequestEvent extends BaseEvent<AdRequestPayload> {
    private static final String EVENT_TOPIC = "ad_serving_events";
    private static final String EVENT_TYPE = "cs.ad_request";

    public static class AdRequestPayload extends BasePayload {
    }

    public final String mo6418a() {
        return EVENT_TOPIC;
    }

    public final String mo6419b() {
        return EVENT_TYPE;
    }

    public AdRequestEvent(String str) {
        super(str);
    }

    protected final /* synthetic */ BasePayload mo6420c() {
        return new AdRequestPayload();
    }
}
