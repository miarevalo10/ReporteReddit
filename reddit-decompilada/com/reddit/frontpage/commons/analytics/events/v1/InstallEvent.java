package com.reddit.frontpage.commons.analytics.events.v1;

import com.google.gson.JsonElement;

public class InstallEvent extends BaseEvent<InstallPayload> {
    private static final String EVENT_TOPIC = "app_launch_events";
    private static final String EVENT_TYPE = "cs.app_launch_android";

    public static class InstallPayload extends BasePayload {
        public JsonElement branch_params;
        public long branch_response_timing;
        public boolean deeplinked;
        public String url_parsed_utm_content;
        public String url_parsed_utm_medium;
        public String url_parsed_utm_name;
        public String url_parsed_utm_source;
    }

    public final String mo6418a() {
        return EVENT_TOPIC;
    }

    public final String mo6419b() {
        return EVENT_TYPE;
    }

    public InstallEvent() {
        super(null);
    }

    protected final /* synthetic */ BasePayload mo6420c() {
        return new InstallPayload();
    }
}
