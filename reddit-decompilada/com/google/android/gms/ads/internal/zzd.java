package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.internal.zzaau;
import com.google.android.gms.internal.zzabo;
import com.google.android.gms.internal.zzafo;
import com.google.android.gms.internal.zzafq;
import com.google.android.gms.internal.zzafr;
import com.google.android.gms.internal.zzafs;
import com.google.android.gms.internal.zzafx;
import com.google.android.gms.internal.zzagb;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzhk;
import com.google.android.gms.internal.zziu.zza.zzb;
import com.google.android.gms.internal.zzix;
import com.google.android.gms.internal.zzjj;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zznu;
import com.google.android.gms.internal.zzqm;
import com.google.android.gms.internal.zzqw;
import com.google.android.gms.internal.zzuj;
import com.google.android.gms.internal.zzuq;
import com.google.android.gms.internal.zzux;
import com.google.android.gms.internal.zzzv;
import com.google.android.gms.internal.zzzy;
import com.instabug.library.model.State;

@zzzv
public abstract class zzd extends zza implements zzn, zzbl, zzuj {
    private transient boolean f19077i;
    protected final zzux f19078m;

    public zzd(Context context, zzjn com_google_android_gms_internal_zzjn, String str, zzux com_google_android_gms_internal_zzux, zzakd com_google_android_gms_internal_zzakd, zzv com_google_android_gms_ads_internal_zzv) {
        this(new zzbt(context, com_google_android_gms_internal_zzjn, str, com_google_android_gms_internal_zzakd), com_google_android_gms_internal_zzux, com_google_android_gms_ads_internal_zzv);
    }

    private zzd(zzbt com_google_android_gms_ads_internal_zzbt, zzux com_google_android_gms_internal_zzux, zzv com_google_android_gms_ads_internal_zzv) {
        super(com_google_android_gms_ads_internal_zzbt, com_google_android_gms_ads_internal_zzv);
        this.f19078m = com_google_android_gms_internal_zzux;
        this.f19077i = false;
    }

