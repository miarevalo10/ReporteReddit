package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.ads.internal.zzbs;
import java.util.Map;
import org.json.JSONObject;

@zzzv
public final class zzxa extends zzxb implements zzt<zzanh> {
    private final zzanh f14728a;
    private final Context f14729b;
    private final WindowManager f14730c;
    private final zzmt f14731d;
    private DisplayMetrics f14732e;
    private float f14733f;
    private int f14734g = -1;
    private int f14735h = -1;
    private int f14736i;
    private int f14737j = -1;
    private int f14738k = -1;
    private int f14739l = -1;
    private int f14740m = -1;

    public zzxa(zzanh com_google_android_gms_internal_zzanh, Context context, zzmt com_google_android_gms_internal_zzmt) {
        super(com_google_android_gms_internal_zzanh);
        this.f14728a = com_google_android_gms_internal_zzanh;
        this.f14729b = context;
        this.f14731d = com_google_android_gms_internal_zzmt;
        this.f14730c = (WindowManager) context.getSystemService("window");
    }

    public final void m14432a(int i, int i2) {
        int i3 = 0;
        if (this.f14729b instanceof Activity) {
            zzbs.m4486e();
            i3 = zzahn.m5202c((Activity) this.f14729b)[0];
        }
        if (this.f14728a.mo3474u() == null || !this.f14728a.mo3474u().m5488c()) {
            zzkb.m6345a();
            this.f14739l = zzajr.m5329b(this.f14729b, this.f14728a.getWidth());
            zzkb.m6345a();
            this.f14740m = zzajr.m5329b(this.f14729b, this.f14728a.getHeight());
        }
        int i4 = i2 - i3;
        i3 = this.f14739l;
        try {
            this.f8141s.mo3463a("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i4).put("width", i3).put("height", this.f14740m));
        } catch (Throwable e) {
            zzakb.m5367b("Error occured while dispatching default position.", e);
        }
        zzani w = this.f14728a.mo4019w();
        if (w.f6624k != null) {
            zzwr com_google_android_gms_internal_zzwr = w.f6624k;
            com_google_android_gms_internal_zzwr.f14710c = i;
            com_google_android_gms_internal_zzwr.f14711d = i2;
        }
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzmt com_google_android_gms_internal_zzmt;
        Intent intent;
        int[] iArr;
        int b;
        this.f14732e = new DisplayMetrics();
        obj = this.f14730c.getDefaultDisplay();
        obj.getMetrics(this.f14732e);
        this.f14733f = this.f14732e.density;
        this.f14736i = obj.getRotation();
        zzkb.m6345a();
        this.f14734g = zzajr.m5330b(this.f14732e, this.f14732e.widthPixels);
        zzkb.m6345a();
        this.f14735h = zzajr.m5330b(this.f14732e, this.f14732e.heightPixels);
        Activity d = this.f14728a.mo3467d();
        if (d != null) {
            if (d.getWindow() != null) {
                zzbs.m4486e();
                obj = zzahn.m5184a(d);
                zzkb.m6345a();
                this.f14737j = zzajr.m5330b(this.f14732e, obj[0]);
                zzkb.m6345a();
                obj = zzajr.m5330b(this.f14732e, obj[1]);
                this.f14738k = obj;
                if (this.f14728a.mo3474u().m5488c() == null) {
                    this.f14739l = this.f14734g;
                    this.f14740m = this.f14735h;
                } else {
                    this.f14728a.measure(0, 0);
                }
                m6782a(this.f14734g, this.f14735h, this.f14737j, this.f14738k, this.f14733f, this.f14736i);
                obj = new zzwz();
                com_google_android_gms_internal_zzmt = this.f14731d;
                intent = new Intent("android.intent.action.DIAL");
                intent.setData(Uri.parse("tel:"));
                obj.f8136b = com_google_android_gms_internal_zzmt.m6472a(intent);
                com_google_android_gms_internal_zzmt = this.f14731d;
                intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("sms:"));
                obj.f8135a = com_google_android_gms_internal_zzmt.m6472a(intent);
                obj.f8137c = this.f14731d.m6473b();
                obj.f8138d = this.f14731d.m6471a();
                obj.f8139e = true;
                this.f14728a.mo3463a("onDeviceFeaturesReceived", new zzwx(obj).m6775a());
                iArr = new int[2];
                this.f14728a.getLocationOnScreen(iArr);
                zzkb.m6345a();
                b = zzajr.m5329b(this.f14729b, iArr[0]);
                zzkb.m6345a();
                m14432a(b, zzajr.m5329b(this.f14729b, iArr[1]));
                if (zzakb.m5365a(2) != null) {
                    zzakb.m5370d("Dispatching Ready Event.");
                }
                this.f8141s.mo3463a("onReadyEventReceived", new JSONObject().put("js", this.f14728a.mo3472k().f17551a));
            }
        }
        this.f14737j = this.f14734g;
        obj = this.f14735h;
        this.f14738k = obj;
        if (this.f14728a.mo3474u().m5488c() == null) {
            this.f14728a.measure(0, 0);
        } else {
            this.f14739l = this.f14734g;
            this.f14740m = this.f14735h;
        }
        m6782a(this.f14734g, this.f14735h, this.f14737j, this.f14738k, this.f14733f, this.f14736i);
        obj = new zzwz();
        com_google_android_gms_internal_zzmt = this.f14731d;
        intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        obj.f8136b = com_google_android_gms_internal_zzmt.m6472a(intent);
        com_google_android_gms_internal_zzmt = this.f14731d;
        intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        obj.f8135a = com_google_android_gms_internal_zzmt.m6472a(intent);
        obj.f8137c = this.f14731d.m6473b();
        obj.f8138d = this.f14731d.m6471a();
        obj.f8139e = true;
        this.f14728a.mo3463a("onDeviceFeaturesReceived", new zzwx(obj).m6775a());
        iArr = new int[2];
        this.f14728a.getLocationOnScreen(iArr);
        zzkb.m6345a();
        b = zzajr.m5329b(this.f14729b, iArr[0]);
        zzkb.m6345a();
        m14432a(b, zzajr.m5329b(this.f14729b, iArr[1]));
        if (zzakb.m5365a(2) != null) {
            zzakb.m5370d("Dispatching Ready Event.");
        }
        try {
            this.f8141s.mo3463a("onReadyEventReceived", new JSONObject().put("js", this.f14728a.mo3472k().f17551a));
        } catch (Object obj2) {
            zzakb.m5367b("Error occured while dispatching ready Event.", obj2);
        }
    }
}
