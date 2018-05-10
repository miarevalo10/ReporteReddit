package com.reddit.datalibrary.frontpage.data.provider;

import android.database.Cursor;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.list.FlowCursorIterator;
import com.raizlabs.android.dbflow.list.FlowCursorList;
import com.raizlabs.android.dbflow.list.FlowCursorList.Builder;
import com.raizlabs.android.dbflow.list.IFlowCursorIterator;
import com.raizlabs.android.dbflow.structure.ModelAdapter;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;
import com.reddit.datalibrary.frontpage.data.common.db2.RedditFlowSharedDatabase;
import com.reddit.datalibrary.frontpage.requests.models.v2.Subreddit;
import com.reddit.datalibrary.frontpage.requests.models.v2.SubredditInfo;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0017\u0010\u000f\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0010\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u0011J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0002J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/provider/DelegatedFlowCursorList;", "TModel", "", "Lcom/raizlabs/android/dbflow/list/IFlowCursorIterator;", "builder", "Lcom/raizlabs/android/dbflow/list/FlowCursorList$Builder;", "(Lcom/raizlabs/android/dbflow/list/FlowCursorList$Builder;)V", "flowCursor", "Lcom/raizlabs/android/dbflow/list/FlowCursorList;", "close", "", "cursor", "Landroid/database/Cursor;", "getCount", "", "getItem", "position", "(J)Ljava/lang/Object;", "iterator", "Lcom/raizlabs/android/dbflow/list/FlowCursorIterator;", "startingLocation", "", "limit", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: DelegatedFlowCursorList.kt */
public final class DelegatedFlowCursorList<TModel> implements IFlowCursorIterator<TModel>, Iterable<TModel>, KMappedMarker {
    private final FlowCursorList<TModel> f16235a;

    public DelegatedFlowCursorList(Builder<TModel> builder) {
        Intrinsics.b(builder, "builder");
        builder = builder.build();
        Intrinsics.a(builder, "builder.build()");
        this.f16235a = builder;
    }

    public final FlowCursorIterator<TModel> iterator(int i, long j) {
        return new FlowCursorIterator(this.f16235a, i, j);
    }

    public final FlowCursorIterator<TModel> iterator() {
        return new FlowCursorIterator(this.f16235a);
    }

    public final TModel getItem(long j) {
        j = this.f16235a.getItem(j);
        if (j instanceof Subreddit) {
            ModelAdapter modelAdapterForTable = FlowManager.getDatabase(RedditFlowSharedDatabase.class).getModelAdapterForTable(SubredditInfo.class);
            if (modelAdapterForTable == null) {
                Intrinsics.a();
            }
            ModelAdapter modelAdapterForTable2 = FlowManager.getDatabase(RedditFlowSharedDatabase.class).getModelAdapterForTable(Subreddit.class);
            if (modelAdapterForTable2 == null) {
                Intrinsics.a();
            }
            Cursor cursor = this.f16235a.cursor();
            if (cursor == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.raizlabs.android.dbflow.structure.database.FlowCursor");
            }
            modelAdapterForTable.loadFromCursor((FlowCursor) cursor, j);
            Cursor cursor2 = this.f16235a.cursor();
            if (cursor2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.raizlabs.android.dbflow.structure.database.FlowCursor");
            }
            modelAdapterForTable2.loadFromCursor((FlowCursor) cursor2, j);
        }
        return j;
    }

    public final long getCount() {
        return this.f16235a.getCount();
    }

    public final void close() {
        this.f16235a.close();
    }

    public final Cursor cursor() {
        return this.f16235a.cursor();
    }
}
