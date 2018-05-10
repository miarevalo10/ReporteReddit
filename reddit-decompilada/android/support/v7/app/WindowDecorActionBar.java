package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.support.v7.appcompat.C0164R;
import android.support.v7.view.ActionBarPolicy;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback;
import android.support.v7.widget.DecorToolbar;
import android.support.v7.widget.ScrollingTabContainerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class WindowDecorActionBar extends ActionBar implements ActionBarVisibilityCallback {
    static final /* synthetic */ boolean f11588s = true;
    private static final Interpolator f11589t = new AccelerateInterpolator();
    private static final Interpolator f11590u = new DecelerateInterpolator();
    private boolean f11591A;
    private boolean f11592B;
    private ArrayList<Object> f11593C = new ArrayList();
    private boolean f11594D;
    private int f11595E = 0;
    private boolean f11596F;
    private boolean f11597G = true;
    private boolean f11598H;
    Context f11599a;
    ActionBarOverlayLayout f11600b;
    ActionBarContainer f11601c;
    DecorToolbar f11602d;
    ActionBarContextView f11603e;
    View f11604f;
    ScrollingTabContainerView f11605g;
    ActionModeImpl f11606h;
    ActionMode f11607i;
    Callback f11608j;
    boolean f11609k = true;
    boolean f11610l;
    boolean f11611m;
    ViewPropertyAnimatorCompatSet f11612n;
    boolean f11613o;
    final ViewPropertyAnimatorListener f11614p = new C15921(this);
    final ViewPropertyAnimatorListener f11615q = new C15932(this);
    final ViewPropertyAnimatorUpdateListener f11616r = new C10153(this);
    private Context f11617v;
    private Activity f11618w;
    private Dialog f11619x;
    private ArrayList<Object> f11620y = new ArrayList();
    private int f11621z = -1;

    class C10153 implements ViewPropertyAnimatorUpdateListener {
        final /* synthetic */ WindowDecorActionBar f11582a;

        C10153(WindowDecorActionBar windowDecorActionBar) {
            this.f11582a = windowDecorActionBar;
        }

        public final void mo460a() {
            ((View) this.f11582a.f11601c.getParent()).invalidate();
        }
    }

    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
        final MenuBuilder f11583a;
        final /* synthetic */ WindowDecorActionBar f11584b;
        private final Context f11585e;
        private Callback f11586f;
        private WeakReference<View> f11587g;

        public ActionModeImpl(WindowDecorActionBar windowDecorActionBar, Context context, Callback callback) {
            this.f11584b = windowDecorActionBar;
            this.f11585e = context;
            this.f11586f = callback;
            this.f11583a = new MenuBuilder(context).setDefaultShowAsAction(1);
            this.f11583a.setCallback(this);
        }

        public final MenuInflater mo461a() {
            return new SupportMenuInflater(this.f11585e);
        }

        public final Menu mo466b() {
            return this.f11583a;
        }

        public final void mo469c() {
            if (this.f11584b.f11606h == this) {
                if (WindowDecorActionBar.m10304a(this.f11584b.f11610l, this.f11584b.f11611m, false)) {
                    this.f11586f.mo430a(this);
                } else {
                    this.f11584b.f11607i = this;
                    this.f11584b.f11608j = this.f11586f;
                }
                this.f11586f = null;
                this.f11584b.m10328h(false);
                ActionBarContextView actionBarContextView = this.f11584b.f11603e;
                if (actionBarContextView.f11808g == null) {
                    actionBarContextView.m10521b();
                }
                this.f11584b.f11602d.mo736a().sendAccessibilityEvent(32);
                this.f11584b.f11600b.setHideOnContentScrollEnabled(this.f11584b.f11613o);
                this.f11584b.f11606h = null;
            }
        }

        public final void mo470d() {
            if (this.f11584b.f11606h == this) {
                this.f11583a.stopDispatchingItemsChanged();
                try {
                    this.f11586f.mo433b(this, this.f11583a);
                } finally {
                    this.f11583a.startDispatchingItemsChanged();
                }
            }
        }

        public final boolean m10297e() {
            this.f11583a.stopDispatchingItemsChanged();
            try {
                boolean a = this.f11586f.mo431a((ActionMode) this, this.f11583a);
                return a;
            } finally {
                this.f11583a.startDispatchingItemsChanged();
            }
        }

        public final void mo463a(View view) {
            this.f11584b.f11603e.setCustomView(view);
            this.f11587g = new WeakReference(view);
        }

        public final void mo464a(CharSequence charSequence) {
            this.f11584b.f11603e.setSubtitle(charSequence);
        }

        public final void mo468b(CharSequence charSequence) {
            this.f11584b.f11603e.setTitle(charSequence);
        }

        public final void mo462a(int i) {
            mo468b(this.f11584b.f11599a.getResources().getString(i));
        }

        public final void mo467b(int i) {
            mo464a(this.f11584b.f11599a.getResources().getString(i));
        }

        public final CharSequence mo471f() {
            return this.f11584b.f11603e.getTitle();
        }

        public final CharSequence mo472g() {
            return this.f11584b.f11603e.getSubtitle();
        }

        public final void mo465a(boolean z) {
            super.mo465a(z);
            this.f11584b.f11603e.setTitleOptional(z);
        }

        public final boolean mo473h() {
            return this.f11584b.f11603e.f11809h;
        }

        public final View mo474i() {
            return this.f11587g != null ? (View) this.f11587g.get() : null;
        }

        public final boolean mo108a(MenuBuilder menuBuilder, MenuItem menuItem) {
            return this.f11586f != null ? this.f11586f.mo432a((ActionMode) this, menuItem) : null;
        }

        public final void mo107a(MenuBuilder menuBuilder) {
            if (this.f11586f != null) {
                mo470d();
                this.f11584b.f11603e.mo549a();
            }
        }
    }

    class C15921 extends ViewPropertyAnimatorListenerAdapter {
        final /* synthetic */ WindowDecorActionBar f16569a;

        C15921(WindowDecorActionBar windowDecorActionBar) {
            this.f16569a = windowDecorActionBar;
        }

        public final void mo378b(View view) {
            if (!(this.f16569a.f11609k == null || this.f16569a.f11604f == null)) {
                this.f16569a.f11604f.setTranslationY(0.0f);
                this.f16569a.f11601c.setTranslationY(0.0f);
            }
            this.f16569a.f11601c.setVisibility(8);
            this.f16569a.f11601c.setTransitioning(false);
            this.f16569a.f11612n = null;
            view = this.f16569a;
            if (view.f11608j != null) {
                view.f11608j.mo430a(view.f11607i);
                view.f11607i = null;
                view.f11608j = null;
            }
            if (this.f16569a.f11600b != null) {
                ViewCompat.m1264y(this.f16569a.f11600b);
            }
        }
    }

    class C15932 extends ViewPropertyAnimatorListenerAdapter {
        final /* synthetic */ WindowDecorActionBar f16570a;

        C15932(WindowDecorActionBar windowDecorActionBar) {
            this.f16570a = windowDecorActionBar;
        }

        public final void mo378b(View view) {
            this.f16570a.f11612n = null;
            this.f16570a.f11601c.requestLayout();
        }
    }

    private void m10302a(int r1, int r2) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: android.support.v7.app.WindowDecorActionBar.a(int, int):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.DecodeException: Unknown instruction: not-int
	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:568)
	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:56)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:102)
	... 5 more
