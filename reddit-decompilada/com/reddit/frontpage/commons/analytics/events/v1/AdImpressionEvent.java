package com.reddit.frontpage.commons.analytics.events.v1;

public class AdImpressionEvent extends BaseEvent<AdImpressionPayload> {
    private static final String EVENT_TOPIC = "ad_serving_events";
    private static final String EVENT_TYPE = "cs.ad_impression";

    public static class AdImpressionPayload extends BasePayload {
        public String ad_url;
    }

    public final String mo6418a() {
        return EVENT_TOPIC;
    }

    public final String mo6419b() {
        return EVENT_TYPE;
    }

    protected final /* synthetic */ BasePayload mo6420c() {
        return new AdImpressionPayload();
    }
}
