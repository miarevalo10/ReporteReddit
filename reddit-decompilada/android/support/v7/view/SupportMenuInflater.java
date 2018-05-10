package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff.Mode;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.appcompat.C0164R;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuItemWrapperICS;
import android.support.v7.widget.DrawableUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class SupportMenuInflater extends MenuInflater {
    static final Class<?>[] f2004a;
    static final Class<?>[] f2005b;
    final Object[] f2006c;
    final Object[] f2007d = this.f2006c;
    Context f2008e;
    Object f2009f;

    private static class InflatedOnMenuItemClickListener implements OnMenuItemClickListener {
        private static final Class<?>[] f1969a = new Class[]{MenuItem.class};
        private Object f1970b;
        private Method f1971c;

        public InflatedOnMenuItemClickListener(Object obj, String str) {
            this.f1970b = obj;
            obj = obj.getClass();
            try {
                this.f1971c = obj.getMethod(str, f1969a);
            } catch (Throwable e) {
                StringBuilder stringBuilder = new StringBuilder("Couldn't resolve menu item onClick handler ");
                stringBuilder.append(str);
                stringBuilder.append(" in class ");
                stringBuilder.append(obj.getName());
                InflateException inflateException = new InflateException(stringBuilder.toString());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f1971c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f1971c.invoke(this.f1970b, new Object[]{menuItem})).booleanValue();
                }
                this.f1971c.invoke(this.f1970b, new Object[]{menuItem});
                return true;
            } catch (MenuItem menuItem2) {
                throw new RuntimeException(menuItem2);
            }
        }
    }

    private class MenuState {
        ActionProvider f1972A;
        CharSequence f1973B;
        CharSequence f1974C;
        ColorStateList f1975D = null;
        Mode f1976E = null;
        final /* synthetic */ SupportMenuInflater f1977F;
        Menu f1978a;
        int f1979b;
        int f1980c;
        int f1981d;
        int f1982e;
        boolean f1983f;
        boolean f1984g;
        boolean f1985h;
        int f1986i;
        int f1987j;
        CharSequence f1988k;
        CharSequence f1989l;
        int f1990m;
        char f1991n;
        int f1992o;
        char f1993p;
        int f1994q;
        int f1995r;
        boolean f1996s;
        boolean f1997t;
        boolean f1998u;
        int f1999v;
        int f2000w;
        String f2001x;
        String f2002y;
        String f2003z;

        public MenuState(SupportMenuInflater supportMenuInflater, Menu menu) {
            this.f1977F = supportMenuInflater;
            this.f1978a = menu;
            m1695a();
        }

        public final void m1695a() {
            this.f1979b = 0;
            this.f1980c = 0;
            this.f1981d = 0;
            this.f1982e = 0;
            this.f1983f = true;
            this.f1984g = true;
        }

        static char m1693a(String str) {
            return str == null ? '\u0000' : str.charAt(0);
        }

        final void m1696a(MenuItem menuItem) {
            int i = 0;
            menuItem.setChecked(this.f1996s).setVisible(this.f1997t).setEnabled(this.f1998u).setCheckable(this.f1995r > 0).setTitleCondensed(this.f1989l).setIcon(this.f1990m);
            if (this.f1999v >= 0) {
                menuItem.setShowAsAction(this.f1999v);
            }
            if (this.f2003z != null) {
                if (this.f1977F.f2008e.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                SupportMenuInflater supportMenuInflater = this.f1977F;
                if (supportMenuInflater.f2009f == null) {
                    supportMenuInflater.f2009f = SupportMenuInflater.m1698a(supportMenuInflater.f2008e);
                }
                menuItem.setOnMenuItemClickListener(new InflatedOnMenuItemClickListener(supportMenuInflater.f2009f, this.f2003z));
            }
            if (this.f1995r >= 2) {
                if (menuItem instanceof MenuItemImpl) {
                    ((MenuItemImpl) menuItem).m10479a(true);
                } else if (menuItem instanceof MenuItemWrapperICS) {
                    MenuItemWrapperICS menuItemWrapperICS = (MenuItemWrapperICS) menuItem;
                    try {
                        if (menuItemWrapperICS.f16635e == null) {
                            menuItemWrapperICS.f16635e = ((SupportMenuItem) menuItemWrapperICS.d).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
                        }
                        menuItemWrapperICS.f16635e.invoke(menuItemWrapperICS.d, new Object[]{Boolean.valueOf(true)});
                    } catch (Throwable e) {
                        Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
                    }
                }
            }
            if (this.f2001x != null) {
                menuItem.setActionView((View) m1694a(this.f2001x, SupportMenuInflater.f2004a, this.f1977F.f2006c));
                i = 1;
            }
            if (this.f2000w > 0) {
                if (i == 0) {
                    menuItem.setActionView(this.f2000w);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            if (this.f1972A != null) {
                MenuItemCompat.m1112a(menuItem, this.f1972A);
            }
            MenuItemCompat.m1117a(menuItem, this.f1973B);
            MenuItemCompat.m1119b(menuItem, this.f1974C);
            MenuItemCompat.m1118b(menuItem, this.f1991n, this.f1992o);
            MenuItemCompat.m1114a(menuItem, this.f1993p, this.f1994q);
            if (this.f1976E != null) {
                MenuItemCompat.m1116a(menuItem, this.f1976E);
            }
            if (this.f1975D != null) {
                MenuItemCompat.m1115a(menuItem, this.f1975D);
            }
        }

        public final SubMenu m1697b() {
            this.f1985h = true;
            SubMenu addSubMenu = this.f1978a.addSubMenu(this.f1979b, this.f1986i, this.f1987j, this.f1988k);
            m1696a(addSubMenu.getItem());
            return addSubMenu;
        }

        final <T> T m1694a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                clsArr = this.f1977F.f2008e.getClassLoader().loadClass(str).getConstructor(clsArr);
                clsArr.setAccessible(true);
                return clsArr.newInstance(objArr);
            } catch (Class<?>[] clsArr2) {
                StringBuilder stringBuilder = new StringBuilder("Cannot instantiate class: ");
                stringBuilder.append(str);
                Log.w("SupportMenuInflater", stringBuilder.toString(), clsArr2);
                return null;
            }
        }
    }

    static {
        Class[] clsArr = new Class[]{Context.class};
        f2004a = clsArr;
        f2005b = clsArr;
    }

    public SupportMenuInflater(Context context) {
        super(context);
        this.f2008e = context;
        this.f2006c = new Object[]{context};
    }

    public void inflate(int i, Menu menu) {
        if (menu instanceof SupportMenu) {
            XmlResourceParser xmlResourceParser = null;
            try {
                i = this.f2008e.getResources().getLayout(i);
                try {
                    m1699a(i, Xml.asAttributeSet(i), menu);
                    if (i != 0) {
                        i.close();
                        return;
                    }
                    return;
                } catch (XmlPullParserException e) {
                    menu = e;
                    Object obj = i;
                    throw new InflateException("Error inflating menu XML", menu);
                } catch (IOException e2) {
                    menu = e2;
                    xmlResourceParser = i;
                    throw new InflateException("Error inflating menu XML", menu);
                } catch (Throwable th) {
                    menu = th;
                    xmlResourceParser = i;
                    if (xmlResourceParser != null) {
                        xmlResourceParser.close();
                    }
                    throw menu;
                }
            } catch (XmlPullParserException e3) {
                menu = e3;
                throw new InflateException("Error inflating menu XML", menu);
            } catch (IOException e4) {
                menu = e4;
                throw new InflateException("Error inflating menu XML", menu);
            } catch (Throwable th2) {
                menu = th2;
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
                throw menu;
            }
        }
        super.inflate(i, menu);
    }

    private void m1699a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        MenuState menuState = new MenuState(this, menu);
        menu = xmlPullParser.getEventType();
        while (menu != 2) {
            menu = xmlPullParser.next();
            if (menu == 1) {
                break;
            }
        }
        menu = xmlPullParser.getName();
        if (menu.equals("menu")) {
            menu = xmlPullParser.next();
            int i = menu;
            Object obj = null;
            menu = null;
            Menu menu2 = menu;
            while (menu == null) {
                String name;
                switch (i) {
                    case 1:
                        throw new RuntimeException("Unexpected end of document");
                    case 2:
                        if (menu2 != null) {
                            break;
                        }
                        name = xmlPullParser.getName();
                        TypedArray obtainStyledAttributes;
                        if (!name.equals("group")) {
                            if (!name.equals("item")) {
                                if (!name.equals("menu")) {
                                    menu2 = true;
                                    obj = name;
                                    break;
                                }
                                m1699a(xmlPullParser, attributeSet, menuState.m1697b());
                                break;
                            }
                            obtainStyledAttributes = menuState.f1977F.f2008e.obtainStyledAttributes(attributeSet, C0164R.styleable.MenuItem);
                            menuState.f1986i = obtainStyledAttributes.getResourceId(C0164R.styleable.MenuItem_android_id, 0);
                            menuState.f1987j = (obtainStyledAttributes.getInt(C0164R.styleable.MenuItem_android_menuCategory, menuState.f1980c) & -65536) | (obtainStyledAttributes.getInt(C0164R.styleable.MenuItem_android_orderInCategory, menuState.f1981d) & 65535);
                            menuState.f1988k = obtainStyledAttributes.getText(C0164R.styleable.MenuItem_android_title);
                            menuState.f1989l = obtainStyledAttributes.getText(C0164R.styleable.MenuItem_android_titleCondensed);
                            menuState.f1990m = obtainStyledAttributes.getResourceId(C0164R.styleable.MenuItem_android_icon, 0);
                            menuState.f1991n = MenuState.m1693a(obtainStyledAttributes.getString(C0164R.styleable.MenuItem_android_alphabeticShortcut));
                            menuState.f1992o = obtainStyledAttributes.getInt(C0164R.styleable.MenuItem_alphabeticModifiers, 4096);
                            menuState.f1993p = MenuState.m1693a(obtainStyledAttributes.getString(C0164R.styleable.MenuItem_android_numericShortcut));
                            menuState.f1994q = obtainStyledAttributes.getInt(C0164R.styleable.MenuItem_numericModifiers, 4096);
                            if (obtainStyledAttributes.hasValue(C0164R.styleable.MenuItem_android_checkable)) {
                                menuState.f1995r = obtainStyledAttributes.getBoolean(C0164R.styleable.MenuItem_android_checkable, false);
                            } else {
                                menuState.f1995r = menuState.f1982e;
                            }
                            menuState.f1996s = obtainStyledAttributes.getBoolean(C0164R.styleable.MenuItem_android_checked, false);
                            menuState.f1997t = obtainStyledAttributes.getBoolean(C0164R.styleable.MenuItem_android_visible, menuState.f1983f);
                            menuState.f1998u = obtainStyledAttributes.getBoolean(C0164R.styleable.MenuItem_android_enabled, menuState.f1984g);
                            menuState.f1999v = obtainStyledAttributes.getInt(C0164R.styleable.MenuItem_showAsAction, -1);
                            menuState.f2003z = obtainStyledAttributes.getString(C0164R.styleable.MenuItem_android_onClick);
                            menuState.f2000w = obtainStyledAttributes.getResourceId(C0164R.styleable.MenuItem_actionLayout, 0);
                            menuState.f2001x = obtainStyledAttributes.getString(C0164R.styleable.MenuItem_actionViewClass);
                            menuState.f2002y = obtainStyledAttributes.getString(C0164R.styleable.MenuItem_actionProviderClass);
                            boolean z = menuState.f2002y != null;
                            if (z && menuState.f2000w == 0 && menuState.f2001x == null) {
                                menuState.f1972A = (ActionProvider) menuState.m1694a(menuState.f2002y, f2005b, menuState.f1977F.f2007d);
                            } else {
                                if (z) {
                                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                                }
                                menuState.f1972A = null;
                            }
                            menuState.f1973B = obtainStyledAttributes.getText(C0164R.styleable.MenuItem_contentDescription);
                            menuState.f1974C = obtainStyledAttributes.getText(C0164R.styleable.MenuItem_tooltipText);
                            if (obtainStyledAttributes.hasValue(C0164R.styleable.MenuItem_iconTintMode)) {
                                menuState.f1976E = DrawableUtils.m1957a(obtainStyledAttributes.getInt(C0164R.styleable.MenuItem_iconTintMode, -1), menuState.f1976E);
                            } else {
                                menuState.f1976E = null;
                            }
                            if (obtainStyledAttributes.hasValue(C0164R.styleable.MenuItem_iconTint)) {
                                menuState.f1975D = obtainStyledAttributes.getColorStateList(C0164R.styleable.MenuItem_iconTint);
                            } else {
                                menuState.f1975D = null;
                            }
                            obtainStyledAttributes.recycle();
                            menuState.f1985h = false;
                            break;
                        }
                        obtainStyledAttributes = menuState.f1977F.f2008e.obtainStyledAttributes(attributeSet, C0164R.styleable.MenuGroup);
                        menuState.f1979b = obtainStyledAttributes.getResourceId(C0164R.styleable.MenuGroup_android_id, 0);
                        menuState.f1980c = obtainStyledAttributes.getInt(C0164R.styleable.MenuGroup_android_menuCategory, 0);
                        menuState.f1981d = obtainStyledAttributes.getInt(C0164R.styleable.MenuGroup_android_orderInCategory, 0);
                        menuState.f1982e = obtainStyledAttributes.getInt(C0164R.styleable.MenuGroup_android_checkableBehavior, 0);
                        menuState.f1983f = obtainStyledAttributes.getBoolean(C0164R.styleable.MenuGroup_android_visible, true);
                        menuState.f1984g = obtainStyledAttributes.getBoolean(C0164R.styleable.MenuGroup_android_enabled, true);
                        obtainStyledAttributes.recycle();
                        break;
                        break;
                    case 3:
                        name = xmlPullParser.getName();
                        if (menu2 == null || !name.equals(r6)) {
                            if (!name.equals("group")) {
                                if (!name.equals("item")) {
                                    if (!name.equals("menu")) {
                                        break;
                                    }
                                    menu = 1;
                                    break;
                                } else if (!menuState.f1985h) {
                                    if (menuState.f1972A != null && menuState.f1972A.mo545e()) {
                                        menuState.m1697b();
                                        break;
                                    }
                                    menuState.f1985h = true;
                                    menuState.m1696a(menuState.f1978a.add(menuState.f1979b, menuState.f1986i, menuState.f1987j, menuState.f1988k));
                                    break;
                                } else {
                                    break;
                                }
                            }
                            menuState.m1695a();
                            break;
                        }
                        obj = null;
                        menu2 = false;
                        break;
                    default:
                        break;
                }
                i = xmlPullParser.next();
            }
            return;
        }
        attributeSet = new StringBuilder("Expecting menu, got ");
        attributeSet.append(menu);
        throw new RuntimeException(attributeSet.toString());
    }

    static Object m1698a(Object obj) {
        while (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) {
            obj = ((ContextWrapper) obj).getBaseContext();
        }
        return obj;
    }
}
