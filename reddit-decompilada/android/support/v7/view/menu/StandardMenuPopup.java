package android.support.v7.view.menu;

import android.content.Context;
import android.os.Parcelable;
import android.support.v7.appcompat.C0164R;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.widget.MenuPopupWindow;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

final class StandardMenuPopup extends MenuPopup implements MenuPresenter, OnKeyListener, OnItemClickListener, OnDismissListener {
    final MenuPopupWindow f16638a;
    View f16639b;
    private final Context f16640c;
    private final MenuBuilder f16641d;
    private final MenuAdapter f16642f;
    private final boolean f16643g;
    private final int f16644h;
    private final int f16645i;
    private final int f16646j;
    private final OnGlobalLayoutListener f16647k = new C01881(this);
    private final OnAttachStateChangeListener f16648l = new C01892(this);
    private OnDismissListener f16649m;
    private View f16650n;
    private Callback f16651o;
    private ViewTreeObserver f16652p;
    private boolean f16653q;
    private boolean f16654r;
    private int f16655s;
    private int f16656t = 0;
    private boolean f16657u;

    class C01881 implements OnGlobalLayoutListener {
        final /* synthetic */ StandardMenuPopup f2048a;

        C01881(StandardMenuPopup standardMenuPopup) {
            this.f2048a = standardMenuPopup;
        }

        public void onGlobalLayout() {
            if (this.f2048a.mo655f() && !this.f2048a.f16638a.f12024r) {
                View view = this.f2048a.f16639b;
                if (view != null) {
                    if (view.isShown()) {
                        this.f2048a.f16638a.mo653d();
                    }
                }
                this.f2048a.mo654e();
            }
        }
    }

    class C01892 implements OnAttachStateChangeListener {
        final /* synthetic */ StandardMenuPopup f2049a;

        public void onViewAttachedToWindow(View view) {
        }

        C01892(StandardMenuPopup standardMenuPopup) {
            this.f2049a = standardMenuPopup;
        }

