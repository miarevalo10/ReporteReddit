package com.reddit.datalibrary.frontpage.data.common.db2;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.JobIntentService;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.reddit.data.events.models.EventDataModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\b"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/db2/MigrateEventsTableService;", "Landroid/support/v4/app/JobIntentService;", "()V", "onHandleWork", "", "intent", "Landroid/content/Intent;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: MigrateEventsTableService.kt */
public final class MigrateEventsTableService extends JobIntentService {
    public static final Companion f15729j = new Companion();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/common/db2/MigrateEventsTableService$Companion;", "", "()V", "JOB_ID", "", "start", "", "context", "Landroid/content/Context;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: MigrateEventsTableService.kt */
    public static final class Companion {
        private Companion() {
        }

        public static void m8766a(Context context) {
            Intrinsics.b(context, "context");
            JobIntentService.m653a(context, MigrateEventsTableService.class, 0, new Intent());
        }
    }

    public static final void m15815a(Context context) {
        Companion.m8766a(context);
    }

    protected final void mo2910a(Intent intent) {
        Intrinsics.b(intent, "intent");
        try {
            List<EventDataModel> list = (List) new ArrayList();
            FlowManager.getDatabase(RedditFlowSharedDatabase.class).executeTransaction(new MigrateEventsTableService$onHandleWork$1(list));
            for (EventDataModel insert : list) {
                insert.insert();
            }
        } catch (Intent intent2) {
            Timber.c((Throwable) intent2, "Failed to migrate events table", new Object[0]);
        }
    }
}
