package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.appcompat.C0164R;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.menu.ActionMenuItem;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;
import com.reddit.frontpage.C1761R;

public class ToolbarWidgetWrapper implements DecorToolbar {
    Toolbar f12090a;
    CharSequence f12091b;
    Callback f12092c;
    boolean f12093d;
    private int f12094e;
    private View f12095f;
    private View f12096g;
    private Drawable f12097h;
    private Drawable f12098i;
    private Drawable f12099j;
    private boolean f12100k;
    private CharSequence f12101l;
    private CharSequence f12102m;
    private ActionMenuPresenter f12103n;
    private int f12104o;
    private int f12105p;
    private Drawable f12106q;

    class C02351 implements OnClickListener {
        final ActionMenuItem f2640a = new ActionMenuItem(this.f2641b.f12090a.getContext(), this.f2641b.f12091b);
        final /* synthetic */ ToolbarWidgetWrapper f2641b;

        C02351(ToolbarWidgetWrapper toolbarWidgetWrapper) {
            this.f2641b = toolbarWidgetWrapper;
        }

        public void onClick(View view) {
            if (this.f2641b.f12092c != null && this.f2641b.f12093d != null) {
                this.f2641b.f12092c.onMenuItemSelected(0, this.f2640a);
            }
        }
    }

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z) {
        this(toolbar, z, C0164R.string.abc_action_bar_up_description);
    }

    private ToolbarWidgetWrapper(Toolbar toolbar, boolean z, int i) {
        this.f12104o = 0;
        this.f12105p = 0;
        this.f12090a = toolbar;
        this.f12091b = toolbar.getTitle();
        this.f12101l = toolbar.getSubtitle();
        this.f12100k = this.f12091b != null;
        this.f12099j = toolbar.getNavigationIcon();
        CharSequence charSequence = null;
        toolbar = TintTypedArray.m2308a(toolbar.getContext(), null, C0164R.styleable.ActionBar, C0164R.attr.actionBarStyle, 0);
        this.f12106q = toolbar.m2311a(C0164R.styleable.ActionBar_homeAsUpIndicator);
        if (z) {
            Toolbar toolbar2;
            Context context;
            CharSequence c = toolbar.m2316c(C0164R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty(c)) {
                mo748b(c);
            }
            c = toolbar.m2316c(C0164R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(c)) {
                this.f12101l = c;
                if ((this.f12094e & 8) != 0) {
                    this.f12090a.setSubtitle(c);
                }
            }
            Drawable a = toolbar.m2311a(C0164R.styleable.ActionBar_logo);
            if (a == true) {
                m10932c(a);
            }
            a = toolbar.m2311a(C0164R.styleable.ActionBar_icon);
            if (a == true) {
                mo738a(a);
            }
            if (!this.f12099j && this.f12106q) {
                mo747b(this.f12106q);
            }
            mo749c(toolbar.m2310a(C0164R.styleable.ActionBar_displayOptions, 0));
            z = toolbar.m2323g(C0164R.styleable.ActionBar_customNavigationLayout, 0);
            if (z) {
                z = LayoutInflater.from(this.f12090a.getContext()).inflate(z, this.f12090a, false);
                if (!(this.f12096g == null || (this.f12094e & 16) == 0)) {
                    this.f12090a.removeView(this.f12096g);
                }
                this.f12096g = z;
                if (z && (this.f12094e & 16)) {
                    this.f12090a.addView(this.f12096g);
                }
                mo749c(this.f12094e | 16);
            }
            z = toolbar.m2321f(C0164R.styleable.ActionBar_height, 0);
            if (z <= false) {
                LayoutParams layoutParams = this.f12090a.getLayoutParams();
                layoutParams.height = z;
                this.f12090a.setLayoutParams(layoutParams);
            }
            z = toolbar.m2317d(C0164R.styleable.ActionBar_contentInsetStart, -1);
            int d = toolbar.m2317d(C0164R.styleable.ActionBar_contentInsetEnd, -1);
            if (z < false || d >= 0) {
                Toolbar toolbar3 = this.f12090a;
                z = Math.max(z, 0);
                d = Math.max(d, 0);
                toolbar3.m2347g();
                toolbar3.f2626m.m2255a(z, d);
            }
            z = toolbar.m2323g(C0164R.styleable.ActionBar_titleTextStyle, 0);
            if (z) {
                toolbar2 = this.f12090a;
                context = this.f12090a.getContext();
                toolbar2.f2623j = z;
                if (toolbar2.f2615b != null) {
                    toolbar2.f2615b.setTextAppearance(context, z);
                }
            }
            z = toolbar.m2323g(C0164R.styleable.ActionBar_subtitleTextStyle, 0);
            if (z) {
                toolbar2 = this.f12090a;
                context = this.f12090a.getContext();
                toolbar2.f2624k = z;
                if (toolbar2.f2616c != null) {
                    toolbar2.f2616c.setTextAppearance(context, z);
                }
            }
            z = toolbar.m2323g(C0164R.styleable.ActionBar_popupTheme, 0);
            if (z) {
                this.f12090a.setPopupTheme(z);
            }
        } else {
            z = true;
            if (this.f12090a.getNavigationIcon() != null) {
                z = true;
                this.f12106q = this.f12090a.getNavigationIcon();
            }
            this.f12094e = z;
        }
        toolbar.f2595b.recycle();
        if (i != this.f12105p) {
            this.f12105p = i;
            if (TextUtils.isEmpty(this.f12090a.getNavigationContentDescription()) != null) {
                toolbar = this.f12105p;
                if (toolbar != null) {
                    charSequence = this.f12090a.getContext().getString(toolbar);
                }
                this.f12102m = charSequence;
                m10936v();
            }
        }
        this.f12102m = this.f12090a.getNavigationContentDescription();
        this.f12090a.setNavigationOnClickListener(new C02351(this));
    }

    public final ViewGroup mo736a() {
        return this.f12090a;
    }

    public final Context mo745b() {
        return this.f12090a.getContext();
    }

    public final boolean mo750c() {
        Toolbar toolbar = this.f12090a;
        return (toolbar.f2630q == null || toolbar.f2630q.f12087b == null) ? false : true;
    }

    public final void mo751d() {
        this.f12090a.m2344c();
    }

    public final void mo742a(Callback callback) {
        this.f12092c = callback;
    }

    public final void mo743a(CharSequence charSequence) {
        if (!this.f12100k) {
            m10933c(charSequence);
        }
    }

    public final CharSequence mo753e() {
        return this.f12090a.getTitle();
    }

    public final void mo748b(CharSequence charSequence) {
        this.f12100k = true;
        m10933c(charSequence);
    }

    private void m10933c(CharSequence charSequence) {
        this.f12091b = charSequence;
        if ((this.f12094e & 8) != 0) {
            this.f12090a.setTitle(charSequence);
        }
    }

    public final void mo754f() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public final void mo755g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public final void mo738a(Drawable drawable) {
        this.f12097h = drawable;
        m10934t();
    }

    private void m10932c(Drawable drawable) {
        this.f12098i = drawable;
        m10934t();
    }

    private void m10934t() {
        Drawable drawable = (this.f12094e & 2) != 0 ? (this.f12094e & 1) != 0 ? this.f12098i != null ? this.f12098i : this.f12097h : this.f12097h : null;
        this.f12090a.setLogo(drawable);
    }

    public final boolean mo756h() {
        Toolbar toolbar = this.f12090a;
        return toolbar.getVisibility() == 0 && toolbar.f2614a != null && toolbar.f2614a.f11862b;
    }

    public final boolean mo757i() {
        return this.f12090a.m2342a();
    }

    public final boolean mo758j() {
        Toolbar toolbar = this.f12090a;
        if (toolbar.f2614a != null) {
            boolean z;
            ActionMenuView actionMenuView = toolbar.f2614a;
            if (actionMenuView.f11863c != null) {
                ActionMenuPresenter actionMenuPresenter = actionMenuView.f11863c;
                if (actionMenuPresenter.f16671o == null) {
                    if (!actionMenuPresenter.m16900j()) {
                        z = false;
                        if (z) {
                            z = true;
                            if (z) {
                                return true;
                            }
                        }
                    }
                }
                z = true;
                if (z) {
                    z = true;
                    if (z) {
                        return false;
                    }
                    return true;
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean mo759k() {
        return this.f12090a.m2343b();
    }

    public final boolean mo760l() {
        Toolbar toolbar = this.f12090a;
        if (toolbar.f2614a != null) {
            ActionMenuView actionMenuView = toolbar.f2614a;
            boolean z = actionMenuView.f11863c != null && actionMenuView.f11863c.m16897g();
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final void mo761m() {
        this.f12093d = true;
    }

    public final void mo741a(Menu menu, MenuPresenter.Callback callback) {
        if (this.f12103n == null) {
            this.f12103n = new ActionMenuPresenter(this.f12090a.getContext());
            this.f12103n.f11724h = C0164R.id.action_menu_presenter;
        }
        this.f12103n.f11722f = callback;
        callback = this.f12090a;
        MenuBuilder menuBuilder = (MenuBuilder) menu;
        ActionMenuPresenter actionMenuPresenter = this.f12103n;
        if (menuBuilder != null || callback.f2614a != null) {
            callback.m2345d();
            MenuBuilder menuBuilder2 = callback.f2614a.f11861a;
            if (menuBuilder2 != menuBuilder) {
                if (menuBuilder2 != null) {
                    menuBuilder2.removeMenuPresenter(callback.f2629p);
                    menuBuilder2.removeMenuPresenter(callback.f2630q);
                }
                if (callback.f2630q == null) {
                    callback.f2630q = new ExpandedActionViewMenuPresenter(callback);
                }
                actionMenuPresenter.f16668l = true;
                if (menuBuilder != null) {
                    menuBuilder.addMenuPresenter(actionMenuPresenter, callback.f2621h);
                    menuBuilder.addMenuPresenter(callback.f2630q, callback.f2621h);
                } else {
                    actionMenuPresenter.mo45a(callback.f2621h, null);
                    callback.f2630q.mo45a(callback.f2621h, null);
                    actionMenuPresenter.mo49a(true);
                    callback.f2630q.mo49a(true);
                }
                callback.f2614a.setPopupTheme(callback.f2622i);
                callback.f2614a.setPresenter(actionMenuPresenter);
                callback.f2629p = actionMenuPresenter;
            }
        }
    }

    public final void mo762n() {
        Toolbar toolbar = this.f12090a;
        if (toolbar.f2614a != null) {
            toolbar.f2614a.m10556b();
        }
    }

    public final int mo763o() {
        return this.f12094e;
    }

    public final void mo749c(int i) {
        int i2 = this.f12094e ^ i;
        this.f12094e = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    m10936v();
                }
                m10935u();
            }
            if ((i2 & 3) != 0) {
                m10934t();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f12090a.setTitle(this.f12091b);
                    this.f12090a.setSubtitle(this.f12101l);
                } else {
                    this.f12090a.setTitle(null);
                    this.f12090a.setSubtitle(null);
                }
            }
            if (!((i2 & 16) == 0 || this.f12096g == null)) {
                if ((i & 16) != 0) {
                    this.f12090a.addView(this.f12096g);
                    return;
                }
                this.f12090a.removeView(this.f12096g);
            }
        }
    }

    public final void mo740a(ScrollingTabContainerView scrollingTabContainerView) {
        if (this.f12095f != null && this.f12095f.getParent() == this.f12090a) {
            this.f12090a.removeView(this.f12095f);
        }
        this.f12095f = scrollingTabContainerView;
        if (scrollingTabContainerView != null && this.f12104o == 2) {
            this.f12090a.addView(this.f12095f, 0);
            Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) this.f12095f.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.a = 8388691;
            scrollingTabContainerView.setAllowCollapse(true);
        }
    }

    public final void mo744a(boolean z) {
        this.f12090a.setCollapsible(z);
    }

    public final int mo764p() {
        return this.f12104o;
    }

    public final ViewPropertyAnimatorCompat mo735a(final int i, long j) {
        return ViewCompat.m1254o(this.f12090a).m1291a(i == 0 ? 1.0f : 0.0f).m1292a(j).m1293a(new ViewPropertyAnimatorListenerAdapter(this) {
            final /* synthetic */ ToolbarWidgetWrapper f16724b;
            private boolean f16725c = null;

            public final void mo377a(View view) {
                this.f16724b.f12090a.setVisibility(0);
            }

            public final void mo378b(View view) {
                if (this.f16725c == null) {
                    this.f16724b.f12090a.setVisibility(i);
                }
            }

            public final void mo379c(View view) {
                this.f16725c = true;
            }
        });
    }

    public final void mo747b(Drawable drawable) {
        this.f12099j = drawable;
        m10935u();
    }

    private void m10935u() {
        if ((this.f12094e & 4) != 0) {
            this.f12090a.setNavigationIcon(this.f12099j != null ? this.f12099j : this.f12106q);
        } else {
            this.f12090a.setNavigationIcon(null);
        }
    }

    private void m10936v() {
        if ((this.f12094e & 4) != 0) {
            if (TextUtils.isEmpty(this.f12102m)) {
                this.f12090a.setNavigationContentDescription(this.f12105p);
                return;
            }
            this.f12090a.setNavigationContentDescription(this.f12102m);
        }
    }

    public final void mo752d(int i) {
        this.f12090a.setVisibility(i);
    }

    public final int mo766r() {
        return this.f12090a.getVisibility();
    }

    public final void mo739a(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        Toolbar toolbar = this.f12090a;
        toolbar.f2631r = callback;
        toolbar.f2632s = callback2;
        if (toolbar.f2614a != null) {
            toolbar.f2614a.m10554a(callback, callback2);
        }
    }

    public final Menu mo767s() {
        return this.f12090a.getMenu();
    }

    public final void mo737a(int i) {
        mo738a(i != 0 ? AppCompatResources.m1570b(this.f12090a.getContext(), i) : 0);
    }

    public final void mo746b(int i) {
        m10932c(i != 0 ? AppCompatResources.m1570b(this.f12090a.getContext(), i) : 0);
    }

    public final void mo765q() {
        mo747b(AppCompatResources.m1570b(this.f12090a.getContext(), C1761R.drawable.ic_icon_close));
    }
}
