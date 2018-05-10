package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@zzzv
public final class zzyg extends zzxw {
    protected zzuo f19240g;
    private zzux f19241h;
    private zzug f19242i;
    private zzui f19243j;
    private final zznu f19244k;
    private final zzanh f19245l;
    private boolean f19246m;

    zzyg(Context context, zzafp com_google_android_gms_internal_zzafp, zzux com_google_android_gms_internal_zzux, zzyb com_google_android_gms_internal_zzyb, zznu com_google_android_gms_internal_zznu, zzanh com_google_android_gms_internal_zzanh) {
        super(context, com_google_android_gms_internal_zzafp, com_google_android_gms_internal_zzyb);
        this.f19241h = com_google_android_gms_internal_zzux;
        this.f19243j = com_google_android_gms_internal_zzafp.f6316c;
        this.f19244k = com_google_android_gms_internal_zznu;
        this.f19245l = com_google_android_gms_internal_zzanh;
    }

    private static String m20451a(List<zzuo> list) {
        String str = "";
        if (list == null) {
            return str.toString();
        }
        Iterator it = list.iterator();
        while (true) {
            int i = 0;
            if (!it.hasNext()) {
                return str.substring(0, Math.max(0, str.length() - 1));
            }
            zzuo com_google_android_gms_internal_zzuo = (zzuo) it.next();
            if (!(com_google_android_gms_internal_zzuo == null || com_google_android_gms_internal_zzuo.f8087b == null || TextUtils.isEmpty(com_google_android_gms_internal_zzuo.f8087b.f8049d))) {
                str = String.valueOf(str);
                String str2 = com_google_android_gms_internal_zzuo.f8087b.f8049d;
                switch (com_google_android_gms_internal_zzuo.f8086a) {
                    case -1:
                        i = 4;
                        break;
                    case 0:
                        break;
                    case 1:
                        i = 1;
                        break;
                    case 3:
                        i = 2;
                        break;
                    case 4:
                        i = 3;
                        break;
                    case 5:
                        i = 5;
                        break;
                    default:
                        i = 6;
                        break;
                }
                long j = com_google_android_gms_internal_zzuo.f8092g;
                StringBuilder stringBuilder = new StringBuilder(33 + String.valueOf(str2).length());
                stringBuilder.append(str2);
                stringBuilder.append(".");
                stringBuilder.append(i);
                stringBuilder.append(".");
                stringBuilder.append(j);
                String stringBuilder2 = stringBuilder.toString();
                StringBuilder stringBuilder3 = new StringBuilder((1 + String.valueOf(str).length()) + String.valueOf(stringBuilder2).length());
                stringBuilder3.append(str);
                stringBuilder3.append(stringBuilder2);
                stringBuilder3.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
                str = stringBuilder3.toString();
            }
        }
    }

    protected final zzafo mo4045a(int i) {
        zzaat com_google_android_gms_internal_zzaat = this.e.f6314a;
        zzjj com_google_android_gms_internal_zzjj = com_google_android_gms_internal_zzaat.f17396c;
        zzanh com_google_android_gms_internal_zzanh = this.f19245l;
        List list = this.f.f17443c;
        List list2 = this.f.f17445e;
        List list3 = this.f.f17449i;
        int i2 = this.f.f17451k;
        long j = this.f.f17450j;
        String str = com_google_android_gms_internal_zzaat.f17402i;
        boolean z = this.f.f17447g;
        zzuh com_google_android_gms_internal_zzuh = this.f19240g != null ? r0.f19240g.f8087b : null;
        zzva com_google_android_gms_internal_zzva = r0.f19240g != null ? r0.f19240g.f8088c : null;
        return new zzafo(com_google_android_gms_internal_zzjj, com_google_android_gms_internal_zzanh, list, i, list2, list3, i2, j, str, z, com_google_android_gms_internal_zzuh, com_google_android_gms_internal_zzva, r0.f19240g != null ? r0.f19240g.f8089d : AdMobAdapter.class.getName(), r0.f19243j, r0.f19240g != null ? r0.f19240g.f8090e : null, r0.f.f17448h, r0.e.f6317d, r0.f.f17446f, r0.e.f6319f, r0.f.f17453m, r0.f.f17454n, r0.e.f6321h, null, r0.f.f17421A, r0.f.f17422B, r0.f.f17423C, r0.f19243j != null ? r0.f19243j.f8078n : false, r0.f.f17425E, r0.f19242i != null ? m20451a(r0.f19242i.mo2167b()) : null, r0.f.f17428H, r0.f.f17432L, r0.e.f6322i, r0.f.f17435O, r0.e.f6323j);
    }