    private final com.google.android.gms.internal.zzaau m20140a(com.google.android.gms.internal.zzjj r68, android.os.Bundle r69, com.google.android.gms.internal.zzafs r70, int r71) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Not initialized variable reg: 54, insn: 0x025e: MOVE  (r2 ?[OBJECT, ARRAY]) = (r54 ?[OBJECT, ARRAY]), block:B:89:0x0240, method: com.google.android.gms.ads.internal.zzd.a(com.google.android.gms.internal.zzjj, android.os.Bundle, com.google.android.gms.internal.zzafs, int):com.google.android.gms.internal.zzaau
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:168)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVar(SSATransform.java:197)
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:132)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
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
        r67 = this;
        r1 = r67;
        r4 = r68;
        r2 = r70;
        r3 = r1.e;
        r3 = r3.f5600c;
        r7 = r3.getApplicationInfo();
        r5 = 0;
        r6 = r1.e;	 Catch:{ NameNotFoundException -> 0x001f }
        r6 = r6.f5600c;	 Catch:{ NameNotFoundException -> 0x001f }
        r6 = com.google.android.gms.internal.zzbhf.m5574a(r6);	 Catch:{ NameNotFoundException -> 0x001f }
        r8 = r7.packageName;	 Catch:{ NameNotFoundException -> 0x001f }
        r6 = r6.m5572b(r8, r5);	 Catch:{ NameNotFoundException -> 0x001f }
        r8 = r6;
        goto L_0x0020;
    L_0x001f:
        r8 = 0;
    L_0x0020:
        r6 = r1.e;
        r6 = r6.f5600c;
        r6 = r6.getResources();
        r6 = r6.getDisplayMetrics();
        r9 = r1.e;
        r9 = r9.f5603f;
        r10 = 2;
        r11 = 1;
        if (r9 == 0) goto L_0x0098;
    L_0x0034:
        r9 = r1.e;
        r9 = r9.f5603f;
        r9 = r9.getParent();
        if (r9 == 0) goto L_0x0098;
    L_0x003e:
        r9 = new int[r10];
        r12 = r1.e;
        r12 = r12.f5603f;
        r12.getLocationOnScreen(r9);
        r12 = r9[r5];
        r9 = r9[r11];
        r13 = r1.e;
        r13 = r13.f5603f;
        r13 = r13.getWidth();
        r14 = r1.e;
        r14 = r14.f5603f;
        r14 = r14.getHeight();
        r15 = r1.e;
        r15 = r15.f5603f;
        r15 = r15.isShown();
        if (r15 == 0) goto L_0x0077;
    L_0x0065:
        r15 = r12 + r13;
        if (r15 <= 0) goto L_0x0077;
    L_0x0069:
        r15 = r9 + r14;
        if (r15 <= 0) goto L_0x0077;
    L_0x006d:
        r15 = r6.widthPixels;
        if (r12 > r15) goto L_0x0077;
    L_0x0071:
        r15 = r6.heightPixels;
        if (r9 > r15) goto L_0x0077;
    L_0x0075:
        r15 = r11;
        goto L_0x0078;
    L_0x0077:
        r15 = r5;
    L_0x0078:
        r3 = new android.os.Bundle;
        r5 = 5;
        r3.<init>(r5);
        r5 = "x";
        r3.putInt(r5, r12);
        r5 = "y";
        r3.putInt(r5, r9);
        r5 = "width";
        r3.putInt(r5, r13);
        r5 = "height";
        r3.putInt(r5, r14);
        r5 = "visible";
        r3.putInt(r5, r15);
        goto L_0x0099;
    L_0x0098:
        r3 = 0;
    L_0x0099:
        r5 = com.google.android.gms.ads.internal.zzbs.m4490i();
        r9 = r5.m13253c();
        r5 = r1.e;
        r12 = new com.google.android.gms.internal.zzafq;
        r13 = r1.e;
        r13 = r13.f5599b;
        r12.<init>(r9, r13);
        r5.f5609l = r12;
        r5 = r1.e;
        r5 = r5.f5609l;
        r12 = r5.f6326c;
        monitor-enter(r12);
        r13 = android.os.SystemClock.elapsedRealtime();	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r5.f6332i = r13;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r13 = r5.f6324a;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r13 = r13.m13255d();	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r14 = r5.f6332i;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r5 = r13.f6357f;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        monitor-enter(r5);	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r11 = com.google.android.gms.ads.internal.zzbs.m4490i();	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r16 = r11.m13263k();	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r11 = com.google.android.gms.ads.internal.zzbs.m4492k();	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r10 = r11.mo1632a();	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r54 = r6;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r53 = r7;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r6 = r13.f6353b;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r18 = -1;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r6 = (r6 > r18 ? 1 : (r6 == r18 ? 0 : -1));	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        if (r6 != 0) goto L_0x0111;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
    L_0x00e2:
        r6 = r10 - r16;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r55 = r3;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r3 = com.google.android.gms.internal.zznh.aw;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r56 = r8;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r8 = com.google.android.gms.internal.zzkb.m6350f();	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r3 = r8.m6488a(r3);	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r3 = (java.lang.Long) r3;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r16 = r3.longValue();	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r3 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1));	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        if (r3 <= 0) goto L_0x0100;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
    L_0x00fc:
        r3 = -1;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r13.f6355d = r3;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        goto L_0x010a;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
    L_0x0100:
        r3 = com.google.android.gms.ads.internal.zzbs.m4490i();	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r3 = r3.m13266n();	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r13.f6355d = r3;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
    L_0x010a:
        r13.f6353b = r14;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r6 = r13.f6353b;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r13.f6352a = r6;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        goto L_0x0117;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
    L_0x0111:
        r55 = r3;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r56 = r8;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r13.f6352a = r14;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
    L_0x0117:
        r6 = 0;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        if (r4 == 0) goto L_0x012e;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
    L_0x011b:
        r3 = r4.f18136c;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        if (r3 == 0) goto L_0x012e;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
    L_0x011f:
        r3 = r4.f18136c;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r8 = "gw";	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r14 = 2;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r3 = r3.getInt(r8, r14);	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r8 = 1;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        if (r3 != r8) goto L_0x012e;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
    L_0x012b:
        monitor-exit(r5);	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r8 = 1;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        goto L_0x0153;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
    L_0x012e:
        r3 = r13.f6354c;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r8 = 1;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r3 = r3 + r8;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r13.f6354c = r3;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r3 = r13.f6355d;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r3 = r3 + r8;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r13.f6355d = r3;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r3 = r13.f6355d;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        if (r3 != 0) goto L_0x0147;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
    L_0x013d:
        r13.f6356e = r6;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r3 = com.google.android.gms.ads.internal.zzbs.m4490i();	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r3.m13239a(r10);	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        goto L_0x0152;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
    L_0x0147:
        r3 = com.google.android.gms.ads.internal.zzbs.m4490i();	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r14 = r3.m13264l();	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r10 = r10 - r14;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r13.f6356e = r10;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
    L_0x0152:
        monitor-exit(r5);	 Catch:{ all -> 0x03b9, all -> 0x03bd }
    L_0x0153:
        monitor-exit(r12);	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        com.google.android.gms.ads.internal.zzbs.m4486e();
        r3 = r1.e;
        r3 = r3.f5600c;
        r5 = r1.e;
        r5 = r5.f5603f;
        r10 = r1.e;
        r10 = r10.f5606i;
        r20 = com.google.android.gms.internal.zzahn.m5158a(r3, r5, r10);
        r3 = r1.e;
        r3 = r3.f5613p;
        if (r3 == 0) goto L_0x017d;
    L_0x016d:
        r3 = r1.e;	 Catch:{ RemoteException -> 0x0178 }
        r3 = r3.f5613p;	 Catch:{ RemoteException -> 0x0178 }
        r10 = r3.mo2029a();	 Catch:{ RemoteException -> 0x0178 }
        r21 = r10;
        goto L_0x017f;
    L_0x0178:
        r3 = "Cannot get correlation id, default to 0.";
        com.google.android.gms.internal.zzakb.m5371e(r3);
    L_0x017d:
        r21 = r6;
    L_0x017f:
        r3 = java.util.UUID.randomUUID();
        r23 = r3.toString();
        r3 = com.google.android.gms.ads.internal.zzbs.m4490i();
        r5 = r1.e;
        r5 = r5.f5600c;
        r12 = r3.m13235a(r5, r1, r9);
        r14 = new java.util.ArrayList;
        r14.<init>();
        r15 = new java.util.ArrayList;
        r15.<init>();
        r3 = 0;
    L_0x019e:
        r5 = r1.e;
        r5 = r5.f5617t;
        r5 = r5.size();
        if (r3 >= r5) goto L_0x01cf;
    L_0x01a8:
        r5 = r1.e;
        r5 = r5.f5617t;
        r5 = r5.m1053b(r3);
        r5 = (java.lang.String) r5;
        r14.add(r5);
        r6 = r1.e;
        r6 = r6.f5616s;
        r6 = r6.containsKey(r5);
        if (r6 == 0) goto L_0x01cc;
    L_0x01bf:
        r6 = r1.e;
        r6 = r6.f5616s;
        r6 = r6.get(r5);
        if (r6 == 0) goto L_0x01cc;
    L_0x01c9:
        r15.add(r5);
    L_0x01cc:
        r3 = r3 + 1;
        goto L_0x019e;
    L_0x01cf:
        r3 = new com.google.android.gms.ads.internal.zze;
        r3.<init>(r1);
        r5 = com.google.android.gms.internal.zzahh.f6369a;
        r34 = com.google.android.gms.internal.zzahh.m5149a(r5, r3);
        r3 = new com.google.android.gms.ads.internal.zzf;
        r3.<init>(r1);
        r5 = com.google.android.gms.internal.zzahh.f6369a;
        r44 = com.google.android.gms.internal.zzahh.m5149a(r5, r3);
        if (r2 == 0) goto L_0x01ec;
    L_0x01e7:
        r2 = r2.f6341d;
        r35 = r2;
        goto L_0x01ee;
    L_0x01ec:
        r35 = 0;
    L_0x01ee:
        r2 = r1.e;
        r2 = r2.f5586C;
        if (r2 == 0) goto L_0x023c;
    L_0x01f4:
        r2 = r1.e;
        r2 = r2.f5586C;
        r2 = r2.size();
        if (r2 <= 0) goto L_0x023c;
    L_0x01fe:
        if (r56 == 0) goto L_0x0205;
    L_0x0200:
        r10 = r56;
        r5 = r10.versionCode;
        goto L_0x0208;
    L_0x0205:
        r10 = r56;
        r5 = 0;
    L_0x0208:
        r2 = com.google.android.gms.ads.internal.zzbs.m4490i();
        r2 = r2.m13265m();
        if (r5 <= r2) goto L_0x0221;
    L_0x0212:
        r2 = com.google.android.gms.ads.internal.zzbs.m4490i();
        r2.m13269q();
        r2 = com.google.android.gms.ads.internal.zzbs.m4490i();
        r2.m13238a(r5);
        goto L_0x023e;
    L_0x0221:
        r2 = com.google.android.gms.ads.internal.zzbs.m4490i();
        r2 = r2.m13268p();
        if (r2 == 0) goto L_0x023e;
    L_0x022b:
        r3 = r1.e;
        r3 = r3.f5599b;
        r2 = r2.optJSONArray(r3);
        if (r2 == 0) goto L_0x023e;
    L_0x0235:
        r2 = r2.toString();
        r46 = r2;
        goto L_0x0240;
    L_0x023c:
        r10 = r56;
    L_0x023e:
        r46 = 0;
    L_0x0240:
        r52 = new com.google.android.gms.internal.zzaau;
        r2 = r1.e;
        r5 = r2.f5606i;
        r2 = r1.e;
        r6 = r2.f5599b;
        r11 = com.google.android.gms.internal.zzkb.m6347c();
        r2 = r1.e;
        r13 = r2.f5602e;
        r2 = r1.e;
        r7 = r2.f5586C;
        r2 = com.google.android.gms.ads.internal.zzbs.m4490i();
        r16 = r2.m13258f();
        r2 = r54;
        r3 = r2.widthPixels;
        r57 = r15;
        r15 = r2.heightPixels;
        r2 = r2.density;
        r24 = com.google.android.gms.internal.zznh.m6489a();
        r8 = r1.e;
        r8 = r8.f5598a;
        r58 = r2;
        r2 = r1.e;
        r2 = r2.f5618u;
        r59 = r2;
        r2 = r1.e;
        r60 = r3;
        r3 = r2.f5592I;
        if (r3 == 0) goto L_0x0284;
    L_0x0280:
        r3 = r2.f5593J;
        if (r3 != 0) goto L_0x02a0;
    L_0x0284:
        r3 = r2.f5592I;
        if (r3 == 0) goto L_0x0292;
    L_0x0288:
        r2 = r2.f5594K;
        if (r2 == 0) goto L_0x028f;
    L_0x028c:
        r2 = "top-scrollable";
        goto L_0x02a2;
    L_0x028f:
        r2 = "top-locked";
        goto L_0x02a2;
    L_0x0292:
        r3 = r2.f5593J;
        if (r3 == 0) goto L_0x02a0;
    L_0x0296:
        r2 = r2.f5594K;
        if (r2 == 0) goto L_0x029d;
    L_0x029a:
        r2 = "bottom-scrollable";
        goto L_0x02a2;
    L_0x029d:
        r2 = "bottom-locked";
        goto L_0x02a2;
    L_0x02a0:
        r2 = "";
    L_0x02a2:
        r27 = r2;
        com.google.android.gms.ads.internal.zzbs.m4486e();
        r28 = com.google.android.gms.internal.zzahn.m5197c();
        com.google.android.gms.ads.internal.zzbs.m4486e();
        r29 = com.google.android.gms.internal.zzahn.m5205d();
        com.google.android.gms.ads.internal.zzbs.m4486e();
        r2 = r1.e;
        r2 = r2.f5600c;
        r30 = com.google.android.gms.internal.zzahn.m5218j(r2);
        com.google.android.gms.ads.internal.zzbs.m4486e();
        r2 = r1.e;
        r2 = r2.f5603f;
        r31 = com.google.android.gms.internal.zzahn.m5203d(r2);
        r2 = r1.e;
        r2 = r2.f5600c;
        r3 = r2 instanceof android.app.Activity;
        r2 = com.google.android.gms.ads.internal.zzbs.m4490i();
        r33 = r2.m13262j();
        r2 = com.google.android.gms.ads.internal.zzbs.m4490i();
        r2 = r2.f14078g;
        r2.m5114a();
        r2 = r2.f6345a;
        r61 = r3;
        r3 = com.google.android.gms.internal.zzafw.f6349b;
        if (r2 != r3) goto L_0x02ea;
    L_0x02e7:
        r36 = 1;
        goto L_0x02ec;
    L_0x02ea:
        r36 = 0;
    L_0x02ec:
        r2 = com.google.android.gms.ads.internal.zzbs.m4505x();
        r2 = r2.f6590a;
        r37 = r2.size();
        com.google.android.gms.ads.internal.zzbs.m4486e();
        r38 = com.google.android.gms.internal.zzahn.m5207e();
        r2 = com.google.android.gms.ads.internal.zzbs.m4495n();
        r39 = r2.m5280a();
        r2 = r1.e;
        r3 = r2.f5620w;
        r2 = com.google.android.gms.ads.internal.zzbs.m4495n();
        r41 = r2.m5283b();
        r2 = com.google.android.gms.internal.zztk.m6655a();
        r62 = r15;
        r15 = new android.os.Bundle;
        r15.<init>();
        r63 = r3;
        r3 = "ipl";
        r64 = r7;
        r7 = r2.f8020a;
        r15.putInt(r3, r7);
        r3 = "ipds";
        r7 = r2.f8021b;
        r15.putInt(r3, r7);
        r3 = "ipde";
        r7 = r2.f8022c;
        r15.putInt(r3, r7);
        r3 = "iph";
        r7 = r2.f8023d;
        r15.putInt(r3, r7);
        r3 = "ipm";
        r2 = r2.f8024e;
        r15.putInt(r3, r2);
        com.google.android.gms.ads.internal.zzbs.m4490i();
        r2 = r1.e;
        r2 = r2.f5600c;
        r3 = r1.e;
        r3 = r3.f5599b;
        r7 = "admob";
        r65 = r8;
        r8 = 0;
        r2 = r2.getSharedPreferences(r7, r8);
        r7 = java.util.Collections.emptySet();
        r8 = "never_pool_slots";
        r2 = r2.getStringSet(r8, r7);
        r43 = r2.contains(r3);
        r2 = r1.e;
        r8 = r2.f5622y;
        r2 = r1.e;
        r2 = r2.f5600c;
        r2 = com.google.android.gms.internal.zzbhf.m5574a(r2);
        r49 = r2.m5570a();
        r2 = com.google.android.gms.ads.internal.zzbs.m4490i();
        r2 = r2.f14078g;
        r2.m5114a();
        r2 = r2.f6345a;
        r3 = com.google.android.gms.internal.zzafw.f6350c;
        if (r2 != r3) goto L_0x0387;
    L_0x0384:
        r50 = 1;
        goto L_0x0389;
    L_0x0387:
        r50 = 0;
    L_0x0389:
        com.google.android.gms.ads.internal.zzbs.m4488g();
        r51 = com.google.android.gms.internal.zzaht.m5234e();
        r19 = r58;
        r26 = r59;
        r2 = r52;
        r17 = r60;
        r32 = r61;
        r40 = r63;
        r3 = r55;
        r18 = r64;
        r7 = r53;
        r45 = r8;
        r25 = r65;
        r8 = r10;
        r10 = r11;
        r11 = r13;
        r13 = r18;
        r42 = r15;
        r47 = r57;
        r18 = r62;
        r15 = r69;
        r48 = r71;
        r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51);
        return r52;
    L_0x03b9:
        r0 = move-exception;
        r2 = r0;
        monitor-exit(r5);	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        throw r2;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
    L_0x03bd:
        r0 = move-exception;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        r2 = r0;	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        monitor-exit(r12);	 Catch:{ all -> 0x03b9, all -> 0x03bd }
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzd.a(com.google.android.gms.internal.zzjj, android.os.Bundle, com.google.android.gms.internal.zzafs, int):com.google.android.gms.internal.zzaau");
    }

    static java.lang.String m20141c(com.google.android.gms.internal.zzafo r2) {
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
        if (r2 != 0) goto L_0x0004;
    L_0x0002:
        r2 = 0;
        return r2;
    L_0x0004:
        r0 = r2.f6303p;
        r1 = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
        r1 = r1.equals(r0);
        if (r1 != 0) goto L_0x0019;
    L_0x000e:
        r1 = "com.google.ads.mediation.customevent.CustomEventAdapter";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0017;
    L_0x0016:
        goto L_0x0019;
    L_0x0017:
        r1 = 0;
        goto L_0x001a;
    L_0x0019:
        r1 = 1;
    L_0x001a:
        if (r1 == 0) goto L_0x0030;
    L_0x001c:
        r1 = r2.f6301n;
        if (r1 == 0) goto L_0x0030;
    L_0x0020:
        r2 = r2.f6301n;
        r2 = r2.f8055j;
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0030, JSONException -> 0x0030 }
        r1.<init>(r2);	 Catch:{ JSONException -> 0x0030, JSONException -> 0x0030 }
        r2 = "class_name";	 Catch:{ JSONException -> 0x0030, JSONException -> 0x0030 }
        r2 = r1.getString(r2);	 Catch:{ JSONException -> 0x0030, JSONException -> 0x0030 }
        return r2;
    L_0x0030:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzd.c(com.google.android.gms.internal.zzafo):java.lang.String");
    }

    public void mo1988D() {
        zzakb.m5371e("showInterstitial is not supported for current ad type");
    }

    public void mo3942M() {
        mo1263e();
    }

    public void mo3943N() {
        m20151U();
    }

    public void mo3944O() {
        zzakb.m5371e("Mediated ad does not support onVideoEnd callback");
    }

    protected boolean mo4384P() {
        zzbs.m4486e();
        if (zzahn.m5179a(this.e.f5600c, this.e.f5600c.getPackageName(), "android.permission.INTERNET")) {
            zzbs.m4486e();
            if (zzahn.m5178a(this.e.f5600c)) {
                return true;
            }
        }
        return false;
    }

    public final void mo3945Q() {
        mo1753b();
    }

    public final void mo3946R() {
        m17474t();
    }

    public final void mo3947S() {
        mo1756f();
    }

    public final void mo3948T() {
        if (this.e.f5607j != null) {
            String str = this.e.f5607j.f6303p;
            StringBuilder stringBuilder = new StringBuilder(74 + String.valueOf(str).length());
            stringBuilder.append("Mediation adapter ");
            stringBuilder.append(str);
            stringBuilder.append(" refreshed, but mediation adapters should never refresh.");
            zzakb.m5371e(stringBuilder.toString());
        }
        mo4385a(this.e.f5607j, true);
        mo4273v();
    }

    public final void m20151U() {
        mo4385a(this.e.f5607j, false);
    }

    public final String mo1989a() {
        return this.e.f5607j == null ? null : this.e.f5607j.f6303p;
    }

    public final void mo3949a(zzqm com_google_android_gms_internal_zzqm, String str) {
        zzqw com_google_android_gms_internal_zzqw = null;
        if (com_google_android_gms_internal_zzqm != null) {
            try {
                Object l = com_google_android_gms_internal_zzqm.mo2149l();
            } catch (Throwable e) {
                zzakb.m5369c("Unable to call onCustomClick.", e);
                return;
            }
        }
        l = null;
        if (!(this.e.f5616s == null || l == null)) {
            com_google_android_gms_internal_zzqw = (zzqw) this.e.f5616s.get(l);
        }
        if (com_google_android_gms_internal_zzqw == null) {
            zzakb.m5371e("Mediation adapter invoked onCustomClick but no listeners were set.");
        } else {
            com_google_android_gms_internal_zzqw.mo2153a(com_google_android_gms_internal_zzqm, str);
        }
    }

    public final boolean m20155a(zzaau com_google_android_gms_internal_zzaau, zznu com_google_android_gms_internal_zznu) {
        this.a = com_google_android_gms_internal_zznu;
        com_google_android_gms_internal_zznu.m6504a("seq_num", com_google_android_gms_internal_zzaau.f6048g);
        com_google_android_gms_internal_zznu.m6504a("request_id", com_google_android_gms_internal_zzaau.f6063v);
        com_google_android_gms_internal_zznu.m6504a("session_id", com_google_android_gms_internal_zzaau.f6049h);
        if (com_google_android_gms_internal_zzaau.f6047f != null) {
            com_google_android_gms_internal_zznu.m6504a(State.KEY_APP_VERSION, String.valueOf(com_google_android_gms_internal_zzaau.f6047f.versionCode));
        }
        zzbt com_google_android_gms_ads_internal_zzbt = this.e;
        zzbs.m4482a();
        Context context = this.e.f5600c;
        zzix com_google_android_gms_internal_zzix = this.h.f5652d;
        zzagb com_google_android_gms_internal_zzabo = com_google_android_gms_internal_zzaau.f6043b.f18136c.getBundle("sdk_less_server_data") != null ? new zzabo(context, com_google_android_gms_internal_zzaau, this, com_google_android_gms_internal_zzix) : new zzzy(context, com_google_android_gms_internal_zzaau, this, com_google_android_gms_internal_zzix);
        com_google_android_gms_internal_zzabo.m13277h();
        com_google_android_gms_ads_internal_zzbt.f5604g = com_google_android_gms_internal_zzabo;
        return true;
    }

    final boolean mo3950a(zzafo com_google_android_gms_internal_zzafo) {
        zzjj com_google_android_gms_internal_zzjj;
        boolean z = false;
        if (this.f != null) {
            com_google_android_gms_internal_zzjj = this.f;
            this.f = null;
        } else {
            com_google_android_gms_internal_zzjj = com_google_android_gms_internal_zzafo.f6288a;
            if (com_google_android_gms_internal_zzjj.f18136c != null) {
                z = com_google_android_gms_internal_zzjj.f18136c.getBoolean("_noRefresh", false);
            }
        }
        return mo4270a(com_google_android_gms_internal_zzjj, com_google_android_gms_internal_zzafo, z);
    }

    public boolean mo3952a(zzjj com_google_android_gms_internal_zzjj, zznu com_google_android_gms_internal_zznu) {
        return m20160a(com_google_android_gms_internal_zzjj, com_google_android_gms_internal_zznu, 1);
    }

    public final void mo3953b(String str, String str2) {
        mo3387a(str, str2);
    }

    public final void mo1754c() {
        this.g.m13921b(this.e.f5607j);
    }

    protected final boolean mo3954c(zzjj com_google_android_gms_internal_zzjj) {
        return super.mo3954c(com_google_android_gms_internal_zzjj) && !this.f19077i;
    }

    public final void mo1755d() {
        this.g.m13922c(this.e.f5607j);
    }

    public final void mo1263e() {
        if (this.e.f5607j == null) {
            zzakb.m5371e("Ad state was null when trying to ping click URLs.");
            return;
        }
        if (!(this.e.f5607j.f6304q == null || this.e.f5607j.f6304q.f8067c == null)) {
            zzbs.m4503v();
            zzuq.m6686a(this.e.f5600c, this.e.f5602e.f17551a, this.e.f5607j, this.e.f5599b, false, m17429a(this.e.f5607j.f6304q.f8067c));
        }
        if (!(this.e.f5607j.f6301n == null || this.e.f5607j.f6301n.f8051f == null)) {
            zzbs.m4503v();
            zzuq.m6686a(this.e.f5600c, this.e.f5602e.f17551a, this.e.f5607j, this.e.f5599b, false, this.e.f5607j.f6301n.f8051f);
        }
        super.mo1263e();
    }

    public void mo1756f() {
        this.f19077i = true;
        m17475u();
    }

    public final String g_() {
        return this.e.f5607j == null ? null : m20141c(this.e.f5607j);
    }

    public final void h_() {
        zzbs.m4486e();
        zzahn.m5173a(new zzg(this));
    }

    public final void i_() {
        zzbs.m4486e();
        zzahn.m5173a(new zzh(this));
    }

    public void mo2011n() {
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
        r2 = this;
        r0 = "pause must be called on the main UI thread.";
        com.google.android.gms.common.internal.zzbq.m4816b(r0);
        r0 = r2.e;
        r0 = r0.f5607j;
        if (r0 == 0) goto L_0x0027;
    L_0x000b:
        r0 = r2.e;
        r0 = r0.f5607j;
        r0 = r0.f6289b;
        if (r0 == 0) goto L_0x0027;
    L_0x0013:
        r0 = r2.e;
        r0 = r0.m4513c();
        if (r0 == 0) goto L_0x0027;
    L_0x001b:
        com.google.android.gms.ads.internal.zzbs.m4488g();
        r0 = r2.e;
        r0 = r0.f5607j;
        r0 = r0.f6289b;
        com.google.android.gms.internal.zzaht.m5232a(r0);
    L_0x0027:
        r0 = r2.e;
        r0 = r0.f5607j;
        if (r0 == 0) goto L_0x0044;
    L_0x002d:
        r0 = r2.e;
        r0 = r0.f5607j;
        r0 = r0.f6302o;
        if (r0 == 0) goto L_0x0044;
    L_0x0035:
        r0 = r2.e;	 Catch:{ RemoteException -> 0x003f }
        r0 = r0.f5607j;	 Catch:{ RemoteException -> 0x003f }
        r0 = r0.f6302o;	 Catch:{ RemoteException -> 0x003f }
        r0.mo2184d();	 Catch:{ RemoteException -> 0x003f }
        goto L_0x0044;
    L_0x003f:
        r0 = "Could not pause mediation adapter.";
        com.google.android.gms.internal.zzakb.m5371e(r0);
    L_0x0044:
        r0 = r2.g;
        r1 = r2.e;
        r1 = r1.f5607j;
        r0.m13921b(r1);
        r0 = r2.d;
        r0.m4474b();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzd.n():void");
    }

    public void mo2012o() {
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
        r2 = this;
        r0 = "resume must be called on the main UI thread.";
        com.google.android.gms.common.internal.zzbq.m4816b(r0);
        r0 = r2.e;
        r0 = r0.f5607j;
        if (r0 == 0) goto L_0x001a;
    L_0x000b:
        r0 = r2.e;
        r0 = r0.f5607j;
        r0 = r0.f6289b;
        if (r0 == 0) goto L_0x001a;
    L_0x0013:
        r0 = r2.e;
        r0 = r0.f5607j;
        r0 = r0.f6289b;
        goto L_0x001b;
    L_0x001a:
        r0 = 0;
    L_0x001b:
        if (r0 == 0) goto L_0x0031;
    L_0x001d:
        r1 = r2.e;
        r1 = r1.m4513c();
        if (r1 == 0) goto L_0x0031;
    L_0x0025:
        com.google.android.gms.ads.internal.zzbs.m4488g();
        r1 = r2.e;
        r1 = r1.f5607j;
        r1 = r1.f6289b;
        com.google.android.gms.internal.zzaht.m5233b(r1);
    L_0x0031:
        r1 = r2.e;
        r1 = r1.f5607j;
        if (r1 == 0) goto L_0x004e;
    L_0x0037:
        r1 = r2.e;
        r1 = r1.f5607j;
        r1 = r1.f6302o;
        if (r1 == 0) goto L_0x004e;
    L_0x003f:
        r1 = r2.e;	 Catch:{ RemoteException -> 0x0049 }
        r1 = r1.f5607j;	 Catch:{ RemoteException -> 0x0049 }
        r1 = r1.f6302o;	 Catch:{ RemoteException -> 0x0049 }
        r1.mo2185e();	 Catch:{ RemoteException -> 0x0049 }
        goto L_0x004e;
    L_0x0049:
        r1 = "Could not resume mediation adapter.";
        com.google.android.gms.internal.zzakb.m5371e(r1);
    L_0x004e:
        if (r0 == 0) goto L_0x0056;
    L_0x0050:
        r0 = r0.mo3968E();
        if (r0 != 0) goto L_0x005b;
    L_0x0056:
        r0 = r2.d;
        r0.m4475c();
    L_0x005b:
        r0 = r2.g;
        r1 = r2.e;
        r1 = r1.f5607j;
        r0.m13922c(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzd.o():void");
    }

    public final boolean m20160a(zzjj com_google_android_gms_internal_zzjj, zznu com_google_android_gms_internal_zznu, int i) {
        if (!mo4384P()) {
            return false;
        }
        zzafs o;
        zzbs.m4486e();
        zzhk a = zzbs.m4490i().m13237a(this.e.f5600c);
        Bundle a2 = a == null ? null : zzahn.m5153a(a);
        this.d.m4471a();
        this.e.f5589F = 0;
        if (((Boolean) zzkb.m6350f().m6488a(zznh.cc)).booleanValue()) {
            o = zzbs.m4490i().m13267o();
            zzbs.m4493l().m4458a(this.e.f5600c, this.e.f5602e, false, o, o.f6340c, this.e.f5599b, null);
        } else {
            o = null;
        }
        return m20155a(m20140a(com_google_android_gms_internal_zzjj, a2, o, i), com_google_android_gms_internal_zznu);
    }

    public final void mo3389b(zzafo com_google_android_gms_internal_zzafo) {
        super.mo3389b(com_google_android_gms_internal_zzafo);
        zzbu com_google_android_gms_ads_internal_zzbu;
        if (com_google_android_gms_internal_zzafo.f6301n != null) {
            zzakb.m5366b("Disable the debug gesture detector on the mediation ad frame.");
            if (this.e.f5603f != null) {
                com_google_android_gms_ads_internal_zzbu = this.e.f5603f;
                zzagf.m13278a("Disable debug gesture detector on adFrame.");
                com_google_android_gms_ads_internal_zzbu.f5626c = false;
            }
            zzakb.m5366b("Pinging network fill URLs.");
            zzbs.m4503v();
            zzuq.m6686a(this.e.f5600c, this.e.f5602e.f17551a, com_google_android_gms_internal_zzafo, this.e.f5599b, false, com_google_android_gms_internal_zzafo.f6301n.f8054i);
            if (!(com_google_android_gms_internal_zzafo.f6304q == null || com_google_android_gms_internal_zzafo.f6304q.f8070f == null || com_google_android_gms_internal_zzafo.f6304q.f8070f.size() <= 0)) {
                zzakb.m5366b("Pinging urls remotely");
                zzbs.m4486e();
                zzahn.m5171a(this.e.f5600c, com_google_android_gms_internal_zzafo.f6304q.f8070f);
            }
        } else {
            zzakb.m5366b("Enable the debug gesture detector on the admob ad frame.");
            if (this.e.f5603f != null) {
                com_google_android_gms_ads_internal_zzbu = this.e.f5603f;
                zzagf.m13278a("Enable debug gesture detector on adFrame.");
                com_google_android_gms_ads_internal_zzbu.f5626c = true;
            }
        }
        if (com_google_android_gms_internal_zzafo.f6291d == 3 && com_google_android_gms_internal_zzafo.f6304q != null && com_google_android_gms_internal_zzafo.f6304q.f8069e != null) {
            zzakb.m5366b("Pinging no fill URLs.");
            zzbs.m4503v();
            zzuq.m6686a(this.e.f5600c, this.e.f5602e.f17551a, com_google_android_gms_internal_zzafo, this.e.f5599b, false, com_google_android_gms_internal_zzafo.f6304q.f8069e);
        }
    }

    public boolean mo3951a(zzafo com_google_android_gms_internal_zzafo, zzafo com_google_android_gms_internal_zzafo2) {
        if (!(com_google_android_gms_internal_zzafo == null || com_google_android_gms_internal_zzafo.f6305r == null)) {
            com_google_android_gms_internal_zzafo.f6305r.m19041a(null);
        }
        if (com_google_android_gms_internal_zzafo2.f6305r != null) {
            com_google_android_gms_internal_zzafo2.f6305r.m19041a((zzuj) this);
        }
        int i = 0;
        if (com_google_android_gms_internal_zzafo2.f6304q != null) {
            i = com_google_android_gms_internal_zzafo2.f6304q.f8081q;
            com_google_android_gms_internal_zzafo = com_google_android_gms_internal_zzafo2.f6304q.f8082r;
        } else {
            com_google_android_gms_internal_zzafo = null;
        }
        com_google_android_gms_internal_zzafo2 = this.e.f5587D;
        synchronized (com_google_android_gms_internal_zzafo2.f6361a) {
            com_google_android_gms_internal_zzafo2.f6362b = i;
            com_google_android_gms_internal_zzafo2.f6363c = com_google_android_gms_internal_zzafo;
            com_google_android_gms_internal_zzafo = com_google_android_gms_internal_zzafo2.f6364d;
            String str = com_google_android_gms_internal_zzafo2.f6365e;
            synchronized (com_google_android_gms_internal_zzafo.f14072a) {
                com_google_android_gms_internal_zzafo.f14075d.put(str, com_google_android_gms_internal_zzafo2);
            }
        }
        return true;
    }

    public boolean mo4270a(zzjj com_google_android_gms_internal_zzjj, zzafo com_google_android_gms_internal_zzafo, boolean z) {
        if (!z && this.e.m4513c()) {
            long j;
            if (com_google_android_gms_internal_zzafo.f6295h > 0) {
                z = this.d;
                j = com_google_android_gms_internal_zzafo.f6295h;
            } else if (com_google_android_gms_internal_zzafo.f6304q && com_google_android_gms_internal_zzafo.f6304q.f8073i > 0) {
                z = this.d;
                j = com_google_android_gms_internal_zzafo.f6304q.f8073i;
            } else if (!com_google_android_gms_internal_zzafo.f6300m && com_google_android_gms_internal_zzafo.f6291d == true) {
                this.d.m4472a(com_google_android_gms_internal_zzjj);
            }
            z.m4473a(com_google_android_gms_internal_zzjj, j);
        }
        return this.d.f5534b;
    }

    public void mo1753b() {
        this.f19077i = false;
        mo4286s();
        zzafq com_google_android_gms_internal_zzafq = this.e.f5609l;
        synchronized (com_google_android_gms_internal_zzafq.f6326c) {
            if (!(com_google_android_gms_internal_zzafq.f6333j == -1 || com_google_android_gms_internal_zzafq.f6325b.isEmpty())) {
                zzafr com_google_android_gms_internal_zzafr = (zzafr) com_google_android_gms_internal_zzafq.f6325b.getLast();
                if (com_google_android_gms_internal_zzafr.f6337b == -1) {
                    com_google_android_gms_internal_zzafr.f6337b = SystemClock.elapsedRealtime();
                    com_google_android_gms_internal_zzafq.f6324a.m13245a(com_google_android_gms_internal_zzafq);
                }
            }
        }
    }

    protected void mo4385a(zzafo com_google_android_gms_internal_zzafo, boolean z) {
        if (com_google_android_gms_internal_zzafo == null) {
            zzakb.m5371e("Ad state was null when trying to ping impression URLs.");
            return;
        }
        if (com_google_android_gms_internal_zzafo == null) {
            zzakb.m5371e("Ad state was null when trying to ping impression URLs.");
        } else {
            zzakb.m5366b("Pinging Impression URLs.");
            if (this.f17129e.f5609l != null) {
                zzafq com_google_android_gms_internal_zzafq = this.f17129e.f5609l;
                synchronized (com_google_android_gms_internal_zzafq.f6326c) {
                    if (com_google_android_gms_internal_zzafq.f6333j != -1 && com_google_android_gms_internal_zzafq.f6328e == -1) {
                        com_google_android_gms_internal_zzafq.f6328e = SystemClock.elapsedRealtime();
                        com_google_android_gms_internal_zzafq.f6324a.m13245a(com_google_android_gms_internal_zzafq);
                    }
                    zzafx d = com_google_android_gms_internal_zzafq.f6324a.m13255d();
                    synchronized (d.f6357f) {
                        d.f6359h++;
                    }
                }
            }
            com_google_android_gms_internal_zzafo.f6282H.m6326a(zzb.AD_IMPRESSION);
            if (!(com_google_android_gms_internal_zzafo.f6292e == null || com_google_android_gms_internal_zzafo.f6277C)) {
                zzbs.m4486e();
                zzahn.m5170a(this.f17129e.f5600c, this.f17129e.f5602e.f17551a, m17429a(com_google_android_gms_internal_zzafo.f6292e));
                com_google_android_gms_internal_zzafo.f6277C = true;
            }
        }
        if (!com_google_android_gms_internal_zzafo.f6278D || z) {
            if (!(com_google_android_gms_internal_zzafo.f6304q == null || com_google_android_gms_internal_zzafo.f6304q.f8068d == null)) {
                zzbs.m4503v();
                zzuq.m6686a(this.e.f5600c, this.e.f5602e.f17551a, com_google_android_gms_internal_zzafo, this.e.f5599b, z, m17429a(com_google_android_gms_internal_zzafo.f6304q.f8068d));
            }
            if (!(com_google_android_gms_internal_zzafo.f6301n == null || com_google_android_gms_internal_zzafo.f6301n.f8052g == null)) {
                zzbs.m4503v();
                zzuq.m6686a(this.e.f5600c, this.e.f5602e.f17551a, com_google_android_gms_internal_zzafo, this.e.f5599b, z, com_google_android_gms_internal_zzafo.f6301n.f8052g);
            }
            com_google_android_gms_internal_zzafo.f6278D = true;
        }
    }
}
