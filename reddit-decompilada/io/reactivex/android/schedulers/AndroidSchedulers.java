package io.reactivex.android.schedulers;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import java.util.concurrent.Callable;

public final class AndroidSchedulers {
    private static final Scheduler f25003a = RxAndroidPlugins.m26506a(new C21281());

    static class C21281 implements Callable<Scheduler> {
        C21281() {
        }

        public final /* bridge */ /* synthetic */ Object call() throws Exception {
            return MainHolder.f25002a;
        }
    }

    private static final class MainHolder {
        static final Scheduler f25002a = new HandlerScheduler(new Handler(Looper.getMainLooper()));
    }

    public static Scheduler m26509a() {
        return RxAndroidPlugins.m26505a(f25003a);
    }
}
