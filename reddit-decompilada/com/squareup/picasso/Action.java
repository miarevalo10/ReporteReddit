package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.Picasso.LoadedFrom;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

abstract class Action<T> {
    final Picasso f23713a;
    final Request f23714b;
    final WeakReference<T> f23715c;
    final boolean f23716d;
    final int f23717e;
    final int f23718f;
    final int f23719g;
    final Drawable f23720h;
    final String f23721i;
    final Object f23722j;
    boolean f23723k;
    boolean f23724l;

    static class RequestWeakReference<M> extends WeakReference<M> {
        final Action f23712a;

        public RequestWeakReference(Action action, M m, ReferenceQueue<? super M> referenceQueue) {
            super(m, referenceQueue);
            this.f23712a = action;
        }
    }

    abstract void mo5453a();

    abstract void mo5454a(Bitmap bitmap, LoadedFrom loadedFrom);

    Action(Picasso picasso, T t, Request request, int i, int i2, int i3, Drawable drawable, String str, Object obj, boolean z) {
        this.f23713a = picasso;
        this.f23714b = request;
        if (t == null) {
            picasso = null;
        } else {
            picasso = new RequestWeakReference(this, t, picasso.f23837k);
        }
        this.f23715c = picasso;
        this.f23717e = i;
        this.f23718f = i2;
        this.f23716d = z;
        this.f23719g = i3;
        this.f23720h = drawable;
        this.f23721i = str;
        if (obj == null) {
            obj = this;
        }
        this.f23722j = obj;
    }

    void mo5455b() {
        this.f23724l = true;
    }

    final T m25743c() {
        return this.f23715c == null ? null : this.f23715c.get();
    }
}
