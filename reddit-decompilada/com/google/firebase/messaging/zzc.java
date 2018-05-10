package com.google.firebase.messaging;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.zzfkt;
import com.google.android.gms.internal.zzfku;
import com.google.android.gms.measurement.AppMeasurement;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class zzc {
    private static Bundle m7450a(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(str, str2);
        return bundle;
    }

    private static com.google.android.gms.internal.zzfku m7451a(byte[] r0) {
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
        r0 = com.google.android.gms.internal.zzfku.m18744a(r0);	 Catch:{ zzfjr -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.zzc.a(byte[]):com.google.android.gms.internal.zzfku");
    }

    private static com.google.android.gms.measurement.AppMeasurement m7452a(android.content.Context r0) {
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
        r0 = com.google.android.gms.measurement.AppMeasurement.getInstance(r0);	 Catch:{ NoClassDefFoundError -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.zzc.a(android.content.Context):com.google.android.gms.measurement.AppMeasurement");
    }

    private static String m7455a(Object obj) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        return (String) Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty").getField("mName").get(obj);
    }

    private static List<Object> m7456a(AppMeasurement appMeasurement, String str) {
        List<Object> list;
        ArrayList arrayList = new ArrayList();
        try {
            Method declaredMethod = AppMeasurement.class.getDeclaredMethod("getConditionalUserProperties", new Class[]{String.class, String.class});
            declaredMethod.setAccessible(true);
            list = (List) declaredMethod.invoke(appMeasurement, new Object[]{str, ""});
        } catch (Throwable e) {
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            list = arrayList;
        }
        if (Log.isLoggable("FirebaseAbtUtil", 2)) {
            int size = list.size();
            StringBuilder stringBuilder = new StringBuilder(55 + String.valueOf(str).length());
            stringBuilder.append("Number of currently set _Es for origin: ");
            stringBuilder.append(str);
            stringBuilder.append(" is ");
            stringBuilder.append(size);
            Log.v("FirebaseAbtUtil", stringBuilder.toString());
        }
        return list;
    }

    private static void m7457a(Context context, String str, String str2, String str3, String str4) {
        if (Log.isLoggable("FirebaseAbtUtil", 2)) {
            String str5 = "FirebaseAbtUtil";
            String str6 = "_CE(experimentId) called by ";
            str = String.valueOf(str);
            Log.v(str5, str.length() != 0 ? str6.concat(str) : new String(str6));
        }
        if (m7462b(context)) {
            AppMeasurement a = m7452a(context);
            try {
                Method declaredMethod = AppMeasurement.class.getDeclaredMethod("clearConditionalUserProperty", new Class[]{String.class, String.class, Bundle.class});
                declaredMethod.setAccessible(true);
                if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                    StringBuilder stringBuilder = new StringBuilder((17 + String.valueOf(str2).length()) + String.valueOf(str3).length());
                    stringBuilder.append("Clearing _E: [");
                    stringBuilder.append(str2);
                    stringBuilder.append(", ");
                    stringBuilder.append(str3);
                    stringBuilder.append("]");
                    Log.v("FirebaseAbtUtil", stringBuilder.toString());
                }
                declaredMethod.invoke(a, new Object[]{str2, str4, m7450a(str2, str3)});
            } catch (Throwable e) {
                Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            }
        }
    }

    public static void m7458a(Context context, String str, byte[] bArr, zzb com_google_firebase_messaging_zzb) {
        Context context2 = context;
        String str2 = str;
        zzb com_google_firebase_messaging_zzb2 = com_google_firebase_messaging_zzb;
        int i = 2;
        if (Log.isLoggable("FirebaseAbtUtil", 2)) {
            String str3 = "FirebaseAbtUtil";
            String str4 = "_SE called by ";
            String valueOf = String.valueOf(str);
            Log.v(str3, valueOf.length() != 0 ? str4.concat(valueOf) : new String(str4));
        }
        if (m7462b(context)) {
            AppMeasurement a = m7452a(context);
            zzfku a2 = m7451a(bArr);
            if (a2 == null) {
                if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                    Log.v("FirebaseAbtUtil", "_SE failed; either _P was not set, or we couldn't deserialize the _P.");
                }
                return;
            }
            try {
                Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty");
                Object obj = null;
                for (Object next : m7456a(a, str2)) {
                    String a3 = m7455a(next);
                    String b = m7461b(next);
                    long longValue = ((Long) Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty").getField("mCreationTimestamp").get(next)).longValue();
                    if (a2.f18100a.equals(a3) && a2.f18101b.equals(b)) {
                        if (Log.isLoggable("FirebaseAbtUtil", i)) {
                            StringBuilder stringBuilder = new StringBuilder((23 + String.valueOf(a3).length()) + String.valueOf(b).length());
                            stringBuilder.append("_E is already set. [");
                            stringBuilder.append(a3);
                            stringBuilder.append(", ");
                            stringBuilder.append(b);
                            stringBuilder.append("]");
                            Log.v("FirebaseAbtUtil", stringBuilder.toString());
                        }
                        obj = 1;
                    } else {
                        StringBuilder stringBuilder2;
                        Object obj2;
                        zzfkt[] com_google_android_gms_internal_zzfktArr = a2.f18112m;
                        int length = com_google_android_gms_internal_zzfktArr.length;
                        int i2 = 0;
                        while (i2 < length) {
                            if (com_google_android_gms_internal_zzfktArr[i2].f18099a.equals(a3)) {
                                if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                                    stringBuilder2 = new StringBuilder((33 + String.valueOf(a3).length()) + String.valueOf(b).length());
                                    stringBuilder2.append("_E is found in the _OE list. [");
                                    stringBuilder2.append(a3);
                                    stringBuilder2.append(", ");
                                    stringBuilder2.append(b);
                                    stringBuilder2.append("]");
                                    Log.v("FirebaseAbtUtil", stringBuilder2.toString());
                                }
                                obj2 = 1;
                                if (obj2 == null) {
                                    if (a2.f18102c > longValue) {
                                        if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                                            stringBuilder2 = new StringBuilder((115 + String.valueOf(a3).length()) + String.valueOf(b).length());
                                            stringBuilder2.append("Clearing _E as it was not in the _OE list, andits start time is older than the start time of the _E to be set. [");
                                            stringBuilder2.append(a3);
                                            stringBuilder2.append(", ");
                                            stringBuilder2.append(b);
                                            stringBuilder2.append("]");
                                            Log.v("FirebaseAbtUtil", stringBuilder2.toString());
                                        }
                                        m7457a(context2, str2, a3, b, m7454a(a2, com_google_firebase_messaging_zzb2));
                                    } else if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                                        stringBuilder2 = new StringBuilder((109 + String.valueOf(a3).length()) + String.valueOf(b).length());
                                        stringBuilder2.append("_E was not found in the _OE list, but not clearing it as it has a new start time than the _E to be set.  [");
                                        stringBuilder2.append(a3);
                                        stringBuilder2.append(", ");
                                        stringBuilder2.append(b);
                                        stringBuilder2.append("]");
                                        Log.v("FirebaseAbtUtil", stringBuilder2.toString());
                                    }
                                }
                                i = 2;
                            } else {
                                i2++;
                            }
                        }
                        obj2 = null;
                        if (obj2 == null) {
                            if (a2.f18102c > longValue) {
                                if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                                    stringBuilder2 = new StringBuilder((115 + String.valueOf(a3).length()) + String.valueOf(b).length());
                                    stringBuilder2.append("Clearing _E as it was not in the _OE list, andits start time is older than the start time of the _E to be set. [");
                                    stringBuilder2.append(a3);
                                    stringBuilder2.append(", ");
                                    stringBuilder2.append(b);
                                    stringBuilder2.append("]");
                                    Log.v("FirebaseAbtUtil", stringBuilder2.toString());
                                }
                                m7457a(context2, str2, a3, b, m7454a(a2, com_google_firebase_messaging_zzb2));
                            } else if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                                stringBuilder2 = new StringBuilder((109 + String.valueOf(a3).length()) + String.valueOf(b).length());
                                stringBuilder2.append("_E was not found in the _OE list, but not clearing it as it has a new start time than the _E to be set.  [");
                                stringBuilder2.append(a3);
                                stringBuilder2.append(", ");
                                stringBuilder2.append(b);
                                stringBuilder2.append("]");
                                Log.v("FirebaseAbtUtil", stringBuilder2.toString());
                            }
                        }
                        i = 2;
                    }
                }
                if (obj != null) {
                    if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                        str2 = a2.f18100a;
                        String str5 = a2.f18101b;
                        StringBuilder stringBuilder3 = new StringBuilder((44 + String.valueOf(str2).length()) + String.valueOf(str5).length());
                        stringBuilder3.append("_E is already set. Not setting it again [");
                        stringBuilder3.append(str2);
                        stringBuilder3.append(", ");
                        stringBuilder3.append(str5);
                        stringBuilder3.append("]");
                        Log.v("FirebaseAbtUtil", stringBuilder3.toString());
                    }
                    return;
                }
                m7459a(a, context2, str2, a2, com_google_firebase_messaging_zzb2);
            } catch (Throwable e) {
                Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            }
        }
    }

    private static void m7459a(AppMeasurement appMeasurement, Context context, String str, zzfku com_google_android_gms_internal_zzfku, zzb com_google_firebase_messaging_zzb) {
        if (Log.isLoggable("FirebaseAbtUtil", 2)) {
            String str2 = com_google_android_gms_internal_zzfku.f18100a;
            String str3 = com_google_android_gms_internal_zzfku.f18101b;
            StringBuilder stringBuilder = new StringBuilder((7 + String.valueOf(str2).length()) + String.valueOf(str3).length());
            stringBuilder.append("_SEI: ");
            stringBuilder.append(str2);
            stringBuilder.append(" ");
            stringBuilder.append(str3);
            Log.v("FirebaseAbtUtil", stringBuilder.toString());
        }
        try {
            Object obj;
            StringBuilder stringBuilder2;
            String str4;
            StringBuilder stringBuilder3;
            Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty");
            List a = m7456a(appMeasurement, str);
            if (m7456a(appMeasurement, str).size() >= m7460b(appMeasurement, str)) {
                if ((com_google_android_gms_internal_zzfku.f18111l != 0 ? com_google_android_gms_internal_zzfku.f18111l : 1) == 1) {
                    obj = a.get(0);
                    str3 = m7455a(obj);
                    str2 = m7461b(obj);
                    if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                        stringBuilder2 = new StringBuilder(38 + String.valueOf(str3).length());
                        stringBuilder2.append("Clearing _E due to overflow policy: [");
                        stringBuilder2.append(str3);
                        stringBuilder2.append("]");
                        Log.v("FirebaseAbtUtil", stringBuilder2.toString());
                    }
                    m7457a(context, str, str3, str2, m7454a(com_google_android_gms_internal_zzfku, com_google_firebase_messaging_zzb));
                } else {
                    if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                        str4 = com_google_android_gms_internal_zzfku.f18100a;
                        str = com_google_android_gms_internal_zzfku.f18101b;
                        stringBuilder3 = new StringBuilder((44 + String.valueOf(str4).length()) + String.valueOf(str).length());
                        stringBuilder3.append("_E won't be set due to overflow policy. [");
                        stringBuilder3.append(str4);
                        stringBuilder3.append(", ");
                        stringBuilder3.append(str);
                        stringBuilder3.append("]");
                        Log.v("FirebaseAbtUtil", stringBuilder3.toString());
                    }
                    return;
                }
            }
            for (Object obj2 : a) {
                str3 = m7455a(obj2);
                str2 = m7461b(obj2);
                if (str3.equals(com_google_android_gms_internal_zzfku.f18100a) && !str2.equals(com_google_android_gms_internal_zzfku.f18101b) && Log.isLoggable("FirebaseAbtUtil", 2)) {
                    stringBuilder2 = new StringBuilder((77 + String.valueOf(str3).length()) + String.valueOf(str2).length());
                    stringBuilder2.append("Clearing _E, as only one _V of the same _E can be set atany given time: [");
                    stringBuilder2.append(str3);
                    stringBuilder2.append(", ");
                    stringBuilder2.append(str2);
                    stringBuilder2.append("].");
                    Log.v("FirebaseAbtUtil", stringBuilder2.toString());
                    m7457a(context, str, str3, str2, m7454a(com_google_android_gms_internal_zzfku, com_google_firebase_messaging_zzb));
                }
            }
            if (m7453a(com_google_android_gms_internal_zzfku, str, com_google_firebase_messaging_zzb) == null) {
                if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                    str4 = com_google_android_gms_internal_zzfku.f18100a;
                    str = com_google_android_gms_internal_zzfku.f18101b;
                    stringBuilder3 = new StringBuilder((42 + String.valueOf(str4).length()) + String.valueOf(str).length());
                    stringBuilder3.append("Could not create _CUP for: [");
                    stringBuilder3.append(str4);
                    stringBuilder3.append(", ");
                    stringBuilder3.append(str);
                    stringBuilder3.append("]. Skipping.");
                    Log.v("FirebaseAbtUtil", stringBuilder3.toString());
                }
                return;
            }
            try {
                Method declaredMethod = AppMeasurement.class.getDeclaredMethod("setConditionalUserProperty", new Class[]{Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty")});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(appMeasurement, new Object[]{r10});
            } catch (Throwable e) {
                Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            }
        } catch (Throwable e2) {
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e2);
        }
    }

    private static int m7460b(AppMeasurement appMeasurement, String str) {
        try {
            Method declaredMethod = AppMeasurement.class.getDeclaredMethod("getMaxUserProperties", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(appMeasurement, new Object[]{str})).intValue();
        } catch (Throwable e) {
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            return 20;
        }
    }

    private static String m7461b(Object obj) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        return (String) Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty").getField("mValue").get(obj);
    }

    private static boolean m7462b(android.content.Context r2) {
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
        r2 = m7452a(r2);
        r0 = 0;
        r1 = 2;
        if (r2 != 0) goto L_0x0018;
    L_0x0008:
        r2 = "FirebaseAbtUtil";
        r2 = android.util.Log.isLoggable(r2, r1);
        if (r2 == 0) goto L_0x0017;
    L_0x0010:
        r2 = "FirebaseAbtUtil";
        r1 = "Firebase Analytics not available";
        android.util.Log.v(r2, r1);
    L_0x0017:
        return r0;
    L_0x0018:
        r2 = "com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty";	 Catch:{ ClassNotFoundException -> 0x001f }
        java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x001f }
        r2 = 1;
        return r2;
    L_0x001f:
        r2 = "FirebaseAbtUtil";
        r2 = android.util.Log.isLoggable(r2, r1);
        if (r2 == 0) goto L_0x002e;
    L_0x0027:
        r2 = "FirebaseAbtUtil";
        r1 = "Firebase Analytics library is missing support for abt. Please update to a more recent version.";
        android.util.Log.v(r2, r1);
    L_0x002e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.zzc.b(android.content.Context):boolean");
    }

    private static Object m7453a(zzfku com_google_android_gms_internal_zzfku, String str, zzb com_google_firebase_messaging_zzb) {
        Object newInstance;
        Object obj = null;
        try {
            Class cls = Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty");
            Bundle a = m7450a(com_google_android_gms_internal_zzfku.f18100a, com_google_android_gms_internal_zzfku.f18101b);
            newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            try {
                cls.getField("mOrigin").set(newInstance, str);
                cls.getField("mCreationTimestamp").set(newInstance, Long.valueOf(com_google_android_gms_internal_zzfku.f18102c));
                cls.getField("mName").set(newInstance, com_google_android_gms_internal_zzfku.f18100a);
                cls.getField("mValue").set(newInstance, com_google_android_gms_internal_zzfku.f18101b);
                if (TextUtils.isEmpty(com_google_android_gms_internal_zzfku.f18103d) == null) {
                    obj = com_google_android_gms_internal_zzfku.f18103d;
                }
                cls.getField("mTriggerEventName").set(newInstance, obj);
                cls.getField("mTimedOutEventName").set(newInstance, !TextUtils.isEmpty(com_google_android_gms_internal_zzfku.f18109j) ? com_google_android_gms_internal_zzfku.f18109j : com_google_firebase_messaging_zzb.f8704b);
                cls.getField("mTimedOutEventParams").set(newInstance, a);
                cls.getField("mTriggerTimeout").set(newInstance, Long.valueOf(com_google_android_gms_internal_zzfku.f18104e));
                cls.getField("mTriggeredEventName").set(newInstance, !TextUtils.isEmpty(com_google_android_gms_internal_zzfku.f18107h) ? com_google_android_gms_internal_zzfku.f18107h : com_google_firebase_messaging_zzb.f8703a);
                cls.getField("mTriggeredEventParams").set(newInstance, a);
                cls.getField("mTimeToLive").set(newInstance, Long.valueOf(com_google_android_gms_internal_zzfku.f18105f));
                cls.getField("mExpiredEventName").set(newInstance, !TextUtils.isEmpty(com_google_android_gms_internal_zzfku.f18110k) ? com_google_android_gms_internal_zzfku.f18110k : com_google_firebase_messaging_zzb.f8705c);
                cls.getField("mExpiredEventParams").set(newInstance, a);
            } catch (Exception e) {
                com_google_android_gms_internal_zzfku = e;
                Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", com_google_android_gms_internal_zzfku);
                return newInstance;
            }
        } catch (Exception e2) {
            com_google_android_gms_internal_zzfku = e2;
            newInstance = null;
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", com_google_android_gms_internal_zzfku);
            return newInstance;
        }
        return newInstance;
    }

    private static String m7454a(zzfku com_google_android_gms_internal_zzfku, zzb com_google_firebase_messaging_zzb) {
        return (com_google_android_gms_internal_zzfku == null || TextUtils.isEmpty(com_google_android_gms_internal_zzfku.f18108i)) ? com_google_firebase_messaging_zzb.f8706d : com_google_android_gms_internal_zzfku.f18108i;
    }
}
