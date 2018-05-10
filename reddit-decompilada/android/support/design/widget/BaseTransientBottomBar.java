package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.design.C0016R;
import android.support.design.widget.SwipeDismissBehavior.OnDismissListener;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import java.util.List;

public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    static final Handler f440a = new Handler(Looper.getMainLooper(), new C00211());
    private static final boolean f441g;
    final ViewGroup f442b;
    final Context f443c;
    public final SnackbarBaseLayout f444d;
    int f445e;
    final Callback f446f = new C09753(this);
    private final ContentViewCallback f447h;
    private List<Object<B>> f448i;
    private final AccessibilityManager f449j;

    class AnonymousClass10 extends AnimatorListenerAdapter {
        final /* synthetic */ int f426a;
        final /* synthetic */ BaseTransientBottomBar f427b;

        AnonymousClass10(BaseTransientBottomBar baseTransientBottomBar, int i) {
            this.f427b = baseTransientBottomBar;
            this.f426a = i;
        }

        public void onAnimationStart(Animator animator) {
            this.f427b.f447h.mo58b();
        }

        public void onAnimationEnd(Animator animator) {
            this.f427b.m184d();
        }
    }

    class AnonymousClass12 implements AnimationListener {
        final /* synthetic */ int f430a;
        final /* synthetic */ BaseTransientBottomBar f431b;

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }

        AnonymousClass12(BaseTransientBottomBar baseTransientBottomBar, int i) {
            this.f431b = baseTransientBottomBar;
            this.f430a = i;
        }

        public void onAnimationEnd(Animation animation) {
            this.f431b.m184d();
        }
    }

    static class C00211 implements Callback {
        C00211() {
        }

        public final boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    BaseTransientBottomBar baseTransientBottomBar = (BaseTransientBottomBar) message.obj;
                    if (baseTransientBottomBar.f444d.getParent() == null) {
                        LayoutParams layoutParams = baseTransientBottomBar.f444d.getLayoutParams();
                        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                            CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
                            android.support.design.widget.CoordinatorLayout.Behavior behavior = new Behavior(baseTransientBottomBar);
                            behavior.m9606a();
                            behavior.m9609b();
                            behavior.f11122d = 0;
                            behavior.f11121c = new C09764(baseTransientBottomBar);
                            layoutParams2.m246a(behavior);
                            layoutParams2.f549g = 80;
                        }
                        baseTransientBottomBar.f442b.addView(baseTransientBottomBar.f444d);
                    }
                    baseTransientBottomBar.f444d.setOnAttachStateChangeListener(new C09775(baseTransientBottomBar));
                    if (!ViewCompat.m1206G(baseTransientBottomBar.f444d)) {
                        baseTransientBottomBar.f444d.setOnLayoutChangeListener(new C09786(baseTransientBottomBar));
                    } else if (baseTransientBottomBar.m185e()) {
                        baseTransientBottomBar.m182b();
                    } else {
                        baseTransientBottomBar.m183c();
                    }
                    return true;
                case 1:
                    BaseTransientBottomBar baseTransientBottomBar2 = (BaseTransientBottomBar) message.obj;
                    message = message.arg1;
                    if (!baseTransientBottomBar2.m185e() || baseTransientBottomBar2.f444d.getVisibility() != 0) {
                        baseTransientBottomBar2.m184d();
                    } else if (VERSION.SDK_INT >= 12) {
                        ValueAnimator valueAnimator = new ValueAnimator();
                        valueAnimator.setIntValues(new int[]{0, baseTransientBottomBar2.f444d.getHeight()});
                        valueAnimator.setInterpolator(AnimationUtils.f407b);
                        valueAnimator.setDuration(250);
                        valueAnimator.addListener(new AnonymousClass10(baseTransientBottomBar2, message));
                        valueAnimator.addUpdateListener(new AnimatorUpdateListener(baseTransientBottomBar2) {
                            final /* synthetic */ BaseTransientBottomBar f428a;
                            private int f429b = null;

                            {
                                this.f428a = r1;
                            }

                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                valueAnimator = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                if (BaseTransientBottomBar.f441g) {
                                    ViewCompat.m1231b(this.f428a.f444d, valueAnimator - this.f429b);
                                } else {
                                    this.f428a.f444d.setTranslationY((float) valueAnimator);
                                }
                                this.f429b = valueAnimator;
                            }
                        });
                        valueAnimator.start();
                    } else {
                        Animation loadAnimation = AnimationUtils.loadAnimation(baseTransientBottomBar2.f444d.getContext(), C0016R.anim.design_snackbar_out);
                        loadAnimation.setInterpolator(AnimationUtils.f407b);
                        loadAnimation.setDuration(250);
                        loadAnimation.setAnimationListener(new AnonymousClass12(baseTransientBottomBar2, message));
                        baseTransientBottomBar2.f444d.startAnimation(loadAnimation);
                    }
                    return true;
                default:
                    return false;
            }
        }
    }

    class C00237 extends AnimatorListenerAdapter {
        final /* synthetic */ BaseTransientBottomBar f433a;

        C00237(BaseTransientBottomBar baseTransientBottomBar) {
            this.f433a = baseTransientBottomBar;
        }

        public void onAnimationStart(Animator animator) {
            this.f433a.f447h.mo57a();
        }

        public void onAnimationEnd(Animator animator) {
            this.f433a.m183c();
        }
    }

    class C00259 implements AnimationListener {
        final /* synthetic */ BaseTransientBottomBar f437a;

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }

        C00259(BaseTransientBottomBar baseTransientBottomBar) {
            this.f437a = baseTransientBottomBar;
        }

        public void onAnimationEnd(Animation animation) {
            this.f437a.m183c();
        }
    }

    public interface ContentViewCallback {
        void mo57a();

        void mo58b();
    }

    interface OnAttachStateChangeListener {
        void mo64a();
    }

    interface OnLayoutChangeListener {
        void mo65a();
    }

    static class SnackbarBaseLayout extends FrameLayout {
        private OnLayoutChangeListener f438a;
        private OnAttachStateChangeListener f439b;

        SnackbarBaseLayout(Context context) {
            this(context, null);
        }

        SnackbarBaseLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context = context.obtainStyledAttributes(attributeSet, C0016R.styleable.SnackbarLayout);
            if (context.hasValue(C0016R.styleable.SnackbarLayout_elevation) != null) {
                ViewCompat.m1243f(this, (float) context.getDimensionPixelSize(C0016R.styleable.SnackbarLayout_elevation, 0));
            }
            context.recycle();
            setClickable(true);
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.f438a) {
                this.f438a.mo65a();
            }
        }

        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            ViewCompat.m1264y(this);
        }

        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.f439b != null) {
                this.f439b.mo64a();
            }
        }

        void setOnLayoutChangeListener(OnLayoutChangeListener onLayoutChangeListener) {
            this.f438a = onLayoutChangeListener;
        }

        void setOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
            this.f439b = onAttachStateChangeListener;
        }
    }

    class C09742 implements OnApplyWindowInsetsListener {
        final /* synthetic */ BaseTransientBottomBar f11035a;

        C09742(BaseTransientBottomBar baseTransientBottomBar) {
            this.f11035a = baseTransientBottomBar;
        }

        public final WindowInsetsCompat mo56a(View view, WindowInsetsCompat windowInsetsCompat) {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.m1311d());
            return windowInsetsCompat;
        }
    }

    class C09753 implements Callback {
        final /* synthetic */ BaseTransientBottomBar f11036a;

        C09753(BaseTransientBottomBar baseTransientBottomBar) {
            this.f11036a = baseTransientBottomBar;
        }

        public final void mo60a() {
            BaseTransientBottomBar.f440a.sendMessage(BaseTransientBottomBar.f440a.obtainMessage(0, this.f11036a));
        }

        public final void mo61a(int i) {
            BaseTransientBottomBar.f440a.sendMessage(BaseTransientBottomBar.f440a.obtainMessage(1, i, 0, this.f11036a));
        }
    }

    class C09764 implements OnDismissListener {
        final /* synthetic */ BaseTransientBottomBar f11037a;

        C09764(BaseTransientBottomBar baseTransientBottomBar) {
            this.f11037a = baseTransientBottomBar;
        }

        public final void mo63a(View view) {
            view.setVisibility(8);
            this.f11037a.m181a(0);
        }

        public final void mo62a(int i) {
            switch (i) {
                case 0:
                    SnackbarManager.m282a().m293d(this.f11037a.f446f);
                    break;
                case 1:
                case 2:
                    SnackbarManager.m282a().m292c(this.f11037a.f446f);
                    return;
                default:
                    break;
            }
        }
    }

    class C09775 implements OnAttachStateChangeListener {
        final /* synthetic */ BaseTransientBottomBar f11038a;

        class C00221 implements Runnable {
            final /* synthetic */ C09775 f432a;

            C00221(C09775 c09775) {
                this.f432a = c09775;
            }

            public void run() {
                this.f432a.f11038a.m184d();
            }
        }

        C09775(BaseTransientBottomBar baseTransientBottomBar) {
            this.f11038a = baseTransientBottomBar;
        }

        public final void mo64a() {
            if (SnackbarManager.m282a().m294e(this.f11038a.f446f)) {
                BaseTransientBottomBar.f440a.post(new C00221(this));
            }
        }
    }

    class C09786 implements OnLayoutChangeListener {
        final /* synthetic */ BaseTransientBottomBar f11039a;

        C09786(BaseTransientBottomBar baseTransientBottomBar) {
            this.f11039a = baseTransientBottomBar;
        }

        public final void mo65a() {
            this.f11039a.f444d.setOnLayoutChangeListener(null);
            if (this.f11039a.m185e()) {
                this.f11039a.m182b();
            } else {
                this.f11039a.m183c();
            }
        }
    }

    final class Behavior extends SwipeDismissBehavior<SnackbarBaseLayout> {
        final /* synthetic */ BaseTransientBottomBar f16411a;

        Behavior(BaseTransientBottomBar baseTransientBottomBar) {
            this.f16411a = baseTransientBottomBar;
        }

        public final boolean mo3076a(View view) {
            return view instanceof SnackbarBaseLayout;
        }

        private boolean m16524a(CoordinatorLayout coordinatorLayout, SnackbarBaseLayout snackbarBaseLayout, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 3) {
                switch (actionMasked) {
                    case 0:
                        if (coordinatorLayout.m16550a((View) snackbarBaseLayout, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                            SnackbarManager.m282a().m292c(this.f16411a.f446f);
                            break;
                        }
                        break;
                    case 1:
                        break;
                    default:
                        break;
                }
            }
            SnackbarManager.m282a().m293d(this.f16411a.f446f);
            return super.mo76a(coordinatorLayout, (View) snackbarBaseLayout, motionEvent);
        }
    }

    static {
        boolean z = VERSION.SDK_INT >= 16 && VERSION.SDK_INT <= 19;
        f441g = z;
    }

    protected BaseTransientBottomBar(ViewGroup viewGroup, View view, ContentViewCallback contentViewCallback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        } else if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        } else if (contentViewCallback == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        } else {
            this.f442b = viewGroup;
            this.f447h = contentViewCallback;
            this.f443c = viewGroup.getContext();
            ThemeUtils.m333a(this.f443c);
            this.f444d = (SnackbarBaseLayout) LayoutInflater.from(this.f443c).inflate(C0016R.layout.design_layout_snackbar, this.f442b, false);
            this.f444d.addView(view);
            ViewCompat.m1246h(this.f444d);
            ViewCompat.m1214a(this.f444d, 1);
            ViewCompat.m1232b(this.f444d, true);
            ViewCompat.m1221a(this.f444d, new C09742(this));
            this.f449j = (AccessibilityManager) this.f443c.getSystemService("accessibility");
        }
    }

    public final void m180a() {
        SnackbarManager.m282a().m287a(this.f445e, this.f446f);
    }

    public final void m181a(int i) {
        SnackbarManager.m282a().m289a(this.f446f, i);
    }

    final void m182b() {
        if (VERSION.SDK_INT >= 12) {
            final int height = this.f444d.getHeight();
            if (f441g) {
                ViewCompat.m1231b(this.f444d, height);
            } else {
                this.f444d.setTranslationY((float) height);
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(new int[]{height, 0});
            valueAnimator.setInterpolator(AnimationUtils.f407b);
            valueAnimator.setDuration(250);
            valueAnimator.addListener(new C00237(this));
            valueAnimator.addUpdateListener(new AnimatorUpdateListener(this) {
                final /* synthetic */ BaseTransientBottomBar f435b;
                private int f436c = height;

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    valueAnimator = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (BaseTransientBottomBar.f441g) {
                        ViewCompat.m1231b(this.f435b.f444d, valueAnimator - this.f436c);
                    } else {
                        this.f435b.f444d.setTranslationY((float) valueAnimator);
                    }
                    this.f436c = valueAnimator;
                }
            });
            valueAnimator.start();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f444d.getContext(), C0016R.anim.design_snackbar_in);
        loadAnimation.setInterpolator(AnimationUtils.f407b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new C00259(this));
        this.f444d.startAnimation(loadAnimation);
    }

    final void m183c() {
        SnackbarManager.m282a().m291b(this.f446f);
        if (this.f448i != null) {
            for (int size = this.f448i.size() - 1; size >= 0; size--) {
                this.f448i.get(size);
            }
        }
    }

    final void m184d() {
        SnackbarManager.m282a().m288a(this.f446f);
        if (this.f448i != null) {
            for (int size = this.f448i.size() - 1; size >= 0; size--) {
                this.f448i.get(size);
            }
        }
        if (VERSION.SDK_INT < 11) {
            this.f444d.setVisibility(8);
        }
        ViewParent parent = this.f444d.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f444d);
        }
    }

    final boolean m185e() {
        return !this.f449j.isEnabled();
    }
}
