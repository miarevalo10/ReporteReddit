package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzfie implements Iterator<Entry<K, V>> {
    private int f7459a;
    private boolean f7460b;
    private Iterator<Entry<K, V>> f7461c;
    private /* synthetic */ zzfhy f7462d;

    private zzfie(zzfhy com_google_android_gms_internal_zzfhy) {
        this.f7462d = com_google_android_gms_internal_zzfhy;
        this.f7459a = -1;
    }

    private final Iterator<Entry<K, V>> m6077a() {
        if (this.f7461c == null) {
            this.f7461c = this.f7462d.f7451d.entrySet().iterator();
        }
        return this.f7461c;
    }

    public final boolean hasNext() {
        return this.f7459a + 1 >= this.f7462d.f7450c.size() ? !this.f7462d.f7451d.isEmpty() && m6077a().hasNext() : true;
    }

    public final /* synthetic */ Object next() {
        this.f7460b = true;
        int i = this.f7459a + 1;
        this.f7459a = i;
        return (Entry) (i < this.f7462d.f7450c.size() ? this.f7462d.f7450c.get(this.f7459a) : m6077a().next());
    }

    public final void remove() {
        if (this.f7460b) {
            this.f7460b = false;
            this.f7462d.m6067d();
            if (this.f7459a < this.f7462d.f7450c.size()) {
                zzfhy com_google_android_gms_internal_zzfhy = this.f7462d;
                int i = this.f7459a;
                this.f7459a = i - 1;
                com_google_android_gms_internal_zzfhy.m6065c(i);
                return;
            }
            m6077a().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
