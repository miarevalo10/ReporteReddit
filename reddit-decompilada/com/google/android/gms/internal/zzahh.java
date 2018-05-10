package com.google.android.gms.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@zzzv
public final class zzahh {
    public static final ThreadPoolExecutor f6369a = new ThreadPoolExecutor(20, 20, 1, TimeUnit.MINUTES, new LinkedBlockingQueue(), m5150a("Default"));
    private static final ThreadPoolExecutor f6370b = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES, new LinkedBlockingQueue(), m5150a("Loader"));

    static {
        f6369a.allowCoreThreadTimeOut(true);
        f6370b.allowCoreThreadTimeOut(true);
    }

    public static zzakv<Void> m5147a(int i, Runnable runnable) {
        ExecutorService executorService;
        Callable com_google_android_gms_internal_zzahi;
        if (i == 1) {
            executorService = f6370b;
            com_google_android_gms_internal_zzahi = new zzahi(runnable);
        } else {
            executorService = f6369a;
            com_google_android_gms_internal_zzahi = new zzahj(runnable);
        }
        return m5149a(executorService, com_google_android_gms_internal_zzahi);
    }

    public static zzakv<Void> m5148a(Runnable runnable) {
        return m5147a(0, runnable);
    }

    public static <T> zzakv<T> m5149a(ExecutorService executorService, Callable<T> callable) {
        zzakv<T> com_google_android_gms_internal_zzalf = new zzalf();
        try {
            com_google_android_gms_internal_zzalf.mo1732a(new zzahl(com_google_android_gms_internal_zzalf, executorService.submit(new zzahk(com_google_android_gms_internal_zzalf, callable))), zzala.f6511a);
            return com_google_android_gms_internal_zzalf;
        } catch (Throwable e) {
            zzakb.m5369c("Thread execution is rejected.", e);
            com_google_android_gms_internal_zzalf.m13329a(e);
            return com_google_android_gms_internal_zzalf;
        }
    }

    private static ThreadFactory m5150a(String str) {
        return new zzahm(str);
    }
}
