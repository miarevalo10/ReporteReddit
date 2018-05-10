package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.transition.Transition;

public interface Target<R> extends LifecycleListener {
    void mo3268a(Drawable drawable);

    void mo3269a(Request request);

    void mo3857a(SizeReadyCallback sizeReadyCallback);

    void mo3858a(R r, Transition<? super R> transition);

    void mo3270b(Drawable drawable);

    void mo3859b(SizeReadyCallback sizeReadyCallback);

    void mo3271c(Drawable drawable);

    Request mo3272d();
}
