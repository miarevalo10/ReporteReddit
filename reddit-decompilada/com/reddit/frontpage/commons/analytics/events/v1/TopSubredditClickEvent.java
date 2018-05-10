package com.reddit.frontpage.commons.analytics.events.v1;

public class TopSubredditClickEvent extends BaseEvent<TopSubredditPayload> {
    private static final String EVENT_TOPIC = "internal_click_events";
    private static final String EVENT_TYPE = "cs.top_sr_click";

    public static class TopSubredditPayload extends BasePayload {
        public String base_url;
        public int position;
        public String taget_type;
        public String target_id;
        public String target_name;
        public String target_url;
    }

    public final String mo6418a() {
        return EVENT_TOPIC;
    }

    public final String mo6419b() {
        return EVENT_TYPE;
    }

    protected final /* synthetic */ BasePayload mo6420c() {
        return new TopSubredditPayload();
    }
}
