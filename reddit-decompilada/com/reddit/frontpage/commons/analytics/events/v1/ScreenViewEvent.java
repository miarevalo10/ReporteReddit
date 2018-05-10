package com.reddit.frontpage.commons.analytics.events.v1;

public class ScreenViewEvent extends BaseEvent<ScreenViewPayload> {
    private static final String EVENT_TOPIC = "screenview_events";
    private static final String EVENT_TYPE = "cs.screenview_android";

    public static class ScreenViewPayload extends BasePayload {
        public String channel_name;
        public String geo_filter;
        public boolean is_contributor;
        public String listing_name;
        public String live_thread_id;
        public int num_participants;
        public String participant_id;
        public String referrer_element;
        public String referrer_url;
        public boolean social_build = false;
        public String source_page;
        public String target_after;
        public String target_before;
        public Integer target_crosspost_depth;
        public String target_filter_time;
        public String target_id;
        public int target_limit;
        public String target_name;
        public String target_parent_fullname;
        public String target_root_fullname;
        public String target_root_type;
        public String target_sort_order;
        public String target_title;
        public String target_url;
        public String target_url_domain;
        public long time_on_page;
        public String user_fullname;
    }

    public String mo6418a() {
        return EVENT_TOPIC;
    }

    public String mo6419b() {
        return EVENT_TYPE;
    }

    public ScreenViewEvent(String str) {
        super(str);
    }

    protected final /* synthetic */ BasePayload mo6420c() {
        return new ScreenViewPayload();
    }
}
