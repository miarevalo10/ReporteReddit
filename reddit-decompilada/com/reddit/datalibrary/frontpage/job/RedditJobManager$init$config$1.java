package com.reddit.datalibrary.frontpage.job;

import com.birbit.android.jobqueue.log.CustomLogger;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0016¢\u0006\u0002\u0010\nJ)\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0016¢\u0006\u0002\u0010\nJ1\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0016¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J)\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u0012"}, d2 = {"com/reddit/datalibrary/frontpage/job/RedditJobManager$init$config$1", "Lcom/birbit/android/jobqueue/log/CustomLogger;", "()V", "d", "", "text", "", "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "e", "t", "", "(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V", "isDebugEnabled", "", "v", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditJobManager.kt */
public final class RedditJobManager$init$config$1 implements CustomLogger {
    RedditJobManager$init$config$1() {
    }

    public final void mo820c(String str, Object... objArr) {
        Intrinsics.b(str, "text");
        Intrinsics.b(objArr, "args");
        Timber.a(str, Arrays.copyOf(objArr, objArr.length));
    }

    public final void mo817a(String str, Object... objArr) {
        Intrinsics.b(str, "text");
        Intrinsics.b(objArr, "args");
        Timber.b(str, Arrays.copyOf(objArr, objArr.length));
    }

    public final void mo818a(Throwable th, String str, Object... objArr) {
        Intrinsics.b(th, "t");
        Intrinsics.b(str, "text");
        Intrinsics.b(objArr, "args");
        Timber.c(th, str, Arrays.copyOf(objArr, objArr.length));
    }

    public final void mo819b(String str, Object... objArr) {
        Intrinsics.b(str, "text");
        Intrinsics.b(objArr, "args");
        Timber.e(str, Arrays.copyOf(objArr, objArr.length));
    }
}
