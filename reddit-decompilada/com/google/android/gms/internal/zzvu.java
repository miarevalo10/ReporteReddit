package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import java.util.ArrayList;
import java.util.List;

@zzzv
public final class zzvu extends zzvn {
    private final NativeContentAdMapper f18319a;

    public zzvu(NativeContentAdMapper nativeContentAdMapper) {
        this.f18319a = nativeContentAdMapper;
    }

    public final void mo2229a(IObjectWrapper iObjectWrapper) {
        zzn.m17693a(iObjectWrapper);
    }

    public final void mo2231b(IObjectWrapper iObjectWrapper) {
        this.f18319a.mo3302a((View) zzn.m17693a(iObjectWrapper));
    }

    public final void mo2233c(IObjectWrapper iObjectWrapper) {
        zzn.m17693a(iObjectWrapper);
    }

    public final void mo2237g() {
    }

    public final boolean mo2238h() {
        return this.f18319a.m4546c();
    }

    public final boolean mo2239i() {
        return this.f18319a.m4547d();
    }

    public final Bundle mo2240j() {
        return this.f18319a.m4548e();
    }

    public final IObjectWrapper mo2241k() {
        Object f = this.f18319a.m4549f();
        return f == null ? null : zzn.m17692a(f);
    }

    public final zzpm mo2243m() {
        return null;
    }

    public final IObjectWrapper mo2245o() {
        return null;
    }

    public final String mo2228a() {
        return this.f18319a.f13792h;
    }

    public final List mo2230b() {
        List<Image> list = this.f18319a.f13793i;
        if (list == null) {
            return null;
        }
        List arrayList = new ArrayList();
        for (Image image : list) {
            arrayList.add(new zzoi(image.mo2094a(), image.mo2095b(), image.mo2096c()));
        }
        return arrayList;
    }

    public final String mo2232c() {
        return this.f18319a.f13794j;
    }

    public final zzpq mo2234d() {
        Image image = this.f18319a.f13795k;
        return image != null ? new zzoi(image.mo2094a(), image.mo2095b(), image.mo2096c()) : null;
    }

    public final String mo2235e() {
        return this.f18319a.f13796l;
    }

    public final String mo2236f() {
        return this.f18319a.f13797m;
    }

    public final zzll mo2242l() {
        return this.f18319a.f5664f != null ? this.f18319a.f5664f.m4382a() : null;
    }

    public final IObjectWrapper mo2244n() {
        Object obj = this.f18319a.f5663e;
        return obj == null ? null : zzn.m17692a(obj);
    }
}
