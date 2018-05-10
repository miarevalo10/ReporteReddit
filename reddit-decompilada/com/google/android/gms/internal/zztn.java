package com.google.android.gms.internal;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;

@zzzv
final class zztn {
    private static final zztk f8028a = zztk.m6655a();
    private static final float f8029b = ((Float) zzkb.m6350f().m6488a(zznh.aR)).floatValue();
    private static final long f8030c = ((Long) zzkb.m6350f().m6488a(zznh.aP)).longValue();
    private static final float f8031d = ((Float) zzkb.m6350f().m6488a(zznh.aS)).floatValue();
    private static final long f8032e = ((Long) zzkb.m6350f().m6488a(zznh.aQ)).longValue();

    private static int m6659a(long j, int i) {
        return (int) ((j >>> (4 * (i % 16))) & 15);
    }

    static boolean m6660a() {
        int i = f8028a.f8023d;
        int i2 = f8028a.f8024e;
        int i3 = f8028a.f8022c + f8028a.f8021b;
        int i4 = RedditJobManager.f10810d;
        int a = (i >= 16 || f8032e == 0) ? f8031d != 0.0f ? ((int) (f8031d * ((float) i))) + 1 : RedditJobManager.f10810d : m6659a(f8032e, i);
        if (i2 <= a) {
            if (i < 16 && f8030c != 0) {
                i4 = m6659a(f8030c, i);
            } else if (f8029b != 0.0f) {
                i4 = (int) (f8029b * ((float) i));
            }
            if (i3 <= i4) {
                return true;
            }
        }
        return false;
    }
}
