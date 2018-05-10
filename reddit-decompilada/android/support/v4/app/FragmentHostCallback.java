package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.SimpleArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import java.io.PrintWriter;

public abstract class FragmentHostCallback<E> extends FragmentContainer {
    final Activity f11274b;
    final Context f11275c;
    final Handler f11276d;
    final int f11277e;
    final FragmentManagerImpl f11278f;
    SimpleArrayMap<String, LoaderManager> f11279g;
    boolean f11280h;
    LoaderManagerImpl f11281i;
    boolean f11282j;
    boolean f11283k;

    public View mo209a(int i) {
        return null;
    }

    void mo3120a(Fragment fragment) {
    }

    public void mo3123a(Fragment fragment, String[] strArr, int i) {
    }

    public void mo3124a(String str, PrintWriter printWriter, String[] strArr) {
    }

    public boolean mo210a() {
        return true;
    }

    public boolean mo3125a(String str) {
        return false;
    }

    public boolean mo3126b() {
        return true;
    }

    public void mo3128d() {
    }

    public boolean mo3129e() {
        return true;
    }

    public abstract E mo3131g();

    FragmentHostCallback(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.mHandler);
    }

    private FragmentHostCallback(Activity activity, Context context, Handler handler) {
        this.f11278f = new FragmentManagerImpl();
        this.f11274b = activity;
        this.f11275c = context;
        this.f11276d = handler;
        this.f11277e = null;
    }

    public LayoutInflater mo3127c() {
        return LayoutInflater.from(this.f11275c);
    }

    public void mo3121a(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.f11275c.startActivity(intent);
    }

    public void mo3122a(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws SendIntentException {
        int i5 = i;
        if (i5 != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        ActivityCompat.m9754a(this.f11274b, intentSender, i5, intent, i2, i3, i4, bundle);
    }

    public int mo3130f() {
        return this.f11277e;
    }

    final void m9807b(String str) {
        if (this.f11279g != null) {
            LoaderManagerImpl loaderManagerImpl = (LoaderManagerImpl) this.f11279g.get(str);
            if (loaderManagerImpl != null && !loaderManagerImpl.f11375f) {
                loaderManagerImpl.m9993g();
                this.f11279g.remove(str);
            }
        }
    }

    final LoaderManagerImpl m9798a(String str, boolean z, boolean z2) {
        if (this.f11279g == null) {
            this.f11279g = new SimpleArrayMap();
        }
        LoaderManagerImpl loaderManagerImpl = (LoaderManagerImpl) this.f11279g.get(str);
        if (loaderManagerImpl == null && z2) {
            loaderManagerImpl = new LoaderManagerImpl(str, this, z);
            this.f11279g.put(str, loaderManagerImpl);
            return loaderManagerImpl;
        } else if (!z || loaderManagerImpl == null || loaderManagerImpl.f11374e != null) {
            return loaderManagerImpl;
        } else {
            loaderManagerImpl.m9988b();
            return loaderManagerImpl;
        }
    }
}
