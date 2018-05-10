package com.reddit.frontpage.widgets;

import android.view.View;
import android.view.ViewStub;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.getbase.floatingactionbutton.AddFloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.reddit.frontpage.C1761R;

public class FloatingActionsView_ViewBinding implements Unbinder {
    private FloatingActionsView f29448b;

    public FloatingActionsView_ViewBinding(FloatingActionsView floatingActionsView, View view) {
        this.f29448b = floatingActionsView;
        floatingActionsView.button = (FloatingActionButton) Utils.b(view, C1761R.id.floating_action_button, "field 'button'", FloatingActionButton.class);
        floatingActionsView.overlay = Utils.a(view, C1761R.id.transparent_overlay, "field 'overlay'");
        floatingActionsView.menuExpand = (AddFloatingActionButton) Utils.a(view, C1761R.id.fab_expand_menu_button, "field 'menuExpand'", AddFloatingActionButton.class);
        floatingActionsView.menu = (FloatingActionsMenu) Utils.a(view, C1761R.id.floating_action_menu, "field 'menu'", FloatingActionsMenu.class);
        floatingActionsView.menuSubmitImage = (FloatingActionButton) Utils.a(view, C1761R.id.post_image, "field 'menuSubmitImage'", FloatingActionButton.class);
        floatingActionsView.menuSubmitSelf = (FloatingActionButton) Utils.a(view, C1761R.id.post_self, "field 'menuSubmitSelf'", FloatingActionButton.class);
        floatingActionsView.menuSubmitLink = (FloatingActionButton) Utils.a(view, C1761R.id.post_link, "field 'menuSubmitLink'", FloatingActionButton.class);
        floatingActionsView.menuStub = (ViewStub) Utils.a(view, C1761R.id.menu_stub, "field 'menuStub'", ViewStub.class);
    }

    public final void m30481a() {
        FloatingActionsView floatingActionsView = this.f29448b;
        if (floatingActionsView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f29448b = null;
        floatingActionsView.button = null;
        floatingActionsView.overlay = null;
        floatingActionsView.menuExpand = null;
        floatingActionsView.menu = null;
        floatingActionsView.menuSubmitImage = null;
        floatingActionsView.menuSubmitSelf = null;
        floatingActionsView.menuSubmitLink = null;
        floatingActionsView.menuStub = null;
    }
}
