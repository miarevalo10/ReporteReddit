package rx.android.plugins;

import rx.Scheduler;
import rx.functions.Action0;

public class RxAndroidSchedulersHook {
    private static final RxAndroidSchedulersHook f41306a = new RxAndroidSchedulersHook();

    public static Action0 m43421a(Action0 action0) {
        return action0;
    }

    public static Scheduler m43422b() {
        return null;
    }

    public static RxAndroidSchedulersHook m43420a() {
        return f41306a;
    }
}
