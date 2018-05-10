package android.support.v7.view.menu;

import android.content.Context;
import android.support.annotation.RequiresApi;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

@RequiresApi(16)
class MenuItemWrapperJB extends MenuItemWrapperICS {

    class ActionProviderWrapperJB extends ActionProviderWrapper implements VisibilityListener {
        ActionProvider.VisibilityListener f16636e;
        final /* synthetic */ MenuItemWrapperJB f16637f;

        public ActionProviderWrapperJB(MenuItemWrapperJB menuItemWrapperJB, Context context, android.view.ActionProvider actionProvider) {
            this.f16637f = menuItemWrapperJB;
            super(menuItemWrapperJB, context, actionProvider);
        }

        public final View mo3209a(MenuItem menuItem) {
            return this.c.onCreateActionView(menuItem);
        }

        public final boolean mo3211b() {
            return this.c.overridesItemVisibility();
        }

        public final boolean mo3212c() {
            return this.c.isVisible();
        }

        public final void mo3210a(ActionProvider.VisibilityListener visibilityListener) {
            this.f16636e = visibilityListener;
            this.c.setVisibilityListener(this);
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            if (this.f16636e) {
                this.f16636e.mo541a();
            }
        }
    }

    MenuItemWrapperJB(Context context, SupportMenuItem supportMenuItem) {
        super(context, supportMenuItem);
    }

    final ActionProviderWrapper mo3851a(android.view.ActionProvider actionProvider) {
        return new ActionProviderWrapperJB(this, this.a, actionProvider);
    }
}
