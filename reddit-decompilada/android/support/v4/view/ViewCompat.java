package android.support.v4.view;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.Display;
import android.view.PointerIcon;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

public class ViewCompat {
    static final ViewCompatBaseImpl f1462a;

    static class ViewCompatBaseImpl {
        static Field f1454b = null;
        static boolean f1455c = false;
        private static Field f1456d;
        private static boolean f1457e;
        private static Field f1458f;
        private static boolean f1459g;
        private static WeakHashMap<View, String> f1460h;
        WeakHashMap<View, ViewPropertyAnimatorCompat> f1461a = null;

        public WindowInsetsCompat mo4406a(View view, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        public void mo4407a(View view, float f) {
        }

        public void mo3134a(View view, int i) {
        }

        public void mo4220a(View view, Rect rect) {
        }

        public void mo4410a(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        }

        public void mo4447a(View view, PointerIconCompat pointerIconCompat) {
        }

        public void mo3138a(View view, boolean z) {
        }

        public boolean mo376a(View view) {
            return false;
        }

        public WindowInsetsCompat mo4412b(View view, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        public void mo4413b(View view, float f) {
        }

        public boolean mo3139b(View view) {
            return false;
        }

        public void mo4415c(View view, float f) {
        }

        public int mo3141d(View view) {
            return 0;
        }

        public void mo4445d(View view, int i) {
        }

        public void mo3145h(View view) {
        }

        public boolean mo3146i(View view) {
            return false;
        }

        public boolean mo3147j(View view) {
            return true;
        }

        public int mo3837k(View view) {
            return 0;
        }

        public int mo3840n(View view) {
            return 0;
        }

        public boolean mo3841o(View view) {
            return false;
        }

        public Rect mo4221q(View view) {
            return null;
        }

        public void mo4366r(View view) {
        }

        public float mo4418v(View view) {
            return 0.0f;
        }

        public float mo4419w(View view) {
            return 0.0f;
        }

        ViewCompatBaseImpl() {
        }

        public static boolean m1148C(android.view.View r4) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = f1455c;
            r1 = 0;
            if (r0 == 0) goto L_0x0006;
        L_0x0005:
            return r1;
        L_0x0006:
            r0 = f1454b;
            r2 = 1;
            if (r0 != 0) goto L_0x001c;
        L_0x000b:
            r0 = android.view.View.class;	 Catch:{ Throwable -> 0x0019 }
            r3 = "mAccessibilityDelegate";	 Catch:{ Throwable -> 0x0019 }
            r0 = r0.getDeclaredField(r3);	 Catch:{ Throwable -> 0x0019 }
            f1454b = r0;	 Catch:{ Throwable -> 0x0019 }
            r0.setAccessible(r2);	 Catch:{ Throwable -> 0x0019 }
            goto L_0x001c;
        L_0x0019:
            f1455c = r2;
            return r1;
        L_0x001c:
            r0 = f1454b;	 Catch:{ Throwable -> 0x0026 }
            r4 = r0.get(r4);	 Catch:{ Throwable -> 0x0026 }
            if (r4 == 0) goto L_0x0025;
        L_0x0024:
            return r2;
        L_0x0025:
            return r1;
        L_0x0026:
            f1455c = r2;
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewCompat.ViewCompatBaseImpl.C(android.view.View):boolean");
        }

        public void mo3140c(View view) {
            view.postInvalidate();
        }

        public ViewParent mo3142e(View view) {
            return view.getParent();
        }

        public int mo3838l(View view) {
            return view.getPaddingLeft();
        }

        public int mo3839m(View view) {
            return view.getPaddingRight();
        }

        public void mo3836a(View view, int i, int i2, int i3, int i4) {
            view.setPadding(i, i2, i3, i4);
        }

        public int mo3143f(android.view.View r4) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = f1457e;
            if (r0 != 0) goto L_0x0014;
        L_0x0004:
            r0 = 1;
            r1 = android.view.View.class;	 Catch:{ NoSuchFieldException -> 0x0012 }
            r2 = "mMinWidth";	 Catch:{ NoSuchFieldException -> 0x0012 }
            r1 = r1.getDeclaredField(r2);	 Catch:{ NoSuchFieldException -> 0x0012 }
            f1456d = r1;	 Catch:{ NoSuchFieldException -> 0x0012 }
            r1.setAccessible(r0);	 Catch:{ NoSuchFieldException -> 0x0012 }
        L_0x0012:
            f1457e = r0;
        L_0x0014:
            r0 = f1456d;
            if (r0 == 0) goto L_0x0025;
        L_0x0018:
            r0 = f1456d;	 Catch:{ Exception -> 0x0025 }
            r4 = r0.get(r4);	 Catch:{ Exception -> 0x0025 }
            r4 = (java.lang.Integer) r4;	 Catch:{ Exception -> 0x0025 }
            r4 = r4.intValue();	 Catch:{ Exception -> 0x0025 }
            return r4;
        L_0x0025:
            r4 = 0;
            return r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewCompat.ViewCompatBaseImpl.f(android.view.View):int");
        }

