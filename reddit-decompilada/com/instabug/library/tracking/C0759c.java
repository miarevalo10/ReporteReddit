package com.instabug.library.tracking;

import android.view.View;
import android.view.ViewGroup;
import com.instabug.library.C0645b;
import com.instabug.library.Feature;
import com.instabug.library.Feature.State;

/* compiled from: InstabugTouchEventsTracker */
public class C0759c {
    private static C0759c f9879c;
    int f9880a;
    int f9881b;

    private C0759c() {
    }

    public static C0759c m8325a() {
        if (f9879c == null) {
            f9879c = new C0759c();
        }
        return f9879c;
    }

    static boolean m8327b() {
        return C0645b.m8104a().m8113b(Feature.TRACK_USER_STEPS) == State.ENABLED;
    }

    static boolean m8328c() {
        return C0645b.m8104a().m8113b(Feature.REPRO_STEPS) == State.ENABLED;
    }

    static java.lang.String m8326a(android.content.Context r2, int r3) {
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
        r0 = 0;
        r1 = -1;
        if (r3 != r1) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        if (r2 == 0) goto L_0x0017;
    L_0x0007:
        r1 = r2.getResources();	 Catch:{ NotFoundException -> 0x0016 }
        if (r1 == 0) goto L_0x0017;	 Catch:{ NotFoundException -> 0x0016 }
    L_0x000d:
        r2 = r2.getResources();	 Catch:{ NotFoundException -> 0x0016 }
        r2 = r2.getResourceEntryName(r3);	 Catch:{ NotFoundException -> 0x0016 }
        return r2;
    L_0x0016:
        return r0;
    L_0x0017:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.tracking.c.a(android.content.Context, int):java.lang.String");
    }

    final View m8329a(View view, int i, int i2) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        View view2 = null;
        if (i2 >= iArr[1]) {
            int i3 = 0;
            if (i >= iArr[0] && i2 <= iArr[1] + view.getHeight() && i <= iArr[0] + view.getWidth()) {
                if (view instanceof ViewGroup) {
                    while (true) {
                        ViewGroup viewGroup = (ViewGroup) view;
                        if (i3 >= viewGroup.getChildCount()) {
                            break;
                        }
                        View childAt = viewGroup.getChildAt(i3);
                        if (!(childAt instanceof ViewGroup)) {
                            childAt = m8329a(childAt, i, i2);
                            if (childAt != null) {
                            }
                            if (view2 == null) {
                                break;
                            }
                            i3++;
                        } else {
                            childAt = m8329a(childAt, i, i2);
                            if (childAt == null) {
                                childAt = view2;
                            }
                        }
                        view2 = childAt;
                        if (view2 == null) {
                            break;
                        }
                        i3++;
                    }
                    if (view2 != null) {
                        view = view2;
                    }
                }
                return view;
            }
        }
        return null;
    }
}
