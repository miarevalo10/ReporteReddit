package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import org.json.JSONObject;

@zzzv
public final class zzaei extends zzagb implements zzaeh {
    private final zzafp f17524a;
    private final Context f17525b;
    private final ArrayList<Future> f17526c;
    private final ArrayList<String> f17527d;
    private final HashMap<String, zzady> f17528e;
    private final List<zzaeb> f17529f;
    private final HashSet<String> f17530g;
    private final Object f17531h;
    private final zzade f17532i;
    private final long f17533j;

    public zzaei(Context context, zzafp com_google_android_gms_internal_zzafp, zzade com_google_android_gms_internal_zzade) {
        Context context2 = context;
        zzafp com_google_android_gms_internal_zzafp2 = com_google_android_gms_internal_zzafp;
        zzade com_google_android_gms_internal_zzade2 = com_google_android_gms_internal_zzade;
        this(context2, com_google_android_gms_internal_zzafp2, com_google_android_gms_internal_zzade2, ((Long) zzkb.m6350f().m6488a(zznh.at)).longValue());
    }

    private zzaei(Context context, zzafp com_google_android_gms_internal_zzafp, zzade com_google_android_gms_internal_zzade, long j) {
        this.f17526c = new ArrayList();
        this.f17527d = new ArrayList();
        this.f17528e = new HashMap();
        this.f17529f = new ArrayList();
        this.f17530g = new HashSet();
        this.f17531h = new Object();
        this.f17525b = context;
        this.f17524a = com_google_android_gms_internal_zzafp;
        this.f17532i = com_google_android_gms_internal_zzade;
        this.f17533j = j;
    }

    private final zzafo m17771a(int i, String str, zzuh com_google_android_gms_internal_zzuh) {
        zzjj com_google_android_gms_internal_zzjj = this.f17524a.f6314a.f17396c;
        List list = this.f17524a.f6315b.f17443c;
        List list2 = this.f17524a.f6315b.f17445e;
        List list3 = this.f17524a.f6315b.f17449i;
        int i2 = this.f17524a.f6315b.f17451k;
        long j = this.f17524a.f6315b.f17450j;
        String str2 = this.f17524a.f6314a.f17402i;
        boolean z = this.f17524a.f6315b.f17447g;
        zzui com_google_android_gms_internal_zzui = this.f17524a.f6316c;
        long j2 = this.f17524a.f6315b.f17448h;
        zzjn com_google_android_gms_internal_zzjn = this.f17524a.f6317d;
        long j3 = j2;
        zzui com_google_android_gms_internal_zzui2 = com_google_android_gms_internal_zzui;
        long j4 = this.f17524a.f6315b.f17446f;
        long j5 = this.f17524a.f6319f;
        long j6 = this.f17524a.f6315b.f17453m;
        String str3 = this.f17524a.f6315b.f17454n;
        JSONObject jSONObject = this.f17524a.f6321h;
        zzaeq com_google_android_gms_internal_zzaeq = this.f17524a.f6315b.f17421A;
        List list4 = this.f17524a.f6315b.f17422B;
        List list5 = this.f17524a.f6315b.f17423C;
        boolean z2 = this.f17524a.f6315b.f17424D;
        zzaaz com_google_android_gms_internal_zzaaz = this.f17524a.f6315b.f17425E;
        String c = m17772c();
        zzaaz com_google_android_gms_internal_zzaaz2 = com_google_android_gms_internal_zzaaz;
        List list6 = this.f17524a.f6315b.f17428H;
        String str4 = this.f17524a.f6315b.f17432L;
        zzis com_google_android_gms_internal_zzis = this.f17524a.f6322i;
        JSONObject jSONObject2 = jSONObject;
        zzjn com_google_android_gms_internal_zzjn2 = com_google_android_gms_internal_zzjn;
        String str5 = str3;
        long j7 = j3;
        j3 = j6;
        return new zzafo(com_google_android_gms_internal_zzjj, null, list, i, list2, list3, i2, j, str2, z, com_google_android_gms_internal_zzuh, null, str, com_google_android_gms_internal_zzui2, null, j7, com_google_android_gms_internal_zzjn2, j4, j5, j3, str5, jSONObject2, null, com_google_android_gms_internal_zzaeq, list4, list5, z2, com_google_android_gms_internal_zzaaz2, c, list6, str4, com_google_android_gms_internal_zzis, this.f17524a.f6315b.f17435O, this.f17524a.f6323j);
    }