        public int mo3144g(android.view.View r4) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = f1459g;
            if (r0 != 0) goto L_0x0014;
        L_0x0004:
            r0 = 1;
            r1 = android.view.View.class;	 Catch:{ NoSuchFieldException -> 0x0012 }
            r2 = "mMinHeight";	 Catch:{ NoSuchFieldException -> 0x0012 }
            r1 = r1.getDeclaredField(r2);	 Catch:{ NoSuchFieldException -> 0x0012 }
            f1458f = r1;	 Catch:{ NoSuchFieldException -> 0x0012 }
            r1.setAccessible(r0);	 Catch:{ NoSuchFieldException -> 0x0012 }
        L_0x0012:
            f1459g = r0;
        L_0x0014:
            r0 = f1458f;
            if (r0 == 0) goto L_0x0025;
        L_0x0018:
            r0 = f1458f;	 Catch:{ Exception -> 0x0025 }
            r4 = r0.get(r4);	 Catch:{ Exception -> 0x0025 }
            r4 = (java.lang.Integer) r4;	 Catch:{ Exception -> 0x0025 }
            r4 = r4.intValue();	 Catch:{ Exception -> 0x0025 }
            return r4;
        L_0x0025:
            r4 = 0;
            return r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewCompat.ViewCompatBaseImpl.g(android.view.View):int");
        }

        public void mo4411a(View view, String str) {
            if (f1460h == null) {
                f1460h = new WeakHashMap();
            }
            f1460h.put(view, str);
        }

        public String mo4417u(View view) {
            if (f1460h == null) {
                return null;
            }
            return (String) f1460h.get(view);
        }

        public boolean mo4420x(View view) {
            return view instanceof NestedScrollingChild ? ((NestedScrollingChild) view).isNestedScrollingEnabled() : null;
        }

        public void mo3135a(View view, Drawable drawable) {
            view.setBackgroundDrawable(drawable);
        }

        public ColorStateList mo4422z(View view) {
            return view instanceof TintableBackgroundView ? ((TintableBackgroundView) view).getSupportBackgroundTintList() : null;
        }

        public void mo4408a(View view, ColorStateList colorStateList) {
            if (view instanceof TintableBackgroundView) {
                ((TintableBackgroundView) view).setSupportBackgroundTintList(colorStateList);
            }
        }

        public void mo4409a(View view, Mode mode) {
            if (view instanceof TintableBackgroundView) {
                ((TintableBackgroundView) view).setSupportBackgroundTintMode(mode);
            }
        }

        public Mode mo4404A(View view) {
            return view instanceof TintableBackgroundView ? ((TintableBackgroundView) view).getSupportBackgroundTintMode() : null;
        }

        public void mo4421y(View view) {
            if (view instanceof NestedScrollingChild) {
                ((NestedScrollingChild) view).stopNestedScroll();
            }
        }

        public boolean mo4367s(View view) {
            return (view.getWidth() <= 0 || view.getHeight() <= null) ? null : true;
        }

        public float mo4405B(View view) {
            return mo4419w(view) + mo4418v(view);
        }

        public boolean mo4368t(View view) {
            return view.getWindowToken() != null ? true : null;
        }

        public void mo4414b(View view, int i) {
            view.offsetLeftAndRight(i);
            if (view.getVisibility() == 0) {
                m1149D(view);
                view = view.getParent();
                if ((view instanceof View) != 0) {
                    m1149D(view);
                }
            }
        }

        public void mo4416c(View view, int i) {
            view.offsetTopAndBottom(i);
            if (view.getVisibility() == 0) {
                m1149D(view);
                view = view.getParent();
                if ((view instanceof View) != 0) {
                    m1149D(view);
                }
            }
        }

