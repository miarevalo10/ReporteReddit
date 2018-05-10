package com.google.android.gms.ads.internal;

import android.os.Build.VERSION;
import com.google.android.gms.ads.internal.js.zzb;
import com.google.android.gms.ads.internal.overlay.zza;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzr;
import com.google.android.gms.ads.internal.overlay.zzs;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.internal.zzacq;
import com.google.android.gms.internal.zzaff;
import com.google.android.gms.internal.zzaft;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzaht;
import com.google.android.gms.internal.zzahy;
import com.google.android.gms.internal.zzahz;
import com.google.android.gms.internal.zzaia;
import com.google.android.gms.internal.zzaib;
import com.google.android.gms.internal.zzaic;
import com.google.android.gms.internal.zzaid;
import com.google.android.gms.internal.zzaie;
import com.google.android.gms.internal.zzaim;
import com.google.android.gms.internal.zzajf;
import com.google.android.gms.internal.zzajg;
import com.google.android.gms.internal.zzajn;
import com.google.android.gms.internal.zzalg;
import com.google.android.gms.internal.zzaln;
import com.google.android.gms.internal.zzamz;
import com.google.android.gms.internal.zzanr;
import com.google.android.gms.internal.zzhg;
import com.google.android.gms.internal.zzic;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zznm;
import com.google.android.gms.internal.zztg;
import com.google.android.gms.internal.zztq;
import com.google.android.gms.internal.zzuq;
import com.google.android.gms.internal.zzya;
import com.google.android.gms.internal.zzzv;
import com.google.android.gms.internal.zzzw;

@zzzv
public final class zzbs {
    private static final Object f5550a = new Object();
    private static zzbs f5551b;
    private final zzaz f5552A;
    private final zzir f5553B;
    private final zzaff f5554C;
    private final zzamz f5555D;
    private final zzaln f5556E;
    private final zzb f5557F;
    private final zzaie f5558G;
    private final zzajn f5559H;
    private final zza f5560c = new zza();
    private final zzzw f5561d = new zzzw();
    private final zzl f5562e = new zzl();
    private final zzya f5563f = new zzya();
    private final zzahn f5564g = new zzahn();
    private final zzanr f5565h = new zzanr();
    private final zzaht f5566i;
    private final zzhg f5567j;
    private final zzaft f5568k;
    private final zzic f5569l;
    private final zzid f5570m;
    private final zzd f5571n;
    private final zzac f5572o;
    private final zznm f5573p;
    private final zzaim f5574q;
    private final zzacq f5575r;
    private final zzalg f5576s;
    private final zztg f5577t;
    private final zztq f5578u;
    private final zzajf f5579v;
    private final zzr f5580w;
    private final zzs f5581x;
    private final zzuq f5582y;
    private final zzajg f5583z;

    static {
        zzbs com_google_android_gms_ads_internal_zzbs = new zzbs();
        synchronized (f5550a) {
            f5551b = com_google_android_gms_ads_internal_zzbs;
        }
    }

    protected zzbs() {
        int i = VERSION.SDK_INT;
        zzaht com_google_android_gms_internal_zzaid = i >= 21 ? new zzaid() : i >= 19 ? new zzaic() : i >= 18 ? new zzaia() : i >= 17 ? new zzahz() : i >= 16 ? new zzaib() : new zzahy();
        this.f5566i = com_google_android_gms_internal_zzaid;
        this.f5567j = new zzhg();
        this.f5568k = new zzaft();
        this.f5569l = new zzic();
        this.f5570m = new zzid();
        this.f5571n = zzh.m13111d();
        this.f5572o = new zzac();
        this.f5573p = new zznm();
        this.f5574q = new zzaim();
        this.f5575r = new zzacq();
        this.f5557F = new zzb();
        this.f5576s = new zzalg();
        this.f5577t = new zztg();
        this.f5578u = new zztq();
        this.f5579v = new zzajf();
        this.f5580w = new zzr();
        this.f5581x = new zzs();
        this.f5582y = new zzuq();
        this.f5583z = new zzajg();
        this.f5552A = new zzaz();
        this.f5553B = new zzir();
        this.f5554C = new zzaff();
        this.f5555D = new zzamz();
        this.f5556E = new zzaln();
        this.f5558G = new zzaie();
        this.f5559H = new zzajn();
    }

    public static zzb m4478A() {
        return m4481D().f5557F;
    }

    public static zzaie m4479B() {
        return m4481D().f5558G;
    }

    public static zzajn m4480C() {
        return m4481D().f5559H;
    }

    private static zzbs m4481D() {
        zzbs com_google_android_gms_ads_internal_zzbs;
        synchronized (f5550a) {
            com_google_android_gms_ads_internal_zzbs = f5551b;
        }
        return com_google_android_gms_ads_internal_zzbs;
    }

    public static zzzw m4482a() {
        return m4481D().f5561d;
    }

    public static zza m4483b() {
        return m4481D().f5560c;
    }

    public static zzl m4484c() {
        return m4481D().f5562e;
    }

    public static zzya m4485d() {
        return m4481D().f5563f;
    }

    public static zzahn m4486e() {
        return m4481D().f5564g;
    }

    public static zzanr m4487f() {
        return m4481D().f5565h;
    }

    public static zzaht m4488g() {
        return m4481D().f5566i;
    }

    public static zzhg m4489h() {
        return m4481D().f5567j;
    }

    public static zzaft m4490i() {
        return m4481D().f5568k;
    }

    public static zzid m4491j() {
        return m4481D().f5570m;
    }

    public static zzd m4492k() {
        return m4481D().f5571n;
    }

    public static zzac m4493l() {
        return m4481D().f5572o;
    }

    public static zznm m4494m() {
        return m4481D().f5573p;
    }

    public static zzaim m4495n() {
        return m4481D().f5574q;
    }

    public static zzacq m4496o() {
        return m4481D().f5575r;
    }

    public static zzalg m4497p() {
        return m4481D().f5576s;
    }

    public static zztg m4498q() {
        return m4481D().f5577t;
    }

    public static zztq m4499r() {
        return m4481D().f5578u;
    }

    public static zzajf m4500s() {
        return m4481D().f5579v;
    }

    public static zzr m4501t() {
        return m4481D().f5580w;
    }

    public static zzs m4502u() {
        return m4481D().f5581x;
    }

    public static zzuq m4503v() {
        return m4481D().f5582y;
    }

    public static zzajg m4504w() {
        return m4481D().f5583z;
    }

    public static zzamz m4505x() {
        return m4481D().f5555D;
    }

    public static zzaln m4506y() {
        return m4481D().f5556E;
    }

    public static zzaff m4507z() {
        return m4481D().f5554C;
    }
}
