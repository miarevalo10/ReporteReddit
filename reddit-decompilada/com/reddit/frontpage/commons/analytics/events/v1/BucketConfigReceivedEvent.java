package com.reddit.frontpage.commons.analytics.events.v1;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\b\tB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v1/BucketConfigReceivedEvent;", "Lcom/reddit/frontpage/commons/analytics/events/v1/BaseEvent;", "Lcom/reddit/frontpage/commons/analytics/events/v1/BucketConfigReceivedEvent$BucketConfigReceivedPayload;", "()V", "createPayload", "getEventTopic", "", "getEventType", "BucketConfigReceivedPayload", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: BucketConfigReceivedEvent.kt */
public final class BucketConfigReceivedEvent extends BaseEvent<BucketConfigReceivedPayload> {
    public static final Companion Companion = new Companion();
    private static final String EVENT_TOPIC = "bucketing_events";
    private static final String EVENT_TYPE = "cs.bucket_config_received";

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v1/BucketConfigReceivedEvent$Companion;", "", "()V", "EVENT_TOPIC", "", "getEVENT_TOPIC", "()Ljava/lang/String;", "EVENT_TYPE", "getEVENT_TYPE", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: BucketConfigReceivedEvent.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v1/BucketConfigReceivedEvent$BucketConfigReceivedPayload;", "Lcom/reddit/frontpage/commons/analytics/events/v1/BasePayload;", "()V", "experiment_id", "", "getExperiment_id", "()I", "setExperiment_id", "(I)V", "experiment_name", "", "getExperiment_name", "()Ljava/lang/String;", "setExperiment_name", "(Ljava/lang/String;)V", "variant", "getVariant", "setVariant", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: BucketConfigReceivedEvent.kt */
    public static final class BucketConfigReceivedPayload extends BasePayload {
        public int experiment_id;
        public String experiment_name;
        public String variant;
    }

    public BucketConfigReceivedEvent() {
        super(null);
    }

    public final String mo6418a() {
        return EVENT_TOPIC;
    }

    public final String mo6419b() {
        return EVENT_TYPE;
    }

    public final /* synthetic */ BasePayload mo6420c() {
        return new BucketConfigReceivedPayload();
    }
}
