package com.reddit.datalibrary.frontpage.data.common.db2;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;
import com.raizlabs.android.dbflow.structure.database.transaction.ITransaction;
import com.reddit.datalibrary.frontpage.data.model.EventDataModel;
import java.io.Closeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.sequences.SequencesKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "db", "Lcom/raizlabs/android/dbflow/structure/database/DatabaseWrapper;", "kotlin.jvm.PlatformType", "execute"}, k = 3, mv = {1, 1, 9})
/* compiled from: MigrateEventsTableService.kt */
final class MigrateEventsTableService$onHandleWork$1 implements ITransaction {
    final /* synthetic */ List f15728a;

    MigrateEventsTableService$onHandleWork$1(List list) {
        this.f15728a = list;
    }

    public final void execute(DatabaseWrapper databaseWrapper) {
        Closeable query = databaseWrapper.query(FlowManager.getTableName(EventDataModel.class), null, null, null, null, null, null);
        try {
            SequencesKt.a(SequencesKt.e(SequencesKt.a(new MigrateEventsTableService$onHandleWork$1$1$1((FlowCursor) query)), new MigrateEventsTableService$onHandleWork$1$1$2(FlowManager.getModelAdapter(com.reddit.data.events.models.EventDataModel.class))), this.f15728a);
            CloseableKt.a(query, null);
            databaseWrapper.delete(FlowManager.getTableName(EventDataModel.class), null, null);
        } catch (Throwable th) {
            CloseableKt.a(query, databaseWrapper);
        }
    }
}
