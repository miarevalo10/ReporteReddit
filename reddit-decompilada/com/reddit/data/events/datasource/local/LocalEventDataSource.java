package com.reddit.data.events.datasource.local;

import com.reddit.data.events.models.Event;
import com.reddit.data.events.models.EventsResult;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\fH&J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\b2\u0006\u0010\u000b\u001a\u00020\fH&J\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011H&J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0013\u001a\u00020\nH&J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¨\u0006\u0016"}, d2 = {"Lcom/reddit/data/events/datasource/local/LocalEventDataSource;", "", "deleteOldDispatchedEvents", "Lio/reactivex/Single;", "", "timestamp", "", "getEvents", "Lio/reactivex/Maybe;", "", "Lcom/reddit/data/events/models/Event;", "limit", "", "getEventsForDispatch", "Lcom/reddit/data/events/models/EventsResult;", "markDispatched", "eventIds", "", "saveEvent", "event", "saveEvents", "events", "events_release"}, k = 1, mv = {1, 1, 9})
/* compiled from: LocalEventDataSource.kt */
public interface LocalEventDataSource {
    Maybe<List<Event>> mo2903a();

    Maybe<EventsResult> mo2904a(int i);

    Single<Boolean> mo2905a(long j);

    Single<Boolean> mo2906a(Event event);

    Single<Boolean> mo2907a(Collection<Long> collection);
}
