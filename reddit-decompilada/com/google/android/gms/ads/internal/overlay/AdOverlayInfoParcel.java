package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.gmsg.zzb;
import com.google.android.gms.ads.internal.zzao;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.dynamic.IObjectWrapper.zza;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.internal.zzje;
import com.google.android.gms.internal.zzzv;

@zzzv
public final class AdOverlayInfoParcel extends zzbfm implements ReflectedParcelable {
    public static final Creator<AdOverlayInfoParcel> CREATOR = new zzm();
    public final zzc f17080a;
    public final zzje f17081b;
    public final zzn f17082c;
    public final zzanh f17083d;
    public final zzb f17084e;
    public final String f17085f;
    public final boolean f17086g;
    public final String f17087h;
    public final zzq f17088i;
    public final int f17089j;
    public final int f17090k;
    public final String f17091l;
    public final zzakd f17092m;
    public final String f17093n;
    public final zzao f17094o;

    AdOverlayInfoParcel(zzc com_google_android_gms_ads_internal_overlay_zzc, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i, int i2, String str3, zzakd com_google_android_gms_internal_zzakd, String str4, zzao com_google_android_gms_ads_internal_zzao) {
        this.f17080a = com_google_android_gms_ads_internal_overlay_zzc;
        this.f17081b = (zzje) zzn.m17693a(zza.m13115a(iBinder));
        this.f17082c = (zzn) zzn.m17693a(zza.m13115a(iBinder2));
        this.f17083d = (zzanh) zzn.m17693a(zza.m13115a(iBinder3));
        this.f17084e = (zzb) zzn.m17693a(zza.m13115a(iBinder4));
        this.f17085f = str;
        this.f17086g = z;
        this.f17087h = str2;
        this.f17088i = (zzq) zzn.m17693a(zza.m13115a(iBinder5));
        this.f17089j = i;
        this.f17090k = i2;
        this.f17091l = str3;
        this.f17092m = com_google_android_gms_internal_zzakd;
        this.f17093n = str4;
        this.f17094o = com_google_android_gms_ads_internal_zzao;
    }

    public AdOverlayInfoParcel(zzc com_google_android_gms_ads_internal_overlay_zzc, zzje com_google_android_gms_internal_zzje, zzn com_google_android_gms_ads_internal_overlay_zzn, zzq com_google_android_gms_ads_internal_overlay_zzq, zzakd com_google_android_gms_internal_zzakd) {
        this.f17080a = com_google_android_gms_ads_internal_overlay_zzc;
        this.f17081b = com_google_android_gms_internal_zzje;
        this.f17082c = com_google_android_gms_ads_internal_overlay_zzn;
        this.f17083d = null;
        this.f17084e = null;
        this.f17085f = null;
        this.f17086g = false;
        this.f17087h = null;
        this.f17088i = com_google_android_gms_ads_internal_overlay_zzq;
        this.f17089j = -1;
        this.f17090k = 4;
        this.f17091l = null;
        this.f17092m = com_google_android_gms_internal_zzakd;
        this.f17093n = null;
        this.f17094o = null;
    }

    public AdOverlayInfoParcel(zzje com_google_android_gms_internal_zzje, zzn com_google_android_gms_ads_internal_overlay_zzn, zzb com_google_android_gms_ads_internal_gmsg_zzb, zzq com_google_android_gms_ads_internal_overlay_zzq, zzanh com_google_android_gms_internal_zzanh, boolean z, int i, String str, zzakd com_google_android_gms_internal_zzakd) {
        this.f17080a = null;
        this.f17081b = com_google_android_gms_internal_zzje;
        this.f17082c = com_google_android_gms_ads_internal_overlay_zzn;
        this.f17083d = com_google_android_gms_internal_zzanh;
        this.f17084e = com_google_android_gms_ads_internal_gmsg_zzb;
        this.f17085f = null;
        this.f17086g = z;
        this.f17087h = null;
        this.f17088i = com_google_android_gms_ads_internal_overlay_zzq;
        this.f17089j = i;
        this.f17090k = 3;
        this.f17091l = str;
        this.f17092m = com_google_android_gms_internal_zzakd;
        this.f17093n = null;
        this.f17094o = null;
    }

    public AdOverlayInfoParcel(zzje com_google_android_gms_internal_zzje, zzn com_google_android_gms_ads_internal_overlay_zzn, zzb com_google_android_gms_ads_internal_gmsg_zzb, zzq com_google_android_gms_ads_internal_overlay_zzq, zzanh com_google_android_gms_internal_zzanh, boolean z, int i, String str, String str2, zzakd com_google_android_gms_internal_zzakd) {
        this.f17080a = null;
        this.f17081b = com_google_android_gms_internal_zzje;
        this.f17082c = com_google_android_gms_ads_internal_overlay_zzn;
        this.f17083d = com_google_android_gms_internal_zzanh;
        this.f17084e = com_google_android_gms_ads_internal_gmsg_zzb;
        this.f17085f = str2;
        this.f17086g = z;
        this.f17087h = str;
        this.f17088i = com_google_android_gms_ads_internal_overlay_zzq;
        this.f17089j = i;
        this.f17090k = 3;
        this.f17091l = null;
        this.f17092m = com_google_android_gms_internal_zzakd;
        this.f17093n = null;
        this.f17094o = null;
    }

