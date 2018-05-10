package com.reddit.frontpage.commons.analytics.events.v1;

import com.google.gson.Gson;
import org.json.JSONObject;

public class NotificationClickEvent extends BaseEvent<NotificationClickPayload> {
    private static final String DEFAULT_EVENT_TOPIC = "notification_events";
    private static final String DEFAULT_EVENT_TYPE = "cs.tapped_push_notification";

    public static class NotificationClickPayload extends BasePayload {
        public transient String notification_extras;
        public String notification_id;
        public String notification_type;

        private NotificationClickPayload() {
        }
    }

    public final String mo6418a() {
        return DEFAULT_EVENT_TOPIC;
    }

    public final String mo6419b() {
        return DEFAULT_EVENT_TYPE;
    }

    public final JSONObject m34404a(Gson gson) {
        gson = super.a(gson);
        BaseEvent.m28945a(gson, ((NotificationClickPayload) this.payload).notification_extras);
        return gson;
    }

    protected final /* synthetic */ BasePayload mo6420c() {
        return new NotificationClickPayload();
    }
}
