package android.support.v7.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public abstract class ActionMode {
    Object f1960c;
    boolean f1961d;

    public interface Callback {
        void mo430a(ActionMode actionMode);

        boolean mo431a(ActionMode actionMode, Menu menu);

        boolean mo432a(ActionMode actionMode, MenuItem menuItem);

        boolean mo433b(ActionMode actionMode, Menu menu);
    }

    public abstract MenuInflater mo461a();

    public abstract void mo462a(int i);

    public abstract void mo463a(View view);

    public abstract void mo464a(CharSequence charSequence);

    public abstract Menu mo466b();

    public abstract void mo467b(int i);

    public abstract void mo468b(CharSequence charSequence);

    public abstract void mo469c();

    public abstract void mo470d();

    public abstract CharSequence mo471f();

    public abstract CharSequence mo472g();

    public boolean mo473h() {
        return false;
    }

    public abstract View mo474i();

    public void mo465a(boolean z) {
        this.f1961d = z;
    }
}
