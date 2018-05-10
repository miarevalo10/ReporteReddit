package rx.android.plugins;

import java.util.concurrent.atomic.AtomicReference;

public final class RxAndroidPlugins {
    private static final RxAndroidPlugins f41304a = new RxAndroidPlugins();
    private final AtomicReference<RxAndroidSchedulersHook> f41305b = new AtomicReference();

    public static RxAndroidPlugins m43418a() {
        return f41304a;
    }

    RxAndroidPlugins() {
    }

    public final RxAndroidSchedulersHook m43419b() {
        if (this.f41305b.get() == null) {
            this.f41305b.compareAndSet(null, RxAndroidSchedulersHook.m43420a());
        }
        return (RxAndroidSchedulersHook) this.f41305b.get();
    }
}
