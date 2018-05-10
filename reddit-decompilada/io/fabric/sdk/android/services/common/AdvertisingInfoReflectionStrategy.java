package io.fabric.sdk.android.services.common;

import android.content.Context;

class AdvertisingInfoReflectionStrategy implements AdvertisingInfoStrategy {
    private final Context f30992a;

    public AdvertisingInfoReflectionStrategy(Context context) {
        this.f30992a = context.getApplicationContext();
    }

    private static boolean m31956a(android.content.Context r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = "com.google.android.gms.common.GooglePlayServicesUtil";	 Catch:{ Exception -> 0x0027 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ Exception -> 0x0027 }
        r2 = "isGooglePlayServicesAvailable";	 Catch:{ Exception -> 0x0027 }
        r3 = 1;	 Catch:{ Exception -> 0x0027 }
        r4 = new java.lang.Class[r3];	 Catch:{ Exception -> 0x0027 }
        r5 = android.content.Context.class;	 Catch:{ Exception -> 0x0027 }
        r4[r0] = r5;	 Catch:{ Exception -> 0x0027 }
        r1 = r1.getMethod(r2, r4);	 Catch:{ Exception -> 0x0027 }
        r2 = 0;	 Catch:{ Exception -> 0x0027 }
        r4 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0027 }
        r4[r0] = r6;	 Catch:{ Exception -> 0x0027 }
        r6 = r1.invoke(r2, r4);	 Catch:{ Exception -> 0x0027 }
        r6 = (java.lang.Integer) r6;	 Catch:{ Exception -> 0x0027 }
        r6 = r6.intValue();	 Catch:{ Exception -> 0x0027 }
        if (r6 != 0) goto L_0x0026;
    L_0x0025:
        return r3;
    L_0x0026:
        return r0;
    L_0x0027:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.common.AdvertisingInfoReflectionStrategy.a(android.content.Context):boolean");
    }

    public final AdvertisingInfo mo5578a() {
        return m31956a(this.f30992a) ? new AdvertisingInfo(m31957b(), m31958c()) : null;
    }

    private java.lang.String m31957b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = "com.google.android.gms.ads.identifier.AdvertisingIdClient$Info";	 Catch:{ Exception -> 0x001c }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x001c }
        r1 = "getId";	 Catch:{ Exception -> 0x001c }
        r2 = 0;	 Catch:{ Exception -> 0x001c }
        r3 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x001c }
        r0 = r0.getMethod(r1, r3);	 Catch:{ Exception -> 0x001c }
        r1 = r4.m31959d();	 Catch:{ Exception -> 0x001c }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x001c }
        r0 = r0.invoke(r1, r2);	 Catch:{ Exception -> 0x001c }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x001c }
        return r0;
    L_0x001c:
        r0 = io.fabric.sdk.android.Fabric.m26243b();
        r1 = "Fabric";
        r2 = "Could not call getId on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info";
        r0.mo5569d(r1, r2);
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.common.AdvertisingInfoReflectionStrategy.b():java.lang.String");
    }

    private boolean m31958c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = 0;
        r1 = "com.google.android.gms.ads.identifier.AdvertisingIdClient$Info";	 Catch:{ Exception -> 0x0020 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ Exception -> 0x0020 }
        r2 = "isLimitAdTrackingEnabled";	 Catch:{ Exception -> 0x0020 }
        r3 = new java.lang.Class[r0];	 Catch:{ Exception -> 0x0020 }
        r1 = r1.getMethod(r2, r3);	 Catch:{ Exception -> 0x0020 }
        r2 = r4.m31959d();	 Catch:{ Exception -> 0x0020 }
        r3 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x0020 }
        r1 = r1.invoke(r2, r3);	 Catch:{ Exception -> 0x0020 }
        r1 = (java.lang.Boolean) r1;	 Catch:{ Exception -> 0x0020 }
        r1 = r1.booleanValue();	 Catch:{ Exception -> 0x0020 }
        return r1;
    L_0x0020:
        r1 = io.fabric.sdk.android.Fabric.m26243b();
        r2 = "Fabric";
        r3 = "Could not call isLimitAdTrackingEnabled on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info";
        r1.mo5569d(r2, r3);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.common.AdvertisingInfoReflectionStrategy.c():boolean");
    }

    private java.lang.Object m31959d() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = 0;
        r1 = "com.google.android.gms.ads.identifier.AdvertisingIdClient";	 Catch:{ Exception -> 0x0020 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ Exception -> 0x0020 }
        r2 = "getAdvertisingIdInfo";	 Catch:{ Exception -> 0x0020 }
        r3 = 1;	 Catch:{ Exception -> 0x0020 }
        r4 = new java.lang.Class[r3];	 Catch:{ Exception -> 0x0020 }
        r5 = android.content.Context.class;	 Catch:{ Exception -> 0x0020 }
        r6 = 0;	 Catch:{ Exception -> 0x0020 }
        r4[r6] = r5;	 Catch:{ Exception -> 0x0020 }
        r1 = r1.getMethod(r2, r4);	 Catch:{ Exception -> 0x0020 }
        r2 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0020 }
        r3 = r7.f30992a;	 Catch:{ Exception -> 0x0020 }
        r2[r6] = r3;	 Catch:{ Exception -> 0x0020 }
        r1 = r1.invoke(r0, r2);	 Catch:{ Exception -> 0x0020 }
        return r1;
    L_0x0020:
        r1 = io.fabric.sdk.android.Fabric.m26243b();
        r2 = "Fabric";
        r3 = "Could not call getAdvertisingIdInfo on com.google.android.gms.ads.identifier.AdvertisingIdClient";
        r1.mo5569d(r2, r3);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.common.AdvertisingInfoReflectionStrategy.d():java.lang.Object");
    }
}