        public void onViewDetachedFromWindow(View view) {
            if (this.f2049a.f16652p != null) {
                if (!this.f2049a.f16652p.isAlive()) {
                    this.f2049a.f16652p = view.getViewTreeObserver();
                }
                this.f2049a.f16652p.removeGlobalOnLayoutListener(this.f2049a.f16647k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public final void mo46a(Parcelable parcelable) {
    }

    public final void mo3201a(MenuBuilder menuBuilder) {
    }

    public final boolean mo50a() {
        return false;
    }

    public final Parcelable mo55c() {
        return null;
    }

    public StandardMenuPopup(Context context, MenuBuilder menuBuilder, View view, int i, int i2, boolean z) {
        this.f16640c = context;
        this.f16641d = menuBuilder;
        this.f16643g = z;
        this.f16642f = new MenuAdapter(menuBuilder, LayoutInflater.from(context), this.f16643g);
        this.f16645i = i;
        this.f16646j = i2;
        i = context.getResources();
        this.f16644h = Math.max(i.getDisplayMetrics().widthPixels / 2, i.getDimensionPixelSize(C0164R.dimen.abc_config_prefDialogWidth));
        this.f16650n = view;
        this.f16638a = new MenuPopupWindow(this.f16640c, this.f16645i, this.f16646j);
        menuBuilder.addMenuPresenter(this, context);
    }

    public final void mo3205b(boolean z) {
        this.f16642f.f2031c = z;
    }

    public final void mo3200a(int i) {
        this.f16656t = i;
    }

    public final void mo654e() {
        if (mo655f()) {
            this.f16638a.mo654e();
        }
    }

    public final boolean mo655f() {
        return !this.f16653q && this.f16638a.f12025s.isShowing();
    }

    public final void onDismiss() {
        this.f16653q = true;
        this.f16641d.close();
        if (this.f16652p != null) {
            if (!this.f16652p.isAlive()) {
                this.f16652p = this.f16639b.getViewTreeObserver();
            }
            this.f16652p.removeGlobalOnLayoutListener(this.f16647k);
            this.f16652p = null;
        }
        this.f16639b.removeOnAttachStateChangeListener(this.f16648l);
        if (this.f16649m != null) {
            this.f16649m.onDismiss();
        }
    }

    public final void mo49a(boolean z) {
        this.f16654r = false;
        if (this.f16642f) {
            this.f16642f.notifyDataSetChanged();
        }
    }

    public final void mo48a(Callback callback) {
        this.f16651o = callback;
    }

    public final boolean mo52a(SubMenuBuilder subMenuBuilder) {
        if (subMenuBuilder.hasVisibleItems()) {
            boolean z;
            MenuPopupHelper menuPopupHelper = new MenuPopupHelper(this.f16640c, subMenuBuilder, this.f16639b, this.f16643g, this.f16645i, this.f16646j);
            menuPopupHelper.m1716a(this.f16651o);
            menuPopupHelper.m1717a(MenuPopup.m10499b((MenuBuilder) subMenuBuilder));
            menuPopupHelper.f2037b = this.f16656t;
            menuPopupHelper.f2038c = this.f16649m;
            this.f16649m = null;
            this.f16641d.close(false);
            int i = this.f16638a.f12013g;
            int c = this.f16638a.m10742c();
            if (!menuPopupHelper.m1722f()) {
                if (menuPopupHelper.f2036a == null) {
                    z = false;
                    if (z) {
                        if (this.f16651o != null) {
                            this.f16651o.mo429a(subMenuBuilder);
                        }
                        return true;
                    }
                }
                menuPopupHelper.m1715a(i, c, true, true);
            }
            z = true;
            if (z) {
                if (this.f16651o != null) {
                    this.f16651o.mo429a(subMenuBuilder);
                }
                return true;
            }
        }
        return false;
    }

    public final void mo47a(MenuBuilder menuBuilder, boolean z) {
        if (menuBuilder == this.f16641d) {
            mo654e();
            if (this.f16651o != null) {
                this.f16651o.mo428a(menuBuilder, z);
            }
        }
    }

    public final void mo3202a(View view) {
        this.f16650n = view;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return null;
        }
        mo654e();
        return true;
    }

    public final void mo3203a(OnDismissListener onDismissListener) {
        this.f16649m = onDismissListener;
    }

    public final ListView mo656g() {
        return this.f16638a.f12011e;
    }

    public final void mo3204b(int i) {
        this.f16638a.f12013g = i;
    }

    public final void mo3206c(int i) {
        this.f16638a.m10736a(i);
    }

    public final void mo3207c(boolean z) {
        this.f16657u = z;
    }

    public final void mo653d() {
        boolean z = true;
        if (!mo655f()) {
            if (!this.f16653q) {
                if (this.f16650n != null) {
                    this.f16639b = this.f16650n;
                    this.f16638a.m10739a((OnDismissListener) this);
                    this.f16638a.f12020n = this;
                    this.f16638a.m10740b();
                    View view = this.f16639b;
                    boolean z2 = this.f16652p == null;
                    this.f16652p = view.getViewTreeObserver();
                    if (z2) {
                        this.f16652p.addOnGlobalLayoutListener(this.f16647k);
                    }
                    view.addOnAttachStateChangeListener(this.f16648l);
                    this.f16638a.f12019m = view;
                    this.f16638a.f12016j = this.f16656t;
                    if (!this.f16654r) {
                        this.f16655s = MenuPopup.m10497a(this.f16642f, null, this.f16640c, this.f16644h);
                        this.f16654r = true;
                    }
                    this.f16638a.m10741b(this.f16655s);
                    this.f16638a.m10747h();
                    this.f16638a.f12023q = this.f11804e;
                    this.f16638a.mo653d();
                    ViewGroup viewGroup = this.f16638a.f12011e;
                    viewGroup.setOnKeyListener(this);
                    if (this.f16657u && this.f16641d.getHeaderTitle() != null) {
                        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f16640c).inflate(C0164R.layout.abc_popup_menu_header_item_layout, viewGroup, false);
                        TextView textView = (TextView) frameLayout.findViewById(16908310);
                        if (textView != null) {
                            textView.setText(this.f16641d.getHeaderTitle());
                        }
                        frameLayout.setEnabled(false);
                        viewGroup.addHeaderView(frameLayout, null, false);
                    }
                    this.f16638a.mo3229a(this.f16642f);
                    this.f16638a.mo653d();
                }
            }
            z = false;
        }
        if (!z) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }
}
