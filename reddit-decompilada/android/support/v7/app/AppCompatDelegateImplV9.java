package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NavUtils;
import android.support.v4.util.LongSparseArray;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.appcompat.C0164R;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.view.menu.ExpandedMenuView;
import android.support.v7.view.menu.ListMenuPresenter;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.ContentFrameLayout.OnAttachListener;
import android.support.v7.widget.DecorContentParent;
import android.support.v7.widget.FitWindowsViewGroup;
import android.support.v7.widget.FitWindowsViewGroup.OnFitSystemWindowsListener;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewUtils;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.instabug.chat.model.Attachment;

@RequiresApi(14)
class AppCompatDelegateImplV9 extends AppCompatDelegateImplBase implements Callback, Factory2 {
    private static final boolean f16543p = (VERSION.SDK_INT < 21);
    private PanelMenuPresenterCallback f16544A;
    private boolean f16545B;
    private TextView f16546C;
    private View f16547D;
    private boolean f16548E;
    private boolean f16549F;
    private boolean f16550G;
    private PanelFeatureState[] f16551H;
    private PanelFeatureState f16552I;
    private boolean f16553J;
    private final Runnable f16554K = new C01601(this);
    private boolean f16555L;
    private Rect f16556M;
    private Rect f16557N;
    private AppCompatViewInflater f16558O;
    ActionMode f16559q;
    ActionBarContextView f16560r;
    PopupWindow f16561s;
    Runnable f16562t;
    ViewPropertyAnimatorCompat f16563u = null;
    ViewGroup f16564v;
    boolean f16565w;
    int f16566x;
    private DecorContentParent f16567y;
    private ActionMenuPresenterCallback f16568z;

    class C01601 implements Runnable {
        final /* synthetic */ AppCompatDelegateImplV9 f1812a;

        C01601(AppCompatDelegateImplV9 appCompatDelegateImplV9) {
            this.f1812a = appCompatDelegateImplV9;
        }

        public void run() {
            if ((this.f1812a.f16566x & 1) != 0) {
                this.f1812a.m16759i(0);
            }
            if ((this.f1812a.f16566x & 4096) != 0) {
                this.f1812a.m16759i(108);
            }
            this.f1812a.f16565w = false;
            this.f1812a.f16566x = 0;
        }
    }

    class C01615 implements Runnable {
        final /* synthetic */ AppCompatDelegateImplV9 f1813a;

        class C15891 extends ViewPropertyAnimatorListenerAdapter {
            final /* synthetic */ C01615 f16540a;

            C15891(C01615 c01615) {
                this.f16540a = c01615;
            }

            public final void mo377a(View view) {
                this.f16540a.f1813a.f16560r.setVisibility(0);
            }

            public final void mo378b(View view) {
                this.f16540a.f1813a.f16560r.setAlpha(1.0f);
                this.f16540a.f1813a.f16563u.m1293a(null);
                this.f16540a.f1813a.f16563u = null;
            }
        }

        C01615(AppCompatDelegateImplV9 appCompatDelegateImplV9) {
            this.f1813a = appCompatDelegateImplV9;
        }

        public void run() {
            this.f1813a.f16561s.showAtLocation(this.f1813a.f16560r, 55, 0, 0);
            this.f1813a.m16763o();
            if (this.f1813a.m16762n()) {
                this.f1813a.f16560r.setAlpha(0.0f);
                this.f1813a.f16563u = ViewCompat.m1254o(this.f1813a.f16560r).m1291a(1.0f);
                this.f1813a.f16563u.m1293a(new C15891(this));
                return;
            }
            this.f1813a.f16560r.setAlpha(1.0f);
            this.f1813a.f16560r.setVisibility(0);
        }
    }

    protected static final class PanelFeatureState {
        int background;
        View createdPanelView;
        ViewGroup decorView;
        int featureId;
        Bundle frozenActionViewState;
        Bundle frozenMenuState;
        int gravity;
        boolean isHandled;
        boolean isOpen;
        boolean isPrepared;
        ListMenuPresenter listMenuPresenter;
        Context listPresenterContext;
        MenuBuilder menu;
        public boolean qwertyMode;
        boolean refreshDecorView = false;
        boolean refreshMenuContent;
        View shownPanelView;
        boolean wasLastOpen;
        int windowAnimations;
        int f1817x;
        int f1818y;

        private static class SavedState implements Parcelable {
            public static final Creator<SavedState> CREATOR = new C01621();
            int f1814a;
            boolean f1815b;
            Bundle f1816c;

            static class C01621 implements ClassLoaderCreator<SavedState> {
                C01621() {
                }

                public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.m1550a(parcel, classLoader);
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new SavedState[i];
                }

                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    return SavedState.m1550a(parcel, null);
                }
            }

            public int describeContents() {
                return 0;
            }

