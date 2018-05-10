package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;

public interface DecorToolbar {
    ViewPropertyAnimatorCompat mo735a(int i, long j);

    ViewGroup mo736a();

    void mo737a(int i);

    void mo738a(Drawable drawable);

    void mo739a(Callback callback, MenuBuilder.Callback callback2);

    void mo740a(ScrollingTabContainerView scrollingTabContainerView);

    void mo741a(Menu menu, Callback callback);

    void mo742a(Window.Callback callback);

    void mo743a(CharSequence charSequence);

    void mo744a(boolean z);

    Context mo745b();

    void mo746b(int i);

    void mo747b(Drawable drawable);

    void mo748b(CharSequence charSequence);

    void mo749c(int i);

    boolean mo750c();

    void mo751d();

    void mo752d(int i);

    CharSequence mo753e();

    void mo754f();

    void mo755g();

    boolean mo756h();

    boolean mo757i();

    boolean mo758j();

    boolean mo759k();

    boolean mo760l();

    void mo761m();

    void mo762n();

    int mo763o();

    int mo764p();

    void mo765q();

    int mo766r();

    Menu mo767s();
}
