package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.gmsg.zzt;

@zzzv
public final class zzamv implements zzt<zzamp> {
    private boolean f14194a;

    private static int m13397a(android.content.Context r1, java.util.Map<java.lang.String, java.lang.String> r2, java.lang.String r3, int r4) {
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
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
        if (r2 == 0) goto L_0x0044;
    L_0x0008:
        com.google.android.gms.internal.zzkb.m6345a();	 Catch:{ NumberFormatException -> 0x0014 }
        r0 = java.lang.Integer.parseInt(r2);	 Catch:{ NumberFormatException -> 0x0014 }
        r1 = com.google.android.gms.internal.zzajr.m5318a(r1, r0);	 Catch:{ NumberFormatException -> 0x0014 }
        return r1;
    L_0x0014:
        r1 = 34;
        r0 = java.lang.String.valueOf(r3);
        r0 = r0.length();
        r1 = r1 + r0;
        r0 = java.lang.String.valueOf(r2);
        r0 = r0.length();
        r1 = r1 + r0;
        r0 = new java.lang.StringBuilder;
        r0.<init>(r1);
        r1 = "Could not parse ";
        r0.append(r1);
        r0.append(r3);
        r1 = " in a video GMSG: ";
        r0.append(r1);
        r0.append(r2);
        r1 = r0.toString();
        com.google.android.gms.internal.zzakb.m5371e(r1);
    L_0x0044:
        r1 = r4;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzamv.a(android.content.Context, java.util.Map, java.lang.String, int):int");
    }

