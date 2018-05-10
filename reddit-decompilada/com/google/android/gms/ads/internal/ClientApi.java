package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.Keep;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzadd;
import com.google.android.gms.internal.zzadk;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzks;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zzlg;
import com.google.android.gms.internal.zzpg;
import com.google.android.gms.internal.zzpj;
import com.google.android.gms.internal.zzpu;
import com.google.android.gms.internal.zzpz;
import com.google.android.gms.internal.zzux;
import com.google.android.gms.internal.zzxe;
import com.google.android.gms.internal.zzxo;
import com.google.android.gms.internal.zzzv;
import java.util.HashMap;

@Keep
@zzzv
@DynamiteApi
public class ClientApi extends zzlb {
    public zzkn createAdLoaderBuilder(IObjectWrapper iObjectWrapper, String str, zzux com_google_android_gms_internal_zzux, int i) {
        Context context = (Context) zzn.m17693a(iObjectWrapper);
        zzbs.m4486e();
        return new zzaj(context, str, com_google_android_gms_internal_zzux, new zzakd(i, zzahn.m5220l(context)), zzv.m4517a(context));
    }

    public zzxe createAdOverlay(IObjectWrapper iObjectWrapper) {
        return new zzd((Activity) zzn.m17693a(iObjectWrapper));
    }

    public zzks createBannerAdManager(IObjectWrapper iObjectWrapper, zzjn com_google_android_gms_internal_zzjn, String str, zzux com_google_android_gms_internal_zzux, int i) throws RemoteException {
        Context context = (Context) zzn.m17693a(iObjectWrapper);
        zzbs.m4486e();
        return new zzx(context, com_google_android_gms_internal_zzjn, str, com_google_android_gms_internal_zzux, new zzakd(i, zzahn.m5220l(context)), zzv.m4517a(context));
    }

    public zzxo createInAppPurchaseManager(IObjectWrapper iObjectWrapper) {
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.zzks createInterstitialAdManager(com.google.android.gms.dynamic.IObjectWrapper r8, com.google.android.gms.internal.zzjn r9, java.lang.String r10, com.google.android.gms.internal.zzux r11, int r12) throws android.os.RemoteException {
        /*
        r7 = this;
        r8 = com.google.android.gms.dynamic.zzn.m17693a(r8);
        r1 = r8;
        r1 = (android.content.Context) r1;
        com.google.android.gms.internal.zznh.m6490a(r1);
        r5 = new com.google.android.gms.internal.zzakd;
        com.google.android.gms.ads.internal.zzbs.m4486e();
        r8 = com.google.android.gms.internal.zzahn.m5220l(r1);
        r5.<init>(r12, r8);
        r8 = "reward_mb";
        r12 = r9.f18152a;
        r8 = r8.equals(r12);
        if (r8 != 0) goto L_0x0032;
    L_0x0020:
        r12 = com.google.android.gms.internal.zznh.aF;
        r0 = com.google.android.gms.internal.zzkb.m6350f();
        r12 = r0.m6488a(r12);
        r12 = (java.lang.Boolean) r12;
        r12 = r12.booleanValue();
        if (r12 != 0) goto L_0x0046;
    L_0x0032:
        if (r8 == 0) goto L_0x0048;
    L_0x0034:
        r8 = com.google.android.gms.internal.zznh.aG;
        r12 = com.google.android.gms.internal.zzkb.m6350f();
        r8 = r12.m6488a(r8);
        r8 = (java.lang.Boolean) r8;
        r8 = r8.booleanValue();
        if (r8 == 0) goto L_0x0048;
    L_0x0046:
        r8 = 1;
        goto L_0x0049;
    L_0x0048:
        r8 = 0;
    L_0x0049:
        if (r8 == 0) goto L_0x005a;
    L_0x004b:
        r8 = new com.google.android.gms.internal.zztl;
        r9 = com.google.android.gms.ads.internal.zzv.m4517a(r1);
        r0 = r8;
        r2 = r10;
        r3 = r11;
        r4 = r5;
        r5 = r9;
        r0.<init>(r1, r2, r3, r4, r5);
        return r8;
    L_0x005a:
        r8 = new com.google.android.gms.ads.internal.zzak;
        r6 = com.google.android.gms.ads.internal.zzv.m4517a(r1);
        r0 = r8;
        r2 = r9;
        r3 = r10;
        r4 = r11;
        r0.<init>(r1, r2, r3, r4, r5, r6);
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.ClientApi.createInterstitialAdManager(com.google.android.gms.dynamic.IObjectWrapper, com.google.android.gms.internal.zzjn, java.lang.String, com.google.android.gms.internal.zzux, int):com.google.android.gms.internal.zzks");
    }

    public zzpu createNativeAdViewDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzpg((FrameLayout) zzn.m17693a(iObjectWrapper), (FrameLayout) zzn.m17693a(iObjectWrapper2));
    }

    public zzpz createNativeAdViewHolderDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzpj((View) zzn.m17693a(iObjectWrapper), (HashMap) zzn.m17693a(iObjectWrapper2), (HashMap) zzn.m17693a(iObjectWrapper3));
    }

    public zzadk createRewardedVideoAd(IObjectWrapper iObjectWrapper, zzux com_google_android_gms_internal_zzux, int i) {
        Context context = (Context) zzn.m17693a(iObjectWrapper);
        zzbs.m4486e();
        return new zzadd(context, zzv.m4517a(context), com_google_android_gms_internal_zzux, new zzakd(i, zzahn.m5220l(context)));
    }

    public zzks createSearchAdManager(IObjectWrapper iObjectWrapper, zzjn com_google_android_gms_internal_zzjn, String str, int i) throws RemoteException {
        Context context = (Context) zzn.m17693a(iObjectWrapper);
        zzbs.m4486e();
        return new zzbm(context, com_google_android_gms_internal_zzjn, str, new zzakd(i, zzahn.m5220l(context)));
    }

    public zzlg getMobileAdsSettingsManager(IObjectWrapper iObjectWrapper) {
        return null;
    }

    public zzlg getMobileAdsSettingsManagerWithClientJarVersion(IObjectWrapper iObjectWrapper, int i) {
        Context context = (Context) zzn.m17693a(iObjectWrapper);
        zzbs.m4486e();
        return zzaw.m17506a(context, new zzakd(i, zzahn.m5220l(context)));
    }
}
