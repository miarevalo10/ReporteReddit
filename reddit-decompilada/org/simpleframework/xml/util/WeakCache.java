package org.simpleframework.xml.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

public class WeakCache<T> implements Cache<T> {
    private SegmentList list;

    private class Segment extends WeakHashMap<Object, T> {
        final /* synthetic */ WeakCache f27207a;

        private Segment(WeakCache weakCache) {
            this.f27207a = weakCache;
        }

        public final synchronized void m28679a(Object obj, T t) {
            put(obj, t);
        }

        public final synchronized T m28678a(Object obj) {
            return get(obj);
        }

        public final synchronized T m28680b(Object obj) {
            return remove(obj);
        }

        public final synchronized boolean m28681c(Object obj) {
            return containsKey(obj);
        }
    }

    private class SegmentList implements Iterable<Segment> {
        List<Segment> f27208a = new ArrayList();
        int f27209b;
        final /* synthetic */ WeakCache f27210c;

        public SegmentList(WeakCache weakCache, int i) {
            this.f27210c = weakCache;
            this.f27209b = i;
            m28682a(i);
        }

        public Iterator<Segment> iterator() {
            return this.f27208a.iterator();
        }

        private void m28682a(int i) {
            while (true) {
                int i2 = i - 1;
                if (i > 0) {
                    this.f27208a.add(new Segment());
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }

    public WeakCache() {
        this(10);
    }

    public WeakCache(int i) {
        this.list = new SegmentList(this, i);
    }

    public boolean isEmpty() {
        Iterator it = this.list.iterator();
        while (it.hasNext()) {
            if (!((Segment) it.next()).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public void cache(Object obj, T t) {
        map(obj).m28679a(obj, t);
    }

    public T take(Object obj) {
        return map(obj).m28680b(obj);
    }

    public T fetch(Object obj) {
        return map(obj).m28678a(obj);
    }

    public boolean contains(Object obj) {
        return map(obj).m28681c(obj);
    }

    private Segment map(Object obj) {
        SegmentList segmentList = this.list;
        obj = Math.abs(obj.hashCode() % segmentList.f27209b);
        return obj < segmentList.f27209b ? (Segment) segmentList.f27208a.get(obj) : null;
    }
}
