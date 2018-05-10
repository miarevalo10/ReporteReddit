package com.evernote.android.state;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import com.evernote.android.state.Injector.Object;
import java.util.LinkedHashMap;
import java.util.Map;

public final class StateSaver {
    public static final String ANDROID_PREFIX = "android.";
    private static final Map<Class<?>, Injector> INJECTORS = new LinkedHashMap();
    public static final String JAVA_PREFIX = "java.";
    public static final String SUFFIX = "$$StateSaver";

    private static com.evernote.android.state.Injector getInjector(java.lang.Class<?> r2) throws java.lang.IllegalAccessException, java.lang.InstantiationException {
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
        r0 = INJECTORS;
        r0 = r0.get(r2);
        r0 = (com.evernote.android.state.Injector) r0;
        if (r0 != 0) goto L_0x0054;
    L_0x000a:
        r1 = INJECTORS;
        r1 = r1.containsKey(r2);
        if (r1 == 0) goto L_0x0013;
    L_0x0012:
        goto L_0x0054;
    L_0x0013:
        r0 = r2.getName();
        r1 = "android.";
        r1 = r0.startsWith(r1);
        if (r1 != 0) goto L_0x0052;
    L_0x001f:
        r1 = "java.";
        r1 = r0.startsWith(r1);
        if (r1 == 0) goto L_0x0028;
    L_0x0027:
        goto L_0x0052;
    L_0x0028:
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0044 }
        r1.<init>();	 Catch:{ Exception -> 0x0044 }
        r1.append(r0);	 Catch:{ Exception -> 0x0044 }
        r0 = "$$StateSaver";	 Catch:{ Exception -> 0x0044 }
        r1.append(r0);	 Catch:{ Exception -> 0x0044 }
        r0 = r1.toString();	 Catch:{ Exception -> 0x0044 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x0044 }
        r0 = r0.newInstance();	 Catch:{ Exception -> 0x0044 }
        r0 = (com.evernote.android.state.Injector) r0;	 Catch:{ Exception -> 0x0044 }
        goto L_0x004c;
    L_0x0044:
        r0 = r2.getSuperclass();
        r0 = getInjector(r0);
    L_0x004c:
        r1 = INJECTORS;
        r1.put(r2, r0);
        return r0;
    L_0x0052:
        r2 = 0;
        return r2;
    L_0x0054:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.evernote.android.state.StateSaver.getInjector(java.lang.Class):com.evernote.android.state.Injector");
    }

    private static <T extends Injector> T safeGet(Object obj, Injector injector) {
        try {
            Injector injector2 = getInjector(obj.getClass());
            return injector2 == null ? injector : injector2;
        } catch (Injector injector3) {
            StringBuilder stringBuilder = new StringBuilder("Unable to inject state for ");
            stringBuilder.append(obj);
            throw new RuntimeException(stringBuilder.toString(), injector3);
        }
    }

    public static <T> void saveInstanceState(T t, Bundle bundle) {
        ((Object) safeGet(t, Object.DEFAULT)).save(t, bundle);
    }

    public static <T> void restoreInstanceState(T t, Bundle bundle) {
        if (bundle != null) {
            ((Object) safeGet(t, Object.DEFAULT)).restore(t, bundle);
        }
    }

    public static <T extends View> Parcelable saveInstanceState(T t, Parcelable parcelable) {
        return ((Injector.View) safeGet(t, Injector.View.DEFAULT)).save(t, parcelable);
    }

    public static <T extends View> Parcelable restoreInstanceState(T t, Parcelable parcelable) {
        return parcelable != null ? ((Injector.View) safeGet(t, Injector.View.DEFAULT)).restore(t, parcelable) : null;
    }

    private StateSaver() {
        throw new UnsupportedOperationException();
    }
}
