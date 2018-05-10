package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.util.Util;

public final class Descriptor {
    public final String f4827a;
    public final String f4828b;
    public final String f4829c;

    public Descriptor(String str, String str2, String str3) {
        this.f4827a = str;
        this.f4828b = str2;
        this.f4829c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                Descriptor descriptor = (Descriptor) obj;
                return Util.m4313a(this.f4827a, descriptor.f4827a) && Util.m4313a(this.f4828b, descriptor.f4828b) && Util.m4313a(this.f4829c, descriptor.f4829c) != null;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = 31 * (((this.f4827a != null ? this.f4827a.hashCode() : 0) * 31) + (this.f4828b != null ? this.f4828b.hashCode() : 0));
        if (this.f4829c != null) {
            i = this.f4829c.hashCode();
        }
        return hashCode + i;
    }
}
