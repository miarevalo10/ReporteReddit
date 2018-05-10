package com.squareup.picasso;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

class DeferredRequestCreator implements OnPreDrawListener {
    final RequestCreator f23753a;
    final WeakReference<ImageView> f23754b;
    Callback f23755c;

    DeferredRequestCreator(RequestCreator requestCreator, ImageView imageView, Callback callback) {
        this.f23753a = requestCreator;
        this.f23754b = new WeakReference(imageView);
        this.f23755c = callback;
        imageView.getViewTreeObserver().addOnPreDrawListener(this);
    }

    public boolean onPreDraw() {
        ImageView imageView = (ImageView) this.f23754b.get();
        if (imageView == null) {
            return true;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        int width = imageView.getWidth();
        int height = imageView.getHeight();
        if (width > 0) {
            if (height > 0) {
                viewTreeObserver.removeOnPreDrawListener(this);
                RequestCreator requestCreator = this.f23753a;
                requestCreator.f23871c = false;
                requestCreator.f23870b.m25785a(width, height);
                requestCreator.m25790a(imageView, this.f23755c);
                return true;
            }
        }
        return true;
    }
}
