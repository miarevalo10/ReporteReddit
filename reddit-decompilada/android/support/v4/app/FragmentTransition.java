package android.support.v4.app;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentTransitionImpl.C00992;
import android.support.v4.app.FragmentTransitionImpl.C01003;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.MapCollections;
import android.support.v4.view.ViewCompat;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

class FragmentTransition {
    private static final int[] f1050a = new int[]{0, 3, 0, 1, 5, 4, 7, 6, 9, 8};
    private static final FragmentTransitionImpl f1051b = (VERSION.SDK_INT >= 21 ? new FragmentTransitionCompat21() : null);
    private static final FragmentTransitionImpl f1052c = m589a();

    static class FragmentContainerTransition {
        public Fragment f1044a;
        public boolean f1045b;
        public BackStackRecord f1046c;
        public Fragment f1047d;
        public boolean f1048e;
        public BackStackRecord f1049f;

        FragmentContainerTransition() {
        }
    }

    private static android.support.v4.app.FragmentTransitionImpl m589a() {
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
        r0 = "android.support.transition.FragmentTransitionSupport";	 Catch:{ Exception -> 0x0016 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x0016 }
        r1 = 0;	 Catch:{ Exception -> 0x0016 }
        r2 = new java.lang.Class[r1];	 Catch:{ Exception -> 0x0016 }
        r0 = r0.getDeclaredConstructor(r2);	 Catch:{ Exception -> 0x0016 }
        r1 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x0016 }
        r0 = r0.newInstance(r1);	 Catch:{ Exception -> 0x0016 }
        r0 = (android.support.v4.app.FragmentTransitionImpl) r0;	 Catch:{ Exception -> 0x0016 }
        return r0;
    L_0x0016:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentTransition.a():android.support.v4.app.FragmentTransitionImpl");
    }

    static void m602a(FragmentManagerImpl fragmentManagerImpl, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        FragmentManagerImpl fragmentManagerImpl2 = fragmentManagerImpl;
        ArrayList arrayList3 = arrayList;
        ArrayList arrayList4 = arrayList2;
        int i3 = i2;
        boolean z2 = z;
        if (fragmentManagerImpl2.f11317l > 0) {
            SparseArray sparseArray = new SparseArray();
            for (int i4 = i; i4 < i3; i4++) {
                BackStackRecord backStackRecord = (BackStackRecord) arrayList3.get(i4);
                if (((Boolean) arrayList4.get(i4)).booleanValue()) {
                    m612b(backStackRecord, sparseArray, z2);
                } else {
                    m600a(backStackRecord, sparseArray, z2);
                }
            }
            if (sparseArray.size() != 0) {
                View view = new View(fragmentManagerImpl2.f11318m.f11275c);
                int size = sparseArray.size();
                int i5 = 0;
                while (i5 < size) {
                    SparseArray sparseArray2;
                    int i6;
                    int i7;
                    int i8;
                    int i9;
                    int i10;
                    ArrayList<BackStackRecord> arrayList5;
                    ArrayList<Boolean> arrayList6;
                    int i11;
                    int keyAt = sparseArray.keyAt(i5);
                    ArrayMap a = m591a(keyAt, arrayList3, arrayList4, i, i3);
                    FragmentContainerTransition fragmentContainerTransition = (FragmentContainerTransition) sparseArray.valueAt(i5);
                    ArrayList arrayList7;
                    ArrayList arrayList8;
                    Fragment fragment;
                    Object obj;
                    ArrayMap b;
                    ArrayMap arrayMap;
                    Object a2;
                    if (z2) {
                        View view2 = fragmentManagerImpl2.f11319n.mo210a() ? (ViewGroup) fragmentManagerImpl2.f11319n.mo209a(keyAt) : null;
                        if (view2 != null) {
                            Fragment fragment2 = fragmentContainerTransition.f1044a;
                            Fragment fragment3 = fragmentContainerTransition.f1047d;
                            FragmentTransitionImpl a3 = m590a(fragment3, fragment2);
                            if (a3 != null) {
                                boolean z3;
                                Fragment fragment4;
                                ArrayList arrayList9;
                                final ArrayList b2;
                                Fragment fragment5;
                                ArrayList b3;
                                ArrayList a4;
                                boolean z4 = fragmentContainerTransition.f1045b;
                                boolean z5 = fragmentContainerTransition.f1048e;
                                arrayList7 = new ArrayList();
                                arrayList8 = new ArrayList();
                                sparseArray2 = sparseArray;
                                Object a5 = m595a(a3, fragment2, z4);
                                Object b4 = m610b(a3, fragment3, z5);
                                Fragment fragment6 = fragmentContainerTransition.f1044a;
                                i6 = i5;
                                fragment = fragmentContainerTransition.f1047d;
                                if (fragment6 != null) {
                                    i7 = size;
                                    fragment6.getView().setVisibility(0);
                                } else {
                                    i7 = size;
                                }
                                if (fragment6 != null) {
                                    if (fragment != null) {
                                        boolean z6 = fragmentContainerTransition.f1045b;
                                        if (a.isEmpty()) {
                                            z3 = z4;
                                            obj = null;
                                        } else {
                                            obj = m594a(a3, fragment6, fragment, z6);
                                            z3 = z4;
                                        }
                                        b = m608b(a3, a, obj, fragmentContainerTransition);
                                        fragment4 = fragment2;
                                        ArrayMap c = m614c(a3, a, obj, fragmentContainerTransition);
                                        if (a.isEmpty()) {
                                            if (b != null) {
                                                b.clear();
                                            }
                                            if (c != null) {
                                                c.clear();
                                            }
                                            obj = null;
                                        } else {
                                            Object obj2 = obj;
                                            m606a(arrayList8, b, a.keySet());
                                            m606a(arrayList7, c, a.values());
                                            obj = obj2;
                                        }
                                        if (a5 == null && b4 == null && obj == null) {
                                            arrayList9 = arrayList7;
                                            arrayMap = a;
                                            obj = null;
                                            b2 = m611b(a3, b4, fragment3, arrayList8, view);
                                            fragment5 = fragment4;
                                            arrayList7 = arrayList9;
                                            b3 = m611b(a3, a5, fragment5, arrayList7, view);
                                            m605a(b3, 4);
                                            a2 = m596a(a3, a5, b4, obj, fragment5, z3);
                                            if (a2 != null) {
                                                fragment3.setHideReplaced(true);
                                                a3.mo151b(b4, fragment3.getView(), b2);
                                                OneShotPreDrawListener.m700a(fragment3.mContainer, new Runnable() {
                                                    public final void run() {
                                                        FragmentTransition.m605a(b2, 4);
                                                    }
                                                });
                                                a4 = FragmentTransitionImpl.m616a(arrayList7);
                                                a3.mo144a(a2, a5, b3, b4, b2, obj, arrayList7);
                                                a3.mo140a((ViewGroup) view2, a2);
                                                a3.m622a(view2, arrayList8, arrayList7, a4, arrayMap);
                                                i8 = 0;
                                                m605a(b3, 0);
                                                a3.mo146a(obj, arrayList8, arrayList7);
                                            }
                                            i8 = 0;
                                        } else {
                                            Rect rect;
                                            View view3;
                                            m613b(fragment6, fragment, z6, b);
                                            if (obj != null) {
                                                arrayList7.add(view);
                                                a3.mo143a(obj, view, arrayList8);
                                                arrayMap = a;
                                                arrayList9 = arrayList7;
                                                m603a(a3, obj, b4, b, fragmentContainerTransition.f1048e, fragmentContainerTransition.f1049f);
                                                Rect rect2 = new Rect();
                                                View b5 = m609b(c, fragmentContainerTransition, a5, z6);
                                                if (b5 != null) {
                                                    a3.mo141a(a5, rect2);
                                                }
                                                rect = rect2;
                                                view3 = b5;
                                            } else {
                                                arrayList9 = arrayList7;
                                                arrayMap = a;
                                                view3 = null;
                                                rect = view3;
                                            }
                                            final Fragment fragment7 = fragment6;
                                            final Fragment fragment8 = fragment;
                                            final boolean z7 = z6;
                                            final ArrayMap arrayMap2 = c;
                                            final FragmentTransitionImpl fragmentTransitionImpl = a3;
                                            OneShotPreDrawListener.m700a(view2, new Runnable() {
                                                public final void run() {
                                                    FragmentTransition.m613b(fragment7, fragment8, z7, arrayMap2);
                                                    if (view3 != null) {
                                                        FragmentTransitionImpl.m617a(view3, rect);
                                                    }
                                                }
                                            });
                                            if (!(a5 == null && obj == null && b4 == null)) {
                                                b2 = m611b(a3, b4, fragment3, arrayList8, view);
                                                fragment5 = fragment4;
                                                arrayList7 = arrayList9;
                                                b3 = m611b(a3, a5, fragment5, arrayList7, view);
                                                m605a(b3, 4);
                                                a2 = m596a(a3, a5, b4, obj, fragment5, z3);
                                                if (a2 != null) {
                                                    if (fragment3 != null && b4 != null && fragment3.mAdded && fragment3.mHidden && fragment3.mHiddenChanged) {
                                                        fragment3.setHideReplaced(true);
                                                        a3.mo151b(b4, fragment3.getView(), b2);
                                                        OneShotPreDrawListener.m700a(fragment3.mContainer, /* anonymous class already generated */);
                                                    }
                                                    a4 = FragmentTransitionImpl.m616a(arrayList7);
                                                    a3.mo144a(a2, a5, b3, b4, b2, obj, arrayList7);
                                                    a3.mo140a((ViewGroup) view2, a2);
                                                    a3.m622a(view2, arrayList8, arrayList7, a4, arrayMap);
                                                    i8 = 0;
                                                    m605a(b3, 0);
                                                    a3.mo146a(obj, arrayList8, arrayList7);
                                                }
                                            }
                                            i8 = 0;
                                        }
                                    }
                                }
                                z3 = z4;
                                arrayList9 = arrayList7;
                                fragment4 = fragment2;
                                arrayMap = a;
                                obj = null;
                                b2 = m611b(a3, b4, fragment3, arrayList8, view);
                                fragment5 = fragment4;
                                arrayList7 = arrayList9;
                                b3 = m611b(a3, a5, fragment5, arrayList7, view);
                                m605a(b3, 4);
                                a2 = m596a(a3, a5, b4, obj, fragment5, z3);
                                if (a2 != null) {
                                    fragment3.setHideReplaced(true);
                                    a3.mo151b(b4, fragment3.getView(), b2);
                                    OneShotPreDrawListener.m700a(fragment3.mContainer, /* anonymous class already generated */);
                                    a4 = FragmentTransitionImpl.m616a(arrayList7);
                                    a3.mo144a(a2, a5, b3, b4, b2, obj, arrayList7);
                                    a3.mo140a((ViewGroup) view2, a2);
                                    a3.m622a(view2, arrayList8, arrayList7, a4, arrayMap);
                                    i8 = 0;
                                    m605a(b3, 0);
                                    a3.mo146a(obj, arrayList8, arrayList7);
                                }
                                i8 = 0;
                            }
                        }
                        sparseArray2 = sparseArray;
                        i6 = i5;
                        i7 = size;
                        i8 = 0;
                    } else {
                        FragmentManagerImpl fragmentManagerImpl3 = fragmentManagerImpl2;
                        sparseArray2 = sparseArray;
                        arrayMap = a;
                        i6 = i5;
                        i7 = size;
                        i8 = 0;
                        ViewGroup viewGroup = fragmentManagerImpl3.f11319n.mo210a() ? (ViewGroup) fragmentManagerImpl3.f11319n.mo209a(keyAt) : null;
                        if (viewGroup != null) {
                            Fragment fragment9 = fragmentContainerTransition.f1044a;
                            Fragment fragment10 = fragmentContainerTransition.f1047d;
                            FragmentTransitionImpl a6 = m590a(fragment10, fragment9);
                            if (a6 != null) {
                                Object obj3;
                                Fragment fragment11;
                                Fragment fragment12;
                                ArrayList arrayList10;
                                Object obj4;
                                FragmentContainerTransition fragmentContainerTransition2;
                                ArrayMap arrayMap3;
                                ArrayList arrayList11;
                                Object obj5;
                                ArrayList arrayList12;
                                final FragmentTransitionImpl fragmentTransitionImpl2;
                                final View view4;
                                final Fragment fragment13;
                                final ArrayList arrayList13;
                                final ArrayList arrayList14;
                                final ArrayList arrayList15;
                                C00912 c00912;
                                C00912 c009122;
                                ArrayMap arrayMap4;
                                Object obj6;
                                boolean z8 = fragmentContainerTransition.f1045b;
                                boolean z9 = fragmentContainerTransition.f1048e;
                                Object a7 = m595a(a6, fragment9, z8);
                                Object b6 = m610b(a6, fragment10, z9);
                                ArrayList arrayList16 = new ArrayList();
                                ArrayList arrayList17 = new ArrayList();
                                Fragment fragment14 = fragmentContainerTransition.f1044a;
                                fragment = fragmentContainerTransition.f1047d;
                                if (fragment14 != null) {
                                    if (fragment != null) {
                                        boolean z10 = fragmentContainerTransition.f1045b;
                                        a = arrayMap;
                                        if (a.isEmpty()) {
                                            obj3 = null;
                                        } else {
                                            obj3 = m594a(a6, fragment14, fragment, z10);
                                        }
                                        b = m608b(a6, a, obj3, fragmentContainerTransition);
                                        if (a.isEmpty()) {
                                            obj3 = null;
                                        } else {
                                            Object obj7 = obj3;
                                            arrayList16.addAll(b.values());
                                            obj3 = obj7;
                                        }
                                        if (a7 == null && b6 == null && obj3 == null) {
                                            fragment11 = fragment9;
                                            fragment12 = fragment10;
                                            arrayList10 = arrayList16;
                                            a2 = b6;
                                            obj4 = a7;
                                            fragmentContainerTransition2 = fragmentContainerTransition;
                                            arrayMap3 = a;
                                            arrayList11 = arrayList17;
                                            obj5 = null;
                                            i9 = i6;
                                            i10 = i7;
                                            if (obj4 != null) {
                                            }
                                            arrayList8 = m611b(a6, a2, fragment12, arrayList10, view);
                                            a2 = null;
                                            a6.mo150b(obj4, view);
                                            obj3 = m596a(a6, obj4, a2, obj5, fragment11, fragmentContainerTransition2.f1045b);
                                            if (obj3 == null) {
                                                arrayList12 = new ArrayList();
                                                a6.mo144a(obj3, obj4, arrayList12, a2, arrayList8, obj5, arrayList11);
                                                b6 = obj4;
                                                fragmentTransitionImpl2 = a6;
                                                arrayList7 = arrayList12;
                                                view4 = view;
                                                fragment13 = fragment11;
                                                arrayList13 = arrayList11;
                                                arrayList14 = arrayList7;
                                                arrayList15 = arrayList8;
                                                c00912 = c009122;
                                                obj = a2;
                                                c009122 = new Runnable() {
                                                    public final void run() {
                                                        if (b6 != null) {
                                                            fragmentTransitionImpl2.mo154c(b6, view4);
                                                            arrayList14.addAll(FragmentTransition.m611b(fragmentTransitionImpl2, b6, fragment13, arrayList13, view4));
                                                        }
                                                        if (arrayList15 != null) {
                                                            if (obj != null) {
                                                                ArrayList arrayList = new ArrayList();
                                                                arrayList.add(view4);
                                                                fragmentTransitionImpl2.mo152b(obj, arrayList15, arrayList);
                                                            }
                                                            arrayList15.clear();
                                                            arrayList15.add(view4);
                                                        }
                                                    }
                                                };
                                                OneShotPreDrawListener.m700a(viewGroup, c00912);
                                                arrayMap4 = arrayMap3;
                                                arrayList8 = arrayList11;
                                                OneShotPreDrawListener.m700a(viewGroup, new C00992(a6, arrayList8, arrayMap4));
                                                a6.mo140a(viewGroup, obj3);
                                                OneShotPreDrawListener.m700a(viewGroup, new C01003(a6, arrayList8, arrayMap4));
                                            }
                                            i5 = i9 + 1;
                                            size = i10;
                                            sparseArray = sparseArray2;
                                            fragmentManagerImpl2 = fragmentManagerImpl;
                                            arrayList5 = arrayList;
                                            arrayList6 = arrayList2;
                                            i3 = i2;
                                            z2 = z;
                                        } else {
                                            Rect rect3;
                                            ArrayList arrayList18;
                                            ArrayMap arrayMap5;
                                            boolean z11;
                                            Fragment fragment15;
                                            Fragment fragment16;
                                            m613b(fragment14, fragment, z10, b);
                                            if (obj3 != null) {
                                                fragment11 = fragment9;
                                                rect3 = new Rect();
                                                a6.mo143a(obj3, view, arrayList16);
                                                arrayList18 = arrayList16;
                                                fragment12 = fragment10;
                                                arrayMap5 = a;
                                                z11 = z10;
                                                fragment15 = fragment;
                                                fragment16 = fragment14;
                                                ArrayMap arrayMap6 = b;
                                                arrayList3 = arrayList17;
                                                m603a(a6, obj3, b6, arrayMap6, fragmentContainerTransition.f1048e, fragmentContainerTransition.f1049f);
                                                if (a7 != null) {
                                                    a6.mo141a(a7, rect3);
                                                }
                                            } else {
                                                fragment11 = fragment9;
                                                fragment12 = fragment10;
                                                arrayList18 = arrayList16;
                                                arrayMap5 = a;
                                                z11 = z10;
                                                fragment15 = fragment;
                                                fragment16 = fragment14;
                                                arrayList3 = arrayList17;
                                                rect3 = null;
                                            }
                                            Object obj8 = b6;
                                            final FragmentTransitionImpl fragmentTransitionImpl3 = a6;
                                            Object obj9 = a7;
                                            final ArrayMap arrayMap7 = arrayMap5;
                                            FragmentContainerTransition fragmentContainerTransition3 = fragmentContainerTransition;
                                            final Object obj10 = obj3;
                                            Object obj11 = obj3;
                                            final FragmentContainerTransition fragmentContainerTransition4 = fragmentContainerTransition3;
                                            arrayMap3 = arrayMap5;
                                            fragmentContainerTransition2 = fragmentContainerTransition3;
                                            arrayList13 = arrayList3;
                                            obj6 = obj9;
                                            i9 = i6;
                                            final View view5 = view;
                                            arrayList11 = arrayList3;
                                            a2 = obj8;
                                            fragment14 = fragment16;
                                            arrayList10 = arrayList18;
                                            i10 = i7;
                                            final Fragment fragment17 = fragment15;
                                            final boolean z12 = z11;
                                            final ArrayList arrayList19 = arrayList10;
                                            final Object obj12 = obj6;
                                            final Rect rect4 = rect3;
                                            OneShotPreDrawListener.m700a(viewGroup, new Runnable() {
                                                public final void run() {
                                                    ArrayMap a = FragmentTransition.m614c(fragmentTransitionImpl3, arrayMap7, obj10, fragmentContainerTransition4);
                                                    if (a != null) {
                                                        arrayList13.addAll(a.values());
                                                        arrayList13.add(view5);
                                                    }
                                                    FragmentTransition.m613b(fragment14, fragment17, z12, a);
                                                    if (obj10 != null) {
                                                        fragmentTransitionImpl3.mo146a(obj10, arrayList19, arrayList13);
                                                        View a2 = FragmentTransition.m609b(a, fragmentContainerTransition4, obj12, z12);
                                                        if (a2 != null) {
                                                            FragmentTransitionImpl.m617a(a2, rect4);
                                                        }
                                                    }
                                                }
                                            });
                                            obj5 = obj11;
                                            obj4 = obj6;
                                            if (obj4 != null && obj5 == null && a2 == null) {
                                                i5 = i9 + 1;
                                                size = i10;
                                                sparseArray = sparseArray2;
                                                fragmentManagerImpl2 = fragmentManagerImpl;
                                                arrayList5 = arrayList;
                                                arrayList6 = arrayList2;
                                                i3 = i2;
                                                z2 = z;
                                            } else {
                                                arrayList8 = m611b(a6, a2, fragment12, arrayList10, view);
                                                if (arrayList8 == null || arrayList8.isEmpty()) {
                                                    a2 = null;
                                                }
                                                a6.mo150b(obj4, view);
                                                obj3 = m596a(a6, obj4, a2, obj5, fragment11, fragmentContainerTransition2.f1045b);
                                                if (obj3 == null) {
                                                    arrayList12 = new ArrayList();
                                                    a6.mo144a(obj3, obj4, arrayList12, a2, arrayList8, obj5, arrayList11);
                                                    b6 = obj4;
                                                    fragmentTransitionImpl2 = a6;
                                                    arrayList7 = arrayList12;
                                                    view4 = view;
                                                    fragment13 = fragment11;
                                                    arrayList13 = arrayList11;
                                                    arrayList14 = arrayList7;
                                                    arrayList15 = arrayList8;
                                                    c00912 = c009122;
                                                    obj = a2;
                                                    c009122 = /* anonymous class already generated */;
                                                    OneShotPreDrawListener.m700a(viewGroup, c00912);
                                                    arrayMap4 = arrayMap3;
                                                    arrayList8 = arrayList11;
                                                    OneShotPreDrawListener.m700a(viewGroup, new C00992(a6, arrayList8, arrayMap4));
                                                    a6.mo140a(viewGroup, obj3);
                                                    OneShotPreDrawListener.m700a(viewGroup, new C01003(a6, arrayList8, arrayMap4));
                                                }
                                                i5 = i9 + 1;
                                                size = i10;
                                                sparseArray = sparseArray2;
                                                fragmentManagerImpl2 = fragmentManagerImpl;
                                                arrayList5 = arrayList;
                                                arrayList6 = arrayList2;
                                                i3 = i2;
                                                z2 = z;
                                            }
                                        }
                                    }
                                }
                                i11 = 0;
                                fragment11 = fragment9;
                                fragment12 = fragment10;
                                arrayList10 = arrayList16;
                                a2 = b6;
                                obj6 = a7;
                                fragmentContainerTransition2 = fragmentContainerTransition;
                                arrayList11 = arrayList17;
                                i9 = i6;
                                i10 = i7;
                                arrayMap3 = arrayMap;
                                obj5 = null;
                                obj4 = obj6;
                                if (obj4 != null) {
                                }
                                arrayList8 = m611b(a6, a2, fragment12, arrayList10, view);
                                a2 = null;
                                a6.mo150b(obj4, view);
                                obj3 = m596a(a6, obj4, a2, obj5, fragment11, fragmentContainerTransition2.f1045b);
                                if (obj3 == null) {
                                    arrayList12 = new ArrayList();
                                    a6.mo144a(obj3, obj4, arrayList12, a2, arrayList8, obj5, arrayList11);
                                    b6 = obj4;
                                    fragmentTransitionImpl2 = a6;
                                    arrayList7 = arrayList12;
                                    view4 = view;
                                    fragment13 = fragment11;
                                    arrayList13 = arrayList11;
                                    arrayList14 = arrayList7;
                                    arrayList15 = arrayList8;
                                    c00912 = c009122;
                                    obj = a2;
                                    c009122 = /* anonymous class already generated */;
                                    OneShotPreDrawListener.m700a(viewGroup, c00912);
                                    arrayMap4 = arrayMap3;
                                    arrayList8 = arrayList11;
                                    OneShotPreDrawListener.m700a(viewGroup, new C00992(a6, arrayList8, arrayMap4));
                                    a6.mo140a(viewGroup, obj3);
                                    OneShotPreDrawListener.m700a(viewGroup, new C01003(a6, arrayList8, arrayMap4));
                                }
                                i5 = i9 + 1;
                                size = i10;
                                sparseArray = sparseArray2;
                                fragmentManagerImpl2 = fragmentManagerImpl;
                                arrayList5 = arrayList;
                                arrayList6 = arrayList2;
                                i3 = i2;
                                z2 = z;
                            }
                        }
                    }
                    i11 = i8;
                    i9 = i6;
                    i10 = i7;
                    i5 = i9 + 1;
                    size = i10;
                    sparseArray = sparseArray2;
                    fragmentManagerImpl2 = fragmentManagerImpl;
                    arrayList5 = arrayList;
                    arrayList6 = arrayList2;
                    i3 = i2;
                    z2 = z;
                }
            }
        }
    }

    private static ArrayMap<String, String> m591a(int i, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayMap<String, String> arrayMap = new ArrayMap();
        for (i3--; i3 >= i2; i3--) {
            BackStackRecord backStackRecord = (BackStackRecord) arrayList.get(i3);
            if (backStackRecord.m9788b(i)) {
                boolean booleanValue = ((Boolean) arrayList2.get(i3)).booleanValue();
                if (backStackRecord.f11269r != null) {
                    ArrayList arrayList3;
                    ArrayList arrayList4;
                    int size = backStackRecord.f11269r.size();
                    if (booleanValue) {
                        arrayList3 = backStackRecord.f11269r;
                        arrayList4 = backStackRecord.f11270s;
                    } else {
                        ArrayList arrayList5 = backStackRecord.f11269r;
                        arrayList3 = backStackRecord.f11270s;
                        arrayList4 = arrayList5;
                    }
                    for (int i4 = 0; i4 < size; i4++) {
                        String str = (String) arrayList4.get(i4);
                        String str2 = (String) arrayList3.get(i4);
                        String str3 = (String) arrayMap.remove(str2);
                        if (str3 != null) {
                            arrayMap.put(str, str3);
                        } else {
                            arrayMap.put(str, str2);
                        }
                    }
                }
            }
        }
        return arrayMap;
    }

    private static FragmentTransitionImpl m590a(Fragment fragment, Fragment fragment2) {
        List arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            exitTransition = fragment.getReturnTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            fragment = fragment.getSharedElementReturnTransition();
            if (fragment != null) {
                arrayList.add(fragment);
            }
        }
        if (fragment2 != null) {
            fragment = fragment2.getEnterTransition();
            if (fragment != null) {
                arrayList.add(fragment);
            }
            fragment = fragment2.getReenterTransition();
            if (fragment != null) {
                arrayList.add(fragment);
            }
            fragment = fragment2.getSharedElementEnterTransition();
            if (fragment != null) {
                arrayList.add(fragment);
            }
        }
        if (arrayList.isEmpty() != null) {
            return null;
        }
        if (f1051b != null && m607a(f1051b, arrayList) != null) {
            return f1051b;
        }
        if (f1052c != null && m607a(f1052c, arrayList) != null) {
            return f1052c;
        }
        if (f1051b == null) {
            if (f1052c == null) {
                return null;
            }
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    private static boolean m607a(FragmentTransitionImpl fragmentTransitionImpl, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!fragmentTransitionImpl.mo147a(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static Object m594a(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment != null) {
            if (fragment2 != null) {
                if (z) {
                    fragment = fragment2.getSharedElementReturnTransition();
                } else {
                    fragment = fragment.getSharedElementEnterTransition();
                }
                return fragmentTransitionImpl.mo153c(fragmentTransitionImpl.mo148b(fragment));
            }
        }
        return null;
    }

    private static Object m595a(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        if (z) {
            fragment = fragment.getReenterTransition();
        } else {
            fragment = fragment.getEnterTransition();
        }
        return fragmentTransitionImpl.mo148b(fragment);
    }

    private static Object m610b(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        if (z) {
            fragment = fragment.getReturnTransition();
        } else {
            fragment = fragment.getExitTransition();
        }
        return fragmentTransitionImpl.mo148b(fragment);
    }

    private static void m606a(ArrayList<View> arrayList, ArrayMap<String, View> arrayMap, Collection<String> collection) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View view = (View) arrayMap.m1054c(size);
            if (collection.contains(ViewCompat.m1262w(view))) {
                arrayList.add(view);
            }
        }
    }

    private static ArrayMap<String, View> m608b(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap<String, String> arrayMap, Object obj, FragmentContainerTransition fragmentContainerTransition) {
        if (!arrayMap.isEmpty()) {
            if (obj != null) {
                obj = fragmentContainerTransition.f1047d;
                Map arrayMap2 = new ArrayMap();
                fragmentTransitionImpl.m631a(arrayMap2, obj.getView());
                fragmentTransitionImpl = fragmentContainerTransition.f1049f;
                if (fragmentContainerTransition.f1048e != null) {
                    obj = obj.getEnterTransitionCallback();
                    fragmentTransitionImpl = fragmentTransitionImpl.f11270s;
                } else {
                    obj = obj.getExitTransitionCallback();
                    fragmentTransitionImpl = fragmentTransitionImpl.f11269r;
                }
                MapCollections.m1024c(arrayMap2, fragmentTransitionImpl);
                if (obj != null) {
                    for (obj = fragmentTransitionImpl.size() - 1; obj >= null; obj--) {
                        String str = (String) fragmentTransitionImpl.get(obj);
                        View view = (View) arrayMap2.get(str);
                        if (view == null) {
                            arrayMap.remove(str);
                        } else if (!str.equals(ViewCompat.m1262w(view))) {
                            arrayMap.put(ViewCompat.m1262w(view), (String) arrayMap.remove(str));
                        }
                    }
                } else {
                    MapCollections.m1024c(arrayMap, arrayMap2.keySet());
                }
                return arrayMap2;
            }
        }
        arrayMap.clear();
        return null;
    }

    private static ArrayMap<String, View> m614c(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap<String, String> arrayMap, Object obj, FragmentContainerTransition fragmentContainerTransition) {
        Fragment fragment = fragmentContainerTransition.f1044a;
        View view = fragment.getView();
        if (!(arrayMap.isEmpty() || obj == null)) {
            if (view != null) {
                Map arrayMap2 = new ArrayMap();
                fragmentTransitionImpl.m631a(arrayMap2, view);
                fragmentTransitionImpl = fragmentContainerTransition.f1046c;
                if (fragmentContainerTransition.f1045b != null) {
                    fragmentContainerTransition = fragment.getExitTransitionCallback();
                    fragmentTransitionImpl = fragmentTransitionImpl.f11269r;
                } else {
                    fragmentContainerTransition = fragment.getEnterTransitionCallback();
                    fragmentTransitionImpl = fragmentTransitionImpl.f11270s;
                }
                if (fragmentTransitionImpl != null) {
                    MapCollections.m1024c(arrayMap2, fragmentTransitionImpl);
                }
                if (fragmentContainerTransition != null) {
                    for (fragmentContainerTransition = fragmentTransitionImpl.size() - 1; fragmentContainerTransition >= null; fragmentContainerTransition--) {
                        String str = (String) fragmentTransitionImpl.get(fragmentContainerTransition);
                        view = (View) arrayMap2.get(str);
                        if (view == null) {
                            str = m597a((ArrayMap) arrayMap, str);
                            if (str != null) {
                                arrayMap.remove(str);
                            }
                        } else if (!str.equals(ViewCompat.m1262w(view))) {
                            str = m597a((ArrayMap) arrayMap, str);
                            if (str != null) {
                                arrayMap.put(str, ViewCompat.m1262w(view));
                            }
                        }
                    }
                } else {
                    for (fragmentTransitionImpl = arrayMap.size() - 1; fragmentTransitionImpl >= null; fragmentTransitionImpl--) {
                        if (arrayMap2.containsKey((String) arrayMap.m1054c(fragmentTransitionImpl)) == null) {
                            arrayMap.m1055d(fragmentTransitionImpl);
                        }
                    }
                }
                return arrayMap2;
            }
        }
        arrayMap.clear();
        return null;
    }

    private static String m597a(ArrayMap<String, String> arrayMap, String str) {
        int size = arrayMap.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(arrayMap.m1054c(i))) {
                return (String) arrayMap.m1053b(i);
            }
        }
        return null;
    }

    private static View m609b(ArrayMap<String, View> arrayMap, FragmentContainerTransition fragmentContainerTransition, Object obj, boolean z) {
        fragmentContainerTransition = fragmentContainerTransition.f1046c;
        if (obj == null || arrayMap == null || fragmentContainerTransition.f11269r == null || fragmentContainerTransition.f11269r.isEmpty() != null) {
            return null;
        }
        if (z) {
            fragmentContainerTransition = (String) fragmentContainerTransition.f11269r.get(0);
        } else {
            fragmentContainerTransition = (String) fragmentContainerTransition.f11270s.get(0);
        }
        return (View) arrayMap.get(fragmentContainerTransition);
    }

    private static void m603a(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Object obj2, ArrayMap<String, View> arrayMap, boolean z, BackStackRecord backStackRecord) {
        if (backStackRecord.f11269r != null && !backStackRecord.f11269r.isEmpty()) {
            if (z) {
                z = (String) backStackRecord.f11270s.get(0);
            } else {
                z = (String) backStackRecord.f11269r.get(0);
            }
            View view = (View) arrayMap.get(z);
            fragmentTransitionImpl.mo142a(obj, view);
            if (obj2 != null) {
                fragmentTransitionImpl.mo142a(obj2, view);
            }
        }
    }

    private static void m613b(Fragment fragment, Fragment fragment2, boolean z, ArrayMap<String, View> arrayMap) {
        if (z) {
            fragment = fragment2.getEnterTransitionCallback();
        } else {
            fragment = fragment.getEnterTransitionCallback();
        }
        if (fragment != null) {
            boolean z2;
            fragment = new ArrayList();
            fragment2 = new ArrayList();
            z = false;
            if (arrayMap == null) {
                z2 = false;
            } else {
                z2 = arrayMap.size();
            }
            while (z < z2) {
                fragment2.add(arrayMap.m1053b((int) z));
                fragment.add(arrayMap.m1054c(z));
                z++;
            }
        }
    }

    private static ArrayList<View> m611b(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        View view2 = fragment.getView();
        if (view2 != null) {
            fragmentTransitionImpl.m630a(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty() != null) {
            return arrayList2;
        }
        arrayList2.add(view);
        fragmentTransitionImpl.mo145a(obj, arrayList2);
        return arrayList2;
    }

    private static void m605a(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((View) arrayList.get(size)).setVisibility(i);
            }
        }
    }

    private static Object m596a(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        fragment = (obj == null || obj2 == null || fragment == null) ? true : z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        if (fragment != null) {
            return fragmentTransitionImpl.mo139a(obj2, obj, obj3);
        }
        return fragmentTransitionImpl.mo149b(obj2, obj, obj3);
    }

    private static void m600a(BackStackRecord backStackRecord, SparseArray<FragmentContainerTransition> sparseArray, boolean z) {
        int size = backStackRecord.f11253b.size();
        for (int i = 0; i < size; i++) {
            m599a(backStackRecord, (Op) backStackRecord.f11253b.get(i), (SparseArray) sparseArray, false, z);
        }
    }

    private static void m612b(BackStackRecord backStackRecord, SparseArray<FragmentContainerTransition> sparseArray, boolean z) {
        if (backStackRecord.f11252a.f11319n.mo210a()) {
            for (int size = backStackRecord.f11253b.size() - 1; size >= 0; size--) {
                m599a(backStackRecord, (Op) backStackRecord.f11253b.get(size), (SparseArray) sparseArray, true, z);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m599a(android.support.v4.app.BackStackRecord r11, android.support.v4.app.BackStackRecord.Op r12, android.util.SparseArray<android.support.v4.app.FragmentTransition.FragmentContainerTransition> r13, boolean r14, boolean r15) {
        /*
        r6 = r12.f935b;
        if (r6 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r7 = r6.mContainerId;
        if (r7 != 0) goto L_0x000a;
    L_0x0009:
        return;
    L_0x000a:
        if (r14 == 0) goto L_0x0013;
    L_0x000c:
        r0 = f1050a;
        r12 = r12.f934a;
        r12 = r0[r12];
        goto L_0x0015;
    L_0x0013:
        r12 = r12.f934a;
    L_0x0015:
        r0 = 0;
        r1 = 1;
        if (r12 == r1) goto L_0x0076;
    L_0x0019:
        switch(r12) {
            case 3: goto L_0x004c;
            case 4: goto L_0x0034;
            case 5: goto L_0x0021;
            case 6: goto L_0x004c;
            case 7: goto L_0x0076;
            default: goto L_0x001c;
        };
    L_0x001c:
        r12 = r0;
        r1 = r12;
        r8 = r1;
        goto L_0x0089;
    L_0x0021:
        if (r15 == 0) goto L_0x0030;
    L_0x0023:
        r12 = r6.mHiddenChanged;
        if (r12 == 0) goto L_0x0085;
    L_0x0027:
        r12 = r6.mHidden;
        if (r12 != 0) goto L_0x0085;
    L_0x002b:
        r12 = r6.mAdded;
        if (r12 == 0) goto L_0x0085;
    L_0x002f:
        goto L_0x0083;
    L_0x0030:
        r12 = r6.mHidden;
        goto L_0x0086;
    L_0x0034:
        if (r15 == 0) goto L_0x0043;
    L_0x0036:
        r12 = r6.mHiddenChanged;
        if (r12 == 0) goto L_0x0067;
    L_0x003a:
        r12 = r6.mAdded;
        if (r12 == 0) goto L_0x0067;
    L_0x003e:
        r12 = r6.mHidden;
        if (r12 == 0) goto L_0x0067;
    L_0x0042:
        goto L_0x0065;
    L_0x0043:
        r12 = r6.mAdded;
        if (r12 == 0) goto L_0x0067;
    L_0x0047:
        r12 = r6.mHidden;
        if (r12 != 0) goto L_0x0067;
    L_0x004b:
        goto L_0x0042;
    L_0x004c:
        if (r15 == 0) goto L_0x0069;
    L_0x004e:
        r12 = r6.mAdded;
        if (r12 != 0) goto L_0x0067;
    L_0x0052:
        r12 = r6.mView;
        if (r12 == 0) goto L_0x0067;
    L_0x0056:
        r12 = r6.mView;
        r12 = r12.getVisibility();
        if (r12 != 0) goto L_0x0067;
    L_0x005e:
        r12 = r6.mPostponedAlpha;
        r2 = 0;
        r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1));
        if (r12 < 0) goto L_0x0067;
    L_0x0065:
        r12 = r1;
        goto L_0x0072;
    L_0x0067:
        r12 = r0;
        goto L_0x0072;
    L_0x0069:
        r12 = r6.mAdded;
        if (r12 == 0) goto L_0x0067;
    L_0x006d:
        r12 = r6.mHidden;
        if (r12 != 0) goto L_0x0067;
    L_0x0071:
        goto L_0x0065;
    L_0x0072:
        r8 = r12;
        r12 = r1;
        r1 = r0;
        goto L_0x0089;
    L_0x0076:
        if (r15 == 0) goto L_0x007b;
    L_0x0078:
        r12 = r6.mIsNewlyAdded;
        goto L_0x0086;
    L_0x007b:
        r12 = r6.mAdded;
        if (r12 != 0) goto L_0x0085;
    L_0x007f:
        r12 = r6.mHidden;
        if (r12 != 0) goto L_0x0085;
    L_0x0083:
        r12 = r1;
        goto L_0x0086;
    L_0x0085:
        r12 = r0;
    L_0x0086:
        r8 = r0;
        r0 = r12;
        r12 = r8;
    L_0x0089:
        r2 = r13.get(r7);
        r2 = (android.support.v4.app.FragmentTransition.FragmentContainerTransition) r2;
        if (r0 == 0) goto L_0x009b;
    L_0x0091:
        r2 = m588a(r2, r13, r7);
        r2.f1044a = r6;
        r2.f1045b = r14;
        r2.f1046c = r11;
    L_0x009b:
        r9 = r2;
        r10 = 0;
        if (r15 != 0) goto L_0x00c2;
    L_0x009f:
        if (r1 == 0) goto L_0x00c2;
    L_0x00a1:
        if (r9 == 0) goto L_0x00a9;
    L_0x00a3:
        r0 = r9.f1047d;
        if (r0 != r6) goto L_0x00a9;
    L_0x00a7:
        r9.f1047d = r10;
    L_0x00a9:
        r0 = r11.f11252a;
        r1 = r6.mState;
        if (r1 > 0) goto L_0x00c2;
    L_0x00af:
        r1 = r0.f11317l;
        if (r1 <= 0) goto L_0x00c2;
    L_0x00b3:
        r1 = r11.f11271t;
        if (r1 != 0) goto L_0x00c2;
    L_0x00b7:
        r0.m9903d(r6);
        r2 = 1;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r1 = r6;
        r0.m9880a(r1, r2, r3, r4, r5);
    L_0x00c2:
        if (r8 == 0) goto L_0x00d4;
    L_0x00c4:
        if (r9 == 0) goto L_0x00ca;
    L_0x00c6:
        r0 = r9.f1047d;
        if (r0 != 0) goto L_0x00d4;
    L_0x00ca:
        r9 = m588a(r9, r13, r7);
        r9.f1047d = r6;
        r9.f1048e = r14;
        r9.f1049f = r11;
    L_0x00d4:
        if (r15 != 0) goto L_0x00e0;
    L_0x00d6:
        if (r12 == 0) goto L_0x00e0;
    L_0x00d8:
        if (r9 == 0) goto L_0x00e0;
    L_0x00da:
        r11 = r9.f1044a;
        if (r11 != r6) goto L_0x00e0;
    L_0x00de:
        r9.f1044a = r10;
    L_0x00e0:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentTransition.a(android.support.v4.app.BackStackRecord, android.support.v4.app.BackStackRecord$Op, android.util.SparseArray, boolean, boolean):void");
    }

    private static FragmentContainerTransition m588a(FragmentContainerTransition fragmentContainerTransition, SparseArray<FragmentContainerTransition> sparseArray, int i) {
        if (fragmentContainerTransition != null) {
            return fragmentContainerTransition;
        }
        fragmentContainerTransition = new FragmentContainerTransition();
        sparseArray.put(i, fragmentContainerTransition);
        return fragmentContainerTransition;
    }
}
