package com.reddit.data.events.datasource.local;

import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.reddit.data.events.models.EventDataModel;
import com.reddit.data.events.models.EventDataModel_Table;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: DatabaseEventDataSource.kt */
final class DatabaseEventDataSource$deleteOldDispatchedEvents$1<V> implements Callable<T> {
    final /* synthetic */ long f10297a;

    DatabaseEventDataSource$deleteOldDispatchedEvents$1(long j) {
        this.f10297a = j;
    }

    public final /* synthetic */ Object call() {
        SQLite.delete().from(EventDataModel.class).where(EventDataModel_Table.timestamp.lessThan(Long.valueOf(this.f10297a))).and(EventDataModel_Table.dispatched.eq(Boolean.valueOf(true))).execute();
        return Boolean.valueOf(true);
    }
}
