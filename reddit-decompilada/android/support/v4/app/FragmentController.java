package android.support.v4.app;

public class FragmentController {
    final FragmentHostCallback<?> f980a;

    public static final FragmentController m549a(FragmentHostCallback<?> fragmentHostCallback) {
        return new FragmentController(fragmentHostCallback);
    }

    private FragmentController(FragmentHostCallback<?> fragmentHostCallback) {
        this.f980a = fragmentHostCallback;
    }

    public final Fragment m550a(String str) {
        return this.f980a.f11278f.m9899c(str);
    }

    public final void m551a() {
        this.f980a.f11278f.m9915k();
    }

    public final boolean m553b() {
        return this.f980a.f11278f.m9912i();
    }

    public final void m554c() {
        FragmentHostCallback fragmentHostCallback = this.f980a;
        if (!fragmentHostCallback.f11283k) {
            fragmentHostCallback.f11283k = true;
            if (fragmentHostCallback.f11281i != null) {
                fragmentHostCallback.f11281i.m9988b();
            } else if (!fragmentHostCallback.f11282j) {
                fragmentHostCallback.f11281i = fragmentHostCallback.m9798a("(root)", fragmentHostCallback.f11283k, false);
                if (!(fragmentHostCallback.f11281i == null || fragmentHostCallback.f11281i.f11374e)) {
                    fragmentHostCallback.f11281i.m9988b();
                }
            }
            fragmentHostCallback.f11282j = true;
        }
    }

    public final void m552a(boolean z) {
        FragmentHostCallback fragmentHostCallback = this.f980a;
        fragmentHostCallback.f11280h = z;
        if (fragmentHostCallback.f11281i != null && fragmentHostCallback.f11283k) {
            fragmentHostCallback.f11283k = false;
            if (z) {
                fragmentHostCallback.f11281i.m9990d();
                return;
            }
            fragmentHostCallback.f11281i.m9989c();
        }
    }
}
