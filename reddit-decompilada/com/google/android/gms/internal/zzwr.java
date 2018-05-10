package com.google.android.gms.internal;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.util.zze;
import java.util.Set;
import org.json.JSONObject;

@zzzv
public final class zzwr extends zzxb {
    private static Set<String> f14707t = zze.m4901a("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    public String f14708a = "top-right";
    public boolean f14709b = true;
    int f14710c = 0;
    int f14711d = 0;
    public int f14712e = -1;
    public int f14713f = 0;
    public int f14714g = 0;
    public int f14715h = -1;
    public final Object f14716i = new Object();
    public final zzanh f14717j;
    public final Activity f14718k;
    public zzapa f14719l;
    public ImageView f14720m;
    public LinearLayout f14721n;
    public zzxc f14722o;
    public PopupWindow f14723p;
    public RelativeLayout f14724q;
    public ViewGroup f14725r;

    public zzwr(zzanh com_google_android_gms_internal_zzanh, zzxc com_google_android_gms_internal_zzxc) {
        super(com_google_android_gms_internal_zzanh, "resize");
        this.f14717j = com_google_android_gms_internal_zzanh;
        this.f14718k = com_google_android_gms_internal_zzanh.mo3467d();
        this.f14722o = com_google_android_gms_internal_zzxc;
    }

    public final void m14428a(boolean z) {
        synchronized (this.f14716i) {
            if (this.f14723p != null) {
                this.f14723p.dismiss();
                RelativeLayout relativeLayout = this.f14724q;
                zzanh com_google_android_gms_internal_zzanh = this.f14717j;
                if (com_google_android_gms_internal_zzanh == null) {
                    throw null;
                }
                relativeLayout.removeView((View) com_google_android_gms_internal_zzanh);
                if (this.f14725r != null) {
                    this.f14725r.removeView(this.f14720m);
                    ViewGroup viewGroup = this.f14725r;
                    com_google_android_gms_internal_zzanh = this.f14717j;
                    if (com_google_android_gms_internal_zzanh == null) {
                        throw null;
                    }
                    viewGroup.addView((View) com_google_android_gms_internal_zzanh);
                    this.f14717j.mo3981a(this.f14719l);
                }
                if (z) {
                    m6784b("default");
                    if (this.f14722o != null) {
                        this.f14722o.mo4275H();
                    }
                }
                this.f14723p = null;
                this.f14724q = null;
                this.f14725r = null;
                this.f14721n = null;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int[] m14429a() {
        /*
        r9 = this;
        com.google.android.gms.ads.internal.zzbs.m4486e();
        r0 = r9.f14718k;
        r0 = com.google.android.gms.internal.zzahn.m5196b(r0);
        com.google.android.gms.ads.internal.zzbs.m4486e();
        r1 = r9.f14718k;
        r1 = com.google.android.gms.internal.zzahn.m5202c(r1);
        r2 = 0;
        r3 = r0[r2];
        r4 = 1;
        r0 = r0[r4];
        r5 = r9.f14715h;
        r6 = 2;
        r7 = 50;
        if (r5 < r7) goto L_0x00fb;
    L_0x001f:
        r5 = r9.f14715h;
        if (r5 <= r3) goto L_0x0025;
    L_0x0023:
        goto L_0x00fb;
    L_0x0025:
        r5 = r9.f14712e;
        if (r5 < r7) goto L_0x00f8;
    L_0x0029:
        r5 = r9.f14712e;
        if (r5 <= r0) goto L_0x002f;
    L_0x002d:
        goto L_0x00f8;
    L_0x002f:
        r5 = r9.f14712e;
        if (r5 != r0) goto L_0x003b;
    L_0x0033:
        r0 = r9.f14715h;
        if (r0 != r3) goto L_0x003b;
    L_0x0037:
        r0 = "Cannot resize to a full-screen ad.";
        goto L_0x00fd;
    L_0x003b:
        r0 = r9.f14709b;
        if (r0 == 0) goto L_0x00f6;
    L_0x003f:
        r0 = r9.f14708a;
        r5 = -1;
        r8 = r0.hashCode();
        switch(r8) {
            case -1364013995: goto L_0x007c;
            case -1012429441: goto L_0x0072;
            case -655373719: goto L_0x0068;
            case 1163912186: goto L_0x005e;
            case 1288627767: goto L_0x0054;
            case 1755462605: goto L_0x004a;
            default: goto L_0x0049;
        };
    L_0x0049:
        goto L_0x0086;
    L_0x004a:
        r8 = "top-center";
        r0 = r0.equals(r8);
        if (r0 == 0) goto L_0x0086;
    L_0x0052:
        r0 = r4;
        goto L_0x0087;
    L_0x0054:
        r8 = "bottom-center";
        r0 = r0.equals(r8);
        if (r0 == 0) goto L_0x0086;
    L_0x005c:
        r0 = 4;
        goto L_0x0087;
    L_0x005e:
        r8 = "bottom-right";
        r0 = r0.equals(r8);
        if (r0 == 0) goto L_0x0086;
    L_0x0066:
        r0 = 5;
        goto L_0x0087;
    L_0x0068:
        r8 = "bottom-left";
        r0 = r0.equals(r8);
        if (r0 == 0) goto L_0x0086;
    L_0x0070:
        r0 = 3;
        goto L_0x0087;
    L_0x0072:
        r8 = "top-left";
        r0 = r0.equals(r8);
        if (r0 == 0) goto L_0x0086;
    L_0x007a:
        r0 = r2;
        goto L_0x0087;
    L_0x007c:
        r8 = "center";
        r0 = r0.equals(r8);
        if (r0 == 0) goto L_0x0086;
    L_0x0084:
        r0 = r6;
        goto L_0x0087;
    L_0x0086:
        r0 = r5;
    L_0x0087:
        switch(r0) {
            case 0: goto L_0x00e1;
            case 1: goto L_0x00d5;
            case 2: goto L_0x00be;
            case 3: goto L_0x00af;
            case 4: goto L_0x00a3;
            case 5: goto L_0x0099;
            default: goto L_0x008a;
        };
    L_0x008a:
        r0 = r9.f14710c;
        r5 = r9.f14713f;
        r0 = r0 + r5;
        r5 = r9.f14715h;
        r0 = r0 + r5;
        r0 = r0 - r7;
    L_0x0093:
        r5 = r9.f14711d;
        r8 = r9.f14714g;
        r5 = r5 + r8;
        goto L_0x00e7;
    L_0x0099:
        r0 = r9.f14710c;
        r5 = r9.f14713f;
        r0 = r0 + r5;
        r5 = r9.f14715h;
        r0 = r0 + r5;
        r0 = r0 - r7;
        goto L_0x00b4;
    L_0x00a3:
        r0 = r9.f14710c;
        r5 = r9.f14713f;
        r0 = r0 + r5;
        r5 = r9.f14715h;
        r5 = r5 / r6;
        r0 = r0 + r5;
        r0 = r0 + -25;
        goto L_0x00b4;
    L_0x00af:
        r0 = r9.f14710c;
        r5 = r9.f14713f;
        r0 = r0 + r5;
    L_0x00b4:
        r5 = r9.f14711d;
        r8 = r9.f14714g;
        r5 = r5 + r8;
        r8 = r9.f14712e;
        r5 = r5 + r8;
        r5 = r5 - r7;
        goto L_0x00e7;
    L_0x00be:
        r0 = r9.f14710c;
        r5 = r9.f14713f;
        r0 = r0 + r5;
        r5 = r9.f14715h;
        r5 = r5 / r6;
        r0 = r0 + r5;
        r0 = r0 + -25;
        r5 = r9.f14711d;
        r8 = r9.f14714g;
        r5 = r5 + r8;
        r8 = r9.f14712e;
        r8 = r8 / r6;
        r5 = r5 + r8;
        r5 = r5 + -25;
        goto L_0x00e7;
    L_0x00d5:
        r0 = r9.f14710c;
        r5 = r9.f14713f;
        r0 = r0 + r5;
        r5 = r9.f14715h;
        r5 = r5 / r6;
        r0 = r0 + r5;
        r0 = r0 + -25;
        goto L_0x0093;
    L_0x00e1:
        r0 = r9.f14710c;
        r5 = r9.f14713f;
        r0 = r0 + r5;
        goto L_0x0093;
    L_0x00e7:
        if (r0 < 0) goto L_0x0100;
    L_0x00e9:
        r0 = r0 + r7;
        if (r0 > r3) goto L_0x0100;
    L_0x00ec:
        r0 = r1[r2];
        if (r5 < r0) goto L_0x0100;
    L_0x00f0:
        r5 = r5 + r7;
        r0 = r1[r4];
        if (r5 <= r0) goto L_0x00f6;
    L_0x00f5:
        goto L_0x0100;
    L_0x00f6:
        r0 = r4;
        goto L_0x0101;
    L_0x00f8:
        r0 = "Height is too small or too large.";
        goto L_0x00fd;
    L_0x00fb:
        r0 = "Width is too small or too large.";
    L_0x00fd:
        com.google.android.gms.internal.zzakb.m5371e(r0);
    L_0x0100:
        r0 = r2;
    L_0x0101:
        if (r0 != 0) goto L_0x0105;
    L_0x0103:
        r0 = 0;
        return r0;
    L_0x0105:
        r0 = r9.f14709b;
        if (r0 == 0) goto L_0x011a;
    L_0x0109:
        r0 = new int[r6];
        r1 = r9.f14710c;
        r3 = r9.f14713f;
        r1 = r1 + r3;
        r0[r2] = r1;
        r1 = r9.f14711d;
        r2 = r9.f14714g;
        r1 = r1 + r2;
        r0[r4] = r1;
        return r0;
    L_0x011a:
        com.google.android.gms.ads.internal.zzbs.m4486e();
        r0 = r9.f14718k;
        r0 = com.google.android.gms.internal.zzahn.m5196b(r0);
        com.google.android.gms.ads.internal.zzbs.m4486e();
        r1 = r9.f14718k;
        r1 = com.google.android.gms.internal.zzahn.m5202c(r1);
        r0 = r0[r2];
        r3 = r9.f14710c;
        r5 = r9.f14713f;
        r3 = r3 + r5;
        r5 = r9.f14711d;
        r7 = r9.f14714g;
        r5 = r5 + r7;
        if (r3 >= 0) goto L_0x013c;
    L_0x013a:
        r0 = r2;
        goto L_0x0146;
    L_0x013c:
        r7 = r9.f14715h;
        r7 = r7 + r3;
        if (r7 <= r0) goto L_0x0145;
    L_0x0141:
        r3 = r9.f14715h;
        r0 = r0 - r3;
        goto L_0x0146;
    L_0x0145:
        r0 = r3;
    L_0x0146:
        r3 = r1[r2];
        if (r5 >= r3) goto L_0x014d;
    L_0x014a:
        r5 = r1[r2];
        goto L_0x015a;
    L_0x014d:
        r3 = r9.f14712e;
        r3 = r3 + r5;
        r7 = r1[r4];
        if (r3 <= r7) goto L_0x015a;
    L_0x0154:
        r1 = r1[r4];
        r3 = r9.f14712e;
        r5 = r1 - r3;
    L_0x015a:
        r1 = new int[r6];
        r1[r2] = r0;
        r1[r4] = r5;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzwr.a():int[]");
    }

    public final boolean m14430b() {
        boolean z;
        synchronized (this.f14716i) {
            z = this.f14723p != null;
        }
        return z;
    }

    public final void m14427a(int i, int i2) {
        zzbs.m4486e();
        i2 -= zzahn.m5202c(this.f14718k)[0];
        int i3 = this.f14715h;
        try {
            this.f8141s.mo3463a("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", this.f14712e));
        } catch (int i4) {
            zzakb.m5367b("Error occured while dispatching size change.", i4);
        }
    }
}
