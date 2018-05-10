package com.reddit.frontpage.commons.analytics.events.v1;

import com.google.gson.Gson;
import org.json.JSONObject;

public class PushNotificationEvent extends BaseEvent<PushNotificationPayload> {
    private static final String EVENT_TOPIC = "notification_events";
    private static final String EVENT_TYPE = "cs.receive_push_notification";

    public static class PushNotificationPayload extends BasePayload {
        public transient String notification_extras;
        public String notification_id;
        public String notification_type;

        private PushNotificationPayload() {
        }
    }

    public final String mo6418a() {
        return EVENT_TOPIC;
    }

    public String mo6419b() {
        return EVENT_TYPE;
    }

    public PushNotificationEvent() {
        super(null);
    }

    public final JSONObject m34408a(Gson gson) {
        gson = super.a(gson);
        BaseEvent.m28945a(gson, ((PushNotificationPayload) this.payload).notification_extras);
        return gson;
    }

    protected final /* synthetic */ BasePayload mo6420c() {
        return new PushNotificationPayload();
    }
}
