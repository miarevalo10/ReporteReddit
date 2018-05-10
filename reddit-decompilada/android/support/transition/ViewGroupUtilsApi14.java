package android.support.transition;

import android.animation.LayoutTransition;
import android.support.annotation.RequiresApi;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@RequiresApi(14)
class ViewGroupUtilsApi14 implements ViewGroupUtilsImpl {
    private static LayoutTransition f11231a;
    private static Field f11232b;
    private static boolean f11233c;
    private static Method f11234d;
    private static boolean f11235e;

    class C00721 extends LayoutTransition {
        final /* synthetic */ ViewGroupUtilsApi14 f910a;

        public boolean isChangingLayout() {
            return true;
        }

        C00721(ViewGroupUtilsApi14 viewGroupUtilsApi14) {
            this.f910a = viewGroupUtilsApi14;
        }
    }

    ViewGroupUtilsApi14() {
    }

    public ViewGroupOverlayImpl mo174a(ViewGroup viewGroup) {
        return ViewGroupOverlayApi14.m16597a(viewGroup);
    }

    public void mo175a(android.view.ViewGroup r6, boolean r7) {
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
        r5 = this;
        r0 = f11231a;
        r1 = 1;
        r2 = 0;
        r3 = 0;
        if (r0 != 0) goto L_0x0028;
    L_0x0007:
        r0 = new android.support.transition.ViewGroupUtilsApi14$1;
        r0.<init>(r5);
        f11231a = r0;
        r4 = 2;
        r0.setAnimator(r4, r3);
        r0 = f11231a;
        r0.setAnimator(r2, r3);
        r0 = f11231a;
        r0.setAnimator(r1, r3);
        r0 = f11231a;
        r4 = 3;
        r0.setAnimator(r4, r3);
        r0 = f11231a;
        r4 = 4;
        r0.setAnimator(r4, r3);
    L_0x0028:
        if (r7 == 0) goto L_0x007d;
    L_0x002a:
        r7 = r6.getLayoutTransition();
        if (r7 == 0) goto L_0x0077;
    L_0x0030:
        r0 = r7.isRunning();
        if (r0 == 0) goto L_0x006e;
    L_0x0036:
        r0 = f11235e;
        if (r0 != 0) goto L_0x0053;
    L_0x003a:
        r0 = android.animation.LayoutTransition.class;	 Catch:{ NoSuchMethodException -> 0x004a }
        r3 = "cancel";	 Catch:{ NoSuchMethodException -> 0x004a }
        r4 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x004a }
        r0 = r0.getDeclaredMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x004a }
        f11234d = r0;	 Catch:{ NoSuchMethodException -> 0x004a }
        r0.setAccessible(r1);	 Catch:{ NoSuchMethodException -> 0x004a }
        goto L_0x0051;
    L_0x004a:
        r0 = "ViewGroupUtilsApi14";
        r3 = "Failed to access cancel method by reflection";
        android.util.Log.i(r0, r3);
    L_0x0051:
        f11235e = r1;
    L_0x0053:
        r0 = f11234d;
        if (r0 == 0) goto L_0x006e;
    L_0x0057:
        r0 = f11234d;	 Catch:{ IllegalAccessException -> 0x0067, InvocationTargetException -> 0x005f }
        r1 = new java.lang.Object[r2];	 Catch:{ IllegalAccessException -> 0x0067, InvocationTargetException -> 0x005f }
        r0.invoke(r7, r1);	 Catch:{ IllegalAccessException -> 0x0067, InvocationTargetException -> 0x005f }
        goto L_0x006e;
    L_0x005f:
        r0 = "ViewGroupUtilsApi14";
        r1 = "Failed to invoke cancel method by reflection";
        android.util.Log.i(r0, r1);
        goto L_0x006e;
    L_0x0067:
        r0 = "ViewGroupUtilsApi14";
        r1 = "Failed to access cancel method by reflection";
        android.util.Log.i(r0, r1);
    L_0x006e:
        r0 = f11231a;
        if (r7 == r0) goto L_0x0077;
    L_0x0072:
        r0 = android.support.transition.C0069R.id.transition_layout_save;
        r6.setTag(r0, r7);
    L_0x0077:
        r7 = f11231a;
        r6.setLayoutTransition(r7);
        return;
    L_0x007d:
        r6.setLayoutTransition(r3);
        r7 = f11233c;
        if (r7 != 0) goto L_0x009b;
    L_0x0084:
        r7 = android.view.ViewGroup.class;	 Catch:{ NoSuchFieldException -> 0x0092 }
        r0 = "mLayoutSuppressed";	 Catch:{ NoSuchFieldException -> 0x0092 }
        r7 = r7.getDeclaredField(r0);	 Catch:{ NoSuchFieldException -> 0x0092 }
        f11232b = r7;	 Catch:{ NoSuchFieldException -> 0x0092 }
        r7.setAccessible(r1);	 Catch:{ NoSuchFieldException -> 0x0092 }
        goto L_0x0099;
    L_0x0092:
        r7 = "ViewGroupUtilsApi14";
        r0 = "Failed to access mLayoutSuppressed field by reflection";
        android.util.Log.i(r7, r0);
    L_0x0099:
        f11233c = r1;
    L_0x009b:
        r7 = f11232b;
        if (r7 == 0) goto L_0x00b8;
    L_0x009f:
        r7 = f11232b;	 Catch:{ IllegalAccessException -> 0x00b1 }
        r7 = r7.getBoolean(r6);	 Catch:{ IllegalAccessException -> 0x00b1 }
        if (r7 == 0) goto L_0x00af;
    L_0x00a7:
        r0 = f11232b;	 Catch:{ IllegalAccessException -> 0x00ad }
        r0.setBoolean(r6, r2);	 Catch:{ IllegalAccessException -> 0x00ad }
        goto L_0x00af;
    L_0x00ad:
        r2 = r7;
        goto L_0x00b1;
    L_0x00af:
        r2 = r7;
        goto L_0x00b8;
    L_0x00b1:
        r7 = "ViewGroupUtilsApi14";
        r0 = "Failed to get mLayoutSuppressed field by reflection";
        android.util.Log.i(r7, r0);
    L_0x00b8:
        if (r2 == 0) goto L_0x00bd;
    L_0x00ba:
        r6.requestLayout();
    L_0x00bd:
        r7 = android.support.transition.C0069R.id.transition_layout_save;
        r7 = r6.getTag(r7);
        r7 = (android.animation.LayoutTransition) r7;
        if (r7 == 0) goto L_0x00cf;
    L_0x00c7:
        r0 = android.support.transition.C0069R.id.transition_layout_save;
        r6.setTag(r0, r3);
        r6.setLayoutTransition(r7);
    L_0x00cf:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ViewGroupUtilsApi14.a(android.view.ViewGroup, boolean):void");
    }
}
