package com.reddit.frontpage.commons.analytics.events.v1;

import android.text.TextUtils;
import com.cookpad.puree.JsonConvertible;
import java.util.UUID;
import org.json.JSONObject;
import timber.log.Timber;

public abstract class BaseEvent<T extends BasePayload> extends JsonConvertible {
    private static final int EVENT_VERSION = 0;
    private final String event_topic;
    private final long event_ts;
    public String event_type;
    public final T payload;
    private final String uuid;

    public abstract String mo6418a();

    public abstract String mo6419b();

    protected abstract T mo6420c();

    public BaseEvent(String str) {
        this();
        this.payload.screen_name = str;
    }

    public BaseEvent() {
        this.event_topic = mo6418a();
        this.event_type = mo6419b();
        this.event_ts = System.currentTimeMillis();
        this.uuid = UUID.randomUUID().toString();
        this.payload = mo6420c();
    }

    protected static void m28945a(JSONObject jSONObject, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject = jSONObject.getJSONObject("payload");
                JSONObject jSONObject2 = new JSONObject(str);
                str = jSONObject2.keys();
                while (str.hasNext()) {
                    String str2 = (String) str.next();
                    jSONObject.put(str2, jSONObject2.get(str2));
                }
            } catch (JSONObject jSONObject3) {
                Timber.c(jSONObject3, "Failed parsing event JSON", new Object[0]);
            }
        }
    }
}
