package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.support.v4.internal.view.SupportMenuItem;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public final class MenuItemCompat {
    static final MenuVersionImpl f1441a;

    interface MenuVersionImpl {
        void mo369a(MenuItem menuItem, char c, int i);

        void mo370a(MenuItem menuItem, ColorStateList colorStateList);

        void mo371a(MenuItem menuItem, Mode mode);

        void mo372a(MenuItem menuItem, CharSequence charSequence);

        void mo373b(MenuItem menuItem, char c, int i);

        void mo374b(MenuItem menuItem, CharSequence charSequence);
    }

    static class MenuItemCompatBaseImpl implements MenuVersionImpl {
        public void mo369a(MenuItem menuItem, char c, int i) {
        }

        public void mo370a(MenuItem menuItem, ColorStateList colorStateList) {
        }

        public void mo371a(MenuItem menuItem, Mode mode) {
        }

        public void mo372a(MenuItem menuItem, CharSequence charSequence) {
        }

        public void mo373b(MenuItem menuItem, char c, int i) {
        }

        public void mo374b(MenuItem menuItem, CharSequence charSequence) {
        }

        MenuItemCompatBaseImpl() {
        }
    }

    @RequiresApi(26)
    static class MenuItemCompatApi26Impl extends MenuItemCompatBaseImpl {
        MenuItemCompatApi26Impl() {
        }

        public final void mo372a(MenuItem menuItem, CharSequence charSequence) {
            menuItem.setContentDescription(charSequence);
        }

        public final void mo374b(MenuItem menuItem, CharSequence charSequence) {
            menuItem.setTooltipText(charSequence);
        }

        public final void mo369a(MenuItem menuItem, char c, int i) {
            menuItem.setAlphabeticShortcut(c, i);
        }

        public final void mo373b(MenuItem menuItem, char c, int i) {
            menuItem.setNumericShortcut(c, i);
        }

        public final void mo370a(MenuItem menuItem, ColorStateList colorStateList) {
            menuItem.setIconTintList(colorStateList);
        }

        public final void mo371a(MenuItem menuItem, Mode mode) {
            menuItem.setIconTintMode(mode);
        }
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            f1441a = new MenuItemCompatApi26Impl();
        } else {
            f1441a = new MenuItemCompatBaseImpl();
        }
    }

    @Deprecated
    public static View m1113a(MenuItem menuItem) {
        return menuItem.getActionView();
    }

    public static MenuItem m1112a(MenuItem menuItem, ActionProvider actionProvider) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).mo509a(actionProvider);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static void m1117a(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).mo510a(charSequence);
        } else {
            f1441a.mo372a(menuItem, charSequence);
        }
    }

    public static void m1119b(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).mo512b(charSequence);
        } else {
            f1441a.mo374b(menuItem, charSequence);
        }
    }

    public static void m1114a(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setNumericShortcut(c, i);
        } else {
            f1441a.mo373b(menuItem, c, i);
        }
    }

    public static void m1118b(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setAlphabeticShortcut(c, i);
        } else {
            f1441a.mo369a(menuItem, c, i);
        }
    }

    public static void m1115a(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setIconTintList(colorStateList);
        } else {
            f1441a.mo370a(menuItem, colorStateList);
        }
    }

    public static void m1116a(MenuItem menuItem, Mode mode) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setIconTintMode(mode);
        } else {
            f1441a.mo371a(menuItem, mode);
        }
    }
}
