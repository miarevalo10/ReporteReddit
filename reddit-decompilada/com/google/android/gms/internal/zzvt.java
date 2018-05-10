package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import java.util.ArrayList;
import java.util.List;

@zzzv
public final class zzvt extends zzvk {
    private final NativeAppInstallAdMapper f18318a;

    public zzvt(NativeAppInstallAdMapper nativeAppInstallAdMapper) {
        this.f18318a = nativeAppInstallAdMapper;
    }

    public final void mo2209a(IObjectWrapper iObjectWrapper) {
        zzn.m17693a(iObjectWrapper);
    }

    public final void mo2211b(IObjectWrapper iObjectWrapper) {
        this.f18318a.mo3302a((View) zzn.m17693a(iObjectWrapper));
    }

    public final void mo2213c(IObjectWrapper iObjectWrapper) {
        zzn.m17693a(iObjectWrapper);
    }

    public final void mo2219i() {
    }

    public final boolean mo2220j() {
        return this.f18318a.m4546c();
    }

    public final boolean mo2221k() {
        return this.f18318a.m4547d();
    }

    public final Bundle mo2222l() {
        return this.f18318a.m4548e();
    }

    public final IObjectWrapper mo2224n() {
        Object f = this.f18318a.m4549f();
        return f == null ? null : zzn.m17692a(f);
    }

    public final zzpm mo2225o() {
        return null;
    }

    public final IObjectWrapper mo2227q() {
        return null;
    }

    public final String mo2208a() {
        return this.f18318a.f13784h;
    }

    public final List mo2210b() {
        List<Image> list = this.f18318a.f13785i;
        if (list == null) {
            return null;
        }
        List arrayList = new ArrayList();
        for (Image image : list) {
            arrayList.add(new zzoi(image.mo2094a(), image.mo2095b(), image.mo2096c()));
        }
        return arrayList;
    }

    public final String mo2212c() {
        return this.f18318a.f13786j;
    }

    public final zzpq mo2214d() {
        Image image = this.f18318a.f13787k;
        return image != null ? new zzoi(image.mo2094a(), image.mo2095b(), image.mo2096c()) : null;
    }

    public final String mo2215e() {
        return this.f18318a.f13788l;
    }

    public final double mo2216f() {
        return this.f18318a.f13789m;
    }

    public final String mo2217g() {
        return this.f18318a.f13790n;
    }

    public final String mo2218h() {
        return this.f18318a.f13791o;
    }

    public final zzll mo2223m() {
        return this.f18318a.f5664f != null ? this.f18318a.f5664f.m4382a() : null;
    }

    public final IObjectWrapper mo2226p() {
        Object obj = this.f18318a.f5663e;
        return obj == null ? null : zzn.m17692a(obj);
    }
}
