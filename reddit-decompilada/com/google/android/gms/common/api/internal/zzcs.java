package com.google.android.gms.common.api.internal;

import com.google.android.gms.internal.zzbhb;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class zzcs {
    private static final ExecutorService f5823a = new ThreadPoolExecutor(0, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzbhb("GAC_Transform"));

    public static ExecutorService m4758a() {
        return f5823a;
    }
}