    private final String m17772c() {
        StringBuilder stringBuilder = new StringBuilder("");
        if (this.f17529f == null) {
            return stringBuilder.toString();
        }
        Iterator it = this.f17529f.iterator();
        while (true) {
            int i = 1;
            if (!it.hasNext()) {
                return stringBuilder.substring(0, Math.max(0, stringBuilder.length() - 1));
            }
            zzaeb com_google_android_gms_internal_zzaeb = (zzaeb) it.next();
            if (!(com_google_android_gms_internal_zzaeb == null || TextUtils.isEmpty(com_google_android_gms_internal_zzaeb.f6241a))) {
                String str = com_google_android_gms_internal_zzaeb.f6241a;
                switch (com_google_android_gms_internal_zzaeb.f6242b) {
                    case 3:
                        break;
                    case 4:
                        i = 2;
                        break;
                    case 5:
                        i = 4;
                        break;
                    case 6:
                        i = 0;
                        break;
                    case 7:
                        i = 3;
                        break;
                    default:
                        i = 6;
                        break;
                }
                long j = com_google_android_gms_internal_zzaeb.f6243c;
                StringBuilder stringBuilder2 = new StringBuilder(33 + String.valueOf(str).length());
                stringBuilder2.append(str);
                stringBuilder2.append(".");
                stringBuilder2.append(i);
                stringBuilder2.append(".");
                stringBuilder2.append(j);
                stringBuilder.append(String.valueOf(stringBuilder2.toString()).concat(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR));
            }
        }
    }

    public final void mo3431a(int i) {
    }

    public final void mo3432a(String str) {
        synchronized (this.f17531h) {
            this.f17530g.add(str);
        }
    }

    public final void mo3385b() {
    }

