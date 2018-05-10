package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresApi;
import android.support.v4.internal.view.SupportMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;

@RequiresApi(14)
class MenuWrapperICS extends BaseMenuWrapper<SupportMenu> implements Menu {
    MenuWrapperICS(Context context, SupportMenu supportMenu) {
        super(context, supportMenu);
    }

    public MenuItem add(CharSequence charSequence) {
        return m10447a((MenuItem) ((SupportMenu) this.d).add(charSequence));
    }

    public MenuItem add(int i) {
        return m10447a((MenuItem) ((SupportMenu) this.d).add(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m10447a((MenuItem) ((SupportMenu) this.d).add(i, i2, i3, charSequence));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return m10447a((MenuItem) ((SupportMenu) this.d).add(i, i2, i3, i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return m10448a((SubMenu) ((SupportMenu) this.d).addSubMenu(charSequence));
    }

    public SubMenu addSubMenu(int i) {
        return m10448a((SubMenu) ((SupportMenu) this.d).addSubMenu(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return m10448a((SubMenu) ((SupportMenu) this.d).addSubMenu(i, i2, i3, charSequence));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return m10448a((SubMenu) ((SupportMenu) this.d).addSubMenu(i, i2, i3, i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuWrapperICS menuWrapperICS = this;
        MenuItem[] menuItemArr2 = menuItemArr;
        MenuItem[] menuItemArr3 = menuItemArr2 != null ? new MenuItem[menuItemArr2.length] : null;
        int addIntentOptions = ((SupportMenu) menuWrapperICS.d).addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr3);
        if (menuItemArr3 != null) {
            int length = menuItemArr3.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr2[i5] = m10447a(menuItemArr3[i5]);
            }
        }
        return addIntentOptions;
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ((SupportMenu) this.d).setGroupCheckable(i, z, z2);
    }

    public void setGroupVisible(int i, boolean z) {
        ((SupportMenu) this.d).setGroupVisible(i, z);
    }

    public void setGroupEnabled(int i, boolean z) {
        ((SupportMenu) this.d).setGroupEnabled(i, z);
    }

    public boolean hasVisibleItems() {
        return ((SupportMenu) this.d).hasVisibleItems();
    }

    public MenuItem findItem(int i) {
        return m10447a((MenuItem) ((SupportMenu) this.d).findItem(i));
    }

    public int size() {
        return ((SupportMenu) this.d).size();
    }

    public MenuItem getItem(int i) {
        return m10447a((MenuItem) ((SupportMenu) this.d).getItem(i));
    }

    public void close() {
        ((SupportMenu) this.d).close();
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return ((SupportMenu) this.d).performShortcut(i, keyEvent, i2);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return ((SupportMenu) this.d).isShortcutKey(i, keyEvent);
    }

    public boolean performIdentifierAction(int i, int i2) {
        return ((SupportMenu) this.d).performIdentifierAction(i, i2);
    }

    public void setQwertyMode(boolean z) {
        ((SupportMenu) this.d).setQwertyMode(z);
    }

    public void removeItem(int i) {
        if (this.f11728b != null) {
            Iterator it = this.f11728b.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getItemId()) {
                    it.remove();
                    break;
                }
            }
        }
        ((SupportMenu) this.d).removeItem(i);
    }

    public void removeGroup(int i) {
        if (this.f11728b != null) {
            Iterator it = this.f11728b.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getGroupId()) {
                    it.remove();
                }
            }
        }
        ((SupportMenu) this.d).removeGroup(i);
    }

    public void clear() {
        if (this.f11728b != null) {
            this.f11728b.clear();
        }
        if (this.f11729c != null) {
            this.f11729c.clear();
        }
        ((SupportMenu) this.d).clear();
    }
}
