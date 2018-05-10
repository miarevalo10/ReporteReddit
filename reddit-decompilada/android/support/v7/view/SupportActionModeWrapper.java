package android.support.v7.view;

import android.content.Context;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.util.SimpleArrayMap;
import android.support.v7.view.ActionMode.Callback;
import android.support.v7.view.menu.MenuWrapperFactory;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

public class SupportActionModeWrapper extends ActionMode {
    final Context f1967a;
    final ActionMode f1968b;

    public static class CallbackWrapper implements Callback {
        final ActionMode.Callback f11690a;
        final Context f11691b;
        final ArrayList<SupportActionModeWrapper> f11692c = new ArrayList();
        final SimpleArrayMap<Menu, Menu> f11693d = new SimpleArrayMap();

        public CallbackWrapper(Context context, ActionMode.Callback callback) {
            this.f11691b = context;
            this.f11690a = callback;
        }

        public final boolean mo431a(ActionMode actionMode, Menu menu) {
            return this.f11690a.onCreateActionMode(m10424b(actionMode), m10420a(menu));
        }

        public final boolean mo433b(ActionMode actionMode, Menu menu) {
            return this.f11690a.onPrepareActionMode(m10424b(actionMode), m10420a(menu));
        }

        public final boolean mo432a(ActionMode actionMode, MenuItem menuItem) {
            return this.f11690a.onActionItemClicked(m10424b(actionMode), MenuWrapperFactory.m1740a(this.f11691b, (SupportMenuItem) menuItem));
        }

        public final void mo430a(ActionMode actionMode) {
            this.f11690a.onDestroyActionMode(m10424b(actionMode));
        }

        private Menu m10420a(Menu menu) {
            Menu menu2 = (Menu) this.f11693d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            menu2 = MenuWrapperFactory.m1739a(this.f11691b, (SupportMenu) menu);
            this.f11693d.put(menu, menu2);
            return menu2;
        }

        public final ActionMode m10424b(ActionMode actionMode) {
            int size = this.f11692c.size();
            for (int i = 0; i < size; i++) {
                SupportActionModeWrapper supportActionModeWrapper = (SupportActionModeWrapper) this.f11692c.get(i);
                if (supportActionModeWrapper != null && supportActionModeWrapper.f1968b == actionMode) {
                    return supportActionModeWrapper;
                }
            }
            ActionMode supportActionModeWrapper2 = new SupportActionModeWrapper(this.f11691b, actionMode);
            this.f11692c.add(supportActionModeWrapper2);
            return supportActionModeWrapper2;
        }
    }

    public SupportActionModeWrapper(Context context, ActionMode actionMode) {
        this.f1967a = context;
        this.f1968b = actionMode;
    }

    public Object getTag() {
        return this.f1968b.f1960c;
    }

    public void setTag(Object obj) {
        this.f1968b.f1960c = obj;
    }

    public void setTitle(CharSequence charSequence) {
        this.f1968b.mo468b(charSequence);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1968b.mo464a(charSequence);
    }

    public void invalidate() {
        this.f1968b.mo470d();
    }

    public void finish() {
        this.f1968b.mo469c();
    }

    public Menu getMenu() {
        return MenuWrapperFactory.m1739a(this.f1967a, (SupportMenu) this.f1968b.mo466b());
    }

    public CharSequence getTitle() {
        return this.f1968b.mo471f();
    }

    public void setTitle(int i) {
        this.f1968b.mo462a(i);
    }

    public CharSequence getSubtitle() {
        return this.f1968b.mo472g();
    }

    public void setSubtitle(int i) {
        this.f1968b.mo467b(i);
    }

    public View getCustomView() {
        return this.f1968b.mo474i();
    }

    public void setCustomView(View view) {
        this.f1968b.mo463a(view);
    }

    public MenuInflater getMenuInflater() {
        return this.f1968b.mo461a();
    }

    public boolean getTitleOptionalHint() {
        return this.f1968b.f1961d;
    }

    public void setTitleOptionalHint(boolean z) {
        this.f1968b.mo465a(z);
    }

    public boolean isTitleOptional() {
        return this.f1968b.mo473h();
    }
}
