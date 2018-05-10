package android.support.design.widget;

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
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.WindowInsetsCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import io.fabric.sdk.android.services.common.AbstractSpiCall;

public final class TwoActionSnackbar {
    private static final Handler f712d = new Handler(Looper.getMainLooper(), new C00481());
    final ViewGroup f713a;
    public final SnackbarLayout f714b;
    final Callback f715c = new C09884(this);
    private final Context f716e;
    private int f717f;
    private final AccessibilityManager f718g;

    class AnonymousClass11 implements AnimationListener {
        final /* synthetic */ int f698a;
        final /* synthetic */ TwoActionSnackbar f699b;

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }

        AnonymousClass11(TwoActionSnackbar twoActionSnackbar, int i) {
            this.f699b = twoActionSnackbar;
            this.f698a = i;
        }

        public void onAnimationEnd(Animation animation) {
            this.f699b.m350d();
        }
    }

    static class C00481 implements Callback {
        C00481() {
        }

        public final boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    TwoActionSnackbar twoActionSnackbar = (TwoActionSnackbar) message.obj;
                    if (twoActionSnackbar.f714b.getParent() == null) {
                        LayoutParams layoutParams = twoActionSnackbar.f714b.getLayoutParams();
                        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                            CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
                            android.support.design.widget.CoordinatorLayout.Behavior behavior = new Behavior(twoActionSnackbar);
                            behavior.m9606a();
                            behavior.m9609b();
                            behavior.f11122d = 0;
                            behavior.f11121c = new C09895(twoActionSnackbar);
                            layoutParams2.m246a(behavior);
                            layoutParams2.f549g = 80;
                        }
                        twoActionSnackbar.f713a.addView(twoActionSnackbar.f714b);
                    }
                    twoActionSnackbar.f714b.setOnAttachStateChangeListener(new C09906(twoActionSnackbar));
                    if (!ViewCompat.m1206G(twoActionSnackbar.f714b)) {
                        twoActionSnackbar.f714b.setOnLayoutChangeListener(new C09917(twoActionSnackbar));
                    } else if (twoActionSnackbar.m351e()) {
                        twoActionSnackbar.m348b();
                    } else {
                        twoActionSnackbar.m349c();
                    }
                    return true;
                case 1:
                    TwoActionSnackbar twoActionSnackbar2 = (TwoActionSnackbar) message.obj;
                    message = message.arg1;
                    if (!twoActionSnackbar2.m351e() || twoActionSnackbar2.f714b.getVisibility() != 0) {
                        twoActionSnackbar2.m350d();
                    } else if (VERSION.SDK_INT >= 14) {
                        ViewCompat.m1254o(twoActionSnackbar2.f714b).m1300c((float) twoActionSnackbar2.f714b.getHeight()).m1295a(AnimationUtils.f407b).m1292a(250).m1293a(new AnonymousClass10(twoActionSnackbar2, message)).m1299b();
                    } else {
                        Animation loadAnimation = AnimationUtils.loadAnimation(twoActionSnackbar2.f714b.getContext(), C1761R.anim.design_snackbar_out);
                        loadAnimation.setInterpolator(AnimationUtils.f407b);
                        loadAnimation.setDuration(250);
                        loadAnimation.setAnimationListener(new AnonymousClass11(twoActionSnackbar2, message));
                        twoActionSnackbar2.f714b.startAnimation(loadAnimation);
                    }
                    return true;
                default:
                    return false;
            }
        }
    }

    class C00529 implements AnimationListener {
        final /* synthetic */ TwoActionSnackbar f705a;

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }

        C00529(TwoActionSnackbar twoActionSnackbar) {
            this.f705a = twoActionSnackbar;
        }

        public void onAnimationEnd(Animation animation) {
            this.f705a.m349c();
        }
    }

    public static class SnackbarLayout extends RelativeLayout {
        TextView f706a;
        Button f707b;
        Button f708c;
        private int f709d;
        private OnLayoutChangeListener f710e;
        private OnAttachStateChangeListener f711f;

        interface OnAttachStateChangeListener {
            void mo124a();
        }

        interface OnLayoutChangeListener {
            void mo125a();
        }

        class C09921 implements OnApplyWindowInsetsListener {
            final /* synthetic */ SnackbarLayout f11183a;

            C09921(SnackbarLayout snackbarLayout) {
                this.f11183a = snackbarLayout;
            }

            public final WindowInsetsCompat mo56a(View view, WindowInsetsCompat windowInsetsCompat) {
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.m1311d());
                return windowInsetsCompat;
            }
        }

        public SnackbarLayout(Context context) {
            this(context, null);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            attributeSet = context.obtainStyledAttributes(attributeSet, C0016R.styleable.SnackbarLayout);
            this.f709d = attributeSet.getDimensionPixelSize(0, -1);
            if (attributeSet.hasValue(1)) {
                ViewCompat.m1243f(this, (float) attributeSet.getDimensionPixelSize(1, 0));
            }
            attributeSet.recycle();
            setClickable(true);
            LayoutInflater.from(context).inflate(C1761R.layout.design_layout_snackbar_two_action_include, this);
            ViewCompat.m1246h(this);
            ViewCompat.m1214a((View) this, 1);
            ViewCompat.m1232b((View) this, true);
            ViewCompat.m1221a((View) this, new C09921(this));
        }

        protected void onFinishInflate() {
            super.onFinishInflate();
            this.f706a = (TextView) findViewById(C1761R.id.snackbar_text);
            this.f707b = (Button) findViewById(C1761R.id.snackbar_action_1);
            this.f708c = (Button) findViewById(C1761R.id.snackbar_action_2);
        }

        TextView getMessageView() {
            return this.f706a;
        }

        Button getAction1View() {
            return this.f707b;
        }

        Button getAction2View() {
            return this.f708c;
        }

        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.f709d > 0 && getMeasuredWidth() > this.f709d) {
                super.onMeasure(MeasureSpec.makeMeasureSpec(this.f709d, 1073741824), i2);
            }
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.f710e) {
                this.f710e.mo125a();
            }
        }

        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            ViewCompat.m1264y(this);
        }

        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.f711f != null) {
                this.f711f.mo124a();
            }
        }

        void setOnLayoutChangeListener(OnLayoutChangeListener onLayoutChangeListener) {
            this.f710e = onLayoutChangeListener;
        }

        void setOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
            this.f711f = onAttachStateChangeListener;
        }
    }

    class C09884 implements Callback {
        final /* synthetic */ TwoActionSnackbar f11179a;

        C09884(TwoActionSnackbar twoActionSnackbar) {
            this.f11179a = twoActionSnackbar;
        }

        public final void mo60a() {
            TwoActionSnackbar.f712d.sendMessage(TwoActionSnackbar.f712d.obtainMessage(0, this.f11179a));
        }

        public final void mo61a(int i) {
            TwoActionSnackbar.f712d.sendMessage(TwoActionSnackbar.f712d.obtainMessage(1, i, 0, this.f11179a));
        }
    }

    class C09895 implements OnDismissListener {
        final /* synthetic */ TwoActionSnackbar f11180a;

        C09895(TwoActionSnackbar twoActionSnackbar) {
            this.f11180a = twoActionSnackbar;
        }

        public final void mo63a(View view) {
            view.setVisibility(8);
            SnackbarManager.m282a().m289a(this.f11180a.f715c, 0);
        }

        public final void mo62a(int i) {
            switch (i) {
                case 0:
                    SnackbarManager.m282a().m293d(this.f11180a.f715c);
                    break;
                case 1:
                case 2:
                    SnackbarManager.m282a().m292c(this.f11180a.f715c);
                    return;
                default:
                    break;
            }
        }
    }

    class C09906 implements OnAttachStateChangeListener {
        final /* synthetic */ TwoActionSnackbar f11181a;

        class C00511 implements Runnable {
            final /* synthetic */ C09906 f704a;

            C00511(C09906 c09906) {
                this.f704a = c09906;
            }

            public void run() {
                this.f704a.f11181a.m350d();
            }
        }

        C09906(TwoActionSnackbar twoActionSnackbar) {
            this.f11181a = twoActionSnackbar;
        }

        public final void mo124a() {
            if (SnackbarManager.m282a().m294e(this.f11181a.f715c)) {
                TwoActionSnackbar.f712d.post(new C00511(this));
            }
        }
    }

    class C09917 implements OnLayoutChangeListener {
        final /* synthetic */ TwoActionSnackbar f11182a;

        C09917(TwoActionSnackbar twoActionSnackbar) {
            this.f11182a = twoActionSnackbar;
        }

        public final void mo125a() {
            this.f11182a.f714b.setOnLayoutChangeListener(null);
            if (this.f11182a.m351e()) {
                this.f11182a.m348b();
            } else {
                this.f11182a.m349c();
            }
        }
    }

    class AnonymousClass10 extends ViewPropertyAnimatorListenerAdapter {
        boolean f16453a = null;
        final /* synthetic */ int f16454b;
        final /* synthetic */ TwoActionSnackbar f16455c;

        AnonymousClass10(TwoActionSnackbar twoActionSnackbar, int i) {
            this.f16455c = twoActionSnackbar;
            this.f16454b = i;
        }

        public final void mo377a(View view) {
            if (this.f16455c.f718g.isEnabled() == null) {
                view = this.f16455c.f714b;
                ViewCompat.m1235c(view.f706a, 1.0f);
                ViewCompat.m1254o(view.f706a).m1291a(0.0f).m1292a(180).m1298b(0).m1299b();
                if (view.f707b.getVisibility() == 0) {
                    ViewCompat.m1235c(view.f707b, 1.0f);
                    ViewCompat.m1254o(view.f707b).m1291a(0.0f).m1292a(180).m1298b(0).m1299b();
                }
                if (view.f708c.getVisibility() == 0) {
                    ViewCompat.m1235c(view.f708c, 1.0f);
                    ViewCompat.m1254o(view.f708c).m1291a(0.0f).m1292a(180).m1298b(0).m1299b();
                }
            }
        }

        public final void mo378b(View view) {
            this.f16455c.m350d();
        }
    }

    class C15848 extends ViewPropertyAnimatorListenerAdapter {
        final /* synthetic */ TwoActionSnackbar f16456a;

        C15848(TwoActionSnackbar twoActionSnackbar) {
            this.f16456a = twoActionSnackbar;
        }

        public final void mo377a(View view) {
            if (this.f16456a.f718g.isEnabled() == null) {
                view = this.f16456a.f714b;
                ViewCompat.m1235c(view.f706a, 0.0f);
                ViewCompat.m1254o(view.f706a).m1291a(1.0f).m1292a(180).m1298b(70).m1299b();
                if (view.f707b.getVisibility() == 0) {
                    ViewCompat.m1235c(view.f707b, 0.0f);
                    ViewCompat.m1254o(view.f707b).m1291a(1.0f).m1292a(180).m1298b(70).m1299b();
                }
                if (view.f708c.getVisibility() == 0) {
                    ViewCompat.m1235c(view.f708c, 0.0f);
                    ViewCompat.m1254o(view.f708c).m1291a(1.0f).m1292a(180).m1298b(70).m1299b();
                }
            }
        }

        public final void mo378b(View view) {
            this.f16456a.m349c();
        }
    }

    final class Behavior extends SwipeDismissBehavior<SnackbarLayout> {
        final /* synthetic */ TwoActionSnackbar f16457a;

        Behavior(TwoActionSnackbar twoActionSnackbar) {
            this.f16457a = twoActionSnackbar;
        }

        public final boolean mo3076a(View view) {
            return view instanceof SnackbarLayout;
        }

        private boolean m16574a(CoordinatorLayout coordinatorLayout, SnackbarLayout snackbarLayout, MotionEvent motionEvent) {
            if (coordinatorLayout.m16550a((View) snackbarLayout, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked != 3) {
                    switch (actionMasked) {
                        case 0:
                            SnackbarManager.m282a().m292c(this.f16457a.f715c);
                            break;
                        case 1:
                            break;
                        default:
                            break;
                    }
                }
                SnackbarManager.m282a().m293d(this.f16457a.f715c);
            }
            return super.mo76a(coordinatorLayout, (View) snackbarLayout, motionEvent);
        }
    }

    private TwoActionSnackbar(ViewGroup viewGroup) {
        this.f713a = viewGroup;
        this.f716e = viewGroup.getContext();
        ThemeUtils.m333a(this.f716e);
        this.f714b = (SnackbarLayout) LayoutInflater.from(this.f716e).inflate(C1761R.layout.design_layout_snackbar_two_action, this.f713a, false);
        this.f718g = (AccessibilityManager) this.f716e.getSystemService("accessibility");
    }

    public static TwoActionSnackbar m337a(View view, int i) {
        i = view.getResources().getText(i);
        TwoActionSnackbar twoActionSnackbar = new TwoActionSnackbar(m338a(view));
        twoActionSnackbar.f714b.getMessageView().setText(i);
        twoActionSnackbar.f717f = AbstractSpiCall.DEFAULT_TIMEOUT;
        return twoActionSnackbar;
    }

    private static ViewGroup m338a(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                view = view.getParent();
                if (view instanceof View) {
                    view = view;
                    continue;
                } else {
                    view = null;
                    continue;
                }
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view;
    }

    public final TwoActionSnackbar m345a(int i, final OnClickListener onClickListener) {
        i = this.f716e.getText(i);
        TextView action1View = this.f714b.getAction1View();
        if (!TextUtils.isEmpty(i)) {
            if (onClickListener != null) {
                action1View.setVisibility(0);
                action1View.setText(i);
                action1View.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ TwoActionSnackbar f701b;

                    public void onClick(View view) {
                        onClickListener.onClick(view);
                        SnackbarManager.m282a().m289a(this.f701b.f715c, 1);
                    }
                });
                return this;
            }
        }
        action1View.setVisibility(8);
        action1View.setOnClickListener(0);
        return this;
    }

    public final TwoActionSnackbar m347b(int i, final OnClickListener onClickListener) {
        i = this.f716e.getText(i);
        TextView action2View = this.f714b.getAction2View();
        if (!TextUtils.isEmpty(i)) {
            if (onClickListener != null) {
                action2View.setVisibility(0);
                action2View.setText(i);
                action2View.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ TwoActionSnackbar f703b;

                    public void onClick(View view) {
                        onClickListener.onClick(view);
                        SnackbarManager.m282a().m289a(this.f703b.f715c, 1);
                    }
                });
                return this;
            }
        }
        action2View.setVisibility(8);
        action2View.setOnClickListener(0);
        return this;
    }

    public final void m346a() {
        SnackbarManager.m282a().m287a(this.f717f, this.f715c);
    }

    final void m348b() {
        if (VERSION.SDK_INT >= 14) {
            ViewCompat.m1230b(this.f714b, (float) this.f714b.getHeight());
            ViewCompat.m1254o(this.f714b).m1300c(0.0f).m1295a(AnimationUtils.f407b).m1292a(250).m1293a(new C15848(this)).m1299b();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f714b.getContext(), C1761R.anim.design_snackbar_in);
        loadAnimation.setInterpolator(AnimationUtils.f407b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new C00529(this));
        this.f714b.startAnimation(loadAnimation);
    }

    final void m349c() {
        SnackbarManager.m282a().m291b(this.f715c);
    }

    final void m350d() {
        SnackbarManager.m282a().m288a(this.f715c);
        ViewParent parent = this.f714b.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f714b);
        }
    }

    final boolean m351e() {
        return !this.f718g.isEnabled();
    }
}
