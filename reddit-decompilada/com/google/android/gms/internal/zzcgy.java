package com.google.android.gms.internal;

import java.util.Iterator;

final class zzcgy implements Iterator<String> {
    private Iterator<String> f6850a = this.f6851b.f17797a.keySet().iterator();
    private /* synthetic */ zzcgx f6851b;

    zzcgy(zzcgx com_google_android_gms_internal_zzcgx) {
        this.f6851b = com_google_android_gms_internal_zzcgx;
    }

    public final boolean hasNext() {
        return this.f6850a.hasNext();
    }

    public final /* synthetic */ Object next() {
        return (String) this.f6850a.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
