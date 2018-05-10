package com.reddit.frontpage.sync.routine;

import android.accounts.Account;
import android.content.Context;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/reddit/frontpage/sync/routine/SyncRoutine;", "", "syncId", "", "pollFrequency", "", "(IJ)V", "getPollFrequency", "()J", "getSyncId", "()I", "equals", "", "other", "hashCode", "sync", "account", "Landroid/accounts/Account;", "context", "Landroid/content/Context;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SyncRoutine.kt */
public abstract class SyncRoutine {
    private static final long f21056a = TimeUnit.HOURS.toSeconds(12);
    public static final Companion f21057i = new Companion();
    public final int f21058g;
    public final long f21059h;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/sync/routine/SyncRoutine$Companion;", "", "()V", "DEFAULT_POLL_FREQUENCY_TO_SECONDS", "", "getDEFAULT_POLL_FREQUENCY_TO_SECONDS", "()J", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: SyncRoutine.kt */
    public static final class Companion {
        private Companion() {
        }

        public static long m23271a() {
            return SyncRoutine.f21056a;
        }
    }

    public abstract boolean mo4941a(Account account, Context context);

    public SyncRoutine(int i, long j) {
        this.f21058g = i;
        this.f21059h = j;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof SyncRoutine) && ((SyncRoutine) obj).f21058g == this.f21058g) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f21058g;
    }
}
