package android.support.v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0164R;
import android.support.v7.view.ContextThemeWrapper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

class AppCompatViewInflater {
    private static final Class<?>[] f1823a = new Class[]{Context.class, AttributeSet.class};
    private static final int[] f1824b = new int[]{16843375};
    private static final String[] f1825c = new String[]{"android.widget.", "android.view.", "android.webkit."};
    private static final Map<String, Constructor<? extends View>> f1826d = new ArrayMap();
    private final Object[] f1827e = new Object[2];

    private static class DeclaredOnClickListener implements OnClickListener {
        private final View f1819a;
        private final String f1820b;
        private Method f1821c;
        private Context f1822d;

        public DeclaredOnClickListener(View view, String str) {
            this.f1819a = view;
            this.f1820b = str;
        }

        public void onClick(android.view.View r8) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r7 = this;
            r0 = r7.f1821c;
            r1 = 0;
            r2 = 1;
            if (r0 != 0) goto L_0x008c;
        L_0x0006:
            r0 = r7.f1819a;
            r0 = r0.getContext();
        L_0x000c:
            if (r0 == 0) goto L_0x0038;
        L_0x000e:
            r3 = r0.isRestricted();	 Catch:{ NoSuchMethodException -> 0x002b }
            if (r3 != 0) goto L_0x002b;	 Catch:{ NoSuchMethodException -> 0x002b }
        L_0x0014:
            r3 = r0.getClass();	 Catch:{ NoSuchMethodException -> 0x002b }
            r4 = r7.f1820b;	 Catch:{ NoSuchMethodException -> 0x002b }
            r5 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x002b }
            r6 = android.view.View.class;	 Catch:{ NoSuchMethodException -> 0x002b }
            r5[r1] = r6;	 Catch:{ NoSuchMethodException -> 0x002b }
            r3 = r3.getMethod(r4, r5);	 Catch:{ NoSuchMethodException -> 0x002b }
            if (r3 == 0) goto L_0x002b;	 Catch:{ NoSuchMethodException -> 0x002b }
        L_0x0026:
            r7.f1821c = r3;	 Catch:{ NoSuchMethodException -> 0x002b }
            r7.f1822d = r0;	 Catch:{ NoSuchMethodException -> 0x002b }
            goto L_0x008c;
        L_0x002b:
            r3 = r0 instanceof android.content.ContextWrapper;
            if (r3 == 0) goto L_0x0036;
        L_0x002f:
            r0 = (android.content.ContextWrapper) r0;
            r0 = r0.getBaseContext();
            goto L_0x000c;
        L_0x0036:
            r0 = 0;
            goto L_0x000c;
        L_0x0038:
            r8 = r7.f1819a;
            r8 = r8.getId();
            r0 = -1;
            if (r8 != r0) goto L_0x0044;
        L_0x0041:
            r8 = "";
            goto L_0x0065;
        L_0x0044:
            r0 = new java.lang.StringBuilder;
            r1 = " with id '";
            r0.<init>(r1);
            r1 = r7.f1819a;
            r1 = r1.getContext();
            r1 = r1.getResources();
            r8 = r1.getResourceEntryName(r8);
            r0.append(r8);
            r8 = "'";
            r0.append(r8);
            r8 = r0.toString();
        L_0x0065:
            r0 = new java.lang.IllegalStateException;
            r1 = new java.lang.StringBuilder;
            r2 = "Could not find method ";
            r1.<init>(r2);
            r2 = r7.f1820b;
            r1.append(r2);
            r2 = "(View) in a parent or ancestor Context for android:onClick attribute defined on view ";
            r1.append(r2);
            r2 = r7.f1819a;
            r2 = r2.getClass();
            r1.append(r2);
            r1.append(r8);
            r8 = r1.toString();
            r0.<init>(r8);
            throw r0;
        L_0x008c:
            r0 = r7.f1821c;	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0098 }
            r3 = r7.f1822d;	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0098 }
            r2 = new java.lang.Object[r2];	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0098 }
            r2[r1] = r8;	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0098 }
            r0.invoke(r3, r2);	 Catch:{ IllegalAccessException -> 0x00a1, InvocationTargetException -> 0x0098 }
            return;
        L_0x0098:
            r8 = move-exception;
            r0 = new java.lang.IllegalStateException;
            r1 = "Could not execute method for android:onClick";
            r0.<init>(r1, r8);
            throw r0;
        L_0x00a1:
            r8 = move-exception;
            r0 = new java.lang.IllegalStateException;
            r1 = "Could not execute non-public method for android:onClick";
            r0.<init>(r1, r8);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatViewInflater.DeclaredOnClickListener.onClick(android.view.View):void");
        }
    }

    AppCompatViewInflater() {
    }

    final android.view.View m1554a(android.content.Context r5, java.lang.String r6, android.util.AttributeSet r7) {
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
        r4 = this;
        r0 = "view";
        r0 = r6.equals(r0);
        r1 = 0;
        if (r0 == 0) goto L_0x000f;
    L_0x0009:
        r6 = "class";
        r6 = r7.getAttributeValue(r1, r6);
    L_0x000f:
        r0 = 1;
        r2 = 0;
        r3 = r4.f1827e;	 Catch:{ Exception -> 0x005e, all -> 0x0054 }
        r3[r2] = r5;	 Catch:{ Exception -> 0x005e, all -> 0x0054 }
        r3 = r4.f1827e;	 Catch:{ Exception -> 0x005e, all -> 0x0054 }
        r3[r0] = r7;	 Catch:{ Exception -> 0x005e, all -> 0x0054 }
        r7 = -1;	 Catch:{ Exception -> 0x005e, all -> 0x0054 }
        r3 = 46;	 Catch:{ Exception -> 0x005e, all -> 0x0054 }
        r3 = r6.indexOf(r3);	 Catch:{ Exception -> 0x005e, all -> 0x0054 }
        if (r7 != r3) goto L_0x0047;	 Catch:{ Exception -> 0x005e, all -> 0x0054 }
    L_0x0022:
        r7 = r2;	 Catch:{ Exception -> 0x005e, all -> 0x0054 }
    L_0x0023:
        r3 = f1825c;	 Catch:{ Exception -> 0x005e, all -> 0x0054 }
        r3 = r3.length;	 Catch:{ Exception -> 0x005e, all -> 0x0054 }
        if (r7 >= r3) goto L_0x003e;	 Catch:{ Exception -> 0x005e, all -> 0x0054 }
    L_0x0028:
        r3 = f1825c;	 Catch:{ Exception -> 0x005e, all -> 0x0054 }
        r3 = r3[r7];	 Catch:{ Exception -> 0x005e, all -> 0x0054 }
        r3 = r4.m1552a(r5, r6, r3);	 Catch:{ Exception -> 0x005e, all -> 0x0054 }
        if (r3 == 0) goto L_0x003b;
    L_0x0032:
        r5 = r4.f1827e;
        r5[r2] = r1;
        r5 = r4.f1827e;
        r5[r0] = r1;
        return r3;
    L_0x003b:
        r7 = r7 + 1;
        goto L_0x0023;
    L_0x003e:
        r5 = r4.f1827e;
        r5[r2] = r1;
        r5 = r4.f1827e;
        r5[r0] = r1;
        return r1;
    L_0x0047:
        r5 = r4.m1552a(r5, r6, r1);	 Catch:{ Exception -> 0x005e, all -> 0x0054 }
        r6 = r4.f1827e;
        r6[r2] = r1;
        r6 = r4.f1827e;
        r6[r0] = r1;
        return r5;
    L_0x0054:
        r5 = move-exception;
        r6 = r4.f1827e;
        r6[r2] = r1;
        r6 = r4.f1827e;
        r6[r0] = r1;
        throw r5;
    L_0x005e:
        r5 = r4.f1827e;
        r5[r2] = r1;
        r5 = r4.f1827e;
        r5[r0] = r1;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatViewInflater.a(android.content.Context, java.lang.String, android.util.AttributeSet):android.view.View");
    }

    static void m1553a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (context instanceof ContextWrapper) {
            if (VERSION.SDK_INT < 15 || ViewCompat.m1210K(view)) {
                attributeSet = context.obtainStyledAttributes(attributeSet, f1824b);
                String string = attributeSet.getString(0);
                if (string != null) {
                    view.setOnClickListener(new DeclaredOnClickListener(view, string));
                }
                attributeSet.recycle();
            }
        }
    }

    private android.view.View m1552a(android.content.Context r2, java.lang.String r3, java.lang.String r4) throws java.lang.ClassNotFoundException, android.view.InflateException {
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
        r1 = this;
        r0 = f1826d;
        r0 = r0.get(r3);
        r0 = (java.lang.reflect.Constructor) r0;
        if (r0 != 0) goto L_0x0036;
    L_0x000a:
        r2 = r2.getClassLoader();	 Catch:{ Exception -> 0x0043 }
        if (r4 == 0) goto L_0x0020;	 Catch:{ Exception -> 0x0043 }
    L_0x0010:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0043 }
        r0.<init>();	 Catch:{ Exception -> 0x0043 }
        r0.append(r4);	 Catch:{ Exception -> 0x0043 }
        r0.append(r3);	 Catch:{ Exception -> 0x0043 }
        r4 = r0.toString();	 Catch:{ Exception -> 0x0043 }
        goto L_0x0021;	 Catch:{ Exception -> 0x0043 }
    L_0x0020:
        r4 = r3;	 Catch:{ Exception -> 0x0043 }
    L_0x0021:
        r2 = r2.loadClass(r4);	 Catch:{ Exception -> 0x0043 }
        r4 = android.view.View.class;	 Catch:{ Exception -> 0x0043 }
        r2 = r2.asSubclass(r4);	 Catch:{ Exception -> 0x0043 }
        r4 = f1823a;	 Catch:{ Exception -> 0x0043 }
        r0 = r2.getConstructor(r4);	 Catch:{ Exception -> 0x0043 }
        r2 = f1826d;	 Catch:{ Exception -> 0x0043 }
        r2.put(r3, r0);	 Catch:{ Exception -> 0x0043 }
    L_0x0036:
        r2 = 1;	 Catch:{ Exception -> 0x0043 }
        r0.setAccessible(r2);	 Catch:{ Exception -> 0x0043 }
        r2 = r1.f1827e;	 Catch:{ Exception -> 0x0043 }
        r2 = r0.newInstance(r2);	 Catch:{ Exception -> 0x0043 }
        r2 = (android.view.View) r2;	 Catch:{ Exception -> 0x0043 }
        return r2;
    L_0x0043:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatViewInflater.a(android.content.Context, java.lang.String, java.lang.String):android.view.View");
    }

    static Context m1551a(Context context, AttributeSet attributeSet, boolean z) {
        attributeSet = context.obtainStyledAttributes(attributeSet, C0164R.styleable.View, 0, 0);
        z = z ? attributeSet.getResourceId(C0164R.styleable.View_android_theme, 0) : false;
        if (!z) {
            z = attributeSet.getResourceId(C0164R.styleable.View_theme, 0);
            if (z) {
                Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
            }
        }
        attributeSet.recycle();
        if (z) {
            return ((context instanceof ContextThemeWrapper) == null || ((ContextThemeWrapper) context).f1962a != z) ? new ContextThemeWrapper(context, z) : context;
        } else {
            return context;
        }
    }
}
