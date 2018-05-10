package com.reddit.frontpage.util;

import android.util.LruCache;
import de.greenrobot.event.EventBus;

@Deprecated
public abstract class EventLruCache<K, V> extends LruCache<K, V> {
    public abstract Object createEvent(K k);

    public EventLruCache(int i) {
        super(i);
    }

    public void putAndNotify(K k, V v) {
        super.put(k, v);
        EventBus.getDefault().post(createEvent(k));
    }
}
