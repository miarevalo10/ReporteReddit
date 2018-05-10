package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory.Builder;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.Preconditions;

public final class DrawableTransitionOptions extends TransitionOptions<DrawableTransitionOptions, Drawable> {
    public static DrawableTransitionOptions m11650b() {
        TransitionOptions drawableTransitionOptions = new DrawableTransitionOptions();
        drawableTransitionOptions.f3254a = (TransitionFactory) Preconditions.m3217a(new Builder(100).m3197a());
        return (DrawableTransitionOptions) drawableTransitionOptions;
    }
}