        private static void m1149D(View view) {
            float translationY = view.getTranslationY();
            view.setTranslationY(1.0f + translationY);
            view.setTranslationY(translationY);
        }

        public Display mo3842p(View view) {
            return mo4368t(view) ? ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay() : null;
        }

        public static void m1150a(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
            view.setAccessibilityDelegate(accessibilityDelegateCompat == null ? null : accessibilityDelegateCompat.f1432b);
        }

        public static void m1151a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat.f1523a);
        }

        public void mo3136a(View view, Runnable runnable) {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }

        public void mo3137a(View view, Runnable runnable, long j) {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j);
        }
    }

    @RequiresApi(15)
    static class ViewCompatApi15Impl extends ViewCompatBaseImpl {
        ViewCompatApi15Impl() {
        }

        public final boolean mo376a(View view) {
            return view.hasOnClickListeners();
        }
    }

    @RequiresApi(16)
    static class ViewCompatApi16Impl extends ViewCompatApi15Impl {
        ViewCompatApi16Impl() {
        }

        public final boolean mo3139b(View view) {
            return view.hasTransientState();
        }

        public final void mo3138a(View view, boolean z) {
            view.setHasTransientState(z);
        }

        public final void mo3140c(View view) {
            view.postInvalidateOnAnimation();
        }

        public final void mo3136a(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        public final void mo3137a(View view, Runnable runnable, long j) {
            view.postOnAnimationDelayed(runnable, j);
        }

        public final int mo3141d(View view) {
            return view.getImportantForAccessibility();
        }

        public void mo3134a(View view, int i) {
            if (i == 4) {
                i = 2;
            }
            view.setImportantForAccessibility(i);
        }

        public final ViewParent mo3142e(View view) {
            return view.getParentForAccessibility();
        }

        public final int mo3143f(View view) {
            return view.getMinimumWidth();
        }

        public final int mo3144g(View view) {
            return view.getMinimumHeight();
        }

        public void mo3145h(View view) {
            view.requestFitSystemWindows();
        }

        public final boolean mo3146i(View view) {
            return view.getFitsSystemWindows();
        }

        public final boolean mo3147j(View view) {
            return view.hasOverlappingRendering();
        }

        public final void mo3135a(View view, Drawable drawable) {
            view.setBackground(drawable);
        }
    }

    @RequiresApi(17)
    static class ViewCompatApi17Impl extends ViewCompatApi16Impl {
        ViewCompatApi17Impl() {
        }

        public final int mo3837k(View view) {
            return view.getLayoutDirection();
        }

        public final int mo3838l(View view) {
            return view.getPaddingStart();
        }

        public final int mo3839m(View view) {
            return view.getPaddingEnd();
        }

        public final void mo3836a(View view, int i, int i2, int i3, int i4) {
            view.setPaddingRelative(i, i2, i3, i4);
        }

        public final int mo3840n(View view) {
            return view.getWindowSystemUiVisibility();
        }

        public final boolean mo3841o(View view) {
            return view.isPaddingRelative();
        }

        public final Display mo3842p(View view) {
            return view.getDisplay();
        }
    }

    @RequiresApi(18)
    static class ViewCompatApi18Impl extends ViewCompatApi17Impl {
        ViewCompatApi18Impl() {
        }

        public final void mo4220a(View view, Rect rect) {
            view.setClipBounds(rect);
        }

        public final Rect mo4221q(View view) {
            return view.getClipBounds();
        }
    }

    @RequiresApi(19)
    static class ViewCompatApi19Impl extends ViewCompatApi18Impl {
        ViewCompatApi19Impl() {
        }

        public final void mo4366r(View view) {
            view.setAccessibilityLiveRegion(1);
        }

        public final void mo3134a(View view, int i) {
            view.setImportantForAccessibility(i);
        }

        public final boolean mo4367s(View view) {
            return view.isLaidOut();
        }

        public final boolean mo4368t(View view) {
            return view.isAttachedToWindow();
        }
    }

    @RequiresApi(21)
    static class ViewCompatApi21Impl extends ViewCompatApi19Impl {
        private static ThreadLocal<Rect> f19832d;

        ViewCompatApi21Impl() {
        }

        public final void mo4411a(View view, String str) {
            view.setTransitionName(str);
        }

        public final String mo4417u(View view) {
            return view.getTransitionName();
        }

        public final void mo3145h(View view) {
            view.requestApplyInsets();
        }

        public final void mo4407a(View view, float f) {
            view.setElevation(f);
        }

        public final float mo4418v(View view) {
            return view.getElevation();
        }

        public final void mo4413b(View view, float f) {
            view.setTranslationZ(f);
        }

        public final float mo4419w(View view) {
            return view.getTranslationZ();
        }

        public final void mo4410a(View view, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            if (onApplyWindowInsetsListener == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                view.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener(this) {
                    final /* synthetic */ ViewCompatApi21Impl f1453b;

                    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        return (WindowInsets) WindowInsetsCompat.m1306a(onApplyWindowInsetsListener.mo56a(view, WindowInsetsCompat.m1305a((Object) windowInsets)));
                    }
                });
            }
        }

        public final boolean mo4420x(View view) {
            return view.isNestedScrollingEnabled();
        }

        public final void mo4421y(View view) {
            view.stopNestedScroll();
        }

        public final ColorStateList mo4422z(View view) {
            return view.getBackgroundTintList();
        }

        public final void mo4408a(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
            if (VERSION.SDK_INT == 21) {
                colorStateList = view.getBackground();
                Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
                if (colorStateList != null && obj != null) {
                    if (colorStateList.isStateful()) {
                        colorStateList.setState(view.getDrawableState());
                    }
                    view.setBackground(colorStateList);
                }
            }
        }

        public final void mo4409a(View view, Mode mode) {
            view.setBackgroundTintMode(mode);
            if (VERSION.SDK_INT == 21) {
                mode = view.getBackground();
                Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
                if (mode != null && obj != null) {
                    if (mode.isStateful()) {
                        mode.setState(view.getDrawableState());
                    }
                    view.setBackground(mode);
                }
            }
        }

        public final Mode mo4404A(View view) {
            return view.getBackgroundTintMode();
        }

        public final WindowInsetsCompat mo4406a(View view, WindowInsetsCompat windowInsetsCompat) {
            Object obj = (WindowInsets) WindowInsetsCompat.m1306a(windowInsetsCompat);
            view = view.onApplyWindowInsets(obj);
            if (view != obj) {
                obj = new WindowInsets(view);
            }
            return WindowInsetsCompat.m1305a(obj);
        }

        public final WindowInsetsCompat mo4412b(View view, WindowInsetsCompat windowInsetsCompat) {
            Object obj = (WindowInsets) WindowInsetsCompat.m1306a(windowInsetsCompat);
            view = view.dispatchApplyWindowInsets(obj);
            if (view != obj) {
                obj = new WindowInsets(view);
            }
            return WindowInsetsCompat.m1305a(obj);
        }

        public final float mo4405B(View view) {
            return view.getZ();
        }

        public final void mo4415c(View view, float f) {
            view.setZ(f);
        }

        public void mo4414b(View view, int i) {
            int intersects;
            Rect a = m21572a();
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                a.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                intersects = a.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ^ 1;
            } else {
                intersects = 0;
            }
            super.mo4414b(view, i);
            if (intersects != 0 && a.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) != null) {
                ((View) parent).invalidate(a);
            }
        }

        public void mo4416c(View view, int i) {
            int intersects;
            Rect a = m21572a();
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                a.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                intersects = a.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ^ 1;
            } else {
                intersects = 0;
            }
            super.mo4416c(view, i);
            if (intersects != 0 && a.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) != null) {
                ((View) parent).invalidate(a);
            }
        }

        private static Rect m21572a() {
            if (f19832d == null) {
                f19832d = new ThreadLocal();
            }
            Rect rect = (Rect) f19832d.get();
            if (rect == null) {
                rect = new Rect();
                f19832d.set(rect);
            }
            rect.setEmpty();
            return rect;
        }
    }

    @RequiresApi(23)
    static class ViewCompatApi23Impl extends ViewCompatApi21Impl {
        ViewCompatApi23Impl() {
        }

        public final void mo4445d(View view, int i) {
            view.setScrollIndicators(i, 3);
        }

        public final void mo4414b(View view, int i) {
            view.offsetLeftAndRight(i);
        }

        public final void mo4416c(View view, int i) {
            view.offsetTopAndBottom(i);
        }
    }

    @RequiresApi(24)
    static class ViewCompatApi24Impl extends ViewCompatApi23Impl {
        ViewCompatApi24Impl() {
        }

        public final void mo4447a(View view, PointerIconCompat pointerIconCompat) {
            if (pointerIconCompat != null) {
                pointerIconCompat = pointerIconCompat.f1451a;
            } else {
                pointerIconCompat = null;
            }
            view.setPointerIcon((PointerIcon) pointerIconCompat);
        }
    }

    @RequiresApi(26)
    static class ViewCompatApi26Impl extends ViewCompatApi24Impl {
        ViewCompatApi26Impl() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            f1462a = new ViewCompatApi26Impl();
        } else if (VERSION.SDK_INT >= 24) {
            f1462a = new ViewCompatApi24Impl();
        } else if (VERSION.SDK_INT >= 23) {
            f1462a = new ViewCompatApi23Impl();
        } else if (VERSION.SDK_INT >= 21) {
            f1462a = new ViewCompatApi21Impl();
        } else if (VERSION.SDK_INT >= 19) {
            f1462a = new ViewCompatApi19Impl();
        } else if (VERSION.SDK_INT >= 18) {
            f1462a = new ViewCompatApi18Impl();
        } else if (VERSION.SDK_INT >= 17) {
            f1462a = new ViewCompatApi17Impl();
        } else if (VERSION.SDK_INT >= 16) {
            f1462a = new ViewCompatApi16Impl();
        } else if (VERSION.SDK_INT >= 15) {
            f1462a = new ViewCompatApi15Impl();
        } else {
            f1462a = new ViewCompatBaseImpl();
        }
    }

    public static void m1223a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewCompatBaseImpl.m1151a(view, accessibilityNodeInfoCompat);
    }

    public static void m1220a(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompatBaseImpl.m1150a(view, accessibilityDelegateCompat);
    }

    public static boolean m1228a(View view) {
        return ViewCompatBaseImpl.m1148C(view);
    }

    public static boolean m1233b(View view) {
        return f1462a.mo3139b(view);
    }

    public static void m1227a(View view, boolean z) {
        f1462a.mo3138a(view, z);
    }

    public static void m1234c(View view) {
        f1462a.mo3140c(view);
    }

    public static void m1224a(View view, Runnable runnable) {
        f1462a.mo3136a(view, runnable);
    }

    public static void m1225a(View view, Runnable runnable, long j) {
        f1462a.mo3137a(view, runnable, j);
    }

    public static int m1237d(View view) {
        return f1462a.mo3141d(view);
    }

    public static void m1214a(View view, int i) {
        f1462a.mo3134a(view, i);
    }

    @Deprecated
    public static float m1240e(View view) {
        return view.getAlpha();
    }

    public static int m1242f(View view) {
        return f1462a.mo3837k(view);
    }

    public static ViewParent m1244g(View view) {
        return f1462a.mo3142e(view);
    }

    public static void m1246h(View view) {
        f1462a.mo4366r(view);
    }

    public static int m1248i(View view) {
        return f1462a.mo3838l(view);
    }

    public static int m1249j(View view) {
        return f1462a.mo3839m(view);
    }

    public static void m1215a(View view, int i, int i2, int i3, int i4) {
        f1462a.mo3836a(view, i, i2, i3, i4);
    }

    @Deprecated
    public static float m1250k(View view) {
        return view.getTranslationX();
    }

    @Deprecated
    public static float m1251l(View view) {
        return view.getTranslationY();
    }

    public static int m1252m(View view) {
        return f1462a.mo3143f(view);
    }

    public static int m1253n(View view) {
        return f1462a.mo3144g(view);
    }

    public static ViewPropertyAnimatorCompat m1254o(View view) {
        ViewCompatBaseImpl viewCompatBaseImpl = f1462a;
        if (viewCompatBaseImpl.f1461a == null) {
            viewCompatBaseImpl.f1461a = new WeakHashMap();
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat) viewCompatBaseImpl.f1461a.get(view);
        if (viewPropertyAnimatorCompat != null) {
            return viewPropertyAnimatorCompat;
        }
        viewPropertyAnimatorCompat = new ViewPropertyAnimatorCompat(view);
        viewCompatBaseImpl.f1461a.put(view, viewPropertyAnimatorCompat);
        return viewPropertyAnimatorCompat;
    }

    @Deprecated
    public static void m1213a(View view, float f) {
        view.setTranslationX(f);
    }

    @Deprecated
    public static void m1230b(View view, float f) {
        view.setTranslationY(f);
    }

    @Deprecated
    public static void m1235c(View view, float f) {
        view.setAlpha(f);
    }

    @Deprecated
    public static void m1255p(View view) {
        view.setRotation(0.0f);
    }

    @Deprecated
    public static void m1256q(View view) {
        view.setRotationX(0.0f);
    }

    @Deprecated
    public static void m1257r(View view) {
        view.setRotationY(0.0f);
    }

    @Deprecated
    public static void m1258s(View view) {
        view.setScaleX(1.0f);
    }

    @Deprecated
    public static void m1259t(View view) {
        view.setScaleY(1.0f);
    }

    @Deprecated
    public static void m1238d(View view, float f) {
        view.setPivotX(f);
    }

    @Deprecated
    public static void m1241e(View view, float f) {
        view.setPivotY(f);
    }

    public static void m1243f(View view, float f) {
        f1462a.mo4407a(view, f);
    }

    public static float m1260u(View view) {
        return f1462a.mo4418v(view);
    }

    public static void m1245g(View view, float f) {
        f1462a.mo4413b(view, f);
    }

    public static float m1261v(View view) {
        return f1462a.mo4419w(view);
    }

    public static void m1226a(View view, String str) {
        f1462a.mo4411a(view, str);
    }

    public static String m1262w(View view) {
        return f1462a.mo4417u(view);
    }

    public static int m1263x(View view) {
        return f1462a.mo3840n(view);
    }

    public static void m1264y(View view) {
        f1462a.mo3145h(view);
    }

    public static boolean m1265z(View view) {
        return f1462a.mo3146i(view);
    }

    @Deprecated
    public static void m1232b(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static void m1221a(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        f1462a.mo4410a(view, onApplyWindowInsetsListener);
    }

    public static WindowInsetsCompat m1212a(View view, WindowInsetsCompat windowInsetsCompat) {
        return f1462a.mo4406a(view, windowInsetsCompat);
    }

    public static WindowInsetsCompat m1229b(View view, WindowInsetsCompat windowInsetsCompat) {
        return f1462a.mo4412b(view, windowInsetsCompat);
    }

    public static boolean m1200A(View view) {
        return f1462a.mo3147j(view);
    }

    public static boolean m1201B(View view) {
        return f1462a.mo3841o(view);
    }

    public static void m1219a(View view, Drawable drawable) {
        f1462a.mo3135a(view, drawable);
    }

    public static ColorStateList m1202C(View view) {
        return f1462a.mo4422z(view);
    }

    public static void m1216a(View view, ColorStateList colorStateList) {
        f1462a.mo4408a(view, colorStateList);
    }

    public static Mode m1203D(View view) {
        return f1462a.mo4404A(view);
    }

    public static void m1217a(View view, Mode mode) {
        f1462a.mo4409a(view, mode);
    }

    public static boolean m1204E(View view) {
        return f1462a.mo4420x(view);
    }

    public static void m1205F(View view) {
        f1462a.mo4421y(view);
    }

    public static boolean m1206G(View view) {
        return f1462a.mo4367s(view);
    }

    public static float m1207H(View view) {
        return f1462a.mo4405B(view);
    }

    public static void m1247h(View view, float f) {
        f1462a.mo4415c(view, f);
    }

    public static void m1231b(View view, int i) {
        f1462a.mo4416c(view, i);
    }

    public static void m1236c(View view, int i) {
        f1462a.mo4414b(view, i);
    }

    public static void m1218a(View view, Rect rect) {
        f1462a.mo4220a(view, rect);
    }

    public static Rect m1208I(View view) {
        return f1462a.mo4221q(view);
    }

    public static boolean m1209J(View view) {
        return f1462a.mo4368t(view);
    }

    public static boolean m1210K(View view) {
        return f1462a.mo376a(view);
    }

    public static void m1239d(View view, int i) {
        f1462a.mo4445d(view, i);
    }

    public static void m1222a(View view, PointerIconCompat pointerIconCompat) {
        f1462a.mo4447a(view, pointerIconCompat);
    }

    public static Display m1211L(View view) {
        return f1462a.mo3842p(view);
    }
}
