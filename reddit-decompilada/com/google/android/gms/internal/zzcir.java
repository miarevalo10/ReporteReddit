package com.google.android.gms.internal;

import android.os.Binder;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzx;
import com.google.android.gms.common.zzp;
import com.google.android.gms.common.zzq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzcir extends zzchf {
    private final zzcim f17869a;
    private Boolean f17870b;
    private String f17871c;

    public zzcir(zzcim com_google_android_gms_internal_zzcim) {
        this(com_google_android_gms_internal_zzcim, (byte) 0);
    }

    private zzcir(zzcim com_google_android_gms_internal_zzcim, byte b) {
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcim);
        this.f17869a = com_google_android_gms_internal_zzcim;
        this.f17871c = null;
    }

    private final void m18299e(zzcgi com_google_android_gms_internal_zzcgi) {
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcgi);
        m18298a(com_google_android_gms_internal_zzcgi.f17759a, false);
        this.f17869a.m5758i().m18560e(com_google_android_gms_internal_zzcgi.f17760b);
    }

    public final void mo1836a(long j, String str, String str2, String str3) {
        this.f17869a.m5755f().m18271a(new zzcjj(this, str2, str3, str, j));
    }

    public final void mo1837a(zzcgi com_google_android_gms_internal_zzcgi) {
        m18299e(com_google_android_gms_internal_zzcgi);
        Runnable com_google_android_gms_internal_zzcji = new zzcji(this, com_google_android_gms_internal_zzcgi);
        if (this.f17869a.m5755f().m18296z()) {
            com_google_android_gms_internal_zzcji.run();
        } else {
            this.f17869a.m5755f().m18271a(com_google_android_gms_internal_zzcji);
        }
    }

    public final void mo1838a(zzcgl com_google_android_gms_internal_zzcgl) {
        zzcih f;
        Runnable com_google_android_gms_internal_zzciv;
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcgl);
        zzbq.m4808a(com_google_android_gms_internal_zzcgl.f17776c);
        m18298a(com_google_android_gms_internal_zzcgl.f17774a, true);
        zzcgl com_google_android_gms_internal_zzcgl2 = new zzcgl(com_google_android_gms_internal_zzcgl);
        if (com_google_android_gms_internal_zzcgl.f17776c.m18501a() == null) {
            f = this.f17869a.m5755f();
            com_google_android_gms_internal_zzciv = new zzciv(this, com_google_android_gms_internal_zzcgl2);
        } else {
            f = this.f17869a.m5755f();
            com_google_android_gms_internal_zzciv = new zzciw(this, com_google_android_gms_internal_zzcgl2);
        }
        f.m18271a(com_google_android_gms_internal_zzciv);
    }

    public final void mo1839a(zzcgl com_google_android_gms_internal_zzcgl, zzcgi com_google_android_gms_internal_zzcgi) {
        zzcih f;
        Runnable com_google_android_gms_internal_zzcit;
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcgl);
        zzbq.m4808a(com_google_android_gms_internal_zzcgl.f17776c);
        m18299e(com_google_android_gms_internal_zzcgi);
        zzcgl com_google_android_gms_internal_zzcgl2 = new zzcgl(com_google_android_gms_internal_zzcgl);
        com_google_android_gms_internal_zzcgl2.f17774a = com_google_android_gms_internal_zzcgi.f17759a;
        if (com_google_android_gms_internal_zzcgl.f17776c.m18501a() == null) {
            f = this.f17869a.m5755f();
            com_google_android_gms_internal_zzcit = new zzcit(this, com_google_android_gms_internal_zzcgl2, com_google_android_gms_internal_zzcgi);
        } else {
            f = this.f17869a.m5755f();
            com_google_android_gms_internal_zzcit = new zzciu(this, com_google_android_gms_internal_zzcgl2, com_google_android_gms_internal_zzcgi);
        }
        f.m18271a(com_google_android_gms_internal_zzcit);
    }

    public final void mo1840a(zzcha com_google_android_gms_internal_zzcha, zzcgi com_google_android_gms_internal_zzcgi) {
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcha);
        m18299e(com_google_android_gms_internal_zzcgi);
        this.f17869a.m5755f().m18271a(new zzcjc(this, com_google_android_gms_internal_zzcha, com_google_android_gms_internal_zzcgi));
    }

    public final void mo1841a(zzcha com_google_android_gms_internal_zzcha, String str, String str2) {
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcha);
        zzbq.m4810a(str);
        m18298a(str, true);
        this.f17869a.m5755f().m18271a(new zzcjd(this, com_google_android_gms_internal_zzcha, str));
    }

    public final void mo1842a(zzcln com_google_android_gms_internal_zzcln, zzcgi com_google_android_gms_internal_zzcgi) {
        zzcih f;
        Runnable com_google_android_gms_internal_zzcjf;
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcln);
        m18299e(com_google_android_gms_internal_zzcgi);
        if (com_google_android_gms_internal_zzcln.m18501a() == null) {
            f = this.f17869a.m5755f();
            com_google_android_gms_internal_zzcjf = new zzcjf(this, com_google_android_gms_internal_zzcln, com_google_android_gms_internal_zzcgi);
        } else {
            f = this.f17869a.m5755f();
            com_google_android_gms_internal_zzcjf = new zzcjg(this, com_google_android_gms_internal_zzcln, com_google_android_gms_internal_zzcgi);
        }
        f.m18271a(com_google_android_gms_internal_zzcjf);
    }

    public final void mo1844b(zzcgi com_google_android_gms_internal_zzcgi) {
        m18299e(com_google_android_gms_internal_zzcgi);
        this.f17869a.m5755f().m18271a(new zzcis(this, com_google_android_gms_internal_zzcgi));
    }

    public final String mo1845c(zzcgi com_google_android_gms_internal_zzcgi) {
        m18299e(com_google_android_gms_internal_zzcgi);
        return this.f17869a.m5735a(com_google_android_gms_internal_zzcgi.f17759a);
    }

    public final void mo1846d(zzcgi com_google_android_gms_internal_zzcgi) {
        m18298a(com_google_android_gms_internal_zzcgi.f17759a, false);
        this.f17869a.m5755f().m18271a(new zzcjb(this, com_google_android_gms_internal_zzcgi));
    }

    public final byte[] mo1843a(zzcha com_google_android_gms_internal_zzcha, String str) {
        zzbq.m4810a(str);
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcha);
        m18298a(str, true);
        this.f17869a.m5754e().f17821f.m5694a("Log and bundle. event", this.f17869a.m5759j().m18128a(com_google_android_gms_internal_zzcha.f17798a));
        long c = this.f17869a.f6982i.mo1634c() / 1000000;
        try {
            byte[] bArr = (byte[]) this.f17869a.m5755f().m18272b(new zzcje(this, com_google_android_gms_internal_zzcha, str)).get();
            if (bArr == null) {
                this.f17869a.m5754e().f17816a.m5694a("Log and bundle returned null. appId", zzchm.m18154a(str));
                bArr = new byte[0];
            }
            this.f17869a.m5754e().f17821f.m5696a("Log and bundle processed. event, size, time_ms", this.f17869a.m5759j().m18128a(com_google_android_gms_internal_zzcha.f17798a), Integer.valueOf(bArr.length), Long.valueOf((this.f17869a.f6982i.mo1634c() / 1000000) - c));
            return bArr;
        } catch (InterruptedException e) {
            this.f17869a.m5754e().f17816a.m5696a("Failed to log and bundle. appId, event, error", zzchm.m18154a(str), this.f17869a.m5759j().m18128a(com_google_android_gms_internal_zzcha.f17798a), e);
            return null;
        }
    }

    public final List<zzcln> mo1831a(zzcgi com_google_android_gms_internal_zzcgi, boolean z) {
        m18299e(com_google_android_gms_internal_zzcgi);
        try {
            List<zzclp> list = (List) this.f17869a.m5755f().m18269a(new zzcjh(this, com_google_android_gms_internal_zzcgi)).get();
            List<zzcln> arrayList = new ArrayList(list.size());
            for (zzclp com_google_android_gms_internal_zzclp : list) {
                if (z || !zzclq.m18527h(com_google_android_gms_internal_zzclp.f7177c)) {
                    arrayList.add(new zzcln(com_google_android_gms_internal_zzclp));
                }
            }
            return arrayList;
        } catch (boolean z2) {
            this.f17869a.m5754e().f17816a.m5695a("Failed to get user attributes. appId", zzchm.m18154a(com_google_android_gms_internal_zzcgi.f17759a), z2);
            return null;
        }
    }

    private final void m18298a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            this.f17869a.m5754e().f17816a.m5693a("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z) {
            try {
                if (!this.f17870b) {
                    if (!("com.google.android.gms".equals(this.f17871c) || zzx.m4925a(this.f17869a.f6974a, Binder.getCallingUid()))) {
                        if (!zzq.m4945a(this.f17869a.f6974a).m4949a(Binder.getCallingUid())) {
                            z = false;
                            this.f17870b = Boolean.valueOf(z);
                        }
                    }
                    z = true;
                    this.f17870b = Boolean.valueOf(z);
                }
                if (this.f17870b.booleanValue()) {
                    return;
                }
            } catch (boolean z2) {
                this.f17869a.m5754e().f17816a.m5694a("Measurement Service called with invalid calling package. appId", zzchm.m18154a(str));
                throw z2;
            }
        }
        if (!this.f17871c && zzp.zzb(this.f17869a.f6974a, Binder.getCallingUid(), str)) {
            this.f17871c = str;
        }
        if (!str.equals(this.f17871c)) {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
        }
    }

    public final List<zzcln> mo1835a(String str, String str2, boolean z, zzcgi com_google_android_gms_internal_zzcgi) {
        m18299e(com_google_android_gms_internal_zzcgi);
        try {
            List<zzclp> list = (List) this.f17869a.m5755f().m18269a(new zzcix(this, com_google_android_gms_internal_zzcgi, str, str2)).get();
            str2 = new ArrayList(list.size());
            for (zzclp com_google_android_gms_internal_zzclp : list) {
                if (z || !zzclq.m18527h(com_google_android_gms_internal_zzclp.f7177c)) {
                    str2.add(new zzcln(com_google_android_gms_internal_zzclp));
                }
            }
            return str2;
        } catch (String str3) {
            this.f17869a.m5754e().f17816a.m5695a("Failed to get user attributes. appId", zzchm.m18154a(com_google_android_gms_internal_zzcgi.f17759a), str3);
            return Collections.emptyList();
        }
    }

    public final List<zzcln> mo1834a(String str, String str2, String str3, boolean z) {
        m18298a(str, true);
        try {
            List<zzclp> list = (List) this.f17869a.m5755f().m18269a(new zzciy(this, str, str2, str3)).get();
            str3 = new ArrayList(list.size());
            for (zzclp com_google_android_gms_internal_zzclp : list) {
                if (z || !zzclq.m18527h(com_google_android_gms_internal_zzclp.f7177c)) {
                    str3.add(new zzcln(com_google_android_gms_internal_zzclp));
                }
            }
            return str3;
        } catch (String str22) {
            this.f17869a.m5754e().f17816a.m5695a("Failed to get user attributes. appId", zzchm.m18154a(str), str22);
            return Collections.emptyList();
        }
    }

    public final List<zzcgl> mo1832a(String str, String str2, zzcgi com_google_android_gms_internal_zzcgi) {
        m18299e(com_google_android_gms_internal_zzcgi);
        try {
            return (List) this.f17869a.m5755f().m18269a(new zzciz(this, com_google_android_gms_internal_zzcgi, str, str2)).get();
        } catch (String str3) {
            this.f17869a.m5754e().f17816a.m5694a("Failed to get conditional user properties", str3);
            return Collections.emptyList();
        }
    }

    public final List<zzcgl> mo1833a(String str, String str2, String str3) {
        m18298a(str, true);
        try {
            return (List) this.f17869a.m5755f().m18269a(new zzcja(this, str, str2, str3)).get();
        } catch (String str4) {
            this.f17869a.m5754e().f17816a.m5694a("Failed to get conditional user properties", str4);
            return Collections.emptyList();
        }
    }
}
