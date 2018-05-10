package android.support.v4.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class ActionProvider {
    public SubUiVisibilityListener f1433a;
    public VisibilityListener f1434b;
    private final Context f1435c;

    public interface SubUiVisibilityListener {
        void mo3227b(boolean z);
    }

    public interface VisibilityListener {
        void mo541a();
    }

    public abstract View mo542a();

    public void mo543a(SubMenu subMenu) {
    }

    public boolean mo3211b() {
        return false;
    }

    public boolean mo3212c() {
        return true;
    }

    public boolean mo544d() {
        return false;
    }

    public boolean mo545e() {
        return false;
    }

    public ActionProvider(Context context) {
        this.f1435c = context;
    }

    public View mo3209a(MenuItem menuItem) {
        return mo542a();
    }

    public final void m1090a(boolean z) {
        if (this.f1433a != null) {
            this.f1433a.mo3227b(z);
        }
    }

    public void mo3210a(VisibilityListener visibilityListener) {
        if (this.f1434b != null) {
            StringBuilder stringBuilder = new StringBuilder("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
            stringBuilder.append(getClass().getSimpleName());
            stringBuilder.append(" instance while it is still in use somewhere else?");
            Log.w("ActionProvider(support)", stringBuilder.toString());
        }
        this.f1434b = visibilityListener;
    }
}
