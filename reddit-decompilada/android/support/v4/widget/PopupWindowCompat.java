package android.support.v4.widget;

import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class PopupWindowCompat {
    static final PopupWindowCompatBaseImpl f1656a;

    static class PopupWindowCompatBaseImpl {
        private static Method f1654a;
        private static boolean f1655b;

        public void mo3157a(PopupWindow popupWindow, boolean z) {
        }

        PopupWindowCompatBaseImpl() {
        }

        public void mo398a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            if ((GravityCompat.m1096a(i3, ViewCompat.m1242f(view)) & 7) == 5) {
                i -= popupWindow.getWidth() - view.getWidth();
            }
            popupWindow.showAsDropDown(view, i, i2);
        }

        public void mo3843a(android.widget.PopupWindow r7, int r8) {
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
            r6 = this;
            r0 = f1655b;
            r1 = 0;
            r2 = 1;
            if (r0 != 0) goto L_0x001b;
        L_0x0006:
            r0 = android.widget.PopupWindow.class;	 Catch:{ Exception -> 0x0019 }
            r3 = "setWindowLayoutType";	 Catch:{ Exception -> 0x0019 }
            r4 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x0019 }
            r5 = java.lang.Integer.TYPE;	 Catch:{ Exception -> 0x0019 }
            r4[r1] = r5;	 Catch:{ Exception -> 0x0019 }
            r0 = r0.getDeclaredMethod(r3, r4);	 Catch:{ Exception -> 0x0019 }
            f1654a = r0;	 Catch:{ Exception -> 0x0019 }
            r0.setAccessible(r2);	 Catch:{ Exception -> 0x0019 }
        L_0x0019:
            f1655b = r2;
        L_0x001b:
            r0 = f1654a;
            if (r0 == 0) goto L_0x002d;
        L_0x001f:
            r0 = f1654a;	 Catch:{ Exception -> 0x002d }
            r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x002d }
            r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x002d }
            r2[r1] = r8;	 Catch:{ Exception -> 0x002d }
            r0.invoke(r7, r2);	 Catch:{ Exception -> 0x002d }
            return;
        L_0x002d:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.PopupWindowCompat.PopupWindowCompatBaseImpl.a(android.widget.PopupWindow, int):void");
        }
    }

    @RequiresApi(19)
    static class PopupWindowCompatApi19Impl extends PopupWindowCompatBaseImpl {
        PopupWindowCompatApi19Impl() {
        }

        public final void mo398a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            popupWindow.showAsDropDown(view, i, i2, i3);
        }
    }

    @RequiresApi(21)
    static class PopupWindowCompatApi21Impl extends PopupWindowCompatApi19Impl {
        private static Field f16534a;

        PopupWindowCompatApi21Impl() {
        }

        static {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                f16534a = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable e) {
                Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
            }
        }

        public void mo3157a(PopupWindow popupWindow, boolean z) {
            if (f16534a != null) {
                try {
                    f16534a.set(popupWindow, Boolean.valueOf(z));
                } catch (PopupWindow popupWindow2) {
                    Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", popupWindow2);
                }
            }
        }
    }

    @RequiresApi(23)
    static class PopupWindowCompatApi23Impl extends PopupWindowCompatApi21Impl {
        PopupWindowCompatApi23Impl() {
        }

        public final void mo3157a(PopupWindow popupWindow, boolean z) {
            popupWindow.setOverlapAnchor(z);
        }

        public final void mo3843a(PopupWindow popupWindow, int i) {
            popupWindow.setWindowLayoutType(i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 23) {
            f1656a = new PopupWindowCompatApi23Impl();
        } else if (VERSION.SDK_INT >= 21) {
            f1656a = new PopupWindowCompatApi21Impl();
        } else if (VERSION.SDK_INT >= 19) {
            f1656a = new PopupWindowCompatApi19Impl();
        } else {
            f1656a = new PopupWindowCompatBaseImpl();
        }
    }

    public static void m1416a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        f1656a.mo398a(popupWindow, view, i, i2, i3);
    }

    public static void m1417a(PopupWindow popupWindow, boolean z) {
        f1656a.mo3157a(popupWindow, z);
    }

    public static void m1415a(PopupWindow popupWindow, int i) {
        f1656a.mo3843a(popupWindow, i);
    }
}
