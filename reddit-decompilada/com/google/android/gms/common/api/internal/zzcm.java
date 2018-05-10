package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.internal.zzbq;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public final class zzcm {
    final Set<zzci<?>> f5816a = Collections.newSetFromMap(new WeakHashMap());

    public static <L> zzci<L> m4756a(L l, Looper looper, String str) {
        zzbq.m4809a((Object) l, (Object) "Listener must not be null");
        zzbq.m4809a((Object) looper, (Object) "Looper must not be null");
        zzbq.m4809a((Object) str, (Object) "Listener type must not be null");
        return new zzci(looper, l, str);
    }

    public static <L> zzck<L> m4757a(L l, String str) {
        zzbq.m4809a((Object) l, (Object) "Listener must not be null");
        zzbq.m4809a((Object) str, (Object) "Listener type must not be null");
        zzbq.m4811a(str, (Object) "Listener type must not be empty");
        return new zzck(l, str);
    }
}
