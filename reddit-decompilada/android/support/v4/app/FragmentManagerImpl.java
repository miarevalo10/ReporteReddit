package android.support.v4.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v4.util.ArraySet;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.LogWriter;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: FragmentManager */
final class FragmentManagerImpl extends FragmentManager implements Factory2 {
    static final Interpolator f11296E = new DecelerateInterpolator(2.5f);
    static final Interpolator f11297F = new DecelerateInterpolator(1.5f);
    static final Interpolator f11298G = new AccelerateInterpolator(2.5f);
    static final Interpolator f11299H = new AccelerateInterpolator(1.5f);
    static boolean f11300a = false;
    static Field f11301q;
    SparseArray<Parcelable> f11302A = null;
    ArrayList<StartEnterTransitionListener> f11303B;
    FragmentManagerNonConfig f11304C;
    Runnable f11305D = new C00831(this);
    private final CopyOnWriteArrayList<Pair<Object, Boolean>> f11306I = new CopyOnWriteArrayList();
    ArrayList<OpGenerator> f11307b;
    boolean f11308c;
    int f11309d = 0;
    final ArrayList<Fragment> f11310e = new ArrayList();
    SparseArray<Fragment> f11311f;
    ArrayList<BackStackRecord> f11312g;
    ArrayList<Fragment> f11313h;
    ArrayList<BackStackRecord> f11314i;
    ArrayList<Integer> f11315j;
    ArrayList<OnBackStackChangedListener> f11316k;
    int f11317l = 0;
    FragmentHostCallback f11318m;
    FragmentContainer f11319n;
    Fragment f11320o;
    Fragment f11321p;
    boolean f11322r;
    boolean f11323s;
    boolean f11324t;
    String f11325u;
    boolean f11326v;
    ArrayList<BackStackRecord> f11327w;
    ArrayList<Boolean> f11328x;
    ArrayList<Fragment> f11329y;
    Bundle f11330z = null;

    /* compiled from: FragmentManager */
    class C00831 implements Runnable {
        final /* synthetic */ FragmentManagerImpl f981a;

        C00831(FragmentManagerImpl fragmentManagerImpl) {
            this.f981a = fragmentManagerImpl;
        }

        public void run() {
            this.f981a.m9912i();
        }
    }

    /* compiled from: FragmentManager */
    private static class AnimationListenerWrapper implements AnimationListener {
        private final AnimationListener f992a;

        private AnimationListenerWrapper(AnimationListener animationListener) {
            this.f992a = animationListener;
        }

        public void onAnimationStart(Animation animation) {
            if (this.f992a != null) {
                this.f992a.onAnimationStart(animation);
            }
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f992a != null) {
                this.f992a.onAnimationEnd(animation);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            if (this.f992a != null) {
                this.f992a.onAnimationRepeat(animation);
            }
        }
    }

    /* compiled from: FragmentManager */
    private static class AnimationOrAnimator {
        public final Animation f993a;
        public final Animator f994b;

