package com.reddit.frontpage.sync;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import com.reddit.datalibrary.frontpage.data.feature.settings.InternalSettings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J0\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0014"}, d2 = {"Lcom/reddit/frontpage/sync/RedditSyncAdapter;", "Landroid/content/AbstractThreadedSyncAdapter;", "context", "Landroid/content/Context;", "autoInitialize", "", "(Landroid/content/Context;Z)V", "onPerformSync", "", "account", "Landroid/accounts/Account;", "extras", "Landroid/os/Bundle;", "authority", "", "provider", "Landroid/content/ContentProviderClient;", "syncResult", "Landroid/content/SyncResult;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditSyncAdapter.kt */
public class RedditSyncAdapter extends AbstractThreadedSyncAdapter {
    public static final Companion f21047a = new Companion();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/sync/RedditSyncAdapter$Companion;", "", "()V", "SYNC_ID_UNDEFINED", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: RedditSyncAdapter.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public RedditSyncAdapter(Context context) {
        Intrinsics.m26847b(context, "context");
        super(context, true);
    }

    public void onPerformSync(Account account, Bundle bundle, String str, ContentProviderClient contentProviderClient, SyncResult syncResult) {
        Intrinsics.m26847b(account, "account");
        Intrinsics.m26847b(bundle, "extras");
        Intrinsics.m26847b(str, "authority");
        Intrinsics.m26847b(contentProviderClient, "provider");
        Intrinsics.m26847b(syncResult, "syncResult");
        int i = bundle.getInt("com.reddit.frontpage.sync_id", -1);
        if (i == -1) {
            Timber.b("Sync routine undefined for %s/%s", new Object[]{account, str});
            return;
        }
        str = SyncSchedule.m23254a(str, i);
        if (str == null) {
            Timber.e("Unknown sync id (%d) was requested", new Object[]{Integer.valueOf(i)});
            return;
        }
        Object context = getContext();
        Intrinsics.m26843a(context, "context");
        str = str.mo4941a(account, context);
        InternalSettings.a().a(account.name, i, System.currentTimeMillis());
        if (str == null) {
            syncResult.tooManyRetries = true;
        }
    }
}
