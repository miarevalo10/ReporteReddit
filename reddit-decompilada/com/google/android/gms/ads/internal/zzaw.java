package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzaig;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzlh;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zzzv;

@zzzv
public final class zzaw extends zzlh {
    private static final Object f17179b = new Object();
    private static zzaw f17180c;
    private final Context f17181a;
    private final Object f17182d = new Object();
    private boolean f17183e;
    private zzakd f17184f;

    private zzaw(Context context, zzakd com_google_android_gms_internal_zzakd) {
        this.f17181a = context;
        this.f17184f = com_google_android_gms_internal_zzakd;
        this.f17183e = false;
    }

    public static zzaw m17506a(Context context, zzakd com_google_android_gms_internal_zzakd) {
        zzaw com_google_android_gms_ads_internal_zzaw;
        synchronized (f17179b) {
            if (f17180c == null) {
                f17180c = new zzaw(context.getApplicationContext(), com_google_android_gms_internal_zzakd);
            }
            com_google_android_gms_ads_internal_zzaw = f17180c;
        }
        return com_google_android_gms_ads_internal_zzaw;
    }

    public final void mo2030a() {
        synchronized (f17179b) {
            if (this.f17183e) {
                zzakb.m5371e("Mobile ads is initialized already.");
                return;
            }
            this.f17183e = true;
            zznh.m6490a(this.f17181a);
            zzbs.m4490i().m13243a(this.f17181a, this.f17184f);
            zzbs.m4491j().m6319a(this.f17181a);
        }
    }

    public final void mo2031a(float f) {
        zzbs.m4479B().m5259a(f);
    }

    public final void mo2033a(String str) {
        zznh.m6490a(this.f17181a);
        if (!TextUtils.isEmpty(str)) {
            if (((Boolean) zzkb.m6350f().m6488a(zznh.cc)).booleanValue()) {
                zzbs.m4493l().m4457a(this.f17181a, this.f17184f, str, null);
            }
        }
    }

    public final void mo2034a(String str, IObjectWrapper iObjectWrapper) {
        if (!TextUtils.isEmpty(str)) {
            zznh.m6490a(this.f17181a);
            int booleanValue = ((Boolean) zzkb.m6350f().m6488a(zznh.cc)).booleanValue() | ((Boolean) zzkb.m6350f().m6488a(zznh.as)).booleanValue();
            Runnable runnable = null;
            if (((Boolean) zzkb.m6350f().m6488a(zznh.as)).booleanValue()) {
                booleanValue = 1;
                runnable = new zzax(this, (Runnable) zzn.m17693a(iObjectWrapper));
            }
            if (booleanValue != 0) {
                zzbs.m4493l().m4457a(this.f17181a, this.f17184f, str, runnable);
            }
        }
    }

    public final void mo2035a(boolean z) {
        zzbs.m4479B().m5260a(z);
    }

    public final float mo2036b() {
        return zzbs.m4479B().m5258a();
    }

    public final boolean mo2037c() {
        return zzbs.m4479B().m5261b();
    }

    public final void mo2032a(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            iObjectWrapper = "Wrapped context is null. Failed to open debug menu.";
        } else {
            Context context = (Context) zzn.m17693a(iObjectWrapper);
            if (context == null) {
                iObjectWrapper = "Context is null. Failed to open debug menu.";
            } else {
                zzaig com_google_android_gms_internal_zzaig = new zzaig(context);
                com_google_android_gms_internal_zzaig.f6395b = str;
                com_google_android_gms_internal_zzaig.f6396c = this.f17184f.f17551a;
                com_google_android_gms_internal_zzaig.m5274a();
                return;
            }
        }
        zzakb.m5368c(iObjectWrapper);
    }
}