    public AdOverlayInfoParcel(zzje com_google_android_gms_internal_zzje, zzn com_google_android_gms_ads_internal_overlay_zzn, zzq com_google_android_gms_ads_internal_overlay_zzq, zzanh com_google_android_gms_internal_zzanh, int i, zzakd com_google_android_gms_internal_zzakd, String str, zzao com_google_android_gms_ads_internal_zzao) {
        this.f17080a = null;
        this.f17081b = com_google_android_gms_internal_zzje;
        this.f17082c = com_google_android_gms_ads_internal_overlay_zzn;
        this.f17083d = com_google_android_gms_internal_zzanh;
        this.f17084e = null;
        this.f17085f = null;
        this.f17086g = false;
        this.f17087h = null;
        this.f17088i = com_google_android_gms_ads_internal_overlay_zzq;
        this.f17089j = i;
        this.f17090k = 1;
        this.f17091l = null;
        this.f17092m = com_google_android_gms_internal_zzakd;
        this.f17093n = str;
        this.f17094o = com_google_android_gms_ads_internal_zzao;
    }

    public AdOverlayInfoParcel(zzje com_google_android_gms_internal_zzje, zzn com_google_android_gms_ads_internal_overlay_zzn, zzq com_google_android_gms_ads_internal_overlay_zzq, zzanh com_google_android_gms_internal_zzanh, boolean z, int i, zzakd com_google_android_gms_internal_zzakd) {
        this.f17080a = null;
        this.f17081b = com_google_android_gms_internal_zzje;
        this.f17082c = com_google_android_gms_ads_internal_overlay_zzn;
        this.f17083d = com_google_android_gms_internal_zzanh;
        this.f17084e = null;
        this.f17085f = null;
        this.f17086g = z;
        this.f17087h = null;
        this.f17088i = com_google_android_gms_ads_internal_overlay_zzq;
        this.f17089j = i;
        this.f17090k = 2;
        this.f17091l = null;
        this.f17092m = com_google_android_gms_internal_zzakd;
        this.f17093n = null;
        this.f17094o = null;
    }

    public static com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel m17396a(android.content.Intent r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = "com.google.android.gms.ads.inernal.overlay.AdOverlayInfo";	 Catch:{ Exception -> 0x0018 }
        r1 = r1.getBundleExtra(r0);	 Catch:{ Exception -> 0x0018 }
        r0 = com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel.class;	 Catch:{ Exception -> 0x0018 }
        r0 = r0.getClassLoader();	 Catch:{ Exception -> 0x0018 }
        r1.setClassLoader(r0);	 Catch:{ Exception -> 0x0018 }
        r0 = "com.google.android.gms.ads.inernal.overlay.AdOverlayInfo";	 Catch:{ Exception -> 0x0018 }
        r1 = r1.getParcelable(r0);	 Catch:{ Exception -> 0x0018 }
        r1 = (com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel) r1;	 Catch:{ Exception -> 0x0018 }
        return r1;
    L_0x0018:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel.a(android.content.Intent):com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel");
    }

    public static void m17397a(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5544a(parcel, 2, this.f17080a, i);
        zzbfp.m5543a(parcel, 3, zzn.m17692a(this.f17081b).asBinder());
        zzbfp.m5543a(parcel, 4, zzn.m17692a(this.f17082c).asBinder());
        zzbfp.m5543a(parcel, 5, zzn.m17692a(this.f17083d).asBinder());
        zzbfp.m5543a(parcel, 6, zzn.m17692a(this.f17084e).asBinder());
        zzbfp.m5545a(parcel, 7, this.f17085f);
        zzbfp.m5547a(parcel, 8, this.f17086g);
        zzbfp.m5545a(parcel, 9, this.f17087h);
        zzbfp.m5543a(parcel, 10, zzn.m17692a(this.f17088i).asBinder());
        zzbfp.m5540a(parcel, 11, this.f17089j);
        zzbfp.m5540a(parcel, 12, this.f17090k);
        zzbfp.m5545a(parcel, 13, this.f17091l);
        zzbfp.m5544a(parcel, 14, this.f17092m, i);
        zzbfp.m5545a(parcel, 16, this.f17093n);
        zzbfp.m5544a(parcel, 17, this.f17094o, i);
        zzbfp.m5537a(parcel, a);
    }
}
