package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class zzct extends zzcs {
    private static Object f18017r = new Object();
    private static final String f18018s = "zzct";
    private static volatile zzdm f18019t = null;
    private static boolean f18020u = false;
    private static long f18021v;
    protected boolean f18022q = false;
    private String f18023w;
    private boolean f18024x = false;
    private boolean f18025y = false;
    private zzdt f18026z;

    protected zzct(Context context, String str, boolean z) {
        super(context);
        this.f18023w = str;
        this.f18022q = z;
    }

    private static zzdq m18646a(zzdm com_google_android_gms_internal_zzdm, MotionEvent motionEvent, DisplayMetrics displayMetrics) throws zzdj {
        Method a = com_google_android_gms_internal_zzdm.m5846a("Qplw2pUqnSpmThNy4cjVdvqrjxx/9Z0jyK1w8BPQVMfA35eh0MC7cXEA3u5Xkcuj", "JqjJogq0azQ/rErdMQn/B0NsEhrIRbxY2b3jvD0/vE8=");
        if (a != null) {
            if (motionEvent != null) {
                try {
                    return new zzdq((String) a.invoke(null, new Object[]{motionEvent, displayMetrics}));
                } catch (Throwable e) {
                    throw new zzdj(e);
                }
            }
        }
        throw new zzdj();
    }

    protected static synchronized void m18647a(Context context, boolean z) {
        synchronized (zzct.class) {
            if (!f18020u) {
                f18021v = zzdr.m5888a().longValue() / 1000;
                f18019t = m18649b(context, z);
                f18020u = true;
            }
        }
    }

    protected final long mo3492a(StackTraceElement[] stackTraceElementArr) throws zzdj {
        Method a = f18019t.m5846a("hoZ4RlhPWT5MX/I+m/lUD5aYJ9aPmEb2eUGLaeSBLBDs9eDpXoNNJPm6j1dXVkvA", "Z7StFiuQ59x4y88apmlBJn3lPoWOEnuqoEhP2AVUL8A=");
        if (a != null) {
            if (stackTraceElementArr != null) {
                try {
                    return new zzdk((String) a.invoke(null, new Object[]{stackTraceElementArr})).f14286a.longValue();
                } catch (Throwable e) {
                    throw new zzdj(e);
                }
            }
        }
        throw new zzdj();
    }

    public final void mo1522a(View view) {
        if (!((Boolean) zzkb.m6350f().m6488a(zznh.bt)).booleanValue()) {
            return;
        }
        if (this.f18026z == null) {
            this.f18026z = new zzdt(f18019t, view);
        } else {
            this.f18026z.m5901a(view);
        }
    }

    protected final zzdq mo3495b(MotionEvent motionEvent) throws zzdj {
        Method a = f18019t.m5846a("I8ATAvvv3zdNeDvmT5gQ/ekfiNEF+bBdZZ3FGipPSiGHOLI4yQdK3XpX6xFRuejz", "SRWP8PeqaQflId3WUP9WJTho9Un3bF1tLB8c7UP1Ruo=");
        if (a != null) {
            if (motionEvent != null) {
                try {
                    Object[] objArr = new Object[3];
                    objArr[0] = motionEvent;
                    objArr[1] = this.p;
                    objArr[2] = zzkb.m6350f().m6488a(zznh.bu);
                    return new zzdq((String) a.invoke(null, objArr));
                } catch (Throwable e) {
                    throw new zzdj(e);
                }
            }
        }
        throw new zzdj();
    }

    private static zzdm m18649b(Context context, boolean z) {
        if (f18019t == null) {
            synchronized (f18017r) {
                if (f18019t == null) {
                    context = zzdm.m5836a(context, "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", z);
                    if (context.f7226k) {
                        context.m5848a("VywbbfxE2QuRqZ5xcIwapO7AdSzfVaSWnmJxmUg+0adJ3QBAH5P7EgXr1uzyY+u6", "JgKAyQW0PWqOrZHk4ZNT0IJH02FdSWTXOOjBnF9RRok=", Context.class);
                        context.m5848a("yzGxsS8IwfgINPYaD3TFRjRVH+0Pq4QvVGq15MBf/opCBPnlCr4QHvEcReKXEMs7", "kMEgIGkHy2R1ROJUgud//6gDu/wM35rLhA6gUKrjKq0=", Context.class);
                        context.m5848a("notQcG55r2oh2A1cS/dLfKg9hawk3H86BF0iXzU7AAnhYpfHWl9mq3lZzdkAltxm", "U9ntf5BvZUTabci6TosC4bQNHZ+DOrzvRmpSy4CzkoQ=", Context.class);
                        context.m5848a("2GI4cQuNT2V9TGPC/Z2McvgqRAU80qquJKbm0BMTxLR8WwMEgJwPEKdGCxKNxeUN", "1Kj5K8xXQ2YA9zbG2Rm9FzZtUD9R2drVmZXzLVF7uLA=", Context.class);
                        context.m5848a("ZsnUMRH5gS7aUE0TqnSYS8JWwJCKCL7bH7XFSqbI4dWEEyg2o14AuyyBvtsnwc4D", "SFchXCfZXuuDAwXfTJDosXRUHrZZ0v26SJChYX3rL/o=", Context.class);
                        context.m5848a("lMH30ZU/uP5xaOsdIj/K3/wZfVr7hnOzUHjpO1NWhTJQvW+gY38/OvCWA8Ap4ZOf", "FCjXGcebz7gnog9LMAWyd/isayIV3I84uK1cUtHZ2fI=", Context.class);
                        context.m5848a("oWVj3eW9lsJMixyFq7g0kyuRqYP087mdDp4dCL3paE/7Ut3Ewp3IcEq6P10MPRyy", "siNRngHYHRLjixmg2PEX5OdKhRHe1h8DNRpJp4wC0pk=", Context.class);
                        context.m5848a("yATd8qneW4MlwQIx8jIN6cfiWJ28/zOw6vW7xs0IWvNvim2a85v5X4ZiVD1KK9hX", "0wjmexcQnona3bxO7Nd7FrKMEEoBhOp7s6KivBhMQKU=", Context.class);
                        context.m5848a("Qplw2pUqnSpmThNy4cjVdvqrjxx/9Z0jyK1w8BPQVMfA35eh0MC7cXEA3u5Xkcuj", "JqjJogq0azQ/rErdMQn/B0NsEhrIRbxY2b3jvD0/vE8=", MotionEvent.class, DisplayMetrics.class);
                        context.m5848a("I8ATAvvv3zdNeDvmT5gQ/ekfiNEF+bBdZZ3FGipPSiGHOLI4yQdK3XpX6xFRuejz", "SRWP8PeqaQflId3WUP9WJTho9Un3bF1tLB8c7UP1Ruo=", MotionEvent.class, DisplayMetrics.class, Integer.TYPE);
                        context.m5848a("HYkEKMk8dvMdQrlbFR00sh73U7jSOxxrrxd0BhHmEXYlIfEqe1EzBQsw2kucbDs8", "puD1TaAJX/qcP/8PMgKROAswM+eaSDu4sTUEXpqs2fU=", new Class[0]);
                        context.m5848a("8Hx2xRqW2QZDPiXj7EKgQgzecg5taNOrZe4YkZ9zi7FcQAOy1BO0rYbAdBI9x6Pm", "nJw4XP5tQfSQ6wm+0x6UMq5j2kNiUh+TXa92gyyhaOo=", new Class[0]);
                        context.m5848a("4w5pMN4cUsuXvD3CJ7PKPSwMmWPClIaNSjeM6jtHahV40Q7EiLps1VIbOcEaCSp4", "5XuSFVTSxDkE27CIZHrBIXal5K53Dv1J/UFXKGBFAXY=", new Class[0]);
                        context.m5848a("igTfSDGbP3Q2KSYfnqAL0vFW/zSSX6v+f+5s7NdwuKQgo6M7dQVerLATgNETrLAr", "Wz4eX479PrQ8rGu0gkJoEYqOJ2Dr8sAHE85KoBBz7s4=", new Class[0]);
                        context.m5848a("BiRNVQ0aQHyQJTXKNLbpSFJJy6+rG5ICwTiWxRhS6qdZjM6S9BBOaVfdO1b0Kd8E", "z9Ycw/7CJTzBzg6MPXNZ2oLMXcxWzT8qsF0ig0ITUxc=", new Class[0]);
                        context.m5848a("2glehmg5UKxyaNPdnG06BLa5QbEzBADKVm3lYiT3+JTkguRZEzOA9BDahqC4W8ki", "wM87KVhGHShMaqkZWTxt04VnU6kJHrMxqQyksEW6glI=", new Class[0]);
                        context.m5848a("DGPkHpN6F5DQjFiQDfOpLUfwAMooIPhSFT4YA2aSEj+k+u5Kt4pQoimNrK0aCsHP", "V/2NrZQU5cdFMpqYa0Q9vKRizJ0aHS7vWXQS8vp0qlI=", Context.class, Boolean.TYPE);
                        context.m5848a("hoZ4RlhPWT5MX/I+m/lUD5aYJ9aPmEb2eUGLaeSBLBDs9eDpXoNNJPm6j1dXVkvA", "Z7StFiuQ59x4y88apmlBJn3lPoWOEnuqoEhP2AVUL8A=", StackTraceElement[].class);
                        context.m5848a("peD/v7hHRn46N2uI0dQKpTtMr7rKDQ+Rzb4yluPWMw4TUUwj2SFV9GkdTp0kog66", "XxfDY0AzBkt4iSC5Sim2fww10jQc1evowDldz5+caY4=", View.class, DisplayMetrics.class);
                        context.m5848a("cINMMi7uKicDN2DHSf1rHdgax7DU+CM2mIG3cRQw3SI0nkdhPwdVz1PCbewJpJoO", "VWQmr3p+wsDJ15H20t2tLb975qLEArv8gtHgpBQKEOE=", Context.class, Boolean.TYPE);
                        context.m5848a("6qQh+8GAMu6fM86JkRzoeHiiHD67+MgHO4xhhwcbyPT7CQmAN57q8YytJQRqDjU5", "Qrc1hPZgr+QjlmQtpbdJO1QCxqr2PdTRKIIDeDNdHp8=", View.class, Activity.class);
                        context.m5848a("HBbZPURZUWU/TDYIx99LmOTdgpFP2mdidp6Zk4sZdEVCGaQNYtmNlQBCP3rgXOne", "pdXBsPFh4N2rQp3r0gjTSQiWtas1GOGaKulNSciQTj0=", Long.TYPE);
                    }
                    f18019t = context;
                }
            }
        }
        return f18019t;
    }

    protected final zzaz mo3494b(Context context) {
        zzaz com_google_android_gms_internal_zzaz = new zzaz();
        if (!TextUtils.isEmpty(this.f18023w)) {
            com_google_android_gms_internal_zzaz.f17642b = this.f18023w;
        }
        zzdm b = m18649b(context, this.f18022q);
        if (b.f7217b != null) {
            m18648a(mo4024a(b, com_google_android_gms_internal_zzaz, null));
        }
        return com_google_android_gms_internal_zzaz;
    }

    protected final com.google.android.gms.internal.zzaz mo3493a(android.content.Context r16, android.view.View r17, android.app.Activity r18) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r15 = this;
        r0 = r15;
        r9 = new com.google.android.gms.internal.zzaz;
        r9.<init>();
        r1 = r0.f18023w;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x0012;
    L_0x000e:
        r1 = r0.f18023w;
        r9.f17642b = r1;
    L_0x0012:
        r1 = r0.f18022q;
        r2 = r16;
        r10 = m18649b(r2, r1);
        r1 = r10.f7226k;
        r2 = 0;
        r3 = 1;
        if (r1 != 0) goto L_0x0038;
    L_0x0020:
        r4 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;
        r1 = java.lang.Long.valueOf(r4);
        r9.f17651k = r1;
        r1 = new java.util.concurrent.Callable[r3];
        r3 = new com.google.android.gms.internal.zzee;
        r3.<init>(r10, r9);
        r1[r2] = r3;
        r1 = java.util.Arrays.asList(r1);
        r11 = r1;
        goto L_0x0374;
    L_0x0038:
        r1 = r0.a;	 Catch:{ zzdj -> 0x0058 }
        r4 = r0.p;	 Catch:{ zzdj -> 0x0058 }
        r1 = m18646a(r10, r1, r4);	 Catch:{ zzdj -> 0x0058 }
        r4 = r1.f14291a;	 Catch:{ zzdj -> 0x0058 }
        r9.f17647g = r4;	 Catch:{ zzdj -> 0x0058 }
        r4 = r1.f14292b;	 Catch:{ zzdj -> 0x0058 }
        r9.f17648h = r4;	 Catch:{ zzdj -> 0x0058 }
        r4 = r1.f14293c;	 Catch:{ zzdj -> 0x0058 }
        r9.f17649i = r4;	 Catch:{ zzdj -> 0x0058 }
        r4 = r0.o;	 Catch:{ zzdj -> 0x0058 }
        if (r4 == 0) goto L_0x0058;	 Catch:{ zzdj -> 0x0058 }
    L_0x0050:
        r4 = r1.f14294d;	 Catch:{ zzdj -> 0x0058 }
        r9.f17661u = r4;	 Catch:{ zzdj -> 0x0058 }
        r1 = r1.f14295e;	 Catch:{ zzdj -> 0x0058 }
        r9.f17662v = r1;	 Catch:{ zzdj -> 0x0058 }
    L_0x0058:
        r1 = new com.google.android.gms.internal.zzba;
        r1.<init>();
        r4 = r0.c;
        r6 = 0;
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 <= 0) goto L_0x0141;
    L_0x0065:
        r4 = r0.p;
        r4 = com.google.android.gms.internal.zzdr.m5891a(r4);
        if (r4 == 0) goto L_0x0141;
    L_0x006d:
        r4 = com.google.android.gms.internal.zznh.bu;
        r5 = com.google.android.gms.internal.zzkb.m6350f();
        r4 = r5.m6488a(r4);
        r4 = (java.lang.Integer) r4;
        r4 = r4.intValue();
        r11 = r0.j;
        r5 = r0.p;
        r11 = com.google.android.gms.internal.zzdr.m5886a(r11, r4, r5);
        r5 = java.lang.Long.valueOf(r11);
        r1.f17680m = r5;
        r5 = com.google.android.gms.internal.zznh.bv;
        r8 = com.google.android.gms.internal.zzkb.m6350f();
        r5 = r8.m6488a(r5);
        r5 = (java.lang.Boolean) r5;
        r5 = r5.booleanValue();
        if (r5 == 0) goto L_0x00df;
    L_0x009d:
        r5 = r0.m;
        r8 = r0.k;
        r5 = r5 - r8;
        r11 = (double) r5;
        r5 = r0.p;
        r11 = com.google.android.gms.internal.zzdr.m5886a(r11, r4, r5);
        r5 = java.lang.Long.valueOf(r11);
        r1.f17681n = r5;
        r5 = r0.n;
        r8 = r0.l;
        r5 = r5 - r8;
        r11 = (double) r5;
        r5 = r0.p;
        r11 = com.google.android.gms.internal.zzdr.m5886a(r11, r4, r5);
        r5 = java.lang.Long.valueOf(r11);
        r1.f17682o = r5;
        r5 = r0.k;
        r11 = (double) r5;
        r5 = r0.p;
        r11 = com.google.android.gms.internal.zzdr.m5886a(r11, r4, r5);
        r5 = java.lang.Long.valueOf(r11);
        r1.f17685r = r5;
        r5 = r0.l;
        r11 = (double) r5;
        r5 = r0.p;
        r11 = com.google.android.gms.internal.zzdr.m5886a(r11, r4, r5);
        r5 = java.lang.Long.valueOf(r11);
        r1.f17686s = r5;
    L_0x00df:
        r5 = com.google.android.gms.internal.zznh.bw;
        r8 = com.google.android.gms.internal.zzkb.m6350f();
        r5 = r8.m6488a(r5);
        r5 = (java.lang.Boolean) r5;
        r5 = r5.booleanValue();
        if (r5 == 0) goto L_0x0141;
    L_0x00f1:
        r5 = r0.o;
        if (r5 == 0) goto L_0x0141;
    L_0x00f5:
        r5 = r0.a;
        if (r5 == 0) goto L_0x0141;
    L_0x00f9:
        r5 = r0.k;
        r8 = r0.m;
        r5 = r5 - r8;
        r8 = r0.a;
        r8 = r8.getRawX();
        r5 = r5 + r8;
        r8 = r0.a;
        r8 = r8.getX();
        r5 = r5 - r8;
        r11 = (double) r5;
        r5 = r0.p;
        r11 = com.google.android.gms.internal.zzdr.m5886a(r11, r4, r5);
        r5 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1));
        if (r5 == 0) goto L_0x011d;
    L_0x0117:
        r5 = java.lang.Long.valueOf(r11);
        r1.f17683p = r5;
    L_0x011d:
        r5 = r0.l;
        r8 = r0.n;
        r5 = r5 - r8;
        r8 = r0.a;
        r8 = r8.getRawY();
        r5 = r5 + r8;
        r8 = r0.a;
        r8 = r8.getY();
        r5 = r5 - r8;
        r11 = (double) r5;
        r5 = r0.p;
        r4 = com.google.android.gms.internal.zzdr.m5886a(r11, r4, r5);
        r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r8 == 0) goto L_0x0141;
    L_0x013b:
        r4 = java.lang.Long.valueOf(r4);
        r1.f17684q = r4;
    L_0x0141:
        r4 = 0;
        r5 = r0.a;	 Catch:{ zzdj -> 0x01c8 }
        r5 = r0.mo3495b(r5);	 Catch:{ zzdj -> 0x01c8 }
        r8 = r5.f14291a;	 Catch:{ zzdj -> 0x01c8 }
        r1.f17668a = r8;	 Catch:{ zzdj -> 0x01c8 }
        r8 = r5.f14292b;	 Catch:{ zzdj -> 0x01c8 }
        r1.f17669b = r8;	 Catch:{ zzdj -> 0x01c8 }
        r8 = r5.f14302l;	 Catch:{ zzdj -> 0x01c8 }
        r1.f17687t = r8;	 Catch:{ zzdj -> 0x01c8 }
        r8 = r5.f14303m;	 Catch:{ zzdj -> 0x01c8 }
        r1.f17688u = r8;	 Catch:{ zzdj -> 0x01c8 }
        r8 = r5.f14293c;	 Catch:{ zzdj -> 0x01c8 }
        r1.f17675h = r8;	 Catch:{ zzdj -> 0x01c8 }
        r8 = r0.o;	 Catch:{ zzdj -> 0x01c8 }
        if (r8 == 0) goto L_0x01c8;	 Catch:{ zzdj -> 0x01c8 }
    L_0x0160:
        r8 = r5.f14295e;	 Catch:{ zzdj -> 0x01c8 }
        r1.f17670c = r8;	 Catch:{ zzdj -> 0x01c8 }
        r8 = r5.f14294d;	 Catch:{ zzdj -> 0x01c8 }
        r1.f17672e = r8;	 Catch:{ zzdj -> 0x01c8 }
        r8 = r5.f14296f;	 Catch:{ zzdj -> 0x01c8 }
        r11 = r8.longValue();	 Catch:{ zzdj -> 0x01c8 }
        r8 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1));	 Catch:{ zzdj -> 0x01c8 }
        if (r8 == 0) goto L_0x0174;	 Catch:{ zzdj -> 0x01c8 }
    L_0x0172:
        r8 = r3;	 Catch:{ zzdj -> 0x01c8 }
        goto L_0x0175;	 Catch:{ zzdj -> 0x01c8 }
    L_0x0174:
        r8 = r2;	 Catch:{ zzdj -> 0x01c8 }
    L_0x0175:
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ zzdj -> 0x01c8 }
        r1.f17674g = r8;	 Catch:{ zzdj -> 0x01c8 }
        r11 = r0.d;	 Catch:{ zzdj -> 0x01c8 }
        r8 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1));	 Catch:{ zzdj -> 0x01c8 }
        if (r8 <= 0) goto L_0x01ad;	 Catch:{ zzdj -> 0x01c8 }
    L_0x0181:
        r8 = r0.p;	 Catch:{ zzdj -> 0x01c8 }
        r8 = com.google.android.gms.internal.zzdr.m5891a(r8);	 Catch:{ zzdj -> 0x01c8 }
        if (r8 == 0) goto L_0x0199;	 Catch:{ zzdj -> 0x01c8 }
    L_0x0189:
        r11 = r0.i;	 Catch:{ zzdj -> 0x01c8 }
        r11 = (double) r11;	 Catch:{ zzdj -> 0x01c8 }
        r13 = r0.d;	 Catch:{ zzdj -> 0x01c8 }
        r13 = (double) r13;	 Catch:{ zzdj -> 0x01c8 }
        r11 = r11 / r13;	 Catch:{ zzdj -> 0x01c8 }
        r11 = java.lang.Math.round(r11);	 Catch:{ zzdj -> 0x01c8 }
        r8 = java.lang.Long.valueOf(r11);	 Catch:{ zzdj -> 0x01c8 }
        goto L_0x019a;	 Catch:{ zzdj -> 0x01c8 }
    L_0x0199:
        r8 = r4;	 Catch:{ zzdj -> 0x01c8 }
    L_0x019a:
        r1.f17671d = r8;	 Catch:{ zzdj -> 0x01c8 }
        r11 = r0.h;	 Catch:{ zzdj -> 0x01c8 }
        r11 = (double) r11;	 Catch:{ zzdj -> 0x01c8 }
        r13 = r0.d;	 Catch:{ zzdj -> 0x01c8 }
        r13 = (double) r13;	 Catch:{ zzdj -> 0x01c8 }
        r11 = r11 / r13;	 Catch:{ zzdj -> 0x01c8 }
        r11 = java.lang.Math.round(r11);	 Catch:{ zzdj -> 0x01c8 }
        r8 = java.lang.Long.valueOf(r11);	 Catch:{ zzdj -> 0x01c8 }
        r1.f17673f = r8;	 Catch:{ zzdj -> 0x01c8 }
    L_0x01ad:
        r8 = r5.f14299i;	 Catch:{ zzdj -> 0x01c8 }
        r1.f17677j = r8;	 Catch:{ zzdj -> 0x01c8 }
        r8 = r5.f14300j;	 Catch:{ zzdj -> 0x01c8 }
        r1.f17676i = r8;	 Catch:{ zzdj -> 0x01c8 }
        r5 = r5.f14301k;	 Catch:{ zzdj -> 0x01c8 }
        r11 = r5.longValue();	 Catch:{ zzdj -> 0x01c8 }
        r5 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1));	 Catch:{ zzdj -> 0x01c8 }
        if (r5 == 0) goto L_0x01c1;	 Catch:{ zzdj -> 0x01c8 }
    L_0x01bf:
        r5 = r3;	 Catch:{ zzdj -> 0x01c8 }
        goto L_0x01c2;	 Catch:{ zzdj -> 0x01c8 }
    L_0x01c1:
        r5 = r2;	 Catch:{ zzdj -> 0x01c8 }
    L_0x01c2:
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ zzdj -> 0x01c8 }
        r1.f17678k = r5;	 Catch:{ zzdj -> 0x01c8 }
    L_0x01c8:
        r11 = r0.g;
        r5 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1));
        if (r5 <= 0) goto L_0x01d6;
    L_0x01ce:
        r11 = r0.g;
        r5 = java.lang.Long.valueOf(r11);
        r1.f17679l = r5;
    L_0x01d6:
        r9.f17627K = r1;
        r11 = r0.c;
        r1 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1));
        if (r1 <= 0) goto L_0x01e6;
    L_0x01de:
        r11 = r0.c;
        r1 = java.lang.Long.valueOf(r11);
        r9.f17665y = r1;
    L_0x01e6:
        r11 = r0.d;
        r1 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1));
        if (r1 <= 0) goto L_0x01f4;
    L_0x01ec:
        r11 = r0.d;
        r1 = java.lang.Long.valueOf(r11);
        r9.f17664x = r1;
    L_0x01f4:
        r11 = r0.e;
        r1 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1));
        if (r1 <= 0) goto L_0x0202;
    L_0x01fa:
        r11 = r0.e;
        r1 = java.lang.Long.valueOf(r11);
        r9.f17663w = r1;
    L_0x0202:
        r11 = r0.f;
        r1 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1));
        if (r1 <= 0) goto L_0x0210;
    L_0x0208:
        r5 = r0.f;
        r1 = java.lang.Long.valueOf(r5);
        r9.f17666z = r1;
    L_0x0210:
        r1 = r0.b;	 Catch:{ zzdj -> 0x0243 }
        r1 = r1.size();	 Catch:{ zzdj -> 0x0243 }
        r1 = r1 - r3;	 Catch:{ zzdj -> 0x0243 }
        if (r1 <= 0) goto L_0x0245;	 Catch:{ zzdj -> 0x0243 }
    L_0x0219:
        r3 = new com.google.android.gms.internal.zzba[r1];	 Catch:{ zzdj -> 0x0243 }
        r9.f17628L = r3;	 Catch:{ zzdj -> 0x0243 }
    L_0x021d:
        if (r2 >= r1) goto L_0x0245;	 Catch:{ zzdj -> 0x0243 }
    L_0x021f:
        r3 = f18019t;	 Catch:{ zzdj -> 0x0243 }
        r5 = r0.b;	 Catch:{ zzdj -> 0x0243 }
        r5 = r5.get(r2);	 Catch:{ zzdj -> 0x0243 }
        r5 = (android.view.MotionEvent) r5;	 Catch:{ zzdj -> 0x0243 }
        r6 = r0.p;	 Catch:{ zzdj -> 0x0243 }
        r3 = m18646a(r3, r5, r6);	 Catch:{ zzdj -> 0x0243 }
        r5 = new com.google.android.gms.internal.zzba;	 Catch:{ zzdj -> 0x0243 }
        r5.<init>();	 Catch:{ zzdj -> 0x0243 }
        r6 = r3.f14291a;	 Catch:{ zzdj -> 0x0243 }
        r5.f17668a = r6;	 Catch:{ zzdj -> 0x0243 }
        r3 = r3.f14292b;	 Catch:{ zzdj -> 0x0243 }
        r5.f17669b = r3;	 Catch:{ zzdj -> 0x0243 }
        r3 = r9.f17628L;	 Catch:{ zzdj -> 0x0243 }
        r3[r2] = r5;	 Catch:{ zzdj -> 0x0243 }
        r2 = r2 + 1;
        goto L_0x021d;
    L_0x0243:
        r9.f17628L = r4;
    L_0x0245:
        r11 = new java.util.ArrayList;
        r11.<init>();
        r1 = r10.f7217b;
        if (r1 == 0) goto L_0x0374;
    L_0x024e:
        r12 = r10.m5851c();
        r1 = new com.google.android.gms.internal.zzee;
        r1.<init>(r10, r9);
        r11.add(r1);
        r7 = new com.google.android.gms.internal.zzeh;
        r3 = "4w5pMN4cUsuXvD3CJ7PKPSwMmWPClIaNSjeM6jtHahV40Q7EiLps1VIbOcEaCSp4";
        r4 = "5XuSFVTSxDkE27CIZHrBIXal5K53Dv1J/UFXKGBFAXY=";
        r1 = r7;
        r2 = r10;
        r5 = r9;
        r6 = r12;
        r1.<init>(r2, r3, r4, r5, r6);
        r11.add(r7);
        r13 = new com.google.android.gms.internal.zzec;
        r3 = "HYkEKMk8dvMdQrlbFR00sh73U7jSOxxrrxd0BhHmEXYlIfEqe1EzBQsw2kucbDs8";
        r4 = "puD1TaAJX/qcP/8PMgKROAswM+eaSDu4sTUEXpqs2fU=";
        r6 = f18021v;
        r1 = r13;
        r8 = r12;
        r1.<init>(r2, r3, r4, r5, r6, r8);
        r11.add(r13);
        r7 = new com.google.android.gms.internal.zzeb;
        r3 = "igTfSDGbP3Q2KSYfnqAL0vFW/zSSX6v+f+5s7NdwuKQgo6M7dQVerLATgNETrLAr";
        r4 = "Wz4eX479PrQ8rGu0gkJoEYqOJ2Dr8sAHE85KoBBz7s4=";
        r1 = r7;
        r6 = r12;
        r1.<init>(r2, r3, r4, r5, r6);
        r11.add(r7);
        r7 = new com.google.android.gms.internal.zzeg;
        r3 = "ZsnUMRH5gS7aUE0TqnSYS8JWwJCKCL7bH7XFSqbI4dWEEyg2o14AuyyBvtsnwc4D";
        r4 = "SFchXCfZXuuDAwXfTJDosXRUHrZZ0v26SJChYX3rL/o=";
        r1 = r7;
        r1.<init>(r2, r3, r4, r5, r6);
        r11.add(r7);
        r7 = new com.google.android.gms.internal.zzei;
        r3 = "lMH30ZU/uP5xaOsdIj/K3/wZfVr7hnOzUHjpO1NWhTJQvW+gY38/OvCWA8Ap4ZOf";
        r4 = "FCjXGcebz7gnog9LMAWyd/isayIV3I84uK1cUtHZ2fI=";
        r1 = r7;
        r1.<init>(r2, r3, r4, r5, r6);
        r11.add(r7);
        r7 = new com.google.android.gms.internal.zzef;
        r3 = "BiRNVQ0aQHyQJTXKNLbpSFJJy6+rG5ICwTiWxRhS6qdZjM6S9BBOaVfdO1b0Kd8E";
        r4 = "z9Ycw/7CJTzBzg6MPXNZ2oLMXcxWzT8qsF0ig0ITUxc=";
        r1 = r7;
        r1.<init>(r2, r3, r4, r5, r6);
        r11.add(r7);
        r7 = new com.google.android.gms.internal.zzea;
        r3 = "2GI4cQuNT2V9TGPC/Z2McvgqRAU80qquJKbm0BMTxLR8WwMEgJwPEKdGCxKNxeUN";
        r4 = "1Kj5K8xXQ2YA9zbG2Rm9FzZtUD9R2drVmZXzLVF7uLA=";
        r1 = r7;
        r1.<init>(r2, r3, r4, r5, r6);
        r11.add(r7);
        r7 = new com.google.android.gms.internal.zzep;
        r3 = "oWVj3eW9lsJMixyFq7g0kyuRqYP087mdDp4dCL3paE/7Ut3Ewp3IcEq6P10MPRyy";
        r4 = "siNRngHYHRLjixmg2PEX5OdKhRHe1h8DNRpJp4wC0pk=";
        r1 = r7;
        r1.<init>(r2, r3, r4, r5, r6);
        r11.add(r7);
        r7 = new com.google.android.gms.internal.zzdx;
        r3 = "yATd8qneW4MlwQIx8jIN6cfiWJ28/zOw6vW7xs0IWvNvim2a85v5X4ZiVD1KK9hX";
        r4 = "0wjmexcQnona3bxO7Nd7FrKMEEoBhOp7s6KivBhMQKU=";
        r1 = r7;
        r1.<init>(r2, r3, r4, r5, r6);
        r11.add(r7);
        r7 = new com.google.android.gms.internal.zzem;
        r3 = "2glehmg5UKxyaNPdnG06BLa5QbEzBADKVm3lYiT3+JTkguRZEzOA9BDahqC4W8ki";
        r4 = "wM87KVhGHShMaqkZWTxt04VnU6kJHrMxqQyksEW6glI=";
        r1 = r7;
        r1.<init>(r2, r3, r4, r5, r6);
        r11.add(r7);
        r8 = new com.google.android.gms.internal.zzel;
        r3 = "hoZ4RlhPWT5MX/I+m/lUD5aYJ9aPmEb2eUGLaeSBLBDs9eDpXoNNJPm6j1dXVkvA";
        r4 = "Z7StFiuQ59x4y88apmlBJn3lPoWOEnuqoEhP2AVUL8A=";
        r1 = new java.lang.Throwable;
        r1.<init>();
        r7 = r1.getStackTrace();
        r1 = r8;
        r1.<init>(r2, r3, r4, r5, r6, r7);
        r11.add(r8);
        r8 = new com.google.android.gms.internal.zzeq;
        r3 = "peD/v7hHRn46N2uI0dQKpTtMr7rKDQ+Rzb4yluPWMw4TUUwj2SFV9GkdTp0kog66";
        r4 = "XxfDY0AzBkt4iSC5Sim2fww10jQc1evowDldz5+caY4=";
        r1 = r8;
        r7 = r17;
        r1.<init>(r2, r3, r4, r5, r6, r7);
        r11.add(r8);
        r1 = com.google.android.gms.internal.zznh.br;
        r2 = com.google.android.gms.internal.zzkb.m6350f();
        r1 = r2.m6488a(r1);
        r1 = (java.lang.Boolean) r1;
        r1 = r1.booleanValue();
        if (r1 == 0) goto L_0x032a;
    L_0x031a:
        r7 = new com.google.android.gms.internal.zzek;
        r3 = "cINMMi7uKicDN2DHSf1rHdgax7DU+CM2mIG3cRQw3SI0nkdhPwdVz1PCbewJpJoO";
        r4 = "VWQmr3p+wsDJ15H20t2tLb975qLEArv8gtHgpBQKEOE=";
        r1 = r7;
        r2 = r10;
        r5 = r9;
        r6 = r12;
        r1.<init>(r2, r3, r4, r5, r6);
        r11.add(r7);
    L_0x032a:
        r1 = com.google.android.gms.internal.zznh.bs;
        r2 = com.google.android.gms.internal.zzkb.m6350f();
        r1 = r2.m6488a(r1);
        r1 = (java.lang.Boolean) r1;
        r1 = r1.booleanValue();
        if (r1 == 0) goto L_0x0350;
    L_0x033c:
        r13 = new com.google.android.gms.internal.zzdw;
        r3 = "6qQh+8GAMu6fM86JkRzoeHiiHD67+MgHO4xhhwcbyPT7CQmAN57q8YytJQRqDjU5";
        r4 = "Qrc1hPZgr+QjlmQtpbdJO1QCxqr2PdTRKIIDeDNdHp8=";
        r1 = r13;
        r2 = r10;
        r5 = r9;
        r6 = r12;
        r7 = r17;
        r8 = r18;
        r1.<init>(r2, r3, r4, r5, r6, r7, r8);
        r11.add(r13);
    L_0x0350:
        r1 = com.google.android.gms.internal.zznh.bt;
        r2 = com.google.android.gms.internal.zzkb.m6350f();
        r1 = r2.m6488a(r1);
        r1 = (java.lang.Boolean) r1;
        r1 = r1.booleanValue();
        if (r1 == 0) goto L_0x0374;
    L_0x0362:
        r8 = new com.google.android.gms.internal.zzen;
        r3 = "HBbZPURZUWU/TDYIx99LmOTdgpFP2mdidp6Zk4sZdEVCGaQNYtmNlQBCP3rgXOne";
        r4 = "pdXBsPFh4N2rQp3r0gjTSQiWtas1GOGaKulNSciQTj0=";
        r7 = r0.f18026z;
        r1 = r8;
        r2 = r10;
        r5 = r9;
        r6 = r12;
        r1.<init>(r2, r3, r4, r5, r6, r7);
        r11.add(r8);
    L_0x0374:
        m18648a(r11);
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzct.a(android.content.Context, android.view.View, android.app.Activity):com.google.android.gms.internal.zzaz");
    }

    protected List<Callable<Void>> mo4024a(zzdm com_google_android_gms_internal_zzdm, zzaz com_google_android_gms_internal_zzaz, zzaw com_google_android_gms_internal_zzaw) {
        int c = com_google_android_gms_internal_zzdm.m5851c();
        List<Callable<Void>> arrayList = new ArrayList();
        if (com_google_android_gms_internal_zzdm.f7226k) {
            zzdm com_google_android_gms_internal_zzdm2 = com_google_android_gms_internal_zzdm;
            zzaz com_google_android_gms_internal_zzaz2 = com_google_android_gms_internal_zzaz;
            arrayList.add(new zzdz(com_google_android_gms_internal_zzdm2, "DGPkHpN6F5DQjFiQDfOpLUfwAMooIPhSFT4YA2aSEj+k+u5Kt4pQoimNrK0aCsHP", "V/2NrZQU5cdFMpqYa0Q9vKRizJ0aHS7vWXQS8vp0qlI=", com_google_android_gms_internal_zzaz2, c, com_google_android_gms_internal_zzaw));
            arrayList.add(new zzec(com_google_android_gms_internal_zzdm2, "HYkEKMk8dvMdQrlbFR00sh73U7jSOxxrrxd0BhHmEXYlIfEqe1EzBQsw2kucbDs8", "puD1TaAJX/qcP/8PMgKROAswM+eaSDu4sTUEXpqs2fU=", com_google_android_gms_internal_zzaz2, f18021v, c));
            int i = c;
            arrayList.add(new zzeh(com_google_android_gms_internal_zzdm2, "4w5pMN4cUsuXvD3CJ7PKPSwMmWPClIaNSjeM6jtHahV40Q7EiLps1VIbOcEaCSp4", "5XuSFVTSxDkE27CIZHrBIXal5K53Dv1J/UFXKGBFAXY=", com_google_android_gms_internal_zzaz2, i));
            arrayList.add(new zzej(com_google_android_gms_internal_zzdm2, "notQcG55r2oh2A1cS/dLfKg9hawk3H86BF0iXzU7AAnhYpfHWl9mq3lZzdkAltxm", "U9ntf5BvZUTabci6TosC4bQNHZ+DOrzvRmpSy4CzkoQ=", com_google_android_gms_internal_zzaz2, i));
            arrayList.add(new zzeo(com_google_android_gms_internal_zzdm2, "8Hx2xRqW2QZDPiXj7EKgQgzecg5taNOrZe4YkZ9zi7FcQAOy1BO0rYbAdBI9x6Pm", "nJw4XP5tQfSQ6wm+0x6UMq5j2kNiUh+TXa92gyyhaOo=", com_google_android_gms_internal_zzaz2, i));
            arrayList.add(new zzdy(com_google_android_gms_internal_zzdm2, "yzGxsS8IwfgINPYaD3TFRjRVH+0Pq4QvVGq15MBf/opCBPnlCr4QHvEcReKXEMs7", "kMEgIGkHy2R1ROJUgud//6gDu/wM35rLhA6gUKrjKq0=", com_google_android_gms_internal_zzaz2, i));
            arrayList.add(new zzea(com_google_android_gms_internal_zzdm2, "2GI4cQuNT2V9TGPC/Z2McvgqRAU80qquJKbm0BMTxLR8WwMEgJwPEKdGCxKNxeUN", "1Kj5K8xXQ2YA9zbG2Rm9FzZtUD9R2drVmZXzLVF7uLA=", com_google_android_gms_internal_zzaz2, i));
            arrayList.add(new zzeg(com_google_android_gms_internal_zzdm2, "ZsnUMRH5gS7aUE0TqnSYS8JWwJCKCL7bH7XFSqbI4dWEEyg2o14AuyyBvtsnwc4D", "SFchXCfZXuuDAwXfTJDosXRUHrZZ0v26SJChYX3rL/o=", com_google_android_gms_internal_zzaz2, i));
            arrayList.add(new zzei(com_google_android_gms_internal_zzdm2, "lMH30ZU/uP5xaOsdIj/K3/wZfVr7hnOzUHjpO1NWhTJQvW+gY38/OvCWA8Ap4ZOf", "FCjXGcebz7gnog9LMAWyd/isayIV3I84uK1cUtHZ2fI=", com_google_android_gms_internal_zzaz2, i));
            arrayList.add(new zzeb(com_google_android_gms_internal_zzdm2, "igTfSDGbP3Q2KSYfnqAL0vFW/zSSX6v+f+5s7NdwuKQgo6M7dQVerLATgNETrLAr", "Wz4eX479PrQ8rGu0gkJoEYqOJ2Dr8sAHE85KoBBz7s4=", com_google_android_gms_internal_zzaz2, i));
            arrayList.add(new zzef(com_google_android_gms_internal_zzdm2, "BiRNVQ0aQHyQJTXKNLbpSFJJy6+rG5ICwTiWxRhS6qdZjM6S9BBOaVfdO1b0Kd8E", "z9Ycw/7CJTzBzg6MPXNZ2oLMXcxWzT8qsF0ig0ITUxc=", com_google_android_gms_internal_zzaz2, i));
            arrayList.add(new zzep(com_google_android_gms_internal_zzdm2, "oWVj3eW9lsJMixyFq7g0kyuRqYP087mdDp4dCL3paE/7Ut3Ewp3IcEq6P10MPRyy", "siNRngHYHRLjixmg2PEX5OdKhRHe1h8DNRpJp4wC0pk=", com_google_android_gms_internal_zzaz2, i));
            arrayList.add(new zzdx(com_google_android_gms_internal_zzdm2, "yATd8qneW4MlwQIx8jIN6cfiWJ28/zOw6vW7xs0IWvNvim2a85v5X4ZiVD1KK9hX", "0wjmexcQnona3bxO7Nd7FrKMEEoBhOp7s6KivBhMQKU=", com_google_android_gms_internal_zzaz2, i));
            arrayList.add(new zzem(com_google_android_gms_internal_zzdm2, "2glehmg5UKxyaNPdnG06BLa5QbEzBADKVm3lYiT3+JTkguRZEzOA9BDahqC4W8ki", "wM87KVhGHShMaqkZWTxt04VnU6kJHrMxqQyksEW6glI=", com_google_android_gms_internal_zzaz2, i));
            if (((Boolean) zzkb.m6350f().m6488a(zznh.br)).booleanValue() != null) {
                arrayList.add(new zzek(com_google_android_gms_internal_zzdm, "cINMMi7uKicDN2DHSf1rHdgax7DU+CM2mIG3cRQw3SI0nkdhPwdVz1PCbewJpJoO", "VWQmr3p+wsDJ15H20t2tLb975qLEArv8gtHgpBQKEOE=", com_google_android_gms_internal_zzaz, c));
            }
            return arrayList;
        }
        com_google_android_gms_internal_zzaz.f17651k = Long.valueOf(16384);
        return arrayList;
    }

    private static void m18648a(List<Callable<Void>> list) {
        if (f18019t != null) {
            ExecutorService executorService = f18019t.f7217b;
            if (!(executorService == null || list.isEmpty())) {
                try {
                    executorService.invokeAll(list, ((Long) zzkb.m6350f().m6488a(zznh.bp)).longValue(), TimeUnit.MILLISECONDS);
                } catch (Throwable e) {
                    Log.d(f18018s, String.format("class methods got exception: %s", new Object[]{zzdr.m5890a(e)}));
                }
            }
        }
    }
}
