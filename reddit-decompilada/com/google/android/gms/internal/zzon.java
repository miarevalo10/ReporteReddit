package com.google.android.gms.internal;

import android.support.v4.util.SimpleArrayMap;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import java.util.Arrays;
import java.util.List;

@zzzv
public final class zzon extends zzqn implements zzou {
    private final zzog f18224a;
    private final String f18225b;
    private final SimpleArrayMap<String, zzoi> f18226c;
    private final SimpleArrayMap<String, String> f18227d;
    private zzll f18228e;
    private View f18229f;
    private final Object f18230g = new Object();
    private zzos f18231h;

    public zzon(String str, SimpleArrayMap<String, zzoi> simpleArrayMap, SimpleArrayMap<String, String> simpleArrayMap2, zzog com_google_android_gms_internal_zzog, zzll com_google_android_gms_internal_zzll, View view) {
        this.f18225b = str;
        this.f18226c = simpleArrayMap;
        this.f18227d = simpleArrayMap2;
        this.f18224a = com_google_android_gms_internal_zzog;
        this.f18228e = com_google_android_gms_internal_zzll;
        this.f18229f = view;
    }

    public final String mo2139a(String str) {
        return (String) this.f18227d.get(str);
    }

    public final List<String> mo2140a() {
        String[] strArr = new String[(this.f18226c.size() + this.f18227d.size())];
        int i = 0;
        int i2 = 0;
        int i3 = i2;
        while (i2 < this.f18226c.size()) {
            strArr[i3] = (String) this.f18226c.m1053b(i2);
            i2++;
            i3++;
        }
        while (i < this.f18227d.size()) {
            strArr[i3] = (String) this.f18227d.m1053b(i);
            i++;
            i3++;
        }
        return Arrays.asList(strArr);
    }

    public final void mo3539a(zzos com_google_android_gms_internal_zzos) {
        synchronized (this.f18230g) {
            this.f18231h = com_google_android_gms_internal_zzos;
        }
    }

    public final boolean mo2141a(IObjectWrapper iObjectWrapper) {
        if (this.f18231h == null) {
            zzakb.m5368c("Attempt to call renderVideoInMediaView before ad initialized.");
            return false;
        } else if (this.f18229f == null) {
            return false;
        } else {
            View view = (FrameLayout) zzn.m17693a(iObjectWrapper);
            this.f18231h.mo2073a(view, new zzoo(this));
            return true;
        }
    }

    public final IObjectWrapper mo2142b() {
        return zzn.m17692a(this.f18231h);
    }

    public final zzpq mo2143b(String str) {
        return (zzpq) this.f18226c.get(str);
    }

    public final zzll mo2144c() {
        return this.f18228e;
    }

    public final void mo2145c(String str) {
        synchronized (this.f18230g) {
            if (this.f18231h == null) {
                zzakb.m5368c("Attempt to call performClick before ad initialized.");
                return;
            }
            this.f18231h.mo2074a(null, str, null, null, null);
        }
    }

    public final void mo2146d() {
        synchronized (this.f18230g) {
            if (this.f18231h == null) {
                zzakb.m5368c("Attempt to perform recordImpression before ad initialized.");
                return;
            }
            this.f18231h.mo2075a(null, null);
        }
    }

    public final IObjectWrapper mo2147e() {
        return zzn.m17692a(this.f18231h.mo2088i().getApplicationContext());
    }

    public final void mo2148f() {
        zzahn.f6379a.post(new zzop(this));
        this.f18228e = null;
        this.f18229f = null;
    }

    public final String mo3540k() {
        return "3";
    }

    public final String mo3541l() {
        return this.f18225b;
    }

    public final zzog mo3542m() {
        return this.f18224a;
    }

    public final View mo3543o() {
        return this.f18229f;
    }
}
