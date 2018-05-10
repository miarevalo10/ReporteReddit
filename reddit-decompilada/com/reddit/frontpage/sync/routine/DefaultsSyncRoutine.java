package com.reddit.frontpage.sync.routine;

import android.accounts.Account;
import android.content.Context;
import com.reddit.frontpage.util.SessionUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/reddit/frontpage/sync/routine/DefaultsSyncRoutine;", "Lcom/reddit/frontpage/sync/routine/SubredditSyncRoutine;", "()V", "sync", "", "account", "Landroid/accounts/Account;", "context", "Landroid/content/Context;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: DefaultsSyncRoutine.kt */
public final class DefaultsSyncRoutine extends SubredditSyncRoutine {
    public static final int f34182a = 0;
    public static final Companion f34183b = new Companion();
    private static final String f34184e = "DefaultsSyncRoutine";

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/sync/routine/DefaultsSyncRoutine$Companion;", "", "()V", "SYNC_ID", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: DefaultsSyncRoutine.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public DefaultsSyncRoutine() {
        super(f34182a);
    }

    public final boolean mo4941a(Account account, Context context) {
        Intrinsics.m26847b(account, "account");
        Intrinsics.m26847b(context, "context");
        Timber.b("Starting default subreddit sync.", new Object[0]);
        if (SessionUtil.m23892a(account, f34184e) == null) {
            return false;
        }
        try {
            m29924b().a();
            m29925c().m22497b().blockingGet();
            Timber.b("Default subreddit sync complete.", new Object[0]);
            return true;
        } catch (Account account2) {
            Timber.c((Throwable) account2, "Unable to sync default subreddits", new Object[0]);
            return false;
        }
    }

    static {
        Intrinsics.m26843a(DefaultsSyncRoutine.class.getSimpleName(), "DefaultsSyncRoutine::class.java.simpleName");
    }
}
