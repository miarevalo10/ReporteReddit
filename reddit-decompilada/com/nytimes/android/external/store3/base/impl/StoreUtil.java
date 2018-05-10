package com.nytimes.android.external.store3.base.impl;

import com.nytimes.android.external.store3.base.Persister;
import com.nytimes.android.external.store3.base.RecordProvider;
import com.nytimes.android.external.store3.base.RecordState;

final class StoreUtil {
    private StoreUtil() {
    }

    static <Raw, Key> boolean m8712a(Persister<Raw, Key> persister, StalePolicy stalePolicy, Key key) {
        return (stalePolicy != StalePolicy.NETWORK_BEFORE_STALE || m8713a((Object) key, (Persister) persister) == null) ? null : true;
    }

    static <Raw, Key> boolean m8713a(Key key, Persister<Raw, Key> persister) {
        if ((persister instanceof RecordProvider) && ((RecordProvider) persister).mo3787b(key) == RecordState.STALE) {
            return true;
        }
        return false;
    }
}
