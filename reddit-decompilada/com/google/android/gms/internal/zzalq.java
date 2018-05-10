package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

@zzzv
abstract class zzalq {
    private final WeakReference<View> f6518a;

    public zzalq(View view) {
        this.f6518a = new WeakReference(view);
    }

    private final ViewTreeObserver m5400c() {
        View view = (View) this.f6518a.get();
        if (view == null) {
            return null;
        }
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        return (viewTreeObserver == null || !viewTreeObserver.isAlive()) ? null : viewTreeObserver;
    }

    public final void m5401a() {
        ViewTreeObserver c = m5400c();
        if (c != null) {
            mo1738a(c);
        }
    }

    protected abstract void mo1738a(ViewTreeObserver viewTreeObserver);

    public final void m5403b() {
        ViewTreeObserver c = m5400c();
        if (c != null) {
            mo1739b(c);
        }
    }

    protected abstract void mo1739b(ViewTreeObserver viewTreeObserver);
}
