package android.support.v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.support.annotation.RequiresApi;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Window;

@RequiresApi(23)
class AppCompatDelegateImplV23 extends AppCompatDelegateImplV14 {
    private final UiModeManager f19794y;

    class AppCompatWindowCallbackV23 extends AppCompatWindowCallbackV14 {
        final /* synthetic */ AppCompatDelegateImplV23 f18854d;

        public ActionMode onWindowStartingActionMode(Callback callback) {
            return null;
        }

        AppCompatWindowCallbackV23(AppCompatDelegateImplV23 appCompatDelegateImplV23, Window.Callback callback) {
            this.f18854d = appCompatDelegateImplV23;
            super(appCompatDelegateImplV23, callback);
        }

        public ActionMode onWindowStartingActionMode(Callback callback, int i) {
            if (this.f18854d.f19470p) {
                if (i == 0) {
                    return m16719a(callback);
                }
            }
            return super.onWindowStartingActionMode(callback, i);
        }
    }

    AppCompatDelegateImplV23(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
        this.f19794y = (UiModeManager) context.getSystemService("uimode");
    }

    Window.Callback mo4224a(Window.Callback callback) {
        return new AppCompatWindowCallbackV23(this, callback);
    }

    final int mo4225g(int i) {
        if (i == 0 && this.f19794y.getNightMode() == 0) {
            return -1;
        }
        return super.mo4225g(i);
    }
}
