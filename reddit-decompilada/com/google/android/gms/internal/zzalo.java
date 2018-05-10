package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.google.android.gms.ads.internal.zzbs;
import java.lang.ref.WeakReference;

@zzzv
final class zzalo extends zzalq implements OnGlobalLayoutListener {
    private final WeakReference<OnGlobalLayoutListener> f14146a;

    public zzalo(View view, OnGlobalLayoutListener onGlobalLayoutListener) {
        super(view);
        this.f14146a = new WeakReference(onGlobalLayoutListener);
    }

    protected final void mo1738a(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnGlobalLayoutListener(this);
    }

    protected final void mo1739b(ViewTreeObserver viewTreeObserver) {
        zzbs.m4488g().mo4289a(viewTreeObserver, (OnGlobalLayoutListener) this);
    }

    public final void onGlobalLayout() {
        OnGlobalLayoutListener onGlobalLayoutListener = (OnGlobalLayoutListener) this.f14146a.get();
        if (onGlobalLayoutListener != null) {
            onGlobalLayoutListener.onGlobalLayout();
        } else {
            m5403b();
        }
    }
}
