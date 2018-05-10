package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public class StandaloneActionMode extends ActionMode implements Callback {
    private Context f11683a;
    private ActionBarContextView f11684b;
    private ActionMode.Callback f11685e;
    private WeakReference<View> f11686f;
    private boolean f11687g;
    private boolean f11688h;
    private MenuBuilder f11689i;

    public StandaloneActionMode(Context context, ActionBarContextView actionBarContextView, ActionMode.Callback callback, boolean z) {
        this.f11683a = context;
        this.f11684b = actionBarContextView;
        this.f11685e = callback;
        this.f11689i = new MenuBuilder(actionBarContextView.getContext()).setDefaultShowAsAction(1);
        this.f11689i.setCallback(this);
        this.f11688h = z;
    }

    public final void mo468b(CharSequence charSequence) {
        this.f11684b.setTitle(charSequence);
    }

    public final void mo464a(CharSequence charSequence) {
        this.f11684b.setSubtitle(charSequence);
    }

    public final void mo462a(int i) {
        mo468b(this.f11683a.getString(i));
    }

    public final void mo467b(int i) {
        mo464a(this.f11683a.getString(i));
    }

    public final void mo465a(boolean z) {
        super.mo465a(z);
        this.f11684b.setTitleOptional(z);
    }

    public final boolean mo473h() {
        return this.f11684b.f11809h;
    }

    public final void mo463a(View view) {
        this.f11684b.setCustomView(view);
        this.f11686f = view != null ? new WeakReference(view) : null;
    }

    public final void mo470d() {
        this.f11685e.mo433b(this, this.f11689i);
    }

    public final void mo469c() {
        if (!this.f11687g) {
            this.f11687g = true;
            this.f11684b.sendAccessibilityEvent(32);
            this.f11685e.mo430a(this);
        }
    }

    public final Menu mo466b() {
        return this.f11689i;
    }

    public final CharSequence mo471f() {
        return this.f11684b.getTitle();
    }

    public final CharSequence mo472g() {
        return this.f11684b.getSubtitle();
    }

    public final View mo474i() {
        return this.f11686f != null ? (View) this.f11686f.get() : null;
    }

    public final MenuInflater mo461a() {
        return new SupportMenuInflater(this.f11684b.getContext());
    }

    public final boolean mo108a(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.f11685e.mo432a((ActionMode) this, menuItem);
    }

    public final void mo107a(MenuBuilder menuBuilder) {
        mo470d();
        this.f11684b.mo549a();
    }
}