    private static void m13398a(java.util.Map<java.lang.String, java.lang.String> r4) {
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
        r0 = "minBufferMs";
        r0 = r4.get(r0);
        r0 = (java.lang.String) r0;
        r1 = "maxBufferMs";
        r1 = r4.get(r1);
        r1 = (java.lang.String) r1;
        r2 = "bufferForPlaybackMs";
        r2 = r4.get(r2);
        r2 = (java.lang.String) r2;
        r3 = "bufferForPlaybackAfterRebufferMs";
        r4 = r4.get(r3);
        r4 = (java.lang.String) r4;
        if (r0 == 0) goto L_0x0025;
    L_0x0022:
        java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x0035 }
    L_0x0025:
        if (r1 == 0) goto L_0x002a;	 Catch:{ NumberFormatException -> 0x0035 }
    L_0x0027:
        java.lang.Integer.parseInt(r1);	 Catch:{ NumberFormatException -> 0x0035 }
    L_0x002a:
        if (r2 == 0) goto L_0x002f;	 Catch:{ NumberFormatException -> 0x0035 }
    L_0x002c:
        java.lang.Integer.parseInt(r2);	 Catch:{ NumberFormatException -> 0x0035 }
    L_0x002f:
        if (r4 == 0) goto L_0x0047;	 Catch:{ NumberFormatException -> 0x0035 }
    L_0x0031:
        java.lang.Integer.parseInt(r4);	 Catch:{ NumberFormatException -> 0x0035 }
        return;
    L_0x0035:
        r4 = "Could not parse buffer parameters in loadControl video GMSG: (%s, %s)";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r2[r3] = r0;
        r0 = 1;
        r2[r0] = r1;
        r4 = java.lang.String.format(r4, r2);
        com.google.android.gms.internal.zzakb.m5371e(r4);
    L_0x0047:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzamv.a(java.util.Map):void");
    }

    public final /* synthetic */ void zza(java.lang.Object r12, java.util.Map r13) {
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
        r11 = this;
        r12 = (com.google.android.gms.internal.zzamp) r12;
        r0 = "action";
        r0 = r13.get(r0);
        r0 = (java.lang.String) r0;
        if (r0 != 0) goto L_0x0012;
    L_0x000c:
        r12 = "Action missing from video GMSG.";
        com.google.android.gms.internal.zzakb.m5371e(r12);
        return;
    L_0x0012:
        r1 = 3;
        r1 = com.google.android.gms.internal.zzakb.m5365a(r1);
        if (r1 == 0) goto L_0x0057;
    L_0x0019:
        r1 = new org.json.JSONObject;
        r1.<init>(r13);
        r2 = "google.afma.Notify_dt";
        r1.remove(r2);
        r1 = r1.toString();
        r2 = 13;
        r3 = java.lang.String.valueOf(r0);
        r3 = r3.length();
        r2 = r2 + r3;
        r3 = java.lang.String.valueOf(r1);
        r3 = r3.length();
        r2 = r2 + r3;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "Video GMSG: ";
        r3.append(r2);
        r3.append(r0);
        r2 = " ";
        r3.append(r2);
        r3.append(r1);
        r1 = r3.toString();
        com.google.android.gms.internal.zzakb.m5366b(r1);
    L_0x0057:
        r1 = "background";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0081;
    L_0x005f:
        r0 = "color";
        r13 = r13.get(r0);
        r13 = (java.lang.String) r13;
        r0 = android.text.TextUtils.isEmpty(r13);
        if (r0 == 0) goto L_0x0073;
    L_0x006d:
        r12 = "Color parameter missing from color video GMSG.";
        com.google.android.gms.internal.zzakb.m5371e(r12);
        return;
    L_0x0073:
        r13 = android.graphics.Color.parseColor(r13);	 Catch:{ IllegalArgumentException -> 0x007b }
        r12.setBackgroundColor(r13);	 Catch:{ IllegalArgumentException -> 0x007b }
        return;
    L_0x007b:
        r12 = "Invalid color parameter in video GMSG.";
        com.google.android.gms.internal.zzakb.m5371e(r12);
        return;
    L_0x0081:
        r1 = "decoderProps";
        r1 = r1.equals(r0);
        r2 = 0;
        if (r1 == 0) goto L_0x00d2;
    L_0x008a:
        r0 = "mimeTypes";
        r13 = r13.get(r0);
        r13 = (java.lang.String) r13;
        if (r13 != 0) goto L_0x009f;
    L_0x0094:
        r13 = "No MIME types specified for decoder properties inspection.";
        com.google.android.gms.internal.zzakb.m5371e(r13);
        r13 = "missingMimeTypes";
        com.google.android.gms.internal.zzamd.m13349a(r12, r13);
        return;
    L_0x009f:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 16;
        if (r0 >= r1) goto L_0x00b0;
    L_0x00a5:
        r13 = "Video decoder properties available on API versions >= 16.";
        com.google.android.gms.internal.zzakb.m5371e(r13);
        r13 = "deficientApiVersion";
        com.google.android.gms.internal.zzamd.m13349a(r12, r13);
        return;
    L_0x00b0:
        r0 = new java.util.HashMap;
        r0.<init>();
        r1 = ",";
        r13 = r13.split(r1);
        r1 = r13.length;
    L_0x00bc:
        if (r2 >= r1) goto L_0x00ce;
    L_0x00be:
        r3 = r13[r2];
        r4 = r3.trim();
        r4 = com.google.android.gms.internal.zzajp.m5310a(r4);
        r0.put(r3, r4);
        r2 = r2 + 1;
        goto L_0x00bc;
    L_0x00ce:
        com.google.android.gms.internal.zzamd.m13350a(r12, r0);
        return;
    L_0x00d2:
        r1 = r12.mo3976a();
        if (r1 != 0) goto L_0x00de;
    L_0x00d8:
        r12 = "Could not get underlay container for a video GMSG.";
        com.google.android.gms.internal.zzakb.m5371e(r12);
        return;
    L_0x00de:
        r3 = "new";
        r3 = r3.equals(r0);
        r4 = "position";
        r4 = r4.equals(r0);
        if (r3 != 0) goto L_0x027f;
    L_0x00ec:
        if (r4 == 0) goto L_0x00f0;
    L_0x00ee:
        goto L_0x027f;
    L_0x00f0:
        r1 = r1.m5417a();
        if (r1 != 0) goto L_0x00fa;
    L_0x00f6:
        com.google.android.gms.internal.zzamd.m13348a(r12);
        return;
    L_0x00fa:
        r3 = "click";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x012c;
    L_0x0102:
        r12 = r12.getContext();
        r0 = "x";
        r0 = m13397a(r12, r13, r0, r2);
        r3 = "y";
        r12 = m13397a(r12, r13, r3, r2);
        r4 = android.os.SystemClock.uptimeMillis();
        r6 = 0;
        r7 = (float) r0;
        r8 = (float) r12;
        r9 = 0;
        r2 = r4;
        r12 = android.view.MotionEvent.obtain(r2, r4, r6, r7, r8, r9);
        r13 = r1.f14151b;
        if (r13 == 0) goto L_0x0128;
    L_0x0123:
        r13 = r1.f14151b;
        r13.dispatchTouchEvent(r12);
    L_0x0128:
        r12.recycle();
        return;
    L_0x012c:
        r3 = "currentTime";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x0170;
    L_0x0134:
        r12 = "time";
        r12 = r13.get(r12);
        r12 = (java.lang.String) r12;
        if (r12 != 0) goto L_0x0144;
    L_0x013e:
        r12 = "Time parameter missing from currentTime video GMSG.";
        com.google.android.gms.internal.zzakb.m5371e(r12);
        return;
    L_0x0144:
        r13 = java.lang.Float.parseFloat(r12);	 Catch:{ NumberFormatException -> 0x0156 }
        r0 = 1148846080; // 0x447a0000 float:1000.0 double:5.676053805E-315;	 Catch:{ NumberFormatException -> 0x0156 }
        r13 = r13 * r0;	 Catch:{ NumberFormatException -> 0x0156 }
        r13 = (int) r13;	 Catch:{ NumberFormatException -> 0x0156 }
        r0 = r1.f14151b;	 Catch:{ NumberFormatException -> 0x0156 }
        if (r0 == 0) goto L_0x0155;	 Catch:{ NumberFormatException -> 0x0156 }
    L_0x0150:
        r0 = r1.f14151b;	 Catch:{ NumberFormatException -> 0x0156 }
        r0.mo3449a(r13);	 Catch:{ NumberFormatException -> 0x0156 }
    L_0x0155:
        return;
    L_0x0156:
        r13 = "Could not parse time parameter from currentTime video GMSG: ";
        r12 = java.lang.String.valueOf(r12);
        r0 = r12.length();
        if (r0 == 0) goto L_0x0167;
    L_0x0162:
        r12 = r13.concat(r12);
        goto L_0x016c;
    L_0x0167:
        r12 = new java.lang.String;
        r12.<init>(r13);
    L_0x016c:
        com.google.android.gms.internal.zzakb.m5371e(r12);
        return;
    L_0x0170:
        r3 = "hide";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x017d;
    L_0x0178:
        r12 = 4;
        r1.setVisibility(r12);
        return;
    L_0x017d:
        r3 = "load";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x0189;
    L_0x0185:
        r1.m13364h();
        return;
    L_0x0189:
        r3 = "loadControl";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x0195;
    L_0x0191:
        m13398a(r13);
        return;
    L_0x0195:
        r3 = "muted";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x01b3;
    L_0x019d:
        r12 = "muted";
        r12 = r13.get(r12);
        r12 = (java.lang.String) r12;
        r12 = java.lang.Boolean.parseBoolean(r12);
        if (r12 == 0) goto L_0x01af;
    L_0x01ab:
        r1.m13366j();
        return;
    L_0x01af:
        r1.m13367k();
        return;
    L_0x01b3:
        r3 = "pause";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x01bf;
    L_0x01bb:
        r1.m13365i();
        return;
    L_0x01bf:
        r3 = "play";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x01d1;
    L_0x01c7:
        r12 = r1.f14151b;
        if (r12 == 0) goto L_0x01d0;
    L_0x01cb:
        r12 = r1.f14151b;
        r12.mo3452c();
    L_0x01d0:
        return;
    L_0x01d1:
        r3 = "show";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x01dd;
    L_0x01d9:
        r1.setVisibility(r2);
        return;
    L_0x01dd:
        r3 = "src";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x01f0;
    L_0x01e5:
        r12 = "src";
        r12 = r13.get(r12);
        r12 = (java.lang.String) r12;
        r1.f14153d = r12;
        return;
    L_0x01f0:
        r3 = "touchMove";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x021e;
    L_0x01f8:
        r0 = r12.getContext();
        r3 = "dx";
        r3 = m13397a(r0, r13, r3, r2);
        r4 = "dy";
        r13 = m13397a(r0, r13, r4, r2);
        r0 = (float) r3;
        r13 = (float) r13;
        r2 = r1.f14151b;
        if (r2 == 0) goto L_0x0213;
    L_0x020e:
        r1 = r1.f14151b;
        r1.mo3448a(r0, r13);
    L_0x0213:
        r13 = r11.f14194a;
        if (r13 != 0) goto L_0x021d;
    L_0x0217:
        r12.mo3998f();
        r12 = 1;
        r11.f14194a = r12;
    L_0x021d:
        return;
    L_0x021e:
        r12 = "volume";
        r12 = r12.equals(r0);
        if (r12 == 0) goto L_0x0258;
    L_0x0226:
        r12 = "volume";
        r12 = r13.get(r12);
        r12 = (java.lang.String) r12;
        if (r12 != 0) goto L_0x0236;
    L_0x0230:
        r12 = "Level parameter missing from volume video GMSG.";
        com.google.android.gms.internal.zzakb.m5371e(r12);
        return;
    L_0x0236:
        r13 = java.lang.Float.parseFloat(r12);	 Catch:{ NumberFormatException -> 0x023e }
        r1.m13353a(r13);	 Catch:{ NumberFormatException -> 0x023e }
        return;
    L_0x023e:
        r13 = "Could not parse volume parameter from volume video GMSG: ";
        r12 = java.lang.String.valueOf(r12);
        r0 = r12.length();
        if (r0 == 0) goto L_0x024f;
    L_0x024a:
        r12 = r13.concat(r12);
        goto L_0x0254;
    L_0x024f:
        r12 = new java.lang.String;
        r12.<init>(r13);
    L_0x0254:
        com.google.android.gms.internal.zzakb.m5371e(r12);
        return;
    L_0x0258:
        r12 = "watermark";
        r12 = r12.equals(r0);
        if (r12 == 0) goto L_0x0264;
    L_0x0260:
        r1.m13368l();
        return;
    L_0x0264:
        r12 = "Unknown video action: ";
        r13 = java.lang.String.valueOf(r0);
        r0 = r13.length();
        if (r0 == 0) goto L_0x0275;
    L_0x0270:
        r12 = r12.concat(r13);
        goto L_0x027b;
    L_0x0275:
        r13 = new java.lang.String;
        r13.<init>(r12);
        r12 = r13;
    L_0x027b:
        com.google.android.gms.internal.zzakb.m5371e(r12);
        return;
    L_0x027f:
        r0 = r12.getContext();
        r4 = "x";
        r4 = m13397a(r0, r13, r4, r2);
        r5 = "y";
        r5 = m13397a(r0, r13, r5, r2);
        r6 = "w";
        r7 = -1;
        r6 = m13397a(r0, r13, r6, r7);
        r8 = "h";
        r0 = m13397a(r0, r13, r8, r7);
        r8 = com.google.android.gms.internal.zznh.bR;
        r9 = com.google.android.gms.internal.zzkb.m6350f();
        r8 = r9.m6488a(r8);
        r8 = (java.lang.Boolean) r8;
        r8 = r8.booleanValue();
        if (r8 == 0) goto L_0x02c0;
    L_0x02ae:
        r8 = r12.mo4003m();
        r8 = r8 - r4;
        r6 = java.lang.Math.min(r6, r8);
        r12 = r12.mo3999l();
        r12 = r12 - r5;
        r0 = java.lang.Math.min(r0, r12);
    L_0x02c0:
        r12 = "player";	 Catch:{ NumberFormatException -> 0x02cb }
        r12 = r13.get(r12);	 Catch:{ NumberFormatException -> 0x02cb }
        r12 = (java.lang.String) r12;	 Catch:{ NumberFormatException -> 0x02cb }
        java.lang.Integer.parseInt(r12);	 Catch:{ NumberFormatException -> 0x02cb }
    L_0x02cb:
        r12 = "spherical";
        r12 = r13.get(r12);
        r12 = (java.lang.String) r12;
        r12 = java.lang.Boolean.parseBoolean(r12);
        if (r3 == 0) goto L_0x033a;
    L_0x02d9:
        r3 = r1.m5417a();
        if (r3 != 0) goto L_0x033a;
    L_0x02df:
        r3 = new com.google.android.gms.internal.zzamo;
        r8 = "flags";
        r8 = r13.get(r8);
        r8 = (java.lang.String) r8;
        r3.<init>(r8);
        r3 = r1.f6544d;
        if (r3 != 0) goto L_0x0330;
    L_0x02f0:
        r3 = r1.f6542b;
        r3 = r3.mo3471j();
        r3 = r3.f7941b;
        r8 = r1.f6542b;
        r8 = r8.mo3466c();
        r9 = "vpr2";
        r9 = new java.lang.String[]{r9};
        com.google.android.gms.internal.zznn.m6499a(r3, r8, r9);
        r3 = new com.google.android.gms.internal.zzamd;
        r8 = r1.f6541a;
        r9 = r1.f6542b;
        r10 = r1.f6542b;
        r10 = r10.mo3471j();
        r10 = r10.f7941b;
        r3.<init>(r8, r9, r12, r10);
        r1.f6544d = r3;
        r12 = r1.f6543c;
        r3 = r1.f6544d;
        r8 = new android.view.ViewGroup$LayoutParams;
        r8.<init>(r7, r7);
        r12.addView(r3, r2, r8);
        r12 = r1.f6544d;
        r12.m13355a(r4, r5, r6, r0);
        r12 = r1.f6542b;
        r12.mo3985a(r2);
    L_0x0330:
        r12 = r1.m5417a();
        if (r12 == 0) goto L_0x0339;
    L_0x0336:
        m13398a(r13);
    L_0x0339:
        return;
    L_0x033a:
        r12 = "The underlay may only be modified from the UI thread.";
        com.google.android.gms.common.internal.zzbq.m4816b(r12);
        r12 = r1.f6544d;
        if (r12 == 0) goto L_0x0348;
    L_0x0343:
        r12 = r1.f6544d;
        r12.m13355a(r4, r5, r6, r0);
    L_0x0348:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzamv.zza(java.lang.Object, java.util.Map):void");
    }
}
