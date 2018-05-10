package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

public abstract class AppCompatDelegate {
    static int f1803a = -1;
    private static boolean f1804b = false;

    public abstract ActionBar mo417a();

    public abstract <T extends View> T mo3164a(int i);

    public abstract void mo3165a(Configuration configuration);

    public abstract void mo3166a(Bundle bundle);

    public abstract void mo3167a(Toolbar toolbar);

    public abstract void mo3168a(View view);

    public abstract void mo3169a(View view, LayoutParams layoutParams);

    public abstract void mo418a(CharSequence charSequence);

    public abstract MenuInflater mo419b();

    public abstract void mo3172b(int i);

    public abstract void mo420b(Bundle bundle);

    public abstract void mo3173b(View view, LayoutParams layoutParams);

    public abstract void mo3175c();

    public abstract boolean mo3176c(int i);

    public abstract void mo421d();

    public abstract void mo422d(int i);

    public abstract void mo423e();

    public abstract void mo3178f();

    public abstract void mo3180g();

    public abstract void mo424h();

    public abstract void mo3181i();

    public abstract boolean mo425j();

    public static AppCompatDelegate m1523a(Activity activity, AppCompatCallback appCompatCallback) {
        return m1525a(activity, activity.getWindow(), appCompatCallback);
    }

    public static AppCompatDelegate m1524a(Dialog dialog, AppCompatCallback appCompatCallback) {
        return m1525a(dialog.getContext(), dialog.getWindow(), appCompatCallback);
    }

    private static AppCompatDelegate m1525a(Context context, Window window, AppCompatCallback appCompatCallback) {
        if (VERSION.SDK_INT >= 24) {
            return new AppCompatDelegateImplN(context, window, appCompatCallback);
        }
        if (VERSION.SDK_INT >= 23) {
            return new AppCompatDelegateImplV23(context, window, appCompatCallback);
        }
        if (VERSION.SDK_INT >= 14) {
            return new AppCompatDelegateImplV14(context, window, appCompatCallback);
        }
        if (VERSION.SDK_INT >= 11) {
            return new AppCompatDelegateImplV11(context, window, appCompatCallback);
        }
        return new AppCompatDelegateImplV9(context, window, appCompatCallback);
    }

    AppCompatDelegate() {
    }

    public static boolean m1526k() {
        return f1804b;
    }
}
