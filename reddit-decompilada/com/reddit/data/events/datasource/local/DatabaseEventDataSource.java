package com.reddit.data.events.datasource.local;

import com.raizlabs.android.dbflow.data.Blob;
import com.raizlabs.android.dbflow.kotlinextensions.QueryExtensionsKt;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.raizlabs.android.dbflow.sql.language.Where;
import com.raizlabs.android.dbflow.sql.language.property.IProperty;
import com.raizlabs.android.dbflow.sql.queriable.ModelQueriable;
import com.reddit.data.events.models.Event;
import com.reddit.data.events.models.EventDataModel;
import com.reddit.data.events.models.EventDataModel_Table;
import com.reddit.data.events.models.EventsResult;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.Charsets;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u001aH\u0016J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u001c\u001a\u00020\u0007H\u0016J\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013H\u0016R!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/reddit/data/events/datasource/local/DatabaseEventDataSource;", "Lcom/reddit/data/events/datasource/local/LocalEventDataSource;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "adapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/reddit/data/events/models/Event;", "getAdapter", "()Lcom/squareup/moshi/JsonAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "deleteOldDispatchedEvents", "Lio/reactivex/Single;", "", "timestamp", "", "getEvents", "Lio/reactivex/Maybe;", "", "limit", "", "getEventsForDispatch", "Lcom/reddit/data/events/models/EventsResult;", "markDispatched", "eventIds", "", "saveEvent", "event", "saveEvents", "events", "events_release"}, k = 1, mv = {1, 1, 9})
/* compiled from: DatabaseEventDataSource.kt */
public final class DatabaseEventDataSource implements LocalEventDataSource {
    static final /* synthetic */ KProperty[] f15718a = new KProperty[]{Reflection.a(new PropertyReference1Impl(Reflection.a(DatabaseEventDataSource.class), "adapter", "getAdapter()Lcom/squareup/moshi/JsonAdapter;"))};
    private final Lazy f15719b = LazyKt.a((Function0) new DatabaseEventDataSource$adapter$2(this));
    private final Moshi f15720c;

    private final JsonAdapter<Event> m15808b() {
        return (JsonAdapter) this.f15719b.b();
    }

    @Inject
    public DatabaseEventDataSource(Moshi moshi) {
        Intrinsics.b(moshi, "moshi");
        this.f15720c = moshi;
    }

    public final Single<Boolean> mo2906a(Event event) {
        Intrinsics.b(event, "event");
        Long l = event.client_timestamp;
        Intrinsics.a(l, "event.client_timestamp");
        long longValue = l.longValue();
        event = m15808b().toJson(event);
        Intrinsics.a(event, "adapter.toJson(event)");
        Charset charset = Charsets.a;
        if (event == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        event = event.getBytes(charset);
        Intrinsics.a(event, "(this as java.lang.String).getBytes(charset)");
        event = new EventDataModel(0, longValue, new Blob(event), false, 9, null).save();
        Intrinsics.a(event, "EventDataModel(\n        …Array())\n        ).save()");
        return event;
    }

    public final Single<Boolean> mo2907a(Collection<Long> collection) {
        Intrinsics.b(collection, "eventIds");
        collection = Single.fromCallable(new DatabaseEventDataSource$markDispatched$1(collection)).onErrorReturnItem(Boolean.valueOf(false));
        Intrinsics.a(collection, "Single.fromCallable {\n  ….onErrorReturnItem(false)");
        return collection;
    }

    public final Single<Boolean> mo2905a(long j) {
        j = Single.fromCallable(new DatabaseEventDataSource$deleteOldDispatchedEvents$1(j)).onErrorReturnItem(Boolean.valueOf(false));
        Intrinsics.a(j, "Single.fromCallable {\n  ….onErrorReturnItem(false)");
        return j;
    }

    public final Maybe<EventsResult> mo2904a(int i) {
        Select select = SQLite.select(new IProperty[0]);
        Intrinsics.a(select, "SQLite.select()");
        i = QueryExtensionsKt.from(select, Reflection.a(EventDataModel.class)).where(EventDataModel_Table.dispatched.notEq(Boolean.valueOf(true))).orderBy(EventDataModel_Table.timestamp.asc()).limit(i);
        Intrinsics.a(i, "select.from(EventDataMod…            .limit(limit)");
        i = com.raizlabs.android.dbflow.rx2.kotlinextensions.QueryExtensionsKt.rx((ModelQueriable) i).queryList().map(new DatabaseEventDataSource$getEventsForDispatch$1(this)).toMaybe();
        Intrinsics.a(i, "select.from(EventDataMod…)\n            }.toMaybe()");
        return i;
    }

    public final Maybe<List<Event>> mo2903a() {
        Select select = SQLite.select(new IProperty[0]);
        Intrinsics.a(select, "SQLite.select()");
        Where limit = QueryExtensionsKt.from(select, Reflection.a(EventDataModel.class)).orderBy(EventDataModel_Table.timestamp.asc()).limit(100);
        Intrinsics.a(limit, "select.from(EventDataMod…            .limit(limit)");
        Maybe<List<Event>> toMaybe = com.raizlabs.android.dbflow.rx2.kotlinextensions.QueryExtensionsKt.rx((ModelQueriable) limit).queryList().map(new DatabaseEventDataSource$getEvents$1(this)).toMaybe();
        Intrinsics.a(toMaybe, "select.from(EventDataMod…}\n            }.toMaybe()");
        return toMaybe;
    }
}
