package android.support.v7.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;

class MenuDialogHelper implements OnClickListener, OnDismissListener, OnKeyListener, Callback {
    MenuBuilder f11759a;
    AlertDialog f11760b;
    ListMenuPresenter f11761c;
    private Callback f11762d;

    public MenuDialogHelper(MenuBuilder menuBuilder) {
        this.f11759a = menuBuilder;
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                dialogInterface = this.f11760b.getWindow();
                if (dialogInterface != null) {
                    dialogInterface = dialogInterface.getDecorView();
                    if (dialogInterface != null) {
                        dialogInterface = dialogInterface.getKeyDispatcherState();
                        if (dialogInterface != null) {
                            dialogInterface.startTracking(keyEvent, this);
                            return true;
                        }
                    }
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
                Window window = this.f11760b.getWindow();
                if (window != null) {
                    View decorView = window.getDecorView();
                    if (decorView != null) {
                        DispatcherState keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null && keyDispatcherState.isTracking(keyEvent)) {
                            this.f11759a.close(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.f11759a.performShortcut(i, keyEvent, 0);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f11761c.mo47a(this.f11759a, true);
    }

    public final void mo428a(MenuBuilder menuBuilder, boolean z) {
        if ((z || menuBuilder == this.f11759a) && this.f11760b != null) {
            this.f11760b.dismiss();
        }
        if (this.f11762d != null) {
            this.f11762d.mo428a(menuBuilder, z);
        }
    }

    public final boolean mo429a(MenuBuilder menuBuilder) {
        return this.f11762d != null ? this.f11762d.mo429a(menuBuilder) : null;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f11759a.performItemAction((MenuItemImpl) this.f11761c.m10468d().getItem(i), 0);
    }
}
