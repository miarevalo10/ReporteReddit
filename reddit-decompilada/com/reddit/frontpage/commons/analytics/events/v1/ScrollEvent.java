package com.reddit.frontpage.commons.analytics.events.v1;

import java.util.List;

public class ScrollEvent extends BaseEvent<ScrollPayload> {
    private static final String EVENT_TOPIC = "scroll_events";
    private static final String EVENT_TYPE = "cs.scroll_android";

    public static class ScrollPayload extends BasePayload {
        public String base_url;
        public String control_name;
        public String live_thread_id;
        public List<String> posts_seen;
        public List<Long> posts_seen_end_time;
        public List<Long> posts_seen_start_time;
        public int scroll_items_seen;
        public float scroll_percentage;
        public long time_on_page;
        public int total_screens_scrolled;
        public int total_scroll_items;
    }

    public final String mo6418a() {
        return EVENT_TOPIC;
    }

    public final String mo6419b() {
        return EVENT_TYPE;
    }

    public ScrollEvent(String str) {
        super(str);
    }

    protected final /* synthetic */ BasePayload mo6420c() {
        return new ScrollPayload();
    }
}
