package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.util.HashMap;
import java.util.Map;

public final class Jobs {
    private final Map<Key, EngineJob<?>> f3434a = new HashMap();
    private final Map<Key, EngineJob<?>> f3435b = new HashMap();

    Jobs() {
    }

    public final Map<Key, EngineJob<?>> m2926a(boolean z) {
        return z ? this.f3435b : this.f3434a;
    }

    final void m2927a(Key key, EngineJob<?> engineJob) {
        Map a = m2926a(engineJob.f12403i);
        if (engineJob.equals(a.get(key)) != null) {
            a.remove(key);
        }
    }
}
