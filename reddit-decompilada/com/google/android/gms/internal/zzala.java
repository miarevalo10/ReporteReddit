package com.google.android.gms.internal;

import java.util.concurrent.Executor;

@zzzv
public final class zzala {
    public static final Executor f6511a = new zzalb();
    public static final Executor f6512b = new zzalc();
    private static zzakz f6513c = m5392a(f6511a);
    private static zzakz f6514d = m5392a(f6512b);

    private static zzakz m5392a(Executor executor) {
        return new zzald(executor, (byte) 0);
    }
}
