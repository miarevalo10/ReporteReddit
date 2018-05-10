package com.reddit.frontpage.sync.routine;

import android.accounts.Account;
import android.content.Context;
import com.reddit.frontpage.util.SessionUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/reddit/frontpage/sync/routine/SubscriptionsSyncRoutine;", "Lcom/reddit/frontpage/sync/routine/SubredditSyncRoutine;", "()V", "sync", "", "account", "Landroid/accounts/Account;", "context", "Landroid/content/Context;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SubscriptionsSyncRoutine.kt */
public final class SubscriptionsSyncRoutine extends SubredditSyncRoutine {
    public static final int f34191a = 1;
    public static final Companion f34192b = new Companion();
    private static final String f34193e = "SubscriptionsSyncRoutine";

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006XD¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/reddit/frontpage/sync/routine/SubscriptionsSyncRoutine$Companion;", "", "()V", "SYNC_ID", "", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: SubscriptionsSyncRoutine.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public SubscriptionsSyncRoutine() {
        super(f34191a);
    }

    public final boolean mo4941a(Account account, Context context) {
        Intrinsics.m26847b(account, "account");
        Intrinsics.m26847b(context, "context");
        Timber.b("Starting subscriptions sync.", new Object[0]);
        account = SessionUtil.m23892a(account, f34193e);
        if (account == null) {
            return false;
        }
        try {
            m29924b().a(account);
            m29925c().m22499c().blockingGet();
            Timber.b("Subscriptions sync complete.", new Object[0]);
            return true;
        } catch (Account account2) {
            Timber.c((Throwable) account2, "Unable to sync subscribed subreddits", new Object[0]);
            return false;
        }
    }
}
