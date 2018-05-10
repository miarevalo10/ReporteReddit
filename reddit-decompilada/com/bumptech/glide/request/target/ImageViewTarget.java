package com.bumptech.glide.request.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.request.transition.Transition.ViewAdapter;

public abstract class ImageViewTarget<Z> extends ViewTarget<ImageView, Z> implements ViewAdapter {
    private Animatable f19487c;

    protected abstract void mo4378a(Z z);

    public ImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    public final Drawable mo4233e() {
        return ((ImageView) this.a).getDrawable();
    }

    public final void mo4232d(Drawable drawable) {
        ((ImageView) this.a).setImageDrawable(drawable);
    }

    public final void mo3270b(Drawable drawable) {
        super.mo3270b(drawable);
        m20770b(null);
        mo4232d(drawable);
    }

    public final void mo3271c(Drawable drawable) {
        super.mo3271c(drawable);
        m20770b(null);
        mo4232d(drawable);
    }

    public final void mo3268a(Drawable drawable) {
        super.mo3268a(drawable);
        if (this.f19487c != null) {
            this.f19487c.stop();
        }
        m20770b(null);
        mo4232d(drawable);
    }

    public void mo3858a(Z z, Transition<? super Z> transition) {
        if (transition != null) {
            if (transition.mo1028a(z, this) != null) {
                m20771c((Object) z);
                return;
            }
        }
        m20770b((Object) z);
    }

    public final void mo871a() {
        if (this.f19487c != null) {
            this.f19487c.start();
        }
    }

    public final void mo872b() {
        if (this.f19487c != null) {
            this.f19487c.stop();
        }
    }

    private void m20770b(Z z) {
        mo4378a((Object) z);
        m20771c((Object) z);
    }

    private void m20771c(Z z) {
        if (z instanceof Animatable) {
            this.f19487c = (Animatable) z;
            this.f19487c.start();
            return;
        }
        this.f19487c = null;
    }
}
