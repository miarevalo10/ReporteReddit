package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.internal.zzbq;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

@zzzv
public abstract class zzxu implements zzaif<Void>, zzanm {
    protected final Context f14741a;
    protected final zzanh f14742b;
    protected zzaax f14743c;
    private zzyb f14744d;
    private zzafp f14745e;
    private Runnable f14746f;
    private Object f14747g = new Object();
    private AtomicBoolean f14748h = new AtomicBoolean(true);

    protected zzxu(Context context, zzafp com_google_android_gms_internal_zzafp, zzanh com_google_android_gms_internal_zzanh, zzyb com_google_android_gms_internal_zzyb) {
        this.f14741a = context;
        this.f14745e = com_google_android_gms_internal_zzafp;
        this.f14743c = this.f14745e.f6315b;
        this.f14742b = com_google_android_gms_internal_zzanh;
        this.f14744d = com_google_android_gms_internal_zzyb;
    }

    protected abstract void mo3574a();

    protected void mo4043a(int i) {
        zzxu com_google_android_gms_internal_zzxu = this;
        int i2 = i;
        if (i2 != -2) {
            com_google_android_gms_internal_zzxu.f14743c = new zzaax(i2, com_google_android_gms_internal_zzxu.f14743c.f17450j);
        }
        com_google_android_gms_internal_zzxu.f14742b.mo4009q();
        zzyb com_google_android_gms_internal_zzyb = com_google_android_gms_internal_zzxu.f14744d;
        zzaat com_google_android_gms_internal_zzaat = com_google_android_gms_internal_zzxu.f14745e.f6314a;
        zzjj com_google_android_gms_internal_zzjj = com_google_android_gms_internal_zzaat.f17396c;
        zzanh com_google_android_gms_internal_zzanh = com_google_android_gms_internal_zzxu.f14742b;
        List list = com_google_android_gms_internal_zzxu.f14743c.f17443c;
        List list2 = com_google_android_gms_internal_zzxu.f14743c.f17445e;
        List list3 = com_google_android_gms_internal_zzxu.f14743c.f17449i;
        int i3 = com_google_android_gms_internal_zzxu.f14743c.f17451k;
        long j = com_google_android_gms_internal_zzxu.f14743c.f17450j;
        String str = com_google_android_gms_internal_zzaat.f17402i;
        boolean z = com_google_android_gms_internal_zzxu.f14743c.f17447g;
        long j2 = com_google_android_gms_internal_zzxu.f14743c.f17448h;
        zzjn com_google_android_gms_internal_zzjn = com_google_android_gms_internal_zzxu.f14745e.f6317d;
        long j3 = j2;
        zzyb com_google_android_gms_internal_zzyb2 = com_google_android_gms_internal_zzyb;
        long j4 = com_google_android_gms_internal_zzxu.f14743c.f17446f;
        long j5 = com_google_android_gms_internal_zzxu.f14745e.f6319f;
        long j6 = com_google_android_gms_internal_zzxu.f14743c.f17453m;
        String str2 = com_google_android_gms_internal_zzxu.f14743c.f17454n;
        JSONObject jSONObject = com_google_android_gms_internal_zzxu.f14745e.f6321h;
        zzaeq com_google_android_gms_internal_zzaeq = com_google_android_gms_internal_zzxu.f14743c.f17421A;
        List list4 = com_google_android_gms_internal_zzxu.f14743c.f17422B;
        List list5 = com_google_android_gms_internal_zzxu.f14743c.f17423C;
        boolean z2 = com_google_android_gms_internal_zzxu.f14743c.f17424D;
        zzaaz com_google_android_gms_internal_zzaaz = com_google_android_gms_internal_zzxu.f14743c.f17425E;
        List list6 = com_google_android_gms_internal_zzxu.f14743c.f17428H;
        String str3 = com_google_android_gms_internal_zzxu.f14743c.f17432L;
        zzis com_google_android_gms_internal_zzis = com_google_android_gms_internal_zzxu.f14745e.f6322i;
        String str4 = str2;
        zzva com_google_android_gms_internal_zzva = null;
        zzafo com_google_android_gms_internal_zzafo = r41;
        zzyb com_google_android_gms_internal_zzyb3 = com_google_android_gms_internal_zzyb2;
        String str5 = null;
        zzui com_google_android_gms_internal_zzui = null;
        zzuk com_google_android_gms_internal_zzuk = null;
        long j7 = j3;
        long j8 = j4;
        long j9 = j5;
        long j10 = j6;
        zzafo com_google_android_gms_internal_zzafo2 = new zzafo(com_google_android_gms_internal_zzjj, com_google_android_gms_internal_zzanh, list, i2, list2, list3, i3, j, str, z, null, com_google_android_gms_internal_zzva, str5, com_google_android_gms_internal_zzui, com_google_android_gms_internal_zzuk, j7, com_google_android_gms_internal_zzjn, j8, j9, j10, str4, jSONObject, null, com_google_android_gms_internal_zzaeq, list4, list5, z2, com_google_android_gms_internal_zzaaz, null, list6, str3, com_google_android_gms_internal_zzis, com_google_android_gms_internal_zzxu.f14745e.f6315b.f17435O, com_google_android_gms_internal_zzxu.f14745e.f6323j);
        com_google_android_gms_internal_zzyb3.mo3389b(com_google_android_gms_internal_zzafo);
    }

    public final void mo1512a(zzanh com_google_android_gms_internal_zzanh, boolean z) {
        zzakb.m5366b("WebView finished loading.");
        int i = 0;
        if (this.f14748h.getAndSet(false)) {
            if (z) {
                i = -2;
            }
            mo4043a(i);
            zzahn.f6379a.removeCallbacks(this.f14746f);
        }
    }

    public void mo1644d() {
        if (this.f14748h.getAndSet(false)) {
            this.f14742b.stopLoading();
            zzbs.m4488g();
            zzaht.m5232a(this.f14742b);
            mo4043a(-1);
            zzahn.f6379a.removeCallbacks(this.f14746f);
        }
    }

    public final /* synthetic */ Object mo1645e() {
        zzbq.m4816b("Webview render task needs to be called on UI thread.");
        this.f14746f = new zzxv(this);
        zzahn.f6379a.postDelayed(this.f14746f, ((Long) zzkb.m6350f().m6488a(zznh.bn)).longValue());
        mo3574a();
        return null;
    }
}
