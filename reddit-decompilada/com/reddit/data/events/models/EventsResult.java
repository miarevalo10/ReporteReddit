package com.reddit.data.events.models;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/reddit/data/events/models/EventsResult;", "", "ids", "", "", "events", "Lcom/reddit/data/events/models/Event;", "(Ljava/util/List;Ljava/util/List;)V", "getEvents", "()Ljava/util/List;", "getIds", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "events_release"}, k = 1, mv = {1, 1, 9})
/* compiled from: EventDataModel.kt */
public final class EventsResult {
    private final List<Event> events;
    private final List<Long> ids;

    public static /* synthetic */ EventsResult copy$default(EventsResult eventsResult, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = eventsResult.ids;
        }
        if ((i & 2) != 0) {
            list2 = eventsResult.events;
        }
        return eventsResult.copy(list, list2);
    }

    public final List<Long> component1() {
        return this.ids;
    }

    public final List<Event> component2() {
        return this.events;
    }

    public final EventsResult copy(List<Long> list, List<Event> list2) {
        Intrinsics.b(list, "ids");
        Intrinsics.b(list2, "events");
        return new EventsResult(list, list2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof EventsResult) {
                EventsResult eventsResult = (EventsResult) obj;
                if (Intrinsics.a(this.ids, eventsResult.ids) && Intrinsics.a(this.events, eventsResult.events)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        List list = this.ids;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List list2 = this.events;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("EventsResult(ids=");
        stringBuilder.append(this.ids);
        stringBuilder.append(", events=");
        stringBuilder.append(this.events);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public EventsResult(List<Long> list, List<Event> list2) {
        Intrinsics.b(list, "ids");
        Intrinsics.b(list2, "events");
        this.ids = list;
        this.events = list2;
    }

    public final List<Long> getIds() {
        return this.ids;
    }

    public final List<Event> getEvents() {
        return this.events;
    }
}
