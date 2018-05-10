package android.support.v7.widget;

import android.support.v7.view.menu.MenuPresenter.Callback;
import android.view.Menu;
import android.view.Window;

public interface DecorContentParent {
    void mo556a(int i);

    void mo557a(Menu menu, Callback callback);

    boolean mo558b();

    boolean mo559c();

    boolean mo560d();

    boolean mo561e();

    boolean mo562f();

    void mo563g();

    void mo564h();

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);
}
