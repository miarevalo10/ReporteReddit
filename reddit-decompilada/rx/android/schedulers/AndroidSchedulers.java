package rx.android.schedulers;

import android.os.Looper;
import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;

public final class AndroidSchedulers {
    private static final AndroidSchedulers f41307a = new AndroidSchedulers();
    private final Scheduler f41308b = new LooperScheduler(Looper.getMainLooper());

    private AndroidSchedulers() {
        RxAndroidPlugins.m43418a().m43419b();
        RxAndroidSchedulersHook.m43422b();
    }

    public static Scheduler m43423a() {
        return f41307a.f41308b;
    }
}