            SavedState() {
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f1814a);
                parcel.writeInt(this.f1815b);
                if (this.f1815b != 0) {
                    parcel.writeBundle(this.f1816c);
                }
            }

            static SavedState m1550a(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.f1814a = parcel.readInt();
                boolean z = true;
                if (parcel.readInt() != 1) {
                    z = false;
                }
                savedState.f1815b = z;
                if (savedState.f1815b) {
                    savedState.f1816c = parcel.readBundle(classLoader);
                }
                return savedState;
            }
        }

        PanelFeatureState(int i) {
            this.featureId = i;
        }

        public final boolean hasPanelItems() {
            if (this.shownPanelView == null) {
                return false;
            }
            if (this.createdPanelView == null && this.listMenuPresenter.m10468d().getCount() <= 0) {
                return false;
            }
            return true;
        }

        public final void clearMenuPresenters() {
            if (this.menu != null) {
                this.menu.removeMenuPresenter(this.listMenuPresenter);
            }
            this.listMenuPresenter = null;
        }

        final void setStyle(Context context) {
            TypedValue typedValue = new TypedValue();
            Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(C0164R.attr.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(C0164R.attr.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(C0164R.style.Theme_AppCompat_CompactMenu, true);
            }
            Context contextThemeWrapper = new ContextThemeWrapper(context, 0);
            contextThemeWrapper.getTheme().setTo(newTheme);
            this.listPresenterContext = contextThemeWrapper;
            context = contextThemeWrapper.obtainStyledAttributes(C0164R.styleable.AppCompatTheme);
            this.background = context.getResourceId(C0164R.styleable.AppCompatTheme_panelBackground, 0);
            this.windowAnimations = context.getResourceId(C0164R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            context.recycle();
        }

        final void setMenu(MenuBuilder menuBuilder) {
            if (menuBuilder != this.menu) {
                if (this.menu != null) {
                    this.menu.removeMenuPresenter(this.listMenuPresenter);
                }
                this.menu = menuBuilder;
                if (!(menuBuilder == null || this.listMenuPresenter == null)) {
                    menuBuilder.addMenuPresenter(this.listMenuPresenter);
                }
            }
        }

        final MenuView getListMenuView(MenuPresenter.Callback callback) {
            if (this.menu == null) {
                return null;
            }
            if (this.listMenuPresenter == null) {
                this.listMenuPresenter = new ListMenuPresenter(this.listPresenterContext, C0164R.layout.abc_list_menu_item_layout);
                this.listMenuPresenter.f11756h = callback;
                this.menu.addMenuPresenter(this.listMenuPresenter);
            }
            callback = this.listMenuPresenter;
            ViewGroup viewGroup = this.decorView;
            if (callback.f11752d == null) {
                callback.f11752d = (ExpandedMenuView) callback.f11750b.inflate(C0164R.layout.abc_expanded_menu_layout, viewGroup, false);
                if (callback.f11757i == null) {
                    callback.f11757i = new MenuAdapter(callback);
                }
                callback.f11752d.setAdapter(callback.f11757i);
                callback.f11752d.setOnItemClickListener(callback);
            }
            return callback.f11752d;
        }

        final Parcelable onSaveInstanceState() {
            Parcelable savedState = new SavedState();
            savedState.f1814a = this.featureId;
            savedState.f1815b = this.isOpen;
            if (this.menu != null) {
                savedState.f1816c = new Bundle();
                this.menu.savePresenterStates(savedState.f1816c);
            }
            return savedState;
        }

        final void onRestoreInstanceState(Parcelable parcelable) {
            SavedState savedState = (SavedState) parcelable;
            this.featureId = savedState.f1814a;
            this.wasLastOpen = savedState.f1815b;
            this.frozenMenuState = savedState.f1816c;
            this.shownPanelView = null;
            this.decorView = null;
        }

        final void applyFrozenState() {
            if (this.menu != null && this.frozenMenuState != null) {
                this.menu.restorePresenterStates(this.frozenMenuState);
                this.frozenMenuState = null;
            }
        }
    }

    class C10112 implements OnApplyWindowInsetsListener {
        final /* synthetic */ AppCompatDelegateImplV9 f11560a;

        C10112(AppCompatDelegateImplV9 appCompatDelegateImplV9) {
            this.f11560a = appCompatDelegateImplV9;
        }

        public final WindowInsetsCompat mo56a(View view, WindowInsetsCompat windowInsetsCompat) {
            int b = windowInsetsCompat.m1309b();
            int j = this.f11560a.m16760j(b);
            if (b != j) {
                windowInsetsCompat = windowInsetsCompat.m1308a(windowInsetsCompat.m1307a(), j, windowInsetsCompat.m1310c(), windowInsetsCompat.m1311d());
            }
            return ViewCompat.m1212a(view, windowInsetsCompat);
        }
    }

    class C10123 implements OnFitSystemWindowsListener {
        final /* synthetic */ AppCompatDelegateImplV9 f11561a;

        C10123(AppCompatDelegateImplV9 appCompatDelegateImplV9) {
            this.f11561a = appCompatDelegateImplV9;
        }

        public final void mo426a(Rect rect) {
            rect.top = this.f11561a.m16760j(rect.top);
        }
    }

    class C10134 implements OnAttachListener {
        final /* synthetic */ AppCompatDelegateImplV9 f11562a;

        C10134(AppCompatDelegateImplV9 appCompatDelegateImplV9) {
            this.f11562a = appCompatDelegateImplV9;
        }

        public final void mo427a() {
            this.f11562a.m16765q();
        }
    }

    private final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        final /* synthetic */ AppCompatDelegateImplV9 f11563a;

        ActionMenuPresenterCallback(AppCompatDelegateImplV9 appCompatDelegateImplV9) {
            this.f11563a = appCompatDelegateImplV9;
        }

        public final boolean mo429a(MenuBuilder menuBuilder) {
            Window.Callback callback = this.f11563a.f11546c.getCallback();
            if (callback != null) {
                callback.onMenuOpened(108, menuBuilder);
            }
            return true;
        }

        public final void mo428a(MenuBuilder menuBuilder, boolean z) {
            this.f11563a.m16746b(menuBuilder);
        }
    }

    class ActionModeCallbackWrapperV9 implements ActionMode.Callback {
        final /* synthetic */ AppCompatDelegateImplV9 f11564a;
        private ActionMode.Callback f11565b;

        class C15911 extends ViewPropertyAnimatorListenerAdapter {
            final /* synthetic */ ActionModeCallbackWrapperV9 f16542a;

            C15911(ActionModeCallbackWrapperV9 actionModeCallbackWrapperV9) {
                this.f16542a = actionModeCallbackWrapperV9;
            }

            public final void mo378b(View view) {
                this.f16542a.f11564a.f16560r.setVisibility(8);
                if (this.f16542a.f11564a.f16561s != null) {
                    this.f16542a.f11564a.f16561s.dismiss();
                } else if ((this.f16542a.f11564a.f16560r.getParent() instanceof View) != null) {
                    ViewCompat.m1264y((View) this.f16542a.f11564a.f16560r.getParent());
                }
                this.f16542a.f11564a.f16560r.removeAllViews();
                this.f16542a.f11564a.f16563u.m1293a(null);
                this.f16542a.f11564a.f16563u = null;
            }
        }

        public ActionModeCallbackWrapperV9(AppCompatDelegateImplV9 appCompatDelegateImplV9, ActionMode.Callback callback) {
            this.f11564a = appCompatDelegateImplV9;
            this.f11565b = callback;
        }

        public final boolean mo431a(ActionMode actionMode, Menu menu) {
            return this.f11565b.mo431a(actionMode, menu);
        }

        public final boolean mo433b(ActionMode actionMode, Menu menu) {
            return this.f11565b.mo433b(actionMode, menu);
        }

        public final boolean mo432a(ActionMode actionMode, MenuItem menuItem) {
            return this.f11565b.mo432a(actionMode, menuItem);
        }

        public final void mo430a(ActionMode actionMode) {
            this.f11565b.mo430a(actionMode);
            if (this.f11564a.f16561s != null) {
                this.f11564a.c.getDecorView().removeCallbacks(this.f11564a.f16562t);
            }
            if (this.f11564a.f16560r != null) {
                this.f11564a.m16763o();
                this.f11564a.f16563u = ViewCompat.m1254o(this.f11564a.f16560r).m1291a(0.0f);
                this.f11564a.f16563u.m1293a(new C15911(this));
            }
            if (this.f11564a.f != null) {
                actionMode = this.f11564a.f;
                actionMode = this.f11564a.f16559q;
            }
            this.f11564a.f16559q = null;
        }
    }

    private class ListMenuDecorView extends ContentFrameLayout {
        final /* synthetic */ AppCompatDelegateImplV9 f11566a;

        public ListMenuDecorView(AppCompatDelegateImplV9 appCompatDelegateImplV9, Context context) {
            this.f11566a = appCompatDelegateImplV9;
            super(context);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (!this.f11566a.mo3171a(keyEvent)) {
                if (super.dispatchKeyEvent(keyEvent) == null) {
                    return null;
                }
            }
            return true;
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                boolean z;
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (x >= -5 && y >= -5 && x <= getWidth() + 5) {
                    if (y <= getHeight() + 5) {
                        z = false;
                        if (z) {
                            this.f11566a.m16764p();
                            return true;
                        }
                    }
                }
                z = true;
                if (z) {
                    this.f11566a.m16764p();
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        public void setBackgroundResource(int i) {
            setBackgroundDrawable(AppCompatResources.m1570b(getContext(), i));
        }
    }

    private final class PanelMenuPresenterCallback implements MenuPresenter.Callback {
        final /* synthetic */ AppCompatDelegateImplV9 f11567a;

        PanelMenuPresenterCallback(AppCompatDelegateImplV9 appCompatDelegateImplV9) {
            this.f11567a = appCompatDelegateImplV9;
        }

        public final void mo428a(MenuBuilder menuBuilder, boolean z) {
            Menu menu;
            Menu rootMenu = menuBuilder.getRootMenu();
            boolean z2 = rootMenu != menuBuilder;
            AppCompatDelegateImplV9 appCompatDelegateImplV9 = this.f11567a;
            if (z2) {
                menu = rootMenu;
            }
            PanelFeatureState a = appCompatDelegateImplV9.m16731a(menu);
            if (a != null) {
                if (z2) {
                    this.f11567a.m16734a(a.featureId, a, rootMenu);
                    this.f11567a.m16737a(a, true);
                    return;
                }
                this.f11567a.m16737a(a, z);
            }
        }

        public final boolean mo429a(MenuBuilder menuBuilder) {
            if (menuBuilder == null && this.f11567a.i) {
                Window.Callback callback = this.f11567a.f11546c.getCallback();
                if (!(callback == null || this.f11567a.f11558o)) {
                    callback.onMenuOpened(108, menuBuilder);
                }
            }
            return true;
        }
    }

    class C15906 extends ViewPropertyAnimatorListenerAdapter {
        final /* synthetic */ AppCompatDelegateImplV9 f16541a;

        C15906(AppCompatDelegateImplV9 appCompatDelegateImplV9) {
            this.f16541a = appCompatDelegateImplV9;
        }

        public final void mo377a(View view) {
            this.f16541a.f16560r.setVisibility(0);
            this.f16541a.f16560r.sendAccessibilityEvent(32);
            if ((this.f16541a.f16560r.getParent() instanceof View) != null) {
                ViewCompat.m1264y((View) this.f16541a.f16560r.getParent());
            }
        }

        public final void mo378b(View view) {
            this.f16541a.f16560r.setAlpha(1.0f);
            this.f16541a.f16563u.m1293a(null);
            this.f16541a.f16563u = null;
        }
    }

    AppCompatDelegateImplV9(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
    }

    public void mo3166a(Bundle bundle) {
        if (!((this.d instanceof Activity) == null || NavUtils.m667b((Activity) this.d) == null)) {
            bundle = this.f11550g;
            if (bundle == null) {
                this.f16555L = true;
                return;
            }
            bundle.mo449d(true);
        }
    }

    public final void mo3175c() {
        m16729r();
    }

    public final void mo3182l() {
        m16729r();
        if (this.i) {
            if (this.g == null) {
                if (this.d instanceof Activity) {
                    this.g = new WindowDecorActionBar((Activity) this.d, this.j);
                } else if (this.d instanceof Dialog) {
                    this.g = new WindowDecorActionBar((Dialog) this.d);
                }
                if (this.g != null) {
                    this.g.mo449d(this.f16555L);
                }
            }
        }
    }

    public final void mo3167a(Toolbar toolbar) {
        if (this.d instanceof Activity) {
            ActionBar a = mo417a();
            if (a instanceof WindowDecorActionBar) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.h = null;
            if (a != null) {
                a.mo459k();
            }
            if (toolbar != null) {
                a = new ToolbarActionBar(toolbar, ((Activity) this.d).getTitle(), this.e);
                this.g = a;
                this.c.setCallback(a.f11576c);
            } else {
                this.g = null;
                this.c.setCallback(this.e);
            }
            mo3180g();
        }
    }

    public final <T extends View> T mo3164a(int i) {
        m16729r();
        return this.c.findViewById(i);
    }

    public final void mo3165a(Configuration configuration) {
        if (this.i && this.f16545B) {
            ActionBar a = mo417a();
            if (a != null) {
                a.mo438a(configuration);
            }
        }
        configuration = AppCompatDrawableManager.m1809a();
        Context context = this.b;
        synchronized (configuration.f2149a) {
            LongSparseArray longSparseArray = (LongSparseArray) configuration.f2150b.get(context);
            if (longSparseArray != null) {
                longSparseArray.m1020c();
            }
        }
        mo425j();
    }

    public void mo423e() {
        ActionBar a = mo417a();
        if (a != null) {
            a.mo452e(false);
        }
    }

    public final void mo3178f() {
        ActionBar a = mo417a();
        if (a != null) {
            a.mo452e(true);
        }
    }

    public final void mo3168a(View view) {
        m16729r();
        ViewGroup viewGroup = (ViewGroup) this.f16564v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.d.onContentChanged();
    }

    public final void mo3172b(int i) {
        m16729r();
        ViewGroup viewGroup = (ViewGroup) this.f16564v.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.b).inflate(i, viewGroup);
        this.d.onContentChanged();
    }

    public final void mo3169a(View view, LayoutParams layoutParams) {
        m16729r();
        ViewGroup viewGroup = (ViewGroup) this.f16564v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.d.onContentChanged();
    }

    public final void mo3173b(View view, LayoutParams layoutParams) {
        m16729r();
        ((ViewGroup) this.f16564v.findViewById(16908290)).addView(view, layoutParams);
        this.d.onContentChanged();
    }

    public void mo424h() {
        if (this.f16565w) {
            this.c.getDecorView().removeCallbacks(this.f16554K);
        }
        super.mo424h();
        if (this.g != null) {
            this.g.mo459k();
        }
    }

    private void m16729r() {
        if (!this.f16545B) {
            TypedArray obtainStyledAttributes = this.b.obtainStyledAttributes(C0164R.styleable.AppCompatTheme);
            if (obtainStyledAttributes.hasValue(C0164R.styleable.AppCompatTheme_windowActionBar)) {
                View view;
                if (obtainStyledAttributes.getBoolean(C0164R.styleable.AppCompatTheme_windowNoTitle, false)) {
                    mo3176c(1);
                } else if (obtainStyledAttributes.getBoolean(C0164R.styleable.AppCompatTheme_windowActionBar, false)) {
                    mo3176c(108);
                }
                if (obtainStyledAttributes.getBoolean(C0164R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
                    mo3176c(109);
                }
                if (obtainStyledAttributes.getBoolean(C0164R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
                    mo3176c(10);
                }
                this.l = obtainStyledAttributes.getBoolean(C0164R.styleable.AppCompatTheme_android_windowIsFloating, false);
                obtainStyledAttributes.recycle();
                this.c.getDecorView();
                LayoutInflater from = LayoutInflater.from(this.b);
                if (this.m) {
                    if (this.k) {
                        view = (ViewGroup) from.inflate(C0164R.layout.abc_screen_simple_overlay_action_mode, null);
                    } else {
                        view = (ViewGroup) from.inflate(C0164R.layout.abc_screen_simple, null);
                    }
                    if (VERSION.SDK_INT >= 21) {
                        ViewCompat.m1221a(view, new C10112(this));
                    } else {
                        ((FitWindowsViewGroup) view).setOnFitSystemWindowsListener(new C10123(this));
                    }
                } else if (this.l) {
                    view = (ViewGroup) from.inflate(C0164R.layout.abc_dialog_title_material, null);
                    this.j = false;
                    this.i = false;
                } else if (this.i) {
                    Context contextThemeWrapper;
                    TypedValue typedValue = new TypedValue();
                    this.b.getTheme().resolveAttribute(C0164R.attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        contextThemeWrapper = new ContextThemeWrapper(this.b, typedValue.resourceId);
                    } else {
                        contextThemeWrapper = this.b;
                    }
                    view = (ViewGroup) LayoutInflater.from(contextThemeWrapper).inflate(C0164R.layout.abc_screen_toolbar, null);
                    this.f16567y = (DecorContentParent) view.findViewById(C0164R.id.decor_content_parent);
                    this.f16567y.setWindowCallback(this.f11546c.getCallback());
                    if (this.j) {
                        this.f16567y.mo556a(109);
                    }
                    if (this.f16548E) {
                        this.f16567y.mo556a(2);
                    }
                    if (this.f16549F) {
                        this.f16567y.mo556a(5);
                    }
                } else {
                    view = null;
                }
                if (view == null) {
                    StringBuilder stringBuilder = new StringBuilder("AppCompat does not support the current theme features: { windowActionBar: ");
                    stringBuilder.append(this.i);
                    stringBuilder.append(", windowActionBarOverlay: ");
                    stringBuilder.append(this.j);
                    stringBuilder.append(", android:windowIsFloating: ");
                    stringBuilder.append(this.l);
                    stringBuilder.append(", windowActionModeOverlay: ");
                    stringBuilder.append(this.k);
                    stringBuilder.append(", windowNoTitle: ");
                    stringBuilder.append(this.m);
                    stringBuilder.append(" }");
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                CharSequence title;
                if (this.f16567y == null) {
                    this.f16546C = (TextView) view.findViewById(C0164R.id.title);
                }
                ViewUtils.m2391b(view);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view.findViewById(C0164R.id.action_bar_activity_content);
                ViewGroup viewGroup = (ViewGroup) this.c.findViewById(16908290);
                if (viewGroup != null) {
                    while (viewGroup.getChildCount() > 0) {
                        View childAt = viewGroup.getChildAt(0);
                        viewGroup.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup instanceof FrameLayout) {
                        ((FrameLayout) viewGroup).setForeground(null);
                    }
                }
                this.c.setContentView(view);
                contentFrameLayout.setAttachListener(new C10134(this));
                this.f16564v = view;
                if (this.f11547d instanceof Activity) {
                    title = ((Activity) this.f11547d).getTitle();
                } else {
                    title = this.f11557n;
                }
                if (!TextUtils.isEmpty(title)) {
                    mo3174b(title);
                }
                ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.f16564v.findViewById(16908290);
                View decorView = this.c.getDecorView();
                contentFrameLayout2.f2213b.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
                if (ViewCompat.m1206G(contentFrameLayout2)) {
                    contentFrameLayout2.requestLayout();
                }
                TypedArray obtainStyledAttributes2 = this.b.obtainStyledAttributes(C0164R.styleable.AppCompatTheme);
                obtainStyledAttributes2.getValue(C0164R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout2.getMinWidthMajor());
                obtainStyledAttributes2.getValue(C0164R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout2.getMinWidthMinor());
                if (obtainStyledAttributes2.hasValue(C0164R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
                    obtainStyledAttributes2.getValue(C0164R.styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout2.getFixedWidthMajor());
                }
                if (obtainStyledAttributes2.hasValue(C0164R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
                    obtainStyledAttributes2.getValue(C0164R.styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout2.getFixedWidthMinor());
                }
                if (obtainStyledAttributes2.hasValue(C0164R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
                    obtainStyledAttributes2.getValue(C0164R.styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout2.getFixedHeightMajor());
                }
                if (obtainStyledAttributes2.hasValue(C0164R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
                    obtainStyledAttributes2.getValue(C0164R.styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout2.getFixedHeightMinor());
                }
                obtainStyledAttributes2.recycle();
                contentFrameLayout2.requestLayout();
                this.f16545B = true;
                PanelFeatureState h = m16756h(0);
                if (!this.f11558o) {
                    if (h == null || h.menu == null) {
                        mo4225g(108);
                        return;
                    }
                    return;
                }
                return;
            }
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
    }

    final void mo3174b(CharSequence charSequence) {
        if (this.f16567y != null) {
            this.f16567y.setWindowTitle(charSequence);
        } else if (this.f11550g != null) {
            this.f11550g.mo445b(charSequence);
        } else {
            if (this.f16546C != null) {
                this.f16546C.setText(charSequence);
            }
        }
    }

    final void mo3177e(int i) {
        if (i == 108) {
            i = mo417a();
            if (i != 0) {
                i.mo454f(false);
            }
            return;
        }
        if (i == 0) {
            PanelFeatureState h = m16756h(i);
            if (h.isOpen) {
                m16737a(h, false);
            }
        }
    }

    final boolean mo3179f(int i) {
        if (i != 108) {
            return false;
        }
        i = mo417a();
        if (i != 0) {
            i.mo454f(true);
        }
        return true;
    }

    public final void mo3180g() {
        ActionBar a = mo417a();
        if (a == null || !a.mo457i()) {
            mo4225g(0);
        }
    }

    final boolean m16762n() {
        return this.f16545B && this.f16564v != null && ViewCompat.m1206G(this.f16564v);
    }

    final void m16763o() {
        if (this.f16563u != null) {
            this.f16563u.m1296a();
        }
    }

    final boolean mo3170a(int i, KeyEvent keyEvent) {
        ActionBar a = mo417a();
        if (a != null && a.mo442a(i, keyEvent) != 0) {
            return true;
        }
        if (this.f16552I == 0 || m16726a(this.f16552I, keyEvent.getKeyCode(), keyEvent) == 0) {
            if (this.f16552I == 0) {
                PanelFeatureState h = m16756h(0);
                m16727b(h, keyEvent);
                keyEvent = m16726a(h, keyEvent.getKeyCode(), keyEvent);
                h.isPrepared = false;
                if (keyEvent != null) {
                    return true;
                }
            }
            return false;
        }
        if (this.f16552I != 0) {
            this.f16552I.isHandled = true;
        }
        return true;
    }

    final boolean mo3171a(KeyEvent keyEvent) {
        boolean z = true;
        if (keyEvent.getKeyCode() == 82 && this.d.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        PanelFeatureState h;
        if (keyEvent.getAction() == 0) {
            if (keyCode == 4) {
                if ((keyEvent.getFlags() & 128) == null) {
                    z = false;
                }
                this.f16553J = z;
            } else if (keyCode == 82) {
                if (keyEvent.getRepeatCount() == 0) {
                    h = m16756h(0);
                    if (!h.isOpen) {
                        m16727b(h, keyEvent);
                    }
                }
                return true;
            }
            return false;
        }
        if (keyCode == 4) {
            keyEvent = this.f16553J;
            this.f16553J = false;
            h = m16756h(0);
            if (h == null || !h.isOpen) {
                if (this.f16559q != null) {
                    this.f16559q.mo469c();
                } else {
                    keyEvent = mo417a();
                    if (keyEvent == null || keyEvent.mo458j() == null) {
                        keyEvent = null;
                        if (keyEvent == null) {
                            return true;
                        }
                    }
                }
                keyEvent = 1;
                if (keyEvent == null) {
                    return false;
                }
                return true;
            }
            if (keyEvent == null) {
                m16737a(h, true);
            }
            return true;
        } else if (keyCode == 82) {
            if (this.f16559q == null) {
                AudioManager audioManager;
                h = m16756h(0);
                if (this.f16567y == null || !this.f16567y.mo558b() || ViewConfiguration.get(this.b).hasPermanentMenuKey()) {
                    if (!h.isOpen) {
                        if (!h.isHandled) {
                            if (h.isPrepared) {
                                boolean b;
                                if (h.refreshMenuContent) {
                                    h.isPrepared = false;
                                    b = m16727b(h, keyEvent);
                                } else {
                                    b = true;
                                }
                                if (b) {
                                    m16725a(h, keyEvent);
                                    keyEvent = 1;
                                    if (keyEvent != null) {
                                        audioManager = (AudioManager) this.b.getSystemService(Attachment.TYPE_AUDIO);
                                        if (audioManager == null) {
                                            audioManager.playSoundEffect(0);
                                        } else {
                                            Log.w("AppCompatDelegate", "Couldn't get audio manager");
                                        }
                                    }
                                }
                            }
                        }
                    }
                    keyEvent = h.isOpen;
                    m16737a(h, true);
                    if (keyEvent != null) {
                        audioManager = (AudioManager) this.b.getSystemService(Attachment.TYPE_AUDIO);
                        if (audioManager == null) {
                            Log.w("AppCompatDelegate", "Couldn't get audio manager");
                        } else {
                            audioManager.playSoundEffect(0);
                        }
                    }
                } else {
                    if (this.f16567y.mo559c()) {
                        keyEvent = this.f16567y.mo562f();
                    } else if (!(this.f11558o || m16727b(h, keyEvent) == null)) {
                        keyEvent = this.f16567y.mo561e();
                    }
                    if (keyEvent != null) {
                        audioManager = (AudioManager) this.b.getSystemService(Attachment.TYPE_AUDIO);
                        if (audioManager == null) {
                            audioManager.playSoundEffect(0);
                        } else {
                            Log.w("AppCompatDelegate", "Couldn't get audio manager");
                        }
                    }
                }
                keyEvent = null;
                if (keyEvent != null) {
                    audioManager = (AudioManager) this.b.getSystemService(Attachment.TYPE_AUDIO);
                    if (audioManager == null) {
                        Log.w("AppCompatDelegate", "Couldn't get audio manager");
                    } else {
                        audioManager.playSoundEffect(0);
                    }
                }
            }
            return true;
        }
        return false;
    }

    public final void mo3181i() {
        LayoutInflater from = LayoutInflater.from(this.b);
        if (from.getFactory() == null) {
            LayoutInflaterCompat.m1100b(from, this);
            return;
        }
        if (!(from.getFactory2() instanceof AppCompatDelegateImplV9)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.View r7, java.lang.String r8, android.content.Context r9, android.util.AttributeSet r10) {
        /*
        r6 = this;
        r0 = r6.mo3844a(r8, r9, r10);
        if (r0 == 0) goto L_0x0007;
    L_0x0006:
        return r0;
    L_0x0007:
        r0 = r6.f16558O;
        if (r0 != 0) goto L_0x0012;
    L_0x000b:
        r0 = new android.support.v7.app.AppCompatViewInflater;
        r0.<init>();
        r6.f16558O = r0;
    L_0x0012:
        r0 = f16543p;
        r1 = 1;
        r2 = 0;
        if (r0 == 0) goto L_0x004b;
    L_0x0018:
        r0 = r10 instanceof org.xmlpull.v1.XmlPullParser;
        if (r0 == 0) goto L_0x0027;
    L_0x001c:
        r0 = r10;
        r0 = (org.xmlpull.v1.XmlPullParser) r0;
        r0 = r0.getDepth();
        if (r0 <= r1) goto L_0x004b;
    L_0x0025:
        r0 = r1;
        goto L_0x004c;
    L_0x0027:
        r0 = r7;
        r0 = (android.view.ViewParent) r0;
        if (r0 != 0) goto L_0x002d;
    L_0x002c:
        goto L_0x004b;
    L_0x002d:
        r3 = r6.c;
        r3 = r3.getDecorView();
    L_0x0033:
        if (r0 != 0) goto L_0x0036;
    L_0x0035:
        goto L_0x0025;
    L_0x0036:
        if (r0 == r3) goto L_0x004b;
    L_0x0038:
        r4 = r0 instanceof android.view.View;
        if (r4 == 0) goto L_0x004b;
    L_0x003c:
        r4 = r0;
        r4 = (android.view.View) r4;
        r4 = android.support.v4.view.ViewCompat.m1209J(r4);
        if (r4 == 0) goto L_0x0046;
    L_0x0045:
        goto L_0x004b;
    L_0x0046:
        r0 = r0.getParent();
        goto L_0x0033;
    L_0x004b:
        r0 = r2;
    L_0x004c:
        r3 = r6.f16558O;
        r4 = f16543p;
        r5 = android.support.v7.widget.VectorEnabledTintResources.m2359a();
        if (r0 == 0) goto L_0x005d;
    L_0x0056:
        if (r7 == 0) goto L_0x005d;
    L_0x0058:
        r7 = r7.getContext();
        goto L_0x005e;
    L_0x005d:
        r7 = r9;
    L_0x005e:
        r7 = android.support.v7.app.AppCompatViewInflater.m1551a(r7, r10, r4);
        if (r5 == 0) goto L_0x0068;
    L_0x0064:
        r7 = android.support.v7.widget.TintContextWrapper.m2304a(r7);
    L_0x0068:
        r0 = 0;
        r4 = -1;
        r5 = r8.hashCode();
        switch(r5) {
            case -1946472170: goto L_0x00f2;
            case -1455429095: goto L_0x00e7;
            case -1346021293: goto L_0x00dc;
            case -938935918: goto L_0x00d2;
            case -937446323: goto L_0x00c8;
            case -658531749: goto L_0x00bd;
            case -339785223: goto L_0x00b3;
            case 776382189: goto L_0x00a9;
            case 1125864064: goto L_0x00a0;
            case 1413872058: goto L_0x0094;
            case 1601505219: goto L_0x0089;
            case 1666676343: goto L_0x007e;
            case 2001146706: goto L_0x0073;
            default: goto L_0x0071;
        };
    L_0x0071:
        goto L_0x00fd;
    L_0x0073:
        r1 = "Button";
        r1 = r8.equals(r1);
        if (r1 == 0) goto L_0x00fd;
    L_0x007b:
        r1 = 2;
        goto L_0x00fe;
    L_0x007e:
        r1 = "EditText";
        r1 = r8.equals(r1);
        if (r1 == 0) goto L_0x00fd;
    L_0x0086:
        r1 = 3;
        goto L_0x00fe;
    L_0x0089:
        r1 = "CheckBox";
        r1 = r8.equals(r1);
        if (r1 == 0) goto L_0x00fd;
    L_0x0091:
        r1 = 6;
        goto L_0x00fe;
    L_0x0094:
        r1 = "AutoCompleteTextView";
        r1 = r8.equals(r1);
        if (r1 == 0) goto L_0x00fd;
    L_0x009c:
        r1 = 9;
        goto L_0x00fe;
    L_0x00a0:
        r2 = "ImageView";
        r2 = r8.equals(r2);
        if (r2 == 0) goto L_0x00fd;
    L_0x00a8:
        goto L_0x00fe;
    L_0x00a9:
        r1 = "RadioButton";
        r1 = r8.equals(r1);
        if (r1 == 0) goto L_0x00fd;
    L_0x00b1:
        r1 = 7;
        goto L_0x00fe;
    L_0x00b3:
        r1 = "Spinner";
        r1 = r8.equals(r1);
        if (r1 == 0) goto L_0x00fd;
    L_0x00bb:
        r1 = 4;
        goto L_0x00fe;
    L_0x00bd:
        r1 = "SeekBar";
        r1 = r8.equals(r1);
        if (r1 == 0) goto L_0x00fd;
    L_0x00c5:
        r1 = 12;
        goto L_0x00fe;
    L_0x00c8:
        r1 = "ImageButton";
        r1 = r8.equals(r1);
        if (r1 == 0) goto L_0x00fd;
    L_0x00d0:
        r1 = 5;
        goto L_0x00fe;
    L_0x00d2:
        r1 = "TextView";
        r1 = r8.equals(r1);
        if (r1 == 0) goto L_0x00fd;
    L_0x00da:
        r1 = r2;
        goto L_0x00fe;
    L_0x00dc:
        r1 = "MultiAutoCompleteTextView";
        r1 = r8.equals(r1);
        if (r1 == 0) goto L_0x00fd;
    L_0x00e4:
        r1 = 10;
        goto L_0x00fe;
    L_0x00e7:
        r1 = "CheckedTextView";
        r1 = r8.equals(r1);
        if (r1 == 0) goto L_0x00fd;
    L_0x00ef:
        r1 = 8;
        goto L_0x00fe;
    L_0x00f2:
        r1 = "RatingBar";
        r1 = r8.equals(r1);
        if (r1 == 0) goto L_0x00fd;
    L_0x00fa:
        r1 = 11;
        goto L_0x00fe;
    L_0x00fd:
        r1 = r4;
    L_0x00fe:
        switch(r1) {
            case 0: goto L_0x014a;
            case 1: goto L_0x0144;
            case 2: goto L_0x013e;
            case 3: goto L_0x0138;
            case 4: goto L_0x0132;
            case 5: goto L_0x012c;
            case 6: goto L_0x0126;
            case 7: goto L_0x0120;
            case 8: goto L_0x011a;
            case 9: goto L_0x0114;
            case 10: goto L_0x010e;
            case 11: goto L_0x0108;
            case 12: goto L_0x0102;
            default: goto L_0x0101;
        };
    L_0x0101:
        goto L_0x014f;
    L_0x0102:
        r0 = new android.support.v7.widget.AppCompatSeekBar;
        r0.<init>(r7, r10);
        goto L_0x014f;
    L_0x0108:
        r0 = new android.support.v7.widget.AppCompatRatingBar;
        r0.<init>(r7, r10);
        goto L_0x014f;
    L_0x010e:
        r0 = new android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
        r0.<init>(r7, r10);
        goto L_0x014f;
    L_0x0114:
        r0 = new android.support.v7.widget.AppCompatAutoCompleteTextView;
        r0.<init>(r7, r10);
        goto L_0x014f;
    L_0x011a:
        r0 = new android.support.v7.widget.AppCompatCheckedTextView;
        r0.<init>(r7, r10);
        goto L_0x014f;
    L_0x0120:
        r0 = new android.support.v7.widget.AppCompatRadioButton;
        r0.<init>(r7, r10);
        goto L_0x014f;
    L_0x0126:
        r0 = new android.support.v7.widget.AppCompatCheckBox;
        r0.<init>(r7, r10);
        goto L_0x014f;
    L_0x012c:
        r0 = new android.support.v7.widget.AppCompatImageButton;
        r0.<init>(r7, r10);
        goto L_0x014f;
    L_0x0132:
        r0 = new android.support.v7.widget.AppCompatSpinner;
        r0.<init>(r7, r10);
        goto L_0x014f;
    L_0x0138:
        r0 = new android.support.v7.widget.AppCompatEditText;
        r0.<init>(r7, r10);
        goto L_0x014f;
    L_0x013e:
        r0 = new android.support.v7.widget.AppCompatButton;
        r0.<init>(r7, r10);
        goto L_0x014f;
    L_0x0144:
        r0 = new android.support.v7.widget.AppCompatImageView;
        r0.<init>(r7, r10);
        goto L_0x014f;
    L_0x014a:
        r0 = new android.support.v7.widget.AppCompatTextView;
        r0.<init>(r7, r10);
    L_0x014f:
        if (r0 != 0) goto L_0x0157;
    L_0x0151:
        if (r9 == r7) goto L_0x0157;
    L_0x0153:
        r0 = r3.m1554a(r7, r8, r10);
    L_0x0157:
        if (r0 == 0) goto L_0x015c;
    L_0x0159:
        android.support.v7.app.AppCompatViewInflater.m1553a(r0, r10);
    L_0x015c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatDelegateImplV9.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    View mo3844a(String str, Context context, AttributeSet attributeSet) {
        if (this.d instanceof Factory) {
            str = ((Factory) this.d).onCreateView(str, context, attributeSet);
            if (str != null) {
                return str;
            }
        }
        return null;
    }

    private void m16725a(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        if (!panelFeatureState.isOpen) {
            if (!this.f11558o) {
                if (panelFeatureState.featureId == 0) {
                    if ((this.b.getResources().getConfiguration().screenLayout & 15) == 4) {
                        return;
                    }
                }
                Window.Callback callback = this.f11546c.getCallback();
                if (callback == null || callback.onMenuOpened(panelFeatureState.featureId, panelFeatureState.menu)) {
                    WindowManager windowManager = (WindowManager) this.b.getSystemService("window");
                    if (windowManager != null && m16727b(panelFeatureState, keyEvent) != null) {
                        int i;
                        KeyEvent layoutParams;
                        ViewParent parent;
                        if (panelFeatureState.decorView != null) {
                            if (panelFeatureState.refreshDecorView == null) {
                                if (panelFeatureState.createdPanelView != null) {
                                    keyEvent = panelFeatureState.createdPanelView.getLayoutParams();
                                    if (keyEvent != null && keyEvent.width == -1) {
                                        i = -1;
                                        panelFeatureState.isHandled = false;
                                        layoutParams = new WindowManager.LayoutParams(i, -2, panelFeatureState.f1817x, panelFeatureState.f1818y, 1002, 8519680, -3);
                                        layoutParams.gravity = panelFeatureState.gravity;
                                        layoutParams.windowAnimations = panelFeatureState.windowAnimations;
                                        windowManager.addView(panelFeatureState.decorView, layoutParams);
                                        panelFeatureState.isOpen = true;
                                        return;
                                    }
                                }
                                i = -2;
                                panelFeatureState.isHandled = false;
                                layoutParams = new WindowManager.LayoutParams(i, -2, panelFeatureState.f1817x, panelFeatureState.f1818y, 1002, 8519680, -3);
                                layoutParams.gravity = panelFeatureState.gravity;
                                layoutParams.windowAnimations = panelFeatureState.windowAnimations;
                                windowManager.addView(panelFeatureState.decorView, layoutParams);
                                panelFeatureState.isOpen = true;
                                return;
                            }
                        }
                        if (panelFeatureState.decorView == null) {
                            panelFeatureState.setStyle(m10240m());
                            panelFeatureState.decorView = new ListMenuDecorView(this, panelFeatureState.listPresenterContext);
                            panelFeatureState.gravity = 81;
                            if (panelFeatureState.decorView == null) {
                                return;
                            }
                        } else if (panelFeatureState.refreshDecorView != null && panelFeatureState.decorView.getChildCount() > null) {
                            panelFeatureState.decorView.removeAllViews();
                        }
                        if (panelFeatureState.createdPanelView != null) {
                            panelFeatureState.shownPanelView = panelFeatureState.createdPanelView;
                        } else {
                            if (panelFeatureState.menu != null) {
                                if (this.f16544A == null) {
                                    this.f16544A = new PanelMenuPresenterCallback(this);
                                }
                                panelFeatureState.shownPanelView = (View) panelFeatureState.getListMenuView(this.f16544A);
                                if (panelFeatureState.shownPanelView != null) {
                                }
                            }
                            keyEvent = null;
                            if (keyEvent != null) {
                                if (panelFeatureState.hasPanelItems() == null) {
                                    keyEvent = panelFeatureState.shownPanelView.getLayoutParams();
                                    if (keyEvent == null) {
                                        keyEvent = new LayoutParams(-2, -2);
                                    }
                                    panelFeatureState.decorView.setBackgroundResource(panelFeatureState.background);
                                    parent = panelFeatureState.shownPanelView.getParent();
                                    if (parent != null && (parent instanceof ViewGroup)) {
                                        ((ViewGroup) parent).removeView(panelFeatureState.shownPanelView);
                                    }
                                    panelFeatureState.decorView.addView(panelFeatureState.shownPanelView, keyEvent);
                                    if (panelFeatureState.shownPanelView.hasFocus() == null) {
                                        panelFeatureState.shownPanelView.requestFocus();
                                    }
                                    i = -2;
                                    panelFeatureState.isHandled = false;
                                    layoutParams = new WindowManager.LayoutParams(i, -2, panelFeatureState.f1817x, panelFeatureState.f1818y, 1002, 8519680, -3);
                                    layoutParams.gravity = panelFeatureState.gravity;
                                    layoutParams.windowAnimations = panelFeatureState.windowAnimations;
                                    windowManager.addView(panelFeatureState.decorView, layoutParams);
                                    panelFeatureState.isOpen = true;
                                    return;
                                }
                            }
                            return;
                        }
                        keyEvent = 1;
                        if (keyEvent != null) {
                            if (panelFeatureState.hasPanelItems() == null) {
                                keyEvent = panelFeatureState.shownPanelView.getLayoutParams();
                                if (keyEvent == null) {
                                    keyEvent = new LayoutParams(-2, -2);
                                }
                                panelFeatureState.decorView.setBackgroundResource(panelFeatureState.background);
                                parent = panelFeatureState.shownPanelView.getParent();
                                ((ViewGroup) parent).removeView(panelFeatureState.shownPanelView);
                                panelFeatureState.decorView.addView(panelFeatureState.shownPanelView, keyEvent);
                                if (panelFeatureState.shownPanelView.hasFocus() == null) {
                                    panelFeatureState.shownPanelView.requestFocus();
                                }
                                i = -2;
                                panelFeatureState.isHandled = false;
                                layoutParams = new WindowManager.LayoutParams(i, -2, panelFeatureState.f1817x, panelFeatureState.f1818y, 1002, 8519680, -3);
                                layoutParams.gravity = panelFeatureState.gravity;
                                layoutParams.windowAnimations = panelFeatureState.windowAnimations;
                                windowManager.addView(panelFeatureState.decorView, layoutParams);
                                panelFeatureState.isOpen = true;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                m16737a(panelFeatureState, true);
            }
        }
    }

    final void m16746b(MenuBuilder menuBuilder) {
        if (!this.f16550G) {
            this.f16550G = true;
            this.f16567y.mo564h();
            Window.Callback callback = this.f11546c.getCallback();
            if (!(callback == null || this.f11558o)) {
                callback.onPanelClosed(108, menuBuilder);
            }
            this.f16550G = null;
        }
    }

    final void m16764p() {
        m16737a(m16756h(0), true);
    }

    final void m16737a(PanelFeatureState panelFeatureState, boolean z) {
        if (z && panelFeatureState.featureId == 0 && this.f16567y != null && this.f16567y.mo559c()) {
            m16746b(panelFeatureState.menu);
            return;
        }
        WindowManager windowManager = (WindowManager) this.b.getSystemService("window");
        if (!(windowManager == null || !panelFeatureState.isOpen || panelFeatureState.decorView == null)) {
            windowManager.removeView(panelFeatureState.decorView);
            if (z) {
                m16734a(panelFeatureState.featureId, panelFeatureState, null);
            }
        }
        panelFeatureState.isPrepared = false;
        panelFeatureState.isHandled = false;
        panelFeatureState.isOpen = false;
        panelFeatureState.shownPanelView = null;
        panelFeatureState.refreshDecorView = true;
        if (this.f16552I == panelFeatureState) {
            this.f16552I = null;
        }
    }

    final void m16734a(int i, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i >= 0 && i < this.f16551H.length) {
                panelFeatureState = this.f16551H[i];
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.menu;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.isOpen != null) && this.f11558o == null) {
            this.d.onPanelClosed(i, menu);
        }
    }

    final PanelFeatureState m16731a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.f16551H;
        int i = 0;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        while (i < length) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.menu == menu) {
                return panelFeatureState;
            }
            i++;
        }
        return null;
    }

    protected final PanelFeatureState m16756h(int i) {
        Object obj = this.f16551H;
        if (obj == null || obj.length <= i) {
            Object obj2 = new PanelFeatureState[(i + 1)];
            if (obj != null) {
                System.arraycopy(obj, 0, obj2, 0, obj.length);
            }
            this.f16551H = obj2;
            obj = obj2;
        }
        PanelFeatureState panelFeatureState = obj[i];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        panelFeatureState = new PanelFeatureState(i);
        obj[i] = panelFeatureState;
        return panelFeatureState;
    }

    private boolean m16726a(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent) {
        boolean z = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.isPrepared || m16727b(panelFeatureState, keyEvent)) && panelFeatureState.menu != null) {
            z = panelFeatureState.menu.performShortcut(i, keyEvent, 1);
        }
        return z;
    }

    private void mo4225g(int i) {
        this.f16566x = (1 << i) | this.f16566x;
        if (this.f16565w == 0) {
            ViewCompat.m1224a(this.c.getDecorView(), this.f16554K);
            this.f16565w = true;
        }
    }

    final void m16759i(int i) {
        PanelFeatureState h = m16756h(i);
        if (h.menu != null) {
            Bundle bundle = new Bundle();
            h.menu.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                h.frozenActionViewState = bundle;
            }
            h.menu.stopDispatchingItemsChanged();
            h.menu.clear();
        }
        h.refreshMenuContent = true;
        h.refreshDecorView = true;
        if ((i == 108 || i == 0) && this.f16567y != 0) {
            h = m16756h(0);
            if (h != null) {
                h.isPrepared = false;
                m16727b(h, (KeyEvent) 0);
            }
        }
    }

    final int m16760j(int i) {
        int i2;
        int i3 = 0;
        if (this.f16560r == null || !(this.f16560r.getLayoutParams() instanceof MarginLayoutParams)) {
            i2 = 0;
        } else {
            int i4;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f16560r.getLayoutParams();
            i2 = 1;
            if (this.f16560r.isShown()) {
                if (this.f16556M == null) {
                    this.f16556M = new Rect();
                    this.f16557N = new Rect();
                }
                Rect rect = this.f16556M;
                Rect rect2 = this.f16557N;
                rect.set(0, i, 0, 0);
                ViewUtils.m2389a(this.f16564v, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.f16547D == null) {
                        this.f16547D = new View(this.b);
                        this.f16547D.setBackgroundColor(this.b.getResources().getColor(C0164R.color.abc_input_method_navigation_guard));
                        this.f16564v.addView(this.f16547D, -1, new LayoutParams(-1, i));
                    } else {
                        LayoutParams layoutParams = this.f16547D.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.f16547D.setLayoutParams(layoutParams);
                        }
                    }
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                if (this.f16547D == null) {
                    i2 = 0;
                }
                if (!(this.k || r3 == 0)) {
                    i = 0;
                }
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                i4 = 1;
                i2 = 0;
            } else {
                i4 = 0;
                i2 = i4;
            }
            if (i4 != 0) {
                this.f16560r.setLayoutParams(marginLayoutParams);
            }
        }
        if (this.f16547D != null) {
            View view = this.f16547D;
            if (i2 == 0) {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
        return i;
    }

    private void m16730s() {
        if (this.f16545B) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    final void m16765q() {
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
        r2 = this;
        r0 = r2.f16567y;
        if (r0 == 0) goto L_0x0009;
    L_0x0004:
        r0 = r2.f16567y;
        r0.mo564h();
    L_0x0009:
        r0 = r2.f16561s;
        if (r0 == 0) goto L_0x0028;
    L_0x000d:
        r0 = r2.c;
        r0 = r0.getDecorView();
        r1 = r2.f16562t;
        r0.removeCallbacks(r1);
        r0 = r2.f16561s;
        r0 = r0.isShowing();
        if (r0 == 0) goto L_0x0025;
    L_0x0020:
        r0 = r2.f16561s;	 Catch:{ IllegalArgumentException -> 0x0025 }
        r0.dismiss();	 Catch:{ IllegalArgumentException -> 0x0025 }
    L_0x0025:
        r0 = 0;
        r2.f16561s = r0;
    L_0x0028:
        r2.m16763o();
        r0 = 0;
        r0 = r2.m16756h(r0);
        if (r0 == 0) goto L_0x003b;
    L_0x0032:
        r1 = r0.menu;
        if (r1 == 0) goto L_0x003b;
    L_0x0036:
        r0 = r0.menu;
        r0.close();
    L_0x003b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatDelegateImplV9.q():void");
    }

    public final boolean mo3176c(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i = 108;
        } else if (i == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i = 109;
        }
        if (this.m && i == 108) {
            return false;
        }
        if (this.i && i == 1) {
            this.i = false;
        }
        switch (i) {
            case 1:
                m16730s();
                this.m = true;
                return true;
            case 2:
                m16730s();
                this.f16548E = true;
                return true;
            case 5:
                m16730s();
                this.f16549F = true;
                return true;
            case 10:
                m16730s();
                this.k = true;
                return true;
            case 108:
                m16730s();
                this.i = true;
                return true;
            case 109:
                m16730s();
                this.j = true;
                return true;
            default:
                return this.c.requestFeature(i);
        }
    }

    public final boolean mo108a(MenuBuilder menuBuilder, MenuItem menuItem) {
        Window.Callback callback = this.f11546c.getCallback();
        if (!(callback == null || this.f11558o)) {
            menuBuilder = m16731a(menuBuilder.getRootMenu());
            if (menuBuilder != null) {
                return callback.onMenuItemSelected(menuBuilder.featureId, menuItem);
            }
        }
        return null;
    }

    public final void mo107a(MenuBuilder menuBuilder) {
        if (this.f16567y == null || this.f16567y.mo558b() == null || (ViewConfiguration.get(this.b).hasPermanentMenuKey() != null && this.f16567y.mo560d() == null)) {
            PanelFeatureState h = m16756h(0);
            h.refreshDecorView = true;
            m16737a(h, false);
            m16725a(h, null);
            return;
        }
        menuBuilder = this.f11546c.getCallback();
        if (this.f16567y.mo559c()) {
            this.f16567y.mo562f();
            if (!this.f11558o) {
                menuBuilder.onPanelClosed(108, m16756h(0).menu);
            }
        } else if (!(menuBuilder == null || this.f11558o)) {
            if (this.f16565w && (1 & this.f16566x) != 0) {
                this.c.getDecorView().removeCallbacks(this.f16554K);
                this.f16554K.run();
            }
            PanelFeatureState h2 = m16756h(0);
            if (!(h2.menu == null || h2.refreshMenuContent || !menuBuilder.onPreparePanel(0, h2.createdPanelView, h2.menu))) {
                menuBuilder.onMenuOpened(108, h2.menu);
                this.f16567y.mo561e();
            }
        }
    }

    private boolean m16727b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        if (this.f11558o) {
            return false;
        }
        if (panelFeatureState.isPrepared) {
            return true;
        }
        boolean z;
        Context context;
        TypedValue typedValue;
        Theme theme;
        Theme newTheme;
        Context contextThemeWrapper;
        MenuBuilder menuBuilder;
        if (!(this.f16552I == null || this.f16552I == panelFeatureState)) {
            m16737a(this.f16552I, false);
        }
        Window.Callback callback = this.f11546c.getCallback();
        if (callback != null) {
            panelFeatureState.createdPanelView = callback.onCreatePanelView(panelFeatureState.featureId);
        }
        if (panelFeatureState.featureId != 0) {
            if (panelFeatureState.featureId != 108) {
                z = false;
                if (z && this.f16567y != null) {
                    this.f16567y.mo563g();
                }
                if (panelFeatureState.createdPanelView == null && !(z && (this.f11550g instanceof ToolbarActionBar))) {
                    if (panelFeatureState.menu == null || panelFeatureState.refreshMenuContent) {
                        if (panelFeatureState.menu == null) {
                            context = this.b;
                            if ((panelFeatureState.featureId == 0 || panelFeatureState.featureId == 108) && this.f16567y != null) {
                                typedValue = new TypedValue();
                                theme = context.getTheme();
                                theme.resolveAttribute(C0164R.attr.actionBarTheme, typedValue, true);
                                if (typedValue.resourceId == 0) {
                                    newTheme = context.getResources().newTheme();
                                    newTheme.setTo(theme);
                                    newTheme.applyStyle(typedValue.resourceId, true);
                                    newTheme.resolveAttribute(C0164R.attr.actionBarWidgetTheme, typedValue, true);
                                } else {
                                    theme.resolveAttribute(C0164R.attr.actionBarWidgetTheme, typedValue, true);
                                    newTheme = null;
                                }
                                if (typedValue.resourceId != 0) {
                                    if (newTheme == null) {
                                        newTheme = context.getResources().newTheme();
                                        newTheme.setTo(theme);
                                    }
                                    newTheme.applyStyle(typedValue.resourceId, true);
                                }
                                if (newTheme != null) {
                                    contextThemeWrapper = new ContextThemeWrapper(context, 0);
                                    contextThemeWrapper.getTheme().setTo(newTheme);
                                    menuBuilder = new MenuBuilder(contextThemeWrapper);
                                    menuBuilder.setCallback(this);
                                    panelFeatureState.setMenu(menuBuilder);
                                    if (panelFeatureState.menu == null) {
                                        return false;
                                    }
                                }
                            }
                            contextThemeWrapper = context;
                            menuBuilder = new MenuBuilder(contextThemeWrapper);
                            menuBuilder.setCallback(this);
                            panelFeatureState.setMenu(menuBuilder);
                            if (panelFeatureState.menu == null) {
                                return false;
                            }
                        }
                        if (z && this.f16567y != null) {
                            if (this.f16568z == null) {
                                this.f16568z = new ActionMenuPresenterCallback(this);
                            }
                            this.f16567y.mo557a(panelFeatureState.menu, this.f16568z);
                        }
                        panelFeatureState.menu.stopDispatchingItemsChanged();
                        if (callback.onCreatePanelMenu(panelFeatureState.featureId, panelFeatureState.menu)) {
                            panelFeatureState.setMenu(null);
                            if (z && this.f16567y != null) {
                                this.f16567y.mo557a(null, this.f16568z);
                            }
                            return false;
                        }
                        panelFeatureState.refreshMenuContent = false;
                    }
                    panelFeatureState.menu.stopDispatchingItemsChanged();
                    if (panelFeatureState.frozenActionViewState != null) {
                        panelFeatureState.menu.restoreActionViewStates(panelFeatureState.frozenActionViewState);
                        panelFeatureState.frozenActionViewState = null;
                    }
                    if (callback.onPreparePanel(0, panelFeatureState.createdPanelView, panelFeatureState.menu)) {
                        if (z && this.f16567y != null) {
                            this.f16567y.mo557a(null, this.f16568z);
                        }
                        panelFeatureState.menu.startDispatchingItemsChanged();
                        return false;
                    }
                    panelFeatureState.qwertyMode = KeyCharacterMap.load(keyEvent == null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1 ? 1 : null;
                    panelFeatureState.menu.setQwertyMode(panelFeatureState.qwertyMode);
                    panelFeatureState.menu.startDispatchingItemsChanged();
                }
                panelFeatureState.isPrepared = true;
                panelFeatureState.isHandled = false;
                this.f16552I = panelFeatureState;
                return true;
            }
        }
        z = true;
        this.f16567y.mo563g();
        if (panelFeatureState.menu == null) {
            context = this.b;
            typedValue = new TypedValue();
            theme = context.getTheme();
            theme.resolveAttribute(C0164R.attr.actionBarTheme, typedValue, true);
            if (typedValue.resourceId == 0) {
                theme.resolveAttribute(C0164R.attr.actionBarWidgetTheme, typedValue, true);
                newTheme = null;
            } else {
                newTheme = context.getResources().newTheme();
                newTheme.setTo(theme);
                newTheme.applyStyle(typedValue.resourceId, true);
                newTheme.resolveAttribute(C0164R.attr.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (newTheme == null) {
                    newTheme = context.getResources().newTheme();
                    newTheme.setTo(theme);
                }
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            if (newTheme != null) {
                contextThemeWrapper = new ContextThemeWrapper(context, 0);
                contextThemeWrapper.getTheme().setTo(newTheme);
                menuBuilder = new MenuBuilder(contextThemeWrapper);
                menuBuilder.setCallback(this);
                panelFeatureState.setMenu(menuBuilder);
                if (panelFeatureState.menu == null) {
                    return false;
                }
            }
            contextThemeWrapper = context;
            menuBuilder = new MenuBuilder(contextThemeWrapper);
            menuBuilder.setCallback(this);
            panelFeatureState.setMenu(menuBuilder);
            if (panelFeatureState.menu == null) {
                return false;
            }
        }
        if (this.f16568z == null) {
            this.f16568z = new ActionMenuPresenterCallback(this);
        }
        this.f16567y.mo557a(panelFeatureState.menu, this.f16568z);
        panelFeatureState.menu.stopDispatchingItemsChanged();
        if (callback.onCreatePanelMenu(panelFeatureState.featureId, panelFeatureState.menu)) {
            panelFeatureState.refreshMenuContent = false;
            panelFeatureState.menu.stopDispatchingItemsChanged();
            if (panelFeatureState.frozenActionViewState != null) {
                panelFeatureState.menu.restoreActionViewStates(panelFeatureState.frozenActionViewState);
                panelFeatureState.frozenActionViewState = null;
            }
            if (callback.onPreparePanel(0, panelFeatureState.createdPanelView, panelFeatureState.menu)) {
                if (keyEvent == null) {
                }
                if (KeyCharacterMap.load(keyEvent == null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
                }
                panelFeatureState.qwertyMode = KeyCharacterMap.load(keyEvent == null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1 ? 1 : null;
                panelFeatureState.menu.setQwertyMode(panelFeatureState.qwertyMode);
                panelFeatureState.menu.startDispatchingItemsChanged();
                panelFeatureState.isPrepared = true;
                panelFeatureState.isHandled = false;
                this.f16552I = panelFeatureState;
                return true;
            }
            this.f16567y.mo557a(null, this.f16568z);
            panelFeatureState.menu.startDispatchingItemsChanged();
            return false;
        }
        panelFeatureState.setMenu(null);
        this.f16567y.mo557a(null, this.f16568z);
        return false;
    }
}
