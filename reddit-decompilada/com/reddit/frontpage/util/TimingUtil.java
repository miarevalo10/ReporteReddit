package com.reddit.frontpage.util;

import com.google.common.base.Stopwatch;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0007H\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0007H\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u0007H\u0007J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/reddit/frontpage/util/TimingUtil;", "", "()V", "TIMER_NOT_STARTED_STATE", "", "timers", "", "", "Lcom/google/common/base/Stopwatch;", "getTimers", "()Ljava/util/Map;", "elapsedTime", "tag", "endTimer", "startTimer", "", "startTimerClean", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: TimingUtil.kt */
public final class TimingUtil {
    public static final TimingUtil f21804a = new TimingUtil();
    private static final Map<String, Stopwatch> f21805b = new LinkedHashMap();

    private TimingUtil() {
    }

    public static final void m23938a(String str) {
        Intrinsics.m26847b(str, "tag");
        f21805b.remove(str);
        m23939b(str);
    }

    public static final void m23939b(String str) {
        Intrinsics.m26847b(str, "tag");
        if (f21805b.containsKey(str)) {
            Timber.e("Timer %s has already been started", new Object[]{str});
            return;
        }
        Object b = Stopwatch.b();
        Map map = f21805b;
        Intrinsics.m26843a(b, "stopwatch");
        map.put(str, b);
    }

    public static final long m23940c(String str) {
        Intrinsics.m26847b(str, "tag");
        Stopwatch stopwatch = (Stopwatch) f21805b.get(str);
        long j = -1;
        if (stopwatch == null) {
            return -1;
        }
        if (stopwatch.c()) {
            j = stopwatch.a(TimeUnit.MILLISECONDS);
        }
        return j;
    }

    public static final long m23941d(String str) {
        Intrinsics.m26847b(str, "tag");
        long c = m23940c(str);
        f21805b.remove(str);
        return c;
    }
}
