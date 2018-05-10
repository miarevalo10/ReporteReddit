package android.support.v7.view.menu;

import android.content.Context;
import android.os.Parcelable;

public interface MenuPresenter {

    public interface Callback {
        void mo428a(MenuBuilder menuBuilder, boolean z);

        boolean mo429a(MenuBuilder menuBuilder);
    }

    void mo45a(Context context, MenuBuilder menuBuilder);

    void mo46a(Parcelable parcelable);

    void mo47a(MenuBuilder menuBuilder, boolean z);

    void mo48a(Callback callback);

    void mo49a(boolean z);

    boolean mo50a();

    boolean mo51a(MenuItemImpl menuItemImpl);

    boolean mo52a(SubMenuBuilder subMenuBuilder);

    int mo53b();

    boolean mo54b(MenuItemImpl menuItemImpl);

    Parcelable mo55c();
}
