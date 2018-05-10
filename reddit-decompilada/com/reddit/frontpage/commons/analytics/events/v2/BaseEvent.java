package com.reddit.frontpage.commons.analytics.events.v2;

import com.cookpad.puree.JsonConvertible;
import java.util.UUID;
import timber.log.Timber;

public abstract class BaseEvent<T extends BasePayload> extends JsonConvertible {
    private final String event_topic = mo6421a();
    private final long event_ts = System.currentTimeMillis();
    public String event_type = mo6423b();
    public final T payload = mo6422c();
    private final String uuid = UUID.randomUUID().toString();

    public abstract String mo6421a();

    public abstract String mo6423b();

    protected abstract T mo6422c();

    public BaseEvent() {
        Timber.a("Base event, topic [%s], ts [%d], uuid [%s]", new Object[]{this.event_topic, Long.valueOf(this.event_ts), this.uuid});
    }
}
