package io.branch.referral;

import android.net.ConnectivityManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;

class DeviceInfo {
    private static DeviceInfo f24624p;
    final String f24625a;
    final boolean f24626b;
    final String f24627c;
    final String f24628d;
    final int f24629e;
    final int f24630f;
    final int f24631g;
    final boolean f24632h;
    final String f24633i;
    final String f24634j;
    final int f24635k;
    final String f24636l;
    final String f24637m;
    final String f24638n;
    private final String f24639o;

    public static DeviceInfo m26139a(boolean z, SystemObserver systemObserver, boolean z2) {
        if (f24624p == null) {
            f24624p = new DeviceInfo(z, systemObserver, z2);
        }
        return f24624p;
    }

    public static DeviceInfo m26138a() {
        return f24624p;
    }

    private DeviceInfo(boolean z, SystemObserver systemObserver, boolean z2) {
        if (z2) {
            this.f24625a = systemObserver.m26216a(true);
        } else {
            this.f24625a = systemObserver.m26216a(z);
        }
        this.f24626b = systemObserver.f24674d;
        this.f24627c = SystemObserver.m26206c();
        this.f24628d = SystemObserver.m26207d();
        z = new DisplayMetrics();
        ((WindowManager) systemObserver.f24673c.getSystemService("window")).getDefaultDisplay().getMetrics(z);
        this.f24629e = z.densityDpi;
        this.f24630f = z.heightPixels;
        this.f24631g = z.widthPixels;
        z2 = false;
        if (!systemObserver.f24673c.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE")) {
            z = ((ConnectivityManager) systemObserver.f24673c.getSystemService("connectivity")).getNetworkInfo(1);
            if (z && z.isConnected()) {
                z2 = true;
            }
        }
        this.f24632h = z2;
        this.f24633i = SystemObserver.m26212j();
        this.f24634j = SystemObserver.m26210g();
        this.f24635k = SystemObserver.m26211h();
        this.f24639o = systemObserver.m26214a();
        this.f24636l = systemObserver.m26217b();
        this.f24637m = SystemObserver.m26208e();
        this.f24638n = SystemObserver.m26209f();
    }

    public final String m26140b() {
        return this.f24625a.equals("bnc_no_value") ? null : this.f24625a;
    }
}
