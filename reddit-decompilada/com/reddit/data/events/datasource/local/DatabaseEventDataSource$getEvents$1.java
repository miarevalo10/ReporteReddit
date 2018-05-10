package com.reddit.data.events.datasource.local;

import com.reddit.data.events.models.Event;
import com.reddit.data.events.models.EventDataModel;
import com.squareup.moshi.JsonAdapter;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012(\u0010\u0003\u001a$\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00010\u0004H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "Lcom/reddit/data/events/models/Event;", "it", "", "Lcom/reddit/data/events/models/EventDataModel;", "kotlin.jvm.PlatformType", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: DatabaseEventDataSource.kt */
final class DatabaseEventDataSource$getEvents$1<T, R> implements Function<T, R> {
    final /* synthetic */ DatabaseEventDataSource f15716a;

    DatabaseEventDataSource$getEvents$1(DatabaseEventDataSource databaseEventDataSource) {
        this.f15716a = databaseEventDataSource;
    }

    public final /* synthetic */ Object apply(Object obj) {
        List list = (List) obj;
        Intrinsics.b(list, "it");
        Iterable<EventDataModel> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.b(iterable));
        for (EventDataModel eventDataModel : iterable) {
            JsonAdapter a = this.f15716a.m15808b();
            Object blob = eventDataModel.getEvent().getBlob();
            Intrinsics.a(blob, "it.event.blob");
            blob = a.fromJson(new String(blob, Charsets.a));
            if (blob == null) {
                Intrinsics.a();
            }
            arrayList.add((Event) blob);
        }
        return (List) arrayList;
    }
}
