package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.zzbs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@zzzv
public final class zzafq {
    public final zzaft f6324a;
    public final LinkedList<zzafr> f6325b;
    public final Object f6326c;
    public long f6327d;
    public long f6328e;
    public boolean f6329f;
    public long f6330g;
    public long f6331h;
    public long f6332i;
    public long f6333j;
    private final String f6334k;
    private final String f6335l;

    private zzafq(zzaft com_google_android_gms_internal_zzaft, String str, String str2) {
        this.f6326c = new Object();
        this.f6327d = -1;
        this.f6328e = -1;
        this.f6329f = false;
        this.f6330g = -1;
        this.f6331h = 0;
        this.f6332i = -1;
        this.f6333j = -1;
        this.f6324a = com_google_android_gms_internal_zzaft;
        this.f6334k = str;
        this.f6335l = str2;
        this.f6325b = new LinkedList();
    }

    public zzafq(String str, String str2) {
        this(zzbs.m4490i(), str, str2);
    }

    public final Bundle m5111a() {
        Bundle bundle;
        synchronized (this.f6326c) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.f6334k);
            bundle.putString("slotid", this.f6335l);
            bundle.putBoolean("ismediation", this.f6329f);
            bundle.putLong("treq", this.f6332i);
            bundle.putLong("tresponse", this.f6333j);
            bundle.putLong("timp", this.f6328e);
            bundle.putLong("tload", this.f6330g);
            bundle.putLong("pcc", this.f6331h);
            bundle.putLong("tfetch", this.f6327d);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f6325b.iterator();
            while (it.hasNext()) {
                zzafr com_google_android_gms_internal_zzafr = (zzafr) it.next();
                Bundle bundle2 = new Bundle();
                bundle2.putLong("topen", com_google_android_gms_internal_zzafr.f6336a);
                bundle2.putLong("tclose", com_google_android_gms_internal_zzafr.f6337b);
                arrayList.add(bundle2);
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }
}