    protected final void mo4046a(long j) throws zzxz {
        boolean z;
        ListIterator listIterator;
        StringBuilder stringBuilder;
        synchronized (this.d) {
            zzug com_google_android_gms_internal_zzug;
            try {
                if (r1.f19243j.f8076l != -1) {
                    Context context = r1.b;
                    zzaat com_google_android_gms_internal_zzaat = r1.e.f6314a;
                    zzux com_google_android_gms_internal_zzux = r1.f19241h;
                    zzui com_google_android_gms_internal_zzui = r1.f19243j;
                    boolean z2 = r1.f.f17459s;
                    boolean z3 = r1.f.f17466z;
                    String str = r1.f.f17430J;
                    long longValue = ((Long) zzkb.m6350f().m6488a(zznh.bn)).longValue();
                    boolean z4 = r1.e.f6323j;
                } else {
                    zzug com_google_android_gms_internal_zzuu = new zzuu(r1.b, r1.e.f6314a, r1.f19241h, r1.f19243j, r1.f.f17459s, r1.f.f17466z, r1.f.f17430J, j, ((Long) zzkb.m6350f().m6488a(zznh.bn)).longValue(), r1.f19244k, r1.e.f6323j);
                }
                r1.f19242i = com_google_android_gms_internal_zzug;
            } finally {
                com_google_android_gms_internal_zzug = r0;
            }
        }
        List arrayList = new ArrayList(r1.f19243j.f8065a);
        Bundle bundle = r1.e.f6314a.f17396c.f18146m;
        String str2 = "com.google.ads.mediation.admob.AdMobAdapter";
        if (bundle != null) {
            bundle = bundle.getBundle(str2);
            if (bundle != null) {
                z = bundle.getBoolean("_skipMediation");
                if (z) {
                    listIterator = arrayList.listIterator();
                    while (listIterator.hasNext()) {
                        if (!((zzuh) listIterator.next()).f8048c.contains(str2)) {
                            listIterator.remove();
                        }
                    }
                }
                r1.f19240g = r1.f19242i.mo2165a(arrayList);
                switch (r1.f19240g.f8086a) {
                    case 0:
                        if (r1.f19240g.f8087b == null && r1.f19240g.f8087b.f8058m != null) {
                            CountDownLatch countDownLatch = new CountDownLatch(1);
                            zzahn.f6379a.post(new zzyh(r1, countDownLatch));
                            try {
                                countDownLatch.await(10, TimeUnit.SECONDS);
                                synchronized (r1.d) {
                                    try {
                                        if (!r1.f19246m) {
                                            throw new zzxz("View could not be prepared", 0);
                                        } else if (r1.f19245l.mo3965B()) {
                                            throw new zzxz("Assets not loaded, web view is destroyed", 0);
                                        }
                                    } catch (Throwable th) {
                                        Throwable th2 = th;
                                    }
                                }
                                return;
                            } catch (InterruptedException e) {
                                String valueOf = String.valueOf(e);
                                stringBuilder = new StringBuilder(38 + String.valueOf(valueOf).length());
                                stringBuilder.append("Interrupted while waiting for latch : ");
                                stringBuilder.append(valueOf);
                                throw new zzxz(stringBuilder.toString(), 0);
                            }
                        }
                        return;
                    case 1:
                        throw new zzxz("No fill from any mediation ad networks.", 3);
                    default:
                        int i = r1.f19240g.f8086a;
                        stringBuilder = new StringBuilder(40);
                        stringBuilder.append("Unexpected mediation result: ");
                        stringBuilder.append(i);
                        throw new zzxz(stringBuilder.toString(), 0);
                }
            }
        }
        z = false;
        if (z) {
            listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                if (!((zzuh) listIterator.next()).f8048c.contains(str2)) {
                    listIterator.remove();
                }
            }
        }
        r1.f19240g = r1.f19242i.mo2165a(arrayList);
        switch (r1.f19240g.f8086a) {
            case 0:
                if (r1.f19240g.f8087b == null) {
                    break;
                }
                return;
            case 1:
                throw new zzxz("No fill from any mediation ad networks.", 3);
            default:
                int i2 = r1.f19240g.f8086a;
                stringBuilder = new StringBuilder(40);
                stringBuilder.append("Unexpected mediation result: ");
                stringBuilder.append(i2);
                throw new zzxz(stringBuilder.toString(), 0);
        }
    }

    public final void mo3385b() {
        synchronized (this.d) {
            super.mo3385b();
            if (this.f19242i != null) {
                this.f19242i.mo2166a();
            }
        }
    }
}
