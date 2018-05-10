package com.firebase.jobdispatcher;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.util.Pair;
import java.util.ArrayList;

final class GooglePlayCallbackExtractor {
    private static Boolean f3851a;

    GooglePlayCallbackExtractor() {
    }

    public static Pair<JobCallback, Bundle> m3462a(Bundle bundle) {
        if (bundle != null) {
            return m3465b(bundle);
        }
        Log.e("FJD.GooglePlayReceiver", "No callback received, terminating");
        return null;
    }

    @SuppressLint({"ParcelClassLoader"})
    private static Pair<JobCallback, Bundle> m3465b(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle = m3466c(bundle);
        Pair<JobCallback, Bundle> pair = null;
        if (bundle.readInt() <= 0) {
            Log.w("FJD.GooglePlayReceiver", "No callback received, terminating");
            return pair;
        } else if (bundle.readInt() != 1279544898) {
            Log.w("FJD.GooglePlayReceiver", "No callback received, terminating");
            bundle.recycle();
            return pair;
        } else {
            int readInt = bundle.readInt();
            Object obj = pair;
            for (int i = 0; i < readInt; i++) {
                String readString;
                if (m3464a()) {
                    readString = bundle.readString();
                } else {
                    Object readValue = bundle.readValue(pair);
                    if (readValue instanceof String) {
                        readString = (String) readValue;
                    } else {
                        Log.w("FJD.GooglePlayReceiver", "Bad callback received, terminating");
                        readString = pair;
                    }
                }
                if (readString != null) {
                    if (obj == null) {
                        if ("callback".equals(readString)) {
                            if (bundle.readInt() != 4) {
                                Log.w("FJD.GooglePlayReceiver", "Bad callback received, terminating");
                                bundle.recycle();
                                return pair;
                            }
                            try {
                                if ("com.google.android.gms.gcm.PendingCallback".equals(bundle.readString())) {
                                    obj = new GooglePlayJobCallback(bundle.readStrongBinder());
                                } else {
                                    Log.w("FJD.GooglePlayReceiver", "Bad callback received, terminating");
                                    bundle.recycle();
                                    return pair;
                                }
                            } finally {
                                bundle.recycle();
                            }
                        }
                    }
                    Object readValue2 = bundle.readValue(pair);
                    if (readValue2 instanceof String) {
                        bundle2.putString(readString, (String) readValue2);
                    } else if (readValue2 instanceof Boolean) {
                        bundle2.putBoolean(readString, ((Boolean) readValue2).booleanValue());
                    } else if (readValue2 instanceof Integer) {
                        bundle2.putInt(readString, ((Integer) readValue2).intValue());
                    } else if (readValue2 instanceof ArrayList) {
                        bundle2.putParcelableArrayList(readString, (ArrayList) readValue2);
                    } else if (readValue2 instanceof Bundle) {
                        bundle2.putBundle(readString, (Bundle) readValue2);
                    } else if (readValue2 instanceof Parcelable) {
                        bundle2.putParcelable(readString, (Parcelable) readValue2);
                    }
                }
            }
            if (obj == null) {
                Log.w("FJD.GooglePlayReceiver", "No callback received, terminating");
                bundle.recycle();
                return pair;
            }
            Pair<JobCallback, Bundle> create = Pair.create(obj, bundle2);
            bundle.recycle();
            return create;
        }
    }

    private static Parcel m3466c(Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        bundle.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        return obtain;
    }

    private static synchronized boolean m3464a() {
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
        r0 = com.firebase.jobdispatcher.GooglePlayCallbackExtractor.class;
        monitor-enter(r0);
        r1 = f3851a;	 Catch:{ all -> 0x0065 }
        if (r1 != 0) goto L_0x005d;	 Catch:{ all -> 0x0065 }
    L_0x0007:
        r1 = new android.os.Bundle;	 Catch:{ all -> 0x0065 }
        r1.<init>();	 Catch:{ all -> 0x0065 }
        r2 = "key";	 Catch:{ all -> 0x0065 }
        r3 = "value";	 Catch:{ all -> 0x0065 }
        r1.putString(r2, r3);	 Catch:{ all -> 0x0065 }
        r1 = m3466c(r1);	 Catch:{ all -> 0x0065 }
        r2 = r1.readInt();	 Catch:{ RuntimeException -> 0x0054 }
        r3 = 0;	 Catch:{ RuntimeException -> 0x0054 }
        r4 = 1;	 Catch:{ RuntimeException -> 0x0054 }
        if (r2 <= 0) goto L_0x0021;	 Catch:{ RuntimeException -> 0x0054 }
    L_0x001f:
        r2 = r4;	 Catch:{ RuntimeException -> 0x0054 }
        goto L_0x0022;	 Catch:{ RuntimeException -> 0x0054 }
    L_0x0021:
        r2 = r3;	 Catch:{ RuntimeException -> 0x0054 }
    L_0x0022:
        m3463a(r2);	 Catch:{ RuntimeException -> 0x0054 }
        r2 = r1.readInt();	 Catch:{ RuntimeException -> 0x0054 }
        r5 = 1279544898; // 0x4c444e42 float:5.146036E7 double:6.321791764E-315;	 Catch:{ RuntimeException -> 0x0054 }
        if (r2 != r5) goto L_0x0030;	 Catch:{ RuntimeException -> 0x0054 }
    L_0x002e:
        r2 = r4;	 Catch:{ RuntimeException -> 0x0054 }
        goto L_0x0031;	 Catch:{ RuntimeException -> 0x0054 }
    L_0x0030:
        r2 = r3;	 Catch:{ RuntimeException -> 0x0054 }
    L_0x0031:
        m3463a(r2);	 Catch:{ RuntimeException -> 0x0054 }
        r2 = r1.readInt();	 Catch:{ RuntimeException -> 0x0054 }
        if (r2 != r4) goto L_0x003b;	 Catch:{ RuntimeException -> 0x0054 }
    L_0x003a:
        r3 = r4;	 Catch:{ RuntimeException -> 0x0054 }
    L_0x003b:
        m3463a(r3);	 Catch:{ RuntimeException -> 0x0054 }
        r2 = "key";	 Catch:{ RuntimeException -> 0x0054 }
        r3 = r1.readString();	 Catch:{ RuntimeException -> 0x0054 }
        r2 = r2.equals(r3);	 Catch:{ RuntimeException -> 0x0054 }
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ RuntimeException -> 0x0054 }
        f3851a = r2;	 Catch:{ RuntimeException -> 0x0054 }
    L_0x004e:
        r1.recycle();	 Catch:{ all -> 0x0065 }
        goto L_0x005d;
    L_0x0052:
        r2 = move-exception;
        goto L_0x0059;
    L_0x0054:
        r2 = java.lang.Boolean.FALSE;	 Catch:{ all -> 0x0052 }
        f3851a = r2;	 Catch:{ all -> 0x0052 }
        goto L_0x004e;
    L_0x0059:
        r1.recycle();	 Catch:{ all -> 0x0065 }
        throw r2;	 Catch:{ all -> 0x0065 }
    L_0x005d:
        r1 = f3851a;	 Catch:{ all -> 0x0065 }
        r1 = r1.booleanValue();	 Catch:{ all -> 0x0065 }
        monitor-exit(r0);
        return r1;
    L_0x0065:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.jobdispatcher.GooglePlayCallbackExtractor.a():boolean");
    }

    private static void m3463a(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }
}