    public final void mo3384a() {
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
        r21 = this;
        r11 = r21;
        r1 = r11.f17524a;
        r1 = r1.f6316c;
        r1 = r1.f8065a;
        r12 = r1.iterator();
    L_0x000c:
        r1 = r12.hasNext();
        if (r1 == 0) goto L_0x00cf;
    L_0x0012:
        r1 = r12.next();
        r13 = r1;
        r13 = (com.google.android.gms.internal.zzuh) r13;
        r14 = r13.f8055j;
        r1 = r13.f8048c;
        r15 = r1.iterator();
    L_0x0021:
        r1 = r15.hasNext();
        if (r1 == 0) goto L_0x000c;
    L_0x0027:
        r1 = r15.next();
        r1 = (java.lang.String) r1;
        r2 = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
        r2 = r2.equals(r1);
        if (r2 != 0) goto L_0x0040;
    L_0x0035:
        r2 = "com.google.ads.mediation.customevent.CustomEventAdapter";
        r2 = r2.equals(r1);
        if (r2 == 0) goto L_0x003e;
    L_0x003d:
        goto L_0x0040;
    L_0x003e:
        r9 = r1;
        goto L_0x004c;
    L_0x0040:
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00be }
        r1.<init>(r14);	 Catch:{ JSONException -> 0x00be }
        r2 = "class_name";	 Catch:{ JSONException -> 0x00be }
        r1 = r1.getString(r2);	 Catch:{ JSONException -> 0x00be }
        goto L_0x003e;
    L_0x004c:
        r10 = r11.f17531h;
        monitor-enter(r10);
        r1 = r11.f17532i;	 Catch:{ all -> 0x00b6 }
        r7 = r1.mo4271b(r9);	 Catch:{ all -> 0x00b6 }
        if (r7 == 0) goto L_0x0093;	 Catch:{ all -> 0x00b6 }
    L_0x0057:
        r1 = r7.f6254b;	 Catch:{ all -> 0x00b6 }
        if (r1 == 0) goto L_0x0093;	 Catch:{ all -> 0x00b6 }
    L_0x005b:
        r1 = r7.f6253a;	 Catch:{ all -> 0x00b6 }
        if (r1 != 0) goto L_0x0060;	 Catch:{ all -> 0x00b6 }
    L_0x005f:
        goto L_0x0093;	 Catch:{ all -> 0x00b6 }
    L_0x0060:
        r8 = new com.google.android.gms.internal.zzady;	 Catch:{ all -> 0x00b6 }
        r2 = r11.f17525b;	 Catch:{ all -> 0x00b6 }
        r6 = r11.f17524a;	 Catch:{ all -> 0x00b6 }
        r4 = r11.f17533j;	 Catch:{ all -> 0x00b6 }
        r1 = r8;
        r3 = r9;
        r16 = r4;
        r4 = r14;
        r5 = r13;
        r18 = r12;
        r12 = r8;
        r8 = r11;
        r20 = r10;
        r19 = r14;
        r14 = r9;
        r9 = r16;
        r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9);	 Catch:{ all -> 0x00bc }
        r1 = r11.f17526c;	 Catch:{ all -> 0x00bc }
        r2 = r12.mo1645e();	 Catch:{ all -> 0x00bc }
        r2 = (com.google.android.gms.internal.zzakv) r2;	 Catch:{ all -> 0x00bc }
        r1.add(r2);	 Catch:{ all -> 0x00bc }
        r1 = r11.f17527d;	 Catch:{ all -> 0x00bc }
        r1.add(r14);	 Catch:{ all -> 0x00bc }
        r1 = r11.f17528e;	 Catch:{ all -> 0x00bc }
        r1.put(r14, r12);	 Catch:{ all -> 0x00bc }
    L_0x0091:
        monitor-exit(r20);	 Catch:{ all -> 0x00bc }
        goto L_0x00c9;	 Catch:{ all -> 0x00bc }
    L_0x0093:
        r20 = r10;	 Catch:{ all -> 0x00bc }
        r18 = r12;	 Catch:{ all -> 0x00bc }
        r19 = r14;	 Catch:{ all -> 0x00bc }
        r14 = r9;	 Catch:{ all -> 0x00bc }
        r1 = r11.f17529f;	 Catch:{ all -> 0x00bc }
        r2 = new com.google.android.gms.internal.zzaed;	 Catch:{ all -> 0x00bc }
        r2.<init>();	 Catch:{ all -> 0x00bc }
        r3 = r13.f8049d;	 Catch:{ all -> 0x00bc }
        r2.f6246b = r3;	 Catch:{ all -> 0x00bc }
        r2.f6245a = r14;	 Catch:{ all -> 0x00bc }
        r3 = 0;	 Catch:{ all -> 0x00bc }
        r2.f6248d = r3;	 Catch:{ all -> 0x00bc }
        r3 = 7;	 Catch:{ all -> 0x00bc }
        r2.f6247c = r3;	 Catch:{ all -> 0x00bc }
        r2 = r2.m5050a();	 Catch:{ all -> 0x00bc }
        r1.add(r2);	 Catch:{ all -> 0x00bc }
        goto L_0x0091;	 Catch:{ all -> 0x00bc }
    L_0x00b6:
        r0 = move-exception;	 Catch:{ all -> 0x00bc }
        r20 = r10;	 Catch:{ all -> 0x00bc }
    L_0x00b9:
        r1 = r0;	 Catch:{ all -> 0x00bc }
        monitor-exit(r20);	 Catch:{ all -> 0x00bc }
        throw r1;
    L_0x00bc:
        r0 = move-exception;
        goto L_0x00b9;
    L_0x00be:
        r0 = move-exception;
        r18 = r12;
        r19 = r14;
        r1 = r0;
        r2 = "Unable to determine custom event class name, skipping...";
        com.google.android.gms.internal.zzakb.m5367b(r2, r1);
    L_0x00c9:
        r12 = r18;
        r14 = r19;
        goto L_0x0021;
    L_0x00cf:
        r1 = 0;
    L_0x00d0:
        r2 = r11.f17526c;
        r2 = r2.size();
        r3 = 0;
        if (r1 >= r2) goto L_0x01e1;
    L_0x00d9:
        r2 = r11.f17526c;	 Catch:{ InterruptedException -> 0x0186, Exception -> 0x0152 }
        r2 = r2.get(r1);	 Catch:{ InterruptedException -> 0x0186, Exception -> 0x0152 }
        r2 = (java.util.concurrent.Future) r2;	 Catch:{ InterruptedException -> 0x0186, Exception -> 0x0152 }
        r2.get();	 Catch:{ InterruptedException -> 0x0186, Exception -> 0x0152 }
        r2 = r11.f17531h;
        monitor-enter(r2);
        r4 = r11.f17527d;	 Catch:{ all -> 0x014b }
        r4 = r4.get(r1);	 Catch:{ all -> 0x014b }
        r4 = (java.lang.String) r4;	 Catch:{ all -> 0x014b }
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x014b }
        if (r5 != 0) goto L_0x0108;	 Catch:{ all -> 0x014b }
    L_0x00f5:
        r5 = r11.f17528e;	 Catch:{ all -> 0x014b }
        r4 = r5.get(r4);	 Catch:{ all -> 0x014b }
        r4 = (com.google.android.gms.internal.zzady) r4;	 Catch:{ all -> 0x014b }
        if (r4 == 0) goto L_0x0108;	 Catch:{ all -> 0x014b }
    L_0x00ff:
        r5 = r11.f17529f;	 Catch:{ all -> 0x014b }
        r4 = r4.m17757c();	 Catch:{ all -> 0x014b }
        r5.add(r4);	 Catch:{ all -> 0x014b }
    L_0x0108:
        monitor-exit(r2);	 Catch:{ all -> 0x014b }
        r4 = r11.f17531h;
        monitor-enter(r4);
        r2 = r11.f17530g;	 Catch:{ all -> 0x0147 }
        r5 = r11.f17527d;	 Catch:{ all -> 0x0147 }
        r5 = r5.get(r1);	 Catch:{ all -> 0x0147 }
        r2 = r2.contains(r5);	 Catch:{ all -> 0x0147 }
        if (r2 == 0) goto L_0x0145;	 Catch:{ all -> 0x0147 }
    L_0x011a:
        r2 = r11.f17527d;	 Catch:{ all -> 0x0147 }
        r1 = r2.get(r1);	 Catch:{ all -> 0x0147 }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x0147 }
        r2 = r11.f17528e;	 Catch:{ all -> 0x0147 }
        r2 = r2.get(r1);	 Catch:{ all -> 0x0147 }
        if (r2 == 0) goto L_0x0134;	 Catch:{ all -> 0x0147 }
    L_0x012a:
        r2 = r11.f17528e;	 Catch:{ all -> 0x0147 }
        r2 = r2.get(r1);	 Catch:{ all -> 0x0147 }
        r2 = (com.google.android.gms.internal.zzady) r2;	 Catch:{ all -> 0x0147 }
        r3 = r2.f17509a;	 Catch:{ all -> 0x0147 }
    L_0x0134:
        r2 = -2;	 Catch:{ all -> 0x0147 }
        r1 = r11.m17771a(r2, r1, r3);	 Catch:{ all -> 0x0147 }
        r2 = com.google.android.gms.internal.zzajr.f6473a;	 Catch:{ all -> 0x0147 }
        r3 = new com.google.android.gms.internal.zzaej;	 Catch:{ all -> 0x0147 }
        r3.<init>(r11, r1);	 Catch:{ all -> 0x0147 }
        r2.post(r3);	 Catch:{ all -> 0x0147 }
        monitor-exit(r4);	 Catch:{ all -> 0x0147 }
        return;	 Catch:{ all -> 0x0147 }
    L_0x0145:
        monitor-exit(r4);	 Catch:{ all -> 0x0147 }
        goto L_0x017e;	 Catch:{ all -> 0x0147 }
    L_0x0147:
        r0 = move-exception;	 Catch:{ all -> 0x0147 }
        r1 = r0;	 Catch:{ all -> 0x0147 }
        monitor-exit(r4);	 Catch:{ all -> 0x0147 }
        throw r1;
    L_0x014b:
        r0 = move-exception;
        r1 = r0;
        monitor-exit(r2);	 Catch:{ all -> 0x014b }
        throw r1;
    L_0x014f:
        r0 = move-exception;
        r2 = r0;
        goto L_0x01b7;
    L_0x0152:
        r0 = move-exception;
        r2 = r0;
        r3 = "Unable to resolve rewarded adapter.";	 Catch:{ all -> 0x014f }
        com.google.android.gms.internal.zzakb.m5369c(r3, r2);	 Catch:{ all -> 0x014f }
        r2 = r11.f17531h;
        monitor-enter(r2);
        r3 = r11.f17527d;	 Catch:{ all -> 0x0182 }
        r3 = r3.get(r1);	 Catch:{ all -> 0x0182 }
        r3 = (java.lang.String) r3;	 Catch:{ all -> 0x0182 }
        r4 = android.text.TextUtils.isEmpty(r3);	 Catch:{ all -> 0x0182 }
        if (r4 != 0) goto L_0x017d;	 Catch:{ all -> 0x0182 }
    L_0x016a:
        r4 = r11.f17528e;	 Catch:{ all -> 0x0182 }
        r3 = r4.get(r3);	 Catch:{ all -> 0x0182 }
        r3 = (com.google.android.gms.internal.zzady) r3;	 Catch:{ all -> 0x0182 }
        if (r3 == 0) goto L_0x017d;	 Catch:{ all -> 0x0182 }
    L_0x0174:
        r4 = r11.f17529f;	 Catch:{ all -> 0x0182 }
        r3 = r3.m17757c();	 Catch:{ all -> 0x0182 }
        r4.add(r3);	 Catch:{ all -> 0x0182 }
    L_0x017d:
        monitor-exit(r2);	 Catch:{ all -> 0x0182 }
    L_0x017e:
        r1 = r1 + 1;	 Catch:{ all -> 0x0182 }
        goto L_0x00d0;	 Catch:{ all -> 0x0182 }
    L_0x0182:
        r0 = move-exception;	 Catch:{ all -> 0x0182 }
        r1 = r0;	 Catch:{ all -> 0x0182 }
        monitor-exit(r2);	 Catch:{ all -> 0x0182 }
        throw r1;
    L_0x0186:
        r2 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x014f }
        r2.interrupt();	 Catch:{ all -> 0x014f }
        r2 = r11.f17531h;
        monitor-enter(r2);
        r4 = r11.f17527d;	 Catch:{ all -> 0x01b3 }
        r1 = r4.get(r1);	 Catch:{ all -> 0x01b3 }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x01b3 }
        r4 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x01b3 }
        if (r4 != 0) goto L_0x01b1;	 Catch:{ all -> 0x01b3 }
    L_0x019e:
        r4 = r11.f17528e;	 Catch:{ all -> 0x01b3 }
        r1 = r4.get(r1);	 Catch:{ all -> 0x01b3 }
        r1 = (com.google.android.gms.internal.zzady) r1;	 Catch:{ all -> 0x01b3 }
        if (r1 == 0) goto L_0x01b1;	 Catch:{ all -> 0x01b3 }
    L_0x01a8:
        r4 = r11.f17529f;	 Catch:{ all -> 0x01b3 }
        r1 = r1.m17757c();	 Catch:{ all -> 0x01b3 }
        r4.add(r1);	 Catch:{ all -> 0x01b3 }
    L_0x01b1:
        monitor-exit(r2);	 Catch:{ all -> 0x01b3 }
        goto L_0x01e1;	 Catch:{ all -> 0x01b3 }
    L_0x01b3:
        r0 = move-exception;	 Catch:{ all -> 0x01b3 }
        r1 = r0;	 Catch:{ all -> 0x01b3 }
        monitor-exit(r2);	 Catch:{ all -> 0x01b3 }
        throw r1;
    L_0x01b7:
        r4 = r11.f17531h;
        monitor-enter(r4);
        r3 = r11.f17527d;	 Catch:{ all -> 0x01dd }
        r1 = r3.get(r1);	 Catch:{ all -> 0x01dd }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x01dd }
        r3 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x01dd }
        if (r3 != 0) goto L_0x01db;	 Catch:{ all -> 0x01dd }
    L_0x01c8:
        r3 = r11.f17528e;	 Catch:{ all -> 0x01dd }
        r1 = r3.get(r1);	 Catch:{ all -> 0x01dd }
        r1 = (com.google.android.gms.internal.zzady) r1;	 Catch:{ all -> 0x01dd }
        if (r1 == 0) goto L_0x01db;	 Catch:{ all -> 0x01dd }
    L_0x01d2:
        r3 = r11.f17529f;	 Catch:{ all -> 0x01dd }
        r1 = r1.m17757c();	 Catch:{ all -> 0x01dd }
        r3.add(r1);	 Catch:{ all -> 0x01dd }
    L_0x01db:
        monitor-exit(r4);	 Catch:{ all -> 0x01dd }
        throw r2;
    L_0x01dd:
        r0 = move-exception;
        r1 = r0;
        monitor-exit(r4);	 Catch:{ all -> 0x01dd }
        throw r1;
    L_0x01e1:
        r1 = 3;
        r1 = r11.m17771a(r1, r3, r3);
        r2 = com.google.android.gms.internal.zzajr.f6473a;
        r3 = new com.google.android.gms.internal.zzaek;
        r3.<init>(r11, r1);
        r2.post(r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaei.a():void");
    }
}
