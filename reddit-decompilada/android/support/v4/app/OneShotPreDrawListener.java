package android.support.v4.app;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class OneShotPreDrawListener implements OnAttachStateChangeListener, OnPreDrawListener {
    private final View f1172a;
    private ViewTreeObserver f1173b;
    private final Runnable f1174c;

    private OneShotPreDrawListener(View view, Runnable runnable) {
        this.f1172a = view;
        this.f1173b = view.getViewTreeObserver();
        this.f1174c = runnable;
    }

    public static OneShotPreDrawListener m700a(View view, Runnable runnable) {
        OneShotPreDrawListener oneShotPreDrawListener = new OneShotPreDrawListener(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(oneShotPreDrawListener);
        view.addOnAttachStateChangeListener(oneShotPreDrawListener);
        return oneShotPreDrawListener;
    }

    public boolean onPreDraw() {
        m701a();
        this.f1174c.run();
        return true;
    }

    private void m701a() {
        if (this.f1173b.isAlive()) {
            this.f1173b.removeOnPreDrawListener(this);
        } else {
            this.f1172a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f1172a.removeOnAttachStateChangeListener(this);
    }

    public void onViewAttachedToWindow(View view) {
        this.f1173b = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        m701a();
    }
}
