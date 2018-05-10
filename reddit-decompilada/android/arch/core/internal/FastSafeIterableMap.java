package android.arch.core.internal;

import java.util.HashMap;

public class FastSafeIterableMap<K, V> extends SafeIterableMap<K, V> {
    private HashMap<K, Entry<K, V>> f10946e = new HashMap();

    public final boolean m9404a(K k) {
        return this.f10946e.containsKey(k);
    }
}
