package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.content.WakefulBroadcastReceiver;

public final class FirebaseInstanceIdReceiver extends WakefulBroadcastReceiver {
    private static boolean f14972a = false;
    private static zzh f14973b;
    private static zzh f14974c;

    private static synchronized zzh m14885a(Context context, String str) {
        synchronized (FirebaseInstanceIdReceiver.class) {
            if ("com.google.firebase.MESSAGING_EVENT".equals(str)) {
                if (f14974c == null) {
                    f14974c = new zzh(context, str);
                }
                zzh com_google_firebase_iid_zzh = f14974c;
                return com_google_firebase_iid_zzh;
            }
            if (f14973b == null) {
                f14973b = new zzh(context, str);
            }
            com_google_firebase_iid_zzh = f14973b;
            return com_google_firebase_iid_zzh;
        }
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
            if (parcelableExtra instanceof Intent) {
                m14886a(context, (Intent) parcelableExtra, intent.getAction());
            } else {
                m14886a(context, intent, intent.getAction());
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m14886a(android.content.Context r7, android.content.Intent r8, java.lang.String r9) {
        /*
        r6 = this;
        r0 = 0;
        r8.setComponent(r0);
        r1 = r7.getPackageName();
        r8.setPackage(r1);
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 18;
        if (r1 > r2) goto L_0x0018;
    L_0x0011:
        r1 = r7.getPackageName();
        r8.removeCategory(r1);
    L_0x0018:
        r1 = "gcm.rawData64";
        r1 = r8.getStringExtra(r1);
        r2 = 0;
        if (r1 == 0) goto L_0x002f;
    L_0x0021:
        r3 = "rawData";
        r1 = android.util.Base64.decode(r1, r2);
        r8.putExtra(r3, r1);
        r1 = "gcm.rawData64";
        r8.removeExtra(r1);
    L_0x002f:
        r1 = "from";
        r1 = r8.getStringExtra(r1);
        r3 = "google.com/iid";
        r1 = r3.equals(r1);
        if (r1 != 0) goto L_0x0062;
    L_0x003d:
        r1 = "com.google.firebase.INSTANCE_ID_EVENT";
        r1 = r1.equals(r9);
        if (r1 == 0) goto L_0x0046;
    L_0x0045:
        goto L_0x0062;
    L_0x0046:
        r1 = "com.google.android.c2dm.intent.RECEIVE";
        r1 = r1.equals(r9);
        if (r1 != 0) goto L_0x005f;
    L_0x004e:
        r1 = "com.google.firebase.MESSAGING_EVENT";
        r9 = r1.equals(r9);
        if (r9 == 0) goto L_0x0057;
    L_0x0056:
        goto L_0x005f;
    L_0x0057:
        r9 = "FirebaseInstanceId";
        r1 = "Unexpected intent";
        android.util.Log.d(r9, r1);
        goto L_0x0064;
    L_0x005f:
        r0 = "com.google.firebase.MESSAGING_EVENT";
        goto L_0x0064;
    L_0x0062:
        r0 = "com.google.firebase.INSTANCE_ID_EVENT";
    L_0x0064:
        r9 = -1;
        if (r0 == 0) goto L_0x00f4;
    L_0x0067:
        r1 = com.google.android.gms.common.util.zzq.m4917i();
        r3 = 1;
        if (r1 == 0) goto L_0x007a;
    L_0x006e:
        r1 = r7.getApplicationInfo();
        r1 = r1.targetSdkVersion;
        r4 = 26;
        if (r1 < r4) goto L_0x007a;
    L_0x0078:
        r1 = r3;
        goto L_0x007b;
    L_0x007a:
        r1 = r2;
    L_0x007b:
        if (r1 == 0) goto L_0x0092;
    L_0x007d:
        r1 = r6.isOrderedBroadcast();
        if (r1 == 0) goto L_0x0086;
    L_0x0083:
        r6.setResultCode(r9);
    L_0x0086:
        r7 = m14885a(r7, r0);
        r0 = r6.goAsync();
        r7.m7382a(r8, r0);
        goto L_0x00f4;
    L_0x0092:
        r1 = com.google.firebase.iid.zzx.m7416a();
        r4 = r0.hashCode();
        r5 = -842411455; // 0xffffffffcdc9d241 float:-4.23249952E8 double:NaN;
        if (r4 == r5) goto L_0x00af;
    L_0x009f:
        r2 = 41532704; // 0x279bd20 float:1.8347907E-37 double:2.0519882E-316;
        if (r4 == r2) goto L_0x00a5;
    L_0x00a4:
        goto L_0x00b8;
    L_0x00a5:
        r2 = "com.google.firebase.MESSAGING_EVENT";
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x00b8;
    L_0x00ad:
        r9 = r3;
        goto L_0x00b8;
    L_0x00af:
        r3 = "com.google.firebase.INSTANCE_ID_EVENT";
        r3 = r0.equals(r3);
        if (r3 == 0) goto L_0x00b8;
    L_0x00b7:
        r9 = r2;
    L_0x00b8:
        switch(r9) {
            case 0: goto L_0x00d1;
            case 1: goto L_0x00ce;
            default: goto L_0x00bb;
        };
    L_0x00bb:
        r7 = "FirebaseInstanceId";
        r8 = "Unknown service action: ";
        r9 = java.lang.String.valueOf(r0);
        r0 = r9.length();
        if (r0 == 0) goto L_0x00e8;
    L_0x00c9:
        r8 = r8.concat(r9);
        goto L_0x00ee;
    L_0x00ce:
        r9 = r1.f8686b;
        goto L_0x00d3;
    L_0x00d1:
        r9 = r1.f8685a;
    L_0x00d3:
        r9.offer(r8);
        r8 = new android.content.Intent;
        r8.<init>(r0);
        r9 = r7.getPackageName();
        r8.setPackage(r9);
        r7 = r1.m7417a(r7, r8);
    L_0x00e6:
        r9 = r7;
        goto L_0x00f4;
    L_0x00e8:
        r9 = new java.lang.String;
        r9.<init>(r8);
        r8 = r9;
    L_0x00ee:
        android.util.Log.w(r7, r8);
        r7 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        goto L_0x00e6;
    L_0x00f4:
        r7 = r6.isOrderedBroadcast();
        if (r7 == 0) goto L_0x00fd;
    L_0x00fa:
        r6.setResultCode(r9);
    L_0x00fd:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdReceiver.a(android.content.Context, android.content.Intent, java.lang.String):void");
    }
}
