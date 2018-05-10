package android.support.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

class ViewUtils {
    static final Property<View, Float> f916a = new Property<View, Float>(Float.class, "translationAlpha") {
        public final /* synthetic */ Object get(Object obj) {
            return Float.valueOf(ViewUtils.m505c((View) obj));
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            ViewUtils.m499a((View) obj, ((Float) obj2).floatValue());
        }
    };
    static final Property<View, Rect> f917b = new Property<View, Rect>(Rect.class, "clipBounds") {
        public final /* synthetic */ Object get(Object obj) {
            return ViewCompat.m1208I((View) obj);
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            ViewCompat.m1218a((View) obj, (Rect) obj2);
        }
    };
    private static final ViewUtilsImpl f918c;
    private static Field f919d;
    private static boolean f920e;

    static {
        if (VERSION.SDK_INT >= 22) {
            f918c = new ViewUtilsApi22();
        } else if (VERSION.SDK_INT >= 21) {
            f918c = new ViewUtilsApi21();
        } else if (VERSION.SDK_INT >= 19) {
            f918c = new ViewUtilsApi19();
        } else if (VERSION.SDK_INT >= 18) {
            f918c = new ViewUtilsApi18();
        } else {
            f918c = new ViewUtilsApi14();
        }
    }

    static ViewOverlayImpl m498a(View view) {
        return f918c.mo178a(view);
    }

    static WindowIdImpl m503b(View view) {
        return f918c.mo182b(view);
    }

    static void m499a(View view, float f) {
        f918c.mo179a(view, f);
    }

    static float m505c(View view) {
        return f918c.mo184c(view);
    }

    static void m506d(View view) {
        f918c.mo185d(view);
    }

    static void m507e(View view) {
        f918c.mo186e(view);
    }

    static void m502a(View view, Matrix matrix) {
        f918c.mo181a(view, matrix);
    }

    static void m504b(View view, Matrix matrix) {
        f918c.mo183b(view, matrix);
    }

    static void m501a(View view, int i, int i2, int i3, int i4) {
        f918c.mo180a(view, i, i2, i3, i4);
    }

    static void m500a(android.view.View r3, int r4) {
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
        r0 = f920e;
        if (r0 != 0) goto L_0x001c;
    L_0x0004:
        r0 = 1;
        r1 = android.view.View.class;	 Catch:{ NoSuchFieldException -> 0x0013 }
        r2 = "mViewFlags";	 Catch:{ NoSuchFieldException -> 0x0013 }
        r1 = r1.getDeclaredField(r2);	 Catch:{ NoSuchFieldException -> 0x0013 }
        f919d = r1;	 Catch:{ NoSuchFieldException -> 0x0013 }
        r1.setAccessible(r0);	 Catch:{ NoSuchFieldException -> 0x0013 }
        goto L_0x001a;
    L_0x0013:
        r1 = "ViewUtils";
        r2 = "fetchViewFlagsField: ";
        android.util.Log.i(r1, r2);
    L_0x001a:
        f920e = r0;
    L_0x001c:
        r0 = f919d;
        if (r0 == 0) goto L_0x002f;
    L_0x0020:
        r0 = f919d;	 Catch:{ IllegalAccessException -> 0x002f }
        r0 = r0.getInt(r3);	 Catch:{ IllegalAccessException -> 0x002f }
        r1 = f919d;	 Catch:{ IllegalAccessException -> 0x002f }
        r0 = r0 & -13;	 Catch:{ IllegalAccessException -> 0x002f }
        r4 = r4 | r0;	 Catch:{ IllegalAccessException -> 0x002f }
        r1.setInt(r3, r4);	 Catch:{ IllegalAccessException -> 0x002f }
        return;
    L_0x002f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ViewUtils.a(android.view.View, int):void");
    }
}
