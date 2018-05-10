package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzzv
public final class zzamz implements Iterable<zzamx> {
    public final List<zzamx> f6590a = new LinkedList();

    public static boolean m5429a(zzamp com_google_android_gms_internal_zzamp) {
        zzamx b = m5430b(com_google_android_gms_internal_zzamp);
        if (b == null) {
            return false;
        }
        b.f17574b.mo3459a();
        return true;
    }

    static zzamx m5430b(zzamp com_google_android_gms_internal_zzamp) {
        Iterator it = zzbs.m4505x().iterator();
        while (it.hasNext()) {
            zzamx com_google_android_gms_internal_zzamx = (zzamx) it.next();
            if (com_google_android_gms_internal_zzamx.f17573a == com_google_android_gms_internal_zzamp) {
                return com_google_android_gms_internal_zzamx;
            }
        }
        return null;
    }

    public final Iterator<zzamx> iterator() {
        return this.f6590a.iterator();
    }
}