*/
        /*
        // Can't load method instructions.
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.WindowDecorActionBar.a(int, int):void");
    }

    static boolean m10304a(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        if (!z) {
            if (!z2) {
                return true;
            }
        }
        return false;
    }

    public WindowDecorActionBar(Activity activity, boolean z) {
        this.f11618w = activity;
        View decorView = activity.getWindow().getDecorView();
        m10303a(decorView);
        if (!z) {
            this.f11604f = decorView.findViewById(true);
        }
    }

    public WindowDecorActionBar(Dialog dialog) {
        this.f11619x = dialog;
        m10303a(dialog.getWindow().getDecorView());
    }

    private void m10303a(View view) {
        DecorToolbar decorToolbar;
        this.f11600b = (ActionBarOverlayLayout) view.findViewById(C0164R.id.decor_content_parent);
        if (this.f11600b != null) {
            this.f11600b.setActionBarVisibilityCallback(this);
        }
        View findViewById = view.findViewById(C0164R.id.action_bar);
        if (findViewById instanceof DecorToolbar) {
            decorToolbar = (DecorToolbar) findViewById;
        } else if (findViewById instanceof Toolbar) {
            decorToolbar = ((Toolbar) findViewById).getWrapper();
        } else {
            StringBuilder stringBuilder = new StringBuilder("Can't make a decor toolbar out of ");
            stringBuilder.append(findViewById);
            throw new IllegalStateException(stringBuilder.toString() != null ? findViewById.getClass().getSimpleName() : "null");
        }
        this.f11602d = decorToolbar;
        this.f11603e = (ActionBarContextView) view.findViewById(C0164R.id.action_context_bar);
        this.f11601c = (ActionBarContainer) view.findViewById(C0164R.id.action_bar_container);
        if (!(this.f11602d == null || this.f11603e == null)) {
            if (this.f11601c != null) {
                this.f11599a = this.f11602d.mo745b();
                if (((this.f11602d.mo763o() & 4) != null ? 1 : null) != null) {
                    this.f11591A = true;
                }
                view = ActionBarPolicy.m1671a(this.f11599a);
                int i = view.f1959a.getApplicationInfo().targetSdkVersion;
                m10305i(view.m1673b());
                view = this.f11599a.obtainStyledAttributes(null, C0164R.styleable.ActionBar, C0164R.attr.actionBarStyle, 0);
                if (view.getBoolean(C0164R.styleable.ActionBar_hideOnContentScroll, false)) {
                    if (this.f11600b.f11824b) {
                        this.f11613o = true;
                        this.f11600b.setHideOnContentScrollEnabled(true);
                    } else {
                        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
                    }
                }
                int dimensionPixelSize = view.getDimensionPixelSize(C0164R.styleable.ActionBar_elevation, 0);
                if (dimensionPixelSize != 0) {
                    ViewCompat.m1243f(this.f11601c, (float) dimensionPixelSize);
                }
                view.recycle();
                return;
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(getClass().getSimpleName());
        stringBuilder2.append(" can only be used with a compatible window decor layout");
        throw new IllegalStateException(stringBuilder2.toString());
    }

    public final void mo438a(Configuration configuration) {
        m10305i(ActionBarPolicy.m1671a(this.f11599a).m1673b());
    }

    private void m10305i(boolean z) {
        this.f11594D = z;
        if (this.f11594D) {
            this.f11601c.setTabContainer(null);
            this.f11602d.mo740a(this.f11605g);
        } else {
            this.f11602d.mo740a(null);
            this.f11601c.setTabContainer(this.f11605g);
        }
        boolean z2 = true;
        z = this.f11602d.mo764p();
        if (this.f11605g != null) {
            if (z) {
                this.f11605g.setVisibility(0);
                if (this.f11600b != null) {
                    ViewCompat.m1264y(this.f11600b);
                }
            } else {
                this.f11605g.setVisibility(8);
            }
        }
        DecorToolbar decorToolbar = this.f11602d;
        boolean z3 = !this.f11594D && z;
        decorToolbar.mo744a(z3);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f11600b;
        if (this.f11594D || !z) {
            z2 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z2);
    }

    public final void mo476b(int i) {
        this.f11595E = i;
    }

    public final void mo452e(boolean z) {
        this.f11598H = z;
        if (!z && this.f11612n) {
            this.f11612n.m1704b();
        }
    }

    public final void mo454f(boolean z) {
        if (z != this.f11592B) {
            this.f11592B = z;
            z = this.f11593C.size();
            for (boolean z2 = false; z2 < z; z2++) {
                this.f11593C.get(z2);
            }
        }
    }

    public final void mo441a(boolean z) {
        m10302a(z ? true : false, 2);
    }

    public final void mo446b(boolean z) {
        m10302a(z ? true : false, 4);
    }

    public final void mo448c(boolean z) {
        m10302a(z ? true : false, 8);
    }

    public final void mo437a(int i) {
        mo440a(this.f11599a.getString(i));
    }

    public final void mo440a(CharSequence charSequence) {
        this.f11602d.mo748b(charSequence);
    }

    public final void mo445b(CharSequence charSequence) {
        this.f11602d.mo743a(charSequence);
    }

    public final int mo436a() {
        return this.f11602d.mo763o();
    }

    public final ActionMode mo475a(Callback callback) {
        if (this.f11606h != null) {
            this.f11606h.mo469c();
        }
        this.f11600b.setHideOnContentScrollEnabled(false);
        this.f11603e.m10521b();
        ActionMode actionModeImpl = new ActionModeImpl(this, this.f11603e.getContext(), callback);
        if (actionModeImpl.m10297e() == null) {
            return null;
        }
        this.f11606h = actionModeImpl;
        actionModeImpl.mo470d();
        this.f11603e.m10519a(actionModeImpl);
        m10328h(true);
        this.f11603e.sendAccessibilityEvent(32);
        return actionModeImpl;
    }

    public final void mo477g(boolean z) {
        this.f11609k = z;
    }

    public final void mo444b() {
        if (this.f11610l) {
            this.f11610l = false;
            m10306j(false);
        }
    }

    public final void mo478l() {
        if (this.f11611m) {
            this.f11611m = false;
            m10306j(true);
        }
    }

    public final void mo447c() {
        if (!this.f11610l) {
            this.f11610l = true;
            m10306j(false);
        }
    }

    public final void mo479m() {
        if (!this.f11611m) {
            this.f11611m = true;
            m10306j(true);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m10306j(boolean r7) {
        /*
        r6 = this;
        r0 = r6.f11610l;
        r1 = r6.f11611m;
        r2 = r6.f11596F;
        r0 = m10304a(r0, r1, r2);
        r1 = 0;
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r3 = 2;
        r4 = 0;
        r5 = 1;
        if (r0 == 0) goto L_0x00bd;
    L_0x0012:
        r0 = r6.f11597G;
        if (r0 != 0) goto L_0x013c;
    L_0x0016:
        r6.f11597G = r5;
        r0 = r6.f11612n;
        if (r0 == 0) goto L_0x0021;
    L_0x001c:
        r0 = r6.f11612n;
        r0.m1704b();
    L_0x0021:
        r0 = r6.f11601c;
        r0.setVisibility(r4);
        r0 = r6.f11595E;
        r4 = 0;
        if (r0 != 0) goto L_0x0097;
    L_0x002b:
        r0 = r6.f11598H;
        if (r0 != 0) goto L_0x0031;
    L_0x002f:
        if (r7 == 0) goto L_0x0097;
    L_0x0031:
        r0 = r6.f11601c;
        r0.setTranslationY(r4);
        r0 = r6.f11601c;
        r0 = r0.getHeight();
        r0 = -r0;
        r0 = (float) r0;
        if (r7 == 0) goto L_0x004e;
    L_0x0040:
        r7 = new int[r3];
        r7 = {0, 0};
        r1 = r6.f11601c;
        r1.getLocationInWindow(r7);
        r7 = r7[r5];
        r7 = (float) r7;
        r0 = r0 - r7;
    L_0x004e:
        r7 = r6.f11601c;
        r7.setTranslationY(r0);
        r7 = new android.support.v7.view.ViewPropertyAnimatorCompatSet;
        r7.<init>();
        r1 = r6.f11601c;
        r1 = android.support.v4.view.ViewCompat.m1254o(r1);
        r1 = r1.m1300c(r4);
        r2 = r6.f11616r;
        r1.m1294a(r2);
        r7.m1700a(r1);
        r1 = r6.f11609k;
        if (r1 == 0) goto L_0x0084;
    L_0x006e:
        r1 = r6.f11604f;
        if (r1 == 0) goto L_0x0084;
    L_0x0072:
        r1 = r6.f11604f;
        r1.setTranslationY(r0);
        r0 = r6.f11604f;
        r0 = android.support.v4.view.ViewCompat.m1254o(r0);
        r0 = r0.m1300c(r4);
        r7.m1700a(r0);
    L_0x0084:
        r0 = f11590u;
        r7.m1702a(r0);
        r7.m1705c();
        r0 = r6.f11615q;
        r7.m1701a(r0);
        r6.f11612n = r7;
        r7.m1703a();
        goto L_0x00b3;
    L_0x0097:
        r7 = r6.f11601c;
        r7.setAlpha(r2);
        r7 = r6.f11601c;
        r7.setTranslationY(r4);
        r7 = r6.f11609k;
        if (r7 == 0) goto L_0x00ae;
    L_0x00a5:
        r7 = r6.f11604f;
        if (r7 == 0) goto L_0x00ae;
    L_0x00a9:
        r7 = r6.f11604f;
        r7.setTranslationY(r4);
    L_0x00ae:
        r7 = r6.f11615q;
        r7.mo378b(r1);
    L_0x00b3:
        r7 = r6.f11600b;
        if (r7 == 0) goto L_0x00bc;
    L_0x00b7:
        r7 = r6.f11600b;
        android.support.v4.view.ViewCompat.m1264y(r7);
    L_0x00bc:
        return;
    L_0x00bd:
        r0 = r6.f11597G;
        if (r0 == 0) goto L_0x013c;
    L_0x00c1:
        r6.f11597G = r4;
        r0 = r6.f11612n;
        if (r0 == 0) goto L_0x00cc;
    L_0x00c7:
        r0 = r6.f11612n;
        r0.m1704b();
    L_0x00cc:
        r0 = r6.f11595E;
        if (r0 != 0) goto L_0x0137;
    L_0x00d0:
        r0 = r6.f11598H;
        if (r0 != 0) goto L_0x00d6;
    L_0x00d4:
        if (r7 == 0) goto L_0x0137;
    L_0x00d6:
        r0 = r6.f11601c;
        r0.setAlpha(r2);
        r0 = r6.f11601c;
        r0.setTransitioning(r5);
        r0 = new android.support.v7.view.ViewPropertyAnimatorCompatSet;
        r0.<init>();
        r1 = r6.f11601c;
        r1 = r1.getHeight();
        r1 = -r1;
        r1 = (float) r1;
        if (r7 == 0) goto L_0x00fd;
    L_0x00ef:
        r7 = new int[r3];
        r7 = {0, 0};
        r2 = r6.f11601c;
        r2.getLocationInWindow(r7);
        r7 = r7[r5];
        r7 = (float) r7;
        r1 = r1 - r7;
    L_0x00fd:
        r7 = r6.f11601c;
        r7 = android.support.v4.view.ViewCompat.m1254o(r7);
        r7 = r7.m1300c(r1);
        r2 = r6.f11616r;
        r7.m1294a(r2);
        r0.m1700a(r7);
        r7 = r6.f11609k;
        if (r7 == 0) goto L_0x0124;
    L_0x0113:
        r7 = r6.f11604f;
        if (r7 == 0) goto L_0x0124;
    L_0x0117:
        r7 = r6.f11604f;
        r7 = android.support.v4.view.ViewCompat.m1254o(r7);
        r7 = r7.m1300c(r1);
        r0.m1700a(r7);
    L_0x0124:
        r7 = f11589t;
        r0.m1702a(r7);
        r0.m1705c();
        r7 = r6.f11614p;
        r0.m1701a(r7);
        r6.f11612n = r0;
        r0.m1703a();
        return;
    L_0x0137:
        r7 = r6.f11614p;
        r7.mo378b(r1);
    L_0x013c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.WindowDecorActionBar.j(boolean):void");
    }

    public final Context mo451e() {
        if (this.f11617v == null) {
            TypedValue typedValue = new TypedValue();
            this.f11599a.getTheme().resolveAttribute(C0164R.attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f11617v = new ContextThemeWrapper(this.f11599a, i);
            } else {
                this.f11617v = this.f11599a;
            }
        }
        return this.f11617v;
    }

    public final void mo439a(Drawable drawable) {
        this.f11602d.mo747b(drawable);
    }

    public final void mo453f() {
        this.f11602d.mo765q();
    }

    public final void mo480n() {
        if (this.f11612n != null) {
            this.f11612n.m1704b();
            this.f11612n = null;
        }
    }

    public final boolean mo458j() {
        if (this.f11602d == null || !this.f11602d.mo750c()) {
            return false;
        }
        this.f11602d.mo751d();
        return true;
    }

    public final void mo449d(boolean z) {
        if (!this.f11591A) {
            mo446b(z);
        }
    }

    public final boolean mo442a(int i, KeyEvent keyEvent) {
        if (this.f11606h == null) {
            return false;
        }
        Menu menu = this.f11606h.f11583a;
        if (menu == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        menu.setQwertyMode(z);
        return menu.performShortcut(i, keyEvent, 0);
    }

    public final boolean mo450d() {
        int height = this.f11601c.getHeight();
        return this.f11597G && (height == 0 || this.f11600b.getActionBarHideOffset() < height);
    }

    public final void m10328h(boolean z) {
        if (z) {
            if (!this.f11596F) {
                this.f11596F = true;
                if (this.f11600b != null) {
                    this.f11600b.setShowingForActionMode(true);
                }
                m10306j(false);
            }
        } else if (this.f11596F) {
            this.f11596F = false;
            if (this.f11600b != null) {
                this.f11600b.setShowingForActionMode(false);
            }
            m10306j(false);
        }
        if (ViewCompat.m1206G(this.f11601c)) {
            ViewPropertyAnimatorCompat a;
            if (z) {
                z = this.f11602d.mo735a(4, 100);
                a = this.f11603e.mo548a(0, 200);
            } else {
                a = this.f11602d.mo735a(0, 200);
                z = this.f11603e.mo548a(8, 100);
            }
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            viewPropertyAnimatorCompatSet.f2010a.add(z);
            View view = (View) z.f1485a.get();
            a.m1298b(view != null ? view.animate().getDuration() : 0);
            viewPropertyAnimatorCompatSet.f2010a.add(a);
            viewPropertyAnimatorCompatSet.m1703a();
        } else if (z) {
            this.f11602d.mo752d(4);
            this.f11603e.setVisibility(0);
        } else {
            this.f11602d.mo752d(0);
            this.f11603e.setVisibility(8);
        }
    }
}
