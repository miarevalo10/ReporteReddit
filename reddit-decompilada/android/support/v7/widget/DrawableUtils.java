package android.support.v7.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableWrapper;

public class DrawableUtils {
    public static final Rect f2259a = new Rect();
    private static Class<?> f2260b;

    static {
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
        r0 = new android.graphics.Rect;
        r0.<init>();
        f2259a = r0;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 18;
        if (r0 < r1) goto L_0x0016;
    L_0x000d:
        r0 = "android.graphics.Insets";	 Catch:{ ClassNotFoundException -> 0x0016 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0016 }
        f2260b = r0;	 Catch:{ ClassNotFoundException -> 0x0016 }
        return;
    L_0x0016:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.DrawableUtils.<clinit>():void");
    }

    public static android.graphics.Rect m1958a(android.graphics.drawable.Drawable r10) {
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
        r0 = f2260b;
        if (r0 == 0) goto L_0x009f;
    L_0x0004:
        r10 = android.support.v4.graphics.drawable.DrawableCompat.m845h(r10);	 Catch:{ Exception -> 0x0098 }
        r0 = r10.getClass();	 Catch:{ Exception -> 0x0098 }
        r1 = "getOpticalInsets";	 Catch:{ Exception -> 0x0098 }
        r2 = 0;	 Catch:{ Exception -> 0x0098 }
        r3 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x0098 }
        r0 = r0.getMethod(r1, r3);	 Catch:{ Exception -> 0x0098 }
        r1 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0098 }
        r10 = r0.invoke(r10, r1);	 Catch:{ Exception -> 0x0098 }
        if (r10 == 0) goto L_0x009f;	 Catch:{ Exception -> 0x0098 }
    L_0x001d:
        r0 = new android.graphics.Rect;	 Catch:{ Exception -> 0x0098 }
        r0.<init>();	 Catch:{ Exception -> 0x0098 }
        r1 = f2260b;	 Catch:{ Exception -> 0x0098 }
        r1 = r1.getFields();	 Catch:{ Exception -> 0x0098 }
        r3 = r1.length;	 Catch:{ Exception -> 0x0098 }
        r4 = r2;	 Catch:{ Exception -> 0x0098 }
    L_0x002a:
        if (r4 >= r3) goto L_0x0097;	 Catch:{ Exception -> 0x0098 }
    L_0x002c:
        r5 = r1[r4];	 Catch:{ Exception -> 0x0098 }
        r6 = r5.getName();	 Catch:{ Exception -> 0x0098 }
        r7 = -1;	 Catch:{ Exception -> 0x0098 }
        r8 = r6.hashCode();	 Catch:{ Exception -> 0x0098 }
        r9 = -1383228885; // 0xffffffffad8d9a2b float:-1.6098308E-11 double:NaN;	 Catch:{ Exception -> 0x0098 }
        if (r8 == r9) goto L_0x006a;	 Catch:{ Exception -> 0x0098 }
    L_0x003c:
        r9 = 115029; // 0x1c155 float:1.6119E-40 double:5.6832E-319;	 Catch:{ Exception -> 0x0098 }
        if (r8 == r9) goto L_0x0060;	 Catch:{ Exception -> 0x0098 }
    L_0x0041:
        r9 = 3317767; // 0x32a007 float:4.649182E-39 double:1.6391947E-317;	 Catch:{ Exception -> 0x0098 }
        if (r8 == r9) goto L_0x0056;	 Catch:{ Exception -> 0x0098 }
    L_0x0046:
        r9 = 108511772; // 0x677c21c float:4.6598146E-35 double:5.36119387E-316;	 Catch:{ Exception -> 0x0098 }
        if (r8 == r9) goto L_0x004c;	 Catch:{ Exception -> 0x0098 }
    L_0x004b:
        goto L_0x0074;	 Catch:{ Exception -> 0x0098 }
    L_0x004c:
        r8 = "right";	 Catch:{ Exception -> 0x0098 }
        r6 = r6.equals(r8);	 Catch:{ Exception -> 0x0098 }
        if (r6 == 0) goto L_0x0074;	 Catch:{ Exception -> 0x0098 }
    L_0x0054:
        r6 = 2;	 Catch:{ Exception -> 0x0098 }
        goto L_0x0075;	 Catch:{ Exception -> 0x0098 }
    L_0x0056:
        r8 = "left";	 Catch:{ Exception -> 0x0098 }
        r6 = r6.equals(r8);	 Catch:{ Exception -> 0x0098 }
        if (r6 == 0) goto L_0x0074;	 Catch:{ Exception -> 0x0098 }
    L_0x005e:
        r6 = r2;	 Catch:{ Exception -> 0x0098 }
        goto L_0x0075;	 Catch:{ Exception -> 0x0098 }
    L_0x0060:
        r8 = "top";	 Catch:{ Exception -> 0x0098 }
        r6 = r6.equals(r8);	 Catch:{ Exception -> 0x0098 }
        if (r6 == 0) goto L_0x0074;	 Catch:{ Exception -> 0x0098 }
    L_0x0068:
        r6 = 1;	 Catch:{ Exception -> 0x0098 }
        goto L_0x0075;	 Catch:{ Exception -> 0x0098 }
    L_0x006a:
        r8 = "bottom";	 Catch:{ Exception -> 0x0098 }
        r6 = r6.equals(r8);	 Catch:{ Exception -> 0x0098 }
        if (r6 == 0) goto L_0x0074;	 Catch:{ Exception -> 0x0098 }
    L_0x0072:
        r6 = 3;	 Catch:{ Exception -> 0x0098 }
        goto L_0x0075;	 Catch:{ Exception -> 0x0098 }
    L_0x0074:
        r6 = r7;	 Catch:{ Exception -> 0x0098 }
    L_0x0075:
        switch(r6) {
            case 0: goto L_0x008e;
            case 1: goto L_0x0087;
            case 2: goto L_0x0080;
            case 3: goto L_0x0079;
            default: goto L_0x0078;
        };	 Catch:{ Exception -> 0x0098 }
    L_0x0078:
        goto L_0x0094;	 Catch:{ Exception -> 0x0098 }
    L_0x0079:
        r5 = r5.getInt(r10);	 Catch:{ Exception -> 0x0098 }
        r0.bottom = r5;	 Catch:{ Exception -> 0x0098 }
        goto L_0x0094;	 Catch:{ Exception -> 0x0098 }
    L_0x0080:
        r5 = r5.getInt(r10);	 Catch:{ Exception -> 0x0098 }
        r0.right = r5;	 Catch:{ Exception -> 0x0098 }
        goto L_0x0094;	 Catch:{ Exception -> 0x0098 }
    L_0x0087:
        r5 = r5.getInt(r10);	 Catch:{ Exception -> 0x0098 }
        r0.top = r5;	 Catch:{ Exception -> 0x0098 }
        goto L_0x0094;	 Catch:{ Exception -> 0x0098 }
    L_0x008e:
        r5 = r5.getInt(r10);	 Catch:{ Exception -> 0x0098 }
        r0.left = r5;	 Catch:{ Exception -> 0x0098 }
    L_0x0094:
        r4 = r4 + 1;
        goto L_0x002a;
    L_0x0097:
        return r0;
    L_0x0098:
        r10 = "DrawableUtils";
        r0 = "Couldn't obtain the optical insets. Ignoring.";
        android.util.Log.e(r10, r0);
    L_0x009f:
        r10 = f2259a;
        return r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.DrawableUtils.a(android.graphics.drawable.Drawable):android.graphics.Rect");
    }

    static void m1959b(Drawable drawable) {
        if (VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            int[] state = drawable.getState();
            if (state != null) {
                if (state.length != 0) {
                    drawable.setState(ThemeUtils.f2583h);
                    drawable.setState(state);
                }
            }
            drawable.setState(ThemeUtils.f2580e);
            drawable.setState(state);
        }
    }

    public static boolean m1960c(Drawable drawable) {
        while (true) {
            if (VERSION.SDK_INT < 15 && (drawable instanceof InsetDrawable)) {
                return false;
            }
            if (VERSION.SDK_INT < 15 && (drawable instanceof GradientDrawable)) {
                return false;
            }
            if (VERSION.SDK_INT >= 17 || !(drawable instanceof LayerDrawable)) {
                if (!(drawable instanceof DrawableContainer)) {
                    if (!(drawable instanceof DrawableWrapper)) {
                        if (!(drawable instanceof android.support.v7.graphics.drawable.DrawableWrapper)) {
                            if (!(drawable instanceof ScaleDrawable)) {
                                break;
                            }
                            drawable = ((ScaleDrawable) drawable).getDrawable();
                        } else {
                            drawable = ((android.support.v7.graphics.drawable.DrawableWrapper) drawable).f1861m;
                        }
                    } else {
                        drawable = ((DrawableWrapper) drawable).mo273a();
                    }
                } else {
                    break;
                }
            }
            return false;
        }
        drawable = drawable.getConstantState();
        if (drawable instanceof DrawableContainerState) {
            for (Drawable c : ((DrawableContainerState) drawable).getChildren()) {
                if (!m1960c(c)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Mode m1957a(int i, Mode mode) {
        if (i == 3) {
            return Mode.SRC_OVER;
        }
        if (i == 5) {
            return Mode.SRC_IN;
        }
        if (i == 9) {
            return Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                return Mode.ADD;
            default:
                return mode;
        }
    }
}
