package com.reddit.datalibrary.frontpage.data.common.db2;

import com.raizlabs.android.dbflow.structure.database.FlowCursor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/raizlabs/android/dbflow/structure/database/FlowCursor;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: MigrateEventsTableService.kt */
final class MigrateEventsTableService$onHandleWork$1$1$1 extends Lambda implements Function0<FlowCursor> {
    final /* synthetic */ FlowCursor f19337a;

    MigrateEventsTableService$onHandleWork$1$1$1(FlowCursor flowCursor) {
        this.f19337a = flowCursor;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return this.f19337a.moveToNext() ? this.f19337a : null;
    }
}
