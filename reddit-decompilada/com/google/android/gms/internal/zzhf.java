package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzzv
public final class zzhf {
    final Object f7653a = new Object();
    int f7654b;
    List<zzhe> f7655c = new LinkedList();

    public final boolean m6280a(zzhe com_google_android_gms_internal_zzhe) {
        synchronized (this.f7653a) {
            if (this.f7655c.contains(com_google_android_gms_internal_zzhe)) {
                return true;
            }
            return false;
        }
    }

    public final zzhe m6279a() {
        synchronized (this.f7653a) {
            zzhe com_google_android_gms_internal_zzhe = null;
            if (this.f7655c.size() == 0) {
                zzakb.m5366b("Queue empty");
                return null;
            }
            int i = 0;
            if (this.f7655c.size() >= 2) {
                int i2 = Integer.MIN_VALUE;
                int i3 = 0;
                for (zzhe com_google_android_gms_internal_zzhe2 : this.f7655c) {
                    int i4 = com_google_android_gms_internal_zzhe2.f7641e;
                    if (i4 > i2) {
                        i = i3;
                        com_google_android_gms_internal_zzhe = com_google_android_gms_internal_zzhe2;
                        i2 = i4;
                    }
                    i3++;
                }
                this.f7655c.remove(i);
                return com_google_android_gms_internal_zzhe;
            }
            zzhe com_google_android_gms_internal_zzhe3 = (zzhe) this.f7655c.get(0);
            synchronized (com_google_android_gms_internal_zzhe3.f7637a) {
                com_google_android_gms_internal_zzhe3.f7641e -= 100;
            }
            return com_google_android_gms_internal_zzhe3;
        }
    }

    public final boolean m6281b(zzhe com_google_android_gms_internal_zzhe) {
        synchronized (this.f7653a) {
            Iterator it = this.f7655c.iterator();
            while (it.hasNext()) {
                zzhe com_google_android_gms_internal_zzhe2 = (zzhe) it.next();
                if (!((Boolean) zzkb.m6350f().m6488a(zznh.f7881Q)).booleanValue() || zzbs.m4490i().m13248a()) {
                    if (((Boolean) zzkb.m6350f().m6488a(zznh.f7883S)).booleanValue() && !zzbs.m4490i().m13252b() && com_google_android_gms_internal_zzhe != com_google_android_gms_internal_zzhe2 && com_google_android_gms_internal_zzhe2.f7644h.equals(com_google_android_gms_internal_zzhe.f7644h)) {
                        it.remove();
                        return true;
                    }
                } else if (com_google_android_gms_internal_zzhe != com_google_android_gms_internal_zzhe2 && com_google_android_gms_internal_zzhe2.f7642f.equals(com_google_android_gms_internal_zzhe.f7642f)) {
                    it.remove();
                    return true;
                }
            }
            return null;
        }
    }
}