        private AnimationOrAnimator(Animation animation) {
            this.f993a = animation;
            this.f994b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        private AnimationOrAnimator(Animator animator) {
            this.f993a = null;
            this.f994b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* compiled from: FragmentManager */
    private static class AnimatorOnHWLayerIfNeededListener extends AnimatorListenerAdapter {
        View f995a;

        AnimatorOnHWLayerIfNeededListener(View view) {
            this.f995a = view;
        }

        public void onAnimationStart(Animator animator) {
            this.f995a.setLayerType(2, null);
        }

        public void onAnimationEnd(Animator animator) {
            this.f995a.setLayerType(0, null);
            animator.removeListener(this);
        }
    }

    /* compiled from: FragmentManager */
    static class FragmentTag {
        public static final int[] f996a = new int[]{16842755, 16842960, 16842961};
    }

    /* compiled from: FragmentManager */
    interface OpGenerator {
        boolean mo199a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* compiled from: FragmentManager */
    private static class AnimateOnHWLayerIfNeededListener extends AnimationListenerWrapper {
        View f11288a;

        /* compiled from: FragmentManager */
        class C00871 implements Runnable {
            final /* synthetic */ AnimateOnHWLayerIfNeededListener f991a;

            C00871(AnimateOnHWLayerIfNeededListener animateOnHWLayerIfNeededListener) {
                this.f991a = animateOnHWLayerIfNeededListener;
            }

            public void run() {
                this.f991a.f11288a.setLayerType(0, null);
            }
        }

        AnimateOnHWLayerIfNeededListener(View view, AnimationListener animationListener) {
            super(animationListener);
            this.f11288a = view;
        }

        public void onAnimationEnd(Animation animation) {
            if (!ViewCompat.m1209J(this.f11288a)) {
                if (VERSION.SDK_INT < 24) {
                    this.f11288a.setLayerType(0, null);
                    super.onAnimationEnd(animation);
                }
            }
            this.f11288a.post(new C00871(this));
            super.onAnimationEnd(animation);
        }
    }

    /* compiled from: FragmentManager */
    private class PopBackStackState implements OpGenerator {
        final String f11289a;
        final int f11290b;
        final int f11291c;
        final /* synthetic */ FragmentManagerImpl f11292d;

        PopBackStackState(FragmentManagerImpl fragmentManagerImpl, String str, int i, int i2) {
            this.f11292d = fragmentManagerImpl;
            this.f11289a = str;
            this.f11290b = i;
            this.f11291c = i2;
        }

        public final boolean mo199a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
            if (this.f11292d.f11321p != null && this.f11290b < 0 && this.f11289a == null) {
                FragmentManager peekChildFragmentManager = this.f11292d.f11321p.peekChildFragmentManager();
                if (peekChildFragmentManager != null && peekChildFragmentManager.mo227d()) {
                    return null;
                }
            }
            return this.f11292d.m9890a((ArrayList) arrayList, (ArrayList) arrayList2, this.f11289a, this.f11290b, this.f11291c);
        }
    }

    /* compiled from: FragmentManager */
    static class StartEnterTransitionListener implements OnStartEnterTransitionListener {
        int f11293a;
        private final boolean f11294b;
        private final BackStackRecord f11295c;

        StartEnterTransitionListener(BackStackRecord backStackRecord, boolean z) {
            this.f11294b = z;
            this.f11295c = backStackRecord;
        }

        public final void mo213a() {
            this.f11293a--;
            if (this.f11293a == 0) {
                this.f11295c.f11252a.m9864u();
            }
        }

        public final void mo214b() {
            this.f11293a++;
        }

        public final void m9819c() {
            int i = 0;
            int i2 = this.f11293a > 0 ? 1 : 0;
            FragmentManagerImpl fragmentManagerImpl = this.f11295c.f11252a;
            int size = fragmentManagerImpl.f11310e.size();
            while (i < size) {
                Fragment fragment = (Fragment) fragmentManagerImpl.f11310e.get(i);
                fragment.setOnStartEnterTransitionListener(null);
                if (i2 != 0 && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
                i++;
            }
            FragmentManagerImpl.m9832a(this.f11295c.f11252a, this.f11295c, this.f11294b, i2 ^ true, true);
        }

        public final void m9820d() {
            FragmentManagerImpl.m9832a(this.f11295c.f11252a, this.f11295c, this.f11294b, false, false);
        }
    }

    public static int m9850d(int i) {
        return i != 4097 ? i != 4099 ? i != 8194 ? 0 : 4097 : 4099 : 8194;
    }

    public final boolean m9912i() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
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
        r4 = this;
        r0 = 1;
        r4.m9848c(r0);
        r1 = 0;
    L_0x0005:
        r2 = r4.f11327w;
        r3 = r4.f11328x;
        r2 = r4.m9849c(r2, r3);
        if (r2 == 0) goto L_0x0022;
    L_0x000f:
        r4.f11308c = r0;
        r1 = r4.f11327w;	 Catch:{ all -> 0x001d }
        r2 = r4.f11328x;	 Catch:{ all -> 0x001d }
        r4.m9844b(r1, r2);	 Catch:{ all -> 0x001d }
        r4.m9865v();
        r1 = r0;
        goto L_0x0005;
    L_0x001d:
        r0 = move-exception;
        r4.m9865v();
        throw r0;
    L_0x0022:
        r4.m9867x();
        r4.m9821A();
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentManagerImpl.i():boolean");
    }

    FragmentManagerImpl() {
    }

    private static boolean m9839a(Animator animator) {
        if (animator == null) {
            return false;
        }
        int i;
        if (animator instanceof ValueAnimator) {
            animator = ((ValueAnimator) animator).getValues();
            for (PropertyValuesHolder propertyName : animator) {
                if ("alpha".equals(propertyName.getPropertyName())) {
                    return true;
                }
            }
        } else if (animator instanceof AnimatorSet) {
            animator = ((AnimatorSet) animator).getChildAnimations();
            for (i = 0; i < animator.size(); i++) {
                if (m9839a((Animator) animator.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    private void m9836a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
        if (this.f11318m != null) {
            try {
                this.f11318m.mo3124a("  ", printWriter, new String[0]);
            } catch (Throwable e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                mo222a("  ", null, printWriter, new String[0]);
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    public final FragmentTransaction mo219a() {
        return new BackStackRecord(this);
    }

    public final boolean mo225b() {
        boolean i = m9912i();
        m9866w();
        return i;
    }

    public final void mo226c() {
        m9884a(new PopBackStackState(this, null, -1, 0), false);
    }

    public final boolean mo227d() {
        m9863t();
        return m9862s();
    }

    public final void mo224b(String str) {
        m9884a(new PopBackStackState(this, str, -1, 1), (boolean) null);
    }

    public final void mo223b(int i) {
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder("Bad id: ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        m9884a(new PopBackStackState(this, null, i, 1), (boolean) 0);
    }

    private boolean m9862s() {
        m9912i();
        m9848c(true);
        if (this.f11321p != null) {
            FragmentManager peekChildFragmentManager = this.f11321p.peekChildFragmentManager();
            if (peekChildFragmentManager != null && peekChildFragmentManager.mo227d()) {
                return true;
            }
        }
        boolean a = m9890a(this.f11327w, this.f11328x, null, -1, 0);
        if (a) {
            this.f11308c = true;
            try {
                m9844b(this.f11327w, this.f11328x);
            } finally {
                m9865v();
            }
        }
        m9867x();
        m9821A();
        return a;
    }

    public final int mo228e() {
        return this.f11312g != null ? this.f11312g.size() : 0;
    }

    public final void mo221a(OnBackStackChangedListener onBackStackChangedListener) {
        if (this.f11316k == null) {
            this.f11316k = new ArrayList();
        }
        this.f11316k.add(onBackStackChangedListener);
    }

    public final void mo220a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mIndex < 0) {
            StringBuilder stringBuilder = new StringBuilder("Fragment ");
            stringBuilder.append(fragment);
            stringBuilder.append(" is not currently in the FragmentManager");
            m9836a(new IllegalStateException(stringBuilder.toString()));
        }
        bundle.putInt(str, fragment.mIndex);
    }

    public final Fragment mo217a(Bundle bundle, String str) {
        bundle = bundle.getInt(str, -1);
        if (bundle == -1) {
            return null;
        }
        Fragment fragment = (Fragment) this.f11311f.get(bundle);
        if (fragment == null) {
            StringBuilder stringBuilder = new StringBuilder("Fragment no longer exists for key ");
            stringBuilder.append(str);
            stringBuilder.append(": index ");
            stringBuilder.append(bundle);
            m9836a(new IllegalStateException(stringBuilder.toString()));
        }
        return fragment;
    }

    public final List<Fragment> mo229f() {
        if (this.f11310e.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<Fragment> list;
        synchronized (this.f11310e) {
            list = (List) this.f11310e.clone();
        }
        return list;
    }

    public final SavedState mo215a(Fragment fragment) {
        if (fragment.mIndex < 0) {
            StringBuilder stringBuilder = new StringBuilder("Fragment ");
            stringBuilder.append(fragment);
            stringBuilder.append(" is not currently in the FragmentManager");
            m9836a(new IllegalStateException(stringBuilder.toString()));
        }
        if (fragment.mState <= 0) {
            return null;
        }
        fragment = m9861m(fragment);
        if (fragment != null) {
            return new SavedState(fragment);
        }
        return null;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.f11320o != null) {
            DebugUtils.m1011a(this.f11320o, stringBuilder);
        } else {
            DebugUtils.m1011a(this.f11318m, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public final void mo222a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("    ");
        String stringBuilder2 = stringBuilder.toString();
        int i = 0;
        if (this.f11311f != null) {
            int size = this.f11311f.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (int i2 = 0; i2 < size; i2++) {
                    Fragment fragment = (Fragment) this.f11311f.valueAt(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(fragment);
                    if (fragment != null) {
                        fragment.dump(stringBuilder2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        fileDescriptor = this.f11310e.size();
        if (fileDescriptor > null) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (strArr = null; strArr < fileDescriptor; strArr++) {
                Fragment fragment2 = (Fragment) this.f11310e.get(strArr);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(strArr);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        if (this.f11313h != null) {
            fileDescriptor = this.f11313h.size();
            if (fileDescriptor > null) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (strArr = null; strArr < fileDescriptor; strArr++) {
                    fragment2 = (Fragment) this.f11313h.get(strArr);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(strArr);
                    printWriter.print(": ");
                    printWriter.println(fragment2.toString());
                }
            }
        }
        if (this.f11312g != null) {
            fileDescriptor = this.f11312g.size();
            if (fileDescriptor > null) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (strArr = null; strArr < fileDescriptor; strArr++) {
                    BackStackRecord backStackRecord = (BackStackRecord) this.f11312g.get(strArr);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(strArr);
                    printWriter.print(": ");
                    printWriter.println(backStackRecord.toString());
                    backStackRecord.m9778a(stringBuilder2, printWriter);
                }
            }
        }
        synchronized (this) {
            if (this.f11314i != null) {
                fileDescriptor = this.f11314i.size();
                if (fileDescriptor > null) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (strArr = null; strArr < fileDescriptor; strArr++) {
                        BackStackRecord backStackRecord2 = (BackStackRecord) this.f11314i.get(strArr);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(strArr);
                        printWriter.print(": ");
                        printWriter.println(backStackRecord2);
                    }
                }
            }
            if (this.f11315j != null && this.f11315j.size() > null) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f11315j.toArray()));
            }
        }
        if (this.f11307b != null) {
            fileDescriptor = this.f11307b.size();
            if (fileDescriptor > null) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i < fileDescriptor) {
                    OpGenerator opGenerator = (OpGenerator) this.f11307b.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(opGenerator);
                    i++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f11318m);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f11319n);
        if (this.f11320o != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f11320o);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f11317l);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f11323s);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f11324t);
        if (this.f11322r != null) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f11322r);
        }
        if (this.f11325u != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.f11325u);
        }
    }

    private static AnimationOrAnimator m9824a(float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f11296E);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(f3, f4);
        scaleAnimation.setInterpolator(f11297F);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        return new AnimationOrAnimator(animationSet);
    }

    private static AnimationOrAnimator m9823a(float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(f11297F);
        alphaAnimation.setDuration(3.08E-43f);
        return new AnimationOrAnimator(alphaAnimation);
    }

    private android.support.v4.app.FragmentManagerImpl.AnimationOrAnimator m9825a(android.support.v4.app.Fragment r6, int r7, boolean r8, int r9) {
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
        r5 = this;
        r0 = r6.getNextAnim();
        r1 = r6.onCreateAnimation(r7, r8, r0);
        r2 = 0;
        if (r1 == 0) goto L_0x0011;
    L_0x000b:
        r6 = new android.support.v4.app.FragmentManagerImpl$AnimationOrAnimator;
        r6.<init>(r1);
        return r6;
    L_0x0011:
        r6 = r6.onCreateAnimator(r7, r8, r0);
        if (r6 == 0) goto L_0x001d;
    L_0x0017:
        r7 = new android.support.v4.app.FragmentManagerImpl$AnimationOrAnimator;
        r7.<init>(r6);
        return r7;
    L_0x001d:
        r6 = 1;
        if (r0 == 0) goto L_0x006f;
    L_0x0020:
        r1 = r5.f11318m;
        r1 = r1.f11275c;
        r1 = r1.getResources();
        r1 = r1.getResourceTypeName(r0);
        r3 = "anim";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x0048;
    L_0x0034:
        r3 = r5.f11318m;	 Catch:{ NotFoundException -> 0x0046, RuntimeException -> 0x0048 }
        r3 = r3.f11275c;	 Catch:{ NotFoundException -> 0x0046, RuntimeException -> 0x0048 }
        r3 = android.view.animation.AnimationUtils.loadAnimation(r3, r0);	 Catch:{ NotFoundException -> 0x0046, RuntimeException -> 0x0048 }
        if (r3 == 0) goto L_0x0044;	 Catch:{ NotFoundException -> 0x0046, RuntimeException -> 0x0048 }
    L_0x003e:
        r4 = new android.support.v4.app.FragmentManagerImpl$AnimationOrAnimator;	 Catch:{ NotFoundException -> 0x0046, RuntimeException -> 0x0048 }
        r4.<init>(r3);	 Catch:{ NotFoundException -> 0x0046, RuntimeException -> 0x0048 }
        return r4;
    L_0x0044:
        r3 = r6;
        goto L_0x0049;
    L_0x0046:
        r6 = move-exception;
        throw r6;
    L_0x0048:
        r3 = r2;
    L_0x0049:
        if (r3 != 0) goto L_0x006f;
    L_0x004b:
        r3 = r5.f11318m;	 Catch:{ RuntimeException -> 0x005b }
        r3 = r3.f11275c;	 Catch:{ RuntimeException -> 0x005b }
        r3 = android.animation.AnimatorInflater.loadAnimator(r3, r0);	 Catch:{ RuntimeException -> 0x005b }
        if (r3 == 0) goto L_0x006f;	 Catch:{ RuntimeException -> 0x005b }
    L_0x0055:
        r4 = new android.support.v4.app.FragmentManagerImpl$AnimationOrAnimator;	 Catch:{ RuntimeException -> 0x005b }
        r4.<init>(r3);	 Catch:{ RuntimeException -> 0x005b }
        return r4;
    L_0x005b:
        r3 = move-exception;
        if (r1 == 0) goto L_0x005f;
    L_0x005e:
        throw r3;
    L_0x005f:
        r1 = r5.f11318m;
        r1 = r1.f11275c;
        r0 = android.view.animation.AnimationUtils.loadAnimation(r1, r0);
        if (r0 == 0) goto L_0x006f;
    L_0x0069:
        r6 = new android.support.v4.app.FragmentManagerImpl$AnimationOrAnimator;
        r6.<init>(r0);
        return r6;
    L_0x006f:
        r0 = 0;
        if (r7 != 0) goto L_0x0073;
    L_0x0072:
        return r0;
    L_0x0073:
        r1 = -1;
        r2 = 4097; // 0x1001 float:5.741E-42 double:2.024E-320;
        if (r7 == r2) goto L_0x008e;
    L_0x0078:
        r6 = 4099; // 0x1003 float:5.744E-42 double:2.025E-320;
        if (r7 == r6) goto L_0x0088;
    L_0x007c:
        r6 = 8194; // 0x2002 float:1.1482E-41 double:4.0484E-320;
        if (r7 == r6) goto L_0x0081;
    L_0x0080:
        goto L_0x0093;
    L_0x0081:
        if (r8 == 0) goto L_0x0086;
    L_0x0083:
        r6 = 3;
    L_0x0084:
        r1 = r6;
        goto L_0x0093;
    L_0x0086:
        r6 = 4;
        goto L_0x0084;
    L_0x0088:
        if (r8 == 0) goto L_0x008c;
    L_0x008a:
        r6 = 5;
        goto L_0x0084;
    L_0x008c:
        r6 = 6;
        goto L_0x0084;
    L_0x008e:
        if (r8 == 0) goto L_0x0091;
    L_0x0090:
        goto L_0x0084;
    L_0x0091:
        r6 = 2;
        goto L_0x0084;
    L_0x0093:
        if (r1 >= 0) goto L_0x0096;
    L_0x0095:
        return r0;
    L_0x0096:
        r6 = 1064933786; // 0x3f79999a float:0.975 double:5.26147199E-315;
        r7 = 0;
        r8 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        switch(r1) {
            case 1: goto L_0x00cc;
            case 2: goto L_0x00c7;
            case 3: goto L_0x00c2;
            case 4: goto L_0x00ba;
            case 5: goto L_0x00b5;
            case 6: goto L_0x00b0;
            default: goto L_0x009f;
        };
    L_0x009f:
        if (r9 != 0) goto L_0x00d3;
    L_0x00a1:
        r6 = r5.f11318m;
        r6 = r6.mo3129e();
        if (r6 == 0) goto L_0x00d3;
    L_0x00a9:
        r6 = r5.f11318m;
        r9 = r6.mo3130f();
        goto L_0x00d3;
    L_0x00b0:
        r6 = m9823a(r8, r7);
        return r6;
    L_0x00b5:
        r6 = m9823a(r7, r8);
        return r6;
    L_0x00ba:
        r6 = 1065982362; // 0x3f89999a float:1.075 double:5.26665264E-315;
        r6 = m9824a(r8, r6, r8, r7);
        return r6;
    L_0x00c2:
        r6 = m9824a(r6, r8, r7, r8);
        return r6;
    L_0x00c7:
        r6 = m9824a(r8, r6, r8, r7);
        return r6;
    L_0x00cc:
        r6 = 1066401792; // 0x3f900000 float:1.125 double:5.2687249E-315;
        r6 = m9824a(r6, r8, r7, r8);
        return r6;
    L_0x00d3:
        if (r9 != 0) goto L_0x00d6;
    L_0x00d5:
        return r0;
    L_0x00d6:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentManagerImpl.a(android.support.v4.app.Fragment, int, boolean, int):android.support.v4.app.FragmentManagerImpl$AnimationOrAnimator");
    }

    public final void m9892b(Fragment fragment) {
        if (fragment.mDeferStart) {
            if (this.f11308c) {
                this.f11326v = true;
                return;
            }
            fragment.mDeferStart = false;
            m9880a(fragment, this.f11317l, 0, 0, false);
        }
    }

    private static AnimationListener m9826a(Animation animation) {
        try {
            if (f11301q == null) {
                Field declaredField = Animation.class.getDeclaredField("mListener");
                f11301q = declaredField;
                declaredField.setAccessible(true);
            }
            return (AnimationListener) f11301q.get(animation);
        } catch (Animation animation2) {
            Log.e("FragmentManager", "No field with the name mListener is found in Animation class", animation2);
            return null;
        } catch (Animation animation22) {
            Log.e("FragmentManager", "Cannot access Animation's mListener field", animation22);
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void m9880a(android.support.v4.app.Fragment r17, int r18, int r19, int r20, boolean r21) {
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
        r16 = this;
        r6 = r16;
        r7 = r17;
        r0 = r7.mAdded;
        r8 = 1;
        if (r0 == 0) goto L_0x0011;
    L_0x0009:
        r0 = r7.mDetached;
        if (r0 == 0) goto L_0x000e;
    L_0x000d:
        goto L_0x0011;
    L_0x000e:
        r0 = r18;
        goto L_0x0016;
    L_0x0011:
        r0 = r18;
        if (r0 <= r8) goto L_0x0016;
    L_0x0015:
        r0 = r8;
    L_0x0016:
        r1 = r7.mRemoving;
        if (r1 == 0) goto L_0x002c;
    L_0x001a:
        r1 = r7.mState;
        if (r0 <= r1) goto L_0x002c;
    L_0x001e:
        r0 = r7.mState;
        if (r0 != 0) goto L_0x002a;
    L_0x0022:
        r0 = r17.isInBackStack();
        if (r0 == 0) goto L_0x002a;
    L_0x0028:
        r0 = r8;
        goto L_0x002c;
    L_0x002a:
        r0 = r7.mState;
    L_0x002c:
        r1 = r7.mDeferStart;
        r9 = 4;
        r10 = 3;
        if (r1 == 0) goto L_0x003a;
    L_0x0032:
        r1 = r7.mState;
        if (r1 >= r9) goto L_0x003a;
    L_0x0036:
        if (r0 <= r10) goto L_0x003a;
    L_0x0038:
        r11 = r10;
        goto L_0x003b;
    L_0x003a:
        r11 = r0;
    L_0x003b:
        r0 = r7.mState;
        r12 = 2;
        r13 = 0;
        r14 = 0;
        if (r0 > r11) goto L_0x0301;
    L_0x0042:
        r0 = r7.mFromLayout;
        if (r0 == 0) goto L_0x004b;
    L_0x0046:
        r0 = r7.mInLayout;
        if (r0 != 0) goto L_0x004b;
    L_0x004a:
        return;
    L_0x004b:
        r0 = r17.getAnimatingAway();
        if (r0 != 0) goto L_0x0057;
    L_0x0051:
        r0 = r17.getAnimator();
        if (r0 == 0) goto L_0x0069;
    L_0x0057:
        r7.setAnimatingAway(r13);
        r7.setAnimator(r13);
        r2 = r17.getStateAfterAnimating();
        r3 = 0;
        r4 = 0;
        r5 = 1;
        r0 = r6;
        r1 = r7;
        r0.m9880a(r1, r2, r3, r4, r5);
    L_0x0069:
        r0 = r7.mState;
        switch(r0) {
            case 0: goto L_0x0070;
            case 1: goto L_0x018b;
            case 2: goto L_0x02b9;
            case 3: goto L_0x02bd;
            case 4: goto L_0x02dc;
            default: goto L_0x006e;
        };
    L_0x006e:
        goto L_0x04c8;
    L_0x0070:
        if (r11 <= 0) goto L_0x018b;
    L_0x0072:
        r0 = f11300a;
        if (r0 == 0) goto L_0x0089;
    L_0x0076:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r2 = "moveto CREATED: ";
        r1.<init>(r2);
        r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0089:
        r0 = r7.mSavedFragmentState;
        if (r0 == 0) goto L_0x00cf;
    L_0x008d:
        r0 = r7.mSavedFragmentState;
        r1 = r6.f11318m;
        r1 = r1.f11275c;
        r1 = r1.getClassLoader();
        r0.setClassLoader(r1);
        r0 = r7.mSavedFragmentState;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r7.mSavedViewState = r0;
        r0 = r7.mSavedFragmentState;
        r1 = "android:target_state";
        r0 = r6.mo217a(r0, r1);
        r7.mTarget = r0;
        r0 = r7.mTarget;
        if (r0 == 0) goto L_0x00bc;
    L_0x00b2:
        r0 = r7.mSavedFragmentState;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r14);
        r7.mTargetRequestCode = r0;
    L_0x00bc:
        r0 = r7.mSavedFragmentState;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r8);
        r7.mUserVisibleHint = r0;
        r0 = r7.mUserVisibleHint;
        if (r0 != 0) goto L_0x00cf;
    L_0x00ca:
        r7.mDeferStart = r8;
        if (r11 <= r10) goto L_0x00cf;
    L_0x00ce:
        r11 = r10;
    L_0x00cf:
        r0 = r6.f11318m;
        r7.mHost = r0;
        r0 = r6.f11320o;
        r7.mParentFragment = r0;
        r0 = r6.f11320o;
        if (r0 == 0) goto L_0x00e0;
    L_0x00db:
        r0 = r6.f11320o;
        r0 = r0.mChildFragmentManager;
        goto L_0x00e4;
    L_0x00e0:
        r0 = r6.f11318m;
        r0 = r0.f11278f;
    L_0x00e4:
        r7.mFragmentManager = r0;
        r0 = r7.mTarget;
        if (r0 == 0) goto L_0x012b;
    L_0x00ea:
        r0 = r6.f11311f;
        r1 = r7.mTarget;
        r1 = r1.mIndex;
        r0 = r0.get(r1);
        r1 = r7.mTarget;
        if (r0 == r1) goto L_0x011b;
    L_0x00f8:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1.append(r7);
        r2 = " declared target fragment ";
        r1.append(r2);
        r2 = r7.mTarget;
        r1.append(r2);
        r2 = " that does not belong to this FragmentManager!";
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x011b:
        r0 = r7.mTarget;
        r0 = r0.mState;
        if (r0 > 0) goto L_0x012b;
    L_0x0121:
        r1 = r7.mTarget;
        r2 = 1;
        r3 = 0;
        r4 = 0;
        r5 = 1;
        r0 = r6;
        r0.m9880a(r1, r2, r3, r4, r5);
    L_0x012b:
        r0 = r6.f11318m;
        r0 = r0.f11275c;
        r6.m9828a(r7, r0, r14);
        r7.mCalled = r14;
        r0 = r6.f11318m;
        r0 = r0.f11275c;
        r7.onAttach(r0);
        r0 = r7.mCalled;
        if (r0 != 0) goto L_0x0158;
    L_0x013f:
        r0 = new android.support.v4.app.SuperNotCalledException;
        r1 = new java.lang.StringBuilder;
        r2 = "Fragment ";
        r1.<init>(r2);
        r1.append(r7);
        r2 = " did not call through to super.onAttach()";
        r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0158:
        r0 = r7.mParentFragment;
        if (r0 != 0) goto L_0x0162;
    L_0x015c:
        r0 = r6.f11318m;
        r0.mo3120a(r7);
        goto L_0x0167;
    L_0x0162:
        r0 = r7.mParentFragment;
        r0.onAttachFragment(r7);
    L_0x0167:
        r0 = r6.f11318m;
        r0 = r0.f11275c;
        r6.m9840b(r7, r0, r14);
        r0 = r7.mIsCreated;
        if (r0 != 0) goto L_0x0182;
    L_0x0172:
        r0 = r7.mSavedFragmentState;
        r6.m9829a(r7, r0, r14);
        r0 = r7.mSavedFragmentState;
        r7.performCreate(r0);
        r0 = r7.mSavedFragmentState;
        r6.m9841b(r7, r0, r14);
        goto L_0x0189;
    L_0x0182:
        r0 = r7.mSavedFragmentState;
        r7.restoreChildFragmentState(r0);
        r7.mState = r8;
    L_0x0189:
        r7.mRetaining = r14;
    L_0x018b:
        r0 = r7.mFromLayout;
        r1 = 8;
        if (r0 == 0) goto L_0x01ca;
    L_0x0191:
        r0 = r7.mPerformedCreateView;
        if (r0 != 0) goto L_0x01ca;
    L_0x0195:
        r0 = r7.mSavedFragmentState;
        r0 = r7.performGetLayoutInflater(r0);
        r2 = r7.mSavedFragmentState;
        r0 = r7.performCreateView(r0, r13, r2);
        r7.mView = r0;
        r0 = r7.mView;
        if (r0 == 0) goto L_0x01c8;
    L_0x01a7:
        r0 = r7.mView;
        r7.mInnerView = r0;
        r0 = r7.mView;
        r0.setSaveFromParentEnabled(r14);
        r0 = r7.mHidden;
        if (r0 == 0) goto L_0x01b9;
    L_0x01b4:
        r0 = r7.mView;
        r0.setVisibility(r1);
    L_0x01b9:
        r0 = r7.mView;
        r2 = r7.mSavedFragmentState;
        r7.onViewCreated(r0, r2);
        r0 = r7.mView;
        r2 = r7.mSavedFragmentState;
        r6.m9830a(r7, r0, r2, r14);
        goto L_0x01ca;
    L_0x01c8:
        r7.mInnerView = r13;
    L_0x01ca:
        if (r11 <= r8) goto L_0x02b9;
    L_0x01cc:
        r0 = f11300a;
        if (r0 == 0) goto L_0x01e3;
    L_0x01d0:
        r0 = "FragmentManager";
        r2 = new java.lang.StringBuilder;
        r3 = "moveto ACTIVITY_CREATED: ";
        r2.<init>(r3);
        r2.append(r7);
        r2 = r2.toString();
        android.util.Log.v(r0, r2);
    L_0x01e3:
        r0 = r7.mFromLayout;
        if (r0 != 0) goto L_0x02a4;
    L_0x01e7:
        r0 = r7.mContainerId;
        if (r0 == 0) goto L_0x0255;
    L_0x01eb:
        r0 = r7.mContainerId;
        r2 = -1;
        if (r0 != r2) goto L_0x020b;
    L_0x01f0:
        r0 = new java.lang.IllegalArgumentException;
        r2 = new java.lang.StringBuilder;
        r3 = "Cannot create fragment ";
        r2.<init>(r3);
        r2.append(r7);
        r3 = " for a container view with no id";
        r2.append(r3);
        r2 = r2.toString();
        r0.<init>(r2);
        r6.m9836a(r0);
    L_0x020b:
        r0 = r6.f11319n;
        r2 = r7.mContainerId;
        r0 = r0.mo209a(r2);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x0256;
    L_0x0217:
        r2 = r7.mRestored;
        if (r2 != 0) goto L_0x0256;
    L_0x021b:
        r2 = r17.getResources();	 Catch:{ NotFoundException -> 0x0226 }
        r3 = r7.mContainerId;	 Catch:{ NotFoundException -> 0x0226 }
        r2 = r2.getResourceName(r3);	 Catch:{ NotFoundException -> 0x0226 }
        goto L_0x0228;
    L_0x0226:
        r2 = "unknown";
    L_0x0228:
        r3 = new java.lang.IllegalArgumentException;
        r4 = new java.lang.StringBuilder;
        r5 = "No view found for id 0x";
        r4.<init>(r5);
        r5 = r7.mContainerId;
        r5 = java.lang.Integer.toHexString(r5);
        r4.append(r5);
        r5 = " (";
        r4.append(r5);
        r4.append(r2);
        r2 = ") for fragment ";
        r4.append(r2);
        r4.append(r7);
        r2 = r4.toString();
        r3.<init>(r2);
        r6.m9836a(r3);
        goto L_0x0256;
    L_0x0255:
        r0 = r13;
    L_0x0256:
        r7.mContainer = r0;
        r2 = r7.mSavedFragmentState;
        r2 = r7.performGetLayoutInflater(r2);
        r3 = r7.mSavedFragmentState;
        r2 = r7.performCreateView(r2, r0, r3);
        r7.mView = r2;
        r2 = r7.mView;
        if (r2 == 0) goto L_0x02a2;
    L_0x026a:
        r2 = r7.mView;
        r7.mInnerView = r2;
        r2 = r7.mView;
        r2.setSaveFromParentEnabled(r14);
        if (r0 == 0) goto L_0x027a;
    L_0x0275:
        r2 = r7.mView;
        r0.addView(r2);
    L_0x027a:
        r0 = r7.mHidden;
        if (r0 == 0) goto L_0x0283;
    L_0x027e:
        r0 = r7.mView;
        r0.setVisibility(r1);
    L_0x0283:
        r0 = r7.mView;
        r1 = r7.mSavedFragmentState;
        r7.onViewCreated(r0, r1);
        r0 = r7.mView;
        r1 = r7.mSavedFragmentState;
        r6.m9830a(r7, r0, r1, r14);
        r0 = r7.mView;
        r0 = r0.getVisibility();
        if (r0 != 0) goto L_0x029e;
    L_0x0299:
        r0 = r7.mContainer;
        if (r0 == 0) goto L_0x029e;
    L_0x029d:
        goto L_0x029f;
    L_0x029e:
        r8 = r14;
    L_0x029f:
        r7.mIsNewlyAdded = r8;
        goto L_0x02a4;
    L_0x02a2:
        r7.mInnerView = r13;
    L_0x02a4:
        r0 = r7.mSavedFragmentState;
        r7.performActivityCreated(r0);
        r0 = r7.mSavedFragmentState;
        r6.m9846c(r7, r0, r14);
        r0 = r7.mView;
        if (r0 == 0) goto L_0x02b7;
    L_0x02b2:
        r0 = r7.mSavedFragmentState;
        r7.restoreViewState(r0);
    L_0x02b7:
        r7.mSavedFragmentState = r13;
    L_0x02b9:
        if (r11 <= r12) goto L_0x02bd;
    L_0x02bb:
        r7.mState = r10;
    L_0x02bd:
        if (r11 <= r10) goto L_0x02dc;
    L_0x02bf:
        r0 = f11300a;
        if (r0 == 0) goto L_0x02d6;
    L_0x02c3:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r2 = "moveto STARTED: ";
        r1.<init>(r2);
        r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02d6:
        r17.performStart();
        r6.m9842b(r7, r14);
    L_0x02dc:
        if (r11 <= r9) goto L_0x04c8;
    L_0x02de:
        r0 = f11300a;
        if (r0 == 0) goto L_0x02f5;
    L_0x02e2:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r2 = "moveto RESUMED: ";
        r1.<init>(r2);
        r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02f5:
        r17.performResume();
        r6.m9847c(r7, r14);
        r7.mSavedFragmentState = r13;
        r7.mSavedViewState = r13;
        goto L_0x04c8;
    L_0x0301:
        r0 = r7.mState;
        if (r0 <= r11) goto L_0x04c8;
    L_0x0305:
        r0 = r7.mState;
        switch(r0) {
            case 1: goto L_0x042c;
            case 2: goto L_0x0367;
            case 3: goto L_0x034b;
            case 4: goto L_0x032c;
            case 5: goto L_0x030c;
            default: goto L_0x030a;
        };
    L_0x030a:
        goto L_0x04c8;
    L_0x030c:
        r0 = 5;
        if (r11 >= r0) goto L_0x032c;
    L_0x030f:
        r0 = f11300a;
        if (r0 == 0) goto L_0x0326;
    L_0x0313:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r2 = "movefrom RESUMED: ";
        r1.<init>(r2);
        r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0326:
        r17.performPause();
        r6.m9852d(r7, r14);
    L_0x032c:
        if (r11 >= r9) goto L_0x034b;
    L_0x032e:
        r0 = f11300a;
        if (r0 == 0) goto L_0x0345;
    L_0x0332:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r2 = "movefrom STARTED: ";
        r1.<init>(r2);
        r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0345:
        r17.performStop();
        r6.m9853e(r7, r14);
    L_0x034b:
        if (r11 >= r10) goto L_0x0367;
    L_0x034d:
        r0 = f11300a;
        if (r0 == 0) goto L_0x0364;
    L_0x0351:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r2 = "movefrom STOPPED: ";
        r1.<init>(r2);
        r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0364:
        r17.performReallyStop();
    L_0x0367:
        if (r11 >= r12) goto L_0x042c;
    L_0x0369:
        r0 = f11300a;
        if (r0 == 0) goto L_0x0380;
    L_0x036d:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r2 = "movefrom ACTIVITY_CREATED: ";
        r1.<init>(r2);
        r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0380:
        r0 = r7.mView;
        if (r0 == 0) goto L_0x0393;
    L_0x0384:
        r0 = r6.f11318m;
        r0 = r0.mo3126b();
        if (r0 == 0) goto L_0x0393;
    L_0x038c:
        r0 = r7.mSavedViewState;
        if (r0 != 0) goto L_0x0393;
    L_0x0390:
        r16.m9860l(r17);
    L_0x0393:
        r17.performDestroyView();
        r6.m9855f(r7, r14);
        r0 = r7.mView;
        if (r0 == 0) goto L_0x0424;
    L_0x039d:
        r0 = r7.mContainer;
        if (r0 == 0) goto L_0x0424;
    L_0x03a1:
        r0 = r7.mView;
        r0.clearAnimation();
        r0 = r7.mContainer;
        r1 = r7.mView;
        r0.endViewTransition(r1);
        r0 = r6.f11317l;
        r1 = 0;
        if (r0 <= 0) goto L_0x03ce;
    L_0x03b2:
        r0 = r6.f11324t;
        if (r0 != 0) goto L_0x03ce;
    L_0x03b6:
        r0 = r7.mView;
        r0 = r0.getVisibility();
        if (r0 != 0) goto L_0x03ce;
    L_0x03be:
        r0 = r7.mPostponedAlpha;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 < 0) goto L_0x03ce;
    L_0x03c4:
        r0 = r19;
        r2 = r20;
        r0 = r6.m9825a(r7, r0, r14, r2);
        r9 = r0;
        goto L_0x03cf;
    L_0x03ce:
        r9 = r13;
    L_0x03cf:
        r7.mPostponedAlpha = r1;
        if (r9 == 0) goto L_0x041d;
    L_0x03d3:
        r10 = r7.mView;
        r3 = r7.mContainer;
        r3.startViewTransition(r10);
        r7.setStateAfterAnimating(r11);
        r0 = r9.f993a;
        if (r0 == 0) goto L_0x0401;
    L_0x03e1:
        r12 = r9.f993a;
        r0 = r7.mView;
        r7.setAnimatingAway(r0);
        r2 = m9826a(r12);
        r15 = new android.support.v4.app.FragmentManagerImpl$2;
        r0 = r15;
        r1 = r6;
        r4 = r10;
        r5 = r7;
        r0.<init>(r1, r2, r3, r4, r5);
        r12.setAnimationListener(r15);
        m9835a(r10, r9);
        r0 = r7.mView;
        r0.startAnimation(r12);
        goto L_0x041d;
    L_0x0401:
        r0 = r9.f994b;
        r1 = r9.f994b;
        r7.setAnimator(r1);
        r1 = new android.support.v4.app.FragmentManagerImpl$3;
        r1.<init>(r6, r3, r10, r7);
        r0.addListener(r1);
        r1 = r7.mView;
        r0.setTarget(r1);
        r1 = r7.mView;
        m9835a(r1, r9);
        r0.start();
    L_0x041d:
        r0 = r7.mContainer;
        r1 = r7.mView;
        r0.removeView(r1);
    L_0x0424:
        r7.mContainer = r13;
        r7.mView = r13;
        r7.mInnerView = r13;
        r7.mInLayout = r14;
    L_0x042c:
        if (r11 > 0) goto L_0x04c8;
    L_0x042e:
        r0 = r6.f11324t;
        if (r0 == 0) goto L_0x0453;
    L_0x0432:
        r0 = r17.getAnimatingAway();
        if (r0 == 0) goto L_0x0443;
    L_0x0438:
        r0 = r17.getAnimatingAway();
        r7.setAnimatingAway(r13);
        r0.clearAnimation();
        goto L_0x0453;
    L_0x0443:
        r0 = r17.getAnimator();
        if (r0 == 0) goto L_0x0453;
    L_0x0449:
        r0 = r17.getAnimator();
        r7.setAnimator(r13);
        r0.cancel();
    L_0x0453:
        r0 = r17.getAnimatingAway();
        if (r0 != 0) goto L_0x04c4;
    L_0x0459:
        r0 = r17.getAnimator();
        if (r0 == 0) goto L_0x0460;
    L_0x045f:
        goto L_0x04c4;
    L_0x0460:
        r0 = f11300a;
        if (r0 == 0) goto L_0x0477;
    L_0x0464:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r2 = "movefrom CREATED: ";
        r1.<init>(r2);
        r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0477:
        r0 = r7.mRetaining;
        if (r0 != 0) goto L_0x0482;
    L_0x047b:
        r17.performDestroy();
        r6.m9857g(r7, r14);
        goto L_0x0484;
    L_0x0482:
        r7.mState = r14;
    L_0x0484:
        r17.performDetach();
        r6.m9858h(r7, r14);
        if (r21 != 0) goto L_0x04c8;
    L_0x048c:
        r0 = r7.mRetaining;
        if (r0 != 0) goto L_0x04bd;
    L_0x0490:
        r0 = r7.mIndex;
        if (r0 < 0) goto L_0x04c8;
    L_0x0494:
        r0 = f11300a;
        if (r0 == 0) goto L_0x04ab;
    L_0x0498:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r2 = "Freeing fragment index ";
        r1.<init>(r2);
        r1.append(r7);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x04ab:
        r0 = r6.f11311f;
        r1 = r7.mIndex;
        r0.put(r1, r13);
        r0 = r6.f11318m;
        r1 = r7.mWho;
        r0.m9807b(r1);
        r17.initState();
        goto L_0x04c8;
    L_0x04bd:
        r7.mHost = r13;
        r7.mParentFragment = r13;
        r7.mFragmentManager = r13;
        goto L_0x04c8;
    L_0x04c4:
        r7.setStateAfterAnimating(r11);
        goto L_0x04c9;
    L_0x04c8:
        r8 = r11;
    L_0x04c9:
        r0 = r7.mState;
        if (r0 == r8) goto L_0x04f4;
    L_0x04cd:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r2 = "moveToState: Fragment state for ";
        r1.<init>(r2);
        r1.append(r7);
        r2 = " not updated inline; expected state ";
        r1.append(r2);
        r1.append(r8);
        r2 = " found ";
        r1.append(r2);
        r2 = r7.mState;
        r1.append(r2);
        r1 = r1.toString();
        android.util.Log.w(r0, r1);
        r7.mState = r8;
    L_0x04f4:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentManagerImpl.a(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    private void m9859k(Fragment fragment) {
        m9880a(fragment, this.f11317l, 0, 0, false);
    }

    final void m9902c(final Fragment fragment) {
        if (fragment != null) {
            ViewGroup viewGroup;
            AnimationOrAnimator a;
            int i = this.f11317l;
            if (fragment.mRemoving) {
                if (fragment.isInBackStack()) {
                    i = Math.min(i, 1);
                } else {
                    i = Math.min(i, 0);
                }
            }
            m9880a(fragment, i, fragment.getNextTransition(), fragment.getNextTransitionStyle(), false);
            if (fragment.mView != null) {
                ViewGroup viewGroup2 = fragment.mContainer;
                View view = fragment.mView;
                Fragment fragment2 = null;
                if (viewGroup2 != null) {
                    if (view != null) {
                        for (int indexOf = this.f11310e.indexOf(fragment) - 1; indexOf >= 0; indexOf--) {
                            Fragment fragment3 = (Fragment) this.f11310e.get(indexOf);
                            if (fragment3.mContainer == viewGroup2 && fragment3.mView != null) {
                                fragment2 = fragment3;
                                break;
                            }
                        }
                    }
                }
                if (fragment2 != null) {
                    View view2 = fragment2.mView;
                    viewGroup = fragment.mContainer;
                    i = viewGroup.indexOfChild(view2);
                    int indexOfChild = viewGroup.indexOfChild(fragment.mView);
                    if (indexOfChild < i) {
                        viewGroup.removeViewAt(indexOfChild);
                        viewGroup.addView(fragment.mView, i);
                    }
                }
                if (fragment.mIsNewlyAdded && fragment.mContainer != null) {
                    if (fragment.mPostponedAlpha > 0.0f) {
                        fragment.mView.setAlpha(fragment.mPostponedAlpha);
                    }
                    fragment.mPostponedAlpha = 0.0f;
                    fragment.mIsNewlyAdded = false;
                    a = m9825a(fragment, fragment.getNextTransition(), true, fragment.getNextTransitionStyle());
                    if (a != null) {
                        m9835a(fragment.mView, a);
                        if (a.f993a != null) {
                            fragment.mView.startAnimation(a.f993a);
                        } else {
                            a.f994b.setTarget(fragment.mView);
                            a.f994b.start();
                        }
                    }
                }
            }
            if (fragment.mHiddenChanged) {
                if (fragment.mView != null) {
                    a = m9825a(fragment, fragment.getNextTransition(), fragment.mHidden ^ true, fragment.getNextTransitionStyle());
                    if (a == null || a.f994b == null) {
                        if (a != null) {
                            m9835a(fragment.mView, a);
                            fragment.mView.startAnimation(a.f993a);
                            a.f993a.start();
                        }
                        i = (!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8;
                        fragment.mView.setVisibility(i);
                        if (fragment.isHideReplaced()) {
                            fragment.setHideReplaced(false);
                        }
                    } else {
                        a.f994b.setTarget(fragment.mView);
                        if (!fragment.mHidden) {
                            fragment.mView.setVisibility(0);
                        } else if (fragment.isHideReplaced()) {
                            fragment.setHideReplaced(false);
                        } else {
                            viewGroup = fragment.mContainer;
                            final View view3 = fragment.mView;
                            viewGroup.startViewTransition(view3);
                            a.f994b.addListener(new AnimatorListenerAdapter(this) {
                                final /* synthetic */ FragmentManagerImpl f990d;

                                public void onAnimationEnd(Animator animator) {
                                    viewGroup.endViewTransition(view3);
                                    animator.removeListener(this);
                                    if (fragment.mView != null) {
                                        fragment.mView.setVisibility(8);
                                    }
                                }
                            });
                        }
                        m9835a(fragment.mView, a);
                        a.f994b.start();
                    }
                }
                if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
                    this.f11322r = true;
                }
                fragment.mHiddenChanged = false;
                fragment.onHiddenChanged(fragment.mHidden);
            }
        }
    }

    final void m9876a(int i, boolean z) {
        if (this.f11318m == null && i != 0) {
            throw new IllegalStateException("No activity");
        } else if (z || i != this.f11317l) {
            this.f11317l = i;
            if (this.f11311f != 0) {
                Fragment fragment;
                i = this.f11310e.size();
                int i2 = 0;
                int i3 = i2;
                while (i2 < i) {
                    fragment = (Fragment) this.f11310e.get(i2);
                    m9902c(fragment);
                    if (fragment.mLoaderManager != null) {
                        i3 |= fragment.mLoaderManager.mo253a();
                    }
                    i2++;
                }
                i = this.f11311f.size();
                for (i2 = 0; i2 < i; i2++) {
                    fragment = (Fragment) this.f11311f.valueAt(i2);
                    if (fragment != null && ((fragment.mRemoving || fragment.mDetached) && !fragment.mIsNewlyAdded)) {
                        m9902c(fragment);
                        if (fragment.mLoaderManager != null) {
                            i3 |= fragment.mLoaderManager.mo253a();
                        }
                    }
                }
                if (i3 == 0) {
                    m9909h();
                }
                if (!(this.f11322r == 0 || this.f11318m == 0 || this.f11317l != 5)) {
                    this.f11318m.mo3128d();
                    this.f11322r = false;
                }
            }
        }
    }

    final void m9909h() {
        if (this.f11311f != null) {
            for (int i = 0; i < this.f11311f.size(); i++) {
                Fragment fragment = (Fragment) this.f11311f.valueAt(i);
                if (fragment != null) {
                    m9892b(fragment);
                }
            }
        }
    }

    final void m9903d(Fragment fragment) {
        if (fragment.mIndex < 0) {
            int i = this.f11309d;
            this.f11309d = i + 1;
            fragment.setIndex(i, this.f11320o);
            if (this.f11311f == null) {
                this.f11311f = new SparseArray();
            }
            this.f11311f.put(fragment.mIndex, fragment);
            if (f11300a) {
                StringBuilder stringBuilder = new StringBuilder("Allocated fragment index ");
                stringBuilder.append(fragment);
                Log.v("FragmentManager", stringBuilder.toString());
            }
        }
    }

    public final void m9881a(Fragment fragment, boolean z) {
        if (f11300a) {
            StringBuilder stringBuilder = new StringBuilder("add: ");
            stringBuilder.append(fragment);
            Log.v("FragmentManager", stringBuilder.toString());
        }
        m9903d(fragment);
        if (!fragment.mDetached) {
            if (this.f11310e.contains(fragment)) {
                StringBuilder stringBuilder2 = new StringBuilder("Fragment already added: ");
                stringBuilder2.append(fragment);
                throw new IllegalStateException(stringBuilder2.toString());
            }
            synchronized (this.f11310e) {
                this.f11310e.add(fragment);
            }
            fragment.mAdded = true;
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.f11322r = true;
            }
            if (z) {
                m9859k(fragment);
            }
        }
    }

    public final void m9906e(Fragment fragment) {
        if (f11300a) {
            StringBuilder stringBuilder = new StringBuilder("remove: ");
            stringBuilder.append(fragment);
            stringBuilder.append(" nesting=");
            stringBuilder.append(fragment.mBackStackNesting);
            Log.v("FragmentManager", stringBuilder.toString());
        }
        int isInBackStack = fragment.isInBackStack() ^ 1;
        if (!fragment.mDetached || isInBackStack != 0) {
            synchronized (this.f11310e) {
                this.f11310e.remove(fragment);
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.f11322r = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
        }
    }

    public static void m9854f(Fragment fragment) {
        if (f11300a) {
            StringBuilder stringBuilder = new StringBuilder("hide: ");
            stringBuilder.append(fragment);
            Log.v("FragmentManager", stringBuilder.toString());
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        }
    }

    public static void m9856g(Fragment fragment) {
        if (f11300a) {
            StringBuilder stringBuilder = new StringBuilder("show: ");
            stringBuilder.append(fragment);
            Log.v("FragmentManager", stringBuilder.toString());
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged ^= 1;
        }
    }

    public final void m9910h(Fragment fragment) {
        if (f11300a) {
            StringBuilder stringBuilder = new StringBuilder("detach: ");
            stringBuilder.append(fragment);
            Log.v("FragmentManager", stringBuilder.toString());
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (f11300a) {
                    StringBuilder stringBuilder2 = new StringBuilder("remove from detach: ");
                    stringBuilder2.append(fragment);
                    Log.v("FragmentManager", stringBuilder2.toString());
                }
                synchronized (this.f11310e) {
                    this.f11310e.remove(fragment);
                }
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.f11322r = true;
                }
                fragment.mAdded = false;
            }
        }
    }

    public final void m9911i(Fragment fragment) {
        if (f11300a) {
            StringBuilder stringBuilder = new StringBuilder("attach: ");
            stringBuilder.append(fragment);
            Log.v("FragmentManager", stringBuilder.toString());
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                if (this.f11310e.contains(fragment)) {
                    stringBuilder = new StringBuilder("Fragment already added: ");
                    stringBuilder.append(fragment);
                    throw new IllegalStateException(stringBuilder.toString());
                }
                if (f11300a) {
                    stringBuilder = new StringBuilder("add from attach: ");
                    stringBuilder.append(fragment);
                    Log.v("FragmentManager", stringBuilder.toString());
                }
                synchronized (this.f11310e) {
                    this.f11310e.add(fragment);
                }
                fragment.mAdded = true;
                if (fragment.mHasMenu && fragment.mMenuVisible != null) {
                    this.f11322r = true;
                }
            }
        }
    }

