package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import java.util.List;

@zzzv
public final class zzoj extends zzqf implements zzov {
    private String f18194a;
    private List<zzoi> f18195b;
    private String f18196c;
    private zzpq f18197d;
    private String f18198e;
    private double f18199f;
    private String f18200g;
    private String f18201h;
    private zzog f18202i;
    private Bundle f18203j;
    private zzll f18204k;
    private View f18205l;
    private IObjectWrapper f18206m;
    private String f18207n;
    private Object f18208o = new Object();
    private zzos f18209p;

    public zzoj(String str, List<zzoi> list, String str2, zzpq com_google_android_gms_internal_zzpq, String str3, double d, String str4, String str5, zzog com_google_android_gms_internal_zzog, Bundle bundle, zzll com_google_android_gms_internal_zzll, View view, IObjectWrapper iObjectWrapper, String str6) {
        this.f18194a = str;
        this.f18195b = list;
        this.f18196c = str2;
        this.f18197d = com_google_android_gms_internal_zzpq;
        this.f18198e = str3;
        this.f18199f = d;
        this.f18200g = str4;
        this.f18201h = str5;
        this.f18202i = com_google_android_gms_internal_zzog;
        this.f18203j = bundle;
        this.f18204k = com_google_android_gms_internal_zzll;
        this.f18205l = view;
        this.f18206m = iObjectWrapper;
        this.f18207n = str6;
    }

    public final String mo2105a() {
        return this.f18194a;
    }

    public final void mo2106a(Bundle bundle) {
        synchronized (this.f18208o) {
            if (this.f18209p == null) {
                zzakb.m5368c("Attempt to perform click before app install ad initialized.");
                return;
            }
            this.f18209p.mo2079b(bundle);
        }
    }

    public final void mo3539a(zzos com_google_android_gms_internal_zzos) {
        synchronized (this.f18208o) {
            this.f18209p = com_google_android_gms_internal_zzos;
        }
    }

    public final List mo2107b() {
        return this.f18195b;
    }

    public final boolean mo2108b(Bundle bundle) {
        synchronized (this.f18208o) {
            if (this.f18209p == null) {
                zzakb.m5368c("Attempt to record impression before app install ad initialized.");
                return false;
            }
            boolean a = this.f18209p.mo2078a(bundle);
            return a;
        }
    }

    public final String mo2109c() {
        return this.f18196c;
    }

    public final void mo2110c(Bundle bundle) {
        synchronized (this.f18208o) {
            if (this.f18209p == null) {
                zzakb.m5368c("Attempt to perform click before app install ad initialized.");
                return;
            }
            this.f18209p.mo2083c(bundle);
        }
    }

    public final zzpq mo2111d() {
        return this.f18197d;
    }

    public final String mo2112e() {
        return this.f18198e;
    }

    public final double mo2113f() {
        return this.f18199f;
    }

    public final String mo2114g() {
        return this.f18200g;
    }

    public final String mo2115h() {
        return this.f18201h;
    }

    public final zzll mo2116i() {
        return this.f18204k;
    }

    public final IObjectWrapper mo2117j() {
        return zzn.m17692a(this.f18209p);
    }

    public final String mo3540k() {
        return "2";
    }

    public final String mo3541l() {
        return "";
    }

    public final zzog mo3542m() {
        return this.f18202i;
    }

    public final Bundle mo2118n() {
        return this.f18203j;
    }

    public final View mo3543o() {
        return this.f18205l;
    }

    public final IObjectWrapper mo2119p() {
        return this.f18206m;
    }

    public final String mo2120q() {
        return this.f18207n;
    }

    public final zzpm mo2121r() {
        return this.f18202i;
    }

    public final void mo2122s() {
        zzahn.f6379a.post(new zzok(this));
        this.f18194a = null;
        this.f18195b = null;
        this.f18196c = null;
        this.f18197d = null;
        this.f18198e = null;
        this.f18199f = 0.0d;
        this.f18200g = null;
        this.f18201h = null;
        this.f18202i = null;
        this.f18203j = null;
        this.f18208o = null;
        this.f18204k = null;
        this.f18205l = null;
    }
}
