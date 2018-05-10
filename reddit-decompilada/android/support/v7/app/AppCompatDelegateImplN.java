package android.support.v7.app;

import android.content.Context;
import android.support.annotation.RequiresApi;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.Window;
import android.view.Window.Callback;
import java.util.List;

@RequiresApi(24)
class AppCompatDelegateImplN extends AppCompatDelegateImplV23 {

    class AppCompatWindowCallbackN extends AppCompatWindowCallbackV23 {
        final /* synthetic */ AppCompatDelegateImplN f19468b;

        AppCompatWindowCallbackN(AppCompatDelegateImplN appCompatDelegateImplN, Callback callback) {
            this.f19468b = appCompatDelegateImplN;
            super(appCompatDelegateImplN, callback);
        }

        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            PanelFeatureState h = this.f19468b.m16756h(0);
            if (h == null || h.menu == null) {
                super.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                super.onProvideKeyboardShortcuts(list, h.menu, i);
            }
        }
    }

    AppCompatDelegateImplN(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
    }

    final Callback mo4224a(Callback callback) {
        return new AppCompatWindowCallbackN(this, callback);
    }
}
