package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

@zzzv
public final class zzair {
    final double[] f6422a;
    final double[] f6423b;
    final int[] f6424c;
    int f6425d;
    private final String[] f6426e;

    private zzair(zzaiu com_google_android_gms_internal_zzaiu) {
        int size = com_google_android_gms_internal_zzaiu.f6433b.size();
        this.f6426e = (String[]) com_google_android_gms_internal_zzaiu.f6432a.toArray(new String[size]);
        this.f6422a = m5287a(com_google_android_gms_internal_zzaiu.f6433b);
        this.f6423b = m5287a(com_google_android_gms_internal_zzaiu.f6434c);
        this.f6424c = new int[size];
        this.f6425d = 0;
    }

    private static double[] m5287a(List<Double> list) {
        double[] dArr = new double[list.size()];
        for (int i = 0; i < dArr.length; i++) {
            dArr[i] = ((Double) list.get(i)).doubleValue();
        }
        return dArr;
    }

    public final List<zzait> m5288a() {
        List<zzait> arrayList = new ArrayList(this.f6426e.length);
        for (int i = 0; i < this.f6426e.length; i++) {
            arrayList.add(new zzait(this.f6426e[i], this.f6423b[i], this.f6422a[i], ((double) this.f6424c[i]) / ((double) this.f6425d), this.f6424c[i]));
        }
        return arrayList;
    }
}
