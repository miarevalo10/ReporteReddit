package com.reddit.frontpage.commons.analytics.events.v1;

public class ShareEvent extends BaseEvent<SharePayload> {
    private static final String EVENT_TOPIC = "share_events";
    private static final String EVENT_TYPE = "cs.share_android";
    public static final String SOURCE_DETAILS_SCREEN = "details_action_bar";
    public static final String SOURCE_LISTINGS_SCREEN = "listings_action_bar";
    public static final String SOURCE_SUBREDDIT_OVERFLOW = "subreddit_overflow";
    public static final String SOURCE_UPVOTE_TOAST = "upvote_toast";

    public static class SharePayload extends BasePayload {
        public String action;
        public String listing_name;
        public String live_thread_id;
        public String referrer_element;
        public String referrer_url;
        public String source;
        public String target_after;
        public String target_before;
        public String target_filter_time;
        public String target_id;
        public int target_limit;
        public String target_name;
        public String target_sort_order;
        public String target_title;
        public String target_url;
        public String target_url_domain;
        public long time_on_page;
        public String user_fullname;
    }

    public final String mo6418a() {
        return EVENT_TOPIC;
    }

    public final String mo6419b() {
        return EVENT_TYPE;
    }

    public ShareEvent(String str) {
        super(str);
    }

    protected final /* synthetic */ BasePayload mo6420c() {
        return new SharePayload();
    }
}
