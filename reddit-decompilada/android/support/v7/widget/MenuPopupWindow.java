package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v7.view.menu.ListMenuItemView;
import android.support.v7.view.menu.MenuAdapter;
import android.support.v7.view.menu.MenuBuilder;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import java.lang.reflect.Method;

public class MenuPopupWindow extends ListPopupWindow implements MenuItemHoverListener {
    public static Method f16713a;
    public MenuItemHoverListener f16714b;

    public static class MenuDropDownListView extends DropDownListView {
        final int f16709h;
        final int f16710i;
        private MenuItemHoverListener f16711j;
        private MenuItem f16712k;

        public final /* bridge */ /* synthetic */ boolean mo3247a(MotionEvent motionEvent, int i) {
            return super.mo3247a(motionEvent, i);
        }

        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        public MenuDropDownListView(Context context, boolean z) {
            super(context, z);
            context = context.getResources().getConfiguration();
            if (VERSION.SDK_INT < true || true != context.getLayoutDirection()) {
                this.f16709h = 22;
                this.f16710i = 21;
                return;
            }
            this.f16709h = 21;
            this.f16710i = 22;
        }

        public void setHoverListener(MenuItemHoverListener menuItemHoverListener) {
            this.f16711j = menuItemHoverListener;
        }

        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.f16709h) {
                if (!(listMenuItemView.isEnabled() == 0 || listMenuItemView.getItemData().hasSubMenu() == 0)) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i != this.f16710i) {
                return super.onKeyDown(i, keyEvent);
            } else {
                setSelection(-1);
                ((MenuAdapter) getAdapter()).f2030b.close(null);
                return true;
            }
        }

        public boolean onHoverEvent(MotionEvent motionEvent) {
            if (this.f16711j != null) {
                int headersCount;
                MenuAdapter menuAdapter;
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
                } else {
                    headersCount = 0;
                    menuAdapter = (MenuAdapter) adapter;
                }
                MenuItem menuItem = null;
                if (motionEvent.getAction() != 10) {
                    int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (pointToPosition != -1) {
                        pointToPosition -= headersCount;
                        if (pointToPosition >= 0 && pointToPosition < menuAdapter.getCount()) {
                            menuItem = menuAdapter.m1710a(pointToPosition);
                        }
                    }
                }
                MenuItem menuItem2 = this.f16712k;
                if (menuItem2 != menuItem) {
                    MenuBuilder menuBuilder = menuAdapter.f2030b;
                    if (menuItem2 != null) {
                        this.f16711j.mo534a(menuBuilder, menuItem2);
                    }
                    this.f16712k = menuItem;
                    if (menuItem != null) {
                        this.f16711j.mo535b(menuBuilder, menuItem);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }
    }

    static {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = android.widget.PopupWindow.class;	 Catch:{ NoSuchMethodException -> 0x0013 }
        r1 = "setTouchModal";	 Catch:{ NoSuchMethodException -> 0x0013 }
        r2 = 1;	 Catch:{ NoSuchMethodException -> 0x0013 }
        r2 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x0013 }
        r3 = 0;	 Catch:{ NoSuchMethodException -> 0x0013 }
        r4 = java.lang.Boolean.TYPE;	 Catch:{ NoSuchMethodException -> 0x0013 }
        r2[r3] = r4;	 Catch:{ NoSuchMethodException -> 0x0013 }
        r0 = r0.getDeclaredMethod(r1, r2);	 Catch:{ NoSuchMethodException -> 0x0013 }
        f16713a = r0;	 Catch:{ NoSuchMethodException -> 0x0013 }
        return;
    L_0x0013:
        r0 = "MenuPopupWindow";
        r1 = "Could not find method setTouchModal() on PopupWindow. Oh well.";
        android.util.Log.i(r0, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.MenuPopupWindow.<clinit>():void");
    }

    public MenuPopupWindow(Context context, int i, int i2) {
        super(context, null, i, i2);
    }

    final DropDownListView mo3252a(Context context, boolean z) {
        DropDownListView menuDropDownListView = new MenuDropDownListView(context, z);
        menuDropDownListView.setHoverListener(this);
        return menuDropDownListView;
    }

    public final void mo535b(MenuBuilder menuBuilder, MenuItem menuItem) {
        if (this.f16714b != null) {
            this.f16714b.mo535b(menuBuilder, menuItem);
        }
    }

    public final void mo534a(MenuBuilder menuBuilder, MenuItem menuItem) {
        if (this.f16714b != null) {
            this.f16714b.mo534a(menuBuilder, menuItem);
        }
    }
}
