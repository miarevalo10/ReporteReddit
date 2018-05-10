package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

public final class zzae {
    final Map<BasePendingResult<?>, Boolean> f5766a = Collections.synchronizedMap(new WeakHashMap());
    final Map<TaskCompletionSource<?>, Boolean> f5767b = Collections.synchronizedMap(new WeakHashMap());

    final void m4695a(boolean z, Status status) {
        synchronized (this.f5766a) {
            Map hashMap = new HashMap(this.f5766a);
        }
        synchronized (this.f5767b) {
            Map hashMap2 = new HashMap(this.f5767b);
        }
        for (Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).m12830b(status);
            }
        }
        for (Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((TaskCompletionSource) entry2.getKey()).m6860b(new ApiException(status));
            }
        }
    }
}
