package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.ContainerHelpers;
import android.support.v4.util.LongSparseArray;
import android.support.v4.view.ViewCompat;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class Transition implements Cloneable {
    private static ThreadLocal<ArrayMap<Animator, AnimationInfo>> f861A = new ThreadLocal();
    private static final int[] f862k = new int[]{2, 1, 3, 4};
    private static final PathMotion f863l = new C09971();
    private ViewGroup f864B = null;
    private ArrayList<Animator> f865C = new ArrayList();
    private int f866D = 0;
    private boolean f867E = false;
    private boolean f868F = false;
    private ArrayList<TransitionListener> f869G = null;
    private ArrayList<Animator> f870H = new ArrayList();
    private EpicenterCallback f871I;
    private ArrayMap<String, String> f872J;
    long f873a = -1;
    long f874b = -1;
    ArrayList<Integer> f875c = new ArrayList();
    ArrayList<View> f876d = new ArrayList();
    ArrayList<String> f877e = null;
    ArrayList<Class> f878f = null;
    TransitionSet f879g = null;
    boolean f880h = false;
    TransitionPropagation f881i;
    PathMotion f882j = f863l;
    private String f883m = getClass().getName();
    private TimeInterpolator f884n = null;
    private ArrayList<Integer> f885o = null;
    private ArrayList<View> f886p = null;
    private ArrayList<Class> f887q = null;
    private ArrayList<String> f888r = null;
    private ArrayList<Integer> f889s = null;
    private ArrayList<View> f890t = null;
    private ArrayList<Class> f891u = null;
    private TransitionValuesMaps f892v = new TransitionValuesMaps();
    private TransitionValuesMaps f893w = new TransitionValuesMaps();
    private int[] f894x = f862k;
    private ArrayList<TransitionValues> f895y;
    private ArrayList<TransitionValues> f896z;

    class C00713 extends AnimatorListenerAdapter {
        final /* synthetic */ Transition f855a;

        C00713(Transition transition) {
            this.f855a = transition;
        }

        public void onAnimationEnd(Animator animator) {
            this.f855a.m478d();
            animator.removeListener(this);
        }
    }

    private static class AnimationInfo {
        View f856a;
        String f857b;
        TransitionValues f858c;
        WindowIdImpl f859d;
        Transition f860e;

        AnimationInfo(View view, String str, Transition transition, WindowIdImpl windowIdImpl, TransitionValues transitionValues) {
            this.f856a = view;
            this.f857b = str;
            this.f858c = transitionValues;
            this.f859d = windowIdImpl;
            this.f860e = transition;
        }
    }

    private static class ArrayListManager {
        static <T> ArrayList<T> m442a(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            if (!arrayList.contains(t)) {
                arrayList.add(t);
            }
            return arrayList;
        }

        static <T> ArrayList<T> m443b(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                return arrayList;
            }
            arrayList.remove(t);
            return arrayList.isEmpty() != null ? null : arrayList;
        }
    }

    public static abstract class EpicenterCallback {
    }

    public interface TransitionListener {
        void mo135a();

        void mo136a(Transition transition);

        void mo137b();

        void mo138c();
    }

    static class C09971 extends PathMotion {
        C09971() {
        }

        public final Path mo157a(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    }

    public Animator mo131a(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public abstract void mo132a(TransitionValues transitionValues);

    public String[] mo133a() {
        return null;
    }

    public abstract void mo134b(TransitionValues transitionValues);

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return mo172e();
    }

    public Transition mo158a(long j) {
        this.f874b = j;
        return this;
    }

    public Transition mo164b(long j) {
        this.f873a = j;
        return this;
    }

    private void m449a(TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2) {
        ArrayMap arrayMap = new ArrayMap(transitionValuesMaps.f905a);
        ArrayMap arrayMap2 = new ArrayMap(transitionValuesMaps2.f905a);
        int i = 0;
        for (int i2 : this.f894x) {
            int i22;
            int size;
            int i3;
            View view;
            View view2;
            TransitionValues transitionValues;
            TransitionValues transitionValues2;
            switch (i22) {
                case 1:
                    for (i22 = arrayMap.size() - 1; i22 >= 0; i22--) {
                        View view3 = (View) arrayMap.m1053b(i22);
                        if (view3 != null && m466a(view3)) {
                            TransitionValues transitionValues3 = (TransitionValues) arrayMap2.remove(view3);
                            if (!(transitionValues3 == null || transitionValues3.f903b == null || !m466a(transitionValues3.f903b))) {
                                this.f895y.add((TransitionValues) arrayMap.m1055d(i22));
                                this.f896z.add(transitionValues3);
                            }
                        }
                    }
                    break;
                case 2:
                    ArrayMap arrayMap3 = transitionValuesMaps.f908d;
                    ArrayMap arrayMap4 = transitionValuesMaps2.f908d;
                    size = arrayMap3.size();
                    for (i3 = 0; i3 < size; i3++) {
                        view = (View) arrayMap3.m1054c(i3);
                        if (view != null && m466a(view)) {
                            view2 = (View) arrayMap4.get(arrayMap3.m1053b(i3));
                            if (view2 != null && m466a(view2)) {
                                transitionValues = (TransitionValues) arrayMap.get(view);
                                transitionValues2 = (TransitionValues) arrayMap2.get(view2);
                                if (!(transitionValues == null || transitionValues2 == null)) {
                                    this.f895y.add(transitionValues);
                                    this.f896z.add(transitionValues2);
                                    arrayMap.remove(view);
                                    arrayMap2.remove(view2);
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    SparseArray sparseArray = transitionValuesMaps.f906b;
                    SparseArray sparseArray2 = transitionValuesMaps2.f906b;
                    size = sparseArray.size();
                    for (i3 = 0; i3 < size; i3++) {
                        view = (View) sparseArray.valueAt(i3);
                        if (view != null && m466a(view)) {
                            view2 = (View) sparseArray2.get(sparseArray.keyAt(i3));
                            if (view2 != null && m466a(view2)) {
                                transitionValues = (TransitionValues) arrayMap.get(view);
                                transitionValues2 = (TransitionValues) arrayMap2.get(view2);
                                if (!(transitionValues == null || transitionValues2 == null)) {
                                    this.f895y.add(transitionValues);
                                    this.f896z.add(transitionValues2);
                                    arrayMap.remove(view);
                                    arrayMap2.remove(view2);
                                }
                            }
                        }
                    }
                    break;
                case 4:
                    LongSparseArray longSparseArray = transitionValuesMaps.f907c;
                    LongSparseArray longSparseArray2 = transitionValuesMaps2.f907c;
                    size = longSparseArray.m1018b();
                    for (i3 = 0; i3 < size; i3++) {
                        view = (View) longSparseArray.m1019b(i3);
                        if (view != null && m466a(view)) {
                            view2 = (View) longSparseArray2.m1015a(longSparseArray.m1014a(i3));
                            if (view2 != null && m466a(view2)) {
                                transitionValues = (TransitionValues) arrayMap.get(view);
                                transitionValues2 = (TransitionValues) arrayMap2.get(view2);
                                if (!(transitionValues == null || transitionValues2 == null)) {
                                    this.f895y.add(transitionValues);
                                    this.f896z.add(transitionValues2);
                                    arrayMap.remove(view);
                                    arrayMap2.remove(view2);
                                }
                            }
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        for (transitionValuesMaps = null; transitionValuesMaps < arrayMap.size(); transitionValuesMaps++) {
            TransitionValues transitionValues4 = (TransitionValues) arrayMap.m1054c(transitionValuesMaps);
            if (m466a(transitionValues4.f903b)) {
                this.f895y.add(transitionValues4);
                this.f896z.add(null);
            }
        }
        while (i < arrayMap2.size()) {
            TransitionValues transitionValues5 = (TransitionValues) arrayMap2.m1054c(i);
            if (m466a(transitionValues5.f903b) != null) {
                this.f896z.add(transitionValues5);
                this.f895y.add(null);
            }
            i++;
        }
    }

    protected void mo163a(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        Transition transition = this;
        ArrayMap f = m453f();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j = Long.MAX_VALUE;
        int i = 0;
        while (i < size) {
            ViewGroup viewGroup2;
            int i2;
            Object obj;
            Animator a;
            View view;
            TransitionValues transitionValues;
            Animator animator;
            TransitionValues transitionValues2;
            Object obj2;
            TransitionValues transitionValues3 = (TransitionValues) arrayList.get(i);
            TransitionValues transitionValues4 = (TransitionValues) arrayList2.get(i);
            if (!(transitionValues3 == null || transitionValues3.f904c.contains(transition))) {
                transitionValues3 = null;
            }
            if (!(transitionValues4 == null || transitionValues4.f904c.contains(transition))) {
                transitionValues4 = null;
            }
            if (transitionValues3 == null) {
                if (transitionValues4 != null) {
                }
                viewGroup2 = viewGroup;
                i2 = size;
                i++;
                size = i2;
            }
            if (!(transitionValues3 == null || transitionValues4 == null)) {
                if (!mo189a(transitionValues3, transitionValues4)) {
                    obj = null;
                    if (obj != null) {
                        a = mo131a(viewGroup, transitionValues3, transitionValues4);
                        if (a != null) {
                            if (transitionValues4 == null) {
                                view = transitionValues4.f903b;
                                String[] a2 = mo133a();
                                if (view == null && a2 != null && a2.length > 0) {
                                    transitionValues = new TransitionValues();
                                    transitionValues.f903b = view;
                                    TransitionValues transitionValues5 = (TransitionValues) transitionValuesMaps2.f905a.get(view);
                                    if (transitionValues5 != null) {
                                        animator = a;
                                        i2 = size;
                                        int i3 = 0;
                                        while (i3 < a2.length) {
                                            TransitionValues transitionValues6 = transitionValues5;
                                            transitionValues.f902a.put(a2[i3], transitionValues5.f902a.get(a2[i3]));
                                            i3++;
                                            transitionValues5 = transitionValues6;
                                            TransitionValuesMaps transitionValuesMaps3 = transitionValuesMaps2;
                                            ArrayList<TransitionValues> arrayList3 = arrayList;
                                        }
                                    } else {
                                        animator = a;
                                        i2 = size;
                                    }
                                    int size2 = f.size();
                                    for (int i4 = 0; i4 < size2; i4++) {
                                        AnimationInfo animationInfo = (AnimationInfo) f.get((Animator) f.m1053b(i4));
                                        if (animationInfo.f858c != null && animationInfo.f856a == view && animationInfo.f857b.equals(transition.f883m) && animationInfo.f858c.equals(transitionValues)) {
                                            transitionValues2 = transitionValues;
                                            obj2 = null;
                                            break;
                                        }
                                    }
                                } else {
                                    animator = a;
                                    i2 = size;
                                    transitionValues = null;
                                }
                                transitionValues2 = transitionValues;
                                obj2 = animator;
                            } else {
                                animator = a;
                                i2 = size;
                                view = transitionValues3.f903b;
                                obj2 = animator;
                                transitionValues2 = null;
                            }
                            if (obj2 == null) {
                                if (transition.f881i != null) {
                                    long a3 = transition.f881i.m486a();
                                    sparseIntArray.put(transition.f870H.size(), (int) a3);
                                    j = Math.min(a3, j);
                                }
                                long j2 = j;
                                f.put(obj2, new AnimationInfo(view, transition.f883m, transition, ViewUtils.m503b(viewGroup), transitionValues2));
                                transition.f870H.add(obj2);
                                j = j2;
                            }
                            i++;
                            size = i2;
                        }
                        i2 = size;
                        i++;
                        size = i2;
                    }
                    viewGroup2 = viewGroup;
                    i2 = size;
                    i++;
                    size = i2;
                }
            }
            obj = 1;
            if (obj != null) {
                a = mo131a(viewGroup, transitionValues3, transitionValues4);
                if (a != null) {
                    if (transitionValues4 == null) {
                        animator = a;
                        i2 = size;
                        view = transitionValues3.f903b;
                        obj2 = animator;
                        transitionValues2 = null;
                    } else {
                        view = transitionValues4.f903b;
                        String[] a22 = mo133a();
                        if (view == null) {
                        }
                        animator = a;
                        i2 = size;
                        transitionValues = null;
                        transitionValues2 = transitionValues;
                        obj2 = animator;
                    }
                    if (obj2 == null) {
                        if (transition.f881i != null) {
                            long a32 = transition.f881i.m486a();
                            sparseIntArray.put(transition.f870H.size(), (int) a32);
                            j = Math.min(a32, j);
                        }
                        long j22 = j;
                        f.put(obj2, new AnimationInfo(view, transition.f883m, transition, ViewUtils.m503b(viewGroup), transitionValues2));
                        transition.f870H.add(obj2);
                        j = j22;
                    }
                    i++;
                    size = i2;
                }
                i2 = size;
                i++;
                size = i2;
            }
            viewGroup2 = viewGroup;
            i2 = size;
            i++;
            size = i2;
        }
        if (j != 0) {
            for (int i5 = 0; i5 < sparseIntArray.size(); i5++) {
                Animator animator2 = (Animator) transition.f870H.get(sparseIntArray.keyAt(i5));
                animator2.setStartDelay((((long) sparseIntArray.valueAt(i5)) - j) + animator2.getStartDelay());
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final boolean m466a(android.view.View r6) {
        /*
        r5 = this;
        r0 = r6.getId();
        r1 = r5.f885o;
        r2 = 0;
        if (r1 == 0) goto L_0x0016;
    L_0x0009:
        r1 = r5.f885o;
        r3 = java.lang.Integer.valueOf(r0);
        r1 = r1.contains(r3);
        if (r1 == 0) goto L_0x0016;
    L_0x0015:
        return r2;
    L_0x0016:
        r1 = r5.f886p;
        if (r1 == 0) goto L_0x0023;
    L_0x001a:
        r1 = r5.f886p;
        r1 = r1.contains(r6);
        if (r1 == 0) goto L_0x0023;
    L_0x0022:
        return r2;
    L_0x0023:
        r1 = r5.f887q;
        if (r1 == 0) goto L_0x0042;
    L_0x0027:
        r1 = r5.f887q;
        r1 = r1.size();
        r3 = r2;
    L_0x002e:
        if (r3 >= r1) goto L_0x0042;
    L_0x0030:
        r4 = r5.f887q;
        r4 = r4.get(r3);
        r4 = (java.lang.Class) r4;
        r4 = r4.isInstance(r6);
        if (r4 == 0) goto L_0x003f;
    L_0x003e:
        return r2;
    L_0x003f:
        r3 = r3 + 1;
        goto L_0x002e;
    L_0x0042:
        r1 = r5.f888r;
        if (r1 == 0) goto L_0x0059;
    L_0x0046:
        r1 = android.support.v4.view.ViewCompat.m1262w(r6);
        if (r1 == 0) goto L_0x0059;
    L_0x004c:
        r1 = r5.f888r;
        r3 = android.support.v4.view.ViewCompat.m1262w(r6);
        r1 = r1.contains(r3);
        if (r1 == 0) goto L_0x0059;
    L_0x0058:
        return r2;
    L_0x0059:
        r1 = r5.f875c;
        r1 = r1.size();
        r3 = 1;
        if (r1 != 0) goto L_0x0083;
    L_0x0062:
        r1 = r5.f876d;
        r1 = r1.size();
        if (r1 != 0) goto L_0x0083;
    L_0x006a:
        r1 = r5.f878f;
        if (r1 == 0) goto L_0x0076;
    L_0x006e:
        r1 = r5.f878f;
        r1 = r1.isEmpty();
        if (r1 == 0) goto L_0x0083;
    L_0x0076:
        r1 = r5.f877e;
        if (r1 == 0) goto L_0x0082;
    L_0x007a:
        r1 = r5.f877e;
        r1 = r1.isEmpty();
        if (r1 == 0) goto L_0x0083;
    L_0x0082:
        return r3;
    L_0x0083:
        r1 = r5.f875c;
        r0 = java.lang.Integer.valueOf(r0);
        r0 = r1.contains(r0);
        if (r0 != 0) goto L_0x00c9;
    L_0x008f:
        r0 = r5.f876d;
        r0 = r0.contains(r6);
        if (r0 == 0) goto L_0x0098;
    L_0x0097:
        goto L_0x00c9;
    L_0x0098:
        r0 = r5.f877e;
        if (r0 == 0) goto L_0x00a9;
    L_0x009c:
        r0 = r5.f877e;
        r1 = android.support.v4.view.ViewCompat.m1262w(r6);
        r0 = r0.contains(r1);
        if (r0 == 0) goto L_0x00a9;
    L_0x00a8:
        return r3;
    L_0x00a9:
        r0 = r5.f878f;
        if (r0 == 0) goto L_0x00c8;
    L_0x00ad:
        r0 = r2;
    L_0x00ae:
        r1 = r5.f878f;
        r1 = r1.size();
        if (r0 >= r1) goto L_0x00c8;
    L_0x00b6:
        r1 = r5.f878f;
        r1 = r1.get(r0);
        r1 = (java.lang.Class) r1;
        r1 = r1.isInstance(r6);
        if (r1 == 0) goto L_0x00c5;
    L_0x00c4:
        return r3;
    L_0x00c5:
        r0 = r0 + 1;
        goto L_0x00ae;
    L_0x00c8:
        return r2;
    L_0x00c9:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.Transition.a(android.view.View):boolean");
    }

    private static ArrayMap<Animator, AnimationInfo> m453f() {
        ArrayMap<Animator, AnimationInfo> arrayMap = (ArrayMap) f861A.get();
        if (arrayMap != null) {
            return arrayMap;
        }
        arrayMap = new ArrayMap();
        f861A.set(arrayMap);
        return arrayMap;
    }

    protected void mo167b() {
        m476c();
        final ArrayMap f = m453f();
        Iterator it = this.f870H.iterator();
        while (it.hasNext()) {
            Animator animator = (Animator) it.next();
            if (f.containsKey(animator)) {
                m476c();
                if (animator != null) {
                    animator.addListener(new AnimatorListenerAdapter(this) {
                        final /* synthetic */ Transition f854b;

                        public void onAnimationStart(Animator animator) {
                            this.f854b.f865C.add(animator);
                        }

                        public void onAnimationEnd(Animator animator) {
                            f.remove(animator);
                            this.f854b.f865C.remove(animator);
                        }
                    });
                    if (animator == null) {
                        m478d();
                    } else {
                        if (this.f874b >= 0) {
                            animator.setDuration(this.f874b);
                        }
                        if (this.f873a >= 0) {
                            animator.setStartDelay(this.f873a);
                        }
                        if (this.f884n != null) {
                            animator.setInterpolator(this.f884n);
                        }
                        animator.addListener(new C00713(this));
                        animator.start();
                    }
                }
            }
        }
        this.f870H.clear();
        m478d();
    }

    public Transition mo166b(View view) {
        this.f876d.add(view);
        return this;
    }

    public Transition mo168c(View view) {
        this.f876d.remove(view);
        return this;
    }

    public Transition mo160a(View view, boolean z) {
        ArrayList arrayList = this.f886p;
        if (view != null) {
            if (z) {
                arrayList = ArrayListManager.m442a(arrayList, view);
            } else {
                arrayList = ArrayListManager.m443b(arrayList, view);
            }
        }
        this.f886p = arrayList;
        return this;
    }

    final void m463a(ViewGroup viewGroup, boolean z) {
        m464a(z);
        int i = 0;
        if ((this.f875c.size() > 0 || this.f876d.size() > 0) && (this.f877e == null || this.f877e.isEmpty())) {
            int i2;
            View view;
            if (this.f878f != null) {
                if (this.f878f.isEmpty()) {
                }
            }
            for (i2 = 0; i2 < this.f875c.size(); i2++) {
                View findViewById = viewGroup.findViewById(((Integer) this.f875c.get(i2)).intValue());
                if (findViewById != null) {
                    TransitionValues transitionValues = new TransitionValues();
                    transitionValues.f903b = findViewById;
                    if (z) {
                        mo132a(transitionValues);
                    } else {
                        mo134b(transitionValues);
                    }
                    transitionValues.f904c.add(this);
                    mo169c(transitionValues);
                    if (z) {
                        m450a(this.f892v, findViewById, transitionValues);
                    } else {
                        m450a(this.f893w, findViewById, transitionValues);
                    }
                }
            }
            for (viewGroup = null; viewGroup < this.f876d.size(); viewGroup++) {
                view = (View) this.f876d.get(viewGroup);
                TransitionValues transitionValues2 = new TransitionValues();
                transitionValues2.f903b = view;
                if (z) {
                    mo132a(transitionValues2);
                } else {
                    mo134b(transitionValues2);
                }
                transitionValues2.f904c.add(this);
                mo169c(transitionValues2);
                if (z) {
                    m450a(this.f892v, view, transitionValues2);
                } else {
                    m450a(this.f893w, view, transitionValues2);
                }
            }
            if (!z && this.f872J != null) {
                viewGroup = this.f872J.size();
                z = new ArrayList(viewGroup);
                for (i2 = 0; i2 < viewGroup; i2++) {
                    z.add(this.f892v.f908d.remove((String) this.f872J.m1053b(i2)));
                }
                while (i < viewGroup) {
                    view = (View) z.get(i);
                    if (view != null) {
                        this.f892v.f908d.put((String) this.f872J.m1054c(i), view);
                    }
                    i++;
                }
                return;
            }
        }
        m452d(viewGroup, z);
        if (!z) {
        }
    }

    private static void m450a(TransitionValuesMaps transitionValuesMaps, View view, TransitionValues transitionValues) {
        transitionValuesMaps.f905a.put(view, transitionValues);
        transitionValues = view.getId();
        if (transitionValues >= null) {
            if (transitionValuesMaps.f906b.indexOfKey(transitionValues) >= 0) {
                transitionValuesMaps.f906b.put(transitionValues, null);
            } else {
                transitionValuesMaps.f906b.put(transitionValues, view);
            }
        }
        transitionValues = ViewCompat.m1262w(view);
        if (transitionValues != null) {
            if (transitionValuesMaps.f908d.containsKey(transitionValues)) {
                transitionValuesMaps.f908d.put(transitionValues, null);
            } else {
                transitionValuesMaps.f908d.put(transitionValues, view);
            }
        }
        if ((view.getParent() instanceof ListView) != null) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                transitionValues = transitionValuesMaps.f907c;
                if (transitionValues.f1391b) {
                    transitionValues.m1016a();
                }
                if (ContainerHelpers.m1007a(transitionValues.f1392c, transitionValues.f1394e, itemIdAtPosition) >= null) {
                    view = (View) transitionValuesMaps.f907c.m1015a(itemIdAtPosition);
                    if (view != null) {
                        ViewCompat.m1227a(view, (boolean) null);
                        transitionValuesMaps.f907c.m1017a(itemIdAtPosition, null);
                    }
                    return;
                }
                ViewCompat.m1227a(view, true);
                transitionValuesMaps.f907c.m1017a(itemIdAtPosition, view);
            }
        }
    }

    final void m464a(boolean z) {
        if (z) {
            this.f892v.f905a.clear();
            this.f892v.f906b.clear();
            this.f892v.f907c.m1020c();
            return;
        }
        this.f893w.f905a.clear();
        this.f893w.f906b.clear();
        this.f893w.f907c.m1020c();
    }

    private void m452d(View view, boolean z) {
        if (view != null) {
            int id = view.getId();
            if (this.f885o != null && this.f885o.contains(Integer.valueOf(id))) {
                return;
            }
            if (this.f886p == null || !this.f886p.contains(view)) {
                int size;
                int i = 0;
                if (this.f887q != null) {
                    size = this.f887q.size();
                    int i2 = 0;
                    while (i2 < size) {
                        if (!((Class) this.f887q.get(i2)).isInstance(view)) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    TransitionValues transitionValues = new TransitionValues();
                    transitionValues.f903b = view;
                    if (z) {
                        mo132a(transitionValues);
                    } else {
                        mo134b(transitionValues);
                    }
                    transitionValues.f904c.add(this);
                    mo169c(transitionValues);
                    if (z) {
                        m450a(this.f892v, view, transitionValues);
                    } else {
                        m450a(this.f893w, view, transitionValues);
                    }
                }
                if ((view instanceof ViewGroup) && (this.f889s == null || !this.f889s.contains(Integer.valueOf(id)))) {
                    if (this.f890t == null || !this.f890t.contains(view)) {
                        if (this.f891u != null) {
                            id = this.f891u.size();
                            size = 0;
                            while (size < id) {
                                if (!((Class) this.f891u.get(size)).isInstance(view)) {
                                    size++;
                                } else {
                                    return;
                                }
                            }
                        }
                        ViewGroup viewGroup = (ViewGroup) view;
                        while (i < viewGroup.getChildCount()) {
                            m452d(viewGroup.getChildAt(i), z);
                            i++;
                        }
                    }
                }
            }
        }
    }

    public final TransitionValues m471b(View view, boolean z) {
        Transition transition = this;
        while (transition.f879g != null) {
            transition = transition.f879g;
        }
        return (TransitionValues) (z ? transition.f892v : transition.f893w).f905a.get(view);
    }

    final TransitionValues m475c(View view, boolean z) {
        Transition transition = this;
        while (transition.f879g != null) {
            transition = transition.f879g;
        }
        ArrayList arrayList = z ? transition.f895y : transition.f896z;
        TransitionValues transitionValues = null;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            TransitionValues transitionValues2 = (TransitionValues) arrayList.get(i2);
            if (transitionValues2 == null) {
                return null;
            }
            if (transitionValues2.f903b == view) {
                i = i2;
                break;
            }
        }
        if (i >= 0) {
            transitionValues = (TransitionValues) (z ? transition.f896z : transition.f895y).get(i);
        }
        return transitionValues;
    }

    public void mo171d(View view) {
        if (!this.f868F) {
            ArrayMap f = m453f();
            int size = f.size();
            view = ViewUtils.m503b(view);
            for (size--; size >= 0; size--) {
                AnimationInfo animationInfo = (AnimationInfo) f.m1054c(size);
                if (animationInfo.f856a != null && view.equals(animationInfo.f859d)) {
                    AnimatorUtils.m428a((Animator) f.m1053b(size));
                }
            }
            if (this.f869G != null && this.f869G.size() > null) {
                ArrayList arrayList = (ArrayList) this.f869G.clone();
                int size2 = arrayList.size();
                for (size = 0; size < size2; size++) {
                    ((TransitionListener) arrayList.get(size)).mo135a();
                }
            }
            this.f867E = true;
        }
    }

    public void mo173e(View view) {
        if (this.f867E) {
            if (!this.f868F) {
                ArrayMap f = m453f();
                int size = f.size();
                view = ViewUtils.m503b(view);
                for (size--; size >= 0; size--) {
                    AnimationInfo animationInfo = (AnimationInfo) f.m1054c(size);
                    if (animationInfo.f856a != null && view.equals(animationInfo.f859d)) {
                        AnimatorUtils.m430b((Animator) f.m1053b(size));
                    }
                }
                if (this.f869G != null && this.f869G.size() > null) {
                    ArrayList arrayList = (ArrayList) this.f869G.clone();
                    int size2 = arrayList.size();
                    for (size = 0; size < size2; size++) {
                        ((TransitionListener) arrayList.get(size)).mo137b();
                    }
                }
            }
            this.f867E = false;
        }
    }

    final void m461a(ViewGroup viewGroup) {
        this.f895y = new ArrayList();
        this.f896z = new ArrayList();
        m449a(this.f892v, this.f893w);
        ArrayMap f = m453f();
        int size = f.size();
        WindowIdImpl b = ViewUtils.m503b(viewGroup);
        for (size--; size >= 0; size--) {
            Animator animator = (Animator) f.m1053b(size);
            if (animator != null) {
                AnimationInfo animationInfo = (AnimationInfo) f.get(animator);
                if (!(animationInfo == null || animationInfo.f856a == null || !b.equals(animationInfo.f859d))) {
                    TransitionValues transitionValues = animationInfo.f858c;
                    View view = animationInfo.f856a;
                    TransitionValues b2 = m471b(view, true);
                    TransitionValues c = m475c(view, true);
                    boolean z = !(b2 == null && c == null) && animationInfo.f860e.mo189a(transitionValues, c);
                    if (z) {
                        if (!animator.isRunning()) {
                            if (!animator.isStarted()) {
                                f.remove(animator);
                            }
                        }
                        animator.cancel();
                    }
                }
            }
        }
        mo163a(viewGroup, this.f892v, this.f893w, this.f895y, this.f896z);
        mo167b();
    }

    public boolean mo189a(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (!(transitionValues == null || transitionValues2 == null)) {
            String[] a = mo133a();
            if (a != null) {
                for (String a2 : a) {
                    if (m451a(transitionValues, transitionValues2, a2)) {
                        return true;
                    }
                }
            } else {
                for (String a3 : transitionValues.f902a.keySet()) {
                    if (m451a(transitionValues, transitionValues2, a3)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean m451a(TransitionValues transitionValues, TransitionValues transitionValues2, String str) {
        transitionValues = transitionValues.f902a.get(str);
        transitionValues2 = transitionValues2.f902a.get(str);
        if (!(transitionValues == null && transitionValues2 == null)) {
            if (transitionValues != null) {
                if (transitionValues2 != null) {
                    if (transitionValues.equals(transitionValues2) == null) {
                        return true;
                    }
                }
            }
            return true;
        }
        return null;
    }

    protected final void m476c() {
        if (this.f866D == 0) {
            if (this.f869G != null && this.f869G.size() > 0) {
                ArrayList arrayList = (ArrayList) this.f869G.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((TransitionListener) arrayList.get(i)).mo138c();
                }
            }
            this.f868F = false;
        }
        this.f866D++;
    }

    protected final void m478d() {
        this.f866D--;
        if (this.f866D == 0) {
            int i;
            View view;
            if (this.f869G != null && this.f869G.size() > 0) {
                ArrayList arrayList = (ArrayList) this.f869G.clone();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((TransitionListener) arrayList.get(i2)).mo136a(this);
                }
            }
            for (i = 0; i < this.f892v.f907c.m1018b(); i++) {
                view = (View) this.f892v.f907c.m1019b(i);
                if (view != null) {
                    ViewCompat.m1227a(view, false);
                }
            }
            for (i = 0; i < this.f893w.f907c.m1018b(); i++) {
                view = (View) this.f893w.f907c.m1019b(i);
                if (view != null) {
                    ViewCompat.m1227a(view, false);
                }
            }
            this.f868F = true;
        }
    }

    public Transition mo159a(TransitionListener transitionListener) {
        if (this.f869G == null) {
            this.f869G = new ArrayList();
        }
        this.f869G.add(transitionListener);
        return this;
    }

    public Transition mo165b(TransitionListener transitionListener) {
        if (this.f869G == null) {
            return this;
        }
        this.f869G.remove(transitionListener);
        if (this.f869G.size() == null) {
            this.f869G = null;
        }
        return this;
    }

    public void mo162a(EpicenterCallback epicenterCallback) {
        this.f871I = epicenterCallback;
    }

    void mo169c(TransitionValues transitionValues) {
        if (!(this.f881i == null || transitionValues.f902a.isEmpty())) {
            String[] b = this.f881i.m487b();
            if (b != null) {
                int i = 0;
                while (i < b.length && transitionValues.f902a.containsKey(b[i])) {
                    i++;
                }
            }
        }
    }

    public String toString() {
        return mo161a("");
    }

    public android.support.transition.Transition mo172e() {
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
        r0 = 0;
        r1 = super.clone();	 Catch:{ CloneNotSupportedException -> 0x0021 }
        r1 = (android.support.transition.Transition) r1;	 Catch:{ CloneNotSupportedException -> 0x0021 }
        r2 = new java.util.ArrayList;	 Catch:{ CloneNotSupportedException -> 0x0021 }
        r2.<init>();	 Catch:{ CloneNotSupportedException -> 0x0021 }
        r1.f870H = r2;	 Catch:{ CloneNotSupportedException -> 0x0021 }
        r2 = new android.support.transition.TransitionValuesMaps;	 Catch:{ CloneNotSupportedException -> 0x0021 }
        r2.<init>();	 Catch:{ CloneNotSupportedException -> 0x0021 }
        r1.f892v = r2;	 Catch:{ CloneNotSupportedException -> 0x0021 }
        r2 = new android.support.transition.TransitionValuesMaps;	 Catch:{ CloneNotSupportedException -> 0x0021 }
        r2.<init>();	 Catch:{ CloneNotSupportedException -> 0x0021 }
        r1.f893w = r2;	 Catch:{ CloneNotSupportedException -> 0x0021 }
        r1.f895y = r0;	 Catch:{ CloneNotSupportedException -> 0x0021 }
        r1.f896z = r0;	 Catch:{ CloneNotSupportedException -> 0x0021 }
        return r1;
    L_0x0021:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.Transition.e():android.support.transition.Transition");
    }

    String mo161a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        stringBuilder.append(": ");
        str = stringBuilder.toString();
        if (this.f874b != -1) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("dur(");
            stringBuilder.append(this.f874b);
            stringBuilder.append(") ");
            str = stringBuilder.toString();
        }
        if (this.f873a != -1) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("dly(");
            stringBuilder.append(this.f873a);
            stringBuilder.append(") ");
            str = stringBuilder.toString();
        }
        if (this.f884n != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("interp(");
            stringBuilder.append(this.f884n);
            stringBuilder.append(") ");
            str = stringBuilder.toString();
        }
        if (this.f875c.size() <= 0 && this.f876d.size() <= 0) {
            return str;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("tgts(");
        str = stringBuilder.toString();
        int i = 0;
        if (this.f875c.size() > 0) {
            String str2 = str;
            for (str = null; str < this.f875c.size(); str++) {
                StringBuilder stringBuilder2;
                if (str > null) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str2);
                    stringBuilder2.append(", ");
                    str2 = stringBuilder2.toString();
                }
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str2);
                stringBuilder2.append(this.f875c.get(str));
                str2 = stringBuilder2.toString();
            }
            str = str2;
        }
        if (this.f876d.size() > 0) {
            while (i < this.f876d.size()) {
                if (i > 0) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(", ");
                    str = stringBuilder.toString();
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(this.f876d.get(i));
                str = stringBuilder.toString();
                i++;
            }
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
