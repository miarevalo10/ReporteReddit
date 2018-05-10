package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0164R;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.CollapsibleActionView;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.view.menu.SubMenuBuilder;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private int f2599A;
    private int f2600B;
    private int f2601C;
    private CharSequence f2602D;
    private CharSequence f2603E;
    private int f2604F;
    private int f2605G;
    private boolean f2606H;
    private boolean f2607I;
    private final ArrayList<View> f2608J;
    private final int[] f2609K;
    private final android.support.v7.widget.ActionMenuView.OnMenuItemClickListener f2610L;
    private ToolbarWidgetWrapper f2611M;
    private boolean f2612N;
    private final Runnable f2613O;
    ActionMenuView f2614a;
    TextView f2615b;
    TextView f2616c;
    Drawable f2617d;
    CharSequence f2618e;
    ImageButton f2619f;
    View f2620g;
    Context f2621h;
    int f2622i;
    int f2623j;
    int f2624k;
    int f2625l;
    RtlSpacingHelper f2626m;
    final ArrayList<View> f2627n;
    OnMenuItemClickListener f2628o;
    ActionMenuPresenter f2629p;
    ExpandedActionViewMenuPresenter f2630q;
    Callback f2631r;
    MenuBuilder.Callback f2632s;
    private ImageButton f2633t;
    private ImageView f2634u;
    private int f2635v;
    private int f2636w;
    private int f2637x;
    private int f2638y;
    private int f2639z;

    class C02322 implements Runnable {
        final /* synthetic */ Toolbar f2597a;

        C02322(Toolbar toolbar) {
            this.f2597a = toolbar;
        }

        public void run() {
            this.f2597a.m2343b();
        }
    }

    class C02333 implements OnClickListener {
        final /* synthetic */ Toolbar f2598a;

        C02333(Toolbar toolbar) {
            this.f2598a = toolbar;
        }

        public void onClick(View view) {
            this.f2598a.m2344c();
        }
    }

    public interface OnMenuItemClickListener {
        boolean mo434a(MenuItem menuItem);
    }

    class C10371 implements android.support.v7.widget.ActionMenuView.OnMenuItemClickListener {
        final /* synthetic */ Toolbar f12085a;

        C10371(Toolbar toolbar) {
            this.f12085a = toolbar;
        }

        public final boolean mo734a(MenuItem menuItem) {
            return this.f12085a.f2628o != null ? this.f12085a.f2628o.mo434a(menuItem) : null;
        }
    }

    private class ExpandedActionViewMenuPresenter implements MenuPresenter {
        MenuBuilder f12086a;
        MenuItemImpl f12087b;
        final /* synthetic */ Toolbar f12088c;

        public final void mo46a(Parcelable parcelable) {
        }

        public final void mo47a(MenuBuilder menuBuilder, boolean z) {
        }

        public final void mo48a(Callback callback) {
        }

        public final boolean mo50a() {
            return false;
        }

        public final boolean mo52a(SubMenuBuilder subMenuBuilder) {
            return false;
        }

        public final int mo53b() {
            return 0;
        }

        public final Parcelable mo55c() {
            return null;
        }

        ExpandedActionViewMenuPresenter(Toolbar toolbar) {
            this.f12088c = toolbar;
        }

        public final void mo45a(Context context, MenuBuilder menuBuilder) {
            if (!(this.f12086a == null || this.f12087b == null)) {
                this.f12086a.collapseItemActionView(this.f12087b);
            }
            this.f12086a = menuBuilder;
        }

        public final void mo49a(boolean z) {
            if (this.f12087b) {
                Object obj = null;
                if (this.f12086a) {
                    z = this.f12086a.size();
                    for (boolean z2 = false; z2 < z; z2++) {
                        if (this.f12086a.getItem(z2) == this.f12087b) {
                            obj = 1;
                            break;
                        }
                    }
                }
                if (obj == null) {
                    mo54b(this.f12087b);
                }
            }
        }

        public final boolean mo51a(MenuItemImpl menuItemImpl) {
            Toolbar toolbar = this.f12088c;
            if (toolbar.f2619f == null) {
                toolbar.f2619f = new AppCompatImageButton(toolbar.getContext(), null, C0164R.attr.toolbarNavigationButtonStyle);
                toolbar.f2619f.setImageDrawable(toolbar.f2617d);
                toolbar.f2619f.setContentDescription(toolbar.f2618e);
                android.view.ViewGroup.LayoutParams layoutParams = new LayoutParams();
                layoutParams.a = (toolbar.f2625l & 112) | 8388611;
                layoutParams.f12089b = 2;
                toolbar.f2619f.setLayoutParams(layoutParams);
                toolbar.f2619f.setOnClickListener(new C02333(toolbar));
            }
            ViewParent parent = this.f12088c.f2619f.getParent();
            if (parent != this.f12088c) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.f12088c.f2619f);
                }
                this.f12088c.addView(this.f12088c.f2619f);
            }
            this.f12088c.f2620g = menuItemImpl.getActionView();
            this.f12087b = menuItemImpl;
            parent = this.f12088c.f2620g.getParent();
            if (parent != this.f12088c) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.f12088c.f2620g);
                }
                android.view.ViewGroup.LayoutParams f = Toolbar.m2338f();
                f.a = (this.f12088c.f2625l & 112) | 8388611;
                f.f12089b = 2;
                this.f12088c.f2620g.setLayoutParams(f);
                this.f12088c.addView(this.f12088c.f2620g);
            }
            toolbar = this.f12088c;
            for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = toolbar.getChildAt(childCount);
                if (!(((LayoutParams) childAt.getLayoutParams()).f12089b == 2 || childAt == toolbar.f2614a)) {
                    toolbar.removeViewAt(childCount);
                    toolbar.f2627n.add(childAt);
                }
            }
            this.f12088c.requestLayout();
            menuItemImpl.m10487e(true);
            if ((this.f12088c.f2620g instanceof CollapsibleActionView) != null) {
                ((CollapsibleActionView) this.f12088c.f2620g).onActionViewExpanded();
            }
            return true;
        }

        public final boolean mo54b(MenuItemImpl menuItemImpl) {
            if (this.f12088c.f2620g instanceof CollapsibleActionView) {
                ((CollapsibleActionView) this.f12088c.f2620g).onActionViewCollapsed();
            }
            this.f12088c.removeView(this.f12088c.f2620g);
            this.f12088c.removeView(this.f12088c.f2619f);
            this.f12088c.f2620g = null;
            Toolbar toolbar = this.f12088c;
            for (int size = toolbar.f2627n.size() - 1; size >= 0; size--) {
                toolbar.addView((View) toolbar.f2627n.get(size));
            }
            toolbar.f2627n.clear();
            this.f12087b = null;
            this.f12088c.requestLayout();
            menuItemImpl.m10487e(false);
            return true;
        }
    }

    public static class LayoutParams extends android.support.v7.app.ActionBar.LayoutParams {
        int f12089b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f12089b = null;
        }

        public LayoutParams() {
            this.f12089b = 0;
            this.a = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((android.support.v7.app.ActionBar.LayoutParams) layoutParams);
            this.f12089b = 0;
            this.f12089b = layoutParams.f12089b;
        }

        public LayoutParams(android.support.v7.app.ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
            this.f12089b = null;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super((android.view.ViewGroup.LayoutParams) marginLayoutParams);
            this.f12089b = 0;
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f12089b = null;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new C02341();
        int expandedMenuItemId;
        boolean isOverflowOpen;

        static class C02341 implements ClassLoaderCreator<SavedState> {
            C02341() {
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcel parcel) {
            this(parcel, null);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.expandedMenuItemId = parcel.readInt();
            this.isOverflowOpen = parcel.readInt() != null ? true : null;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.expandedMenuItemId);
            parcel.writeInt(this.isOverflowOpen);
        }
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return m2329a(layoutParams);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0164R.attr.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2601C = 8388627;
        this.f2608J = new ArrayList();
        this.f2627n = new ArrayList();
        this.f2609K = new int[2];
        this.f2610L = new C10371(this);
        this.f2613O = new C02322(this);
        context = TintTypedArray.m2308a(getContext(), attributeSet, C0164R.styleable.Toolbar, i, 0);
        this.f2623j = context.m2323g(C0164R.styleable.Toolbar_titleTextAppearance, 0);
        this.f2624k = context.m2323g(C0164R.styleable.Toolbar_subtitleTextAppearance, 0);
        this.f2601C = context.m2315c(C0164R.styleable.Toolbar_android_gravity, this.f2601C);
        this.f2625l = context.m2315c(C0164R.styleable.Toolbar_buttonGravity, 48);
        attributeSet = context.m2317d(C0164R.styleable.Toolbar_titleMargin, 0);
        if (context.m2322f(C0164R.styleable.Toolbar_titleMargins) != 0) {
            attributeSet = context.m2317d(C0164R.styleable.Toolbar_titleMargins, attributeSet);
        }
        this.f2639z = attributeSet;
        this.f2638y = attributeSet;
        this.f2637x = attributeSet;
        this.f2636w = attributeSet;
        attributeSet = context.m2317d(C0164R.styleable.Toolbar_titleMarginStart, -1);
        if (attributeSet >= null) {
            this.f2636w = attributeSet;
        }
        attributeSet = context.m2317d(C0164R.styleable.Toolbar_titleMarginEnd, -1);
        if (attributeSet >= null) {
            this.f2637x = attributeSet;
        }
        attributeSet = context.m2317d(C0164R.styleable.Toolbar_titleMarginTop, -1);
        if (attributeSet >= null) {
            this.f2638y = attributeSet;
        }
        attributeSet = context.m2317d(C0164R.styleable.Toolbar_titleMarginBottom, -1);
        if (attributeSet >= null) {
            this.f2639z = attributeSet;
        }
        this.f2635v = context.m2319e(C0164R.styleable.Toolbar_maxButtonHeight, -1);
        attributeSet = context.m2317d(C0164R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int d = context.m2317d(C0164R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int e = context.m2319e(C0164R.styleable.Toolbar_contentInsetLeft, 0);
        int e2 = context.m2319e(C0164R.styleable.Toolbar_contentInsetRight, 0);
        m2347g();
        RtlSpacingHelper rtlSpacingHelper = this.f2626m;
        rtlSpacingHelper.f2478h = false;
        if (e != Integer.MIN_VALUE) {
            rtlSpacingHelper.f2475e = e;
            rtlSpacingHelper.f2471a = e;
        }
        if (e2 != Integer.MIN_VALUE) {
            rtlSpacingHelper.f2476f = e2;
            rtlSpacingHelper.f2472b = e2;
        }
        if (!(attributeSet == -2147483648 && d == Integer.MIN_VALUE)) {
            this.f2626m.m2255a(attributeSet, d);
        }
        this.f2599A = context.m2317d(C0164R.styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.f2600B = context.m2317d(C0164R.styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f2617d = context.m2311a(C0164R.styleable.Toolbar_collapseIcon);
        this.f2618e = context.m2316c(C0164R.styleable.Toolbar_collapseContentDescription);
        CharSequence c = context.m2316c(C0164R.styleable.Toolbar_title);
        if (!TextUtils.isEmpty(c)) {
            setTitle(c);
        }
        c = context.m2316c(C0164R.styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(c)) {
            setSubtitle(c);
        }
        this.f2621h = getContext();
        setPopupTheme(context.m2323g(C0164R.styleable.Toolbar_popupTheme, 0));
        Drawable a = context.m2311a(C0164R.styleable.Toolbar_navigationIcon);
        if (a != null) {
            setNavigationIcon(a);
        }
        c = context.m2316c(C0164R.styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(c)) {
            setNavigationContentDescription(c);
        }
        a = context.m2311a(C0164R.styleable.Toolbar_logo);
        if (a != null) {
            setLogo(a);
        }
        c = context.m2316c(C0164R.styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(c)) {
            setLogoDescription(c);
        }
        if (context.m2322f(C0164R.styleable.Toolbar_titleTextColor) != null) {
            setTitleTextColor(context.m2313b(C0164R.styleable.Toolbar_titleTextColor, -1));
        }
        if (context.m2322f(C0164R.styleable.Toolbar_subtitleTextColor) != null) {
            setSubtitleTextColor(context.m2313b(C0164R.styleable.Toolbar_subtitleTextColor, -1));
        }
        context.f2595b.recycle();
    }

    public void setPopupTheme(int i) {
        if (this.f2622i != i) {
            this.f2622i = i;
            if (i == 0) {
                this.f2621h = getContext();
                return;
            }
            this.f2621h = new ContextThemeWrapper(getContext(), i);
        }
    }

    public int getPopupTheme() {
        return this.f2622i;
    }

    public int getTitleMarginStart() {
        return this.f2636w;
    }

    public void setTitleMarginStart(int i) {
        this.f2636w = i;
        requestLayout();
    }

    public int getTitleMarginTop() {
        return this.f2638y;
    }

    public void setTitleMarginTop(int i) {
        this.f2638y = i;
        requestLayout();
    }

    public int getTitleMarginEnd() {
        return this.f2637x;
    }

    public void setTitleMarginEnd(int i) {
        this.f2637x = i;
        requestLayout();
    }

    public int getTitleMarginBottom() {
        return this.f2639z;
    }

    public void setTitleMarginBottom(int i) {
        this.f2639z = i;
        requestLayout();
    }

    public void onRtlPropertiesChanged(int i) {
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        m2347g();
        RtlSpacingHelper rtlSpacingHelper = this.f2626m;
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        if (z != rtlSpacingHelper.f2477g) {
            rtlSpacingHelper.f2477g = z;
            if (rtlSpacingHelper.f2478h == 0) {
                rtlSpacingHelper.f2471a = rtlSpacingHelper.f2475e;
                rtlSpacingHelper.f2472b = rtlSpacingHelper.f2476f;
            } else if (z) {
                rtlSpacingHelper.f2471a = rtlSpacingHelper.f2474d != Integer.MIN_VALUE ? rtlSpacingHelper.f2474d : rtlSpacingHelper.f2475e;
                rtlSpacingHelper.f2472b = rtlSpacingHelper.f2473c != Integer.MIN_VALUE ? rtlSpacingHelper.f2473c : rtlSpacingHelper.f2476f;
            } else {
                rtlSpacingHelper.f2471a = rtlSpacingHelper.f2473c != Integer.MIN_VALUE ? rtlSpacingHelper.f2473c : rtlSpacingHelper.f2475e;
                rtlSpacingHelper.f2472b = rtlSpacingHelper.f2474d != Integer.MIN_VALUE ? rtlSpacingHelper.f2474d : rtlSpacingHelper.f2476f;
            }
        }
    }

    public void setLogo(int i) {
        setLogo(AppCompatResources.m1570b(getContext(), i));
    }

    public final boolean m2342a() {
        if (this.f2614a != null) {
            ActionMenuView actionMenuView = this.f2614a;
            boolean z = actionMenuView.f11863c != null && actionMenuView.f11863c.m16900j();
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean m2343b() {
        if (this.f2614a != null) {
            ActionMenuView actionMenuView = this.f2614a;
            boolean z = actionMenuView.f11863c != null && actionMenuView.f11863c.m16896f();
            if (z) {
                return true;
            }
        }
        return false;
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m2339h();
            if (!m2337d(this.f2634u)) {
                m2331a(this.f2634u, true);
            }
        } else if (this.f2634u != null && m2337d(this.f2634u)) {
            removeView(this.f2634u);
            this.f2627n.remove(this.f2634u);
        }
        if (this.f2634u != null) {
            this.f2634u.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        return this.f2634u != null ? this.f2634u.getDrawable() : null;
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m2339h();
        }
        if (this.f2634u != null) {
            this.f2634u.setContentDescription(charSequence);
        }
    }

    public CharSequence getLogoDescription() {
        return this.f2634u != null ? this.f2634u.getContentDescription() : null;
    }

    private void m2339h() {
        if (this.f2634u == null) {
            this.f2634u = new AppCompatImageView(getContext());
        }
    }

    public final void m2344c() {
        MenuItemImpl menuItemImpl = this.f2630q == null ? null : this.f2630q.f12087b;
        if (menuItemImpl != null) {
            menuItemImpl.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.f2602D;
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f2615b == null) {
                Context context = getContext();
                this.f2615b = new AppCompatTextView(context);
                this.f2615b.setSingleLine();
                this.f2615b.setEllipsize(TruncateAt.END);
                if (this.f2623j != 0) {
                    this.f2615b.setTextAppearance(context, this.f2623j);
                }
                if (this.f2604F != 0) {
                    this.f2615b.setTextColor(this.f2604F);
                }
            }
            if (!m2337d(this.f2615b)) {
                m2331a(this.f2615b, true);
            }
        } else if (this.f2615b != null && m2337d(this.f2615b)) {
            removeView(this.f2615b);
            this.f2627n.remove(this.f2615b);
        }
        if (this.f2615b != null) {
            this.f2615b.setText(charSequence);
        }
        this.f2602D = charSequence;
    }

    public CharSequence getSubtitle() {
        return this.f2603E;
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f2616c == null) {
                Context context = getContext();
                this.f2616c = new AppCompatTextView(context);
                this.f2616c.setSingleLine();
                this.f2616c.setEllipsize(TruncateAt.END);
                if (this.f2624k != 0) {
                    this.f2616c.setTextAppearance(context, this.f2624k);
                }
                if (this.f2605G != 0) {
                    this.f2616c.setTextColor(this.f2605G);
                }
            }
            if (!m2337d(this.f2616c)) {
                m2331a(this.f2616c, true);
            }
        } else if (this.f2616c != null && m2337d(this.f2616c)) {
            removeView(this.f2616c);
            this.f2627n.remove(this.f2616c);
        }
        if (this.f2616c != null) {
            this.f2616c.setText(charSequence);
        }
        this.f2603E = charSequence;
    }

    public void setTitleTextColor(int i) {
        this.f2604F = i;
        if (this.f2615b != null) {
            this.f2615b.setTextColor(i);
        }
    }

    public void setSubtitleTextColor(int i) {
        this.f2605G = i;
        if (this.f2616c != null) {
            this.f2616c.setTextColor(i);
        }
    }

    public CharSequence getNavigationContentDescription() {
        return this.f2633t != null ? this.f2633t.getContentDescription() : null;
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : 0);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m2341j();
        }
        if (this.f2633t != null) {
            this.f2633t.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(AppCompatResources.m1570b(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            m2341j();
            if (!m2337d(this.f2633t)) {
                m2331a(this.f2633t, true);
            }
        } else if (this.f2633t != null && m2337d(this.f2633t)) {
            removeView(this.f2633t);
            this.f2627n.remove(this.f2633t);
        }
        if (this.f2633t != null) {
            this.f2633t.setImageDrawable(drawable);
        }
    }

    public Drawable getNavigationIcon() {
        return this.f2633t != null ? this.f2633t.getDrawable() : null;
    }

    public void setNavigationOnClickListener(OnClickListener onClickListener) {
        m2341j();
        this.f2633t.setOnClickListener(onClickListener);
    }

    public Menu getMenu() {
        m2340i();
        return this.f2614a.getMenu();
    }

    public void setOverflowIcon(Drawable drawable) {
        m2340i();
        this.f2614a.setOverflowIcon(drawable);
    }

    public Drawable getOverflowIcon() {
        m2340i();
        return this.f2614a.getOverflowIcon();
    }

    private void m2340i() {
        m2345d();
        if (this.f2614a.f11861a == null) {
            MenuBuilder menuBuilder = (MenuBuilder) this.f2614a.getMenu();
            if (this.f2630q == null) {
                this.f2630q = new ExpandedActionViewMenuPresenter(this);
            }
            this.f2614a.setExpandedActionViewsExclusive(true);
            menuBuilder.addMenuPresenter(this.f2630q, this.f2621h);
        }
    }

    final void m2345d() {
        if (this.f2614a == null) {
            this.f2614a = new ActionMenuView(getContext());
            this.f2614a.setPopupTheme(this.f2622i);
            this.f2614a.setOnMenuItemClickListener(this.f2610L);
            this.f2614a.m10554a(this.f2631r, this.f2632s);
            android.view.ViewGroup.LayoutParams layoutParams = new LayoutParams();
            layoutParams.a = 8388613 | (this.f2625l & 112);
            this.f2614a.setLayoutParams(layoutParams);
            m2331a(this.f2614a, false);
        }
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(getContext());
    }

    public final void m2346e() {
        getMenuInflater().inflate(C1761R.menu.menu_submit, getMenu());
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f2628o = onMenuItemClickListener;
    }

    public int getContentInsetStart() {
        if (this.f2626m == null) {
            return 0;
        }
        RtlSpacingHelper rtlSpacingHelper = this.f2626m;
        return rtlSpacingHelper.f2477g ? rtlSpacingHelper.f2472b : rtlSpacingHelper.f2471a;
    }

    public int getContentInsetEnd() {
        if (this.f2626m == null) {
            return 0;
        }
        RtlSpacingHelper rtlSpacingHelper = this.f2626m;
        return rtlSpacingHelper.f2477g ? rtlSpacingHelper.f2471a : rtlSpacingHelper.f2472b;
    }

    public int getContentInsetLeft() {
        return this.f2626m != null ? this.f2626m.f2471a : 0;
    }

    public int getContentInsetRight() {
        return this.f2626m != null ? this.f2626m.f2472b : 0;
    }

    public int getContentInsetStartWithNavigation() {
        if (this.f2599A != Integer.MIN_VALUE) {
            return this.f2599A;
        }
        return getContentInsetStart();
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.f2599A) {
            this.f2599A = i;
            if (getNavigationIcon() != 0) {
                requestLayout();
            }
        }
    }

    public int getContentInsetEndWithActions() {
        if (this.f2600B != Integer.MIN_VALUE) {
            return this.f2600B;
        }
        return getContentInsetEnd();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.f2600B) {
            this.f2600B = i;
            if (getNavigationIcon() != 0) {
                requestLayout();
            }
        }
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.f2599A, 0));
        }
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        int i;
        if (this.f2614a != null) {
            MenuBuilder menuBuilder = this.f2614a.f11861a;
            if (menuBuilder != null && menuBuilder.hasVisibleItems()) {
                i = 1;
                if (i == 0) {
                    return Math.max(getContentInsetEnd(), Math.max(this.f2600B, 0));
                }
                return getContentInsetEnd();
            }
        }
        i = 0;
        if (i == 0) {
            return getContentInsetEnd();
        }
        return Math.max(getContentInsetEnd(), Math.max(this.f2600B, 0));
    }

    public int getCurrentContentInsetLeft() {
        if (ViewCompat.m1242f(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (ViewCompat.m1242f(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    private void m2341j() {
        if (this.f2633t == null) {
            this.f2633t = new AppCompatImageButton(getContext(), null, C0164R.attr.toolbarNavigationButtonStyle);
            android.view.ViewGroup.LayoutParams layoutParams = new LayoutParams();
            layoutParams.a = 8388611 | (this.f2625l & 112);
            this.f2633t.setLayoutParams(layoutParams);
        }
    }

    private void m2331a(View view, boolean z) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams();
        } else if (checkLayoutParams(layoutParams)) {
            layoutParams = (LayoutParams) layoutParams;
        } else {
            layoutParams = m2329a(layoutParams);
        }
        layoutParams.f12089b = 1;
        if (z && this.f2620g) {
            view.setLayoutParams(layoutParams);
            this.f2627n.add(view);
            return;
        }
        addView(view, layoutParams);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        if (!(this.f2630q == null || this.f2630q.f12087b == null)) {
            savedState.expandedMenuItemId = this.f2630q.f12087b.getItemId();
        }
        savedState.isOverflowOpen = m2342a();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            Menu menu;
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (this.f2614a != null) {
                menu = this.f2614a.f11861a;
            } else {
                menu = null;
            }
            if (!(savedState.expandedMenuItemId == 0 || this.f2630q == null || menu == null)) {
                MenuItem findItem = menu.findItem(savedState.expandedMenuItemId);
                if (findItem != null) {
                    findItem.expandActionView();
                }
            }
            if (savedState.isOverflowOpen != null) {
                removeCallbacks(this.f2613O);
                post(this.f2613O);
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f2613O);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2606H = false;
        }
        if (!this.f2606H) {
            motionEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && motionEvent == null) {
                this.f2606H = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f2606H = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f2607I = false;
        }
        if (!this.f2607I) {
            motionEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && motionEvent == null) {
                this.f2607I = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f2607I = false;
        }
        return true;
    }

    private void m2330a(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        i = getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width);
        i2 = getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + 0, marginLayoutParams.height);
        i3 = MeasureSpec.getMode(i2);
        if (i3 != 1073741824 && i4 >= 0) {
            if (i3 != 0) {
                i4 = Math.min(MeasureSpec.getSize(i2), i4);
            }
            i2 = MeasureSpec.makeMeasureSpec(i4, 1073741824);
        }
        view.measure(i, i2);
    }

    private int m2327a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + max) + i2, marginLayoutParams.width), getChildMeasureSpec(i3, (((getPaddingTop() + getPaddingBottom()) + marginLayoutParams.topMargin) + marginLayoutParams.bottomMargin) + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int measuredWidth;
        int max;
        int combineMeasuredStates;
        int i5;
        int[] iArr = this.f2609K;
        if (ViewUtils.m2390a(this)) {
            i3 = 0;
            i4 = 1;
        } else {
            i4 = 0;
            i3 = 1;
        }
        if (m2333a(r7.f2633t)) {
            m2330a(r7.f2633t, i, 0, i2, r7.f2635v);
            measuredWidth = r7.f2633t.getMeasuredWidth() + m2334b(r7.f2633t);
            max = Math.max(0, r7.f2633t.getMeasuredHeight() + m2336c(r7.f2633t));
            combineMeasuredStates = View.combineMeasuredStates(0, r7.f2633t.getMeasuredState());
        } else {
            measuredWidth = 0;
            max = measuredWidth;
            combineMeasuredStates = max;
        }
        if (m2333a(r7.f2619f)) {
            m2330a(r7.f2619f, i, 0, i2, r7.f2635v);
            measuredWidth = r7.f2619f.getMeasuredWidth() + m2334b(r7.f2619f);
            max = Math.max(max, r7.f2619f.getMeasuredHeight() + m2336c(r7.f2619f));
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, r7.f2619f.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max2 = 0 + Math.max(currentContentInsetStart, measuredWidth);
        iArr[i4] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (m2333a(r7.f2614a)) {
            m2330a(r7.f2614a, i, max2, i2, r7.f2635v);
            measuredWidth = r7.f2614a.getMeasuredWidth() + m2334b(r7.f2614a);
            max = Math.max(max, r7.f2614a.getMeasuredHeight() + m2336c(r7.f2614a));
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, r7.f2614a.getMeasuredState());
        } else {
            measuredWidth = 0;
        }
        currentContentInsetStart = getCurrentContentInsetEnd();
        max2 += Math.max(currentContentInsetStart, measuredWidth);
        iArr[i3] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (m2333a(r7.f2620g)) {
            max2 += m2327a(r7.f2620g, i, max2, i2, 0, iArr);
            max = Math.max(max, r7.f2620g.getMeasuredHeight() + m2336c(r7.f2620g));
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, r7.f2620g.getMeasuredState());
        }
        if (m2333a(r7.f2634u)) {
            max2 += m2327a(r7.f2634u, i, max2, i2, 0, iArr);
            max = Math.max(max, r7.f2634u.getMeasuredHeight() + m2336c(r7.f2634u));
            combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, r7.f2634u.getMeasuredState());
        }
        i3 = getChildCount();
        int i6 = max;
        for (max = 0; max < i3; max++) {
            View childAt = getChildAt(max);
            if (((LayoutParams) childAt.getLayoutParams()).f12089b == 0 && m2333a(childAt)) {
                View view = childAt;
                max2 += m2327a(childAt, i, max2, i2, 0, iArr);
                i6 = Math.max(i6, view.getMeasuredHeight() + m2336c(view));
                combineMeasuredStates = View.combineMeasuredStates(combineMeasuredStates, view.getMeasuredState());
            }
        }
        int i7 = r7.f2638y + r7.f2639z;
        i3 = r7.f2636w + r7.f2637x;
        if (m2333a(r7.f2615b)) {
            m2327a(r7.f2615b, i, max2 + i3, i2, i7, iArr);
            currentContentInsetStart = r7.f2615b.getMeasuredHeight() + m2336c(r7.f2615b);
            max = r7.f2615b.getMeasuredWidth() + m2334b(r7.f2615b);
            i4 = View.combineMeasuredStates(combineMeasuredStates, r7.f2615b.getMeasuredState());
            combineMeasuredStates = currentContentInsetStart;
        } else {
            max = 0;
            i4 = combineMeasuredStates;
            combineMeasuredStates = max;
        }
        if (m2333a(r7.f2616c)) {
            int i8 = combineMeasuredStates + i7;
            i7 = i4;
            max = Math.max(max, m2327a(r7.f2616c, i, max2 + i3, i2, i8, iArr));
            combineMeasuredStates += r7.f2616c.getMeasuredHeight() + m2336c(r7.f2616c);
            i4 = View.combineMeasuredStates(i7, r7.f2616c.getMeasuredState());
        } else {
            i7 = i4;
        }
        max2 += max;
        measuredWidth = Math.max(i6, combineMeasuredStates) + (getPaddingTop() + getPaddingBottom());
        int i9 = i;
        currentContentInsetStart = View.resolveSizeAndState(Math.max(max2 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i9, -16777216 & i4);
        measuredWidth = View.resolveSizeAndState(Math.max(measuredWidth, getSuggestedMinimumHeight()), i2, i4 << 16);
        if (r7.f2612N) {
            int childCount = getChildCount();
            i9 = 0;
            while (i9 < childCount) {
                View childAt2 = getChildAt(i9);
                if (!m2333a(childAt2) || childAt2.getMeasuredWidth() <= 0 || childAt2.getMeasuredHeight() <= 0) {
                    i9++;
                }
            }
            i5 = 1;
            if (i5 != 0) {
                measuredWidth = 0;
            }
            setMeasuredDimension(currentContentInsetStart, measuredWidth);
        }
        i5 = 0;
        if (i5 != 0) {
            measuredWidth = 0;
        }
        setMeasuredDimension(currentContentInsetStart, measuredWidth);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int b;
        int currentContentInsetLeft;
        int currentContentInsetRight;
        int max;
        boolean a;
        boolean a2;
        int i6;
        int i7;
        int i8;
        LayoutParams layoutParams;
        int i9;
        int i10;
        List list;
        View view;
        LayoutParams layoutParams2;
        LayoutParams layoutParams3;
        Object obj;
        int i11;
        LayoutParams layoutParams4;
        int i12;
        Toolbar toolbar = this;
        int i13 = ViewCompat.m1242f(this) == 1 ? 1 : 0;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i14 = width - paddingRight;
        int[] iArr = toolbar.f2609K;
        iArr[1] = 0;
        iArr[0] = 0;
        int n = ViewCompat.m1253n(this);
        n = n >= 0 ? Math.min(n, i4 - i2) : 0;
        if (!m2333a(toolbar.f2633t)) {
            i5 = paddingLeft;
        } else if (i13 != 0) {
            b = m2335b(toolbar.f2633t, i14, iArr, n);
            i5 = paddingLeft;
            if (m2333a(toolbar.f2619f)) {
                if (i13 == 0) {
                    b = m2335b(toolbar.f2619f, b, iArr, n);
                } else {
                    i5 = m2328a(toolbar.f2619f, i5, iArr, n);
                }
            }
            if (m2333a(toolbar.f2614a)) {
                if (i13 == 0) {
                    i5 = m2328a(toolbar.f2614a, i5, iArr, n);
                } else {
                    b = m2335b(toolbar.f2614a, b, iArr, n);
                }
            }
            currentContentInsetLeft = getCurrentContentInsetLeft();
            currentContentInsetRight = getCurrentContentInsetRight();
            iArr[0] = Math.max(0, currentContentInsetLeft - i5);
            iArr[1] = Math.max(0, currentContentInsetRight - (i14 - b));
            max = Math.max(i5, currentContentInsetLeft);
            i14 = Math.min(b, i14 - currentContentInsetRight);
            if (m2333a(toolbar.f2620g)) {
                if (i13 == 0) {
                    i14 = m2335b(toolbar.f2620g, i14, iArr, n);
                } else {
                    max = m2328a(toolbar.f2620g, max, iArr, n);
                }
            }
            if (m2333a(toolbar.f2634u)) {
                if (i13 == 0) {
                    i14 = m2335b(toolbar.f2634u, i14, iArr, n);
                } else {
                    max = m2328a(toolbar.f2634u, max, iArr, n);
                }
            }
            a = m2333a(toolbar.f2615b);
            a2 = m2333a(toolbar.f2616c);
            if (a) {
                i6 = paddingRight;
                i7 = 0;
            } else {
                LayoutParams layoutParams5 = (LayoutParams) toolbar.f2615b.getLayoutParams();
                i6 = paddingRight;
                i7 = ((layoutParams5.topMargin + toolbar.f2615b.getMeasuredHeight()) + layoutParams5.bottomMargin) + 0;
            }
            if (a2) {
                i8 = width;
            } else {
                layoutParams = (LayoutParams) toolbar.f2616c.getLayoutParams();
                i8 = width;
                i7 += (layoutParams.topMargin + toolbar.f2616c.getMeasuredHeight()) + layoutParams.bottomMargin;
            }
            if (!a) {
                if (a2) {
                    i9 = paddingLeft;
                    i10 = n;
                    m2332a(toolbar.f2608J, 3);
                    i13 = toolbar.f2608J.size();
                    i7 = max;
                    for (max = 0; max < i13; max++) {
                        i7 = m2328a((View) toolbar.f2608J.get(max), i7, iArr, i10);
                    }
                    n = i10;
                    m2332a(toolbar.f2608J, 5);
                    i13 = toolbar.f2608J.size();
                    for (max = 0; max < i13; max++) {
                        i14 = m2335b((View) toolbar.f2608J.get(max), i14, iArr, n);
                    }
                    m2332a(toolbar.f2608J, 1);
                    list = toolbar.f2608J;
                    height = iArr[0];
                    max = iArr[1];
                    width = list.size();
                    paddingLeft = max;
                    max = 0;
                    paddingRight = 0;
                    while (max < width) {
                        view = (View) list.get(max);
                        layoutParams2 = (LayoutParams) view.getLayoutParams();
                        b = layoutParams2.leftMargin - height;
                        height = layoutParams2.rightMargin - paddingLeft;
                        paddingBottom = Math.max(0, b);
                        i5 = Math.max(0, height);
                        b = Math.max(0, -b);
                        paddingRight += (paddingBottom + view.getMeasuredWidth()) + i5;
                        max++;
                        paddingLeft = Math.max(0, -height);
                        height = b;
                    }
                    i13 = (i9 + (((i8 - i9) - i6) / 2)) - (paddingRight / 2);
                    paddingRight += i13;
                    if (i13 >= i7) {
                        i7 = paddingRight <= i14 ? i13 - (paddingRight - i14) : i13;
                    }
                    i13 = toolbar.f2608J.size();
                    for (paddingLeft = 0; paddingLeft < i13; paddingLeft++) {
                        i7 = m2328a((View) toolbar.f2608J.get(paddingLeft), i7, iArr, n);
                    }
                    toolbar.f2608J.clear();
                }
            }
            layoutParams3 = (LayoutParams) (a ? toolbar.f2615b : toolbar.f2616c).getLayoutParams();
            layoutParams = (LayoutParams) (a2 ? toolbar.f2616c : toolbar.f2615b).getLayoutParams();
            if ((a || toolbar.f2615b.getMeasuredWidth() <= 0) && (!a2 || toolbar.f2616c.getMeasuredWidth() <= 0)) {
                i9 = paddingLeft;
                obj = null;
            } else {
                i9 = paddingLeft;
                obj = 1;
            }
            paddingLeft = toolbar.f2601C & 112;
            i10 = n;
            if (paddingLeft != 48) {
                i11 = max;
                paddingTop = (getPaddingTop() + layoutParams3.topMargin) + toolbar.f2638y;
            } else if (paddingLeft == 80) {
                paddingLeft = (((height - paddingTop) - paddingBottom) - i7) / 2;
                i11 = max;
                if (paddingLeft >= layoutParams3.topMargin + toolbar.f2638y) {
                    paddingLeft = layoutParams3.topMargin + toolbar.f2638y;
                } else {
                    height = (((height - paddingBottom) - i7) - paddingLeft) - paddingTop;
                    if (height < layoutParams3.bottomMargin + toolbar.f2639z) {
                        paddingLeft = Math.max(0, paddingLeft - ((layoutParams.bottomMargin + toolbar.f2639z) - height));
                    }
                }
                paddingTop += paddingLeft;
            } else {
                i11 = max;
                paddingTop = (((height - paddingBottom) - layoutParams.bottomMargin) - toolbar.f2639z) - i7;
            }
            if (i13 == 0) {
                if (obj == null) {
                    i7 = toolbar.f2636w;
                    i13 = 1;
                } else {
                    i13 = 1;
                    i7 = 0;
                }
                i7 -= iArr[i13];
                i14 -= Math.max(0, i7);
                iArr[i13] = Math.max(0, -i7);
                if (a) {
                    max = i14;
                } else {
                    layoutParams4 = (LayoutParams) toolbar.f2615b.getLayoutParams();
                    max = i14 - toolbar.f2615b.getMeasuredWidth();
                    i7 = toolbar.f2615b.getMeasuredHeight() + paddingTop;
                    toolbar.f2615b.layout(max, paddingTop, i14, i7);
                    max -= toolbar.f2637x;
                    paddingTop = i7 + layoutParams4.bottomMargin;
                }
                if (a2) {
                    i7 = i14;
                } else {
                    layoutParams4 = (LayoutParams) toolbar.f2616c.getLayoutParams();
                    paddingTop += layoutParams4.topMargin;
                    toolbar.f2616c.layout(i14 - toolbar.f2616c.getMeasuredWidth(), paddingTop, i14, toolbar.f2616c.getMeasuredHeight() + paddingTop);
                    i7 = i14 - toolbar.f2637x;
                    i13 = layoutParams4.bottomMargin;
                }
                if (obj != null) {
                    i14 = Math.min(max, i7);
                }
                max = i11;
            } else {
                if (obj == null) {
                    i12 = toolbar.f2636w;
                    i13 = 0;
                } else {
                    i13 = 0;
                    i12 = 0;
                }
                max = i12 - iArr[i13];
                i7 = i11 + Math.max(i13, max);
                iArr[i13] = Math.max(i13, -max);
                if (a) {
                    max = i7;
                } else {
                    layoutParams4 = (LayoutParams) toolbar.f2615b.getLayoutParams();
                    max = toolbar.f2615b.getMeasuredWidth() + i7;
                    width = toolbar.f2615b.getMeasuredHeight() + paddingTop;
                    toolbar.f2615b.layout(i7, paddingTop, max, width);
                    max += toolbar.f2637x;
                    paddingTop = width + layoutParams4.bottomMargin;
                }
                if (a2) {
                    width = i7;
                } else {
                    layoutParams4 = (LayoutParams) toolbar.f2616c.getLayoutParams();
                    paddingTop += layoutParams4.topMargin;
                    width = toolbar.f2616c.getMeasuredWidth() + i7;
                    toolbar.f2616c.layout(i7, paddingTop, width, toolbar.f2616c.getMeasuredHeight() + paddingTop);
                    width += toolbar.f2637x;
                    i13 = layoutParams4.bottomMargin;
                }
                max = obj == null ? Math.max(max, width) : i7;
            }
            m2332a(toolbar.f2608J, 3);
            i13 = toolbar.f2608J.size();
            i7 = max;
            for (max = 0; max < i13; max++) {
                i7 = m2328a((View) toolbar.f2608J.get(max), i7, iArr, i10);
            }
            n = i10;
            m2332a(toolbar.f2608J, 5);
            i13 = toolbar.f2608J.size();
            for (max = 0; max < i13; max++) {
                i14 = m2335b((View) toolbar.f2608J.get(max), i14, iArr, n);
            }
            m2332a(toolbar.f2608J, 1);
            list = toolbar.f2608J;
            height = iArr[0];
            max = iArr[1];
            width = list.size();
            paddingLeft = max;
            max = 0;
            paddingRight = 0;
            while (max < width) {
                view = (View) list.get(max);
                layoutParams2 = (LayoutParams) view.getLayoutParams();
                b = layoutParams2.leftMargin - height;
                height = layoutParams2.rightMargin - paddingLeft;
                paddingBottom = Math.max(0, b);
                i5 = Math.max(0, height);
                b = Math.max(0, -b);
                paddingRight += (paddingBottom + view.getMeasuredWidth()) + i5;
                max++;
                paddingLeft = Math.max(0, -height);
                height = b;
            }
            i13 = (i9 + (((i8 - i9) - i6) / 2)) - (paddingRight / 2);
            paddingRight += i13;
            if (i13 >= i7) {
                if (paddingRight <= i14) {
                }
            }
            i13 = toolbar.f2608J.size();
            for (paddingLeft = 0; paddingLeft < i13; paddingLeft++) {
                i7 = m2328a((View) toolbar.f2608J.get(paddingLeft), i7, iArr, n);
            }
            toolbar.f2608J.clear();
        } else {
            i5 = m2328a(toolbar.f2633t, paddingLeft, iArr, n);
        }
        b = i14;
        if (m2333a(toolbar.f2619f)) {
            if (i13 == 0) {
                i5 = m2328a(toolbar.f2619f, i5, iArr, n);
            } else {
                b = m2335b(toolbar.f2619f, b, iArr, n);
            }
        }
        if (m2333a(toolbar.f2614a)) {
            if (i13 == 0) {
                b = m2335b(toolbar.f2614a, b, iArr, n);
            } else {
                i5 = m2328a(toolbar.f2614a, i5, iArr, n);
            }
        }
        currentContentInsetLeft = getCurrentContentInsetLeft();
        currentContentInsetRight = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft - i5);
        iArr[1] = Math.max(0, currentContentInsetRight - (i14 - b));
        max = Math.max(i5, currentContentInsetLeft);
        i14 = Math.min(b, i14 - currentContentInsetRight);
        if (m2333a(toolbar.f2620g)) {
            if (i13 == 0) {
                max = m2328a(toolbar.f2620g, max, iArr, n);
            } else {
                i14 = m2335b(toolbar.f2620g, i14, iArr, n);
            }
        }
        if (m2333a(toolbar.f2634u)) {
            if (i13 == 0) {
                max = m2328a(toolbar.f2634u, max, iArr, n);
            } else {
                i14 = m2335b(toolbar.f2634u, i14, iArr, n);
            }
        }
        a = m2333a(toolbar.f2615b);
        a2 = m2333a(toolbar.f2616c);
        if (a) {
            i6 = paddingRight;
            i7 = 0;
        } else {
            LayoutParams layoutParams52 = (LayoutParams) toolbar.f2615b.getLayoutParams();
            i6 = paddingRight;
            i7 = ((layoutParams52.topMargin + toolbar.f2615b.getMeasuredHeight()) + layoutParams52.bottomMargin) + 0;
        }
        if (a2) {
            i8 = width;
        } else {
            layoutParams = (LayoutParams) toolbar.f2616c.getLayoutParams();
            i8 = width;
            i7 += (layoutParams.topMargin + toolbar.f2616c.getMeasuredHeight()) + layoutParams.bottomMargin;
        }
        if (a) {
            if (a2) {
                i9 = paddingLeft;
                i10 = n;
                m2332a(toolbar.f2608J, 3);
                i13 = toolbar.f2608J.size();
                i7 = max;
                for (max = 0; max < i13; max++) {
                    i7 = m2328a((View) toolbar.f2608J.get(max), i7, iArr, i10);
                }
                n = i10;
                m2332a(toolbar.f2608J, 5);
                i13 = toolbar.f2608J.size();
                for (max = 0; max < i13; max++) {
                    i14 = m2335b((View) toolbar.f2608J.get(max), i14, iArr, n);
                }
                m2332a(toolbar.f2608J, 1);
                list = toolbar.f2608J;
                height = iArr[0];
                max = iArr[1];
                width = list.size();
                paddingLeft = max;
                max = 0;
                paddingRight = 0;
                while (max < width) {
                    view = (View) list.get(max);
                    layoutParams2 = (LayoutParams) view.getLayoutParams();
                    b = layoutParams2.leftMargin - height;
                    height = layoutParams2.rightMargin - paddingLeft;
                    paddingBottom = Math.max(0, b);
                    i5 = Math.max(0, height);
                    b = Math.max(0, -b);
                    paddingRight += (paddingBottom + view.getMeasuredWidth()) + i5;
                    max++;
                    paddingLeft = Math.max(0, -height);
                    height = b;
                }
                i13 = (i9 + (((i8 - i9) - i6) / 2)) - (paddingRight / 2);
                paddingRight += i13;
                if (i13 >= i7) {
                    if (paddingRight <= i14) {
                    }
                }
                i13 = toolbar.f2608J.size();
                for (paddingLeft = 0; paddingLeft < i13; paddingLeft++) {
                    i7 = m2328a((View) toolbar.f2608J.get(paddingLeft), i7, iArr, n);
                }
                toolbar.f2608J.clear();
            }
        }
        if (a) {
        }
        if (a2) {
        }
        layoutParams3 = (LayoutParams) (a ? toolbar.f2615b : toolbar.f2616c).getLayoutParams();
        layoutParams = (LayoutParams) (a2 ? toolbar.f2616c : toolbar.f2615b).getLayoutParams();
        if (a) {
        }
        i9 = paddingLeft;
        obj = null;
        paddingLeft = toolbar.f2601C & 112;
        i10 = n;
        if (paddingLeft != 48) {
            i11 = max;
            paddingTop = (getPaddingTop() + layoutParams3.topMargin) + toolbar.f2638y;
        } else if (paddingLeft == 80) {
            i11 = max;
            paddingTop = (((height - paddingBottom) - layoutParams.bottomMargin) - toolbar.f2639z) - i7;
        } else {
            paddingLeft = (((height - paddingTop) - paddingBottom) - i7) / 2;
            i11 = max;
            if (paddingLeft >= layoutParams3.topMargin + toolbar.f2638y) {
                height = (((height - paddingBottom) - i7) - paddingLeft) - paddingTop;
                if (height < layoutParams3.bottomMargin + toolbar.f2639z) {
                    paddingLeft = Math.max(0, paddingLeft - ((layoutParams.bottomMargin + toolbar.f2639z) - height));
                }
            } else {
                paddingLeft = layoutParams3.topMargin + toolbar.f2638y;
            }
            paddingTop += paddingLeft;
        }
        if (i13 == 0) {
            if (obj == null) {
                i13 = 0;
                i12 = 0;
            } else {
                i12 = toolbar.f2636w;
                i13 = 0;
            }
            max = i12 - iArr[i13];
            i7 = i11 + Math.max(i13, max);
            iArr[i13] = Math.max(i13, -max);
            if (a) {
                max = i7;
            } else {
                layoutParams4 = (LayoutParams) toolbar.f2615b.getLayoutParams();
                max = toolbar.f2615b.getMeasuredWidth() + i7;
                width = toolbar.f2615b.getMeasuredHeight() + paddingTop;
                toolbar.f2615b.layout(i7, paddingTop, max, width);
                max += toolbar.f2637x;
                paddingTop = width + layoutParams4.bottomMargin;
            }
            if (a2) {
                width = i7;
            } else {
                layoutParams4 = (LayoutParams) toolbar.f2616c.getLayoutParams();
                paddingTop += layoutParams4.topMargin;
                width = toolbar.f2616c.getMeasuredWidth() + i7;
                toolbar.f2616c.layout(i7, paddingTop, width, toolbar.f2616c.getMeasuredHeight() + paddingTop);
                width += toolbar.f2637x;
                i13 = layoutParams4.bottomMargin;
            }
            if (obj == null) {
            }
        } else {
            if (obj == null) {
                i13 = 1;
                i7 = 0;
            } else {
                i7 = toolbar.f2636w;
                i13 = 1;
            }
            i7 -= iArr[i13];
            i14 -= Math.max(0, i7);
            iArr[i13] = Math.max(0, -i7);
            if (a) {
                max = i14;
            } else {
                layoutParams4 = (LayoutParams) toolbar.f2615b.getLayoutParams();
                max = i14 - toolbar.f2615b.getMeasuredWidth();
                i7 = toolbar.f2615b.getMeasuredHeight() + paddingTop;
                toolbar.f2615b.layout(max, paddingTop, i14, i7);
                max -= toolbar.f2637x;
                paddingTop = i7 + layoutParams4.bottomMargin;
            }
            if (a2) {
                i7 = i14;
            } else {
                layoutParams4 = (LayoutParams) toolbar.f2616c.getLayoutParams();
                paddingTop += layoutParams4.topMargin;
                toolbar.f2616c.layout(i14 - toolbar.f2616c.getMeasuredWidth(), paddingTop, i14, toolbar.f2616c.getMeasuredHeight() + paddingTop);
                i7 = i14 - toolbar.f2637x;
                i13 = layoutParams4.bottomMargin;
            }
            if (obj != null) {
                i14 = Math.min(max, i7);
            }
            max = i11;
        }
        m2332a(toolbar.f2608J, 3);
        i13 = toolbar.f2608J.size();
        i7 = max;
        for (max = 0; max < i13; max++) {
            i7 = m2328a((View) toolbar.f2608J.get(max), i7, iArr, i10);
        }
        n = i10;
        m2332a(toolbar.f2608J, 5);
        i13 = toolbar.f2608J.size();
        for (max = 0; max < i13; max++) {
            i14 = m2335b((View) toolbar.f2608J.get(max), i14, iArr, n);
        }
        m2332a(toolbar.f2608J, 1);
        list = toolbar.f2608J;
        height = iArr[0];
        max = iArr[1];
        width = list.size();
        paddingLeft = max;
        max = 0;
        paddingRight = 0;
        while (max < width) {
            view = (View) list.get(max);
            layoutParams2 = (LayoutParams) view.getLayoutParams();
            b = layoutParams2.leftMargin - height;
            height = layoutParams2.rightMargin - paddingLeft;
            paddingBottom = Math.max(0, b);
            i5 = Math.max(0, height);
            b = Math.max(0, -b);
            paddingRight += (paddingBottom + view.getMeasuredWidth()) + i5;
            max++;
            paddingLeft = Math.max(0, -height);
            height = b;
        }
        i13 = (i9 + (((i8 - i9) - i6) / 2)) - (paddingRight / 2);
        paddingRight += i13;
        if (i13 >= i7) {
            if (paddingRight <= i14) {
            }
        }
        i13 = toolbar.f2608J.size();
        for (paddingLeft = 0; paddingLeft < i13; paddingLeft++) {
            i7 = m2328a((View) toolbar.f2608J.get(paddingLeft), i7, iArr, n);
        }
        toolbar.f2608J.clear();
    }

    private int m2328a(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.leftMargin - iArr[0];
        i += Math.max(0, i3);
        iArr[0] = Math.max(0, -i3);
        iArr = m2326a(view, i2);
        i2 = view.getMeasuredWidth();
        view.layout(i, iArr, i + i2, view.getMeasuredHeight() + iArr);
        return i + (i2 + layoutParams.rightMargin);
    }

    private int m2335b(View view, int i, int[] iArr, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = layoutParams.rightMargin - iArr[1];
        i -= Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        iArr = m2326a(view, i2);
        i2 = view.getMeasuredWidth();
        view.layout(i - i2, iArr, i, view.getMeasuredHeight() + iArr);
        return i - (i2 + layoutParams.leftMargin);
    }

    private int m2326a(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        view = view.getMeasuredHeight();
        i = i > 0 ? (view - i) / 2 : 0;
        int i2 = layoutParams.a & 112;
        if (!(i2 == 16 || i2 == 48 || i2 == 80)) {
            i2 = this.f2601C & 112;
        }
        if (i2 == 48) {
            return getPaddingTop() - i;
        }
        if (i2 == 80) {
            return (((getHeight() - getPaddingBottom()) - view) - layoutParams.bottomMargin) - i;
        }
        i = getPaddingTop();
        i2 = getPaddingBottom();
        int height = getHeight();
        int i3 = (((height - i) - i2) - view) / 2;
        if (i3 < layoutParams.topMargin) {
            i3 = layoutParams.topMargin;
        } else {
            height = (((height - i2) - view) - i3) - i;
            if (height < layoutParams.bottomMargin) {
                i3 = Math.max(0, i3 - (layoutParams.bottomMargin - height));
            }
        }
        return i + i3;
    }

    private void m2332a(List<View> list, int i) {
        int i2 = 0;
        int i3 = ViewCompat.m1242f(this) == 1 ? 1 : 0;
        int childCount = getChildCount();
        i = GravityCompat.m1096a(i, ViewCompat.m1242f(this));
        list.clear();
        View childAt;
        if (i3 != 0) {
            for (childCount--; childCount >= 0; childCount--) {
                childAt = getChildAt(childCount);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f12089b == 0 && m2333a(childAt) && m2325a(layoutParams.a) == i) {
                    list.add(childAt);
                }
            }
            return;
        }
        while (i2 < childCount) {
            childAt = getChildAt(i2);
            LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams2.f12089b == 0 && m2333a(childAt) && m2325a(layoutParams2.a) == i) {
                list.add(childAt);
            }
            i2++;
        }
    }

    private int m2325a(int i) {
        int f = ViewCompat.m1242f(this);
        i = GravityCompat.m1096a(i, f) & 7;
        if (i == 1 || i == 3 || i == 5) {
            return i;
        }
        return f == 1 ? 5 : 3;
    }

    private boolean m2333a(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? null : true;
    }

    private static int m2334b(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return MarginLayoutParamsCompat.m1101a(marginLayoutParams) + MarginLayoutParamsCompat.m1103b(marginLayoutParams);
    }

    private static int m2336c(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private static LayoutParams m2329a(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof android.support.v7.app.ActionBar.LayoutParams) {
            return new LayoutParams((android.support.v7.app.ActionBar.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    protected static LayoutParams m2338f() {
        return new LayoutParams();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (!super.checkLayoutParams(layoutParams) || (layoutParams instanceof LayoutParams) == null) ? null : true;
    }

    public DecorToolbar getWrapper() {
        if (this.f2611M == null) {
            this.f2611M = new ToolbarWidgetWrapper(this, true);
        }
        return this.f2611M;
    }

    private boolean m2337d(View view) {
        if (view.getParent() != this) {
            if (this.f2627n.contains(view) == null) {
                return null;
            }
        }
        return true;
    }

    public void setCollapsible(boolean z) {
        this.f2612N = z;
        requestLayout();
    }

    final void m2347g() {
        if (this.f2626m == null) {
            this.f2626m = new RtlSpacingHelper();
        }
    }

    ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.f2629p;
    }

    Context getPopupContext() {
        return this.f2621h;
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
