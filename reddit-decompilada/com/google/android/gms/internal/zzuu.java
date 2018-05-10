package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzbs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzzv
public final class zzuu implements zzug {
    private final zzaat f14673a;
    private final zzux f14674b;
    private final Context f14675c;
    private final Object f14676d = new Object();
    private final zzui f14677e;
    private final boolean f14678f;
    private final long f14679g;
    private final long f14680h;
    private final zznu f14681i;
    private final boolean f14682j;
    private final String f14683k;
    private boolean f14684l = false;
    private zzul f14685m;
    private List<zzuo> f14686n = new ArrayList();
    private final boolean f14687o;

    public zzuu(Context context, zzaat com_google_android_gms_internal_zzaat, zzux com_google_android_gms_internal_zzux, zzui com_google_android_gms_internal_zzui, boolean z, boolean z2, String str, long j, long j2, zznu com_google_android_gms_internal_zznu, boolean z3) {
        this.f14675c = context;
        this.f14673a = com_google_android_gms_internal_zzaat;
        this.f14674b = com_google_android_gms_internal_zzux;
        this.f14677e = com_google_android_gms_internal_zzui;
        this.f14678f = z;
        this.f14682j = z2;
        this.f14683k = str;
        this.f14679g = j;
        this.f14680h = j2;
        this.f14681i = com_google_android_gms_internal_zznu;
        this.f14687o = z3;
    }

    public final zzuo mo2165a(List<zzuh> list) {
        Throwable th;
        Object obj;
        ArrayList arrayList;
        zzakb.m5366b("Starting mediation.");
        ArrayList arrayList2 = new ArrayList();
        zzns a = this.f14681i.m6502a();
        zzjn com_google_android_gms_internal_zzjn = this.f14673a.f17397d;
        int[] iArr = new int[2];
        if (com_google_android_gms_internal_zzjn.f18158g != null) {
            zzbs.m4503v();
            if (zzuq.m6688a(r1.f14683k, iArr)) {
                int i = 0;
                int i2 = iArr[0];
                int i3 = iArr[1];
                zzjn[] com_google_android_gms_internal_zzjnArr = com_google_android_gms_internal_zzjn.f18158g;
                int length = com_google_android_gms_internal_zzjnArr.length;
                while (i < length) {
                    zzjn com_google_android_gms_internal_zzjn2 = com_google_android_gms_internal_zzjnArr[i];
                    if (i2 == com_google_android_gms_internal_zzjn2.f18156e && i3 == com_google_android_gms_internal_zzjn2.f18153b) {
                        com_google_android_gms_internal_zzjn = com_google_android_gms_internal_zzjn2;
                        break;
                    }
                    i++;
                }
            }
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzuh com_google_android_gms_internal_zzuh = (zzuh) it.next();
            String str = "Trying mediation network: ";
            String valueOf = String.valueOf(com_google_android_gms_internal_zzuh.f8047b);
            zzakb.m5370d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            Iterator it2 = com_google_android_gms_internal_zzuh.f8048c.iterator();
            while (it2.hasNext()) {
                zzuo com_google_android_gms_internal_zzuo;
                valueOf = (String) it2.next();
                zzns a2 = r1.f14681i.m6502a();
                Object obj2 = r1.f14676d;
                synchronized (obj2) {
                    try {
                        if (r1.f14684l) {
                            try {
                                com_google_android_gms_internal_zzuo = new zzuo(-1);
                            } catch (Throwable th2) {
                                Throwable th3 = th2;
                                obj = obj2;
                                throw th3;
                            }
                        }
                        Iterator it3 = it;
                        Iterator it4 = it2;
                        zzns com_google_android_gms_internal_zzns = a;
                        zzns com_google_android_gms_internal_zzns2 = a2;
                        zzul com_google_android_gms_internal_zzul = com_google_android_gms_internal_zzul;
                        ArrayList arrayList3 = arrayList2;
                        zzul com_google_android_gms_internal_zzul2 = com_google_android_gms_internal_zzul;
                        obj = obj2;
                        try {
                            com_google_android_gms_internal_zzul = new zzul(r1.f14675c, valueOf, r1.f14674b, r1.f14677e, com_google_android_gms_internal_zzuh, r1.f14673a.f17396c, com_google_android_gms_internal_zzjn, r1.f14673a.f17404k, r1.f14678f, r1.f14682j, r1.f14673a.f17418y, r1.f14673a.f17407n, r1.f14673a.f17419z, r1.f14673a.f17391X, r1.f14687o);
                            r1.f14685m = com_google_android_gms_internal_zzul2;
                            com_google_android_gms_internal_zzuo = r1.f14685m.m14298a(r1.f14679g, r1.f14680h);
                            r1.f14686n.add(com_google_android_gms_internal_zzuo);
                            if (com_google_android_gms_internal_zzuo.f8086a == 0) {
                                zzakb.m5366b("Adapter succeeded.");
                                r1.f14681i.m6504a("mediation_network_succeed", valueOf);
                                arrayList = arrayList3;
                                if (!arrayList.isEmpty()) {
                                    r1.f14681i.m6504a("mediation_networks_fail", TextUtils.join(",", arrayList));
                                }
                                r1.f14681i.m6506a(com_google_android_gms_internal_zzns2, "mls");
                                r1.f14681i.m6506a(com_google_android_gms_internal_zzns, "ttm");
                                return com_google_android_gms_internal_zzuo;
                            }
                            zzns com_google_android_gms_internal_zzns3 = com_google_android_gms_internal_zzns;
                            zzns com_google_android_gms_internal_zzns4 = com_google_android_gms_internal_zzns2;
                            arrayList = arrayList3;
                            arrayList.add(valueOf);
                            r1.f14681i.m6506a(com_google_android_gms_internal_zzns4, "mlf");
                            if (com_google_android_gms_internal_zzuo.f8088c != null) {
                                zzahn.f6379a.post(new zzuv(com_google_android_gms_internal_zzuo));
                            }
                            arrayList2 = arrayList;
                            a = com_google_android_gms_internal_zzns3;
                            it = it3;
                            it2 = it4;
                        } catch (Throwable th4) {
                            th2 = th4;
                        }
                    } catch (Throwable th5) {
                        th2 = th5;
                        obj = obj2;
                    }
                }
                return com_google_android_gms_internal_zzuo;
            }
        }
        arrayList = arrayList2;
        if (!arrayList.isEmpty()) {
            r1.f14681i.m6504a("mediation_networks_fail", TextUtils.join(",", arrayList));
        }
        return new zzuo(1);
        th3 = th2;
        throw th3;
    }

    public final void mo2166a() {
        synchronized (this.f14676d) {
            this.f14684l = true;
            if (this.f14685m != null) {
                this.f14685m.m14299a();
            }
        }
    }

    public final List<zzuo> mo2167b() {
        return this.f14686n;
    }
}
