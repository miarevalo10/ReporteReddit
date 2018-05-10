package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import java.lang.ref.WeakReference;

@zzzv
final class zzalp extends zzalq implements OnScrollChangedListener {
    private final WeakReference<OnScrollChangedListener> f14147a;

    public zzalp(View view, OnScrollChangedListener onScrollChangedListener) {
        super(view);
        this.f14147a = new WeakReference(onScrollChangedListener);
    }

    protected final void mo1738a(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnScrollChangedListener(this);
    }

    protected final void mo1739b(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.removeOnScrollChangedListener(this);
    }

    public final void onScrollChanged() {
        OnScrollChangedListener onScrollChangedListener = (OnScrollChangedListener) this.f14147a.get();
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollChanged();
        } else {
            m5403b();
        }
    }
}
