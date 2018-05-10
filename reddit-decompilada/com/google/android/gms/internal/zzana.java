package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.api.Releasable;
import java.lang.ref.WeakReference;
import java.util.Map;

@zzzv
public abstract class zzana implements Releasable {
    protected Context f14195a;
    private String f14196b;
    private WeakReference<zzamp> f14197c;

    public zzana(zzamp com_google_android_gms_internal_zzamp) {
        this.f14195a = com_google_android_gms_internal_zzamp.getContext();
        this.f14196b = zzbs.m4486e().m5225a(this.f14195a, com_google_android_gms_internal_zzamp.mo3472k().f17551a);
        this.f14197c = new WeakReference(com_google_android_gms_internal_zzamp);
    }

    public abstract void mo3459a();

    protected final void m13402a(String str, String str2, int i) {
        zzajr.f6473a.post(new zzanc(this, str, str2, i));
    }

    public final void m13403a(String str, String str2, String str3, String str4) {
        zzajr.f6473a.post(new zzand(this, str, str2, str3, str4));
    }

    public abstract boolean mo3460a(String str);

    static /* synthetic */ void m13399a(zzana com_google_android_gms_internal_zzana, String str, Map map) {
        zzamp com_google_android_gms_internal_zzamp = (zzamp) com_google_android_gms_internal_zzana.f14197c.get();
        if (com_google_android_gms_internal_zzamp != null) {
            com_google_android_gms_internal_zzamp.mo3462a(str, map);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.String m13400b(java.lang.String r2) {
        /*
        r0 = "internal";
        r1 = r2.hashCode();
        switch(r1) {
            case -1396664534: goto L_0x0067;
            case -1347010958: goto L_0x005d;
            case -918817863: goto L_0x0053;
            case -659376217: goto L_0x0049;
            case -642208130: goto L_0x003f;
            case -354048396: goto L_0x0034;
            case -32082395: goto L_0x0029;
            case 96784904: goto L_0x001f;
            case 580119100: goto L_0x0015;
            case 725497484: goto L_0x000b;
            default: goto L_0x0009;
        };
    L_0x0009:
        goto L_0x0071;
    L_0x000b:
        r1 = "noCacheDir";
        r2 = r2.equals(r1);
        if (r2 == 0) goto L_0x0071;
    L_0x0013:
        r2 = 4;
        goto L_0x0072;
    L_0x0015:
        r1 = "expireFailed";
        r2 = r2.equals(r1);
        if (r2 == 0) goto L_0x0071;
    L_0x001d:
        r2 = 5;
        goto L_0x0072;
    L_0x001f:
        r1 = "error";
        r2 = r2.equals(r1);
        if (r2 == 0) goto L_0x0071;
    L_0x0027:
        r2 = 0;
        goto L_0x0072;
    L_0x0029:
        r1 = "externalAbort";
        r2 = r2.equals(r1);
        if (r2 == 0) goto L_0x0071;
    L_0x0031:
        r2 = 9;
        goto L_0x0072;
    L_0x0034:
        r1 = "sizeExceeded";
        r2 = r2.equals(r1);
        if (r2 == 0) goto L_0x0071;
    L_0x003c:
        r2 = 8;
        goto L_0x0072;
    L_0x003f:
        r1 = "playerFailed";
        r2 = r2.equals(r1);
        if (r2 == 0) goto L_0x0071;
    L_0x0047:
        r2 = 1;
        goto L_0x0072;
    L_0x0049:
        r1 = "contentLengthMissing";
        r2 = r2.equals(r1);
        if (r2 == 0) goto L_0x0071;
    L_0x0051:
        r2 = 3;
        goto L_0x0072;
    L_0x0053:
        r1 = "downloadTimeout";
        r2 = r2.equals(r1);
        if (r2 == 0) goto L_0x0071;
    L_0x005b:
        r2 = 7;
        goto L_0x0072;
    L_0x005d:
        r1 = "inProgress";
        r2 = r2.equals(r1);
        if (r2 == 0) goto L_0x0071;
    L_0x0065:
        r2 = 2;
        goto L_0x0072;
    L_0x0067:
        r1 = "badUrl";
        r2 = r2.equals(r1);
        if (r2 == 0) goto L_0x0071;
    L_0x006f:
        r2 = 6;
        goto L_0x0072;
    L_0x0071:
        r2 = -1;
    L_0x0072:
        switch(r2) {
            case 0: goto L_0x007f;
            case 1: goto L_0x007f;
            case 2: goto L_0x007f;
            case 3: goto L_0x007f;
            case 4: goto L_0x007c;
            case 5: goto L_0x007c;
            case 6: goto L_0x0079;
            case 7: goto L_0x0079;
            case 8: goto L_0x0076;
            case 9: goto L_0x0076;
            default: goto L_0x0075;
        };
    L_0x0075:
        goto L_0x0081;
    L_0x0076:
        r0 = "policy";
        goto L_0x0081;
    L_0x0079:
        r0 = "network";
        goto L_0x0081;
    L_0x007c:
        r0 = "io";
        goto L_0x0081;
    L_0x007f:
        r0 = "internal";
    L_0x0081:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzana.b(java.lang.String):java.lang.String");
    }
}
