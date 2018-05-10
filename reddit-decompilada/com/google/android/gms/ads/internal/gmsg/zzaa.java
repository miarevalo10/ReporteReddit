package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.ads.internal.zzw;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzwr;
import com.google.android.gms.internal.zzzv;
import java.util.Map;

@zzzv
public final class zzaa implements zzt<zzanh> {
    private static Map<String, Integer> f13715c = zze.m4900a("resize", Integer.valueOf(1), "playVideo", Integer.valueOf(2), "storePicture", Integer.valueOf(3), "createCalendarEvent", Integer.valueOf(4), "setOrientationProperties", Integer.valueOf(5), "closeResizedAd", Integer.valueOf(6));
    private final zzw f13716a;
    private final zzwr f13717b;

    public zzaa(zzw com_google_android_gms_ads_internal_zzw, zzwr com_google_android_gms_internal_zzwr) {
        this.f13716a = com_google_android_gms_ads_internal_zzw;
        this.f13717b = com_google_android_gms_internal_zzwr;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zza(java.lang.Object r18, java.util.Map r19) {
        /*
        r17 = this;
        r1 = r17;
        r3 = r19;
        r2 = r18;
        r2 = (com.google.android.gms.internal.zzanh) r2;
        r4 = "a";
        r4 = r3.get(r4);
        r4 = (java.lang.String) r4;
        r5 = f13715c;
        r4 = r5.get(r4);
        r4 = (java.lang.Integer) r4;
        r4 = r4.intValue();
        r5 = 5;
        r6 = 0;
        if (r4 == r5) goto L_0x0032;
    L_0x0020:
        r7 = r1.f13716a;
        if (r7 == 0) goto L_0x0032;
    L_0x0024:
        r7 = r1.f13716a;
        r7 = r7.m4520a();
        if (r7 != 0) goto L_0x0032;
    L_0x002c:
        r2 = r1.f13716a;
        r2.m4519a(r6);
        return;
    L_0x0032:
        r7 = -1;
        r8 = 1;
        if (r4 == r8) goto L_0x01ed;
    L_0x0036:
        switch(r4) {
            case 3: goto L_0x010c;
            case 4: goto L_0x008d;
            case 5: goto L_0x0045;
            case 6: goto L_0x003f;
            default: goto L_0x0039;
        };
    L_0x0039:
        r2 = "Unknown MRAID command called.";
        com.google.android.gms.internal.zzakb.m5370d(r2);
        return;
    L_0x003f:
        r2 = r1.f13717b;
        r2.m14428a(r8);
        return;
    L_0x0045:
        r4 = new com.google.android.gms.internal.zzwt;
        r4.<init>(r2, r3);
        r2 = r4.f8123a;
        if (r2 != 0) goto L_0x0054;
    L_0x004e:
        r2 = "AdWebView is null";
        com.google.android.gms.internal.zzakb.m5371e(r2);
        return;
    L_0x0054:
        r2 = "portrait";
        r3 = r4.f8125c;
        r2 = r2.equalsIgnoreCase(r3);
        if (r2 == 0) goto L_0x0067;
    L_0x005e:
        r2 = com.google.android.gms.ads.internal.zzbs.m4488g();
        r7 = r2.mo1722b();
        goto L_0x0087;
    L_0x0067:
        r2 = "landscape";
        r3 = r4.f8125c;
        r2 = r2.equalsIgnoreCase(r3);
        if (r2 == 0) goto L_0x007a;
    L_0x0071:
        r2 = com.google.android.gms.ads.internal.zzbs.m4488g();
        r7 = r2.mo1720a();
        goto L_0x0087;
    L_0x007a:
        r2 = r4.f8124b;
        if (r2 == 0) goto L_0x007f;
    L_0x007e:
        goto L_0x0087;
    L_0x007f:
        r2 = com.google.android.gms.ads.internal.zzbs.m4488g();
        r7 = r2.mo4424c();
    L_0x0087:
        r2 = r4.f8123a;
        r2.mo3989b(r7);
        return;
    L_0x008d:
        r4 = new com.google.android.gms.internal.zzwo;
        r4.<init>(r2, r3);
        r2 = r4.f14700a;
        if (r2 != 0) goto L_0x009c;
    L_0x0096:
        r2 = "Activity context is not available.";
        r4.m6783a(r2);
        return;
    L_0x009c:
        com.google.android.gms.ads.internal.zzbs.m4486e();
        r2 = r4.f14700a;
        r2 = com.google.android.gms.internal.zzahn.m5208e(r2);
        r2 = r2.m6473b();
        if (r2 != 0) goto L_0x00b1;
    L_0x00ab:
        r2 = "This feature is not available on the device.";
        r4.m6783a(r2);
        return;
    L_0x00b1:
        com.google.android.gms.ads.internal.zzbs.m4486e();
        r2 = r4.f14700a;
        r2 = com.google.android.gms.internal.zzahn.m5204d(r2);
        r3 = com.google.android.gms.ads.internal.zzbs.m4490i();
        r3 = r3.m13270r();
        if (r3 == 0) goto L_0x00cb;
    L_0x00c4:
        r5 = com.google.android.gms.C0436R.string.s5;
        r5 = r3.getString(r5);
        goto L_0x00cd;
    L_0x00cb:
        r5 = "Create calendar event";
    L_0x00cd:
        r2.setTitle(r5);
        if (r3 == 0) goto L_0x00d9;
    L_0x00d2:
        r5 = com.google.android.gms.C0436R.string.s6;
        r5 = r3.getString(r5);
        goto L_0x00db;
    L_0x00d9:
        r5 = "Allow Ad to create a calendar event?";
    L_0x00db:
        r2.setMessage(r5);
        if (r3 == 0) goto L_0x00e7;
    L_0x00e0:
        r5 = com.google.android.gms.C0436R.string.s3;
        r5 = r3.getString(r5);
        goto L_0x00e9;
    L_0x00e7:
        r5 = "Accept";
    L_0x00e9:
        r6 = new com.google.android.gms.internal.zzwp;
        r6.<init>(r4);
        r2.setPositiveButton(r5, r6);
        if (r3 == 0) goto L_0x00fa;
    L_0x00f3:
        r5 = com.google.android.gms.C0436R.string.s4;
        r3 = r3.getString(r5);
        goto L_0x00fc;
    L_0x00fa:
        r3 = "Decline";
    L_0x00fc:
        r5 = new com.google.android.gms.internal.zzwq;
        r5.<init>(r4);
        r2.setNegativeButton(r3, r5);
        r2 = r2.create();
        r2.show();
        return;
    L_0x010c:
        r4 = new com.google.android.gms.internal.zzwu;
        r4.<init>(r2, r3);
        r2 = r4.f14727b;
        if (r2 != 0) goto L_0x011b;
    L_0x0115:
        r2 = "Activity context is not available";
        r4.m6783a(r2);
        return;
    L_0x011b:
        com.google.android.gms.ads.internal.zzbs.m4486e();
        r2 = r4.f14727b;
        r2 = com.google.android.gms.internal.zzahn.m5208e(r2);
        r2 = r2.m6471a();
        if (r2 != 0) goto L_0x0130;
    L_0x012a:
        r2 = "Feature is not supported by the device.";
        r4.m6783a(r2);
        return;
    L_0x0130:
        r2 = r4.f14726a;
        r3 = "iurl";
        r2 = r2.get(r3);
        r2 = (java.lang.String) r2;
        r3 = android.text.TextUtils.isEmpty(r2);
        if (r3 == 0) goto L_0x0146;
    L_0x0140:
        r2 = "Image url cannot be empty.";
        r4.m6783a(r2);
        return;
    L_0x0146:
        r3 = android.webkit.URLUtil.isValidUrl(r2);
        if (r3 != 0) goto L_0x0166;
    L_0x014c:
        r3 = "Invalid image url: ";
        r2 = java.lang.String.valueOf(r2);
        r5 = r2.length();
        if (r5 == 0) goto L_0x015d;
    L_0x0158:
        r2 = r3.concat(r2);
        goto L_0x0162;
    L_0x015d:
        r2 = new java.lang.String;
        r2.<init>(r3);
    L_0x0162:
        r4.m6783a(r2);
        return;
    L_0x0166:
        r3 = android.net.Uri.parse(r2);
        r3 = r3.getLastPathSegment();
        com.google.android.gms.ads.internal.zzbs.m4486e();
        r5 = com.google.android.gms.internal.zzahn.m5201c(r3);
        if (r5 != 0) goto L_0x0192;
    L_0x0177:
        r2 = "Image type not recognized: ";
        r3 = java.lang.String.valueOf(r3);
        r5 = r3.length();
        if (r5 == 0) goto L_0x0188;
    L_0x0183:
        r2 = r2.concat(r3);
        goto L_0x018e;
    L_0x0188:
        r3 = new java.lang.String;
        r3.<init>(r2);
        r2 = r3;
    L_0x018e:
        r4.m6783a(r2);
        return;
    L_0x0192:
        r5 = com.google.android.gms.ads.internal.zzbs.m4490i();
        r5 = r5.m13270r();
        com.google.android.gms.ads.internal.zzbs.m4486e();
        r6 = r4.f14727b;
        r6 = com.google.android.gms.internal.zzahn.m5204d(r6);
        if (r5 == 0) goto L_0x01ac;
    L_0x01a5:
        r7 = com.google.android.gms.C0436R.string.s1;
        r7 = r5.getString(r7);
        goto L_0x01ae;
    L_0x01ac:
        r7 = "Save image";
    L_0x01ae:
        r6.setTitle(r7);
        if (r5 == 0) goto L_0x01ba;
    L_0x01b3:
        r7 = com.google.android.gms.C0436R.string.s2;
        r7 = r5.getString(r7);
        goto L_0x01bc;
    L_0x01ba:
        r7 = "Allow Ad to store image in Picture gallery?";
    L_0x01bc:
        r6.setMessage(r7);
        if (r5 == 0) goto L_0x01c8;
    L_0x01c1:
        r7 = com.google.android.gms.C0436R.string.s3;
        r7 = r5.getString(r7);
        goto L_0x01ca;
    L_0x01c8:
        r7 = "Accept";
    L_0x01ca:
        r8 = new com.google.android.gms.internal.zzwv;
        r8.<init>(r4, r2, r3);
        r6.setPositiveButton(r7, r8);
        if (r5 == 0) goto L_0x01db;
    L_0x01d4:
        r2 = com.google.android.gms.C0436R.string.s4;
        r2 = r5.getString(r2);
        goto L_0x01dd;
    L_0x01db:
        r2 = "Decline";
    L_0x01dd:
        r3 = new com.google.android.gms.internal.zzww;
        r3.<init>(r4);
        r6.setNegativeButton(r2, r3);
        r2 = r6.create();
        r2.show();
        return;
    L_0x01ed:
        r2 = r1.f13717b;
        r4 = r2.f14716i;
        monitor-enter(r4);
        r9 = r2.f14718k;	 Catch:{ all -> 0x0506 }
        if (r9 != 0) goto L_0x01fd;
    L_0x01f6:
        r3 = "Not an activity context. Cannot resize.";
        r2.m6783a(r3);	 Catch:{ all -> 0x0506 }
        monitor-exit(r4);	 Catch:{ all -> 0x0506 }
        return;
    L_0x01fd:
        r9 = r2.f14717j;	 Catch:{ all -> 0x0506 }
        r9 = r9.mo3474u();	 Catch:{ all -> 0x0506 }
        if (r9 != 0) goto L_0x020c;
    L_0x0205:
        r3 = "Webview is not yet available, size is not set.";
        r2.m6783a(r3);	 Catch:{ all -> 0x0506 }
        monitor-exit(r4);	 Catch:{ all -> 0x0506 }
        return;
    L_0x020c:
        r9 = r2.f14717j;	 Catch:{ all -> 0x0506 }
        r9 = r9.mo3474u();	 Catch:{ all -> 0x0506 }
        r9 = r9.m5488c();	 Catch:{ all -> 0x0506 }
        if (r9 == 0) goto L_0x021f;
    L_0x0218:
        r3 = "Is interstitial. Cannot resize an interstitial.";
        r2.m6783a(r3);	 Catch:{ all -> 0x0506 }
        monitor-exit(r4);	 Catch:{ all -> 0x0506 }
        return;
    L_0x021f:
        r9 = r2.f14717j;	 Catch:{ all -> 0x0506 }
        r9 = r9.mo3476z();	 Catch:{ all -> 0x0506 }
        if (r9 == 0) goto L_0x022e;
    L_0x0227:
        r3 = "Cannot resize an expanded banner.";
        r2.m6783a(r3);	 Catch:{ all -> 0x0506 }
        monitor-exit(r4);	 Catch:{ all -> 0x0506 }
        return;
    L_0x022e:
        r9 = "width";
        r9 = r3.get(r9);	 Catch:{ all -> 0x0506 }
        r9 = (java.lang.CharSequence) r9;	 Catch:{ all -> 0x0506 }
        r9 = android.text.TextUtils.isEmpty(r9);	 Catch:{ all -> 0x0506 }
        if (r9 != 0) goto L_0x024d;
    L_0x023c:
        com.google.android.gms.ads.internal.zzbs.m4486e();	 Catch:{ all -> 0x0506 }
        r9 = "width";
        r9 = r3.get(r9);	 Catch:{ all -> 0x0506 }
        r9 = (java.lang.String) r9;	 Catch:{ all -> 0x0506 }
        r9 = com.google.android.gms.internal.zzahn.m5185b(r9);	 Catch:{ all -> 0x0506 }
        r2.f14715h = r9;	 Catch:{ all -> 0x0506 }
    L_0x024d:
        r9 = "height";
        r9 = r3.get(r9);	 Catch:{ all -> 0x0506 }
        r9 = (java.lang.CharSequence) r9;	 Catch:{ all -> 0x0506 }
        r9 = android.text.TextUtils.isEmpty(r9);	 Catch:{ all -> 0x0506 }
        if (r9 != 0) goto L_0x026c;
    L_0x025b:
        com.google.android.gms.ads.internal.zzbs.m4486e();	 Catch:{ all -> 0x0506 }
        r9 = "height";
        r9 = r3.get(r9);	 Catch:{ all -> 0x0506 }
        r9 = (java.lang.String) r9;	 Catch:{ all -> 0x0506 }
        r9 = com.google.android.gms.internal.zzahn.m5185b(r9);	 Catch:{ all -> 0x0506 }
        r2.f14712e = r9;	 Catch:{ all -> 0x0506 }
    L_0x026c:
        r9 = "offsetX";
        r9 = r3.get(r9);	 Catch:{ all -> 0x0506 }
        r9 = (java.lang.CharSequence) r9;	 Catch:{ all -> 0x0506 }
        r9 = android.text.TextUtils.isEmpty(r9);	 Catch:{ all -> 0x0506 }
        if (r9 != 0) goto L_0x028b;
    L_0x027a:
        com.google.android.gms.ads.internal.zzbs.m4486e();	 Catch:{ all -> 0x0506 }
        r9 = "offsetX";
        r9 = r3.get(r9);	 Catch:{ all -> 0x0506 }
        r9 = (java.lang.String) r9;	 Catch:{ all -> 0x0506 }
        r9 = com.google.android.gms.internal.zzahn.m5185b(r9);	 Catch:{ all -> 0x0506 }
        r2.f14713f = r9;	 Catch:{ all -> 0x0506 }
    L_0x028b:
        r9 = "offsetY";
        r9 = r3.get(r9);	 Catch:{ all -> 0x0506 }
        r9 = (java.lang.CharSequence) r9;	 Catch:{ all -> 0x0506 }
        r9 = android.text.TextUtils.isEmpty(r9);	 Catch:{ all -> 0x0506 }
        if (r9 != 0) goto L_0x02aa;
    L_0x0299:
        com.google.android.gms.ads.internal.zzbs.m4486e();	 Catch:{ all -> 0x0506 }
        r9 = "offsetY";
        r9 = r3.get(r9);	 Catch:{ all -> 0x0506 }
        r9 = (java.lang.String) r9;	 Catch:{ all -> 0x0506 }
        r9 = com.google.android.gms.internal.zzahn.m5185b(r9);	 Catch:{ all -> 0x0506 }
        r2.f14714g = r9;	 Catch:{ all -> 0x0506 }
    L_0x02aa:
        r9 = "allowOffscreen";
        r9 = r3.get(r9);	 Catch:{ all -> 0x0506 }
        r9 = (java.lang.CharSequence) r9;	 Catch:{ all -> 0x0506 }
        r9 = android.text.TextUtils.isEmpty(r9);	 Catch:{ all -> 0x0506 }
        if (r9 != 0) goto L_0x02c6;
    L_0x02b8:
        r9 = "allowOffscreen";
        r9 = r3.get(r9);	 Catch:{ all -> 0x0506 }
        r9 = (java.lang.String) r9;	 Catch:{ all -> 0x0506 }
        r9 = java.lang.Boolean.parseBoolean(r9);	 Catch:{ all -> 0x0506 }
        r2.f14709b = r9;	 Catch:{ all -> 0x0506 }
    L_0x02c6:
        r9 = "customClosePosition";
        r3 = r3.get(r9);	 Catch:{ all -> 0x0506 }
        r3 = (java.lang.String) r3;	 Catch:{ all -> 0x0506 }
        r9 = android.text.TextUtils.isEmpty(r3);	 Catch:{ all -> 0x0506 }
        if (r9 != 0) goto L_0x02d6;
    L_0x02d4:
        r2.f14708a = r3;	 Catch:{ all -> 0x0506 }
    L_0x02d6:
        r3 = r2.f14715h;	 Catch:{ all -> 0x0506 }
        r9 = 0;
        if (r3 < 0) goto L_0x02e1;
    L_0x02db:
        r3 = r2.f14712e;	 Catch:{ all -> 0x0506 }
        if (r3 < 0) goto L_0x02e1;
    L_0x02df:
        r3 = r8;
        goto L_0x02e2;
    L_0x02e1:
        r3 = r9;
    L_0x02e2:
        if (r3 != 0) goto L_0x02eb;
    L_0x02e4:
        r3 = "Invalid width and height options. Cannot resize.";
        r2.m6783a(r3);	 Catch:{ all -> 0x0506 }
        monitor-exit(r4);	 Catch:{ all -> 0x0506 }
        return;
    L_0x02eb:
        r3 = r2.f14718k;	 Catch:{ all -> 0x0506 }
        r3 = r3.getWindow();	 Catch:{ all -> 0x0506 }
        if (r3 == 0) goto L_0x04ff;
    L_0x02f3:
        r10 = r3.getDecorView();	 Catch:{ all -> 0x0506 }
        if (r10 != 0) goto L_0x02fb;
    L_0x02f9:
        goto L_0x04ff;
    L_0x02fb:
        r10 = r2.m14429a();	 Catch:{ all -> 0x0506 }
        if (r10 != 0) goto L_0x0308;
    L_0x0301:
        r3 = "Resize location out of screen or close button is not visible.";
        r2.m6783a(r3);	 Catch:{ all -> 0x0506 }
        monitor-exit(r4);	 Catch:{ all -> 0x0506 }
        return;
    L_0x0308:
        com.google.android.gms.internal.zzkb.m6345a();	 Catch:{ all -> 0x0506 }
        r11 = r2.f14718k;	 Catch:{ all -> 0x0506 }
        r12 = r2.f14715h;	 Catch:{ all -> 0x0506 }
        r11 = com.google.android.gms.internal.zzajr.m5318a(r11, r12);	 Catch:{ all -> 0x0506 }
        com.google.android.gms.internal.zzkb.m6345a();	 Catch:{ all -> 0x0506 }
        r12 = r2.f14718k;	 Catch:{ all -> 0x0506 }
        r13 = r2.f14712e;	 Catch:{ all -> 0x0506 }
        r12 = com.google.android.gms.internal.zzajr.m5318a(r12, r13);	 Catch:{ all -> 0x0506 }
        r13 = r2.f14717j;	 Catch:{ all -> 0x0506 }
        if (r13 != 0) goto L_0x0323;
    L_0x0322:
        throw r6;	 Catch:{ all -> 0x0506 }
    L_0x0323:
        r13 = (android.view.View) r13;	 Catch:{ all -> 0x0506 }
        r13 = r13.getParent();	 Catch:{ all -> 0x0506 }
        if (r13 == 0) goto L_0x04f8;
    L_0x032b:
        r14 = r13 instanceof android.view.ViewGroup;	 Catch:{ all -> 0x0506 }
        if (r14 == 0) goto L_0x04f8;
    L_0x032f:
        r14 = r13;
        r14 = (android.view.ViewGroup) r14;	 Catch:{ all -> 0x0506 }
        r15 = r2.f14717j;	 Catch:{ all -> 0x0506 }
        if (r15 != 0) goto L_0x0337;
    L_0x0336:
        throw r6;	 Catch:{ all -> 0x0506 }
    L_0x0337:
        r15 = (android.view.View) r15;	 Catch:{ all -> 0x0506 }
        r14.removeView(r15);	 Catch:{ all -> 0x0506 }
        r14 = r2.f14723p;	 Catch:{ all -> 0x0506 }
        if (r14 != 0) goto L_0x0370;
    L_0x0340:
        r13 = (android.view.ViewGroup) r13;	 Catch:{ all -> 0x0506 }
        r2.f14725r = r13;	 Catch:{ all -> 0x0506 }
        com.google.android.gms.ads.internal.zzbs.m4486e();	 Catch:{ all -> 0x0506 }
        r13 = r2.f14717j;	 Catch:{ all -> 0x0506 }
        if (r13 != 0) goto L_0x034c;
    L_0x034b:
        throw r6;	 Catch:{ all -> 0x0506 }
    L_0x034c:
        r13 = (android.view.View) r13;	 Catch:{ all -> 0x0506 }
        r13 = com.google.android.gms.internal.zzahn.m5151a(r13);	 Catch:{ all -> 0x0506 }
        r14 = new android.widget.ImageView;	 Catch:{ all -> 0x0506 }
        r15 = r2.f14718k;	 Catch:{ all -> 0x0506 }
        r14.<init>(r15);	 Catch:{ all -> 0x0506 }
        r2.f14720m = r14;	 Catch:{ all -> 0x0506 }
        r14 = r2.f14720m;	 Catch:{ all -> 0x0506 }
        r14.setImageBitmap(r13);	 Catch:{ all -> 0x0506 }
        r13 = r2.f14717j;	 Catch:{ all -> 0x0506 }
        r13 = r13.mo3474u();	 Catch:{ all -> 0x0506 }
        r2.f14719l = r13;	 Catch:{ all -> 0x0506 }
        r13 = r2.f14725r;	 Catch:{ all -> 0x0506 }
        r14 = r2.f14720m;	 Catch:{ all -> 0x0506 }
        r13.addView(r14);	 Catch:{ all -> 0x0506 }
        goto L_0x0375;
    L_0x0370:
        r13 = r2.f14723p;	 Catch:{ all -> 0x0506 }
        r13.dismiss();	 Catch:{ all -> 0x0506 }
    L_0x0375:
        r13 = new android.widget.RelativeLayout;	 Catch:{ all -> 0x0506 }
        r14 = r2.f14718k;	 Catch:{ all -> 0x0506 }
        r13.<init>(r14);	 Catch:{ all -> 0x0506 }
        r2.f14724q = r13;	 Catch:{ all -> 0x0506 }
        r13 = r2.f14724q;	 Catch:{ all -> 0x0506 }
        r13.setBackgroundColor(r9);	 Catch:{ all -> 0x0506 }
        r13 = r2.f14724q;	 Catch:{ all -> 0x0506 }
        r14 = new android.view.ViewGroup$LayoutParams;	 Catch:{ all -> 0x0506 }
        r14.<init>(r11, r12);	 Catch:{ all -> 0x0506 }
        r13.setLayoutParams(r14);	 Catch:{ all -> 0x0506 }
        com.google.android.gms.ads.internal.zzbs.m4486e();	 Catch:{ all -> 0x0506 }
        r13 = r2.f14724q;	 Catch:{ all -> 0x0506 }
        r13 = com.google.android.gms.internal.zzahn.m5155a(r13, r11, r12);	 Catch:{ all -> 0x0506 }
        r2.f14723p = r13;	 Catch:{ all -> 0x0506 }
        r13 = r2.f14723p;	 Catch:{ all -> 0x0506 }
        r13.setOutsideTouchable(r8);	 Catch:{ all -> 0x0506 }
        r13 = r2.f14723p;	 Catch:{ all -> 0x0506 }
        r13.setTouchable(r8);	 Catch:{ all -> 0x0506 }
        r13 = r2.f14723p;	 Catch:{ all -> 0x0506 }
        r14 = r2.f14709b;	 Catch:{ all -> 0x0506 }
        r14 = r14 ^ r8;
        r13.setClippingEnabled(r14);	 Catch:{ all -> 0x0506 }
        r13 = r2.f14724q;	 Catch:{ all -> 0x0506 }
        r14 = r2.f14717j;	 Catch:{ all -> 0x0506 }
        if (r14 != 0) goto L_0x03b1;
    L_0x03b0:
        throw r6;	 Catch:{ all -> 0x0506 }
    L_0x03b1:
        r14 = (android.view.View) r14;	 Catch:{ all -> 0x0506 }
        r13.addView(r14, r7, r7);	 Catch:{ all -> 0x0506 }
        r13 = new android.widget.LinearLayout;	 Catch:{ all -> 0x0506 }
        r14 = r2.f14718k;	 Catch:{ all -> 0x0506 }
        r13.<init>(r14);	 Catch:{ all -> 0x0506 }
        r2.f14721n = r13;	 Catch:{ all -> 0x0506 }
        r13 = new android.widget.RelativeLayout$LayoutParams;	 Catch:{ all -> 0x0506 }
        com.google.android.gms.internal.zzkb.m6345a();	 Catch:{ all -> 0x0506 }
        r14 = r2.f14718k;	 Catch:{ all -> 0x0506 }
        r15 = 50;
        r14 = com.google.android.gms.internal.zzajr.m5318a(r14, r15);	 Catch:{ all -> 0x0506 }
        com.google.android.gms.internal.zzkb.m6345a();	 Catch:{ all -> 0x0506 }
        r5 = r2.f14718k;	 Catch:{ all -> 0x0506 }
        r5 = com.google.android.gms.internal.zzajr.m5318a(r5, r15);	 Catch:{ all -> 0x0506 }
        r13.<init>(r14, r5);	 Catch:{ all -> 0x0506 }
        r5 = r2.f14708a;	 Catch:{ all -> 0x0506 }
        r14 = r5.hashCode();	 Catch:{ all -> 0x0506 }
        switch(r14) {
            case -1364013995: goto L_0x0414;
            case -1012429441: goto L_0x040a;
            case -655373719: goto L_0x0400;
            case 1163912186: goto L_0x03f6;
            case 1288627767: goto L_0x03ec;
            case 1755462605: goto L_0x03e2;
            default: goto L_0x03e1;
        };	 Catch:{ all -> 0x0506 }
    L_0x03e1:
        goto L_0x041e;
    L_0x03e2:
        r14 = "top-center";
        r5 = r5.equals(r14);	 Catch:{ all -> 0x0506 }
        if (r5 == 0) goto L_0x041e;
    L_0x03ea:
        r5 = r8;
        goto L_0x041f;
    L_0x03ec:
        r14 = "bottom-center";
        r5 = r5.equals(r14);	 Catch:{ all -> 0x0506 }
        if (r5 == 0) goto L_0x041e;
    L_0x03f4:
        r5 = 4;
        goto L_0x041f;
    L_0x03f6:
        r14 = "bottom-right";
        r5 = r5.equals(r14);	 Catch:{ all -> 0x0506 }
        if (r5 == 0) goto L_0x041e;
    L_0x03fe:
        r5 = 5;
        goto L_0x041f;
    L_0x0400:
        r14 = "bottom-left";
        r5 = r5.equals(r14);	 Catch:{ all -> 0x0506 }
        if (r5 == 0) goto L_0x041e;
    L_0x0408:
        r5 = 3;
        goto L_0x041f;
    L_0x040a:
        r14 = "top-left";
        r5 = r5.equals(r14);	 Catch:{ all -> 0x0506 }
        if (r5 == 0) goto L_0x041e;
    L_0x0412:
        r5 = r9;
        goto L_0x041f;
    L_0x0414:
        r14 = "center";
        r5 = r5.equals(r14);	 Catch:{ all -> 0x0506 }
        if (r5 == 0) goto L_0x041e;
    L_0x041c:
        r5 = 2;
        goto L_0x041f;
    L_0x041e:
        r5 = r7;
    L_0x041f:
        r7 = 9;
        r14 = 14;
        r15 = 11;
        r6 = 12;
        r8 = 10;
        switch(r5) {
            case 0: goto L_0x044f;
            case 1: goto L_0x044b;
            case 2: goto L_0x0445;
            case 3: goto L_0x043e;
            case 4: goto L_0x0437;
            case 5: goto L_0x0430;
            default: goto L_0x042c;
        };	 Catch:{ all -> 0x0506 }
    L_0x042c:
        r13.addRule(r8);	 Catch:{ all -> 0x0506 }
        goto L_0x0433;
    L_0x0430:
        r13.addRule(r6);	 Catch:{ all -> 0x0506 }
    L_0x0433:
        r13.addRule(r15);	 Catch:{ all -> 0x0506 }
        goto L_0x0453;
    L_0x0437:
        r13.addRule(r6);	 Catch:{ all -> 0x0506 }
    L_0x043a:
        r13.addRule(r14);	 Catch:{ all -> 0x0506 }
        goto L_0x0453;
    L_0x043e:
        r13.addRule(r6);	 Catch:{ all -> 0x0506 }
    L_0x0441:
        r13.addRule(r7);	 Catch:{ all -> 0x0506 }
        goto L_0x0453;
    L_0x0445:
        r5 = 13;
        r13.addRule(r5);	 Catch:{ all -> 0x0506 }
        goto L_0x0453;
    L_0x044b:
        r13.addRule(r8);	 Catch:{ all -> 0x0506 }
        goto L_0x043a;
    L_0x044f:
        r13.addRule(r8);	 Catch:{ all -> 0x0506 }
        goto L_0x0441;
    L_0x0453:
        r5 = r2.f14721n;	 Catch:{ all -> 0x0506 }
        r6 = new com.google.android.gms.internal.zzws;	 Catch:{ all -> 0x0506 }
        r6.<init>(r2);	 Catch:{ all -> 0x0506 }
        r5.setOnClickListener(r6);	 Catch:{ all -> 0x0506 }
        r5 = r2.f14721n;	 Catch:{ all -> 0x0506 }
        r6 = "Close button";
        r5.setContentDescription(r6);	 Catch:{ all -> 0x0506 }
        r5 = r2.f14724q;	 Catch:{ all -> 0x0506 }
        r6 = r2.f14721n;	 Catch:{ all -> 0x0506 }
        r5.addView(r6, r13);	 Catch:{ all -> 0x0506 }
        r5 = r2.f14723p;	 Catch:{ RuntimeException -> 0x04ac }
        r3 = r3.getDecorView();	 Catch:{ RuntimeException -> 0x04ac }
        com.google.android.gms.internal.zzkb.m6345a();	 Catch:{ RuntimeException -> 0x04ac }
        r6 = r2.f14718k;	 Catch:{ RuntimeException -> 0x04ac }
        r7 = r10[r9];	 Catch:{ RuntimeException -> 0x04ac }
        r6 = com.google.android.gms.internal.zzajr.m5318a(r6, r7);	 Catch:{ RuntimeException -> 0x04ac }
        com.google.android.gms.internal.zzkb.m6345a();	 Catch:{ RuntimeException -> 0x04ac }
        r7 = r2.f14718k;	 Catch:{ RuntimeException -> 0x04ac }
        r8 = 1;
        r13 = r10[r8];	 Catch:{ RuntimeException -> 0x04ac }
        r7 = com.google.android.gms.internal.zzajr.m5318a(r7, r13);	 Catch:{ RuntimeException -> 0x04ac }
        r5.showAtLocation(r3, r9, r6, r7);	 Catch:{ RuntimeException -> 0x04ac }
        r3 = r2.f14722o;	 Catch:{ all -> 0x0506 }
        if (r3 == 0) goto L_0x0494;
    L_0x048f:
        r3 = r2.f14722o;	 Catch:{ all -> 0x0506 }
        r3.mo4274G();	 Catch:{ all -> 0x0506 }
    L_0x0494:
        r3 = r2.f14717j;	 Catch:{ all -> 0x0506 }
        r5 = com.google.android.gms.internal.zzapa.m5485a(r11, r12);	 Catch:{ all -> 0x0506 }
        r3.mo3981a(r5);	 Catch:{ all -> 0x0506 }
        r3 = r10[r9];	 Catch:{ all -> 0x0506 }
        r5 = 1;
        r5 = r10[r5];	 Catch:{ all -> 0x0506 }
        r2.m14427a(r3, r5);	 Catch:{ all -> 0x0506 }
        r3 = "resized";
        r2.m6784b(r3);	 Catch:{ all -> 0x0506 }
        monitor-exit(r4);	 Catch:{ all -> 0x0506 }
        return;
    L_0x04ac:
        r0 = move-exception;
        r3 = r0;
        r5 = "Cannot show popup window: ";
        r3 = r3.getMessage();	 Catch:{ all -> 0x0506 }
        r3 = java.lang.String.valueOf(r3);	 Catch:{ all -> 0x0506 }
        r6 = r3.length();	 Catch:{ all -> 0x0506 }
        if (r6 == 0) goto L_0x04c3;
    L_0x04be:
        r3 = r5.concat(r3);	 Catch:{ all -> 0x0506 }
        goto L_0x04c8;
    L_0x04c3:
        r3 = new java.lang.String;	 Catch:{ all -> 0x0506 }
        r3.<init>(r5);	 Catch:{ all -> 0x0506 }
    L_0x04c8:
        r2.m6783a(r3);	 Catch:{ all -> 0x0506 }
        r3 = r2.f14724q;	 Catch:{ all -> 0x0506 }
        r5 = r2.f14717j;	 Catch:{ all -> 0x0506 }
        if (r5 != 0) goto L_0x04d3;
    L_0x04d1:
        r6 = 0;
        throw r6;	 Catch:{ all -> 0x0506 }
    L_0x04d3:
        r5 = (android.view.View) r5;	 Catch:{ all -> 0x0506 }
        r3.removeView(r5);	 Catch:{ all -> 0x0506 }
        r3 = r2.f14725r;	 Catch:{ all -> 0x0506 }
        if (r3 == 0) goto L_0x04f6;
    L_0x04dc:
        r3 = r2.f14725r;	 Catch:{ all -> 0x0506 }
        r5 = r2.f14720m;	 Catch:{ all -> 0x0506 }
        r3.removeView(r5);	 Catch:{ all -> 0x0506 }
        r3 = r2.f14725r;	 Catch:{ all -> 0x0506 }
        r5 = r2.f14717j;	 Catch:{ all -> 0x0506 }
        if (r5 != 0) goto L_0x04ea;
    L_0x04e9:
        goto L_0x04d1;
    L_0x04ea:
        r5 = (android.view.View) r5;	 Catch:{ all -> 0x0506 }
        r3.addView(r5);	 Catch:{ all -> 0x0506 }
        r3 = r2.f14717j;	 Catch:{ all -> 0x0506 }
        r2 = r2.f14719l;	 Catch:{ all -> 0x0506 }
        r3.mo3981a(r2);	 Catch:{ all -> 0x0506 }
    L_0x04f6:
        monitor-exit(r4);	 Catch:{ all -> 0x0506 }
        return;
    L_0x04f8:
        r3 = "Webview is detached, probably in the middle of a resize or expand.";
        r2.m6783a(r3);	 Catch:{ all -> 0x0506 }
        monitor-exit(r4);	 Catch:{ all -> 0x0506 }
        return;
    L_0x04ff:
        r3 = "Activity context is not ready, cannot get window or decor view.";
        r2.m6783a(r3);	 Catch:{ all -> 0x0506 }
        monitor-exit(r4);	 Catch:{ all -> 0x0506 }
        return;
    L_0x0506:
        r0 = move-exception;
        r2 = r0;
        monitor-exit(r4);	 Catch:{ all -> 0x0506 }
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.gmsg.zzaa.zza(java.lang.Object, java.util.Map):void");
    }
}
