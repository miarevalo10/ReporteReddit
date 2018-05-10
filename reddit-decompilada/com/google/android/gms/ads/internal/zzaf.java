package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.zzahh;
import com.google.android.gms.internal.zzajr;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzcr;
import com.google.android.gms.internal.zzcu;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zzzv;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@zzzv
public final class zzaf implements zzcr, Runnable {
    private final List<Object[]> f13762a;
    private final AtomicReference<zzcr> f13763b;
    private Context f13764c;
    private zzakd f13765d;
    private CountDownLatch f13766e;

    private zzaf(Context context, zzakd com_google_android_gms_internal_zzakd) {
        this.f13762a = new Vector();
        this.f13763b = new AtomicReference();
        this.f13766e = new CountDownLatch(1);
        this.f13764c = context;
        this.f13765d = com_google_android_gms_internal_zzakd;
        zzkb.m6345a();
        if (zzajr.m5332b()) {
            zzahh.m5148a((Runnable) this);
        } else {
            run();
        }
    }

    public zzaf(zzbt com_google_android_gms_ads_internal_zzbt) {
        this(com_google_android_gms_ads_internal_zzbt.f5600c, com_google_android_gms_ads_internal_zzbt.f5602e);
    }

    private final boolean m12765a() {
        try {
            this.f13766e.await();
            return true;
        } catch (Throwable e) {
            zzakb.m5369c("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    private static Context m12766b(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    private final void m12767b() {
        if (!this.f13762a.isEmpty()) {
            for (Object[] objArr : this.f13762a) {
                if (objArr.length == 1) {
                    ((zzcr) this.f13763b.get()).mo1521a((MotionEvent) objArr[0]);
                } else if (objArr.length == 3) {
                    ((zzcr) this.f13763b.get()).mo1520a(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                }
            }
            this.f13762a.clear();
        }
    }

    public final String mo1517a(Context context) {
        if (m12765a()) {
            zzcr com_google_android_gms_internal_zzcr = (zzcr) this.f13763b.get();
            if (com_google_android_gms_internal_zzcr != null) {
                m12767b();
                return com_google_android_gms_internal_zzcr.mo1517a(m12766b(context));
            }
        }
        return "";
    }

    public final String mo1518a(Context context, String str, View view) {
        return mo1519a(context, str, view, null);
    }

    public final String mo1519a(Context context, String str, View view, Activity activity) {
        if (m12765a()) {
            zzcr com_google_android_gms_internal_zzcr = (zzcr) this.f13763b.get();
            if (com_google_android_gms_internal_zzcr != null) {
                m12767b();
                return com_google_android_gms_internal_zzcr.mo1519a(m12766b(context), str, view, activity);
            }
        }
        return "";
    }

    public final void mo1520a(int i, int i2, int i3) {
        zzcr com_google_android_gms_internal_zzcr = (zzcr) this.f13763b.get();
        if (com_google_android_gms_internal_zzcr != null) {
            m12767b();
            com_google_android_gms_internal_zzcr.mo1520a(i, i2, i3);
            return;
        }
        this.f13762a.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public final void mo1521a(MotionEvent motionEvent) {
        zzcr com_google_android_gms_internal_zzcr = (zzcr) this.f13763b.get();
        if (com_google_android_gms_internal_zzcr != null) {
            m12767b();
            com_google_android_gms_internal_zzcr.mo1521a(motionEvent);
            return;
        }
        this.f13762a.add(new Object[]{motionEvent});
    }

    public final void mo1522a(View view) {
        zzcr com_google_android_gms_internal_zzcr = (zzcr) this.f13763b.get();
        if (com_google_android_gms_internal_zzcr != null) {
            com_google_android_gms_internal_zzcr.mo1522a(view);
        }
    }

    public final void run() {
        boolean z = false;
        try {
            boolean z2 = this.f13765d.f17554d;
            if (!((Boolean) zzkb.m6350f().m6488a(zznh.az)).booleanValue() && z2) {
                z = true;
            }
            this.f13763b.set(zzcu.m20407a(this.f13765d.f17551a, m12766b(this.f13764c), z));
        } finally {
            this.f13766e.countDown();
            this.f13764c = null;
            this.f13765d = null;
        }
    }
}
