package com.bumptech.glide.load.engine.bitmap_recycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupedLinkedMap<K extends Poolable, V> {
    private final LinkedEntry<K, V> f3447a = new LinkedEntry();
    private final Map<K, LinkedEntry<K, V>> f3448b = new HashMap();

    private static class LinkedEntry<K, V> {
        final K f3443a;
        List<V> f3444b;
        LinkedEntry<K, V> f3445c;
        LinkedEntry<K, V> f3446d;

        LinkedEntry() {
            this(null);
        }

        LinkedEntry(K k) {
            this.f3446d = this;
            this.f3445c = this;
            this.f3443a = k;
        }

        public final V m2952a() {
            int b = m2953b();
            return b > 0 ? this.f3444b.remove(b - 1) : null;
        }

        public final int m2953b() {
            return this.f3444b != null ? this.f3444b.size() : 0;
        }
    }

    GroupedLinkedMap() {
    }

    public final void m2958a(K k, V v) {
        LinkedEntry linkedEntry = (LinkedEntry) this.f3448b.get(k);
        if (linkedEntry == null) {
            linkedEntry = new LinkedEntry(k);
            m2955b(linkedEntry);
            linkedEntry.f3446d = this.f3447a.f3446d;
            linkedEntry.f3445c = this.f3447a;
            m2954a(linkedEntry);
            this.f3448b.put(k, linkedEntry);
        } else {
            k.mo929a();
        }
        if (linkedEntry.f3444b == null) {
            linkedEntry.f3444b = new ArrayList();
        }
        linkedEntry.f3444b.add(v);
    }

    public final V m2957a(K k) {
        LinkedEntry linkedEntry = (LinkedEntry) this.f3448b.get(k);
        if (linkedEntry == null) {
            linkedEntry = new LinkedEntry(k);
            this.f3448b.put(k, linkedEntry);
        } else {
            k.mo929a();
        }
        m2955b(linkedEntry);
        linkedEntry.f3446d = this.f3447a;
        linkedEntry.f3445c = this.f3447a.f3445c;
        m2954a(linkedEntry);
        return linkedEntry.m2952a();
    }

    public final V m2956a() {
        for (LinkedEntry linkedEntry = this.f3447a.f3446d; !linkedEntry.equals(this.f3447a); linkedEntry = linkedEntry.f3446d) {
            V a = linkedEntry.m2952a();
            if (a != null) {
                return a;
            }
            m2955b(linkedEntry);
            this.f3448b.remove(linkedEntry.f3443a);
            ((Poolable) linkedEntry.f3443a).mo929a();
        }
        return null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("GroupedLinkedMap( ");
        Object obj = null;
        for (LinkedEntry linkedEntry = this.f3447a.f3445c; !linkedEntry.equals(this.f3447a); linkedEntry = linkedEntry.f3445c) {
            obj = 1;
            stringBuilder.append('{');
            stringBuilder.append(linkedEntry.f3443a);
            stringBuilder.append(':');
            stringBuilder.append(linkedEntry.m2953b());
            stringBuilder.append("}, ");
        }
        if (obj != null) {
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        }
        stringBuilder.append(" )");
        return stringBuilder.toString();
    }

    private static <K, V> void m2954a(LinkedEntry<K, V> linkedEntry) {
        linkedEntry.f3445c.f3446d = linkedEntry;
        linkedEntry.f3446d.f3445c = linkedEntry;
    }

    private static <K, V> void m2955b(LinkedEntry<K, V> linkedEntry) {
        linkedEntry.f3446d.f3445c = linkedEntry.f3445c;
        linkedEntry.f3445c.f3446d = linkedEntry.f3446d;
    }
}