    public final Fragment mo216a(int i) {
        int size;
        for (size = this.f11310e.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.f11310e.get(size);
            if (fragment != null && fragment.mFragmentId == i) {
                return fragment;
            }
        }
        if (this.f11311f != null) {
            for (size = this.f11311f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f11311f.valueAt(size);
                if (fragment != null && fragment.mFragmentId == i) {
                    return fragment;
                }
            }
        }
        return 0;
    }

    public final Fragment mo218a(String str) {
        int size;
        Fragment fragment;
        if (str != null) {
            for (size = this.f11310e.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f11310e.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (!(this.f11311f == null || str == null)) {
            for (size = this.f11311f.size() - 1; size >= 0; size--) {
                fragment = (Fragment) this.f11311f.valueAt(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public final Fragment m9899c(String str) {
        if (!(this.f11311f == null || str == null)) {
            for (int size = this.f11311f.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.f11311f.valueAt(size);
                if (fragment != null) {
                    fragment = fragment.findFragmentByWho(str);
                    if (fragment != null) {
                        return fragment;
                    }
                }
            }
        }
        return null;
    }

    private void m9863t() {
        if (this.f11323s) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.f11325u != null) {
            StringBuilder stringBuilder = new StringBuilder("Can not perform this action inside of ");
            stringBuilder.append(this.f11325u);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public final boolean mo230g() {
        return this.f11323s;
    }

    public final void m9884a(OpGenerator opGenerator, boolean z) {
        if (!z) {
            m9863t();
        }
        synchronized (this) {
            if (!this.f11324t) {
                if (this.f11318m != null) {
                    if (!this.f11307b) {
                        this.f11307b = new ArrayList();
                    }
                    this.f11307b.add(opGenerator);
                    m9864u();
                    return;
                }
            }
            if (z) {
                return;
            }
            throw new IllegalStateException("Activity has been destroyed");
        }
    }

    private void m9864u() {
        synchronized (this) {
            Object obj = null;
            Object obj2 = (this.f11303B == null || this.f11303B.isEmpty()) ? null : 1;
            if (this.f11307b != null && this.f11307b.size() == 1) {
                obj = 1;
            }
            if (!(obj2 == null && r1 == null)) {
                this.f11318m.f11276d.removeCallbacks(this.f11305D);
                this.f11318m.f11276d.post(this.f11305D);
            }
        }
    }

    public final int m9870a(BackStackRecord backStackRecord) {
        synchronized (this) {
            int intValue;
            if (this.f11315j != null) {
                if (this.f11315j.size() > 0) {
                    intValue = ((Integer) this.f11315j.remove(this.f11315j.size() - 1)).intValue();
                    if (f11300a) {
                        StringBuilder stringBuilder = new StringBuilder("Adding back stack index ");
                        stringBuilder.append(intValue);
                        stringBuilder.append(" with ");
                        stringBuilder.append(backStackRecord);
                        Log.v("FragmentManager", stringBuilder.toString());
                    }
                    this.f11314i.set(intValue, backStackRecord);
                    return intValue;
                }
            }
            if (this.f11314i == null) {
                this.f11314i = new ArrayList();
            }
            intValue = this.f11314i.size();
            if (f11300a) {
                stringBuilder = new StringBuilder("Setting back stack index ");
                stringBuilder.append(intValue);
                stringBuilder.append(" to ");
                stringBuilder.append(backStackRecord);
                Log.v("FragmentManager", stringBuilder.toString());
            }
            this.f11314i.add(backStackRecord);
            return intValue;
        }
    }

    private void m9827a(int i, BackStackRecord backStackRecord) {
        synchronized (this) {
            if (this.f11314i == null) {
                this.f11314i = new ArrayList();
            }
            int size = this.f11314i.size();
            StringBuilder stringBuilder;
            if (i < size) {
                if (f11300a) {
                    stringBuilder = new StringBuilder("Setting back stack index ");
                    stringBuilder.append(i);
                    stringBuilder.append(" to ");
                    stringBuilder.append(backStackRecord);
                    Log.v("FragmentManager", stringBuilder.toString());
                }
                this.f11314i.set(i, backStackRecord);
            } else {
                while (size < i) {
                    this.f11314i.add(null);
                    if (this.f11315j == null) {
                        this.f11315j = new ArrayList();
                    }
                    if (f11300a) {
                        StringBuilder stringBuilder2 = new StringBuilder("Adding available back stack index ");
                        stringBuilder2.append(size);
                        Log.v("FragmentManager", stringBuilder2.toString());
                    }
                    this.f11315j.add(Integer.valueOf(size));
                    size++;
                }
                if (f11300a) {
                    stringBuilder = new StringBuilder("Adding back stack index ");
                    stringBuilder.append(i);
                    stringBuilder.append(" with ");
                    stringBuilder.append(backStackRecord);
                    Log.v("FragmentManager", stringBuilder.toString());
                }
                this.f11314i.add(backStackRecord);
            }
        }
    }

    private void m9848c(boolean z) {
        if (this.f11308c) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (Looper.myLooper() != this.f11318m.f11276d.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else {
            if (!z) {
                m9863t();
            }
            if (!this.f11327w) {
                this.f11327w = new ArrayList();
                this.f11328x = new ArrayList();
            }
            this.f11308c = true;
            try {
                m9837a(null, null);
            } finally {
                this.f11308c = false;
            }
        }
    }

    public final void m9893b(OpGenerator opGenerator, boolean z) {
        if (!z || (this.f11318m != null && !this.f11324t)) {
            m9848c(z);
            if (opGenerator.mo199a(this.f11327w, this.f11328x) != null) {
                this.f11308c = true;
                try {
                    m9844b(this.f11327w, this.f11328x);
                } finally {
                    m9865v();
                }
            }
            m9867x();
            m9821A();
        }
    }

    private void m9865v() {
        this.f11308c = false;
        this.f11328x.clear();
        this.f11327w.clear();
    }

    private void m9837a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        int size = this.f11303B == null ? 0 : this.f11303B.size();
        int i = 0;
        while (i < size) {
            int indexOf;
            StartEnterTransitionListener startEnterTransitionListener = (StartEnterTransitionListener) this.f11303B.get(i);
            if (!(arrayList == null || startEnterTransitionListener.f11294b)) {
                indexOf = arrayList.indexOf(startEnterTransitionListener.f11295c);
                if (indexOf != -1 && ((Boolean) arrayList2.get(indexOf)).booleanValue()) {
                    startEnterTransitionListener.m9820d();
                    i++;
                }
            }
            if ((startEnterTransitionListener.f11293a == 0 ? 1 : 0) != 0 || (arrayList != null && startEnterTransitionListener.f11295c.m9781a((ArrayList) arrayList, 0, arrayList.size()))) {
                this.f11303B.remove(i);
                i--;
                size--;
                if (!(arrayList == null || startEnterTransitionListener.f11294b)) {
                    indexOf = arrayList.indexOf(startEnterTransitionListener.f11295c);
                    if (indexOf != -1 && ((Boolean) arrayList2.get(indexOf)).booleanValue()) {
                        startEnterTransitionListener.m9820d();
                    }
                }
                startEnterTransitionListener.m9819c();
            }
            i++;
        }
    }

    private void m9844b(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList != null) {
            if (!arrayList.isEmpty()) {
                if (arrayList2 != null) {
                    if (arrayList.size() == arrayList2.size()) {
                        m9837a((ArrayList) arrayList, (ArrayList) arrayList2);
                        int size = arrayList.size();
                        int i = 0;
                        int i2 = 0;
                        while (i < size) {
                            if (!((BackStackRecord) arrayList.get(i)).f11271t) {
                                if (i2 != i) {
                                    m9838a((ArrayList) arrayList, (ArrayList) arrayList2, i2, i);
                                }
                                i2 = i + 1;
                                if (((Boolean) arrayList2.get(i)).booleanValue()) {
                                    while (i2 < size && ((Boolean) arrayList2.get(i2)).booleanValue() && !((BackStackRecord) arrayList.get(i2)).f11271t) {
                                        i2++;
                                    }
                                }
                                m9838a((ArrayList) arrayList, (ArrayList) arrayList2, i, i2);
                                i = i2 - 1;
                            }
                            i++;
                        }
                        if (i2 != size) {
                            m9838a((ArrayList) arrayList, (ArrayList) arrayList2, i2, size);
                        }
                        return;
                    }
                }
                throw new IllegalStateException("Internal error with the back stack records");
            }
        }
    }

    private void m9838a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int i3;
        int i4;
        ArrayList<BackStackRecord> arrayList3 = arrayList;
        ArrayList<Boolean> arrayList4 = arrayList2;
        int i5 = i;
        int i6 = i2;
        boolean z = ((BackStackRecord) arrayList3.get(i5)).f11271t;
        if (this.f11329y == null) {
            r7.f11329y = new ArrayList();
        } else {
            r7.f11329y.clear();
        }
        r7.f11329y.addAll(r7.f11310e);
        Fragment fragment = r7.f11321p;
        boolean z2 = false;
        for (i3 = i5; i3 < i6; i3++) {
            BackStackRecord backStackRecord = (BackStackRecord) arrayList3.get(i3);
            if (((Boolean) arrayList4.get(i3)).booleanValue()) {
                fragment = backStackRecord.m9783b(r7.f11329y, fragment);
            } else {
                fragment = backStackRecord.m9767a(r7.f11329y, fragment);
            }
            if (!z2) {
                if (!backStackRecord.f11260i) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        r7.f11329y.clear();
        if (!z) {
            FragmentTransition.m602a(r7, (ArrayList) arrayList3, (ArrayList) arrayList4, i5, i6, false);
        }
        m9845b(arrayList, arrayList2, i, i2);
        if (z) {
            ArraySet arraySet = new ArraySet();
            m9843b(arraySet);
            i3 = m9822a((ArrayList) arrayList3, (ArrayList) arrayList4, i5, i6, arraySet);
            m9834a(arraySet);
            i4 = i3;
        } else {
            i4 = i6;
        }
        if (i4 != i5 && z) {
            FragmentTransition.m602a(r7, (ArrayList) arrayList3, (ArrayList) arrayList4, i5, i4, true);
            m9876a(r7.f11317l, true);
        }
        while (i5 < i6) {
            BackStackRecord backStackRecord2 = (BackStackRecord) arrayList3.get(i5);
            if (((Boolean) arrayList4.get(i5)).booleanValue() && backStackRecord2.f11264m >= 0) {
                int i7 = backStackRecord2.f11264m;
                synchronized (this) {
                    try {
                        r7.f11314i.set(i7, null);
                        if (r7.f11315j == null) {
                            r7.f11315j = new ArrayList();
                        }
                        if (f11300a) {
                            StringBuilder stringBuilder = new StringBuilder("Freeing back stack index ");
                            stringBuilder.append(i7);
                            Log.v("FragmentManager", stringBuilder.toString());
                        }
                        r7.f11315j.add(Integer.valueOf(i7));
                    } catch (Throwable th) {
                        while (true) {
                            Throwable th2 = th;
                        }
                    }
                }
                backStackRecord2.f11264m = -1;
            }
            backStackRecord2.m9787b();
            i5++;
        }
        if (z2) {
            m9868y();
        }
    }

    private static void m9834a(ArraySet<Fragment> arraySet) {
        int size = arraySet.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = (Fragment) arraySet.f1382g[i];
            if (!fragment.mAdded) {
                View view = fragment.getView();
                fragment.mPostponedAlpha = view.getAlpha();
                view.setAlpha(0.0f);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m9822a(java.util.ArrayList<android.support.v4.app.BackStackRecord> r9, java.util.ArrayList<java.lang.Boolean> r10, int r11, int r12, android.support.v4.util.ArraySet<android.support.v4.app.Fragment> r13) {
        /*
        r8 = this;
        r0 = r12 + -1;
        r1 = r12;
    L_0x0003:
        if (r0 < r11) goto L_0x0073;
    L_0x0005:
        r2 = r9.get(r0);
        r2 = (android.support.v4.app.BackStackRecord) r2;
        r3 = r10.get(r0);
        r3 = (java.lang.Boolean) r3;
        r3 = r3.booleanValue();
        r4 = 0;
        r5 = r4;
    L_0x0017:
        r6 = r2.f11253b;
        r6 = r6.size();
        r7 = 1;
        if (r5 >= r6) goto L_0x0033;
    L_0x0020:
        r6 = r2.f11253b;
        r6 = r6.get(r5);
        r6 = (android.support.v4.app.BackStackRecord.Op) r6;
        r6 = android.support.v4.app.BackStackRecord.m9765b(r6);
        if (r6 == 0) goto L_0x0030;
    L_0x002e:
        r5 = r7;
        goto L_0x0034;
    L_0x0030:
        r5 = r5 + 1;
        goto L_0x0017;
    L_0x0033:
        r5 = r4;
    L_0x0034:
        if (r5 == 0) goto L_0x003f;
    L_0x0036:
        r5 = r0 + 1;
        r5 = r2.m9781a(r9, r5, r12);
        if (r5 != 0) goto L_0x003f;
    L_0x003e:
        goto L_0x0040;
    L_0x003f:
        r7 = r4;
    L_0x0040:
        if (r7 == 0) goto L_0x0070;
    L_0x0042:
        r5 = r8.f11303B;
        if (r5 != 0) goto L_0x004d;
    L_0x0046:
        r5 = new java.util.ArrayList;
        r5.<init>();
        r8.f11303B = r5;
    L_0x004d:
        r5 = new android.support.v4.app.FragmentManagerImpl$StartEnterTransitionListener;
        r5.<init>(r2, r3);
        r6 = r8.f11303B;
        r6.add(r5);
        r2.m9777a(r5);
        if (r3 == 0) goto L_0x0060;
    L_0x005c:
        r2.m9794g();
        goto L_0x0063;
    L_0x0060:
        r2.m9780a(r4);
    L_0x0063:
        r1 = r1 + -1;
        if (r0 == r1) goto L_0x006d;
    L_0x0067:
        r9.remove(r0);
        r9.add(r1, r2);
    L_0x006d:
        r8.m9843b(r13);
    L_0x0070:
        r0 = r0 + -1;
        goto L_0x0003;
    L_0x0073:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentManagerImpl.a(java.util.ArrayList, java.util.ArrayList, int, int, android.support.v4.util.ArraySet):int");
    }

    private static void m9845b(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            BackStackRecord backStackRecord = (BackStackRecord) arrayList.get(i);
            boolean z = true;
            if (((Boolean) arrayList2.get(i)).booleanValue()) {
                backStackRecord.m9775a(-1);
                if (i != i2 - 1) {
                    z = false;
                }
                backStackRecord.m9780a(z);
            } else {
                backStackRecord.m9775a(1);
                backStackRecord.m9794g();
            }
            i++;
        }
    }

    private void m9843b(ArraySet<Fragment> arraySet) {
        if (this.f11317l > 0) {
            int min = Math.min(this.f11317l, 4);
            int size = this.f11310e.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = (Fragment) this.f11310e.get(i);
                if (fragment.mState < min) {
                    m9880a(fragment, min, fragment.getNextAnim(), fragment.getNextTransition(), false);
                    if (!(fragment.mView == null || fragment.mHidden || !fragment.mIsNewlyAdded)) {
                        arraySet.add(fragment);
                    }
                }
            }
        }
    }

    private void m9866w() {
        if (this.f11303B != null) {
            while (!this.f11303B.isEmpty()) {
                ((StartEnterTransitionListener) this.f11303B.remove(0)).m9819c();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m9849c(java.util.ArrayList<android.support.v4.app.BackStackRecord> r5, java.util.ArrayList<java.lang.Boolean> r6) {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = r4.f11307b;	 Catch:{ all -> 0x003a }
        r1 = 0;
        if (r0 == 0) goto L_0x0038;
    L_0x0006:
        r0 = r4.f11307b;	 Catch:{ all -> 0x003a }
        r0 = r0.size();	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x000f;
    L_0x000e:
        goto L_0x0038;
    L_0x000f:
        r0 = r4.f11307b;	 Catch:{ all -> 0x003a }
        r0 = r0.size();	 Catch:{ all -> 0x003a }
        r2 = r1;
    L_0x0016:
        if (r1 >= r0) goto L_0x0028;
    L_0x0018:
        r3 = r4.f11307b;	 Catch:{ all -> 0x003a }
        r3 = r3.get(r1);	 Catch:{ all -> 0x003a }
        r3 = (android.support.v4.app.FragmentManagerImpl.OpGenerator) r3;	 Catch:{ all -> 0x003a }
        r3 = r3.mo199a(r5, r6);	 Catch:{ all -> 0x003a }
        r2 = r2 | r3;
        r1 = r1 + 1;
        goto L_0x0016;
    L_0x0028:
        r5 = r4.f11307b;	 Catch:{ all -> 0x003a }
        r5.clear();	 Catch:{ all -> 0x003a }
        r5 = r4.f11318m;	 Catch:{ all -> 0x003a }
        r5 = r5.f11276d;	 Catch:{ all -> 0x003a }
        r6 = r4.f11305D;	 Catch:{ all -> 0x003a }
        r5.removeCallbacks(r6);	 Catch:{ all -> 0x003a }
        monitor-exit(r4);	 Catch:{ all -> 0x003a }
        return r2;
    L_0x0038:
        monitor-exit(r4);	 Catch:{ all -> 0x003a }
        return r1;
    L_0x003a:
        r5 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x003a }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentManagerImpl.c(java.util.ArrayList, java.util.ArrayList):boolean");
    }

    private void m9867x() {
        if (this.f11326v) {
            int i = 0;
            int i2 = i;
            while (i < this.f11311f.size()) {
                Fragment fragment = (Fragment) this.f11311f.valueAt(i);
                if (!(fragment == null || fragment.mLoaderManager == null)) {
                    i2 |= fragment.mLoaderManager.mo253a();
                }
                i++;
            }
            if (i2 == 0) {
                this.f11326v = false;
                m9909h();
            }
        }
    }

    private void m9868y() {
        if (this.f11316k != null) {
            for (int i = 0; i < this.f11316k.size(); i++) {
                ((OnBackStackChangedListener) this.f11316k.get(i)).mo4426a();
            }
        }
    }

    final boolean m9890a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        if (this.f11312g == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            str = this.f11312g.size() - 1;
            if (str < null) {
                return false;
            }
            arrayList.add(this.f11312g.remove(str));
            arrayList2.add(Boolean.valueOf(true));
        } else {
            int i3;
            if (str == null) {
                if (i < 0) {
                    i3 = -1;
                    if (i3 == this.f11312g.size() - 1) {
                        return false;
                    }
                    for (str = this.f11312g.size() - 1; str > i3; str--) {
                        arrayList.add(this.f11312g.remove(str));
                        arrayList2.add(Boolean.valueOf(true));
                    }
                }
            }
            i3 = this.f11312g.size() - 1;
            while (i3 >= 0) {
                BackStackRecord backStackRecord = (BackStackRecord) this.f11312g.get(i3);
                if ((str != null && str.equals(backStackRecord.f11262k)) || (i >= 0 && i == backStackRecord.f11264m)) {
                    break;
                }
                i3--;
            }
            if (i3 < 0) {
                return false;
            }
            if ((i2 & 1) != 0) {
                i3--;
                while (i3 >= 0) {
                    BackStackRecord backStackRecord2 = (BackStackRecord) this.f11312g.get(i3);
                    if ((str == null || !str.equals(backStackRecord2.f11262k)) && (i < 0 || i != backStackRecord2.f11264m)) {
                        break;
                    }
                    i3--;
                }
            }
            if (i3 == this.f11312g.size() - 1) {
                return false;
            }
            for (str = this.f11312g.size() - 1; str > i3; str--) {
                arrayList.add(this.f11312g.remove(str));
                arrayList2.add(Boolean.valueOf(true));
            }
        }
        return true;
    }

    private void m9869z() {
        List list;
        List list2;
        if (this.f11311f != null) {
            list = null;
            list2 = list;
            for (int i = 0; i < this.f11311f.size(); i++) {
                Fragment fragment = (Fragment) this.f11311f.valueAt(i);
                if (fragment != null) {
                    Object obj;
                    if (fragment.mRetainInstance) {
                        if (list == null) {
                            list = new ArrayList();
                        }
                        list.add(fragment);
                        fragment.mTargetIndex = fragment.mTarget != null ? fragment.mTarget.mIndex : -1;
                        if (f11300a) {
                            StringBuilder stringBuilder = new StringBuilder("retainNonConfig: keeping retained ");
                            stringBuilder.append(fragment);
                            Log.v("FragmentManager", stringBuilder.toString());
                        }
                    }
                    if (fragment.mChildFragmentManager != null) {
                        fragment.mChildFragmentManager.m9869z();
                        obj = fragment.mChildFragmentManager.f11304C;
                    } else {
                        obj = fragment.mChildNonConfig;
                    }
                    if (list2 == null && obj != null) {
                        list2 = new ArrayList(this.f11311f.size());
                        for (int i2 = 0; i2 < i; i2++) {
                            list2.add(null);
                        }
                    }
                    if (list2 != null) {
                        list2.add(obj);
                    }
                }
            }
        } else {
            list = null;
            list2 = list;
        }
        if (list == null && list2 == null) {
            this.f11304C = null;
        } else {
            this.f11304C = new FragmentManagerNonConfig(list, list2);
        }
    }

    private void m9860l(Fragment fragment) {
        if (fragment.mInnerView != null) {
            if (this.f11302A == null) {
                this.f11302A = new SparseArray();
            } else {
                this.f11302A.clear();
            }
            fragment.mInnerView.saveHierarchyState(this.f11302A);
            if (this.f11302A.size() > 0) {
                fragment.mSavedViewState = this.f11302A;
                this.f11302A = null;
            }
        }
    }

    private Bundle m9861m(Fragment fragment) {
        Bundle bundle;
        if (this.f11330z == null) {
            this.f11330z = new Bundle();
        }
        fragment.performSaveInstanceState(this.f11330z);
        m9851d(fragment, this.f11330z, false);
        if (this.f11330z.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.f11330z;
            this.f11330z = null;
        }
        if (fragment.mView != null) {
            m9860l(fragment);
        }
        if (fragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
        }
        if (!fragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
        }
        return bundle;
    }

    final Parcelable m9913j() {
        m9866w();
        int i = 0;
        int size = this.f11311f == null ? 0 : this.f11311f.size();
        int i2 = 0;
        while (true) {
            BackStackState[] backStackStateArr = null;
            if (i2 >= size) {
                break;
            }
            Fragment fragment = (Fragment) this.f11311f.valueAt(i2);
            if (fragment != null) {
                if (fragment.getAnimatingAway() != null) {
                    int stateAfterAnimating = fragment.getStateAfterAnimating();
                    View animatingAway = fragment.getAnimatingAway();
                    Animation animation = animatingAway.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        animatingAway.clearAnimation();
                    }
                    fragment.setAnimatingAway(null);
                    m9880a(fragment, stateAfterAnimating, 0, 0, false);
                } else if (fragment.getAnimator() != null) {
                    fragment.getAnimator().end();
                }
            }
            i2++;
        }
        m9912i();
        this.f11323s = true;
        this.f11304C = null;
        if (this.f11311f != null) {
            if (this.f11311f.size() > 0) {
                i2 = this.f11311f.size();
                FragmentState[] fragmentStateArr = new FragmentState[i2];
                int i3 = 0;
                int i4 = i3;
                while (i3 < i2) {
                    Fragment fragment2 = (Fragment) this.f11311f.valueAt(i3);
                    if (fragment2 != null) {
                        StringBuilder stringBuilder;
                        if (fragment2.mIndex < 0) {
                            StringBuilder stringBuilder2 = new StringBuilder("Failure saving state: active ");
                            stringBuilder2.append(fragment2);
                            stringBuilder2.append(" has cleared index: ");
                            stringBuilder2.append(fragment2.mIndex);
                            m9836a(new IllegalStateException(stringBuilder2.toString()));
                        }
                        FragmentState fragmentState = new FragmentState(fragment2);
                        fragmentStateArr[i3] = fragmentState;
                        if (fragment2.mState <= 0 || fragmentState.f1014k != null) {
                            fragmentState.f1014k = fragment2.mSavedFragmentState;
                        } else {
                            fragmentState.f1014k = m9861m(fragment2);
                            if (fragment2.mTarget != null) {
                                if (fragment2.mTarget.mIndex < 0) {
                                    stringBuilder = new StringBuilder("Failure saving state: ");
                                    stringBuilder.append(fragment2);
                                    stringBuilder.append(" has target not in fragment manager: ");
                                    stringBuilder.append(fragment2.mTarget);
                                    m9836a(new IllegalStateException(stringBuilder.toString()));
                                }
                                if (fragmentState.f1014k == null) {
                                    fragmentState.f1014k = new Bundle();
                                }
                                mo220a(fragmentState.f1014k, "android:target_state", fragment2.mTarget);
                                if (fragment2.mTargetRequestCode != 0) {
                                    fragmentState.f1014k.putInt("android:target_req_state", fragment2.mTargetRequestCode);
                                }
                            }
                        }
                        if (f11300a) {
                            stringBuilder = new StringBuilder("Saved state of ");
                            stringBuilder.append(fragment2);
                            stringBuilder.append(": ");
                            stringBuilder.append(fragmentState.f1014k);
                            Log.v("FragmentManager", stringBuilder.toString());
                        }
                        i4 = true;
                    }
                    i3++;
                }
                if (i4 == 0) {
                    if (f11300a) {
                        Log.v("FragmentManager", "saveAllState: no fragments!");
                    }
                    return null;
                }
                int[] iArr;
                size = this.f11310e.size();
                if (size > 0) {
                    iArr = new int[size];
                    for (i3 = 0; i3 < size; i3++) {
                        StringBuilder stringBuilder3;
                        iArr[i3] = ((Fragment) this.f11310e.get(i3)).mIndex;
                        if (iArr[i3] < 0) {
                            stringBuilder3 = new StringBuilder("Failure saving state: active ");
                            stringBuilder3.append(this.f11310e.get(i3));
                            stringBuilder3.append(" has cleared index: ");
                            stringBuilder3.append(iArr[i3]);
                            m9836a(new IllegalStateException(stringBuilder3.toString()));
                        }
                        if (f11300a) {
                            stringBuilder3 = new StringBuilder("saveAllState: adding fragment #");
                            stringBuilder3.append(i3);
                            stringBuilder3.append(": ");
                            stringBuilder3.append(this.f11310e.get(i3));
                            Log.v("FragmentManager", stringBuilder3.toString());
                        }
                    }
                } else {
                    iArr = null;
                }
                if (this.f11312g != null) {
                    size = this.f11312g.size();
                    if (size > 0) {
                        backStackStateArr = new BackStackState[size];
                        while (i < size) {
                            backStackStateArr[i] = new BackStackState((BackStackRecord) this.f11312g.get(i));
                            if (f11300a) {
                                StringBuilder stringBuilder4 = new StringBuilder("saveAllState: adding back stack #");
                                stringBuilder4.append(i);
                                stringBuilder4.append(": ");
                                stringBuilder4.append(this.f11312g.get(i));
                                Log.v("FragmentManager", stringBuilder4.toString());
                            }
                            i++;
                        }
                    }
                }
                Parcelable fragmentManagerState = new FragmentManagerState();
                fragmentManagerState.f999a = fragmentStateArr;
                fragmentManagerState.f1000b = iArr;
                fragmentManagerState.f1001c = backStackStateArr;
                if (this.f11321p != null) {
                    fragmentManagerState.f1002d = this.f11321p.mIndex;
                }
                fragmentManagerState.f1003e = this.f11309d;
                m9869z();
                return fragmentManagerState;
            }
        }
        return null;
    }

    final void m9879a(Parcelable parcelable, FragmentManagerNonConfig fragmentManagerNonConfig) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.f999a != null) {
                List list;
                StringBuilder stringBuilder;
                if (fragmentManagerNonConfig != null) {
                    List list2 = fragmentManagerNonConfig.f997a;
                    list = fragmentManagerNonConfig.f998b;
                    int size = list2 != null ? list2.size() : 0;
                    for (int i = 0; i < size; i++) {
                        Fragment fragment = (Fragment) list2.get(i);
                        if (f11300a) {
                            StringBuilder stringBuilder2 = new StringBuilder("restoreAllState: re-attaching retained ");
                            stringBuilder2.append(fragment);
                            Log.v("FragmentManager", stringBuilder2.toString());
                        }
                        int i2 = 0;
                        while (i2 < fragmentManagerState.f999a.length && fragmentManagerState.f999a[i2].f1005b != fragment.mIndex) {
                            i2++;
                        }
                        if (i2 == fragmentManagerState.f999a.length) {
                            StringBuilder stringBuilder3 = new StringBuilder("Could not find active fragment with index ");
                            stringBuilder3.append(fragment.mIndex);
                            m9836a(new IllegalStateException(stringBuilder3.toString()));
                        }
                        FragmentState fragmentState = fragmentManagerState.f999a[i2];
                        fragmentState.f1015l = fragment;
                        fragment.mSavedViewState = null;
                        fragment.mBackStackNesting = 0;
                        fragment.mInLayout = false;
                        fragment.mAdded = false;
                        fragment.mTarget = null;
                        if (fragmentState.f1014k != null) {
                            fragmentState.f1014k.setClassLoader(this.f11318m.f11275c.getClassLoader());
                            fragment.mSavedViewState = fragmentState.f1014k.getSparseParcelableArray("android:view_state");
                            fragment.mSavedFragmentState = fragmentState.f1014k;
                        }
                    }
                } else {
                    list = null;
                }
                this.f11311f = new SparseArray(fragmentManagerState.f999a.length);
                int i3 = 0;
                while (i3 < fragmentManagerState.f999a.length) {
                    FragmentState fragmentState2 = fragmentManagerState.f999a[i3];
                    if (fragmentState2 != null) {
                        FragmentManagerNonConfig fragmentManagerNonConfig2 = (list == null || i3 >= list.size()) ? null : (FragmentManagerNonConfig) list.get(i3);
                        FragmentHostCallback fragmentHostCallback = this.f11318m;
                        FragmentContainer fragmentContainer = this.f11319n;
                        Fragment fragment2 = this.f11320o;
                        if (fragmentState2.f1015l == null) {
                            Context context = fragmentHostCallback.f11275c;
                            if (fragmentState2.f1012i != null) {
                                fragmentState2.f1012i.setClassLoader(context.getClassLoader());
                            }
                            if (fragmentContainer != null) {
                                fragmentState2.f1015l = fragmentContainer.mo208a(context, fragmentState2.f1004a, fragmentState2.f1012i);
                            } else {
                                fragmentState2.f1015l = Fragment.instantiate(context, fragmentState2.f1004a, fragmentState2.f1012i);
                            }
                            if (fragmentState2.f1014k != null) {
                                fragmentState2.f1014k.setClassLoader(context.getClassLoader());
                                fragmentState2.f1015l.mSavedFragmentState = fragmentState2.f1014k;
                            }
                            fragmentState2.f1015l.setIndex(fragmentState2.f1005b, fragment2);
                            fragmentState2.f1015l.mFromLayout = fragmentState2.f1006c;
                            fragmentState2.f1015l.mRestored = true;
                            fragmentState2.f1015l.mFragmentId = fragmentState2.f1007d;
                            fragmentState2.f1015l.mContainerId = fragmentState2.f1008e;
                            fragmentState2.f1015l.mTag = fragmentState2.f1009f;
                            fragmentState2.f1015l.mRetainInstance = fragmentState2.f1010g;
                            fragmentState2.f1015l.mDetached = fragmentState2.f1011h;
                            fragmentState2.f1015l.mHidden = fragmentState2.f1013j;
                            fragmentState2.f1015l.mFragmentManager = fragmentHostCallback.f11278f;
                            if (f11300a) {
                                stringBuilder = new StringBuilder("Instantiated fragment ");
                                stringBuilder.append(fragmentState2.f1015l);
                                Log.v("FragmentManager", stringBuilder.toString());
                            }
                        }
                        fragmentState2.f1015l.mChildNonConfig = fragmentManagerNonConfig2;
                        Fragment fragment3 = fragmentState2.f1015l;
                        if (f11300a) {
                            stringBuilder = new StringBuilder("restoreAllState: active #");
                            stringBuilder.append(i3);
                            stringBuilder.append(": ");
                            stringBuilder.append(fragment3);
                            Log.v("FragmentManager", stringBuilder.toString());
                        }
                        this.f11311f.put(fragment3.mIndex, fragment3);
                        fragmentState2.f1015l = null;
                    }
                    i3++;
                }
                if (fragmentManagerNonConfig != null) {
                    fragmentManagerNonConfig = fragmentManagerNonConfig.f997a;
                    i3 = fragmentManagerNonConfig != null ? fragmentManagerNonConfig.size() : 0;
                    for (int i4 = 0; i4 < i3; i4++) {
                        Fragment fragment4 = (Fragment) fragmentManagerNonConfig.get(i4);
                        if (fragment4.mTargetIndex >= 0) {
                            fragment4.mTarget = (Fragment) this.f11311f.get(fragment4.mTargetIndex);
                            if (fragment4.mTarget == null) {
                                stringBuilder = new StringBuilder("Re-attaching retained fragment ");
                                stringBuilder.append(fragment4);
                                stringBuilder.append(" target no longer exists: ");
                                stringBuilder.append(fragment4.mTargetIndex);
                                Log.w("FragmentManager", stringBuilder.toString());
                            }
                        }
                    }
                }
                this.f11310e.clear();
                if (fragmentManagerState.f1000b != null) {
                    for (fragmentManagerNonConfig = null; fragmentManagerNonConfig < fragmentManagerState.f1000b.length; fragmentManagerNonConfig++) {
                        StringBuilder stringBuilder4;
                        Fragment fragment5 = (Fragment) this.f11311f.get(fragmentManagerState.f1000b[fragmentManagerNonConfig]);
                        if (fragment5 == null) {
                            stringBuilder4 = new StringBuilder("No instantiated fragment for index #");
                            stringBuilder4.append(fragmentManagerState.f1000b[fragmentManagerNonConfig]);
                            m9836a(new IllegalStateException(stringBuilder4.toString()));
                        }
                        fragment5.mAdded = true;
                        if (f11300a) {
                            stringBuilder4 = new StringBuilder("restoreAllState: added #");
                            stringBuilder4.append(fragmentManagerNonConfig);
                            stringBuilder4.append(": ");
                            stringBuilder4.append(fragment5);
                            Log.v("FragmentManager", stringBuilder4.toString());
                        }
                        if (this.f11310e.contains(fragment5)) {
                            throw new IllegalStateException("Already added!");
                        }
                        synchronized (this.f11310e) {
                            this.f11310e.add(fragment5);
                        }
                    }
                }
                if (fragmentManagerState.f1001c != null) {
                    this.f11312g = new ArrayList(fragmentManagerState.f1001c.length);
                    for (fragmentManagerNonConfig = null; fragmentManagerNonConfig < fragmentManagerState.f1001c.length; fragmentManagerNonConfig++) {
                        BackStackRecord a = fragmentManagerState.f1001c[fragmentManagerNonConfig].m523a(this);
                        if (f11300a) {
                            StringBuilder stringBuilder5 = new StringBuilder("restoreAllState: back stack #");
                            stringBuilder5.append(fragmentManagerNonConfig);
                            stringBuilder5.append(" (index ");
                            stringBuilder5.append(a.f11264m);
                            stringBuilder5.append("): ");
                            stringBuilder5.append(a);
                            Log.v("FragmentManager", stringBuilder5.toString());
                            PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
                            a.m9779a("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.f11312g.add(a);
                        if (a.f11264m >= 0) {
                            m9827a(a.f11264m, a);
                        }
                    }
                } else {
                    this.f11312g = null;
                }
                if (fragmentManagerState.f1002d >= null) {
                    this.f11321p = (Fragment) this.f11311f.get(fragmentManagerState.f1002d);
                }
                this.f11309d = fragmentManagerState.f1003e;
            }
        }
    }

    private void m9821A() {
        if (this.f11311f != null) {
            for (int size = this.f11311f.size() - 1; size >= 0; size--) {
                if (this.f11311f.valueAt(size) == null) {
                    this.f11311f.delete(this.f11311f.keyAt(size));
                }
            }
        }
    }

    public final void m9882a(FragmentHostCallback fragmentHostCallback, FragmentContainer fragmentContainer, Fragment fragment) {
        if (this.f11318m != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f11318m = fragmentHostCallback;
        this.f11319n = fragmentContainer;
        this.f11320o = fragment;
    }

    public final void m9915k() {
        this.f11304C = null;
        int i = 0;
        this.f11323s = false;
        int size = this.f11310e.size();
        while (i < size) {
            Fragment fragment = (Fragment) this.f11310e.get(i);
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
            i++;
        }
    }

    public final void m9916l() {
        this.f11323s = false;
        m9901c(1);
    }

    public final void m9917m() {
        this.f11323s = false;
        m9901c(2);
    }

    public final void m9918n() {
        this.f11323s = false;
        m9901c(4);
    }

    public final void m9919o() {
        this.f11323s = false;
        m9901c(5);
    }

    public final void m9920p() {
        this.f11323s = true;
        m9901c(3);
    }

    public final void m9921q() {
        this.f11324t = true;
        m9912i();
        m9901c(0);
        this.f11318m = null;
        this.f11319n = null;
        this.f11320o = null;
    }

    final void m9901c(int i) {
        try {
            this.f11308c = true;
            m9876a(i, false);
            m9912i();
        } finally {
            this.f11308c = false;
        }
    }

    public final void m9886a(boolean z) {
        for (int size = this.f11310e.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.f11310e.get(size);
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z);
            }
        }
    }

    public final void m9896b(boolean z) {
        for (int size = this.f11310e.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.f11310e.get(size);
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z);
            }
        }
    }

    public final void m9877a(Configuration configuration) {
        for (int i = 0; i < this.f11310e.size(); i++) {
            Fragment fragment = (Fragment) this.f11310e.get(i);
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    public final void m9922r() {
        for (int i = 0; i < this.f11310e.size(); i++) {
            Fragment fragment = (Fragment) this.f11310e.get(i);
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    public final boolean m9888a(Menu menu, MenuInflater menuInflater) {
        int i = 0;
        if (this.f11317l <= 0) {
            return false;
        }
        ArrayList arrayList = null;
        int i2 = 0;
        boolean z = i2;
        while (i2 < this.f11310e.size()) {
            Fragment fragment = (Fragment) this.f11310e.get(i2);
            if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(fragment);
                z = true;
            }
            i2++;
        }
        if (this.f11313h != null) {
            while (i < this.f11313h.size()) {
                Fragment fragment2 = (Fragment) this.f11313h.get(i);
                if (arrayList == null || arrayList.contains(fragment2) == null) {
                    fragment2.onDestroyOptionsMenu();
                }
                i++;
            }
        }
        this.f11313h = arrayList;
        return z;
    }

    public final boolean m9887a(Menu menu) {
        int i = 0;
        if (this.f11317l <= 0) {
            return false;
        }
        boolean z = false;
        while (i < this.f11310e.size()) {
            Fragment fragment = (Fragment) this.f11310e.get(i);
            if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
            i++;
        }
        return z;
    }

    public final boolean m9889a(MenuItem menuItem) {
        if (this.f11317l <= 0) {
            return false;
        }
        for (int i = 0; i < this.f11310e.size(); i++) {
            Fragment fragment = (Fragment) this.f11310e.get(i);
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final boolean m9898b(MenuItem menuItem) {
        if (this.f11317l <= 0) {
            return false;
        }
        for (int i = 0; i < this.f11310e.size(); i++) {
            Fragment fragment = (Fragment) this.f11310e.get(i);
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void m9894b(Menu menu) {
        if (this.f11317l > 0) {
            for (int i = 0; i < this.f11310e.size(); i++) {
                Fragment fragment = (Fragment) this.f11310e.get(i);
                if (fragment != null) {
                    fragment.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    public final void m9914j(Fragment fragment) {
        if (fragment == null || (this.f11311f.get(fragment.mIndex) == fragment && (fragment.mHost == null || fragment.getFragmentManager() == this))) {
            this.f11321p = fragment;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Fragment ");
        stringBuilder.append(fragment);
        stringBuilder.append(" is not an active fragment of FragmentManager ");
        stringBuilder.append(this);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private void m9828a(Fragment fragment, Context context, boolean z) {
        if (this.f11320o != null) {
            FragmentManager fragmentManager = this.f11320o.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m9828a(fragment, context, true);
            }
        }
        fragment = this.f11306I.iterator();
        while (fragment.hasNext() != null) {
            Pair pair = (Pair) fragment.next();
            if (z) {
                ((Boolean) pair.f1411b).booleanValue();
            }
        }
    }

    private void m9840b(Fragment fragment, Context context, boolean z) {
        if (this.f11320o != null) {
            FragmentManager fragmentManager = this.f11320o.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m9840b(fragment, context, true);
            }
        }
        fragment = this.f11306I.iterator();
        while (fragment.hasNext() != null) {
            Pair pair = (Pair) fragment.next();
            if (z) {
                ((Boolean) pair.f1411b).booleanValue();
            }
        }
    }

    private void m9829a(Fragment fragment, Bundle bundle, boolean z) {
        if (this.f11320o != null) {
            FragmentManager fragmentManager = this.f11320o.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m9829a(fragment, bundle, true);
            }
        }
        fragment = this.f11306I.iterator();
        while (fragment.hasNext() != null) {
            Pair pair = (Pair) fragment.next();
            if (z) {
                ((Boolean) pair.f1411b).booleanValue();
            }
        }
    }

    private void m9841b(Fragment fragment, Bundle bundle, boolean z) {
        if (this.f11320o != null) {
            FragmentManager fragmentManager = this.f11320o.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m9841b(fragment, bundle, true);
            }
        }
        fragment = this.f11306I.iterator();
        while (fragment.hasNext() != null) {
            Pair pair = (Pair) fragment.next();
            if (z) {
                ((Boolean) pair.f1411b).booleanValue();
            }
        }
    }

    private void m9846c(Fragment fragment, Bundle bundle, boolean z) {
        if (this.f11320o != null) {
            FragmentManager fragmentManager = this.f11320o.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m9846c(fragment, bundle, true);
            }
        }
        fragment = this.f11306I.iterator();
        while (fragment.hasNext() != null) {
            Pair pair = (Pair) fragment.next();
            if (z) {
                ((Boolean) pair.f1411b).booleanValue();
            }
        }
    }

    private void m9830a(Fragment fragment, View view, Bundle bundle, boolean z) {
        if (this.f11320o != null) {
            FragmentManager fragmentManager = this.f11320o.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m9830a(fragment, view, bundle, true);
            }
        }
        fragment = this.f11306I.iterator();
        while (fragment.hasNext() != null) {
            Pair pair = (Pair) fragment.next();
            if (z) {
                ((Boolean) pair.f1411b).booleanValue();
            }
        }
    }

    private void m9842b(Fragment fragment, boolean z) {
        if (this.f11320o != null) {
            FragmentManager fragmentManager = this.f11320o.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m9842b(fragment, true);
            }
        }
        fragment = this.f11306I.iterator();
        while (fragment.hasNext()) {
            Pair pair = (Pair) fragment.next();
            if (z) {
                ((Boolean) pair.f1411b).booleanValue();
            }
        }
    }

    private void m9847c(Fragment fragment, boolean z) {
        if (this.f11320o != null) {
            FragmentManager fragmentManager = this.f11320o.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m9847c(fragment, true);
            }
        }
        fragment = this.f11306I.iterator();
        while (fragment.hasNext()) {
            Pair pair = (Pair) fragment.next();
            if (z) {
                ((Boolean) pair.f1411b).booleanValue();
            }
        }
    }

    private void m9852d(Fragment fragment, boolean z) {
        if (this.f11320o != null) {
            FragmentManager fragmentManager = this.f11320o.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m9852d(fragment, true);
            }
        }
        fragment = this.f11306I.iterator();
        while (fragment.hasNext()) {
            Pair pair = (Pair) fragment.next();
            if (z) {
                ((Boolean) pair.f1411b).booleanValue();
            }
        }
    }

    private void m9853e(Fragment fragment, boolean z) {
        if (this.f11320o != null) {
            FragmentManager fragmentManager = this.f11320o.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m9853e(fragment, true);
            }
        }
        fragment = this.f11306I.iterator();
        while (fragment.hasNext()) {
            Pair pair = (Pair) fragment.next();
            if (z) {
                ((Boolean) pair.f1411b).booleanValue();
            }
        }
    }

    private void m9851d(Fragment fragment, Bundle bundle, boolean z) {
        if (this.f11320o != null) {
            FragmentManager fragmentManager = this.f11320o.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m9851d(fragment, bundle, true);
            }
        }
        fragment = this.f11306I.iterator();
        while (fragment.hasNext() != null) {
            Pair pair = (Pair) fragment.next();
            if (z) {
                ((Boolean) pair.f1411b).booleanValue();
            }
        }
    }

    private void m9855f(Fragment fragment, boolean z) {
        if (this.f11320o != null) {
            FragmentManager fragmentManager = this.f11320o.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m9855f(fragment, true);
            }
        }
        fragment = this.f11306I.iterator();
        while (fragment.hasNext()) {
            Pair pair = (Pair) fragment.next();
            if (z) {
                ((Boolean) pair.f1411b).booleanValue();
            }
        }
    }

    private void m9857g(Fragment fragment, boolean z) {
        if (this.f11320o != null) {
            FragmentManager fragmentManager = this.f11320o.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m9857g(fragment, true);
            }
        }
        fragment = this.f11306I.iterator();
        while (fragment.hasNext()) {
            Pair pair = (Pair) fragment.next();
            if (z) {
                ((Boolean) pair.f1411b).booleanValue();
            }
        }
    }

    private void m9858h(Fragment fragment, boolean z) {
        if (this.f11320o != null) {
            FragmentManager fragmentManager = this.f11320o.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).m9858h(fragment, true);
            }
        }
        fragment = this.f11306I.iterator();
        while (fragment.hasNext()) {
            Pair pair = (Pair) fragment.next();
            if (z) {
                ((Boolean) pair.f1411b).booleanValue();
            }
        }
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        FragmentManagerImpl fragmentManagerImpl = this;
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet2.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet2, FragmentTag.f996a);
        int i = 0;
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        String str2 = attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.isSupportFragmentClass(fragmentManagerImpl.f11318m.f11275c, str2)) {
            return null;
        }
        if (view != null) {
            i = view.getId();
        }
        if (i == -1 && resourceId == -1 && string == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(attributeSet.getPositionDescription());
            stringBuilder.append(": Must specify unique android:id, android:tag, or have a parent with an id for ");
            stringBuilder.append(str2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        Fragment fragment;
        Fragment a = resourceId != -1 ? mo216a(resourceId) : null;
        if (a == null && string != null) {
            a = mo218a(string);
        }
        if (a == null && i != -1) {
            a = mo216a(i);
        }
        if (f11300a) {
            StringBuilder stringBuilder2 = new StringBuilder("onCreateView: id=0x");
            stringBuilder2.append(Integer.toHexString(resourceId));
            stringBuilder2.append(" fname=");
            stringBuilder2.append(str2);
            stringBuilder2.append(" existing=");
            stringBuilder2.append(a);
            Log.v("FragmentManager", stringBuilder2.toString());
        }
        if (a == null) {
            Fragment a2 = fragmentManagerImpl.f11319n.mo208a(context2, str2, null);
            a2.mFromLayout = true;
            a2.mFragmentId = resourceId != 0 ? resourceId : i;
            a2.mContainerId = i;
            a2.mTag = string;
            a2.mInLayout = true;
            a2.mFragmentManager = fragmentManagerImpl;
            a2.mHost = fragmentManagerImpl.f11318m;
            a2.onInflate(fragmentManagerImpl.f11318m.f11275c, attributeSet2, a2.mSavedFragmentState);
            m9881a(a2, true);
            fragment = a2;
        } else if (a.mInLayout) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(attributeSet.getPositionDescription());
            stringBuilder.append(": Duplicate id 0x");
            stringBuilder.append(Integer.toHexString(resourceId));
            stringBuilder.append(", tag ");
            stringBuilder.append(string);
            stringBuilder.append(", or parent id 0x");
            stringBuilder.append(Integer.toHexString(i));
            stringBuilder.append(" with another fragment for ");
            stringBuilder.append(str2);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else {
            a.mInLayout = true;
            a.mHost = fragmentManagerImpl.f11318m;
            if (!a.mRetaining) {
                a.onInflate(fragmentManagerImpl.f11318m.f11275c, attributeSet2, a.mSavedFragmentState);
            }
            fragment = a;
        }
        if (fragmentManagerImpl.f11317l > 0 || !fragment.mFromLayout) {
            m9859k(fragment);
        } else {
            m9880a(fragment, 1, 0, 0, false);
        }
        if (fragment.mView == null) {
            StringBuilder stringBuilder3 = new StringBuilder("Fragment ");
            stringBuilder3.append(str2);
            stringBuilder3.append(" did not create a view.");
            throw new IllegalStateException(stringBuilder3.toString());
        }
        if (resourceId != 0) {
            fragment.mView.setId(resourceId);
        }
        if (fragment.mView.getTag() == null) {
            fragment.mView.setTag(string);
        }
        return fragment.mView;
    }

    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    private static void m9835a(View view, AnimationOrAnimator animationOrAnimator) {
        if (view != null) {
            if (animationOrAnimator != null) {
                Object obj = null;
                if (view != null) {
                    if (animationOrAnimator != null) {
                        if (VERSION.SDK_INT >= 19 && view.getLayerType() == 0 && ViewCompat.m1200A(view)) {
                            boolean z;
                            if (!(animationOrAnimator.f993a instanceof AlphaAnimation)) {
                                if (animationOrAnimator.f993a instanceof AnimationSet) {
                                    List animations = ((AnimationSet) animationOrAnimator.f993a).getAnimations();
                                    int i = 0;
                                    while (i < animations.size()) {
                                        if (!(animations.get(i) instanceof AlphaAnimation)) {
                                            i++;
                                        }
                                    }
                                    z = false;
                                } else {
                                    z = m9839a(animationOrAnimator.f994b);
                                }
                                if (z) {
                                    obj = 1;
                                }
                            }
                            z = true;
                            if (z) {
                                obj = 1;
                            }
                        }
                    }
                }
                if (obj != null) {
                    if (animationOrAnimator.f994b != null) {
                        animationOrAnimator.f994b.addListener(new AnimatorOnHWLayerIfNeededListener(view));
                        return;
                    }
                    AnimationListener a = m9826a(animationOrAnimator.f993a);
                    view.setLayerType(2, null);
                    animationOrAnimator.f993a.setAnimationListener(new AnimateOnHWLayerIfNeededListener(view, a));
                }
            }
        }
    }

    static void m9833a(FragmentManagerNonConfig fragmentManagerNonConfig) {
        if (fragmentManagerNonConfig != null) {
            List<Fragment> list = fragmentManagerNonConfig.f997a;
            if (list != null) {
                for (Fragment fragment : list) {
                    fragment.mRetaining = true;
                }
            }
            FragmentManagerNonConfig<FragmentManagerNonConfig> fragmentManagerNonConfig2 = fragmentManagerNonConfig.f998b;
            if (fragmentManagerNonConfig2 != null) {
                for (FragmentManagerNonConfig a : fragmentManagerNonConfig2) {
                    m9833a(a);
                }
            }
        }
    }

    static /* synthetic */ void m9832a(FragmentManagerImpl fragmentManagerImpl, BackStackRecord backStackRecord, boolean z, boolean z2, boolean z3) {
        if (z) {
            backStackRecord.m9780a(z3);
        } else {
            backStackRecord.m9794g();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(backStackRecord);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            FragmentTransition.m602a(fragmentManagerImpl, arrayList, arrayList2, 0, 1, true);
        }
        if (z3) {
            fragmentManagerImpl.m9876a(fragmentManagerImpl.f11317l, true);
        }
        if (fragmentManagerImpl.f11311f) {
            z = fragmentManagerImpl.f11311f.size();
            for (boolean z4 = false; z4 < z; z4++) {
                Fragment fragment = (Fragment) fragmentManagerImpl.f11311f.valueAt(z4);
                if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && backStackRecord.m9788b(fragment.mContainerId)) {
                    if (fragment.mPostponedAlpha > 0.0f) {
                        fragment.mView.setAlpha(fragment.mPostponedAlpha);
                    }
                    if (z3) {
                        fragment.mPostponedAlpha = 0.0f;
                    } else {
                        fragment.mPostponedAlpha = -1.0f;
                        fragment.mIsNewlyAdded = false;
                    }
                }
            }
        }
    }
}
