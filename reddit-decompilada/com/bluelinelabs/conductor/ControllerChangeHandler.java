package com.bluelinelabs.conductor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bluelinelabs.conductor.Controller.C10517;
import com.bluelinelabs.conductor.Controller.LifecycleListener;
import com.bluelinelabs.conductor.Controller.RetainViewMode;
import com.bluelinelabs.conductor.changehandler.SimpleSwapChangeHandler;
import com.bluelinelabs.conductor.internal.ClassUtils;
import com.bluelinelabs.conductor.internal.ViewAttachHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class ControllerChangeHandler {
    private static final Map<String, ChangeHandlerData> f3124b = new HashMap();
    boolean f3125a;
    private boolean f3126c;

    private static class ChangeHandlerData {
        public final ControllerChangeHandler f3116a;
        public final boolean f3117b;

        public ChangeHandlerData(ControllerChangeHandler controllerChangeHandler, boolean z) {
            this.f3116a = controllerChangeHandler;
            this.f3117b = z;
        }
    }

    static class ChangeTransaction {
        final Controller f3118a;
        final Controller f3119b;
        final boolean f3120c;
        final ViewGroup f3121d;
        final ControllerChangeHandler f3122e;
        final List<ControllerChangeListener> f3123f;

        public ChangeTransaction(Controller controller, Controller controller2, boolean z, ViewGroup viewGroup, ControllerChangeHandler controllerChangeHandler, List<ControllerChangeListener> list) {
            this.f3118a = controller;
            this.f3119b = controller2;
            this.f3120c = z;
            this.f3121d = viewGroup;
            this.f3122e = controllerChangeHandler;
            this.f3123f = list;
        }
    }

    public interface ControllerChangeCompletedListener {
        void mo853a();
    }

    public interface ControllerChangeListener {
        void mo847a(Controller controller, ViewGroup viewGroup, ControllerChangeHandler controllerChangeHandler);

        void mo848b(Controller controller, ViewGroup viewGroup, ControllerChangeHandler controllerChangeHandler);
    }

    public void mo860a() {
    }

    public void mo861a(Bundle bundle) {
    }

    public abstract void mo862a(ViewGroup viewGroup, View view, View view2, boolean z, ControllerChangeCompletedListener controllerChangeCompletedListener);

    public void mo863a(ControllerChangeHandler controllerChangeHandler, Controller controller) {
    }

    public void mo864b(Bundle bundle) {
    }

    public boolean mo867c() {
        return false;
    }

    public boolean mo865e() {
        return true;
    }

    public ControllerChangeHandler() {
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
        r3 = this;
        r3.<init>();
        r0 = r3.getClass();	 Catch:{ Exception -> 0x000e }
        r1 = 0;	 Catch:{ Exception -> 0x000e }
        r1 = new java.lang.Class[r1];	 Catch:{ Exception -> 0x000e }
        r0.getConstructor(r1);	 Catch:{ Exception -> 0x000e }
        return;
    L_0x000e:
        r0 = new java.lang.RuntimeException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r3.getClass();
        r1.append(r2);
        r2 = " does not have a default constructor.";
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bluelinelabs.conductor.ControllerChangeHandler.<init>():void");
    }

    public ControllerChangeHandler mo866b() {
        return m2679c(m2688d());
    }

    final Bundle m2688d() {
        Bundle bundle = new Bundle();
        bundle.putString("ControllerChangeHandler.className", getClass().getName());
        Bundle bundle2 = new Bundle();
        mo861a(bundle2);
        bundle.putBundle("ControllerChangeHandler.savedState", bundle2);
        return bundle;
    }

    public static ControllerChangeHandler m2679c(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        ControllerChangeHandler controllerChangeHandler = (ControllerChangeHandler) ClassUtils.m2754a(bundle.getString("ControllerChangeHandler.className"));
        controllerChangeHandler.mo864b(bundle.getBundle("ControllerChangeHandler.savedState"));
        return controllerChangeHandler;
    }

    static boolean m2678a(String str) {
        ChangeHandlerData changeHandlerData = (ChangeHandlerData) f3124b.get(str);
        if (changeHandlerData == null) {
            return null;
        }
        changeHandlerData.f3116a.mo860a();
        f3124b.remove(str);
        return true;
    }

    static void m2676a(ChangeTransaction changeTransaction) {
        final Controller controller = changeTransaction.f3118a;
        final Controller controller2 = changeTransaction.f3119b;
        boolean z = changeTransaction.f3120c;
        View view = changeTransaction.f3121d;
        ControllerChangeHandler controllerChangeHandler = changeTransaction.f3122e;
        final List<ControllerChangeListener> list = changeTransaction.f3123f;
        if (view != null) {
            ControllerChangeType controllerChangeType;
            View view2;
            View view3;
            View view4;
            changeTransaction = controllerChangeHandler == null ? new SimpleSwapChangeHandler() : (controllerChangeHandler.f3126c == null || controllerChangeHandler.mo867c() != null) ? controllerChangeHandler : controllerChangeHandler.mo866b();
            changeTransaction.f3126c = true;
            if (controller2 != null) {
                if (z) {
                    m2678a(controller2.f3101l);
                } else {
                    ChangeHandlerData changeHandlerData = (ChangeHandlerData) f3124b.get(controller2.f3101l);
                    if (changeHandlerData != null) {
                        if (changeHandlerData.f3117b) {
                            changeHandlerData.f3116a.mo863a(changeTransaction, controller);
                        } else {
                            changeHandlerData.f3116a.mo860a();
                        }
                        f3124b.remove(controller2.f3101l);
                    }
                }
            }
            if (controller != null) {
                f3124b.put(controller.f3101l, new ChangeHandlerData(changeTransaction, z));
            }
            for (ControllerChangeListener a : list) {
                a.mo847a(controller, view, changeTransaction);
            }
            final ControllerChangeType controllerChangeType2 = z ? ControllerChangeType.PUSH_ENTER : ControllerChangeType.POP_ENTER;
            if (z) {
                controllerChangeType = ControllerChangeType.PUSH_EXIT;
            } else {
                controllerChangeType = ControllerChangeType.POP_EXIT;
            }
            final ControllerChangeType controllerChangeType3 = controllerChangeType;
            if (controller != null) {
                if (!(controller.f3099j == null || controller.f3099j.getParent() == null || controller.f3099j.getParent() == view)) {
                    controller.m2643a(controller.f3099j, true, false);
                    controller.m2670p();
                }
                if (controller.f3099j == null) {
                    Iterator it;
                    for (LifecycleListener a2 : new ArrayList(controller.f3109t)) {
                        a2.m2609a(controller);
                    }
                    controller.f3099j = controller.m2632a(LayoutInflater.from(view.getContext()), (ViewGroup) view);
                    if (controller.f3099j == view) {
                        throw new IllegalStateException("Controller's onCreateView method returned the parent ViewGroup. Perhaps you forgot to pass false for LayoutInflater.inflate's attachToRoot parameter?");
                    }
                    it = new ArrayList(controller.f3109t).iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                    controller.m2663e(controller.f3099j);
                    controller.f3107r = new ViewAttachHandler(new C10517(controller));
                    controller.f3099j.addOnAttachStateChangeListener(controller.f3107r);
                } else if (controller.f3106q == RetainViewMode.RETAIN_DETACH) {
                    controller.m2671q();
                }
                view2 = controller.f3099j;
                controller.m2646a(controllerChangeType2);
                view3 = view2;
            } else {
                view3 = null;
            }
            if (controller2 != null) {
                view2 = controller2.f3099j;
                controller2.m2646a(controllerChangeType3);
                view4 = view2;
            } else {
                view4 = null;
            }
            final ChangeTransaction changeTransaction2 = changeTransaction;
            final boolean z2 = z;
            final View view5 = view;
            final View view6 = view4;
            changeTransaction.mo862a(view, view4, view3, z, new ControllerChangeCompletedListener() {
                public final void mo853a() {
                    if (controller2 != null) {
                        controller2.m2654b(controllerChangeType3);
                    }
                    if (controller != null) {
                        ControllerChangeHandler.f3124b.remove(controller.f3101l);
                        controller.m2654b(controllerChangeType2);
                    }
                    for (ControllerChangeListener b : list) {
                        b.mo848b(controller, view5, changeTransaction2);
                    }
                    if (changeTransaction2.f3125a && view6 != null) {
                        ViewParent parent = view6.getParent();
                        if (parent != null && (parent instanceof ViewGroup)) {
                            ((ViewGroup) parent).removeView(view6);
                        }
                    }
                    if (changeTransaction2.mo865e() && controller2 != null) {
                        controller2.f3102m = false;
                    }
                }
            });
        }
    }
}
