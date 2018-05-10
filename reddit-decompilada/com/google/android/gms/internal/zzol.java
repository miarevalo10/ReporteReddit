package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import java.util.List;

@zzzv
public final class zzol extends zzqj implements zzov {
    private String f18210a;
    private List<zzoi> f18211b;
    private String f18212c;
    private zzpq f18213d;
    private String f18214e;
    private String f18215f;
    private zzog f18216g;
    private Bundle f18217h;
    private zzll f18218i;
    private View f18219j;
    private IObjectWrapper f18220k;
    private String f18221l;
    private Object f18222m = new Object();
    private zzos f18223n;

    public zzol(String str, List<zzoi> list, String str2, zzpq com_google_android_gms_internal_zzpq, String str3, String str4, zzog com_google_android_gms_internal_zzog, Bundle bundle, zzll com_google_android_gms_internal_zzll, View view, IObjectWrapper iObjectWrapper, String str5) {
        this.f18210a = str;
        this.f18211b = list;
        this.f18212c = str2;
        this.f18213d = com_google_android_gms_internal_zzpq;
        this.f18214e = str3;
        this.f18215f = str4;
        this.f18216g = com_google_android_gms_internal_zzog;
        this.f18217h = bundle;
        this.f18218i = com_google_android_gms_internal_zzll;
        this.f18219j = view;
        this.f18220k = iObjectWrapper;
        this.f18221l = str5;
    }

    public final String mo2123a() {
        return this.f18210a;
    }

    public final void mo2124a(Bundle bundle) {
        synchronized (this.f18222m) {
            if (this.f18223n == null) {
                zzakb.m5368c("Attempt to perform click before content ad initialized.");
                return;
            }
            this.f18223n.mo2079b(bundle);
        }
    }

    public final void mo3539a(zzos com_google_android_gms_internal_zzos) {
        synchronized (this.f18222m) {
            this.f18223n = com_google_android_gms_internal_zzos;
        }
    }

    public final List mo2125b() {
        return this.f18211b;
    }

    public final boolean mo2126b(Bundle bundle) {
        synchronized (this.f18222m) {
            if (this.f18223n == null) {
                zzakb.m5368c("Attempt to record impression before content ad initialized.");
                return false;
            }
            boolean a = this.f18223n.mo2078a(bundle);
            return a;
        }
    }

    public final IObjectWrapper mo2127c() {
        return this.f18220k;
    }

    public final void mo2128c(Bundle bundle) {
        synchronized (this.f18222m) {
            if (this.f18223n == null) {
                zzakb.m5368c("Attempt to perform click before app install ad initialized.");
                return;
            }
            this.f18223n.mo2083c(bundle);
        }
    }

    public final String mo2129d() {
        return this.f18221l;
    }

    public final String mo2130e() {
        return this.f18212c;
    }

    public final zzpq mo2131f() {
        return this.f18213d;
    }

    public final String mo2132g() {
        return this.f18214e;
    }

    public final String mo2133h() {
        return this.f18215f;
    }

    public final zzll mo2134i() {
        return this.f18218i;
    }

    public final IObjectWrapper mo2135j() {
        return zzn.m17692a(this.f18223n);
    }

    public final String mo3540k() {
        return "1";
    }

    public final String mo3541l() {
        return "";
    }

    public final zzog mo3542m() {
        return this.f18216g;
    }

    public final Bundle mo2136n() {
        return this.f18217h;
    }

    public final View mo3543o() {
        return this.f18219j;
    }

    public final zzpm mo2137p() {
        return this.f18216g;
    }

    public final void mo2138q() {
        zzahn.f6379a.post(new zzom(this));
        this.f18210a = null;
        this.f18211b = null;
        this.f18212c = null;
        this.f18213d = null;
        this.f18214e = null;
        this.f18215f = null;
        this.f18216g = null;
        this.f18217h = null;
        this.f18222m = null;
        this.f18218i = null;
        this.f18219j = null;
    }
}
