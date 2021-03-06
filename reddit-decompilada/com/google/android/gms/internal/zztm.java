package com.google.android.gms.internal;

import android.os.Parcel;
import android.util.Base64;
import com.google.android.gms.ads.internal.zzbs;
import java.io.IOException;

@zzzv
final class zztm {
    final zzjj f8025a;
    final String f8026b;
    final int f8027c;

    private zztm(zzjj com_google_android_gms_internal_zzjj, String str, int i) {
        this.f8025a = com_google_android_gms_internal_zzjj;
        this.f8026b = str;
        this.f8027c = i;
    }

    static zztm m6657a(String str) throws IOException {
        String[] split = str.split("\u0000");
        if (split.length != 3) {
            throw new IOException("Incorrect field count for QueueSeed.");
        }
        Parcel obtain = Parcel.obtain();
        try {
            String str2 = new String(Base64.decode(split[0], 0), "UTF-8");
            int parseInt = Integer.parseInt(split[1]);
            byte[] decode = Base64.decode(split[2], 0);
            obtain.unmarshall(decode, 0, decode.length);
            obtain.setDataPosition(0);
            zztm com_google_android_gms_internal_zztm = new zztm((zzjj) zzjj.CREATOR.createFromParcel(obtain), str2, parseInt);
            obtain.recycle();
            return com_google_android_gms_internal_zztm;
        } catch (Throwable e) {
            zzbs.m4490i().m13246a(e, "QueueSeed.decode");
            throw new IOException("Malformed QueueSeed encoding.", e);
        } catch (Throwable th) {
            obtain.recycle();
        }
    }

    final java.lang.String m6658a() {
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
        r6 = this;
        r0 = android.os.Parcel.obtain();
        r1 = r6.f8026b;	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r2 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r1 = r1.getBytes(r2);	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r2 = 0;	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r1 = android.util.Base64.encodeToString(r1, r2);	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r3 = r6.f8027c;	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r3 = java.lang.Integer.toString(r3);	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r4 = r6.f8025a;	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r4.writeToParcel(r0, r2);	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r4 = r0.marshall();	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r2 = android.util.Base64.encodeToString(r4, r2);	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r4 = 2;	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r5 = java.lang.String.valueOf(r1);	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r5 = r5.length();	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r4 = r4 + r5;	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r5 = java.lang.String.valueOf(r3);	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r5 = r5.length();	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r4 = r4 + r5;	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r5 = java.lang.String.valueOf(r2);	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r5 = r5.length();	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r4 = r4 + r5;	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r5 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r5.<init>(r4);	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r5.append(r1);	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r1 = "\u0000";	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r5.append(r1);	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r5.append(r3);	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r1 = "\u0000";	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r5.append(r1);	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r5.append(r2);	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r1 = r5.toString();	 Catch:{ UnsupportedEncodingException -> 0x0062 }
        r0.recycle();
        return r1;
    L_0x0060:
        r1 = move-exception;
        goto L_0x006d;
    L_0x0062:
        r1 = "QueueSeed encode failed because UTF-8 is not available.";	 Catch:{ all -> 0x0060 }
        com.google.android.gms.internal.zzakb.m5368c(r1);	 Catch:{ all -> 0x0060 }
        r0.recycle();
        r0 = "";
        return r0;
    L_0x006d:
        r0.recycle();
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zztm.a():java.lang.String");
    }

    zztm(zzti com_google_android_gms_internal_zzti) {
        this(com_google_android_gms_internal_zzti.f8008b, com_google_android_gms_internal_zzti.f8009c, com_google_android_gms_internal_zzti.f8010d);
    }
}
