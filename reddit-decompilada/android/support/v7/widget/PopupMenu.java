package android.support.v7.widget;

import android.content.Context;
import android.support.v7.appcompat.C0164R;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.view.menu.MenuPopupHelper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow.OnDismissListener;

public class PopupMenu {
    public final MenuBuilder f2342a;
    public final MenuPopupHelper f2343b;
    public OnMenuItemClickListener f2344c;
    private final Context f2345d;
    private final View f2346e;

    class C02112 implements OnDismissListener {
        final /* synthetic */ PopupMenu f2341a;

        public void onDismiss() {
        }

        C02112(PopupMenu popupMenu) {
            this.f2341a = popupMenu;
        }
    }

    public interface OnMenuItemClickListener {
        boolean m2006a(MenuItem menuItem);
    }

    class C10301 implements Callback {
        final /* synthetic */ PopupMenu f12034a;

        public final void mo107a(MenuBuilder menuBuilder) {
        }

        C10301(PopupMenu popupMenu) {
            this.f12034a = popupMenu;
        }

        public final boolean mo108a(MenuBuilder menuBuilder, MenuItem menuItem) {
            return this.f12034a.f2344c != null ? this.f12034a.f2344c.m2006a(menuItem) : null;
        }
    }

    public PopupMenu(Context context, View view) {
        this(context, view, (byte) 0);
    }

    private PopupMenu(Context context, View view, byte b) {
        this(context, view, C0164R.attr.popupMenuStyle);
    }

    private PopupMenu(Context context, View view, int i) {
        this.f2345d = context;
        this.f2346e = view;
        this.f2342a = new MenuBuilder(context);
        this.f2342a.setCallback(new C10301(this));
        this.f2343b = new MenuPopupHelper(context, this.f2342a, view, false, i, 0);
        this.f2343b.f2037b = null;
        this.f2343b.f2038c = new C02112(this);
    }

    public final Menu m2007a() {
        return this.f2342a;
    }

    public final void m2010b() {
        this.f2343b.m1714a();
    }

    public final void m2009a(OnMenuItemClickListener onMenuItemClickListener) {
        this.f2344c = onMenuItemClickListener;
    }

    public final void m2008a(int i) {
        new SupportMenuInflater(this.f2345d).inflate(i, this.f2342a);
    }
}
