package com.bluelinelabs.conductor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import com.bluelinelabs.conductor.ControllerChangeHandler.ControllerChangeListener;
import com.bluelinelabs.conductor.internal.LifecycleHandler;
import com.bluelinelabs.conductor.internal.TransactionIndexer;
import java.util.ArrayList;
import java.util.List;

public class ActivityHostedRouter extends Router {
    private LifecycleHandler f12220a;
    private final TransactionIndexer f12221b = new TransactionIndexer();

    final Router mo844e() {
        return this;
    }

    public final void m11113a(LifecycleHandler lifecycleHandler, ViewGroup viewGroup) {
        if (this.f12220a != lifecycleHandler || this.g != viewGroup) {
            if (this.g != null && (this.g instanceof ControllerChangeListener)) {
                m2718b((ControllerChangeListener) this.g);
            }
            if (viewGroup instanceof ControllerChangeListener) {
                m2707a((ControllerChangeListener) viewGroup);
            }
            this.f12220a = lifecycleHandler;
            this.g = viewGroup;
            m2742q();
        }
    }

    public final void mo836a(Bundle bundle) {
        super.mo836a(bundle);
        bundle.putInt("TransactionIndexer.currentIndex", this.f12221b.f3176a);
    }

    public final void mo841b(Bundle bundle) {
        super.mo841b(bundle);
        this.f12221b.f3176a = bundle.getInt("TransactionIndexer.currentIndex");
    }

    public final Activity mo833a() {
        return this.f12220a != null ? this.f12220a.f3167a : null;
    }

    public final void mo834a(Activity activity) {
        super.mo834a(activity);
        this.f12220a = null;
    }

    public final void mo840b() {
        if (this.f12220a != null && this.f12220a.getFragmentManager() != null) {
            this.f12220a.getFragmentManager().invalidateOptionsMenu();
        }
    }

    final void mo835a(Intent intent) {
        this.f12220a.startActivity(intent);
    }

    final void mo838a(String str, Intent intent, int i) {
        LifecycleHandler lifecycleHandler = this.f12220a;
        lifecycleHandler.f3168b.put(i, str);
        lifecycleHandler.startActivityForResult(intent, i);
    }

    final void mo837a(String str) {
        LifecycleHandler lifecycleHandler = this.f12220a;
        for (int size = lifecycleHandler.f3168b.size() - 1; size >= 0; size--) {
            if (str.equals(lifecycleHandler.f3168b.get(lifecycleHandler.f3168b.keyAt(size)))) {
                lifecycleHandler.f3168b.removeAt(size);
            }
        }
    }

    final void mo839a(String str, String[] strArr, int i) {
        this.f12220a.m2761a(str, strArr, i);
    }

    final boolean mo842c() {
        return this.f12220a != null;
    }

    final List<Router> mo843d() {
        return new ArrayList(this.f12220a.f3169c.values());
    }

    final TransactionIndexer mo845f() {
        return this.f12221b;
    }

    public final void mo846g() {
        super.mo846g();
    }
}
