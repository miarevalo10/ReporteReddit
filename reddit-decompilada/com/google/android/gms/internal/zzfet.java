package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzfet implements Iterator {
    private int f7380a = 0;
    private final int f7381b = this.f7382c.mo3503a();
    private /* synthetic */ zzfes f7382c;

    zzfet(zzfes com_google_android_gms_internal_zzfes) {
        this.f7382c = com_google_android_gms_internal_zzfes;
    }

    private final byte m5961a() {
        try {
            zzfes com_google_android_gms_internal_zzfes = this.f7382c;
            int i = this.f7380a;
            this.f7380a = i + 1;
            return com_google_android_gms_internal_zzfes.mo3502a(i);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public final boolean hasNext() {
        return this.f7380a < this.f7381b;
    }

    public final /* synthetic */ Object next() {
        return Byte.valueOf(m5961a());
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
