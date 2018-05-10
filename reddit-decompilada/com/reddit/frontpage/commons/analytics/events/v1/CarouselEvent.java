package com.reddit.frontpage.commons.analytics.events.v1;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0014\u0015BY\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0002\u0010\u000fJ\b\u0010\u0011\u001a\u00020\u0002H\u0014J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016R\u000e\u0010\b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v1/CarouselEvent;", "Lcom/reddit/frontpage/commons/analytics/events/v1/BaseEvent;", "Lcom/reddit/frontpage/commons/analytics/events/v1/CarouselEvent$CarouselPayload;", "screenName", "", "eventType", "itemsSeen", "", "carouselId", "carouselType", "controlName", "totalScrollItems", "", "position", "fetchUrlString", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;)V", "Ljava/lang/Integer;", "createPayload", "getEventTopic", "getEventType", "CarouselPayload", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CarouselEvent.kt */
public final class CarouselEvent extends BaseEvent<CarouselPayload> {
    public static final Companion Companion = new Companion();
    private static final String EVENT_TOPIC = "carousel_events";
    private final String carouselId;
    private final String carouselType;
    private final String controlName;
    private final String eventType;
    private final String fetchUrlString;
    private final Set<String> itemsSeen;
    private final Integer position;
    private final int totalScrollItems;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v1/CarouselEvent$Companion;", "", "()V", "EVENT_TOPIC", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CarouselEvent.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001d\u0018\u00002\u00020\u0001Be\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\f\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$¨\u0006("}, d2 = {"Lcom/reddit/frontpage/commons/analytics/events/v1/CarouselEvent$CarouselPayload;", "Lcom/reddit/frontpage/commons/analytics/events/v1/BasePayload;", "items_seen", "", "", "event_topic", "event_type", "carousel_id", "carousel_type", "control_name", "total_scroll_items", "", "position", "fetch_url_string", "(Ljava/util/Set;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getCarousel_id", "()Ljava/lang/String;", "setCarousel_id", "(Ljava/lang/String;)V", "getCarousel_type", "setCarousel_type", "getControl_name", "setControl_name", "getEvent_topic", "setEvent_topic", "getEvent_type", "setEvent_type", "getFetch_url_string", "setFetch_url_string", "getItems_seen", "()Ljava/util/Set;", "setItems_seen", "(Ljava/util/Set;)V", "getPosition", "()Ljava/lang/Integer;", "setPosition", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTotal_scroll_items", "setTotal_scroll_items", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: CarouselEvent.kt */
    public static final class CarouselPayload extends BasePayload {
        String carousel_id;
        String carousel_type;
        String control_name;
        String event_topic;
        String event_type;
        String fetch_url_string;
        Set<String> items_seen;
        Integer position;
        Integer total_scroll_items;

        public CarouselPayload(Set<String> set, String str, String str2, String str3, String str4, String str5, Integer num, Integer num2, String str6) {
            this.items_seen = set;
            this.event_topic = str;
            this.event_type = str2;
            this.carousel_id = str3;
            this.carousel_type = str4;
            this.control_name = str5;
            this.total_scroll_items = num;
            this.position = num2;
            this.fetch_url_string = str6;
        }
    }

    public final String mo6418a() {
        return EVENT_TOPIC;
    }

    public CarouselEvent(String str, String str2, Set<String> set, String str3, String str4, String str5, int i, Integer num, String str6) {
        Intrinsics.m26847b(str, "screenName");
        Intrinsics.m26847b(str2, "eventType");
        Intrinsics.m26847b(set, "itemsSeen");
        Intrinsics.m26847b(str3, "carouselId");
        Intrinsics.m26847b(str4, "carouselType");
        Intrinsics.m26847b(str5, "controlName");
        Intrinsics.m26847b(str6, "fetchUrlString");
        super(str);
        this.eventType = str2;
        this.itemsSeen = set;
        this.carouselId = str3;
        this.carouselType = str4;
        this.controlName = str5;
        this.totalScrollItems = i;
        this.position = num;
        this.fetchUrlString = str6;
        ((CarouselPayload) this.payload).items_seen = this.itemsSeen;
        ((CarouselPayload) this.payload).event_topic = EVENT_TOPIC;
        ((CarouselPayload) this.payload).event_type = this.eventType;
        ((CarouselPayload) this.payload).carousel_id = this.carouselId;
        ((CarouselPayload) this.payload).carousel_type = this.carouselType;
        ((CarouselPayload) this.payload).control_name = this.controlName;
        ((CarouselPayload) this.payload).total_scroll_items = Integer.valueOf(this.totalScrollItems);
        ((CarouselPayload) this.payload).position = this.position;
        ((CarouselPayload) this.payload).fetch_url_string = this.fetchUrlString;
    }

    public final String mo6419b() {
        return this.eventType;
    }

    public final /* synthetic */ BasePayload mo6420c() {
        return new CarouselPayload(this.itemsSeen, EVENT_TOPIC, this.eventType, this.carouselId, this.carouselType, this.controlName, Integer.valueOf(this.totalScrollItems), this.position, this.fetchUrlString);
    }
}
