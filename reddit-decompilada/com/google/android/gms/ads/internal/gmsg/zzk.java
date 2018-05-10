package com.google.android.gms.ads.internal.gmsg;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzanh;
import java.util.HashMap;
import java.util.Map;

final class zzk implements zzt<zzanh> {
    zzk() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzanh com_google_android_gms_internal_zzanh = (zzanh) obj;
        WindowManager windowManager = (WindowManager) com_google_android_gms_internal_zzanh.getContext().getSystemService("window");
        zzbs.m4486e();
        View view = (View) com_google_android_gms_internal_zzanh;
        DisplayMetrics a = zzahn.m5154a(windowManager);
        int i = a.widthPixels;
        int i2 = a.heightPixels;
        int[] iArr = new int[2];
        Map hashMap = new HashMap();
        view.getLocationInWindow(iArr);
        hashMap.put("xInPixels", Integer.valueOf(iArr[0]));
        hashMap.put("yInPixels", Integer.valueOf(iArr[1]));
        hashMap.put("windowWidthInPixels", Integer.valueOf(i));
        hashMap.put("windowHeightInPixels", Integer.valueOf(i2));
        com_google_android_gms_internal_zzanh.mo3462a("locationReady", hashMap);
        zzakb.m5371e("GET LOCATION COMPILED");
    }
}
