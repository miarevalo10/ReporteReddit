package butterknife;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ButterKnife {
    static final Map<Class<?>, Constructor<? extends Unbinder>> f2732a = new LinkedHashMap();
    private static boolean f2733b = false;

    public interface Action<T extends View> {
    }

    public interface Setter<T extends View, V> {
    }

    private ButterKnife() {
        throw new AssertionError("No instances.");
    }

    public static Unbinder m2426a(Activity activity) {
        return m2430b(activity, activity.getWindow().getDecorView());
    }

    public static Unbinder m2427a(View view) {
        return m2430b(view, view);
    }

    public static Unbinder m2428a(Object obj, View view) {
        return m2430b(obj, view);
    }

    private static Unbinder m2430b(Object obj, View view) {
        StringBuilder stringBuilder;
        Class cls = obj.getClass();
        if (f2733b) {
            StringBuilder stringBuilder2 = new StringBuilder("Looking up binding for ");
            stringBuilder2.append(cls.getName());
            Log.d("ButterKnife", stringBuilder2.toString());
        }
        Constructor a = m2429a(cls);
        if (a == null) {
            return Unbinder.f2745a;
        }
        try {
            return (Unbinder) a.newInstance(new Object[]{obj, view});
        } catch (Object obj2) {
            stringBuilder = new StringBuilder("Unable to invoke ");
            stringBuilder.append(a);
            throw new RuntimeException(stringBuilder.toString(), obj2);
        } catch (Object obj22) {
            stringBuilder = new StringBuilder("Unable to invoke ");
            stringBuilder.append(a);
            throw new RuntimeException(stringBuilder.toString(), obj22);
        } catch (Object obj222) {
            obj222 = obj222.getCause();
            if ((obj222 instanceof RuntimeException) != null) {
                throw ((RuntimeException) obj222);
            } else if ((obj222 instanceof Error) != null) {
                throw ((Error) obj222);
            } else {
                throw new RuntimeException("Unable to create binding instance.", obj222);
            }
        }
    }

    private static java.lang.reflect.Constructor<? extends butterknife.Unbinder> m2429a(java.lang.Class<?> r5) {
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
        r0 = f2732a;
        r0 = r0.get(r5);
        r0 = (java.lang.reflect.Constructor) r0;
        if (r0 == 0) goto L_0x0016;
    L_0x000a:
        r5 = f2733b;
        if (r5 == 0) goto L_0x0015;
    L_0x000e:
        r5 = "ButterKnife";
        r1 = "HIT: Cached in binding map.";
        android.util.Log.d(r5, r1);
    L_0x0015:
        return r0;
    L_0x0016:
        r0 = r5.getName();
        r1 = "android.";
        r1 = r0.startsWith(r1);
        if (r1 != 0) goto L_0x009d;
    L_0x0022:
        r1 = "java.";
        r1 = r0.startsWith(r1);
        if (r1 == 0) goto L_0x002b;
    L_0x002a:
        goto L_0x009d;
    L_0x002b:
        r1 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x0070, NoSuchMethodException -> 0x005b }
        r1.<init>();	 Catch:{ ClassNotFoundException -> 0x0070, NoSuchMethodException -> 0x005b }
        r1.append(r0);	 Catch:{ ClassNotFoundException -> 0x0070, NoSuchMethodException -> 0x005b }
        r2 = "_ViewBinding";	 Catch:{ ClassNotFoundException -> 0x0070, NoSuchMethodException -> 0x005b }
        r1.append(r2);	 Catch:{ ClassNotFoundException -> 0x0070, NoSuchMethodException -> 0x005b }
        r1 = r1.toString();	 Catch:{ ClassNotFoundException -> 0x0070, NoSuchMethodException -> 0x005b }
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0070, NoSuchMethodException -> 0x005b }
        r2 = 2;	 Catch:{ ClassNotFoundException -> 0x0070, NoSuchMethodException -> 0x005b }
        r2 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x0070, NoSuchMethodException -> 0x005b }
        r3 = 0;	 Catch:{ ClassNotFoundException -> 0x0070, NoSuchMethodException -> 0x005b }
        r2[r3] = r5;	 Catch:{ ClassNotFoundException -> 0x0070, NoSuchMethodException -> 0x005b }
        r3 = 1;	 Catch:{ ClassNotFoundException -> 0x0070, NoSuchMethodException -> 0x005b }
        r4 = android.view.View.class;	 Catch:{ ClassNotFoundException -> 0x0070, NoSuchMethodException -> 0x005b }
        r2[r3] = r4;	 Catch:{ ClassNotFoundException -> 0x0070, NoSuchMethodException -> 0x005b }
        r1 = r1.getConstructor(r2);	 Catch:{ ClassNotFoundException -> 0x0070, NoSuchMethodException -> 0x005b }
        r2 = f2733b;	 Catch:{ ClassNotFoundException -> 0x0070, NoSuchMethodException -> 0x005b }
        if (r2 == 0) goto L_0x0097;	 Catch:{ ClassNotFoundException -> 0x0070, NoSuchMethodException -> 0x005b }
    L_0x0053:
        r2 = "ButterKnife";	 Catch:{ ClassNotFoundException -> 0x0070, NoSuchMethodException -> 0x005b }
        r3 = "HIT: Loaded binding class and constructor.";	 Catch:{ ClassNotFoundException -> 0x0070, NoSuchMethodException -> 0x005b }
        android.util.Log.d(r2, r3);	 Catch:{ ClassNotFoundException -> 0x0070, NoSuchMethodException -> 0x005b }
        goto L_0x0097;
    L_0x005b:
        r5 = move-exception;
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r3 = "Unable to find binding constructor for ";
        r2.<init>(r3);
        r2.append(r0);
        r0 = r2.toString();
        r1.<init>(r0, r5);
        throw r1;
    L_0x0070:
        r0 = f2733b;
        if (r0 == 0) goto L_0x008f;
    L_0x0074:
        r0 = "ButterKnife";
        r1 = new java.lang.StringBuilder;
        r2 = "Not found. Trying superclass ";
        r1.<init>(r2);
        r2 = r5.getSuperclass();
        r2 = r2.getName();
        r1.append(r2);
        r1 = r1.toString();
        android.util.Log.d(r0, r1);
    L_0x008f:
        r0 = r5.getSuperclass();
        r1 = m2429a(r0);
    L_0x0097:
        r0 = f2732a;
        r0.put(r5, r1);
        return r1;
    L_0x009d:
        r5 = f2733b;
        if (r5 == 0) goto L_0x00a8;
    L_0x00a1:
        r5 = "ButterKnife";
        r0 = "MISS: Reached framework class. Abandoning search.";
        android.util.Log.d(r5, r0);
    L_0x00a8:
        r5 = 0;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: butterknife.ButterKnife.a(java.lang.Class):java.lang.reflect.Constructor<? extends butterknife.Unbinder>");
    }
}
